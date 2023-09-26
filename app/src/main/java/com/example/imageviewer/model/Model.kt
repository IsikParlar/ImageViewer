package com.example.imageviewer.model

import com.google.gson.Gson
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Model {
    fun request(urlStr: String): Single<List<Member>> {
        return Retrofit.Builder()
            .baseUrl(urlStr)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(RetrofitService::class.java)
            .members
    }
}