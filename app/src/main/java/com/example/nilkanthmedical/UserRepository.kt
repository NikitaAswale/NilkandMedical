package com.example.nilkanthmedical

import retrofit2.Response

class UserRepository {

    val apiservice = APIService()

    suspend fun getUsers() : Response<List<Userdata>>{
        return apiservice.userService.getUser()
    }
}