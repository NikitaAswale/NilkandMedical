package com.example.nilkanthmedical

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val userRepository = UserRepository()

    private val _users = MutableStateFlow<List<Userdata>>(emptyList())
    val users : StateFlow<List<Userdata>> = _users.asStateFlow()

    init{
        getUsers()
    }

    fun getUsers(){
        viewModelScope.launch {
            val response = userRepository.getUsers()

            if(response.isSuccessful){
                _users.value = response.body()!!
            }
        }
    }

}