package com.example.horrorscope.ui.horoscope.adapter

import android.content.Context
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horrorscope.databinding.ItemHorosocopeBinding
import com.example.horrorscope.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHorosocopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context: Context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.itemParent.setOnClickListener{
           //
            startRotationAnimation(binding.ivHoroscope) {onItemSelected(horoscopeInfo)}
            }
        }
    }

    fun startRotationAnimation(view: View, newLambda: () -> Unit,){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withStartAction { newLambda() }
            start()
        }

}