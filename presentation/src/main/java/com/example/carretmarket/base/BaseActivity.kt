package com.example.carretmarket.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.carretmarket.R
import com.example.carretmarket.BR
import com.example.carretmarket.util.Constant.TAG
import com.example.carretmarket.util.Token
import java.lang.reflect.ParameterizedType
import java.util.Locale
import java.util.Objects

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var mViewModel: VM
    protected lateinit var mBinding: VB

    protected abstract val viewModel: VM

    protected abstract fun observerViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        observerViewModel()
    }

    private fun performDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, layoutRes())
        mViewModel = if (::mViewModel.isInitialized) mViewModel else viewModel
        mBinding.setVariable(BR.vm, mViewModel)
        mBinding.lifecycleOwner = this
    }


    protected fun bindingViewEvent(action: (event: Any) -> Unit) {
        viewModel.viewEvent.observe(this) { event ->
            action.invoke(event)
        }
        viewModel.tokenErrorEvent.observe(this) { event ->
            if (event == Token.TOKEN_EXCEPTION) {
                Toast.makeText(applicationContext, "토큰 만료", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "토큰 만료 - bindingViewEvent() called")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mBinding.isInitialized) mBinding.unbind()
    }


    @LayoutRes
    private fun layoutRes(): Int {
        val split = (
                (Objects.requireNonNull(javaClass.genericSuperclass) as ParameterizedType)
                    .actualTypeArguments[0] as Class<*>
                )
            .simpleName.replace("Binding$".toRegex(), "")
            .split("(?<=.)(?=\\p{Upper})".toRegex())
            .dropLastWhile { it.isEmpty() }.toTypedArray()

        val name = StringBuilder()

        for (i in split.indices) {
            name.append(split[i].lowercase(Locale.ROOT))
            if (i != split.size - 1)
                name.append("_")
        }

        try {
            return R.layout::class.java.getField(name.toString()).getInt(R.layout::class.java)
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }

        return 0
    }
}