package com.wjx.jei_info_for_some_mod.jei.jeim.RightClickOnBlock;

import com.wjx.jei_info_for_some_mod.jei.RecipesCategories;
import com.wjx.jei_info_for_some_mod.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.resources.I18n;

public class RCO_RecipeCategory extends  RCO_AbstractRecipeCategory<RCO_Recipe>{
    private final IDrawable background;
    private final String name;

    public RCO_RecipeCategory(IGuiHelper helper){
        super(helper);
        background = helper.createDrawable(TEXTURES,4,12,160,100);
        name = I18n.format("jei.recipes.RCO.name");
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
        return RecipesCategories.RCO;
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, RCO_Recipe RCO_recipe, IIngredients iIngredients) {
        IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
        stacks.init(input1,true,33,26); //第二个参数一般来说若是输入端，填true，输出就是false
        stacks.init(input2,true,69,48);
        stacks.init(output,false,105,26);
        stacks.set(iIngredients);
    }


}
