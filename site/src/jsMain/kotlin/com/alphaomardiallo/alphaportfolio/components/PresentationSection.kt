package com.alphaomardiallo.alphaportfolio.components

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.styles.CardHeights
import com.alphaomardiallo.alphaportfolio.styles.SiteBorderRadius
import com.alphaomardiallo.alphaportfolio.styles.mediumTitleStyle
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.css.objectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.outline
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.times
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PresentationSection(breakpoint: Breakpoint = rememberBreakpoint()) {

    Div(
        attrs = {
            id(IndexAnchor.home)
            style {
                width(100.percent)
                height(if (breakpoint >= Breakpoint.MD) CardHeights.STANDARD_CARD_HEIGHT else 200.px)
            }
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(leftRight = SitePaddings.MEDIUM_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (breakpoint >= Breakpoint.MD) {
                AlphaPhoto()
                Div(
                    attrs = {
                        style {
                            width(2.percent)
                        }
                    }
                )
                Presentation()
            } else {
                Presentation()
            }
        }
    }
}

@Composable
private fun AlphaPhoto(breakpoint: Breakpoint = rememberBreakpoint()) {
    Img(
        src = "/alpha_diallo_photo.jpg",
        alt = "Portrait of Alpha Diallo",
        attrs = {
            style {
                maxWidth(100.percent)
                height(if (breakpoint >= Breakpoint.MD) CardHeights.STANDARD_CARD_HEIGHT else CardHeights.REDUCED_CARD_HEIGHT)
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                property("transition", "transform 0.3s ease-in-out")
            }
            onMouseOver {
                it.target.asDynamic().style.transform = "scale(1.1)"
            }
            onMouseOut {
                it.target.asDynamic().style.transform = "scale(1)"
            }
        }
    )
}

@Composable
private fun Presentation(breakpoint: Breakpoint = rememberBreakpoint()) {
    Div(
        attrs = {
            style {
                width(100.percent)
                if (breakpoint >= Breakpoint.MD) {
                    height(CardHeights.STANDARD_CARD_HEIGHT)
                }
                minHeight(200.px)
                maxHeight(450.px)
                backgroundColor(Color.lightgreen)
                borderRadius(SiteBorderRadius.STANDARD_BORDER_RADIUS)
                backgroundImage(
                    "linear-gradient(270deg," +
                            "hsl(216deg 75% 80%) 0%," +
                            "hsl(216deg 75% 81%) 7%," +
                            "hsl(216deg 75% 81%) 13%," +
                            "hsl(216deg 74% 82%) 20%," +
                            "hsl(217deg 74% 83%) 25%," +
                            "hsl(217deg 74% 84%) 30%," +
                            "hsl(217deg 74% 85%) 35%," +
                            "hsl(217deg 74% 86%) 40%," +
                            "hsl(217deg 74% 86%) 45%," +
                            "hsl(217deg 74% 87%) 49%," +
                            "hsl(218deg 73% 88%) 53%," +
                            "hsl(218deg 73% 89%) 57%," +
                            "hsl(218deg 73% 89%) 60%," +
                            "hsl(218deg 72% 90%) 64%," +
                            "hsl(218deg 72% 91%) 67%," +
                            "hsl(218deg 72% 92%) 71%," +
                            "hsl(218deg 71% 93%) 74%," +
                            "hsl(219deg 70% 93%) 77%," +
                            "hsl(219deg 69% 94%) 80%," +
                            "hsl(219deg 68% 95%) 83%," +
                            "hsl(219deg 67% 96%) 87%," +
                            "hsl(219deg 64% 96%) 90%," +
                            "hsl(219deg 61% 97%) 93%," +
                            "hsl(220deg 55% 98%) 97%," +
                            "hsl(220deg 43% 99%) 100%)"
                )
            }
        }
    ) {
        Column(
            modifier =
            Modifier.fillMaxHeight()
                .fillMaxWidth(if (breakpoint >= Breakpoint.LG) 90.percent else 100.percent)
                .padding(
                    leftRight = SitePaddings.MEDIUM_PADDING,
                    topBottom = SitePaddings.LARGE_PADDING
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Span(
                mediumTitleStyle.toModifier()
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(TextAlign.Start)
                    .padding(leftRight = SitePaddings.SMALL_PADDING)
                    .toAttrs()
            ) {
                Text("Hi, I'm Alpha.")
            }
            Span(
                smallTitleStyle.toModifier()
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(TextAlign.Start)
                    .padding(leftRight = SitePaddings.SMALL_PADDING)
                    .toAttrs()
            ) {
                Text("I am an Android developer. Before tech, I spent 10 years in hospitality, honing my communication and customer satisfaction skills, which I apply to every project.")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OvalTextButton("Contact me") {
                    println("Clicked on Contact")
                }
                RoundImageButton(
                    imgSrc = "/icons8-github.svg",
                    alt = "Github logo icon, https://icons8.com/icon/106562/github",
                    url = "https://github.com/AlphaOmarDiallo",
                    backgroundColor = "#000000"
                )
                RoundImageButton(
                    imgSrc = "/icons8-linkedin.svg",
                    alt = "LinkedIn logo icon : https://icons8.com/icon/13930/linkedin",
                    url = "https://www.linkedin.com/in/alpha-omar-diallo/?locale=en_US",
                    backgroundColor = "#0288d1"
                )
            }
        }
    }
}

@Composable
private fun RoundImageButton(
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

fun rel(s: String) {

}

@Composable
private fun OvalTextButton(text: String, size: CSSNumeric = 40.px, onClick: () -> Unit) {
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
