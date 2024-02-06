package nesb01t.WeToolbox.io;

import nesb01t.WeToolbox.service.alias.Alias;
import nesb01t.WeToolbox.service.alias.AliasService;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AliasConfig {

    private final File file;
    private final YamlConfiguration config;
    private final AliasService aliasService;

    public AliasConfig(AliasService aliasService) {
        file = new File("plugins/WtToolbox/alias.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
        this.aliasService = aliasService;
        load();
    }

    public List<Alias> load() {
        List<Alias> aliases = new ArrayList<>();
        if (config.isConfigurationSection("aliases")) {
            for (String key : config.getConfigurationSection("aliases").getKeys(false)) {
                String name = config.getString("aliases." + key + ".name");
                String command = config.getString("aliases." + key + ".command");
                aliases.add(new Alias(name, command));
            }
        }
        aliasService.loadAlias(aliases);
        return aliases;
    }

    public void save() {
        save(aliasService.listAlias());
    }

    protected void save(List<Alias> aliases) {
        config.createSection("aliases");
        for (Alias alias : aliases) {
            config.set("aliases." + alias.getName() + ".name", alias.getName());
            config.set("aliases." + alias.getName() + ".command", alias.getCommand());
        }
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
