# Testing Guide - v1

1. Start emulator with the built image.
2. Open Settings -> System -> SNTP BLOCKER.
3. Enable SNTP BLOCKER (toggle).
4. In Blocked Apps, choose an app (e.g., YouTube).
5. Launch the blocked app - you should see the Material dialog "This app is blocked by SNTP BLOCKER".
6. Try opening Settings -> Network -> Private DNS - the UI should be disabled/greyed out while SNTP BLOCKER is enabled.
7. To disable the feature, turn the main toggle off.
8. Collect logs if something breaks:
   adb logcat | grep SntpBlocker
   adb shell dumpsys sntpblocker   (dumpsys key implemented in service)
