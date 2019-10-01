package com.myweb.lab8mysqlqueryinsert

import android.telecom.Call
import layout.student
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentAPI {
        @GET("allstd")
        fun retrieveStudent(): Call<List<student>>

        @FormUrlEncoded
        @POST("std")
        fun insertStd(
            @Field("std_id") std_id: String,
            @Field("std_name") std_name: String,
            @Field("std_age") std_age: Int) : Call<student>


    }
