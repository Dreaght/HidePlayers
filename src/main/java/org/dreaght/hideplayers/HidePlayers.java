package org.dreaght.hideplayers;

import org.bukkit.plugin.java.JavaPlugin;
import org.dreaght.hideplayers.listener.InventoryListener;
import org.dreaght.hideplayers.listener.DropListener;
import org.dreaght.hideplayers.listener.ItemUseListener;
import org.dreaght.hideplayers.listener.JoinListener;

public final class HidePlayers extends JavaPlugin {
    private static Config config;

    public static Config getCfg() {
        return config;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        config = new Config(this);

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new ItemUseListener(), this);
        getServer().getPluginManager().registerEvents(new DropListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }
}
