package io.github.nsdigirolamo.Nessentials.commands;

import io.github.nsdigirolamo.Nessentials.models.Home;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {

                String homeName = args[0];
                ArrayList<Home> homes = HomeStorageUtil.findHomes(player.getUniqueId().toString(), homeName);

                for (Home home: homes) {
                    if (home.getHomeName().equals(homeName)) {
                        Location homeLocation = new Location(player.getWorld(), home.getxPosition(), home.getyPosition(), home.getzPosition());
                        player.teleport(homeLocation);
                    }
                }

            } else {
                player.sendMessage(ChatColor.RED + "Invalid arguments! Proper usage: /home <name>");
            }

            return true;
        }
        return false;
    }
}
