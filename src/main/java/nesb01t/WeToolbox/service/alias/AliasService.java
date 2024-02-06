package nesb01t.WeToolbox.service.alias;

import nesb01t.WeToolbox.Service;

import java.util.ArrayList;
import java.util.List;

public class AliasService {
    private final List<Alias> aliases = new ArrayList<>();

    public AliasService() {

    }

    public Alias setAlias(String name, String command) {
        // check first char
        if (command.charAt(0) != '/') {
            command = "/" + command;
        }

        Alias alias = new Alias(name, command);
        for (Alias a : aliases) {
            if (a.name.equalsIgnoreCase(name)) {
                a.command = command;
                return a;
            }
        }
        aliases.add(alias);
        save();
        return alias;
    }

    public boolean removeAlias(String name) {
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < aliases.size(); i++) {
            Alias alias = aliases.get(i);
            if (alias.name.equalsIgnoreCase(name)) {
                toRemove.add(i);
            }
        }

        if (toRemove.isEmpty()) {
            return false;
        }

        for (int index : toRemove) {
            aliases.remove(index);
        }
        save();
        return true;
    }

    public ArrayList<Alias> listAlias() {
        return (ArrayList<Alias>) aliases;
    }

    public void loadAlias(List<Alias> aliases) {
        this.aliases.clear();
        this.aliases.addAll(aliases);
    }

    public void save() {
        Service.aliasConfig.save();
    }
}
