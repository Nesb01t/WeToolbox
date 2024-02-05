package nesb01t.spigot.cmds;

import nesb01t.spigot.WeToolbox;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

public class CmdConfigurator {
    public CmdConfigurator() {
        reg("wt", new WtCommand());
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
