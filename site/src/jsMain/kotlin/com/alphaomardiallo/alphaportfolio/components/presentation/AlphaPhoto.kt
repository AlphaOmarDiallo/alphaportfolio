package com.alphaomardiallo.alphaportfolio.components.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.alphaomardiallo.alphaportfolio.utils.CardDim
import com.alphaomardiallo.alphaportfolio.utils.SiteBorderRadius
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.transform
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun AlphaPhoto(breakpoint: Breakpoint = rememberBreakpoint()) {
    var isHovered by remember { mutableStateOf(false) } // State to track hover

    Div(
        attrs = {
            style {
                maxWidth(100.percent)
                width(if (breakpoint >= Breakpoint.MD) CardDim.STANDARD_CARD_WIDTH else CardDim.REDUCED_CARD_WIDTH)
                height(if (breakpoint >= Breakpoint.MD) CardDim.STANDARD_CARD_HEIGHT else CardDim.REDUCED_CARD_HEIGHT)
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                overflow("hidden")
            }
        }
    ) {
        Img(
            src = "/alpha_diallo_photo.jpg",
            alt = "Portrait of Alpha Diallo",
            attrs = {
                style {
                    width(100.percent)
                    height(100.percent)
                    property("transition", "transform 0.3s ease")
                    transform {
                        if (isHovered) scale(1.1) else scale(1.0)
                    }
                    cursor()
                }
                onMouseOver {
                    println("Mouse over Alpha!")
                    isHovered = true
                }
                onMouseOut {
                    println("Mouse out Alpha!")
                    isHovered = false
                }
            }
        )
    }
}
