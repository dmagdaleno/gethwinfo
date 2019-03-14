package com.dmagdaleno.gethwinfo

import android.util.Log
import com.dmagdaleno.gethwinfo.HardwareConst.Companion.INTERFACE_NAME
import com.dmagdaleno.gethwinfo.extensions.mapToHexaString
import java.lang.Exception
import java.net.NetworkInterface

fun getMACAddress(): String =
    try {
        NetworkInterface.getNetworkInterfaces()
            .asSequence()
            .first { it.name == INTERFACE_NAME }.hardwareAddress
            .mapToHexaString()
    } catch (e: Exception) {
        Log.e("MAC Address", "Not found", e)
        "Not found"
    }