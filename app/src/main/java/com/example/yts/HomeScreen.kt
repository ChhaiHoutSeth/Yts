package com.example.yts

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.yts.extensions.horizontalGradientBackground
import java.lang.reflect.Modifier

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState(0)
    Box() {

    }
}

@Composable
fun ScrollableContent(scrollState: ScrollState) {
//    Column(
//        modifier =  Modifier
//        .padding(8.dp)
//        .verticalScroll(state = scrollState)
//    ) {
//
//    }
}