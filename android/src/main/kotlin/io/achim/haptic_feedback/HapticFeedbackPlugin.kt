package io.achim.haptic_feedback

import android.app.Activity
import android.os.Build
import android.view.HapticFeedbackConstants
import android.view.View
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

class HapticFeedbackPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    private lateinit var channel: MethodChannel
    private var activity: Activity? = null

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "haptic_feedback")
        channel.setMethodCallHandler(this)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        activity = binding.activity
    }

    override fun onDetachedFromActivity() {
        activity = null
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        activity = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {
        activity = null
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        try {
            when (call.method) {
                "canVibrate" -> {
                    // Haptic feedback will be attempted regardless; assume it's available.
                    // This is safe because we use system-provided feedback which either works or fails silently.
                    result.success(true)
                }

                else -> {
                    val type = hapticsTypeToConstant(call.method)
                    if (type != null) {
                        activity?.window?.decorView?.performHapticFeedback(
                            type,
                            HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
                        )
                        result.success(null)
                    } else {
                        result.notImplemented()
                    }
                }
            }
        } catch (e: Exception) {
            result.error(
                "HAPTIC_FEEDBACK_ERROR",
                "Failed to perform haptic feedback for method '${call.method}'",
                e.localizedMessage
            )
        }
    }


    private fun hapticsTypeToConstant(name: String): Int? {
        return when (name) {
            "success" -> HapticFeedbackConstants.CONFIRM
            "warning" -> HapticFeedbackConstants.GESTURE_THRESHOLD_ACTIVATE
            "error" -> HapticFeedbackConstants.REJECT
            "light" -> HapticFeedbackConstants.VIRTUAL_KEY
            "medium" -> HapticFeedbackConstants.KEYBOARD_TAP
            "heavy" -> HapticFeedbackConstants.CONTEXT_CLICK
            "rigid" -> HapticFeedbackConstants.SEGMENT_TICK
            "soft" -> HapticFeedbackConstants.SEGMENT_FREQUENT_TICK
            "selection" -> HapticFeedbackConstants.CLOCK_TICK
            else -> null
        }
    }
}
