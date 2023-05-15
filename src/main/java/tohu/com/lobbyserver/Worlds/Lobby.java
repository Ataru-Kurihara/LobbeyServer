package tohu.com.lobbyserver.Worlds;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import tohu.com.lobbyserver.LobbyServer;
import tohu.com.lobbyserver.Utils.PlayerUtils;
import tohu.com.lobbyserver.Utils.ServerUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Lobby implements Listener {
    LobbyServer plugin;
    World world;
    public Location spawnPlace, spawnBuildPlace;
    public int SPAWN_X = 1000, SPAWN_Y = 5, SPAWN_Z = 1000;
    public Lobby(LobbyServer plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld("world");
        this.spawnPlace = new Location(world, SPAWN_X, SPAWN_Y, SPAWN_Z);
        this.spawnBuildPlace = new Location(Bukkit.getWorld("build"), -2142 , 11 , 812);
    }

//    @EventHandler
//    public void onPlayerJoinEvent(PlayerChangedWorldEvent e) {
//        Player player = e.getPlayer();
//        World world = player.getWorld();
//        if (world !=  this.world) return;
//        player.teleport(this.spawnPlace);
//        player.sendTitle("Welcome to TohuServer", "", 20, 40, 20);
//        PlayerUtils.setting(player);
//    }

//    @EventHandler
//    public void onPlayerInteractEvent(PlayerInteractEvent e) throws IOException {
//        Player player = e.getPlayer();
//        World world = player.getWorld();
//        ItemStack itemStack = e.getItem();
//        if (this.world != world) return;
//        if (itemStack.getType().equals(Material.WOOD_HOE)) {
//            player.sendMessage("P001Serverに移動します");
//            ServerUtils.move(player, this.plugin, "P001");
//        }
//        if (itemStack.getType().equals(Material.WOOD_AXE)) {
//            player.teleport(this.spawnBuildPlace);
//        }
//    }

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractAtEntityEvent e) throws IOException {
        Player player = e.getPlayer();
        World world = player.getWorld();
        Entity entity = e.getRightClicked();
        if (this.world != world) return;
        if (entity.getType().equals(EntityType.ARMOR_STAND)) {
            if (Objects.equals(entity.getName(), "s001")) {
                player.sendMessage("s001に移動します");
                ServerUtils.move(player, plugin, "s001");
            }
            if (Objects.equals(entity.getName(), "p001")) {
                player.sendMessage("p001に移動します");
                ServerUtils.move(player, plugin, "p001");
            }

        }
    }
}
