package nesb01t.WeToolbox.message;

public class MessageConfigurator {
    public MessageConfigurator() {
        prefix = "&l≬ &eWeToolbox &f&l≬ &7";
    }

    public static String prefix;

    public static void setPrefix(String prefix) {
        MessageConfigurator.prefix = prefix;
    }
}
