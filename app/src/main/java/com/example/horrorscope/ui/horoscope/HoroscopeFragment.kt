package com.example.horrorscope.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horrorscope.databinding.FragmentHoroscopeBinding
import com.example.horrorscope.domain.model.HoroscopeInfo
import com.example.horrorscope.domain.model.HoroscopeModel
import com.example.horrorscope.domain.model.HoroscopeModel.Aquarius
import com.example.horrorscope.domain.model.HoroscopeModel.Aries
import com.example.horrorscope.domain.model.HoroscopeModel.Cancer
import com.example.horrorscope.domain.model.HoroscopeModel.Capricorn
import com.example.horrorscope.domain.model.HoroscopeModel.Gemini
import com.example.horrorscope.domain.model.HoroscopeModel.Leo
import com.example.horrorscope.domain.model.HoroscopeModel.Libra
import com.example.horrorscope.domain.model.HoroscopeModel.Pisces
import com.example.horrorscope.domain.model.HoroscopeModel.Sagittarius
import com.example.horrorscope.domain.model.HoroscopeModel.Scorpio
import com.example.horrorscope.domain.model.HoroscopeModel.Taurus
import com.example.horrorscope.domain.model.HoroscopeModel.Virgo
import com.example.horrorscope.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val type: HoroscopeModel = when (it) {
                HoroscopeInfo.Aquarius -> Aquarius
                HoroscopeInfo.Aries -> Aries
                HoroscopeInfo.Cancer -> Cancer
                HoroscopeInfo.Capricorn -> Capricorn
                HoroscopeInfo.Gemini -> Gemini
                HoroscopeInfo.Leo -> Leo
                HoroscopeInfo.Libra -> Libra
                HoroscopeInfo.Pisces -> Pisces
                HoroscopeInfo.Sagittarius -> Sagittarius
                HoroscopeInfo.Scorpio -> Scorpio
                HoroscopeInfo.Taurus -> Taurus
                HoroscopeInfo.Virgo -> Virgo
            }

            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToDetailHoroscopeActivity(type)
            )
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }


}