package nesb01t.spigot.cmds;

import nesb01t.spigot.WeToolbox;
import nesb01t.spigot.service.alias.AliasService;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

public class CmdConfigurator {
    public CmdConfigurator(AliasService aliasService) {
        reg("wt", new WtCommand(aliasService));
    }

    private static void reg(String cmdName, CommandExecutor cmdExecutor) {
        // init commands
        var cmd = WeToolbox.Instance.getCommand(cmdName);
        if (Objects.isNull(cmd)) {
            return;
        }

        cmd.setExecutor(cmdExecutor);
    }
}
