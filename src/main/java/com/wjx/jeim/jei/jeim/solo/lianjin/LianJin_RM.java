package com.wjx.jeim.jei.jeim.solo.lianjin;

import com.google.common.collect.Lists;
import mezz.jei.api.IJeiHelpers;
import net.mcreator.solomon.item.ItemDeamincan;
import net.mcreator.solomon.item.ItemHuangs;
import net.mcreator.solomon.item.ItemLingsen;
import net.mcreator.solomon.item.ItemYuzadca;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LianJin_RM {
    public static List<LianJin_R> getRecipes(IJeiHelpers helpers){
        List<LianJin_R> jeiRecipes = Lists.newArrayList();
        if (Loader.isModLoaded("solomon")) {
            jeiRecipes.add(RC(ITL(new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.STONE), ItemStack.EMPTY, ItemStack.EMPTY, new ItemStack(Blocks.SANDSTONE)), Items.GOLD_INGOT));
            jeiRecipes.add(RC(ITL(new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY, new ItemStack(ItemDeamincan.block), ItemStack.EMPTY, ItemStack.EMPTY), ItemYuzadca.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemHuangs.block), new ItemStack(Blocks.STONE), ItemStack.EMPTY, new ItemStack(ItemDeamincan.block), ItemStack.EMPTY, ItemStack.EMPTY), ItemLingsen.block));
        }
        return jeiRecipes;
    }



    private static LianJin_R RC(List inputs,Item output){
        return new LianJin_R(inputs,new ItemStack(output,1));
    }

    private static LianJin_R RC(List inputs,Item output,int out_amount){
        return new LianJin_R(inputs,new ItemStack(output,out_amount));
    }

    private static List<ItemStack> ITL(ItemStack... stacks){
        return new ArrayList<>(Arrays.asList(stacks));
    }
}
