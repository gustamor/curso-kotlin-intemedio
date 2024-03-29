package com.example.horrorscope.ui.horoscope.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horrorscope.R
import com.example.horrorscope.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList:List<HoroscopeInfo> = emptyList(),
                       private val onItemSelected:(HoroscopeInfo) -> Unit)
    : RecyclerView.Adapter<HoroscopeViewHolder>()
{

   @SuppressLint("NotifyDataSetChanged")
   fun updateList(list:List<HoroscopeInfo>) {
       horoscopeList = list
       notifyDataSetChanged()
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
       return HoroscopeViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.item_horosocope , parent, false)
       )
    }
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position],onItemSelected)
    }
    override fun getItemCount(): Int = horoscopeList.size

}