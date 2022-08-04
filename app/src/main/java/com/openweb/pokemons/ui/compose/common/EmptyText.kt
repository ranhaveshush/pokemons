package com.openweb.pokemons.ui.compose.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openweb.pokemons.ui.theme.AppTheme

@Composable
fun EmptyText(
    message: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = AppTheme.typography.h6,
            color = AppTheme.colors.onPrimary,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(name = "Light Theme", group = "Error Text")
@Preview(name = "Dark Theme", group = "Error Text", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewEmptyText() {
    AppTheme {
        EmptyText(message = "None repos")
    }
}
