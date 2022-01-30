package com.example.controlesprogramasdetv.fragments.details

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.controlesprogramasdetv.R
import com.example.controlesprogramasdetv.data.ProgramTvDao
import com.example.controlesprogramasdetv.fragments.list.ListFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text


class DetailsFragment : Fragment() {
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        val args: DetailsFragmentArgs by navArgs()
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_details, container, false)

        val program = detailsViewModel.selectProgramTvbyId(args.id)
        program.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.nameDetails).text = it.nameProgram
            view.findViewById<TextView>(R.id.synopsisdetails).text = it.synopsis
            view.findViewById<TextView>(R.id.agegroupdetails).text = it.ageGroup.toString()
            view.findViewById<TextView>(R.id.timedetails).text = it.time
            view.findViewById<TextView>(R.id.hostdetails).text = it.host
            view.findViewById<TextView>(R.id.broadcasterdetails).text = it.broadcaster

            view.findViewById<TextView>(R.id.agegroupdetails).setBackgroundColor(
                Color.parseColor(
                    when{
                        it.ageGroup < 10 -> "#009118"
                        it.ageGroup < 12 -> "#0082DA"
                        it.ageGroup < 14 -> "#FAD019"
                        it.ageGroup < 16 -> "#F18813"
                        it.ageGroup < 18 -> "#D2000D"
                        else -> "#000000"
                    }
                ))
            if(it.ageGroup < 10)
                view.findViewById<TextView>(R.id.agegroupdetails).text = "L"

            view.findViewById<FloatingActionButton>(R.id.floatingActionButtonedit).setOnClickListener{
                val action = DetailsFragmentDirections.actionDetailsFragmentToUpdateFragment(args.id)
                view.findNavController().navigate(action)
            }

        })


        return view
    }

}