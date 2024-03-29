package com.ibrahimethemsen

import com.ibrahimethemsen.chat.Chat
import com.ibrahimethemsen.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

@Suppress("unused")
fun Application.module() {
    val chat = Chat(replay = 100)
    configureSockets(chat)
    configureRouting()
}
