package io.github.nsdigirolamo.Nessentials.models;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Home {

    private final String id;
    private String playerName;
    private String playerID;
    private String homeName;
    private double x;
    private double y;
    private double z;
    private String worldID;

    public Home(Player player, String homeName, Location location) {
        this.id = UUID.randomUUID().toString();
        this.playerName = player.getPlayerListName();
        this.playerID = player.getUniqueId().toString();
        this.homeName = homeName;
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.worldID = location.getWorld().getUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getWorldID() {
        return worldID;
    }

    public void setWorldID(String worldID) {
        this.worldID = worldID;
    }
}
