package com.goble.animationpractice.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Task2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isVisible by remember { mutableStateOf(false) }
//        val animateWidth by animateDpAsState(
//
//        )

        Button(
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text("Toggle")
        }

        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutVertically() + fadeOut(),
//            enter = {
//                slideInHorizontally(
//                    animationSpec = tween(
//                        durationMillis = 200
//                    )
//                )
//            }
//            {
//                fullWidth -> - fullWidth/3
//            }
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.background(color = Color.Red)
//                    .width(animateWidth)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTask2() {
    Task2()
}