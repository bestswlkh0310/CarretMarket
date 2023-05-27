package com.example.carretmarket.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var binding: VB
    protected abstract val viewModel: VM
    protected abstract val TAG: String
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        setContentView(binding.root)

    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }
}