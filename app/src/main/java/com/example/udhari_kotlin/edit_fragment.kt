package com.example.udhari_kotlin

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_edit_fragment.*
import kotlinx.android.synthetic.main.fragment_edit_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class edit_fragment : Fragment() {


    private val args by navArgs<edit_fragmentArgs>()

    @InternalCoroutinesApi
    private lateinit var mUserViewModel: DataViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_fragment, container, false)


        mUserViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        view.EDITeditText.setText(args.currentData.note)
        view.EDITpayAmount.setText("₹ " +args.currentData.Price)
        view.EDITpersonName.setText(args.currentData.Name)



        view.EDITsave_data.setOnClickListener() {
              updateData()
        }

        view.DataDelete.setOnClickListener(){
            mUserViewModel.dataDelete(args.currentData)
            findNavController().navigate(R.id.action_edit_fragment_to_show_amount)
            Toast.makeText(requireContext(),"Data deleted successfully ",Toast.LENGTH_SHORT).show()

        }


        return view
    }



    @InternalCoroutinesApi
    private fun updateData() {
        val firstName = EDITpersonName.text.toString()
        val amount = EDITpayAmount.text.toString()
        val details = EDITeditText.text.toString()


        if (firstName.isNotEmpty() && amount.isNotEmpty() && details.isNotEmpty()) {
            val updateData = Data(args.currentData.id, firstName, amount, details)

            mUserViewModel.updateData(updateData)
            findNavController().navigate(R.id.action_edit_fragment_to_show_amount)
            Toast.makeText(requireContext(), "updated successfully ", Toast.LENGTH_SHORT).show()

        }
        else
        {
            Toast.makeText(requireContext(), " facing some problem ", Toast.LENGTH_SHORT).show()

        }

    }
}


