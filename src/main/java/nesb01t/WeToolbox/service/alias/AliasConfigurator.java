package nesb01t.WeToolbox.service.alias;

public class AliasConfigurator {
    public AliasService aliasService;

    public AliasConfigurator() {
        aliasService = new AliasService();
    }

    public void writeAliasToDisk() {
    }

    private void readAliasFromDisk() {
        // @TODO read alias.yaml
    }
}
