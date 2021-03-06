package tn.esprit.lolretrofit.utils

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query
import tn.esprit.lolretrofit.models.User

interface ApiInterface {

    @POST("login")
    fun seConnecter(@Query("log") login: String, @Query("pwd") password: String): Call<User>

    companion object {

        var BASE_URL = "http://192.168.43.34:5000/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}