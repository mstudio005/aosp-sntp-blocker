package com.android.server.sntpblocker;

/** AIDL interface for SntpBlockerService */
interface ISntpBlockerService {
    void setBlockedApps(in List<String> packages);
    List<String> getBlockedApps();
    void enableDnsLock(boolean enable);
    boolean isDnsLockEnabled();
    boolean isPackageBlocked(String pkg);
}
