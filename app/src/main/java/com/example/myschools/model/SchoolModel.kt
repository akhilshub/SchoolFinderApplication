package com.example.myschools.model

import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.repo.DataRepository
import com.example.myschools.repo.DataRepositoryImpl


class SchoolModel {
    private lateinit var schoolList: ArrayList<SchoolInfoItem>
    private lateinit var dataRepository: DataRepository
     fun getSchools():ArrayList<SchoolInfoItem> {
       schoolList=dataRepository.getSchoolData()
        return (schoolList)
    }
}

