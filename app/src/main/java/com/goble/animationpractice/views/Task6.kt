package com.goble.animationpractice.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults.Large
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun Task6() {
    val items = remember { (1..5).map { "Item $it" } }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items) { index, item ->
            AnimatedListItem(title=item, index = index)
        }
    }
}

@Composable
fun AnimatedListItem(
    title: String,
    index: Int
) {
    var isVisible by remember { mutableStateOf(false) }
    val animatedValue by animateFloatAsState(targetValue= if(isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 2500, delayMillis = 200*index),
        label = "textAnim")

    LaunchedEffect(Unit) {
        isVisible=true
    }

    Box(modifier = Modifier.size(500.dp,100.dp).alpha(animatedValue)) {
        Text("This is an animated list item.", color = White)
    }
}