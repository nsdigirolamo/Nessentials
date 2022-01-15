package io.github.nsdigirolamo.Nessentials.utils;

import com.google.gson.Gson;
import io.github.nsdigirolamo.Nessentials.Nessentials;
import io.github.nsdigirolamo.Nessentials.models.Home;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.bukkit.Bukkit.getLogger;

public class HomeStorageUtil {

    private static ArrayList<Home> homes = new ArrayList<>();

    /**
     * Creates a new home.
     * @param player The player the home belongs to.
     * @param homeName The name of the home.
     * @param xPosition The x position of the home.
     * @param yPosition The y position of the home.
     * @param zPosition The z position of the home.
     * @return The newly created home.
     */
    public static Home createHome(Player player, String homeName, double xPosition, double yPosition, double zPosition) {

        Home home = new Home(player.getDisplayName(), player.getUniqueId().toString(), homeName, xPosition, yPosition, zPosition);
        homes.add(home);

        try {
            saveHomes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return home;
    }

    /**
     * Reads a home.
     * @param id The id of the home.
     * @return The home if the id is valid. Null if the id is invalid.
     */
    public static Home readHome(String id) {

        for (Home home: homes) {
            if (home.getId().equalsIgnoreCase(id)) {
                return home;
            }
        }

        return null;
    }

    /**
     * Find homes with the given playerID.
     * @param playerID The playerID of the homes.
     * @return An ArrayList of homes with matching playerID and homeName if they are found. Null if no matching homes were found.
     */
    public static ArrayList<Home> findHomes(String playerID) {

        ArrayList<Home> foundHomes = new ArrayList<>();

        for (Home home: homes) {
            if (home.getPlayerID().equals(playerID)) {
                foundHomes.add(home);
            }
        }

        return foundHomes;
    }

    /**
     * Find homes with the given playerID and homeName.
     * @param playerID The playerID of the home.
     * @param homeName The name of the home.
     * @return An ArrayList of homes with matching playerID and homeName if they are found. Null if no matching homes were found.
     */
    public static ArrayList<Home> findHomes(String playerID, String homeName) {

        ArrayList<Home> foundHomes = new ArrayList<>();

        for (Home home: homes) {
            if (home.getPlayerID().equals(playerID) && home.getHomeName().equals(homeName)) {
                foundHomes.add(home);
            }
        }

        return foundHomes;
    }

    /**
     * Updates a home with new variables.
     * @param id The id of the home to be updated.
     * @param newHome The new home.
     * @return The newly updated home if the id is valid. Null if the id is invalid.
     */
    public static Home updateHome(String id, Home newHome) {

        for (Home home: homes) {
            if (home.getId().equalsIgnoreCase(id)) {
                home.setPlayerName(newHome.getPlayerName());
                home.setHomeName(newHome.getHomeName());
                home.setxPosition(newHome.getxPosition());
                home.setyPosition(newHome.getxPosition());
                home.setzPosition(newHome.getxPosition());

                try {
                    saveHomes();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return home;
            }
        }

        return null;
    }

    /**
     * Deletes a home.
     * @param id The id of the home to be deleted.
     */
    public static void deleteHome(String id) {

        for (Home home: homes) {
            if (home.getId().equalsIgnoreCase(id)) {
                homes.remove(home);
                break;
            }
        }

        try {
            saveHomes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves homes to homes.json
     * @throws IOException
     */
    public static void saveHomes() throws IOException {

        Gson gson = new Gson();
        // Find path to our plugin's data folder and create a new homes.json file there.
        File file = new File(Nessentials.getPlugin().getDataFolder().getAbsolutePath() + "/homes.json");
        // Create the parent directory if it doesn't already exist.
        file.getParentFile().mkdir();
        // Create homes.json
        file.createNewFile();

        // New writer for our homes.json file.
        // append is false because we will be rewriting it each time.
        Writer writer = new FileWriter(file, false);

        gson.toJson(homes, writer);
        writer.flush();
        writer.close();
        getLogger().info(ChatColor.GREEN + "[Nessentials] homes.json saved.");
    }

    /**
     * Loads homes from homes.json
     * @throws FileNotFoundException
     */
    public static void loadHomes() throws FileNotFoundException {

        Gson gson = new Gson();
        File file = new File(Nessentials.getPlugin().getDataFolder().getAbsolutePath() + "/homes.json");

        if (file.exists()) {
            Reader reader = new FileReader(file);
            Home[] h = gson.fromJson(reader, Home[].class);
            homes = new ArrayList<>(Arrays.asList(h));
            getLogger().info(ChatColor.GREEN + "[Nessentials] homes.json loaded.");

        }
    }
}
