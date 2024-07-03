package com.example.myschools.repo

import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.data.SchoolItem

interface DataRepository {//defining func signature that could be sued by any class that interfaces DataRepo
    fun getSchoolData(): ArrayList<SchoolInfoItem>
    suspend fun getSatScore(dbn: String): List<SchoolItem>
}