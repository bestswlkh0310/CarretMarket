package com.example.carretmarket.features.map

import androidx.fragment.app.viewModels
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentMapBinding

class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>() {
    override val viewModel: MapViewModel by viewModels()
    override fun observerViewModel() {

    }

}