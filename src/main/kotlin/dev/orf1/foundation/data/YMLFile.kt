package dev.orf1.foundation.data

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class YMLFile(plugin: JavaPlugin, name: String) : YamlConfiguration() {
    private val file = File(name)
    init {
        if (!file.exists()) {
            if (plugin.getResource(name) == null) {
                file.createNewFile()
            } else {
                plugin.saveResource(name, false)
            }
        }
    }
    private var config = YamlConfiguration().load(file)
    override fun save(file: File) {
        super.save(this.file)
    }
    fun reload() {
        config = YamlConfiguration().load(file)
    }
}