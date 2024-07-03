package com.example.myschools.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myschools.R
import com.example.myschools.data.School
import com.example.myschools.viewmodel.SchoolsViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var schoolViewModel: SchoolsViewModel
    private lateinit var schoolListAdapter: SchoolListAdapter
    private lateinit var school: School
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setUI()
        getdata()
        callAdapter()
    }
    fun setUI() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    //get data for the activity
    fun getdata() {
        school = schoolViewModel.fetchSchoolNames() as School
    }
    //set view with adapter
    fun callAdapter(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        schoolListAdapter = SchoolListAdapter(school,this)
        recyclerView.adapter = schoolListAdapter
    }
}

