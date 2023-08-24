package com.drongo.scanner.ui.activities.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController

import com.drongo.scanner.databinding.ActivityMainBinding
import com.drongo.scanner.ui.base.BaseActivity
import com.drongo.scanner.ui.utils.CodeTypes
import com.drongo.scanner.ui.utils.ScannerService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()
        setUpScanner()
    }

    private fun setupBottomNavigation() {
        val navController = binding.fragment.getFragment<NavHostFragment>()
        binding.bottomNavigation.setupWithNavController(navController.navController)
    }

    private fun setUpScanner() {
        ScannerService.registerScannerReceiver(scanReceiver, this)
        ScannerService.startScanService(this)
        ScannerService.setScan2Key(this)
        ScannerService.setNfc(this, true)
        ScannerService.setInit(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ScannerService.closeScanner(this)
        unregisterReceiver(scanReceiver)
    }

    private val scanReceiver: BroadcastReceiver = object : BroadcastReceiver() {

        private var barCodeString: String? = null
        private var barCodeName: String? = null

        override fun onReceive(context: Context?, intent: Intent?) {

            val action = intent?.action
            val bundle = intent?.extras ?: return



            when (action) {
                ScannerService.ACTION_RECEIVE_DATA -> {
                    barCodeString = bundle.getString("text") ?: "Not found"
                }
                ScannerService.ACTION_RECEIVE_DATATYPE -> {
                    val barCodeId = bundle.getInt("text")
                    Log.d("Type", "$barCodeId")
                    barCodeName = CodeTypes.fromId(barCodeId)?.codeName ?: "Not found"
                }
            }

            showToast()


        }

        private fun showToast() {

            if (barCodeName == null || barCodeString == null) return

            val string = "Type: $barCodeName Data: $barCodeString"

            Toast.makeText(
                this@MainActivity,
                string,
                Toast.LENGTH_LONG
            ).show()

            barCodeName = null
            barCodeString = null
        }
    }


}