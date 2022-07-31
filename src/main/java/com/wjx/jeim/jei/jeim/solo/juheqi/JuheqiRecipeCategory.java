package com.wjx.jeim.jei.jeim.solo.juheqi;

import com.wjx.jeim.jei.RecipesCategories;
import com.wjx.jeim.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.mcreator.solomon.block.BlockJuhesk;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class JuheqiRecipeCategory extends AbstractJuheqi<JuheqiRecipe>{
    private final IDrawable background;

    private final IDrawable icon;
    private final String name;

    public JuheqiRecipeCategory(IGuiHelper helper){
        super(helper);
        background = helper.createDrawable(TEXTURES,4,12,150,60);
        icon = helper.createDrawableIngredient(new ItemStack(BlockJuhesk.block));
        name = I18n.format("jei.recipes.juhe.name");
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
        return RecipesCategories.Juheqi;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return icon;

    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, JuheqiRecipe juheqiRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
        stacks.init(input1,true,39,3); //第二个参数一般来说若是输入端，填true，输出就是false
        stacks.init(input2,true,109,3);
        stacks.init(output,false,108,32);
        stacks.set(iIngredients);
    }
}
