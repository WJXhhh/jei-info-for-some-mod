package com.wjx.jeim.jei.jeim.solo.duanzao;


import com.wjx.jeim.jei.RecipesCategories;
import com.wjx.jeim.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.mcreator.solomon.block.BlockDuanz;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class DuanZao_RC  extends DuanZao_ARC<DuanZao_R> {
    private final IDrawable background;
    private final IDrawable icon;
    private final String name;

    public DuanZao_RC(IGuiHelper helper){
        super(helper);
        background = helper.createDrawable(TEXTURES,4,12,160,100);
        icon = helper.createDrawableIngredient(new ItemStack(BlockDuanz.block));
        name = I18n.format("jei.recipes.duanzao.name");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getModName() {
        return Reference.NAME;
    }

    @Override
    public String getUid() {
        return RecipesCategories.DuanZao;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return icon;

    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, DuanZao_R DuanZao_R, IIngredients iIngredients) {
        IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
        stacks.init(input1,true,3,8); //第二个参数一般来说若是输入端，填true，输出就是false
        stacks.init(input2,true,38,8);
        stacks.init(input3,true,103,8);
        stacks.init(input4,true,141,7);
        stacks.init(output,false,74,39);
        stacks.set(iIngredients);
    }
}
