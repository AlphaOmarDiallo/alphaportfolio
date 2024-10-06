package com.alphaomardiallo.alphaportfolio.components.projects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.alphaomardiallo.alphaportfolio.model.Project
import com.alphaomardiallo.alphaportfolio.styles.largeTitleStyle
import com.alphaomardiallo.alphaportfolio.styles.mediumTitleStyle
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SiteBorderRadius
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

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
                minHeight(200.px)
                backgroundColor(Color.lightgreen)
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                backgroundImage(
                    "linear-gradient(270deg," +
                            "hsl(146deg 72% 56%) 0%," +
                            "hsl(148deg 63% 65%) 20%," +
                            "hsl(151deg 53% 75%) 40%," +
                            "hsl(154deg 43% 85%) 60%," +
                            "hsl(157deg 33% 92%) 80%," +
                            "hsl(160deg 23% 98%) 100%" +
                            ")"
                )
            }
        }
    ) {
        Div(
            attrs = {
                style {
                    width(100.percent)
                    display(DisplayStyle.Flex) // Flexbox container
                    flexWrap(if (breakpoint >= Breakpoint.MD) FlexWrap.Nowrap else FlexWrap.Wrap) // Wrap if smaller
                    justifyContent(JustifyContent.Center) // Spacing between items
                    flexDirection(FlexDirection.Column)
                    padding(SitePaddings.MEDIUM_PADDING)
                }
            }
        ) {
            Span(
                mediumTitleStyle.toModifier()
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(TextAlign.Start)
                    .color(Color.black)
                    .toAttrs()
            ) {
                Text("My projects")
            }

            Div(
                attrs = {
                    style {
                        display(DisplayStyle.Flex)
                        flexWrap(if (breakpoint >= Breakpoint.MD) FlexWrap.Nowrap else FlexWrap.Wrap) // Wrap if screen is smaller
                        justifyContent(JustifyContent.Center)
                        marginTop(SitePaddings.SMALL_PADDING) // Add some spacing between the title and projects
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
