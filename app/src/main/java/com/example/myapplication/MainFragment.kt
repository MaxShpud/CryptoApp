package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.data.UserRepositoryImpl
import com.example.myapplication.databinding.MainFragmentBinding
import com.example.myapplication.domain.GetUserNameUseCase
import com.example.myapplication.domain.SaveUserNameUseCase
import com.example.myapplication.domain.models.UserNameParam

class MainFragment : BaseFragment<MainFragmentBinding>() {

    private val userRepository by lazy { UserRepositoryImpl(requireActivity().applicationContext) }

    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

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