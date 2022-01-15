package io.github.nsdigirolamo.Nessentials.commands;

import io.github.nsdigirolamo.Nessentials.Nessentials;
import io.github.nsdigirolamo.Nessentials.models.Home;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateHomeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            int maxHomes = Nessentials.getPlugin().getConfig().getInt("maxHomes");
            Player player = (Player) sender;
            String playerID = player.getUniqueId().toString();
            Location location = player.getLocation();

            // Check for only one argument passed by player.
            if (args.length == 1) {

                String homeName = args[0];

                // Check if player already has a home with the given name.
                if (HomeStorageUtil.findHomes(playerID, homeName).isEmpty()) {
                    // Check if player has fewer than the maximum allowed homes.
                    if (maxHomes > HomeStorageUtil.findHomes(playerID).size()) {

                        Home home = HomeStorageUtil.createHome(player, homeName, location);
                        player.sendMessage(ChatColor.GREEN + "Created home "  + home.getHomeName() + " successfully!");

                    } else {
                        player.sendMessage(ChatColor.RED + "Home creation failed. You have reached the maximum number of homes.");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Home " + args[0] + " already exists!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Too many arguments! Proper usage: /createhome <name>");
            }

            return true;
        }

        return false;
    }
}
