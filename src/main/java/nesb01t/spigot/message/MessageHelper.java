package nesb01t.spigot.message;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageHelper {
    public static void send(Player player, String msg) {
        player.sendMessage(MessageConfigurator.prefix + msg);
    }

    public static void send(CommandSender sender, String msg) {
        send((Player) sender, msg);
    }
}
