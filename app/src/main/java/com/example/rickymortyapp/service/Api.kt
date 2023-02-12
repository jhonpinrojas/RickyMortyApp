package com.example.rickymortyapp.service

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.rickymortyapp.data.Character
import retrofit2.Call
import retrofit2.http.Path

interface Api {
    @GET(value="character")
    fun getcaracters(): Call<Character>
    @GET(value="character")
    fun getcaractersperpage(@Query(value = "page")page:Int): Call<Character>

    companion object Factory{
        operator fun invoke():Api{
            return  Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }}
}
