package com.example.controlesprogramasdetv.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.controlesprogramasdetv.R
import com.example.controlesprogramasdetv.model.ProgramaTv


class UpdateFragment : Fragment() {
    private lateinit var updateViewModel: UpdateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        updateViewModel = ViewModelProvider(this).get(UpdateViewModel::class.java)
        val args: UpdateFragmentArgs by navArgs()
        val view = inflater.inflate(R.layout.fragment_update, container, false)


        val program = updateViewModel.selectProgramTvbyId(args.id)

        program.observe(viewLifecycleOwner, Observer{
            view.findViewById<EditText>(R.id.programnameEdit).setText(it.nameProgram)
            view.findViewById<EditText>(R.id.synopsisEdit).setText(it.synopsis)
            view.findViewById<EditText>(R.id.ageGroupEdit).setText(it.ageGroup.toString())
            view.findViewById<EditText>(R.id.timeEdit).setText(it.time)
            view.findViewById<EditText>(R.id.hostnameEdit).setText(it.host)
            view.findViewById<EditText>(R.id.broadcasterEdit).setText(it.broadcaster)
        })

       view.findViewById<Button>(R.id.btnEdit).setOnClickListener {
           updateViewModel.updateProgramTv(
               ProgramaTv(
                   args.id,
                   view.findViewById<EditText>(R.id.programnameEdit).text.toString(),
                   view.findViewById<EditText>(R.id.synopsisEdit).text.toString(),
                   view.findViewById<EditText>(R.id.ageGroupEdit).text.toString().toInt(),
                   view.findViewById<EditText>(R.id.timeEdit).text.toString(),
                   view.findViewById<EditText>(R.id.timeEdit).text.toString(),
                   view.findViewById<EditText>(R.id.broadcasterEdit).text.toString()
               )
           )
           Toast.makeText(context, "thanks for using the app", Toast.LENGTH_LONG).show()
           findNavController().navigate(R.id.action_updateFragment_to_listFragment2)

       }
        view.findViewById<Button>(R.id.btnDeleteEdit).setOnClickListener{
            updateViewModel.deleteProgram(args.id)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment2)

            Toast.makeText(context, "thanks for using the app", Toast.LENGTH_LONG).show()

        }


        return view
    }
}