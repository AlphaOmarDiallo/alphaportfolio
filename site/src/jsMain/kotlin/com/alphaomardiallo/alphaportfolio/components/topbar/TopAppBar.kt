package com.alphaomardiallo.alphaportfolio.components.topbar

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.styles.mediumTitleStyle
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.alphaomardiallo.alphaportfolio.utils.TopAppBarHeight
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.alignItems
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.css.justifyContent
import com.varabyte.kobweb.compose.css.zIndex
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
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textDecoration
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement

/**
 * Simple top app bar component with a title and three simple menu items with anchor links.
 */
@Composable
fun TopAppBar() {
    val breakpoint = rememberBreakpoint()

    Div(
        attrs = {
            style {
                position(Position.Fixed)
                top(0.px)
                left(0.px)
                height(TopAppBarHeight.STANDARD_TOP_APP_BAR_HEIGHT)
                width(100.percent)
                backgroundColor(Color.whitesmoke)
                zIndex(100)
                padding(SitePaddings.TINY_PADDING)
                boxShadow("0.px, 2.px, 4.px, rgba(0, 0, 0, 0.1)")
                display(DisplayStyle.Flex) // Enables Flexbox
                justifyContent(JustifyContent.Center) // Centers items horizontally
                alignItems(AlignItems.Center)
            }
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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
                    MenuItem(href = "#${IndexAnchor.HOME}", text = "Home")
                }
                Span(
                    smallTitleStyle.toModifier()
                        .whiteSpace(WhiteSpace.PreWrap)
                        .textAlign(TextAlign.Center)
                        .padding(leftRight = SitePaddings.SMALL_PADDING)
                        .toAttrs()
                ) {
                    MenuItem(href = "#${IndexAnchor.PROJECTS}", text = "Projects")
                }

                Span(
                    smallTitleStyle.toModifier()
                        .whiteSpace(WhiteSpace.PreWrap)
                        .textAlign(TextAlign.Center)
                        .padding(leftRight = SitePaddings.SMALL_PADDING)
                        .toAttrs()
                ) {
                    MenuItem(href = "#${IndexAnchor.CONTACT}", text = "Contact")
                }
            }
        }
    }
}

@Composable
private fun MenuItem(href: String, text: String) {
    A(
        href = href,
        attrs = {
            onClick {
                val element = window.document.querySelector(href)
                element?.let {
                    val topBarHeight = TopAppBarHeight.STANDARD_TOP_APP_BAR_HEIGHT // Replace with the actual height of your top bar in pixels
                    val yOffset = (it as HTMLElement).offsetTop - (topBarHeight.toString().toInt() - 30)
                    window.scrollTo(0.0, yOffset.toDouble())
                }
            }
            style {
                textDecoration("none")
                color(Color.black)
            }
        }
    ) {
        println("clicked : $text")
        Text(text)
    }
}
