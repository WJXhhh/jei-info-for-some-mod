package com.wjx.jei_info_for_some_mod.jei.jeim.solo.juheqi;

import com.google.common.collect.Lists;
import com.wjx.jei_info_for_some_mod.jei.jeim.RightClickOnBlock.RCO_Recipe;
import mezz.jei.api.IJeiHelpers;
import net.mcreator.solomon.item.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

import java.util.List;

public class JuheqiRecipeMaker {
    private static JuheqiRecipeList itemHelper;

    public static Item yanyin =ItemYanzhiyin.block;
    public static Item Deamincan = ItemDeamincan.block;
    public static Item GodKey = ItemGodkey.block;
    public static Item Huangs = ItemHuangs.block;
    public static Item MingLeiPian = ItemMingleiduanpain.block;
    public static Item LeiYin = ItemLeiyin.block;
    public static Item BingYin = ItemBignzhiyin.block;
    public static Item Yuanshi = ItemYuanshi.block;
    public static Item Jiuchan = ItemJiuchanzhiyuan.block;
    public static Item Ningju = ItemNingjucanhun.block;

    public static List<JuheqiRecipe> getRecipes(IJeiHelpers helpers){



        List<JuheqiRecipe> jeiRecipes = Lists.newArrayList();
        if (Loader.isModLoaded("solomon")){
            List<ItemStack> l1 = Lists.newArrayList(new ItemStack(Deamincan,1),new ItemStack(Items.DIAMOND,1));
            List<ItemStack> l2 = Lists.newArrayList(new ItemStack(Deamincan,1),new ItemStack(Items.IRON_INGOT));
            List<ItemStack> l3 = Lists.newArrayList(new ItemStack(MingLeiPian,8),new ItemStack(Items.DIAMOND,1));
            List<ItemStack> l4 = Lists.newArrayList(new ItemStack(Items.SNOWBALL,8),new ItemStack(Items.DIAMOND));
            List<ItemStack> l5 = Lists.newArrayList(new ItemStack(Yuanshi,4),new ItemStack(Items.IRON_INGOT));
            List<ItemStack> l6 = Lists.newArrayList(new ItemStack(Ningju,1), new ItemStack(Items.IRON_INGOT));
            List<ItemStack> l7 = Lists.newArrayList(new ItemStack(Blocks.COBBLESTONE,4),new ItemStack(Items.DIAMOND));
            jeiRecipes = Lists.newArrayList(new JuheqiRecipe(l1,new ItemStack(GodKey)),new JuheqiRecipe(l2,new ItemStack(Huangs)),new JuheqiRecipe(l3,new ItemStack(LeiYin)), new JuheqiRecipe(l4,new ItemStack(BingYin)), new JuheqiRecipe(l5,new ItemStack(Jiuchan)),new JuheqiRecipe(l6,new ItemStack(Yuanshi,16)), new JuheqiRecipe(l7,new ItemStack(yanyin)) );

        }

        return jeiRecipes;

    }


}
