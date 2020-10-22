package dev.orf1.foundation

import co.aikar.commands.PaperCommandManager
import dev.orf1.foundation.commands.CommandBan
import dev.orf1.foundation.commands.CommandFoundation
import dev.orf1.foundation.data.DataFile
import dev.orf1.foundation.enums.Lang
import dev.orf1.foundation.util.Log
import org.bukkit.plugin.java.JavaPlugin

class Foundation : JavaPlugin() {
    internal companion object {
        @JvmStatic
        internal lateinit var plugin: JavaPlugin
        internal lateinit var manager: PaperCommandManager
        internal lateinit var lang: DataFile
        internal lateinit var settings: DataFile
        internal lateinit var data: DataFile
    }

    override fun onEnable() {
        plugin = this
        manager = PaperCommandManager(this)
        lang = DataFile(plugin, "lang.yml")
        data = DataFile(plugin, "data.yml")
        settings = DataFile(plugin, "config.yml")
        registerCommands()
        registerEvents()
        updateConfig()
        verifyLangIntegrity()
    }

    private fun registerCommands() {
        manager.registerCommand(CommandFoundation())
        manager.registerCommand(CommandBan())
    }

    private fun registerEvents() {

    }

    private fun updateConfig() {
        if (settings.get().getString("version") != description.version) {
            Log.warning("Foundation config is outdated.")
        } else {
            Log.info("Foundation config is up to date.")
        }
    }

    private fun verifyLangIntegrity() {
        var invalid = false
        Lang.values().forEach { lang: Lang ->
            if (lang.message == null) {
                invalid = true
                Log.warning("Lang entry: ${lang.path} is missing, null, or corrupted.")
            }
        }
        if (invalid) {
            Log.error("One or more lang.yml entries are missing, null, or corrupted. Please re-generate the lang.yml.")
        } else {
            Log.info("Lang integrity verified.")
        }
    }
}