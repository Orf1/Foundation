package dev.orf1.foundation.util

import dev.orf1.foundation.Foundation
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class Message {
    internal companion object {
        @JvmStatic
        internal fun send(player: Player, path: String) {
            if (Foundation.lang.get().getString(path) != null) {
                player.sendMessage(Chat.format(Foundation.lang.get().getString(path)!!))
            } else {
                player.sendMessage("null")
            }
        }

        internal fun broadcast(message: String) {
            Bukkit.getServer().broadcastMessage(message)
        }

        internal fun broadcast(message: String, permission: String) {
            Bukkit.getServer().broadcast(message, permission)
        }
    }
}