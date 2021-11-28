package com.example.udhari_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import kotlinx.android.synthetic.main.fragment_add_amount.*
import kotlinx.android.synthetic.main.fragment_add_amount.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class add_amount : Fragment() {

    @InternalCoroutinesApi
    private lateinit var mDataViewModel: DataViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add_amount, container, false)

        mDataViewModel= ViewModelProvider(this).get(DataViewModel::class.java)

        view.save_data.setOnClickListener(){
            insertDataToDataBase()
        }


        return  view

    }

    @InternalCoroutinesApi
    private fun insertDataToDataBase() {

        val name= personName.text.toString()
        val personAmount= payAmount.text.toString()
        val details= editText.text.toString()


        if(name.isNotEmpty() || personAmount.isNotEmpty()|| details.isNotEmpty()){

            val data= Data(0,name,personAmount,details)
            mDataViewModel.insert(data)

            Toast.makeText(requireContext(),"Data is uploaded successfully ", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_add_amount_to_show_amount)


        }
        else
        {
            Toast.makeText(requireContext(),"Fill all data Please",Toast.LENGTH_SHORT).show()
        }

    }


}