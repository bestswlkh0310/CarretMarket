package com.example.carretmarket.features.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.carretmarket.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[SignInViewModel::class.java]
        binding.lifecycleOwner = this
        binding.signin = viewModel

        initSignIn()

        return binding.root
    }

    private fun initSignIn() {
        binding.btnLogin.setOnClickListener {
            viewModel.onClickLogin(requireActivity().applicationContext,
                binding.etInpId.text.toString(),
                binding.etInpPw.text.toString()
            )
        }
    }
}