package br.com.valid.bio.component.gethwinfo

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.NetworkInterface
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val mac = getMACAddress()

        txt_mac.text = mac
    }

    private fun getMACAddress(): String {
        val interfaceName = "wlan0"

        val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())

        for (intf in interfaces) {

            if (intf.name != interfaceName){
                continue
            }

            val mac = intf.hardwareAddress ?: return ""

            val buf = StringBuilder()

            mac.forEach { m ->
                buf.append(String.format("%02X:", m))
            }

            if (buf.isNotEmpty()) {
                buf.deleteCharAt(buf.length - 1)
            }

            return buf.toString()
        }

        return ""
    }


}
