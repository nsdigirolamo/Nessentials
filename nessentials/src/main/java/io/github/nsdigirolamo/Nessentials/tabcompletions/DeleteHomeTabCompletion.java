package io.github.nsdigirolamo.Nessentials.tabcompletions;

import io.github.nsdigirolamo.Nessentials.models.Home;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DeleteHomeTabCompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1 && sender instanceof Player) {

            Player player = (Player) sender;
            ArrayList<Home> homes = HomeStorageUtil.findHomes(player.getUniqueId().toString());
            List<String> homeNames = new ArrayList<String>();

            for(Home home: homes) {
                homeNames.add(home.getHomeName());
            }

            return homeNames;
        }
        return null;
    }
}
