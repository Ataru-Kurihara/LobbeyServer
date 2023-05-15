package tohu.com.lobbyserver.Utils;

import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class NpcUtil {
    public static void setNewArmorStand(Location location, String text, boolean visible) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setBasePlate(false);
        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName(text);
        armorStand.setArms(true);
        armorStand.setVisible(visible);
        armorStand.setInvulnerable(true);
        armorStand.setCanPickupItems(true);
        armorStand.setGravity(false);
        armorStand.setItemInHand(null);
    }

    public static void removeArmorStands(World world) {
        for (Entity entity: world.getEntities()) {
            if (entity instanceof ArmorStand) {
                entity.remove();
            }
        }
    }
}
