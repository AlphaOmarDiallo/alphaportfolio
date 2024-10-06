package com.alphaomardiallo.alphaportfolio.styles

import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em

val largeTitleStyle = CssStyle.base {
    Modifier
        .lineHeight(1.15)
        .fontSize(4.cssRem)
        .margin(top = 0.4.em, bottom = 0.6.em)
        .fontWeight(FontWeight.Bold)
        .fontFamily("JetBrains Mono, monospace")
}

val mediumTitleStyle = CssStyle.base {
    Modifier
        .lineHeight(1.15)
        .fontSize(1.5.cssRem)
        .margin(top = 0.4.em, bottom = 0.6.em)
        .fontWeight(FontWeight.Bold)
        .fontFamily("JetBrains Mono, monospace")
}

val smallTitleStyle = CssStyle.base {
    Modifier
        .lineHeight(1.15)
        .fontSize(1.2.cssRem)
        .margin(top = 0.4.em, bottom = 0.6.em)
        .fontWeight(FontWeight.Medium)
        .fontFamily("JetBrains Mono, monospace")
}
