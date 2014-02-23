package evilcraft.gui.client;

import net.minecraft.entity.player.InventoryPlayer;
import evilcraft.api.gui.client.GuiContainerTankInventory;
import evilcraft.blocks.BloodInfuser;
import evilcraft.entities.tileentities.TileBloodInfuser;
import evilcraft.gui.container.ContainerBloodInfuser;

/**
 * GUI for the {@link BloodInfuser}.
 * @author rubensworks
 *
 */
public class GuiBloodInfuser extends GuiContainerTankInventory<TileBloodInfuser> {
    
    private static final int TEXTUREWIDTH = 176;
    @SuppressWarnings("unused")
    private static final int TEXTUREHEIGHT = 166;

    private static final int TANKWIDTH = 16;
    private static final int TANKHEIGHT = 58;
    private static final int TANKX = TEXTUREWIDTH;
    private static final int TANKY = 0;
    private static final int TANKTARGETX = 43;
    private static final int TANKTARGETY = 72;

    private static final int PROGRESSWIDTH = 24;
    private static final int PROGRESSHEIGHT = 16;
    private static final int PROGRESSX = 192;
    private static final int PROGRESSY = 0;
    private static final int PROGRESSTARGETX = 102;
    private static final int PROGRESSTARGETY = 36;
    
    /**
     * Make a new instance.
     * @param inventory The inventory of the player.
     * @param tile The tile entity that calls the GUI.
     */
    public GuiBloodInfuser(InventoryPlayer inventory, TileBloodInfuser tile) {
        super(new ContainerBloodInfuser(inventory, tile), tile);
        this.setTank(TANKWIDTH, TANKHEIGHT, TANKX, TANKY, TANKTARGETX, TANKTARGETY);
        this.setProgress(PROGRESSWIDTH, PROGRESSHEIGHT, PROGRESSX, PROGRESSY, PROGRESSTARGETX, PROGRESSTARGETY);
    }
    
    @Override
    protected boolean isShowProgress() {
        return this.tile.isInfusing();
    }
    
    @Override
    protected int getProgressScaled(int scale) {
        return this.tile.getInfuseTickScaled(24);
    }
}