package com.example.carretmarket.features.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carretmarket.R
import com.example.carretmarket.databinding.FragmentOnBoardBinding
import com.example.carretmarket.features.auth.join.SignUpFragment
import com.example.carretmarket.features.auth.login.SignInFragment

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        binding.btnLogin.setOnClickListener {
            val signIn = SignInFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fl_start, signIn)
                ?.commit()
        }

        binding.btnSignup.setOnClickListener {
            val signUp = SignUpFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fl_start, signUp)
                ?.commit()
        }

        return binding.root
    }
}