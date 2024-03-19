package org.dreaght.hideplayers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
    private Plugin plugin = HidePlayers.getInstance();
    private FileConfiguration config = plugin.getConfig();

    public void resetConfig() {
        if (config.getString("world-name") == null) {
            config.set("world-name", plugin.getServer().getWorlds().get(0).getName());
        }
        if (config.getString("hide-item-name") == null) {
            config.set("hide-item-name", "§fPlayers: §cHidden §7(Right Click)");
        }
        if (config.getString("show-item-name") == null) {
            config.set("show-item-name", "§fPlayers: §aVisible §7(Right Click)");
        }
        if (config.getString("slot") == null) {
            config.set("slot", 7);
        }

        plugin.saveConfig();
    }

    public String getWorldName() {
        return config.getString("world-name");
    }

    public String getItemName(String configLine) {
        return config.getString(configLine);
    }

    public int getSlot() {
        return config.getInt("slot");
    }
}
