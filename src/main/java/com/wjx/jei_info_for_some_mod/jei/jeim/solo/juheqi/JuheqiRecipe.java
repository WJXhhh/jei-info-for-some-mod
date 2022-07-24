package com.wjx.jei_info_for_some_mod.jei.jeim.solo.juheqi;

import com.wjx.jei_info_for_some_mod.jei.recipe.RCO_R;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import java.util.List;

public class JuheqiRecipe implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public JuheqiRecipe(List<ItemStack> inputs,ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients iIngredients) {
        iIngredients.setInputs(ItemStack.class,inputs);
        iIngredients.setOutput(ItemStack.class,output);

    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        RCO_R recipe = RCO_R.getInstance();
        float experience = 0;

    }

}
