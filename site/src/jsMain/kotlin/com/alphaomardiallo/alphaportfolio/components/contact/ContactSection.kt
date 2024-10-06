package com.alphaomardiallo.alphaportfolio.components.contact

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.components.ContactButtons
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SiteBorderRadius
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactSection() {
    Div(
        attrs = {
            id(IndexAnchor.CONTACT)
            style {
                width(100.percent)
                paddingTop(SitePaddings.MEDIUM_PADDING)
                paddingBottom(SitePaddings.MEDIUM_PADDING)
                paddingLeft(SitePaddings.MEDIUM_PADDING)
                maxHeight(450.px)
                backgroundColor(Color.lightgreen)
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                backgroundImage(
                    "linear-gradient(270deg," +
                            "hsl(0deg 0% 80%) 0%," +
                            "hsl(0deg 0% 85%) 20%," +
                            "hsl(0deg 0% 90%) 40%," +
                            "hsl(0deg 0% 95%) 60%," +
                            "hsl(0deg 0% 98%) 80%," +
                            "hsl(0deg 0% 100%) 100%" +
                            ")"
                )
            }
        }
    ) {
        Span(smallTitleStyle.toModifier()
                .whiteSpace(WhiteSpace.PreWrap)
                .textAlign(TextAlign.Start)
                .padding(SitePaddings.SMALL_PADDING)
                .color(Color.black)
                .toAttrs()
        ) {
            Text("Let's get in touch")
        }
        ContactButtons(reduced = true)
    }
}
