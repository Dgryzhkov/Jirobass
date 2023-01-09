package com.example.jirobass.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jirobass.R
import com.example.jirobass.databinding.DaysListItemBinding

/**
 *@Author Dgryzhkov
 */
class DaysAdapter : ListAdapter<DayModel, DaysAdapter.DayHolder>(MyComparator()) {

    class DayHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = DaysListItemBinding.bind(view)

        fun setData(day: DayModel) = with(binding) {
            val name = root.context.getString(R.string.day) + " ${adapterPosition + 1}"
            tvName.text = name
            val exCounter = root.context.getString(R.string.exercise) + " " +
                day.exercises.split(",").size.toString()
            tvExCounter.text = exCounter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.days_list_item, parent, false)
        return DayHolder(view)
    }

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        holder.setData(getItem(position))
    }

    class MyComparator : DiffUtil.ItemCallback<DayModel>() {
        override fun areItemsTheSame(oldItem: DayModel, newItem: DayModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DayModel, newItem: DayModel): Boolean {
            return oldItem == newItem
        }

    }
}