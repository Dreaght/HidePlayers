package org.dreaght.hideplayers;

import org.bukkit.plugin.java.JavaPlugin;
import org.dreaght.hideplayers.listeners.OnInventoryClear;
import org.dreaght.hideplayers.listeners.OnItemDrop;
import org.dreaght.hideplayers.listeners.OnItemUse;
import org.dreaght.hideplayers.listeners.OnJoin;

public final class HidePlayers extends JavaPlugin {
    private static HidePlayers instance;

    public static HidePlayers getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();
        new Config().resetConfig();

        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new OnItemUse(this), this);
        getServer().getPluginManager().registerEvents(new OnItemDrop(), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClear(), this);
    }
}
