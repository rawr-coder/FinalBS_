package com.example.finalbs_

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.view.LayoutInflater

import androidx.recyclerview.widget.RecyclerView


class ScheduleAdapter(private val days: List<Day>) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewDayName: TextView = itemView.findViewById(R.id.textViewDayName)
        val textViewStages: TextView = itemView.findViewById(R.id.textViewStages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val day = days[position]
        holder.textViewDayName.text = day.name
        holder.textViewStages.text = "Stages: ${day.stages}"
    }

    override fun getItemCount(): Int {
        return days.size
    }
}
