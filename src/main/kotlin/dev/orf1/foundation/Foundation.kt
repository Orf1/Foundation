package dev.orf1.foundation

import co.aikar.commands.PaperCommandManager
import dev.orf1.foundation.commands.CommandBan
import dev.orf1.foundation.commands.CommandFoundation
import dev.orf1.foundation.data.DataFile
import dev.orf1.foundation.util.Log
import org.bukkit.plugin.java.JavaPlugin

class Foundation : JavaPlugin() {
    private lateinit var manager:PaperCommandManager
    private val config = DataFile(this, "config.yml")
    private val data = DataFile(this, "data.yml")

    companion object {
        private lateinit var plugin:JavaPlugin
        @JvmStatic
        internal val lang = DataFile(plugin, "lang.yml")
    }
    override fun onEnable() {
        plugin = this
        manager = PaperCommandManager(this)
        registerCommands()
        registerEvents()

        update()
    }

    private fun registerCommands() {
        manager.registerCommand(CommandFoundation())
        manager.registerCommand(CommandBan())
    }

    private fun registerEvents() {

    }

    private fun update() {
        if (config.get().getString("version") != description.version) {
            Log().warning("Foundation config is outdated.")
        } else {
            Log().info("Foundation config is up to date.")
        }
    }

}