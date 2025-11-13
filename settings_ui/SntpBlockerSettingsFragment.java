package com.android.settings.sntpblocker;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import com.android.settings.R;

/**
 * Skeleton Settings fragment for SNTP BLOCKER.
 */
public class SntpBlockerSettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Load preferences from XML (to be created)
        setPreferencesFromResource(R.xml.sntp_blocker_settings, rootKey);
    }
}
