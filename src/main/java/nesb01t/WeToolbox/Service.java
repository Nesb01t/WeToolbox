package nesb01t.WeToolbox;

import nesb01t.WeToolbox.cmds.CmdConfigurator;
import nesb01t.WeToolbox.io.AliasConfig;
import nesb01t.WeToolbox.message.MessageConfigurator;
import nesb01t.WeToolbox.service.alias.AliasConfigurator;

public class Service {
    public static CmdConfigurator cmdConfigurator;
    public static MessageConfigurator messageConfigurator;
    public static AliasConfigurator aliasConfigurator;

    public static AliasConfig aliasConfig;

    public static void initialize() {
        messageConfigurator = new MessageConfigurator();
        aliasConfigurator = new AliasConfigurator();
        cmdConfigurator = new CmdConfigurator(aliasConfigurator.aliasService);

        aliasConfig = new AliasConfig(aliasConfigurator.aliasService);
    }
}
