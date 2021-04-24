package com.smd.retrofitdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smd.retrofitdemo.databinding.ListItemBinding
import com.smd.retrofitdemo.network.Person

/**
 * Adapter for the list of astronauts
 */
internal class PeopleInSpaceAdapter(var peopleInSpace: MutableList<Person>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleInSpaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PeopleInSpaceViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return peopleInSpace.size
    }

    /**
     * ViewHolder for showing the name of an astronaut and their craft
     */
    internal inner class PeopleInSpaceViewHolder(private val viewBinding: ListItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(position: Int) {
            val astronaut = peopleInSpace[position]
            viewBinding.name.text = astronaut.name
            viewBinding.craft.text = astronaut.craft
        }
    }

    fun replaceAll(newData: List<Person>?) {
        peopleInSpace.clear()
        peopleInSpace.addAll(newData!!)
        notifyDataSetChanged()
    }
}