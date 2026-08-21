package com.deeprows.football.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DeeprowssDarkColors = darkColorScheme(
    primary = Color(0xFFFF1744),
    onPrimary = Color.White,

    secondary = Color(0xFFFF1744),
    onSecondary = Color.White,

    background = Color(0xFF07090D),
    onBackground = Color(0xFFF4F6F8),

    surface = Color(0xFF10141B),
    onSurface = Color(0xFFF4F6F8),

    surfaceVariant = Color(0xFF171C24),
    onSurfaceVariant = Color(0xFF9AA3AE)
)

@Composable
fun DeeprowssTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DeeprowssDarkColors,
        content = content
    )
}
