package com.example.myschools.repo

import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.data.SchoolItem
import retrofit2.http.GET

interface ApiInterface {
    @GET("resource/s3k6-pzi2.json")
     fun getSchoolData(): ArrayList<SchoolInfoItem>

    @GET("resource/f9bf-2cp4.json")
     fun getSatScore(dbn:String): List<SchoolItem>
}
