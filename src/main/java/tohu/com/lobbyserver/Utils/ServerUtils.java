package tohu.com.lobbyserver.Utils;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tohu.com.lobbyserver.LobbyServer;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerUtils {
    public static void move(Player player, LobbyServer plugin, String serverName) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeUTF("Connect");
            dos.writeUTF(serverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(plugin, "BungeeCord", baos.toByteArray());
        baos.close();
        dos.close();
    }
}
