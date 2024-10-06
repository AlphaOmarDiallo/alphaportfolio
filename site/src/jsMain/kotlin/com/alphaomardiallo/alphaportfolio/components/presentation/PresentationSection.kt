package com.alphaomardiallo.alphaportfolio.components.presentation

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.styles.mediumTitleStyle
import com.alphaomardiallo.alphaportfolio.styles.smallTitleStyle
import com.alphaomardiallo.alphaportfolio.utils.CardDim
import com.alphaomardiallo.alphaportfolio.utils.IndexAnchor
import com.alphaomardiallo.alphaportfolio.utils.SitePaddings
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
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
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PresentationSection(breakpoint: Breakpoint = rememberBreakpoint()) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
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
        Div(
            attrs = {
                id(IndexAnchor.HOME)
                style {
                    width(100.percent)
                    if (breakpoint >= Breakpoint.MD) {
                        height(CardDim.STANDARD_CARD_HEIGHT)
                    }
                }
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
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
}
