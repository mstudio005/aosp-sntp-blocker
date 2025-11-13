package com.android.server.sntpblocker;

import android.content.Context;
import android.util.Slog;

/**
 * Simple config store (skeleton). Actual implementation should persist config to
 * /data/system and handle user profiles.
 */
public class SntpConfigStore {
    private static final String TAG = "SntpConfigStore";
    public SntpConfigStore(Context ctx) {}

    public void saveConfig() {
        Slog.i(TAG, "saveConfig() called - implement persistence");
    }

    public void loadConfig() {
        Slog.i(TAG, "loadConfig() called - implement load");
    }
}
