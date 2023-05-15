package tohu.com.lobbyserver.Worlds;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import tohu.com.lobbyserver.LobbyServer;

public class Main implements Listener {
    LobbyServer plugin;
    World world;
    public Location spawnPlace;
    public int SPAWN_X = -1527, SPAWN_Y = 4, SPAWN_Z = 514;
    public Main(LobbyServer plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld("world");
        this.spawnPlace = new Location(world, SPAWN_X, SPAWN_Y, SPAWN_Z);
    }

    @EventHandler
    public void onPlayerChangeWorldEvent(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        ItemStack iron_pickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemStack wood = new ItemStack(Material.WOOD, 1);
        iron_pickaxe.getItemMeta().setDisplayName("サバイバルワールド");
        wood.getItemMeta().setDisplayName("建築ワールド");
        if (this.world != world) return;
        player.getInventory().clear();
        player.getInventory().addItem(iron_pickaxe);
        player.getInventory().addItem(wood);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        ItemStack itemStack = e.getItem();
        Location survival = new Location(Bukkit.getWorld("s"), 507, 67, 226);
        Location build = new Location(Bukkit.getWorld("build"), -2143, 11, 812);
        if (this.world != world) return;
        if (itemStack.getType().equals(Material.IRON_PICKAXE)) player.teleport(survival);
        if (itemStack.getType().equals(Material.WOOD)) player.teleport(build);
        if (e.getAction() == Action.PHYSICAL) {

        }
    }
}
