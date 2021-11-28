package com.example.udhari_kotlin

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add_amount.view.*
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {



    var dataList = emptyList<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    @InternalCoroutinesApi
    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        val currentItem= dataList[position]
        holder.itemView.nameOfPerosn.text=currentItem.Name
        holder.itemView.personMoney.text=("₹ "+currentItem.Price )

        holder.itemView.dataText.text=currentItem.note

        holder.itemView.rowLayout.setOnClickListener(){

            val action = show_amountDirections.actionShowAmountToEditFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }

    }

    override fun getItemCount(): Int {
        return dataList.size

    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    fun setData(data:List<Data>){
        this.dataList=data
        notifyDataSetChanged()
    }

}