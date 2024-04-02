package org.dreaght.hideplayers.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.dreaght.hideplayers.HidePlayers;

public class VisibilityItems {
    public static Plugin plugin;

    private static final int VISIBILITY_ITEM_SLOT = HidePlayers.getCfg().getSlot();

    public static final ItemStack HIDE_ITEM = createItemStack(Material.LIME_DYE, 1, HidePlayers.getCfg().getItemName("hide-item-name"));
    public static final ItemStack SHOW_ITEM = createItemStack(Material.RED_DYE, 1, HidePlayers.getCfg().getItemName("show-item-name"));

    public VisibilityItems(Plugin plugin) {
        this.plugin = plugin;
    }

    // From hide to show and vice versa
    public static boolean changeItemState(PlayerInventory inventory) {
        ItemStack currentItem = inventory.getItem(VISIBILITY_ITEM_SLOT);
        if (currentItem != null) {
            inventory.setItem(VISIBILITY_ITEM_SLOT, currentItem.isSimilar(HIDE_ITEM) ? SHOW_ITEM : HIDE_ITEM);
            return inventory.getItem(VISIBILITY_ITEM_SLOT).isSimilar(SHOW_ITEM); // true -> hide players
        } else {
            inventory.setItem(VISIBILITY_ITEM_SLOT, HIDE_ITEM);
            return false;
        }
    }

    public static void giveHideItemToPlayer(PlayerInventory inventory) {
        inventory.setItem(VISIBILITY_ITEM_SLOT, HIDE_ITEM);
    }

    public static void giveShowItemToPlayer(PlayerInventory inventory) {
        inventory.setItem(VISIBILITY_ITEM_SLOT, SHOW_ITEM);
    }

    private static ItemStack createItemStack(Material material, int amount, String displayName) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
