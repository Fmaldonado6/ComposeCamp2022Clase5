package com.drongo.scanner.ui.activities.main.fragments.scanner

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet.Motion
import com.drongo.scanner.databinding.FragmentScannerBinding
import com.drongo.scanner.ui.utils.ScannerService

class ScannerFragment : Fragment() {

    private lateinit var binding: FragmentScannerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scanButton.setOnTouchListener { view: View, motionEvent: MotionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> ScannerService.startScanning(requireContext())
                MotionEvent.ACTION_UP -> ScannerService.stopScanning(requireContext())
            }
            return@setOnTouchListener false
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = ScannerFragment()
    }


}