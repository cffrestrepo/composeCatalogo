package com.compose.catalogo.ui

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    val onCheckedChange: (Boolean) -> Unit
)
