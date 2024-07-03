package com.example.myschools.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myschools.R
import com.example.myschools.viewmodel.DetailsViewModel
import com.example.myschools.data.SchoolInfoItem

class DetailsActivity : AppCompatActivity() {
    private lateinit var detailViewModel: DetailsViewModel
    private lateinit var detail:SchoolInfoItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        setupUI()
        populate()
    }
    fun setupUI() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    //call func to set values and actions
    fun populate(){
        val dbn = intent.getStringExtra("school_dbn")
        setscore()
        detail= detailViewModel.getInfo(dbn)!!
        prepareMessageButton(detail.school_email)
        gotoWebsite(detail.website)
        call(detail.phone_number)
        locater(detail.location)
        overview(detail.overview_paragraph)
    }
    //set overview
    fun overview(descr:String){
        findViewById<TextView>(R.id.info).apply {
            text=descr
        }
    }
    //set message btn
    fun prepareMessageButton(email:String){
        val message= findViewById<ImageButton>(R.id.message)
        message.setOnClickListener{
            val selectorIntent = Intent(Intent.ACTION_SENDTO)
            val urlString = "mailto:" + Uri.encode(email)
            selectorIntent.data = Uri.parse(urlString)
            startActivity(selectorIntent)
        }
    }
    //set website
    fun gotoWebsite(website:String){
        val query=findViewById<ImageButton>(R.id.que)
        query.setOnClickListener{
            val selectorIntent = Intent(Intent.ACTION_VIEW)
            val urlString =""+ Uri.encode(website)
            selectorIntent.data = Uri.parse(urlString)
            startActivity(selectorIntent)
        }
    }
    //set caller dialogue
    fun call(number:String){
        val call=findViewById<ImageButton>(R.id.call)
        call.setOnClickListener{
            val selectorIntent = Intent(Intent.ACTION_DIAL)
            val urlString = "tel:" + Uri.encode(number)
            selectorIntent.data = Uri.parse(urlString)
            startActivity(selectorIntent)
        }
    }
    //set location listener
    fun locater(address:String){
        val location= findViewById<ImageButton>(R.id.address)
        location.setOnClickListener{
            val selectorIntent = Intent(Intent.ACTION_VIEW)
            val urlString = "http://maps.google.com/maps?daddr=" + Uri.encode(address)
            selectorIntent.data = Uri.parse(urlString)
            startActivity(selectorIntent)
        }
    }
    //set scores
    fun setscore(){
        findViewById<TextView>(R.id.scores).apply {
            text=intent.getStringExtra("satScores")
        }
    }
}