package evilcraft.modcompat;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Interface for external mod compatibilities.
 * Implement this on classes that require external mod functionality
 * that needs to be called in the preInit, init or postInit events.
 * Add instances to the {@link ModCompatLoader#MODCOMPATS} list.
 * Note that classes implementing this interface can NOT use classes
 * from the targetted mod, since an instance of the ModCompat will be
 * created anyways, and otherwise certain class definitions won't be found.
 * @author rubensworks
 *
 */
public interface IModCompat {

    /**
     * Get the unique mod ID.
     * @return The mod ID.
     */
    public String getModID();
    
    /**
     * This will be called in the {@link FMLPreInitializationEvent}.
     */
    public void preInit();
    
    /**
     * This will be called in the {@link FMLInitializationEvent}.
     */
    public void init();
    
    /**
     * This will be called in the {@link FMLPostInitializationEvent}.
     */
    public void postInit();
    
}
