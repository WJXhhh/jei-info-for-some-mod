package com.wjx.jei_info_for_some_mod.jei;

import com.wjx.jei_info_for_some_mod.Main;
import com.wjx.jei_info_for_some_mod.jei.container.RCO_Container;
import com.wjx.jei_info_for_some_mod.jei.jeim.RightClickOnBlock.RCO_RecipeCategory;
import com.wjx.jei_info_for_some_mod.jei.jeim.RightClickOnBlock.RCO_RecipeMaker;
import com.wjx.jei_info_for_some_mod.jei.jeim.solo.juheqi.JuheqiRecipeCategory;
import com.wjx.jei_info_for_some_mod.jei.jeim.solo.juheqi.JuheqiRecipeMaker;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.mcreator.solomon.gui.GuiJuhe;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.tslat.aoa3.common.registration.BlockRegister;
import net.tslat.aoa3.common.registration.ItemRegister;

import java.util.IllegalFormatException;

import static net.minecraft.util.text.translation.I18n.canTranslate;
import static net.minecraft.util.text.translation.I18n.translateToFallback;

@JEIPlugin
public class JEI_Compat implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers helpers = registry.getJeiHelpers();
        final IGuiHelper gui = helpers.getGuiHelper();

        registry.addRecipeCategories(new RCO_RecipeCategory(gui));
        if (Loader.isModLoaded("solomon")){
            registry.addRecipeCategories(new JuheqiRecipeCategory(gui));

        }

    }

    @Override
    public void register(IModRegistry registry) {
        final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
        try {
            if (Loader.isModLoaded("aoa3")){
                registry.addRecipes(RCO_RecipeMaker.getRecipes(jeiHelpers),RecipesCategories.RCO);
                recipeTransfer.addRecipeTransferHandler(RCO_Container.class,RecipesCategories.RCO,0,1,3,36);
            }



        }catch (Exception e){

        }

        try {
            if (Loader.isModLoaded("solomon")){
                Main.logger.info("Solo");
                registry.addRecipes(JuheqiRecipeMaker.getRecipes(jeiHelpers),RecipesCategories.Juheqi);
                recipeTransfer.addRecipeTransferHandler(GuiJuhe.GuiContainerMod.class,RecipesCategories.Juheqi,0,1,3,36);

            }

        }catch (Exception e){

        }
        this.registerDescriptions(registry);

    }

    public static String translateToLocal(String key){
        if(canTranslate(key)) return translateToLocal(key);
        else return translateToFallback(key);
    }

    public static String translateToLocalFormatted(String key,Object... format){
        String s = translateToLocal(key);
        try {
            return String.format(s,format);
        }catch (IllegalFormatException e){
            return "Format Error:"+s ;
        }
    }

    private void registerDescriptions(IModRegistry registry){
        if (Loader.isModLoaded("aoa3")){
            //AOA3 Crystevia

            this.aDI(ItemRegister.GIANT_CRYSTAL,registry,"jei.des.giant_crystal");
            this.aDI(ItemRegister.BLUE_DRUSE,registry,"jei.des.blue_druse");
            this.aDI(ItemRegister.PURPLE_DRUSE,registry,"jei.des.purple_druse");
            this.aDI(ItemRegister.RED_DRUSE,registry,"jei.des.red_druse");
            this.aDI(ItemRegister.WHITE_DRUSE,registry,"jei.des.white_druse");
            this.aDI(ItemRegister.GREEN_DRUSE,registry,"jei.des.green_druse");
            this.aDI(ItemRegister.YELLOW_DRUSE,registry,"jei.des.yellow_druse");

            this.aDB(BlockRegister.CRYSTAL_EXTENSION_SHRINE,registry,"jei.des.ces");




        }


    }

    /**
     * 用于为一个物品添加JEI信息
     * @param item 在此输入要添加JEI信息的物品
     * @param registry 用于填入被覆写的register方法的register参数
     * @param key 信息文本的本地化键
     */
    private void aDI(Item item, IModRegistry registry, String key){
        registry.addIngredientInfo(new ItemStack(item,1),ItemStack.class, I18n.format(key));
    }

    /**
     * 用于为一个方块添加JEI信息
     * @param block 在此输入要添加JEI信息的方块
     * @param registry 用于填入被覆写的register方法的register参数
     * @param key 信息文本的本地化键
     */
    private void aDB(Block block, IModRegistry registry, String key){
        registry.addIngredientInfo(new ItemStack(block,1),ItemStack.class, I18n.format(key));
    }

}
