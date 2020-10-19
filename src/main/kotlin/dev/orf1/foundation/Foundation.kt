package dev.orf1.foundation

import co.aikar.commands.PaperCommandManager
import org.bukkit.plugin.java.JavaPlugin

class Foundation : JavaPlugin() {
    override fun onEnable() {
        val manager = PaperCommandManager(this)
        initiateFiles()
        registerCommands()
        registerEvents()
    }

    private fun registerCommands() {

    }

    private fun registerEvents() {

    }

    private fun initiateFiles() {

    }
}