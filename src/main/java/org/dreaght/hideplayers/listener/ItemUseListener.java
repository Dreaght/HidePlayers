package org.dreaght.hideplayers.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.dreaght.hideplayers.HidePlayers;
import org.dreaght.hideplayers.util.PlayerHider;
import org.dreaght.hideplayers.util.VisibilityItems;

public class ItemUseListener implements Listener {
    private static final int VISIBILITY_ITEM_SLOT = HidePlayers.getCfg().getSlot();

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();

        ItemStack itemStack = event.getItem();

        if (itemStack == null) {
            return;
        }

        int droppedSlot = event.getPlayer().getInventory().getHeldItemSlot();

        if (!(droppedSlot == VISIBILITY_ITEM_SLOT && (itemStack.isSimilar(VisibilityItems.HIDE_ITEM) ||
                itemStack.isSimilar(VisibilityItems.SHOW_ITEM)))) {
            return;
        }

        VisibilityItems.changeItemState(inventory);

        if (PlayerHider.inHiders(player)) {
            PlayerHider.showAllPlayers(player);
        } else {
            PlayerHider.hideAllPlayers(player);
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack currentItem = event.getCurrentItem();
        int droppedSlot = event.getSlot();

        if (droppedSlot == VISIBILITY_ITEM_SLOT && (currentItem.isSimilar(VisibilityItems.HIDE_ITEM) ||
                currentItem.isSimilar(VisibilityItems.SHOW_ITEM))) {
            event.setResult(Event.Result.DENY);
        }
    }
}
