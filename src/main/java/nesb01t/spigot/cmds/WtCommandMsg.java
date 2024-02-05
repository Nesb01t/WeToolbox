package nesb01t.spigot.cmds;

import nesb01t.spigot.message.MessageHelper;
import nesb01t.spigot.service.alias.Alias;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WtCommandMsg {
    public enum WtCommandExecuteStatus {
        SUCCESS,
        FAILED
    }

    public static void sendUsage(Player player) {
        MessageHelper.send(player, "set alias: /wt set <alias> <command>");
        MessageHelper.send(player, "del alias: /wt del <alias>");
        MessageHelper.send(player, "get alias: /wt get");
    }

    public static void setAliasSuccess(Player player, Alias alias) {
        MessageHelper.send(player, "Alias " + alias.getAlias() + " set to " + alias.getCommand());
    }

    public static void getAliases(Player player, ArrayList<Alias> aliases) {
        if (aliases.isEmpty()) {
            MessageHelper.send(player, "No aliases found, use /wt set <alias> <command> to set one.");
            return;
        }

        MessageHelper.send(player, "Aliases:");
        for (var a : aliases) {
            MessageHelper.send(player, "  Alias: " + a.getAlias() + " Command: " + a.getCommand());
        }
    }

    public static void delAliasSuccess(Player player, String aliasName) {
        MessageHelper.send(player, "Alias " + aliasName + " deleted");
    }

    public static void delAliasFailed(Player player, String aliasName) {
        MessageHelper.send(player, "Alias " + aliasName + " not found");
    }
}
