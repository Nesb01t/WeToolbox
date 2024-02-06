package nesb01t.spigot.message;

import nesb01t.spigot.service.alias.Alias;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageHelper {
    public static void send(Player player, String msg) {
        String string = MessageConfigurator.prefix + msg;

        string = colorize(string);
        player.sendMessage(string);
    }

    public static void send(CommandSender sender, String msg) {
        send((Player) sender, msg);
    }

    public static void sendClickable(Player player, TextComponent message) {
        message.setText(colorize(message.getText()));
        player.spigot().sendMessage(message);
    }

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
