package com.example.rickymortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickymortyapp.service.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import com.example.rickymortyapp.data.Result
import com.example.rickymortyapp.data.Character

class Rickymortyviewmodel: ViewModel() {
    private val BASE_URL = "https://rickandmortyapi.com/api/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: Api = retrofit.create(Api::class.java)
    val CharacterList = MutableLiveData<List<Result>>()


    fun getCharacterListperpage(Page:Int) {
        val call = service.getcaractersperpage(Page)
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                response.body()?.results?.let { list ->
                    CharacterList.postValue(list)
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                call.cancel()
            }

        })
    }
}