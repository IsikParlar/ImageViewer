package com.example.imageviewer.model

import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {
    @get:GET("/orgs/google/members")
    val members: Single<List<Member>>
}
