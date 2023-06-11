package com.pmdm.u8.actividad4.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pmdm.u8.actividad4.R
import com.pmdm.u8.actividad4.databinding.ActivityMainBinding
import com.pmdm.u8.actividad4.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var callback: OnButtonClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnGmailPref.setOnClickListener { callback.onGmailPreferences() }
        binding.btnTelegramPref.setOnClickListener { callback.onTelegramPreferences() }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setOnClickListener(mListener: OnButtonClickListener){
        callback = mListener
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    interface OnButtonClickListener {
        fun onGmailPreferences()
        fun onTelegramPreferences()
    }
}