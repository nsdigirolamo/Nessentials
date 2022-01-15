package io.github.nsdigirolamo.Nessentials;

import io.github.nsdigirolamo.Nessentials.commands.*;
import io.github.nsdigirolamo.Nessentials.tabcompletions.HomeTabCompletion;
import io.github.nsdigirolamo.Nessentials.tabcompletions.DeleteHomeTabCompletion;
import io.github.nsdigirolamo.Nessentials.utils.HomeStorageUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;

public final class Nessentials extends JavaPlugin {

    private FileConfiguration config = getConfig();
    public static Nessentials plugin;

    @Override
    public void onEnable() {
        config.addDefault("maxHomes", 10);
        config.options().copyDefaults(true);
        saveConfig();

        plugin = this;
        this.getCommand("createhome").setExecutor(new CreateHomeCommand());
        this.getCommand("deletehome").setExecutor(new DeleteHomeCommand());
        this.getCommand("deletehome").setTabCompleter(new DeleteHomeTabCompletion());
        this.getCommand("homes").setExecutor(new HomesCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("home").setTabCompleter(new HomeTabCompletion());
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
