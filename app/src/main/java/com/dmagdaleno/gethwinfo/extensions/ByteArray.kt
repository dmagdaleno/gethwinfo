package com.dmagdaleno.gethwinfo.extensions

fun ByteArray.mapToHexaString(separator: String = ""): String {
    val buf = StringBuilder()

    this.forEach {
        buf.append(String.format("%02X$separator", it))
    }

    buf.deleteLastChar()

    return buf.toString()
}