package io.github.nsdigirolamo.Nessentials.commands;

import io.github.nsdigirolamo.Nessentials.models.Home;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class HomesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            ArrayList<Home> homes = HomeStorageUtil.findHomes(player.getUniqueId().toString());
            ArrayList<String> homeNames = new ArrayList<>();

            for (Home home: homes) {
                homeNames.add(home.getHomeName());
            }

            player.sendMessage(ChatColor.GREEN + player.getDisplayName() + " Homes: " + homeNames);
            return true;
        }

        return false;
    }
}
