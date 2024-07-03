package com.example.myschools.di

import android.util.Log
import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.data.SchoolItem
import com.example.myschools.repo.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoaderTask {
    lateinit var school:ArrayList<SchoolInfoItem>
    lateinit var score:ArrayList<SchoolItem>
    //To call data of school
    fun getSchoolData(): ArrayList<SchoolInfoItem>{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitdata=retrofit.getSchoolData()
        retrofitdata.enqueue(object : Callback<List<SchoolInfoItem>?> {
            override fun onResponse(
                call: Call<List<SchoolInfoItem>?>,
                response: Response<List<SchoolInfoItem>?>
            ) {
                school= (response.body() as ArrayList<SchoolInfoItem>)
            }
            override fun onFailure(call: Call<List<SchoolInfoItem>?>, t: Throwable) {
                Log.d("mainactivity","onFailure:"+t.message )
            }
        })
        return (school)
    }
    //to get scores of  particular school
    fun getSatscores(dbn:String): ArrayList<SchoolItem> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val satscores=retrofit.getSatScore(dbn)
        satscores.enqueue(object : Callback<List<SchoolItem>?> {
             override fun onResponse(
                 call: Call<List<SchoolItem>?>,
                 response: Response<List<SchoolItem>?>
             ) {
                score= (response.body() as ArrayList<SchoolItem>)
            }
            override fun onFailure(call: Call<List<SchoolItem>?>, t: Throwable) {
                Log.d("mainactivity","onFailure:"+t.message )
            }
        })
        return(score)
    }
}