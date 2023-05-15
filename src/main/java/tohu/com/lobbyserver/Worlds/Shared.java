package tohu.com.lobbyserver.Worlds;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tohu.com.lobbyserver.LobbyServer;
import tohu.com.lobbyserver.Utils.PlayerUtils;

public class Shared implements Listener {
    LobbyServer plugin;
    World world;
    public Location spawnPlace;
    public int SPAWN_X = -1521, SPAWN_Y = 4, SPAWN_Z = 514;
    public Shared(LobbyServer plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld("world");
        this.spawnPlace = new Location(world, SPAWN_X, SPAWN_Y, SPAWN_Z, 88, 2);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);
        player.teleport(this.spawnPlace);
        PlayerUtils.setting(player);
        PlayerUtils.setStatus(player);
        player.sendTitle("とーふへようこそ", "Welcome to To-hu", 20, 40, 20);
        player.sendMessage("移動したいサーバのアーマースタンドをクリックしよう！");
    }
}
