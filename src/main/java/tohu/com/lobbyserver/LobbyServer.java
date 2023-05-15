package tohu.com.lobbyserver;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import tohu.com.lobbyserver.Utils.NpcUtil;
import tohu.com.lobbyserver.Worlds.Build;
import tohu.com.lobbyserver.Worlds.Lobby;
import tohu.com.lobbyserver.Worlds.Main;
import tohu.com.lobbyserver.Worlds.Shared;

public final class LobbyServer extends JavaPlugin implements PluginMessageListener {

    @Override
    public void onEnable() {
        // Plugin startup logicP
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        new Lobby(this);
//        new Main(this);
        new Build(this);
        new Shared(this);
        NpcUtil.removeArmorStands(Bukkit.getWorld("world"));
        Location s001Teleport = new Location(Bukkit.getWorld("world"), -1526.495, 4, 517, -179, -0);
        Location p001Teleport = new Location(Bukkit.getWorld("world"), -1526.495, 4, 511, 0, -5);
        Location t001Teleport = new Location(Bukkit.getWorld("world"), -1529.532, 4, 514, -93, 0);
        NpcUtil.setNewArmorStand(s001Teleport, "s001", true);
        NpcUtil.setNewArmorStand(p001Teleport, "p001", true);
        NpcUtil.setNewArmorStand(t001Teleport, "t001", true);
        s001Teleport.add(0, 1, 1);
        p001Teleport.add(0, 1, -1);
        t001Teleport.add(-1, 1, 0);
        NpcUtil.setNewArmorStand(s001Teleport, "ワールド制作用サーバ", false);
        NpcUtil.setNewArmorStand(p001Teleport, "CC,建築用サーバ", false);
        NpcUtil.setNewArmorStand(t001Teleport, "開発中.....", false);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {

    }
}
