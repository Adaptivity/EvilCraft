package evilcraft.items;
import evilcraft.api.config.ExtendedConfig;
import evilcraft.api.config.ItemConfig;
import evilcraft.api.config.configurable.ConfigurableItem;

/**
 * A core used for infusion machine recipes.
 * @author rubensworks
 *
 */
public class BloodInfusionCore extends ConfigurableItem {
    
    private static BloodInfusionCore _instance = null;
    
    /**
     * Initialise the configurable.
     * @param eConfig The config.
     */
    public static void initInstance(ExtendedConfig<ItemConfig> eConfig) {
        if(_instance == null)
            _instance = new BloodInfusionCore(eConfig);
        else
            eConfig.showDoubleInitError();
    }
    
    /**
     * Get the unique instance.
     * @return The instance.
     */
    public static BloodInfusionCore getInstance() {
        return _instance;
    }

    private BloodInfusionCore(ExtendedConfig<ItemConfig> eConfig) {
        super(eConfig);
    }

}
