package dev.orf1.foundation.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import org.bukkit.BanList
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class CommandBan : BaseCommand() {
    @CommandAlias("ban")
    @CommandPermission("foundation.ban")
    fun onBan(player: Player, target: String, reason: String) {
        if (Bukkit.getServer().getBanList(BanList.Type.NAME).isBanned(target)) {
            //TODO command-ban-already-banned
            println("command-ban-already-banned")
            return
        }


        if (Bukkit.getPlayer(target) != null) {
            if (Bukkit.getPlayer(target)?.hasPermission("foundation.ban.exempt")!!) {
                //TODO command-ban-target-exempt
                println("command-ban-target-exempt")
                return
            } else if (Bukkit.getPlayer(target)?.isOnline!!) {
                Bukkit.getPlayer(target)?.kickPlayer(reason)
            }
        }
        Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(target, reason, null, player.name)
        //TODO command-ban-success
        println("command-ban-success")
    }
}