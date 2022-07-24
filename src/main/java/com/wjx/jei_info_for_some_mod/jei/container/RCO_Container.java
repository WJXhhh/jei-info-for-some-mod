package com.wjx.jei_info_for_some_mod.jei.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;



public class RCO_Container extends Container {
    public RCO_Container(InventoryPlayer player) {

        this.addSlotToContainer(new Slot(player,0,38,38));
        this.addSlotToContainer(new Slot(player,1,74,61));
        this.addSlotToContainer(new Slot(player,0,110,38));

        for(int y =0;y<3;y++){
            for(int x = 0; x<9;x++){
                this.addSlotToContainer(new Slot(player,x+y*9+9,8+x*18,84+y*18));
            }
        }

        for (int x = 0;x<9;x++){
            this.addSlotToContainer(new Slot(player,x,8+x*18,142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }
}
