package com.example.myschools.ui


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myschools.R
import com.example.myschools.data.School
import com.example.myschools.data.SchoolItem

class SchoolListAdapter(private val schools: List<SchoolItem>, private val context: Context):
          RecyclerView.Adapter<SchoolListAdapter.SchoolViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_school_name, parent, false)
        return SchoolViewHolder(view)
    }
    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school = schools[position]
        holder.bind(school)
        actionListener(school,holder)
    }
    override fun getItemCount(): Int {
        return schools.size
    }
    //implement bind() for recyclerview// can be seperate class ViewHolder class
    inner class SchoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        fun bind(school: SchoolItem) {
            nameTextView.text = school.school_name
        }
    }
    //set action and data
    fun actionListener(school: SchoolItem,holder: SchoolViewHolder){
        val satScores ="No. of SAT Test takes:${school.num_of_sat_test_takers} \nSAT Critical Reading Average score:${school.sat_critical_reading_avg_score}\nSAT Math Average score:${school.sat_math_avg_score}"
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("school_dbn", school.dbn)
            intent.putExtra("satScores", satScores)
            context.startActivity(intent)
        }
    }
}