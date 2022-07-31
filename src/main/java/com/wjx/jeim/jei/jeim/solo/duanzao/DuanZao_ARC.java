package com.wjx.jeim.jei.jeim.solo.duanzao;

import com.wjx.jeim.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class DuanZao_ARC<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/duanzao.png");

    protected static final int input1 = 0;
    protected static final int input2 = 1;
    protected static final int input3 = 2;
    protected static final int input4 = 3;
    protected static final int output = 5;

    public DuanZao_ARC(IGuiHelper helper){

    }
}
