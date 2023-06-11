package com.pmdm.u8.actividad4.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.pmdm.u8.actividad4.R

class SettingsGmailFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferencias_gmail, rootKey)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsGmailFragment()
    }
}