package com.czech.housegot.utils

fun extractInt(input: String): Int? {
    if (input.isEmpty()) return null
    val regex = """[^0-9]""".toRegex()
    return regex.replace(input, "").toInt()
}