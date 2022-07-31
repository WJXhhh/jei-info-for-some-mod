package com.wjx.jeim.jei.jeim.RightClickOnBlock;

import com.wjx.jeim.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class RCO_AbstractRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T>
{
    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/rco.png");
    protected static final int input1 = 0;
    protected static final int input2 = 1;
    protected static final int output = 2;

    public RCO_AbstractRecipeCategory(IGuiHelper helper){

    }


}
