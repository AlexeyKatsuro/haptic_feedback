import 'package:haptic_feedback/haptic_feedback.dart';

import 'haptic_feedback_platform_interface.dart';
import 'is_platform_supported.dart';

/// A class that exposes the haptic feedback functionality.
class Haptics {
  const Haptics._();

  /// Checks if the device is capable of performing haptic feedback.
  ///
  /// - On iOS: Haptic feedback is available on iPhone 7 and later models.
  /// - On Android: Haptic feedback is generally available,
  /// but actual support can vary between devices and versions.
  static Future<bool> canVibrate() async {
    if (!isPlatformSupported) {
      return false;
    }

    return HapticFeedbackPlatform.instance.canVibrate();
  }

  /// Performs haptic feedback of [HapticsType] on the device.
  /// Performs nothing if the platform is not supported.
  static Future<void> vibrate(HapticsType type) async {
    if (!isPlatformSupported) {
      return;
    }

    return HapticFeedbackPlatform.instance.vibrate(type);
  }

  /// Indicates that a task or action has completed.
  static Future<void> success() async => vibrate(HapticsType.success);

  /// Indicates that a task or action has produced a warning of some kind.
  static Future<void> warning() async => vibrate(HapticsType.warning);

  /// Indicates that an error has occurred.
  static Future<void> error() async => vibrate(HapticsType.error);

  /// Indicates a collision between small or lightweight UI objects.
  static Future<void> light() async => vibrate(HapticsType.light);

  /// Indicates a collision between medium-sized or medium-weight UI objects.
  static Future<void> medium() async => vibrate(HapticsType.medium);

  /// Indicates a collision between large or heavyweight UI objects.
  static Future<void> heavy() async => vibrate(HapticsType.heavy);

  /// Indicates a collision between hard or inflexible UI objects.
  static Future<void> rigid() async => vibrate(HapticsType.rigid);

  /// Indicates a collision between soft or flexible UI objects.
  static Future<void> soft() async => vibrate(HapticsType.soft);

  /// Indicates that a UI element’s values are changing.
  static Future<void> selection() async => vibrate(HapticsType.selection);
}
