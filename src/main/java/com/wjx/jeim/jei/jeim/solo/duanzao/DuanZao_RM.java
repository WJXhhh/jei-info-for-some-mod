package com.wjx.jeim.jei.jeim.solo.duanzao;

import com.google.common.collect.Lists;
import mezz.jei.api.IJeiHelpers;
import net.mcreator.solomon.item.*;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuanZao_RM {
    public static List<DuanZao_R> getRecipes(IJeiHelpers helpers){
        List<DuanZao_R> jeiRecipes = Lists.newArrayList();
        if (Loader.isModLoaded("solomon")) {
            jeiRecipes.add(RC(ITL(new ItemStack(ItemYuzadca.block,10),new ItemStack(ItemGodkey.block),new ItemStack(ItemChangyuan.block),new ItemStack(ItemWuxingqihun.block)),ItemGuanhong.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemYanzhiyin.block,4),new ItemStack(ItemGodkey.block),new ItemStack(ItemDanshouy.block),new ItemStack(ItemWuxingqihun.block)),ItemZhuofeng.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemVlr.block),new ItemStack(ItemGodkey.block),new ItemStack(ItemDanshouy.block),new ItemStack(ItemWuxingqihun.block)),ItemMorasword.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemLeiyin.block,8),new ItemStack(ItemGodkey.block),new ItemStack(ItemGongyuan.block),new ItemStack(ItemWuxingqihun.block)),ItemFeileiz.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemLeiyin.block,8),new ItemStack(ItemGodkey.block),new ItemStack(ItemDanshouy.block),new ItemStack(ItemWuxingqihun.block)),ItemWuqie.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemLeiyin.block,6),new ItemStack(ItemMingshenyusou.block),new ItemStack(ItemChangyuan.block),new ItemStack(ItemWuxingqihun.block)),ItemTicaozhidaoguang.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemHuangs.block,16),new ItemStack(ItemGodkey.block),new ItemStack(ItemChangyuan.block),new ItemStack(ItemWuxingqihun.block)),ItemLvqiang.block));
            jeiRecipes.add(RC(ITL(new ItemStack(Items.DIAMOND,8),new ItemStack(ItemGodkey.block),new ItemStack(ItemGongyuan.block),new ItemStack(Items.IRON_INGOT)),ItemTanggong.block));
            jeiRecipes.add(RC(ITL(new ItemStack(Items.DIAMOND,8),new ItemStack(ItemGodkey.block),new ItemStack(ItemDanshouy.block),new ItemStack(Items.IRON_INGOT)),ItemChihuyudao.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemBignzhiyin.block,4),new ItemStack(ItemGodkey.block),new ItemStack(ItemGongyuan.block),new ItemStack(ItemWuxingqihun.block)),ItemDongjibaixing.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemYuzadca.block,8),new ItemStack(ItemGodkey.block),new ItemStack(ItemDanshouy.block),new ItemStack(Items.DIAMOND,8)),ItemTianmuyingdadao.block));
            jeiRecipes.add(RC(ITL(new ItemStack(ItemVlw.block),new ItemStack(ItemGodkey.block),new ItemStack(ItemDanshouy.block),new ItemStack(ItemWuxingqihun.block)), ItemBoluan.block));
        }
        return jeiRecipes;
    }


    private static DuanZao_R RC(List<ItemStack> inputs, Item output){
        return new DuanZao_R(inputs,new ItemStack(output,1));
    }

    private static DuanZao_R RC(List<ItemStack> inputs,Item output,int out_amount){
        return new DuanZao_R(inputs,new ItemStack(output,out_amount));
    }

    private static List<ItemStack> ITL(ItemStack... stacks){
        return new ArrayList<>(Arrays.asList(stacks));
    }
}
