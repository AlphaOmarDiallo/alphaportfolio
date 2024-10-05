package com.alphaomardiallo.alphaportfolio.components.presentation

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.SiteBorderRadius
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.css.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.outline
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.times
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun RoundImageButton(
    imgSrc: String,
    alt: String,
    url: String,
    backgroundColor: String,
    size: CSSNumeric = 40.px,
) {
    A(
        attrs = {
            href(url)
            target(ATarget.Blank)
            rel("noopener noreferrer")
            style {
                width(size)
                height(size)
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                display(DisplayStyle.InlineBlock)
                overflow("hidden")
                cursor("pointer")
                margin(SitePaddings.SMALL_PADDING)
                border {
                    style = LineStyle.None
                }
                boxShadow("none")
                outline("none")
                backgroundColor(Color(backgroundColor))
            }
        }
    ) {
        Img(
            src = imgSrc,
            alt = alt,
            attrs = {
                style {
                    width(100.percent)
                    height(100.percent)
                    objectFit(ObjectFit.Contain)
                    backgroundColor(Color.white)
                }
            }
        )
    }
}

@Composable
fun OvalTextButton(text: String, size: CSSNumeric = 40.px, onClick: () -> Unit) {
    Button(
        attrs = {
            onClick { onClick() }
            style {
                width(size * 3)
                height(size)
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                padding(0.px)
                margin(SitePaddings.SMALL_PADDING)
                border {
                    style = LineStyle.None
                    overflow("hidden")
                    cursor("pointer")
                }
                backgroundColor(Color.black)
            }
        }
    ) {
        Span(
            smallTitleStyle.toModifier()
                .whiteSpace(WhiteSpace.PreWrap)
                .textAlign(TextAlign.Center)
                .padding(leftRight = SitePaddings.SMALL_PADDING)
                .color(Color.white)
                .toAttrs()
        ) {
            Text(text)
        }
    }
}
