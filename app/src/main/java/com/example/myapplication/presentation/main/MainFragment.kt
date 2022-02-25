package com.example.myapplication.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.MainFragmentBinding
import com.example.myapplication.presentation.base.BaseFragment

class MainFragment : BaseFragment<MainFragmentBinding>() {

    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(requireActivity().applicationContext)
        )[MainFragmentViewModel::class.java]
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)

    override fun MainFragmentBinding.onBindView(savedInstanceState: Bundle?) {
        receiveButton.setOnClickListener {
            viewModel.load()
        }
        saveButton.setOnClickListener {
            val userName = dataEdittext.text.toString()
            viewModel.save(userName)
        }

        viewModel.resultLiveData.observe(viewLifecycleOwner) { message ->
            dateTextview.text = message
        }
    }
}