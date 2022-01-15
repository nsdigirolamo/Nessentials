package io.github.nsdigirolamo.Nessentials.commands;

import io.github.nsdigirolamo.Nessentials.models.Home;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateHomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            String displayName = player.getDisplayName();
            String playerID = player.getUniqueId().toString();
            double xPosition = player.getLocation().getX();
            double yPosition = player.getLocation().getY();
            double zPosition = player.getLocation().getZ();

            if (args.length == 1) {
                if (HomeStorageUtil.findHomes(playerID, args[0]).isEmpty()) {
                    Home home = HomeStorageUtil.createHome(player, args[0], xPosition, yPosition, zPosition);
                    player.sendMessage(ChatColor.GREEN + "Created home "  + home.getHomeName() + " successfully!");
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
