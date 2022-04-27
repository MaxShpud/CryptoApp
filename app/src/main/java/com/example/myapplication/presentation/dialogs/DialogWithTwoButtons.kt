package com.example.myapplication.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.databinding.DialogWithTwoButtonsBinding
import com.example.myapplication.presentation.base.BaseDialogFragment

class DialogWithTwoButtons : BaseDialogFragment<DialogWithTwoButtonsBinding>() {
	override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): DialogWithTwoButtonsBinding =
		DialogWithTwoButtonsBinding.inflate(inflater, container, false)

	override fun DialogWithTwoButtonsBinding.onBindView(savedInstanceState: Bundle?) {
		buttonSuccess.setOnClickListener { closeWithResult(true) }
		buttonCancel.setOnClickListener { closeWithResult(false) }
	}

	private fun closeWithResult(isSuccess: Boolean) {
		navController.navigateUp()
		setResult(isSuccess)
	}

	private fun setResult(isSuccess: Boolean) {
		setFragmentResultWithRequester("", RESULT_KEY to isSuccess)
	}

	companion object {
		const val REQUEST_KEY = "DIALOG_WITH_TWO_BUTTONS_REQUEST_KEY"
		const val RESULT_KEY = "DIALOG_WITH_TWO_BUTTONS_RESULT_KEY"
	}
}