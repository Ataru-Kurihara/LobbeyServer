package tohu.com.lobbyserver.Utils;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerUtils {
    public static void setting(Player player) {

        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
        ItemStack hoe = new ItemStack(Material.WOOD_HOE, 1);
        ItemStack axe = new ItemStack(Material.WOOD_AXE, 1);
        hoe.getItemMeta().setDisplayName("サーバS001");
        axe.getItemMeta().setDisplayName("建築ワールド");
//        player.getInventory().addItem(hoe);
//        player.getInventory().addItem(axe);
    }
    public static void setStatus(Player player) {
        player.setFoodLevel(20);
        player.setHealth(20);
    }
}
