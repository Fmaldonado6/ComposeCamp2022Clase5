package com.drongo.scanner.ui.activities.main.fragments.settings

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.drongo.scanner.BuildConfig
import com.drongo.scanner.R
import com.drongo.scanner.ui.utils.PreferencesKeys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreferencesFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        val pref = findPreference(PreferencesKeys.Version.key) as Preference?
        pref?.let {
            it.summary = BuildConfig.VERSION_NAME
        }

    }
}