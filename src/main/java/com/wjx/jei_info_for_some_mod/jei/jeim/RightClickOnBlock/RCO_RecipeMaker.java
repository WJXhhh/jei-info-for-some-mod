package com.wjx.jei_info_for_some_mod.jei.jeim.RightClickOnBlock;

import com.google.common.collect.Lists;
import mezz.jei.api.IJeiHelpers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.tslat.aoa3.common.registration.BlockRegister;
import net.tslat.aoa3.common.registration.ItemRegister;

import java.util.List;

public class RCO_RecipeMaker {



    public static List<RCO_Recipe> getRecipes(IJeiHelpers helpers){
        List<RCO_Recipe> jeiRecipes = Lists.newArrayList();
        if(Loader.isModLoaded("aoa3")){
            List<ItemStack> l1 = Lists.newArrayList(new ItemStack(ItemRegister.RED_GEMSTONES),new ItemStack(BlockRegister.RED_CRYSTAL_CREATOR));
            List<ItemStack> l2 = Lists.newArrayList(new ItemStack(ItemRegister.YELLOW_GEMSTONES),new ItemStack(BlockRegister.YELLOW_CRYSTAL_CREATOR));


            jeiRecipes.add(new RCO_Recipe(l1,new ItemStack(ItemRegister.RED_CRYSTAL)));
            jeiRecipes.add(new RCO_Recipe(l2,new ItemStack(ItemRegister.YELLOW_CRYSTAL)));
            jeiRecipes.add(C(ItemRegister.PURPLE_GEMSTONES, Item.getItemFromBlock(BlockRegister.PURPLE_CRYSTAL_CREATOR),ItemRegister.PURPLE_CRYSTAL));
            jeiRecipes.add(C(ItemRegister.BLUE_GEMSTONES,Item.getItemFromBlock(BlockRegister.BLUE_CRYSTAL_CREATOR),ItemRegister.BLUE_CRYSTAL));
            jeiRecipes.add(C(ItemRegister.WHITE_GEMSTONES,Item.getItemFromBlock(BlockRegister.WHITE_CRYSTAL_CREATOR),ItemRegister.WHITE_CRYSTAL));
        }


        return jeiRecipes;
    }

    public static RCO_Recipe C(Item input1,Item input2,Item output){
        List<ItemStack> lc = Lists.newArrayList(new ItemStack(input1),new ItemStack(input2));
        return new RCO_Recipe(lc,new ItemStack(output));

    }



}
