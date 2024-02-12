package com.overazumov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import com.overazumov.fragments.databinding.FragmentBBinding

class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBBinding.inflate(layoutInflater)

        binding.buttonToC.setOnClickListener {
            parentFragmentManager.commit {
                add(R.id.fragmentContainerC, FragmentC.newInstance(), FragmentC.TAG)
                addToBackStack(TAG)
            }
            setFragmentResult(REQUEST_KEY, bundleOf(BUNDLE_KEY to "Hello Fragment C"))
        }

        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    companion object {
        const val TAG = "FragmentB"
        const val REQUEST_KEY = "requestKeyB"
        const val BUNDLE_KEY = "bundleKeyB"

        fun newInstance() = FragmentB()
    }
}