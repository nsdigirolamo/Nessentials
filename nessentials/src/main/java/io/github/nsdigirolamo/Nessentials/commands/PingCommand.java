package io.github.nsdigirolamo.Nessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            int ping = player.getPing();
            ChatColor pingColor;

            if (ping < 50) {
                pingColor = ChatColor.DARK_GREEN;
            } else if (ping < 200) {
                pingColor = ChatColor.GREEN;
            } else if (ping < 500) {
                pingColor = ChatColor.YELLOW;
            } else if (ping < 1000) {
                pingColor = ChatColor.RED;
            } else {
                pingColor = ChatColor.DARK_RED;
            }

            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 10);
            player.sendMessage(ChatColor.ITALIC + "Pong! Your ping is " + pingColor + ping + " ms");

            return true;
        }

        return false;
    }
}
