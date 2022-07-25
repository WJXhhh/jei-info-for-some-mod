package com.wjx.jei_info_for_some_mod.jei.jeim.solo.lianjin;

import com.wjx.jei_info_for_some_mod.jei.RecipesCategories;
import com.wjx.jei_info_for_some_mod.jei.jeim.RightClickOnBlock.RCO_Recipe;
import com.wjx.jei_info_for_some_mod.util.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.resources.I18n;

public class LianJin_RC extends LianJin_ARC<LianJin_R>{
    private final IDrawable background;
    private final String name;

    public LianJin_RC(IGuiHelper helper){
        super(helper);
        background = helper.createDrawable(TEXTURES,4,12,320,100);
        name = I18n.format("jei.recipes.lianjin.name");
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
        return RecipesCategories.Lianjin;
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, LianJin_R LianJin_R, IIngredients iIngredients) {
        IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
        stacks.init(input1,true,116,33); //第二个参数一般来说若是输入端，填true，输出就是false
        stacks.init(input2,true,184,34);
        stacks.init(input3,true,115,71);
        stacks.init(input4,true,183,71);
        stacks.init(input5,true,70,29);
        stacks.init(output,false,149,50);
        stacks.set(iIngredients);
    }
}
