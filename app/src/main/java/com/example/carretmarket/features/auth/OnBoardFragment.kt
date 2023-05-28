package com.example.carretmarket.features.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentOnBoardBinding
import com.example.carretmarket.features.auth.join.SignUpFragment
import com.example.carretmarket.features.auth.login.SignInFragment

class OnBoardFragment : BaseFragment<FragmentOnBoardBinding, OnBoardViewModel>() {
    override val viewModel: OnBoardViewModel by viewModels()
    override fun observerViewModel() {
        mBinding.btnLogin.setOnClickListener {
            val signIn = SignInFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fl_start, signIn)
                ?.commit()
        }

        mBinding.btnSignup.setOnClickListener {
            val signUp = SignUpFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fl_start, signUp)
                ?.commit()
        }
    }
}