package dev.orf1.foundation.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import dev.orf1.foundation.util.Message
import org.bukkit.BanList
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class CommandBan : BaseCommand() {
    @CommandAlias("ban")
    @CommandPermission("foundation.ban")
    fun onBan(player: Player, target: String, reason: String) {
        if (Bukkit.getServer().getBanList(BanList.Type.NAME).isBanned(target)) {
            Message.send(player, "command-ban-already-banned" //TODO Add to lang
                    .replace("%target%", target)
                    .replace("%reason%", reason)
                    .replace("%player%", player.name))
            return
        }

        if (Bukkit.getPlayer(target) != null) {
            if (Bukkit.getPlayer(target)?.hasPermission("foundation.ban.exempt")!!) {
                Message.send(player, "command-ban-exempt" //TODO Add to lang
                        .replace("%target%", target)
                        .replace("%reason%", reason)
                        .replace("%player%", player.name))
                return
            } else if (Bukkit.getPlayer(target)?.isOnline!!) {
                Bukkit.getPlayer(target)?.kickPlayer(reason)
            }
        }

        Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(target, reason, null, player.name)
        Message.send(player, "command-ban-success" //TODO Add to lang
                .replace("%target%", target)
                .replace("%reason%", reason)
                .replace("%player%", player.name))
        Message.broadcast("message-ban", "foundation.ban.notify")
    }
}