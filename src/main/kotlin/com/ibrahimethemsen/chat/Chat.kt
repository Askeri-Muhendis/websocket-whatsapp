package com.ibrahimethemsen.chat

import model.ChatEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class Chat(replay: Int = 100) {
    private val _eventFlow: MutableSharedFlow<ChatEvent> = MutableSharedFlow(replay = replay)

    val eventFlow: SharedFlow<ChatEvent> get() = _eventFlow

    suspend fun broadcastEvent(event: ChatEvent) {
        _eventFlow.emit(event)
    }
}