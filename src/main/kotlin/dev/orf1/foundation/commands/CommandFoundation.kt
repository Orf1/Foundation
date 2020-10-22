package dev.orf1.foundation.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.Default
import co.aikar.commands.annotation.Subcommand
import co.aikar.commands.annotation.Description
import dev.orf1.foundation.util.Chat
import org.bukkit.entity.Player

class CommandFoundation : BaseCommand() {
    @CommandAlias("help")
    @Description("Displays Foundation help page.")
    @Default
    fun onHelp(player: Player){
    }
}