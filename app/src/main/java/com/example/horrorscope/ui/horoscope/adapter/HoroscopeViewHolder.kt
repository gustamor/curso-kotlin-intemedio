package com.example.horrorscope.ui.horoscope.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horrorscope.databinding.ItemHorosocopeBinding
import com.example.horrorscope.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHorosocopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo) {
        val context: Context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)
    }
}