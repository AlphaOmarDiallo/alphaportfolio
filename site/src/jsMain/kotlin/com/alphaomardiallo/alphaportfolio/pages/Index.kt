package com.alphaomardiallo.alphaportfolio.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.alphaomardiallo.alphaportfolio.components.contact.ContactSection
import com.alphaomardiallo.alphaportfolio.components.presentation.PresentationSection
import com.alphaomardiallo.alphaportfolio.components.projects.ProjectSection
import com.alphaomardiallo.alphaportfolio.components.topbar.TopAppBar
import com.alphaomardiallo.alphaportfolio.utils.SiteMaxWidth
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.alphaomardiallo.alphaportfolio.worker.EchoWorker
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.worker.rememberWorker
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Page
@Composable
fun HomePage() {
    val worker = rememberWorker { EchoWorker { output -> console.log("Echoed: $output") } }
    LaunchedEffect(Unit) {
        worker.postInput("Hello, worker!")
    }

    Box(
        modifier = Modifier
            .padding(top = SitePaddings.MEDIUM_PADDING, bottom = SitePaddings.MEDIUM_PADDING)
            .fillMaxSize()
            .overflow(Overflow.Hidden),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .maxWidth(1200.px)
                .padding(leftRight = SitePaddings.MEDIUM_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .maxWidth(SiteMaxWidth.STANDARD_MAX_WIDTH)
                    .padding(leftRight = SitePaddings.MEDIUM_PADDING)
            ){
                PresentationSection()
                Separator()
                ProjectSection()
                Separator()
                ContactSection()
                Separator()
            }
        }
    }
}

@Composable
private fun Separator(){
    Div(
        attrs = {
            style {
                height(SitePaddings.MEDIUM_PADDING)
            }
        }
    )
}