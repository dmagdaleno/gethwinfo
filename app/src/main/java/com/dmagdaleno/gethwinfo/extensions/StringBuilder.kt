package com.dmagdaleno.gethwinfo.extensions

fun StringBuilder.deleteLastChar() {
    if (this.isNotEmpty())
        this.deleteCharAt(this.length - 1)
}