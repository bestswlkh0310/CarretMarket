package com.example.carretmarket.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.carretmarket.R
import com.example.carretmarket.databinding.ActivityBoardBinding
import com.example.carretmarket.network.request.NewBoardRequest
import com.example.carretmarket.viewmodel.InputViewModel

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBoardBinding
    private lateinit var viewModel: InputViewModel

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board)
        viewModel = ViewModelProvider(this).get(InputViewModel::class.java)
        binding.lifecycleOwner = this
        binding.posting = viewModel

        binding.btnSubmit.setOnClickListener {
            val title = binding.evInpTitle.text.toString()
            val content = binding.evInpContent.text.toString()
            Log.d(TAG, "title - $title content - $content} - onCreate() called")

            viewModel.postContent(
                NewBoardRequest(
                    title,
                    content
                )
            )
            finish()
        }
    }
}