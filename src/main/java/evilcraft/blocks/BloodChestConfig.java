package evilcraft.blocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import evilcraft.api.Helpers;
import evilcraft.api.config.BlockConfig;
import evilcraft.api.config.ElementTypeCategory;
import evilcraft.api.config.configurable.ConfigurableProperty;
import evilcraft.api.item.ItemBlockNBT;
import evilcraft.entities.tileentities.TileBloodChest;
import evilcraft.proxies.ClientProxy;
import evilcraft.render.item.RenderItemBloodChest;
import evilcraft.render.tileentity.TileEntityBloodChestRenderer;

/**
 * Config for the {@link BloodChest}.
 * @author rubensworks
 *
 */
public class BloodChestConfig extends BlockConfig {
    
    /**
     * The unique instance.
     */
    public static BloodChestConfig _instance;
    
    /**
     * If the Blood Chest should add random bad enchants.
     */
    @ConfigurableProperty(category = ElementTypeCategory.GENERAL, comment = "If the Blood Chest should add random bad enchants with a small chance to repairing items.", isCommandable = true)
    public static boolean addRandomBadEnchants = true;
    
    /**
     * The amount Blood mB required for repairing one damage value.
     */
    @ConfigurableProperty(category = ElementTypeCategory.GENERAL, comment = "The amount Blood mB required for repairing one damage value.", isCommandable = true)
    public static int mBPerDamage = 5;
    
    /**
     * The amount of ticks required for repairing one damage value.
     */
    @ConfigurableProperty(category = ElementTypeCategory.GENERAL, comment = "The amount of ticks required for repairing one damage value.", isCommandable = true)
    public static int ticksPerDamage = 2;
    
    /**
     * If the Blood Chest should be able to repair tools from Tinkers' Construct (if that mod is available).
     */
    @ConfigurableProperty(category = ElementTypeCategory.GENERAL, comment = "If the Blood Chest should be able to repair tools from Tinkers' Construct", isCommandable = true)
    public static boolean repairTConstructTools = true;

    /**
     * Make a new instance.
     */
    public BloodChestConfig() {
        super(
        	true,
            "bloodChest",
            null,
            BloodChest.class
        );
    }
    
    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return ItemBlockNBT.class;
    }
    
    @Override
    public void onRegistered() {
        if (Helpers.isClientSide()) {
            ClientProxy.TILE_ENTITY_RENDERERS.put(TileBloodChest.class, new TileEntityBloodChestRenderer());
            ClientProxy.ITEM_RENDERERS.put(Item.getItemFromBlock(BloodChest.getInstance()), new RenderItemBloodChest());
        }
    }
    
}
