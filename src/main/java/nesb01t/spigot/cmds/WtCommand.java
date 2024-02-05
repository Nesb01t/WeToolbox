package nesb01t.spigot.cmds;

import nesb01t.spigot.Service;
import nesb01t.spigot.message.MessageHelper;
import nesb01t.spigot.service.alias.AliasService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class WtCommand implements CommandExecutor {
    private AliasService aliasService;

    public WtCommand(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    enum WtCommandType {
        SET_ALIAS,
        DEL_ALIAS,
        GET_ALIAS,
        DEFAULT
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!validate(command)) return false;

        WtCommandType type = getCommandType(strings);
        if (Objects.isNull(type)) {
            return false;
        }

        if (!(commandSender instanceof Player player)) {
            System.out.println("please use this command in game");
            return false;
        }

        if (type.equals(WtCommandType.SET_ALIAS)) {
            var a = aliasService.setAlias(strings[1], strings[2]);
            WtCommandMsg.setAliasSuccess(player, a);
        }

        if (type.equals(WtCommandType.DEL_ALIAS)) {
            var r = aliasService.removeAlias(strings[1]);
            if (r) {
                WtCommandMsg.delAliasSuccess(player, strings[1]);
            } else {
                WtCommandMsg.delAliasFailed(player, strings[1]);
            }
        }

        if (type.equals(WtCommandType.GET_ALIAS)) {
            WtCommandMsg.getAliases(player, aliasService.listAlias());
        }

        if (type.equals(WtCommandType.DEFAULT)) {
            WtCommandMsg.sendUsage(player);
        }

        return true;
    }

    private boolean validate(Command cmd) {
        if (!cmd.getName().equalsIgnoreCase("wt")) {
            return false;
        }
        return true;
    }

    private WtCommandType getCommandType(String[] args) {
        if (args.length == 0 || args[0].equalsIgnoreCase("get")) {
            return WtCommandType.GET_ALIAS;
        } else if (args.length > 2 && args[0].equalsIgnoreCase("set")) {
            return WtCommandType.SET_ALIAS;
        } else if (args.length == 2 && args[0].equalsIgnoreCase("del")) {
            return WtCommandType.DEL_ALIAS;
        }
        return WtCommandType.DEFAULT;
    }
}
