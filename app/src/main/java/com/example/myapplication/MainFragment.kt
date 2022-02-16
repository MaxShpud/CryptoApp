package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainFragmentBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)

    override fun MainFragmentBinding.onBindView(savedInstanceState: Bundle?) {
        textView.setOnClickListener {
            navController.navigate(
                MainFragmentDirections.navigateToAnotherFragment(
                    123,
                    "me favorite fragment"
                )
            )
        }
    }
}