package dev.orf1.foundation.util

import dev.orf1.foundation.Foundation
import org.bukkit.ChatColor

internal class Chat {
    internal companion object {
        @JvmStatic
        internal fun format(message: String): String {
            return ChatColor.translateAlternateColorCodes('&', message)
        }
    }
}