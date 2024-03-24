package org.dreaght.hideplayers.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.dreaght.hideplayers.Config;
import org.dreaght.hideplayers.HidePlayers;
import org.dreaght.hideplayers.utils.VisibilityItems;

public class OnItemDrop implements Listener {
    private static final int VISIBILITY_ITEM_SLOT = HidePlayers.getCfg().getSlot();

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack itemStack = event.getItemDrop().getItemStack();

        int droppedSlot = event.getPlayer().getInventory().getHeldItemSlot();

        if (droppedSlot == VISIBILITY_ITEM_SLOT &&
                (itemStack.isSimilar(VisibilityItems.HIDE_ITEM) || itemStack.isSimilar(VisibilityItems.SHOW_ITEM))) {
            event.setCancelled(true);
        }
    }
}
