package gg.rsmod.game.message.handler

import gg.rsmod.game.message.MessageHandler
import gg.rsmod.game.message.impl.EventAppletFocusMessage
import gg.rsmod.game.model.entity.Client

/**
 * @author Tom <rspsmods@gmail.com>
 */
class EventAppletFocusHandler : MessageHandler<EventAppletFocusMessage> {

    companion object {
        private const val UNFOCUSED_STATE = 0
        private const val FOCUSED_STATE = 1
    }

    override fun handle(client: Client, message: EventAppletFocusMessage) {
        when (message.state) {
            FOCUSED_STATE -> client.appletFocused = true
            UNFOCUSED_STATE -> client.appletFocused = false
        }
    }
}