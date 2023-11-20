package com.example.horrorscope.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.example.horrorscope.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {
    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    companion object {
        val PERMISSION_CAMERA = android.Manifest.permission.CAMERA
    }


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
//startCamera
        } else {
            Toast.makeText(
                requireContext(),
                "Acepta los permisos o lárgate con el resto de perdedores",
                Toast.LENGTH_LONG
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (checkCameraPermission()) {

        } else {
            requestPermissionLauncher.launch(PERMISSION_CAMERA)
        }
    }

    private fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            PERMISSION_CAMERA
        ) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root

        initUI() {

        }
    }

    private fun initUI(function: () -> Unit) {

    }


}
