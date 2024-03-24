package org.dreaght.hideplayers.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;
import org.dreaght.hideplayers.Config;
import org.dreaght.hideplayers.HidePlayers;
import org.dreaght.hideplayers.utils.PlayerHider;
import org.dreaght.hideplayers.utils.VisibilityItems;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        handleJoining(event);
    }

    @EventHandler
    public void onWorldLoad(PlayerChangedWorldEvent event) {
        handleJoining(event);
    }

    private void handleJoining(PlayerEvent event) {
        Player player = event.getPlayer();

        if (!player.getWorld().getName().equals(HidePlayers.getCfg().getWorldName())) {
            return;
        }

        PlayerInventory inventory = player.getInventory();

        if (PlayerHider.inHiders(player)) {
            PlayerHider.hideAllPlayers(player);
            VisibilityItems.giveShowItemToPlayer(inventory);
        } else {
            VisibilityItems.giveHideItemToPlayer(inventory);
        }

        PlayerHider.addPlayerToAllHidden(player);
    }
}
