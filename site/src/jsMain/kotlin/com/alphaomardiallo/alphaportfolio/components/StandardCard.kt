package com.alphaomardiallo.alphaportfolio.components

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun StandardCard(
    id: String,
    width: CSSSizeValue<CSSUnit.px> = 590.px,
    backgroundColor: CSSColorValue = Color.white,
    content: @Composable () -> Unit
) {
    Div (
        attrs = {
            id(id)
            style {
                width(width)
                backgroundColor(backgroundColor)
                borderRadius(50.px)
            }
        }
    ) {
        content()
    }
}
