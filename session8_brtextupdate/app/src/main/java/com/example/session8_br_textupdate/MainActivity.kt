package com.example.session8_br_textupdate

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var wifiStatSwitch: Switch
    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        wifiStatSwitch = findViewById(R.id.wifiSwitch)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiStatSwitch.setOnCheckedChangeListener { compoundButton, isStateChanged ->

            wifiManager.isWifiEnabled = wifiManager.isWifiEnabled
            if (wifiManager.isWifiEnabled) {
                wifiStatSwitch.text = "wifi is enabled"
               // wifiManager.isWifiEnabled = true

            } else {
                wifiStatSwitch.text = "wifi is disable"
                //wifiManager.isWifiEnabled = false

            }


        }

    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifibr ,intentFilter)

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifibr)
    }
val wifibr :BroadcastReceiver = object :BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
      when(intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE
      , WifiManager.WIFI_STATE_UNKNOWN)){

          WifiManager.WIFI_STATE_ENABLED ->{
              wifiStatSwitch.isChecked = true
              wifiStatSwitch.text = "Wifi is on"
          }
          WifiManager.WIFI_STATE_DISABLED ->{
              wifiStatSwitch.isChecked = false
              wifiStatSwitch.text = "Wifi is off"
          }

      }
    }

}

}