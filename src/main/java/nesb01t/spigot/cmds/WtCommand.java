package nesb01t.spigot.cmds;

import nesb01t.spigot.Service;
import nesb01t.spigot.service.alias.AliasService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class WtCommand implements CommandExecutor {
    private AliasService aliasService;

    public WtCommand() {
        aliasService = Service.aliasConfigurator.aliasService;
    }

    enum WtCommandType {
        SET_ALIAS,
        DEL_ALIAS,
        GET_ALIAS,
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!validate(command)) return false;

        WtCommandType type = getCommandType(strings);
        if (Objects.isNull(type)) {
            return false;
        }

        if (type.equals(WtCommandType.SET_ALIAS)) {
            aliasService.setAlias(strings[2], strings[3]);
        }

        if (type.equals(WtCommandType.DEL_ALIAS)) {

        }

        if (type.equals(WtCommandType.GET_ALIAS)) {

        }

        return false;
    }

    private boolean validate(Command cmd) {
        if (!cmd.getName().equalsIgnoreCase("wt")) {
            return false;
        }
        return true;
    }

    private WtCommandType getCommandType(String[] args) {
        if (args.length <= 1 || args[1].equalsIgnoreCase("get")) {
            return WtCommandType.GET_ALIAS;
        } else if (args[1].equalsIgnoreCase("set")) {
            return WtCommandType.SET_ALIAS;
        } else if (args[1].equalsIgnoreCase("del")) {
            return WtCommandType.DEL_ALIAS;
        }
        return null;
    }
}
