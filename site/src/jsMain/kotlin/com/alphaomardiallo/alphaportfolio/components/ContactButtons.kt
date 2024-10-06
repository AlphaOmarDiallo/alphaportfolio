package com.alphaomardiallo.alphaportfolio.components

import androidx.compose.runtime.Composable
import com.alphaomardiallo.alphaportfolio.components.presentation.OvalTextButton
import com.alphaomardiallo.alphaportfolio.components.presentation.RoundImageButton
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px

@Composable
fun ContactButtons(reduced: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OvalTextButton(
            text = "Contact me",
            size = if (reduced) 30.px else 40.px
        )
        {
            window.location.href =
                "mailto:alphaomar.diallo@outlook.com?subject=Contact%20Request&body=Hello%20Alpha,"
        }
        RoundImageButton(
            imgSrc = "/icons8-github.svg",
            alt = "Github logo icon, https://icons8.com/icon/106562/github",
            url = "https://github.com/AlphaOmarDiallo",
            backgroundColor = "#000000",
            size = if (reduced) 30.px else 40.px
        )
        RoundImageButton(
            imgSrc = "/icons8-linkedin.svg",
            alt = "LinkedIn logo icon : https://icons8.com/icon/13930/linkedin",
            url = "https://www.linkedin.com/in/alpha-omar-diallo/?locale=en_US",
            backgroundColor = "#0288d1",
            size = if (reduced) 30.px else 40.px
        )
    }
}
