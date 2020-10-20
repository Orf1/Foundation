package dev.orf1.foundation.util

import org.bukkit.ChatColor

internal class Chat {
    fun format(message : String): String {
        return ChatColor.translateAlternateColorCodes('&', message)
    }
}