package nesb01t.WeToolbox.cmds;

import nesb01t.WeToolbox.service.alias.AliasService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class WtCommand implements CommandExecutor {
    private final AliasService aliasService;

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
        // validate
        if (!validate(command)) return false;
        if (!(commandSender instanceof Player player)) {
            System.out.println("please use this command in game");
            return false;
        }

        // command type (get, del or set)
        WtCommandType type = getCommandType(strings);
        if (Objects.isNull(type)) {
            return false;
        }

        if (type.equals(WtCommandType.SET_ALIAS)) {
            String name = strings[1];
            StringBuilder cmd = new StringBuilder(strings[2]);
            for (int i = 3; i < strings.length; i++) {
                cmd.append(" ").append(strings[i]);
            }

            var a = aliasService.setAlias(name, cmd.toString());
            WtCommandMsg.setAliasSuccess(player, a);
        }

        if (type.equals(WtCommandType.DEL_ALIAS)) {
            String name = strings[1];
            var r = aliasService.removeAlias(name);
            if (r) {
                WtCommandMsg.delAliasSuccess(player, name);
            } else {
                WtCommandMsg.delAliasFailed(player, name);
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
