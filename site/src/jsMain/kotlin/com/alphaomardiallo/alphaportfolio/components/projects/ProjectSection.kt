package com.alphaomardiallo.alphaportfolio.components.projects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.alphaomardiallo.alphaportfolio.model.Project
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.justifyContent
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun ProjectSection(breakpoint: Breakpoint = rememberBreakpoint()) {
    var projects by remember { mutableStateOf(emptyList<Project>()) }

    LaunchedEffect(Unit) {
        projects = try {
            val response = window.fetch("/api/projects").await()
            if (response.ok) {
                val json = response.text().await()
                Json.decodeFromString<List<Project>>(json)
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            println("Error fetching projects: ${e.message}")
            emptyList()
        }
    }

    Div(
        attrs = {
            id(IndexAnchor.PROJECTS)
            style {
                width(100.percent)
                display(DisplayStyle.Flex) // Flexbox container
                flexWrap(if (breakpoint >= Breakpoint.MD) FlexWrap.Nowrap else FlexWrap.Wrap) // Wrap if smaller
                justifyContent(JustifyContent.Center) // Spacing between items
                padding(SitePaddings.MEDIUM_PADDING)
            }
        }
    ) {
        projects.forEach { project ->
            PolaroidCard(
                imageSrc = project.imageSrc,
                imageAlt = project.imageAlt,
                description = project.description,
                link = project.link
            )
            if (breakpoint >= Breakpoint.SM) {
                SpacerPage()
            }
        }
    }
}


@Composable
private fun SpacerPage() {
    Div(
        attrs = {
            style {
                width(10.px)
            }
        }
    )
}
