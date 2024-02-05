package nesb01t.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public final class WeToolbox extends JavaPlugin {

    public static WeToolbox Instance;

    @Override
    public void onEnable() {
        Instance = this;

        Service.initialize();
    }
}
