package com.wjx.jeim.jei.jeim.solo.lianjin;

import com.wjx.jeim.jei.recipe.RCO_R;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import java.util.List;

public class LianJin_R implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public LianJin_R(List<ItemStack> inputs, ItemStack output){
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
