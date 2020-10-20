package dev.orf1.foundation.data

import dev.orf1.foundation.util.Log
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.lang.Exception

data class DataFile(private val plugin: JavaPlugin, private val name: String) {
    private var data:YamlConfiguration
    private var file = File(plugin.dataFolder, name)

    init {
        try {
            if (!file.exists()) {
                if (plugin.getResource(name) == null) {
                    file.createNewFile()
                } else {
                    plugin.saveResource(name, false)
                }
            }
            Log().info("Successfully loaded datafile $name")
        } catch (exception: Exception) {
            Log().error("A fatal error occurred while loading $name")
            exception.printStackTrace()
        }
        data = YamlConfiguration.loadConfiguration(file)
    }

    internal fun reload() {
        data = YamlConfiguration.loadConfiguration(file)
    }

    internal fun save() {
        data.save(file)
    }

    internal fun get(): YamlConfiguration {
        return data;
    }
}