package com.alphaomardiallo.alphaportfolio.components.projects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.alphaomardiallo.alphaportfolio.utils.SiteBorderRadius
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.css.objectFit
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.transform
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun PolaroidCard(
    breakpoint: Breakpoint = rememberBreakpoint(),
    imageSrc: String,
    imageAlt: String,
    description: String,
    link: String
) {
    var isHovered by remember { mutableStateOf(false) } // State to track hover

    Div(
        attrs = {
            style {
                width(if (breakpoint >= Breakpoint.MD) 300.px else 250.px) // Adjust for square shape
                height(if (breakpoint >= Breakpoint.MD) 350.px else 300.px) // Add extra height for the "polaroid border" effect
                backgroundColor(Color.white)
                boxShadow("0px 4px 8px rgba(0, 0, 0, 0.2), 0px 6px 20px rgba(0, 0, 0, 0.19)")
                marginBottom(25.px)
                padding(20.px)
                overflow("hidden")
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
            }
        }
    ) {
        Div(
            attrs = {
                style {
                    width(100.percent)
                    height(80.percent)
                    backgroundColor(Color.white)
                    borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                }
            }
        ) {
            A(
                attrs = {
                    href(link)
                    target(ATarget.Blank)
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
                            property("transition", "transform 0.3s ease")
                            transform {
                                if (isHovered) scale(1.1) else scale(1.0)
                            }
                            cursor()
                            borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                        }
                        onMouseOver {
                            println("Mouse over Image!")
                            isHovered = true
                        }
                        onMouseOut {
                            println("Mouse out Image!")
                            isHovered = false
                        }
                    }
                )
            }
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
