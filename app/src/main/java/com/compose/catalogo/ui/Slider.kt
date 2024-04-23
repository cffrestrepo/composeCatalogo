package com.compose.catalogo.ui

import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun BasicSlider() {
    var sliderPosition by rememberSaveable { mutableStateOf(0f) }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it }
    )
}

