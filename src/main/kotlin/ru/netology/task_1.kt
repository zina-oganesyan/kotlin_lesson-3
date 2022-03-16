package ru.netology

import kotlin.math.absoluteValue

fun main() {
    println(agoToText(59))
}

fun agoToText(seconds: Int): String {
    val text = when (seconds) {
        in 0..60 -> "только что"
        in 61..3600 -> "${pluralForm(seconds / 60, "минуту", "минуты", "минут")} назад"
        in 3601..86400 -> "в сети ${pluralForm(seconds / 3600, "час", "часа", "часов")} назад"
        in 86401..172800 -> "сегодня"
        in 172801..259200 -> "вчера"
        else -> "давно"
    }
    return  "был(а) $text"
}

fun pluralForm(value: Int, one: String, few: String, many: String): String {
    val absValue = value.absoluteValue % 100
    val word = when {
        absValue in 10..20 -> many
        absValue.toString().last().digitToInt() in 2..4 -> few
        absValue.toString().endsWith("1") -> one
        else -> many
    }
    return "$value $word"
}