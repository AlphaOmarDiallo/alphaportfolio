package com.alphaomardiallo.alphaportfolio.components

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.styles.mediumTitleStyle
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.textDecoration
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * Simple top app bar component with a title and three simple menu items with anchor links.
 */
@Composable
fun TopAppBar() {
    val breakpoint = rememberBreakpoint()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                topBottom = SitePaddings.SMALL_PADDING,
                leftRight = SitePaddings.MEDIUM_PADDING
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Right side displaying name and job title
        Row(verticalAlignment = Alignment.CenterVertically) {
            when (breakpoint) {
                Breakpoint.ZERO -> {
                    Span(
                        mediumTitleStyle.toModifier()
                            .whiteSpace(WhiteSpace.PreWrap)
                            .textAlign(TextAlign.Center)
                            .color(Color.lightgreen)
                            .padding(leftRight = SitePaddings.SMALL_PADDING)
                            .toAttrs()
                    ) {
                        Text("AD")
                    }
                }
                else -> {
                    Span(
                        mediumTitleStyle.toModifier()
                            .whiteSpace(WhiteSpace.PreWrap)
                            .textAlign(TextAlign.Center)
                            .padding(leftRight = SitePaddings.SMALL_PADDING)
                            .color(Color.lightgreen)
                            .toAttrs()
                    ) {
                        Text("AD")
                    }
                    Span(
                        mediumTitleStyle.toModifier()
                            .whiteSpace(WhiteSpace.PreWrap)
                            .textAlign(TextAlign.Center)
                            .color(Color.lightgreen)
                            .toAttrs()
                    ) {
                        Text("|")
                    }
                    Span(
                        smallTitleStyle.toModifier()
                            .whiteSpace(WhiteSpace.PreWrap)
                            .textAlign(TextAlign.Center)
                            .toAttrs()
                    ) {
                        Text(" Alpha Diallo")
                    }
                }
            }
        }

        // Left side displaying simple menu items with anchor links
        Row {
            Span(
                smallTitleStyle.toModifier()
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(TextAlign.Center)
                    .padding(leftRight = SitePaddings.SMALL_PADDING)
                    .toAttrs()
            ) {
                MenuItem(href = IndexAnchor.home, text = "Home")
            }
            Span(
                smallTitleStyle.toModifier()
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(TextAlign.Center)
                    .padding(leftRight = SitePaddings.SMALL_PADDING)
                    .toAttrs()
            ) {
                MenuItem(href = IndexAnchor.projects, text = "Projects")
            }

            Span(
                smallTitleStyle.toModifier()
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(TextAlign.Center)
                    .padding(leftRight = SitePaddings.SMALL_PADDING)
                    .toAttrs()
            ) {
                MenuItem(href = IndexAnchor.contact, text = "Contact")
            }
        }
    }
}

@Composable
private fun MenuItem(href: String, text: String) {
    A(
        href = href,
        attrs = {
            style {
                textDecoration("none")
                color(Color.black)
            }
        }
    ) {
        Text(text)
    }
}
