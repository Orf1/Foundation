package dev.orf1.foundation.util

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Scheduler {
    internal fun queueAsync(plugin: JavaPlugin, task: Runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, task)
    }
    internal fun queueSync(plugin: JavaPlugin, task: Runnable) {
        Bukkit.getScheduler().runTask(plugin, task)
    }
}