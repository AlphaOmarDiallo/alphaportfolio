package com.alphaomardiallo.alphaportfolio.components.presentation

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.components.ContactButtons
import com.alphaomardiallo.alphaportfolio.styles.mediumTitleStyle
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.CardDim
import com.alphaomardiallo.alphaportfolio.utils.SiteBorderRadius
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Presentation(breakpoint: Breakpoint = rememberBreakpoint()) {
    Div(
        attrs = {
            style {
                width(100.percent)
                if (breakpoint >= Breakpoint.MD) {
                    height(CardDim.STANDARD_CARD_HEIGHT)
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

            ContactButtons()
        }
    }
}

fun rel(s: String) {

}
