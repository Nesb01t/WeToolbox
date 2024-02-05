package nesb01t.spigot.service.alias;

import java.util.ArrayList;
import java.util.List;

public class AliasService {
    private List<Alias> aliases;

    public AliasService() {

    }

    public void setAlias(String name, String command) {
        Alias alias = new Alias(name, command);
    }

    public void removeAlias(String name) {
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < aliases.size(); i++) {
            Alias alias = aliases.get(i);
            if (alias.name.equalsIgnoreCase(name)) {
                toRemove.add(i);
            }
        }
        for (int index : toRemove) {
            aliases.remove(index);
        }
    }

    public void listAlias() {
    }
}
