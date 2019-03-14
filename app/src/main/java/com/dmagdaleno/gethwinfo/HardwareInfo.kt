package com.dmagdaleno.gethwinfo

import com.dmagdaleno.gethwinfo.HardwareConst.Companion.INTERFACE_NAME
import com.dmagdaleno.gethwinfo.extensions.mapToHexaString
import java.net.NetworkInterface

fun getMACAddress(): String =
    NetworkInterface.getNetworkInterfaces()
        .asSequence()
        .filter { it.name == INTERFACE_NAME }
        .map { it.hardwareAddress }
        .first()
        .mapToHexaString()