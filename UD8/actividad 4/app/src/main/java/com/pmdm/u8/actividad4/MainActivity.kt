package com.pmdm.u8.actividad4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pmdm.u8.actividad4.databinding.ActivityMainBinding
import com.pmdm.u8.actividad4.fragments.MainFragment
import com.pmdm.u8.actividad4.fragments.MainFragment.OnButtonClickListener
import com.pmdm.u8.actividad4.fragments.SettingsGmailFragment
import com.pmdm.u8.actividad4.fragments.SettingsTelegramFragment

class MainActivity : AppCompatActivity(), OnButtonClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        cambiarFragment(MainFragment.newInstance(), false)
    }

    override fun onAttachFragment(fragment: Fragment) {
        if (fragment is MainFragment) {
            fragment.setOnClickListener(this)
        }
    }

    private fun cambiarFragment(fragment: Fragment, addToBackStack: Boolean = true){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        if(addToBackStack)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onGmailPreferences() {
        cambiarFragment(SettingsGmailFragment.newInstance())
    }

    override fun onTelegramPreferences() {
        cambiarFragment(SettingsTelegramFragment.newInstance())
    }
}