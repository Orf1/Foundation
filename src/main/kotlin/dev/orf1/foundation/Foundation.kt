package dev.orf1.foundation

import co.aikar.commands.PaperCommandManager
import dev.orf1.foundation.data.YMLFile
import org.bukkit.plugin.java.JavaPlugin

class Foundation : JavaPlugin() {
    private val config = YMLFile(this, "config")
    internal val data = YMLFile(this, "data")

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