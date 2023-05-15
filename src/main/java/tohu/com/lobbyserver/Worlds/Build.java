package tohu.com.lobbyserver.Worlds;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import tohu.com.lobbyserver.LobbyServer;

//mod無しで建築遊ぶ場所
public class Build implements Listener {
    LobbyServer plugin;
    World world;

    public Location spawnPlace;
    public int SPAWN_X = 1000, SPAWN_Y = 5, SPAWN_Z = 1000;
    public Build(LobbyServer plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld("build");
        this.spawnPlace = new Location(world, SPAWN_X, SPAWN_Y, SPAWN_Z);

    }

    @EventHandler
    public void onChangedWorldEvent(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (world != this.world) return;
        player.getInventory().clear();
        player.setGameMode(GameMode.CREATIVE);
        player.sendTitle("建築ワールド", "建築楽しんで！", 20, 40, 20);
        player.sendMessage("前までの建築ワールドは、サーバP001に移行しました");
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        Block block = e.getBlock();
        if (world != this.world) return;
        if (block.getType().equals(Material.TNT)) e.setCancelled(true);
        if (block.getType().equals(Material.LAVA)) e.setCancelled(true);
    }
}
