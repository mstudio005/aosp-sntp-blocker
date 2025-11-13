# Emulator build notes

- The GitHub Actions CI will produce a packaged emulator image (system.img etc).
- To use locally, you can push system.img to an emulator with:
  adb root
  adb remount
  adb push out/target/product/generic_x86_64/system.img /system
  adb reboot

- Alternatively, use Android Studio AVD and load the generated system images.
