package com.goble.animationpractice.views

import android.R.attr.visible
import android.animation.Animator
import android.transition.Fade
import android.transition.Fade.IN
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Task1() {
    // Track whether the composable has been composed
    var isVisible by remember { mutableStateOf(false) }
    val animatedValue by animateFloatAsState(targetValue= if(isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 2500),
        label = "textAnim")

    LaunchedEffect(Unit) {
        isVisible=true
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            Text(
                text = "Hello Android",
                fontSize = 24.sp,
                modifier = Modifier.alpha(animatedValue)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTask1() {
    Task1()
}