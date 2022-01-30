package com.example.controlesprogramasdetv.fragments.list

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.controlesprogramasdetv.R
import com.example.controlesprogramasdetv.model.ProgramaTv

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var programList = emptyList<ProgramaTv>()

    class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return programList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = programList[position]
        holder.itemView.findViewById<TextView>(R.id.programnametxt).text = currentItem.nameProgram
        holder.itemView.findViewById<TextView>(R.id.broadcastertxt).text = currentItem.broadcaster
        holder.itemView.findViewById<TextView>(R.id.agegrouptxt).text = currentItem.ageGroup.toString()


        holder.itemView.findViewById<TextView>(R.id.agegrouptxt).setBackgroundColor(Color.parseColor(
            when{
                currentItem.ageGroup < 10 -> "#009118"
                currentItem.ageGroup < 12 -> "#0082DA"
                currentItem.ageGroup < 14 -> "#FAD019"
                currentItem.ageGroup < 16 -> "#F18813"
                currentItem.ageGroup < 18 -> "#D2000D"
                else -> "#000000"
            }
            ))
        if(currentItem.ageGroup < 10)
            holder.itemView.findViewById<TextView>(R.id.agegrouptxt).text = "L"

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(currentItem.id)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(program : List<ProgramaTv>){
        this.programList = program
        notifyDataSetChanged()
    }
}