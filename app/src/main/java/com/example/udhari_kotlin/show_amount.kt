package com.example.udhari_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_show_amount.*
import kotlinx.android.synthetic.main.fragment_show_amount.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class show_amount : Fragment() {

@InternalCoroutinesApi
lateinit var mUserViewModel: DataViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_show_amount, container, false)

        val recyclerView=view.recyclerView
        val adapter=  ListAdapter()
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this.requireContext())

        mUserViewModel= ViewModelProvider(this).get(DataViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer{data->
            adapter.setData(data)
        })

        view.addAmout.setOnClickListener(){
            findNavController().navigate(R.id.action_show_amount_to_add_amount)
        }

        return view
    }

}