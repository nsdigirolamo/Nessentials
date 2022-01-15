package io.github.nsdigirolamo.Nessentials.commands;

import io.github.nsdigirolamo.Nessentials.models.Home;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

import static org.bukkit.Bukkit.getWorld;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            // Check for only one argument passed by player.
            if (args.length == 1) {

                String homeName = args[0];
                ArrayList<Home> homes = HomeStorageUtil.findHomes(player.getUniqueId().toString(), homeName);
                Home foundHome = null;

                for (Home home: homes) {
                    // Check if any of the players homes matches the given home name.
                    if (home.getHomeName().equals(homeName)) {
                        foundHome = home;
                    }
                }

                // Check if the above for loop found any homes.
                if (!(foundHome == null)) {

                        World world = getWorld(UUID.fromString(foundHome.getWorldID()));
                        Location homeLocation = new Location(world, foundHome.getX(), foundHome.getY(), foundHome.getZ());
                        player.teleport(homeLocation);
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);

                } else {
                player.sendMessage(ChatColor.RED + "Home " + homeName + " not found.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid arguments! Proper usage: /home <name>");
            }
            return true;
        }
        return false;
    }
}
