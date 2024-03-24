package org.dreaght.hideplayers.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.PlayerInventory;
import org.dreaght.hideplayers.utils.PlayerHider;
import org.dreaght.hideplayers.utils.VisibilityItems;

public class OnInventoryClear implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        PlayerInventory inventory = player.getInventory();

        if (inventory.equals(player.getInventory())) {
            if (player.getInventory().isEmpty()) {
                if (PlayerHider.inHiders(player)) {
                    VisibilityItems.giveShowItemToPlayer(inventory);
                } else {
                    VisibilityItems.giveHideItemToPlayer(inventory);
                }
            }
        }
    }
}
