package com.nhinlechi.nhin_music_app.ui.component

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestingCompose(name: String) {
    Text("Hello $name!")
}

@Preview(showSystemUi = true)
@Composable
fun TestingComposePreview() {
    TestingCompose(name = "Nhin")
}
