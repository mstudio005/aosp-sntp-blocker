# How to apply patches into AOSP

1. Sync your AOSP/Lineage source for the target branch:
   repo init -u https://android.googlesource.com/platform/manifest -b android-14.0.0_rX
   repo sync

2. Copy this repo into your build host (or clone it on the host).

3. Apply patches:
   cd $AOSP/frameworks/base
   git am /path/to/aosp-sntp-blocker/patches/frameworks_base/0001-add-sntp-blocker-service.patch

   cd $AOSP/packages/apps/Settings
   git am /path/to/aosp-sntp-blocker/patches/packages_apps_Settings/0001-add-sntp-blocker-settings.patch

   cd $AOSP/packages/apps/SystemUI
   git am /path/to/aosp-sntp-blocker/patches/packages_apps_SystemUI/0001-add-blockview-overlay.patch

4. Build (for emulator target):
   source build/envsetup.sh
   lunch aosp_x86_64-eng
   m -j$(nproc) 

5. Flash emulator or use the CI generated images.
