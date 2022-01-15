package io.github.nsdigirolamo.Nessentials.commands;

import io.github.nsdigirolamo.Nessentials.models.Home;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class DeleteHomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            // Check for only one argument passed by player.
            if (args.length == 1) {

                ArrayList<Home> homes = HomeStorageUtil.findHomes(player.getUniqueId().toString(), args[0]);

                // Check if a home was found with the given name.
                if (!homes.isEmpty()) {

                    HomeStorageUtil.deleteHome(homes.get(0).getId());
                    player.sendMessage(ChatColor.YELLOW + "Deleted home "  + homes.get(0).getHomeName() + " successfully.");

                } else {
                    player.sendMessage(ChatColor.RED + "Home " + args[0] + " does not exist.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid arguments! Proper usage: /deletehome <name>");
            }
            return true;
        }
        return false;
    }
}
