package com.example.myapplication.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.databinding.MainFragmentBinding
import com.example.myapplication.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<MainFragmentBinding>() {

	private val viewModel by viewModel<MainFragmentViewModel>()

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
			navController.navigate(MainFragmentDirections.navigateToTwoButtonDialog("qqq"))
		}

		viewModel.resultLiveData.observe(viewLifecycleOwner) { message ->
			dateTextview.text = message
		}
	}
}