package dev.orf1.foundation

import co.aikar.commands.PaperCommandManager
import dev.orf1.foundation.commands.CommandBan
import dev.orf1.foundation.commands.CommandFoundation
import dev.orf1.foundation.data.DataFile
import dev.orf1.foundation.util.Log
import org.bukkit.plugin.java.JavaPlugin

class Foundation : JavaPlugin() {
    internal companion object {
        @JvmStatic
        internal lateinit var plugin:JavaPlugin
        internal lateinit var manager:PaperCommandManager
        internal val lang = DataFile(plugin, "lang.yml")
        internal val settings = DataFile(plugin, "config.yml")
        internal val data = DataFile(plugin, "data.yml")
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
        if (settings.get().getString("version") != description.version) {
            Log.warning("Foundation config is outdated.")
        } else {
            Log.info("Foundation config is up to date.")
        }
    }

}