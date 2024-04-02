package org.dreaght.hideplayers.util;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PlayerHider {
    private static HashMap<Player, HashSet<Player>> hiddenPlayers = new HashMap<>();

    public static boolean inHiders(Player player) {
        return hiddenPlayers.containsKey(player);
    }

    public static void hideAllPlayers(Player player) {
        for (Player targetPlayer : player.getServer().getOnlinePlayers()) {
            if (targetPlayer != player) {
                player.hidePlayer(targetPlayer);
                addHiddenPlayer(player, targetPlayer);
            }
        }
    }

    public static void showAllPlayers(Player player) {
        if (hiddenPlayers.containsKey(player)) {
            for (Player hiddenPlayer : hiddenPlayers.get(player)) {
                player.showPlayer(hiddenPlayer);
            }
            hiddenPlayers.remove(player);
        }
    }

    public static void addHiddenPlayer(Player hider, Player hidden) {
        if (!hiddenPlayers.containsKey(hider)) {
            hiddenPlayers.put(hider, new HashSet<>());
        }
        hiddenPlayers.get(hider).add(hidden);
    }

    public static void addPlayerToAllHidden(Player playerToAdd) {
        for (Map.Entry<Player, HashSet<Player>> entry : hiddenPlayers.entrySet()) {
            Player key = entry.getKey();
            HashSet<Player> value = entry.getValue();

            if (playerToAdd.equals(key)) {
                return;
            }

            value.add(playerToAdd);
            key.hidePlayer(playerToAdd);
        }
    }
}
