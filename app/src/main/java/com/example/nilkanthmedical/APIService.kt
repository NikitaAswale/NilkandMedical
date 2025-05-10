package com.example.nilkanthmedical

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class APIService {

    private val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").
            addConverterFactory(GsonConverterFactory.create()).
            build()

    val userService = retrofit.create(APIService :: class.java)

    interface APIService {
        @GET("/users")
        suspend fun getUser() : Response<List<Userdata>>
    }
}