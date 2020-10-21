package dev.orf1.foundation.util

import org.bukkit.Bukkit

class Log {
    internal companion object {
        @JvmStatic
        internal fun info(message: String) {
            Bukkit.getLogger().info(message)
        }

        internal fun warning(message: String) {
            Bukkit.getLogger().warning(message)
        }

        internal fun error(message: String) {
            Bukkit.getLogger().severe(message)
        }
    }
}