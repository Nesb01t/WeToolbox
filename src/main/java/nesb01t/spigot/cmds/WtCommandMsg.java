package nesb01t.spigot.cmds;

import nesb01t.spigot.message.MessageHelper;
import nesb01t.spigot.service.alias.Alias;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WtCommandMsg {
    public enum WtCommandExecuteStatus {
        SUCCESS,
        FAILED
    }

    public static void sendUsage(Player player) {
        MessageHelper.send(player, "set alias: /wt set &b<alias> &f<command>");
        MessageHelper.send(player, "del alias: /wt del &b<alias>");
        MessageHelper.send(player, "get alias: /wt get");
    }

    public static void setAliasSuccess(Player player, Alias alias) {
        MessageHelper.send(player, "Alias &b" + alias.getName() + " &7set to &f" + alias.getCommand());
    }

    public static void getAliases(Player player, ArrayList<Alias> aliases) {
        if (aliases.isEmpty()) {
            MessageHelper.send(player, "No aliases found, use /wt set &b<alias> &f<command> &7to set one.");
            return;
        }

        MessageHelper.send(player, "Aliases:");
        for (var a : aliases) {
            var message = buildAliasRunMessage(a);
            MessageHelper.sendClickable(player, message);
        }
    }

    public static void delAliasSuccess(Player player, String aliasName) {
        MessageHelper.send(player, "Alias &b" + aliasName + " &7deleted");
    }

    public static void delAliasFailed(Player player, String aliasName) {
        MessageHelper.send(player, "Alias &b" + aliasName + " &7not found");
    }

    private static TextComponent buildAliasRunMessage(Alias a) {
        TextComponent message = new TextComponent("&7 · Alias &b" + a.getName() + "&7 Command &f" + a.getCommand());
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, a.getCommand()));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to run command " + a.getCommand())));
        return message;
    }
}
