package io.github.nsdigirolamo.Nessentials;

import io.github.nsdigirolamo.Nessentials.commands.*;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;

public final class Nessentials extends JavaPlugin {

    public static Nessentials plugin;

    @Override
    public void onEnable() {

        plugin = this;
        this.getCommand("createhome").setExecutor(new CreateHomeCommand());
        this.getCommand("deletehome").setExecutor(new DeleteHomeCommand());
        this.getCommand("homes").setExecutor(new HomesCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("ping").setExecutor(new PingCommand());

        try {
            HomeStorageUtil.loadHomes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        getLogger().info(ChatColor.GREEN + "Nessentials is now enabled!");
    }

    public static Nessentials getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.YELLOW + "Nessentials is now disabled!");
    }
}
