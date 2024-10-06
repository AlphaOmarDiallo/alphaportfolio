package com.alphaomardiallo.alphaportfolio.api

import com.alphaomardiallo.alphaportfolio.model.Project
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.HttpMethod
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Api
fun listProjects(ctx: ApiContext) {
    try {
        // Check if the method is GET
        if (ctx.req.method != HttpMethod.GET) {
            ctx.res.status = 405 // Method Not Allowed
            ctx.res.setBodyText("Only GET method is allowed")
            return
        }

        // Serialize the list of projects to JSON and set as the response body
        ctx.res.setBodyText(Json.encodeToString(projectList()))
        ctx.res.status = 200
    } catch (e: Exception) {
        // Handle errors and provide feedback
        println(e.localizedMessage)
        ctx.res.status = 500
        ctx.res.setBodyText(e.toString())
    }
}

private fun projectList() = listOf(
    Project(
        imageSrc = "/pawned_app_demo.png",
        imageAlt = "Pwned app home page showing the result of an email check",
        description = "Pwned App - Have I been Pwned?",
        link = "https://play.google.com/store/apps/details?id=com.alphaomardiallo.pawnedemail"
    ),
    Project(
        imageSrc = "/handy_docs_demo.jpg",
        imageAlt = "Handy docs app illustration showing the home page with scanned documents",
        description = "HandyDocs - Document Scanner",
        link = "https://play.google.com/store/apps/details?id=com.alphaomardiallo.handydocs"
    )
)
