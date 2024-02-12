package com.overazumov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import com.overazumov.fragments.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(layoutInflater)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(BUNDLE_KEY)
            binding.messageText.text = result
        }

        setFragmentResultListener(FragmentB.REQUEST_KEY) { _, bundle ->
            val result = bundle.getString(FragmentB.BUNDLE_KEY)
            binding.messageText.text = result
        }

        binding.buttonToD.setOnClickListener {
            parentFragmentManager.commit {
                add(R.id.fragmentContainerD, FragmentD.newInstance(), FragmentD.TAG)
                addToBackStack(TAG)
            }
        }

        binding.buttonToA.setOnClickListener {
            parentFragmentManager.popBackStack(FragmentA.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(BUNDLE_KEY, binding.messageText.text.toString())
    }

    companion object {
        const val TAG = "FragmentC"
        const val BUNDLE_KEY = "bundleKeyC"

        fun newInstance() = FragmentC()
    }
}