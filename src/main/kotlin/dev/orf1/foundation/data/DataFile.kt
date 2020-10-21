package dev.orf1.foundation.data

import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.lang.Exception

data class DataFile(private val plugin: JavaPlugin, private val name: String) {
    private lateinit var data:YamlConfiguration
    private val file = File(plugin.dataFolder, name)

    init {
        try {
            if (!file.exists()) {
                if (plugin.getResource(name) == null) {
                    file.createNewFile()
                } else {
                    plugin.saveResource(name, false)
                }
            }
            info("Successfully initialized datafile $name")
        } catch (exception: Exception) {
            error("A fatal error occurred while initializing datafile $name")
            exception.printStackTrace()
        }
        try {
            data = YamlConfiguration.loadConfiguration(file)
            info("Successfully loaded datafile $name")
        } catch (exception: Exception) {
            error("A fatal error occurred while loading datafile $name")
            exception.printStackTrace()
        }
    }

    internal fun reload() {
        try {
            data = YamlConfiguration.loadConfiguration(file)
            info("Successfully reloaded datafile $name")
        } catch (exception: Exception) {
            error("A fatal error occurred while reloading datafile $name")
            exception.printStackTrace()
        }
    }

    internal fun save() {
        try {
            data.save(file)
            info("Successfully saved datafile $name")
        } catch (exception: Exception) {
            error("A fatal error occurred while saving datafile $name")
            exception.printStackTrace()
        }
    }

    internal fun get(): YamlConfiguration {
        return data;
    }

    private fun info(message: String) {
        Bukkit.getLogger().info(message)
    }

    private fun warning(message: String) {
        Bukkit.getLogger().warning(message)
    }

    private fun error(message: String) {
        Bukkit.getLogger().severe(message)
    }
}