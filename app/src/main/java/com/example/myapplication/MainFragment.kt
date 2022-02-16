package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.MainFragmentBinding
import com.example.myapplication.domain.GetUserNameUseCase
import com.example.myapplication.domain.SaveUserNameUseCase
import com.example.myapplication.domain.models.UserNameParam

class MainFragment : BaseFragment<MainFragmentBinding>() {

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)

    override fun MainFragmentBinding.onBindView(savedInstanceState: Bundle?) {
        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dateTextview.text = userName.firstName
        }
        saveButton.setOnClickListener {
            val userName = dataEdittext.text.toString()
            val result = saveUserNameUseCase.execute(UserNameParam(userName))
            dateTextview.text = result.toString()
        }
    }
}