package io.github.daruma256.testplugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;

import java.util.ArrayList;

public class EventListener implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.sendMessage("Thanks for reading the bug report.");
        player.sendMessage("");

        ItemStack itemStack = new ItemStack(Material.STICK);

        ItemMeta itemMeta = itemStack.getItemMeta();

        CustomModelDataComponent component = itemMeta.getCustomModelDataComponent();

        ArrayList<String> list = new ArrayList<>();
        list.add("test");

        component.setStrings(list);

        itemMeta.setCustomModelDataComponent(component);

        itemStack.setItemMeta(itemMeta);

        player.getInventory().addItem(itemStack);

        player.sendMessage("For example, if you drop this item and check it by");
        player.sendMessage(ChatColor.GREEN + "/data get entity @e[type=item, distance=. .5, limit=1]");
        player.sendMessage("the value of custom_model_data is blank.");
    }
}
