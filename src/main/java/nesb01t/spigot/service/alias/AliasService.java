package nesb01t.spigot.service.alias;

import java.util.ArrayList;
import java.util.List;

public class AliasService {
    private final List<Alias> aliases = new ArrayList<>();

    public AliasService() {

    }

    public Alias setAlias(String name, String command) {
        Alias alias = new Alias(name, command);
        aliases.add(alias);
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
        return true;
    }

    public ArrayList<Alias> listAlias() {
        return (ArrayList<Alias>) aliases;
    }
}
