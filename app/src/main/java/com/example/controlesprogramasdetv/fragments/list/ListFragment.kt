package com.example.controlesprogramasdetv.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controlesprogramasdetv.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var listViewModel: ListModelView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        val recyclervView = view.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ListAdapter()
        recyclervView.adapter = adapter
        recyclervView.layoutManager = LinearLayoutManager(requireContext())

        listViewModel = ViewModelProvider(this).get(ListModelView::class.java)
        listViewModel.selectProgram.observe(viewLifecycleOwner, Observer { program ->
            adapter.setData(program)
        })

        view.findViewById<FloatingActionButton>(R.id.btnDeleteAll).setOnClickListener{
            listViewModel.deleteall()
        }

        return view
    }



}