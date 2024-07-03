package com.example.myschools.viewmodel

import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.model.DetailsModel

class DetailsViewModel {
    lateinit var detailmodel: DetailsModel
    lateinit var detailItems:ArrayList<SchoolInfoItem>
    //get info of a school using dbn
    fun getInfo(dbn: String?): SchoolInfoItem? {
        detailItems= detailmodel.getSchoolData()
        val foundSchool = findSchoolByDbn(detailItems, dbn)
        return(foundSchool)

    }
    //SEARCH USING KEY
    fun findSchoolByDbn(schools: ArrayList<SchoolInfoItem>, dbnToFind: String?): SchoolInfoItem? {
        for (school in schools) {
            if (school.dbn == dbnToFind) {
                return school
            }
        }
        return null
    }
}