package com.wjx.jeim.jei.jeim.solo.juheqi;

import com.wjx.jeim.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractJuheqi <T extends IRecipeWrapper> implements IRecipeCategory<T> {

    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID+":textures/gui/juhe.png");
    protected static final int input1 = 0; //有多余的input就起名input1……input2什么的吧，有几个input,output就定义几个，数字瞎写也没关系，只要你能想起来。
    protected static final int input2 = 1;
    protected static final int output = 2;

    public AbstractJuheqi(IGuiHelper helper) {
    }

}
