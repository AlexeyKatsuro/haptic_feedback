# haptic_feedback (forked)

A haptic feedback plugin for Flutter that provides consistent cross-platform haptic experiences.  
This fork introduces a **custom Android implementation** based on the official [`HapticFeedbackConstants`](https://developer.android.com/reference/android/view/HapticFeedbackConstants) for more precise alignment with iOS haptic types.

📦 [Original Package on pub.dev](https://pub.dev/packages/haptic_feedback)

---

## 🚀 What's different in this fork?

This fork improves the **Android behavior** by explicitly mapping each iOS-style haptic type (`HapticsType`) to a corresponding constant from Android's `HapticFeedbackConstants`. The original package aimed to emulate iOS behavior, but this fork brings more accurate feedback by utilizing Android’s native constants directly.

### 🔁 Haptic Mapping Table

| **iOS (`HapticsType`)** | **Android (`HapticFeedbackConstants`)** | **Description** |
|-------------------------|-----------------------------------------|------------------|
| `success`               | `CONFIRM (16)`                         | Signals successful task completion. |
| `warning`               | `GESTURE_THRESHOLD_ACTIVATE (23)`      | Indicates a warning or attention is needed. |
| `error`                 | `REJECT (17)`                          | Signals failure or error. |
| `light`                 | `VIRTUAL_KEY (1)`                      | Light tap sensation. |
| `medium`                | `KEYBOARD_TAP (3)`                     | Medium-strength tap, similar to keyboard press. |
| `heavy`                 | `CONTEXT_CLICK (6)`                    | Heavy feedback, like a collision. |
| `rigid`                 | `SEGMENT_TICK (26)`                    | Crisp, hard impact feedback. |
| `soft`                  | `SEGMENT_FREQUENT_TICK (27)`           | Soft, subtle haptic feel. |
| `selection`             | `CLOCK_TICK (4)`                       | Discrete selection feedback. |

---

## Getting Started

### 1. Add the dependency

```yaml
dependencies:
  haptic_feedback:
    git:
      url: https://github.com/AlexeyKatsuro/haptic_feedback
      ref: v0.6.0
```

### 2. Use the plugin

```dart
await Haptics.success(); // or  await Haptics.vibrate(HapticsType.success)
await Haptics.warning();
await Haptics.error();

await Haptics.light();
await Haptics.medium();
await Haptics.heavy();

await Haptics.rigid();
await Haptics.soft();

await Haptics.selection();
```