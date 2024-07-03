package com.example.myschools.repo

import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.data.SchoolItem
import com.example.myschools.di.LoaderTask

class DataRepositoryImpl (private val loaderTask: LoaderTask) : DataRepository {
//get schools data
    override fun getSchoolData(): ArrayList<SchoolInfoItem> {
        val schoollist=loaderTask.getSchoolData()
        return(schoollist)
    }
//get scores of a school
    override suspend fun getSatScore(dbn: String): List<SchoolItem> {
        val satscores=loaderTask.getSatscores(dbn)
        return(satscores)
    }
}
