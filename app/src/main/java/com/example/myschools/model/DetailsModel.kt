package com.example.myschools.model

import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.repo.DataRepository

class DetailsModel {
    private lateinit var dataRepository: DataRepository
    fun getSchoolData(): ArrayList<SchoolInfoItem> {
       val schoollist=dataRepository.getSchoolData()//to call the repo
        return (schoollist)
    }
}