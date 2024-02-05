package nesb01t.spigot;

import nesb01t.spigot.cmds.CmdConfigurator;
import nesb01t.spigot.message.MessageConfigurator;
import nesb01t.spigot.service.alias.AliasConfigurator;

public class Service {
    public static CmdConfigurator cmdConfigurator;
    public static MessageConfigurator messageConfigurator;
    public static AliasConfigurator aliasConfigurator;

    public static void initialize() {
        messageConfigurator = new MessageConfigurator();
        aliasConfigurator = new AliasConfigurator();

        cmdConfigurator = new CmdConfigurator(aliasConfigurator.aliasService);
    }
}
