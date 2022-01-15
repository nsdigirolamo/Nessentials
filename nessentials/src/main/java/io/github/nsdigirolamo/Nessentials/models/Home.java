package io.github.nsdigirolamo.Nessentials.models;

import java.util.UUID;

public class Home {

    private String id;
    private String playerName;
    private String playerID;
    private String homeName;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public Home(String playerName, String playerID, String homeName, double xPosition, double yPosition, double zPosition) {
        this.id = UUID.randomUUID().toString();
        this.playerName = playerName;
        this.playerID = playerID;
        this.homeName = homeName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.zPosition = zPosition;
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

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getzPosition() {
        return zPosition;
    }

    public void setzPosition(double zPosition) {
        this.zPosition = zPosition;
    }
}
