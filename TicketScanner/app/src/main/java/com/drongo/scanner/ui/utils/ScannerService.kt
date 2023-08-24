package com.drongo.scanner.ui.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.registerReceiver

object ScannerService {

    const val SCANNER_INIT = "unitech.scanservice.init"
    const val SCANNER_NFC_ENABLE = "unitech.scanservice.nfcenable”"
    const val SCAN2KEY_SETTING = "unitech.scanservice.scan2key_setting"
    const val START_SCANSERVICE = "unitech.scanservice.start"
    const val CLOSE_SCANSERVICE = "unitech.scanservice.close"
    const val SOFTWARE_SCANKEY = "unitech.scanservice.software_scankey"
    const val ACTION_RECEIVE_DATA = "unitech.scanservice.data"
    const val ACTION_RECEIVE_DATABYTES = "unitech.scanservice.databyte"
    const val ACTION_RECEIVE_DATALENGTH = "unitech.scanservice.datalength"
    const val ACTION_RECEIVE_DATATYPE = "unitech.scanservice.datatype"

    fun registerScannerReceiver(receiver: BroadcastReceiver, context: Context) {
        val intentFilter = IntentFilter()
        intentFilter.addAction(ACTION_RECEIVE_DATA)
        intentFilter.addAction(ACTION_RECEIVE_DATABYTES)
        intentFilter.addAction(ACTION_RECEIVE_DATALENGTH)
        intentFilter.addAction(ACTION_RECEIVE_DATATYPE)
        context.registerReceiver(receiver, intentFilter)
    }

    fun setNfc(context: Context, value: Boolean) {
        val bundle = Bundle()
        bundle.putBoolean("nfcenable", value)
        val mIntent = Intent().setAction(SCANNER_INIT).putExtras(bundle)
        context.sendBroadcast(mIntent)
    }

    fun setInit(context: Context) {
        val bundle1 = Bundle()
        bundle1.putBoolean("enable", true)
        val mIntent1 = Intent().setAction(SCANNER_INIT).putExtras(bundle1)
        context.sendBroadcast(mIntent1)
    }

    fun setScan2Key(context: Context) {
        val bundle = Bundle()
        bundle.putBoolean("scan2key", false)
        val mIntent = Intent().setAction(SCAN2KEY_SETTING).putExtras(bundle)
        context.sendBroadcast(mIntent)
    }

    fun startScanService(context: Context) {
        val mIntent = Intent().setAction(START_SCANSERVICE)
        context.sendBroadcast(mIntent)
    }

    fun stopScanning(context: Context) {
        val bundle = Bundle()
        bundle.putBoolean("scan", false)
        val mIntent = Intent().setAction(SOFTWARE_SCANKEY).putExtras(bundle)
        context.sendBroadcast(mIntent)
    }

    fun startScanning(context: Context) {
        val bundle = Bundle()
        bundle.putBoolean("scan", true)
        val mIntent = Intent().setAction(SOFTWARE_SCANKEY).putExtras(bundle)
        context.sendBroadcast(mIntent)
    }

    fun closeScanner(context: Context) {
        val bundle = Bundle()
        bundle.putBoolean("close", true)
        val mIntent = Intent().setAction(CLOSE_SCANSERVICE).putExtras(bundle)
        context.sendBroadcast(mIntent)
    }


}