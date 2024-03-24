package org.dreaght.hideplayers;

import org.bukkit.plugin.java.JavaPlugin;
import org.dreaght.hideplayers.listeners.OnInventoryClear;
import org.dreaght.hideplayers.listeners.OnItemDrop;
import org.dreaght.hideplayers.listeners.OnItemUse;
import org.dreaght.hideplayers.listeners.OnJoin;

public final class HidePlayers extends JavaPlugin {
    private static Config config;

    public static Config getCfg() {
        return config;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        config = new Config(this);

        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new OnItemUse(), this);
        getServer().getPluginManager().registerEvents(new OnItemDrop(), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClear(), this);
    }
}
