package nesb01t.spigot.message;

public class MessageConfigurator {
    public MessageConfigurator() {
        prefix = "[ WeToolbox ] ";
    }

    public static String prefix;

    public static void setPrefix(String prefix) {
        MessageConfigurator.prefix = prefix;
    }
}
