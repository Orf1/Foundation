package dev.orf1.foundation.util

import dev.orf1.foundation.Foundation
import org.bukkit.entity.Player

class Message {
    fun send(player: Player, path: String) {
        if (Foundation.lang.get().getString(path) != null) {
            player.sendMessage(Chat().format(Foundation.lang.get().getString(path)!!))
        } else {
            player.sendMessage("null")
        }
    }
}