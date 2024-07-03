package com.example.myschools.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myschools.data.SchoolInfoItem
import com.example.myschools.model.SchoolModel

class SchoolsViewModel : ViewModel() {
        lateinit var schoolmodel: SchoolModel
        lateinit var schoolItems: ArrayList<SchoolInfoItem>
        lateinit var schoolnamelist:MutableList<String>
        //get list of school names
        fun fetchSchoolNames(): List<String> {
            schoolItems=schoolmodel.getSchools( )
            for (school in schoolItems){
               val schoolname=school.school_name
               schoolnamelist.add(schoolname)
            }
           return(schoolnamelist)
        }
}
