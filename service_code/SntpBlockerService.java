package com.android.server.sntpblocker;

import android.content.Context;
import android.os.IBinder;
import android.util.Slog;
import com.android.server.SystemService;
import java.util.ArrayList;
import java.util.List;

/**
 * Minimal skeleton of SntpBlockerService.
 * This file is a starting point and requires integration into frameworks/base build files.
 */
public final class SntpBlockerService extends SystemService {
    private static final String TAG = "SntpBlockerService";
    private final Context mContext;
    private final List<String> mBlockedPackages = new ArrayList<>();
    private boolean mDnsLockEnabled = false;

    public SntpBlockerService(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void onStart() {
        Slog.i(TAG, "SntpBlockerService starting");
        publishBinderService("sntp_blocker", new BinderService());
    }

    private final class BinderService extends ISntpBlockerService.Stub {
        @Override
        public void setBlockedApps(List<String> packages) {
            synchronized (mBlockedPackages) {
                mBlockedPackages.clear();
                if (packages != null) mBlockedPackages.addAll(packages);
            }
        }

        @Override
        public List<String> getBlockedApps() {
            synchronized (mBlockedPackages) {
                return new ArrayList<>(mBlockedPackages);
            }
        }

        @Override
        public void enableDnsLock(boolean enable) {
            mDnsLockEnabled = enable;
            // For v1 we will not actively revert DNS programmatically.
        }

        @Override
        public boolean isDnsLockEnabled() {
            return mDnsLockEnabled;
        }

        @Override
        public boolean isPackageBlocked(String pkg) {
            synchronized (mBlockedPackages) {
                return mBlockedPackages.contains(pkg);
            }
        }
    }
}
