package nesb01t.spigot.message;

import org.bukkit.entity.Player;

public class MessageHelper {
    public static void send(Player player, String msg) {
        player.sendMessage(MessageConfigurator.prefix + msg);
    }
}
