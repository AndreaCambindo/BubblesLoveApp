package com.example.bubblesloveapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bubblesloveapp.databinding.FragmentForgotBinding
import com.example.bubblesloveapp.databinding.FragmentSignUpBinding

class ForgotFragment : Fragment() {

    private var _binding: FragmentForgotBinding? = null
    private val binding: FragmentForgotBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentForgotBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.fragmentForgotLabel2.setOnClickListener{
           findNavController().navigate(R.id.action_forgotFragment_to_signUpFragment)
        }
    }

}