package com.alphaomardiallo.alphaportfolio.components

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.styles.CardHeights
import com.alphaomardiallo.alphaportfolio.styles.SiteBorderRadius
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.css.justifyContent
import com.varabyte.kobweb.compose.css.objectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectSection(breakpoint: Breakpoint = rememberBreakpoint()) {
    Div(
        attrs = {
            id(IndexAnchor.home)
            style {
                width(100.percent)
                display(DisplayStyle.Flex) // Flexbox container
                flexWrap(if (breakpoint >= Breakpoint.MD) FlexWrap.Nowrap else FlexWrap.Wrap) // Wrap if smaller
                justifyContent(JustifyContent.Center) // Spacing between items
                padding(SitePaddings.MEDIUM_PADDING)
            }
        }
    ) {
        PolaroidCard(
            imageSrc = "/alpha_diallo_photo.jpg",
            imageAlt = "Portrait of Alpha Diallo",
            description = "Portrait of Alpha Diallo"
        )
        SpacerPage()
        PolaroidCard(
            imageSrc = "/alpha_diallo_photo.jpg",
            imageAlt = "Portrait of Alpha Diallo",
            description = "Portrait of Alpha Diallo"
        )
        SpacerPage()
        PolaroidCard(
            imageSrc = "/alpha_diallo_photo.jpg",
            imageAlt = "Portrait of Alpha Diallo",
            description = "Portrait of Alpha Diallo"
        )
    }
}

@Composable
fun PolaroidCard(breakpoint: Breakpoint = rememberBreakpoint(), imageSrc: String, imageAlt: String, description: String) {
    Div(
        attrs = {
            style {
                width(if (breakpoint >= Breakpoint.MD) 300.px else 250.px) // Adjust for square shape
                height(if (breakpoint >= Breakpoint.MD) 350.px else 300.px) // Add extra height for the "polaroid border" effect
                backgroundColor(Color.white)
                boxShadow("0px 4px 8px rgba(0, 0, 0, 0.2), 0px 6px 20px rgba(0, 0, 0, 0.19)")
                marginBottom(25.px)
                padding(20.px) // To add white borders
                overflow("hidden") // Ensure content stays within the borders
            }
        }
    ) {
        Div(
            attrs = {
                style {
                    width(100.percent)
                    height(80.percent) // Keep image part proportional
                    backgroundColor(Color.white)
                }
            }
        ) {
            Img(
                src = imageSrc,
                alt = imageAlt,
                attrs = {
                    style {
                        width(100.percent)
                        height(100.percent) // Ensure the image fills the container
                        objectFit(ObjectFit.Cover) // Crops to fill and maintain aspect ratio
                    }
                }
            )
        }
        Div(
            attrs = {
                style {
                    textAlign("center")
                    padding(10.px) // Padding for description area
                    height(20.percent) // Proportional height for the description part
                }
            }
        ) {
            P {
                Text(description)
            }
        }
    }
}

@Composable
fun SpacerPage(){
    Div(
        attrs = {
            style {
                width(10.px)
            }
        }
    )
}