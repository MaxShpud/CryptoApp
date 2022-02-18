package com.example.myapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.data.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.data.storage.converters.UserParamToUserConverter
import com.example.data.storage.converters.UserToUserNameConverter
import com.example.domain.models.UserNameParam
import com.example.domain.repository.usecase.GetUserNameUseCase
import com.example.domain.repository.usecase.SaveUserNameUseCase
import com.example.myapplication.databinding.MainFragmentBinding
import com.example.myapplication.presentation.base.BaseFragment

class MainFragment : BaseFragment<MainFragmentBinding>() {

    private val userStorage by lazy { SharedPrefUserStorage(requireActivity().applicationContext) }
    private val userRepository by lazy {
        UserRepositoryImpl(
            userStorage,
            UserParamToUserConverter(),
            UserToUserNameConverter()
        )
    }

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