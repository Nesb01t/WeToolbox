package nesb01t.WeToolbox.message;

public class ColorHelper {
    public enum Color {
        BLACK("§0"),
        DARK_BLUE("§1"),
        DARK_GREEN("§2"),
        DARK_AQUA("§3"),
        DARK_RED("§4"),
        DARK_PURPLE("§5"),
        GOLD("§6"),
        GRAY("§7"),
        DARK_GRAY("§8"),
        BLUE("§9"),
        GREEN("§a"),
        AQUA("§b"),
        RED("§c"),
        LIGHT_PURPLE("§d"),
        YELLOW("§e"),
        WHITE("§f"),
        MAGIC("§k"),
        BOLD("§l"),
        STRIKETHROUGH("§m"),
        UNDERLINE("§n"),
        ITALIC("§o"),
        RESET("§r");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
