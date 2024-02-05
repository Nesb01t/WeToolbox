package nesb01t.spigot.service.alias;

public class Alias {
    public String name;
    public String command;

    public Alias(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public String getAlias() {
        return name;
    }

    public String getCommand() {
        return command;
    }
}
