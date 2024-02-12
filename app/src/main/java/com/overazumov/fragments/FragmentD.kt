package com.overazumov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.overazumov.fragments.databinding.FragmentDBinding

class FragmentD : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDBinding.inflate(layoutInflater)

        binding.buttonToB.setOnClickListener {
            parentFragmentManager.popBackStack(FragmentB.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        return binding.root
    }

    companion object {
        const val TAG = "FragmentD"

        fun newInstance() = FragmentD()
    }
}