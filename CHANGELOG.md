## 0.6.0

* Complete rewrite of Android implementation to use native haptic constants via `HapticFeedbackConstants`, replacing custom vibration patterns.
* Implement `ActivityAware` to access the active `Activity` and properly invoke `performHapticFeedback`.
* `canVibrate()` now always returns `true`, reflecting the fact that native haptic feedback will either be ignored silently or handled by the system.
* Add shorthand methods for each haptic type:
    - `Haptics.success()`
    - `Haptics.warning()`
    - `Haptics.error()`
    - `Haptics.light()`
    - `Haptics.medium()`
    - `Haptics.heavy()`
    - `Haptics.rigid()`
    - `Haptics.soft()`
    - `Haptics.selection()`
      These are aliases for `Haptics.vibrate(HapticsType.X)` calls, providing a cleaner and more expressive API.
* Add try-catch handling in `onMethodCall` to ensure proper error forwarding via `result.error`.

## 0.5.1+1

* Add an article link about using the plugin to the readme. Thanks @kamranbekirovyz!

## 0.5.1

* Update podspec version.

## 0.5.0

* Early return if platform is not supported (instead of an exception). Supported are iOS an Android. Thanks @rizerco!
* Upgrade Android dependencies (Gradle, AGP, Java, Kotlin).
* Widen `flutter_lints` constraints.

## 0.4.2

* Update package description.

## 0.4.1

* Update example.

## 0.4.0

* `canVibrate()` is now a method.
* Catching of native errors on Android: You can call `vibrate()` without checking `canVibrate()` first.
* Improve docs.

## 0.3.3+1

* Fix typo in readme. Thanks @walid-ashik!

## 0.3.3

* Update podspec version.

## 0.3.2

* Maintenance release.
* Update `gradle`, `kotlin`, and `mockito`.

## 0.3.1

* Update podspec version.

## 0.3.0

* Update package identifier.

## 0.2.5

* Refactor example.

## 0.2.4

* Small refactoring.

## 0.2.3

* Check API level before calling `hasAmplitudeControl()`.

## 0.2.2

* Update version in `podspec`.

## 0.2.1

* Refactor Kotlin code.

## 0.2.0

* Improve docs.
* Add private constructor to `Haptics`.

## 0.1.1

* Improve docs.

## 0.1.0

* Format Swift code.

## 0.0.9

* Call fallback methods on iOS < 13 for `.rigid` and `.soft` haptics.

## 0.0.8

* Refactor `canVibrate` implementation for supporting lower iOS versions.

## 0.0.7

* Format native code.

## 0.0.6

* Refactor `canVibrate` method into a getter for improved readability and usage.

## 0.0.5

* Make methods static.

## 0.0.4

* Add `namespace` to build.gradle.
* Update `Kotlin` version of example.
* Upgrade `Gradle` version of example.
* Upgrade `Android Gradle Plugin` version of example.

## 0.0.3

* Fine-tune Android haptics.

## 0.0.2

* Update description.

## 0.0.1

* Initial release.
