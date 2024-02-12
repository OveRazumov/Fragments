package com.overazumov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.overazumov.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentABinding.inflate(layoutInflater)

        binding.buttonToB.setOnClickListener {
            parentFragmentManager.commit {
                add(R.id.fragmentContainerB, FragmentB.newInstance(), FragmentB.TAG)
                addToBackStack(TAG)
            }
        }

        return binding.root
    }

    companion object {
        const val TAG = "FragmentA"

        fun newInstance() = FragmentA()
    }
}