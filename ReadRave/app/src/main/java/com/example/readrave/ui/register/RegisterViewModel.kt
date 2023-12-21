package com.example.readrave.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.readrave.data.repository.Repository
import com.example.readrave.data.response.RegisterResponse

class RegisterViewModel (private val repository: Repository) : ViewModel() {

    private val _registrationResult = MutableLiveData<RegisterResponse>()
    val registrationResult: LiveData<RegisterResponse> get() = _registrationResult

    fun registerUser(name: String, email: String, password: String, confPassword: String) = repository.register(name, email, password, confPassword)
}