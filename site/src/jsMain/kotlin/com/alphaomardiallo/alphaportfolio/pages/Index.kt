package com.alphaomardiallo.alphaportfolio.pages

import androidx.compose.runtime.*
import com.alphaomardiallo.alphaportfolio.components.TopAppBar
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.worker.rememberWorker
import com.alphaomardiallo.alphaportfolio.worker.EchoWorker
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.modifiers.background
import org.jetbrains.compose.web.css.Color

@Page
@Composable
fun HomePage() {
    val worker = rememberWorker { EchoWorker { output -> console.log("Echoed: $output") } }
    LaunchedEffect(Unit) {
        worker.postInput("Hello, worker!")
    }

    Column(modifier = Modifier.fillMaxSize().background(Color.whitesmoke)) {
        TopAppBar()
    }
}
