package com.wjx.jeim.jei;

import com.wjx.jeim.Main;
import com.wjx.jeim.jei.container.RCO_Container;
import com.wjx.jeim.jei.jeim.RightClickOnBlock.RCO_RecipeCategory;
import com.wjx.jeim.jei.jeim.RightClickOnBlock.RCO_RecipeMaker;
import com.wjx.jeim.jei.jeim.solo.duanzao.DuanZao_RC;
import com.wjx.jeim.jei.jeim.solo.duanzao.DuanZao_RM;
import com.wjx.jeim.jei.jeim.solo.juheqi.JuheqiRecipeCategory;
import com.wjx.jeim.jei.jeim.solo.juheqi.JuheqiRecipeMaker;
import com.wjx.jeim.jei.jeim.solo.lianjin.LianJin_RC;
import com.wjx.jeim.jei.jeim.solo.lianjin.LianJin_RM;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.mcreator.solomon.block.BlockLiakmion;
import net.mcreator.solomon.gui.GuiDuanzao;
import net.mcreator.solomon.gui.GuiJuhe;
import net.mcreator.solomon.gui.GuiLeviaswen;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.tslat.aoa3.common.registration.BlockRegister;
import net.tslat.aoa3.common.registration.ItemRegister;
import net.tslat.aoa3.common.registration.WeaponRegister;

import java.util.IllegalFormatException;

import static net.minecraft.util.text.translation.I18n.canTranslate;
import static net.minecraft.util.text.translation.I18n.translateToFallback;

@JEIPlugin
public class JEI_Compat implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        Main.logger.info("JEI_Plugin_Loaded1!");
        final IJeiHelpers helpers = registry.getJeiHelpers();
        final IGuiHelper gui = helpers.getGuiHelper();


        if (Loader.isModLoaded("aoa3")){
            registry.addRecipeCategories(new RCO_RecipeCategory(gui));

        }
        if (Loader.isModLoaded("solomon")){
            registry.addRecipeCategories(new JuheqiRecipeCategory(gui));
            registry.addRecipeCategories(new LianJin_RC(gui));
            registry.addRecipeCategories(new DuanZao_RC(gui));

        }

    }

    @Override
    public void register(IModRegistry registry) {
		Main.logger.info("JEI_Plugin_Loaded2!");
        final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();

            if (Loader.isModLoaded("aoa3")){
                registry.addRecipes(RCO_RecipeMaker.getRecipes(jeiHelpers),RecipesCategories.RCO);
                recipeTransfer.addRecipeTransferHandler(RCO_Container.class,RecipesCategories.RCO,0,1,3,36);
            }
            if (Loader.isModLoaded("solomon")){
                Main.logger.info("Solo");
                registry.addRecipes(JuheqiRecipeMaker.getRecipes(jeiHelpers),RecipesCategories.Juheqi);
                registry.addRecipes(LianJin_RM.getRecipes(jeiHelpers),RecipesCategories.Lianjin);
                registry.addRecipes(DuanZao_RM.getRecipes(jeiHelpers),RecipesCategories.DuanZao);
                recipeTransfer.addRecipeTransferHandler(GuiJuhe.GuiContainerMod.class,RecipesCategories.Juheqi,0,1,3,36);
                recipeTransfer.addRecipeTransferHandler(GuiLeviaswen.GuiContainerMod.class,RecipesCategories.Lianjin,0,1,3,36);
                recipeTransfer.addRecipeTransferHandler(GuiDuanzao.GuiContainerMod.class,RecipesCategories.DuanZao,0,1,3,36);

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
        if (Loader.isModLoaded("aoa3")) {
            AoaSupport(registry);
        }
        if (Loader.isModLoaded("solomon")){
            SolomonSupport(registry);
        }




    }
    @Optional.Method(modid = "aoa3")
    void AoaSupport(IModRegistry registry){
        //AOA3

            //Crystevia

            this.aDIO(ItemRegister.GIANT_CRYSTAL,registry,"jei.des.giant_crystal");
            this.aDIO(ItemRegister.BLUE_DRUSE,registry,"jei.des.blue_druse");
            this.aDIO(ItemRegister.PURPLE_DRUSE,registry,"jei.des.purple_druse");
            this.aDIO(ItemRegister.RED_DRUSE,registry,"jei.des.red_druse");
            this.aDIO(ItemRegister.WHITE_DRUSE,registry,"jei.des.white_druse");
            this.aDIO(ItemRegister.GREEN_DRUSE,registry,"jei.des.green_druse");
            this.aDIO(ItemRegister.YELLOW_DRUSE,registry,"jei.des.yellow_druse");
            //misc
        this.aDIO(ItemRegister.MAGIC_REPAIR_DUST,registry,"jei.des.magic_rd");
        this.aDIO(ItemRegister.MAGIC_MENDING_COMPOUND,registry,"jei.des.magic_mc");
        this.aDIO(ItemRegister.MAGIC_MENDING_SOLUTION,registry,"jei.des.magic_ms");
        this.aDIO(ItemRegister.CORAL_STONE,registry,"jei.des.coral_s");
        this.aDIO(ItemRegister.DARKLY_POWDER,registry,"jei.des.darkly_p");
        this.aDIO(ItemRegister.GHOSTLY_POWDER,registry,"jei.des.ghostly_p");
        this.aDIO(ItemRegister.ICE_CRYSTAL,registry,"jei.des.ice_c");
        this.aDIO(ItemRegister.IVORY,registry,"jei.des.ivory");
        this.aDIO(ItemRegister.JUNGLE_THORNS,registry,"jei.des.jungle_t");
        this.aDIO(ItemRegister.ORBULON,registry,"jei.des.orbulon");
        this.aDIO(ItemRegister.RAMMERHEAD_HIDE,registry,"jei.des.rammerhead_h");
        this.aDIO(ItemRegister.TOXIC_LUMP,registry,"jei.des.toxic_l");
        this.aDIO(ItemRegister.URKA_HIDE,registry,"jei.des.urka_h");
        this.aDI(ItemRegister.WHITEWASHING_SOLUTION,registry,"whitewashing_s");
        this.aDI(ItemRegister.NIGHTMARE_FLAKES,registry,"nightmare_f");
        //Lands of Runandor
        this.aDIO(ItemRegister.RUNIC_ENERGY,registry,"jei.des.runic_e");
        //Gardencia
        this.aDIO(ItemRegister.SMALL_GREEN_PETAL,registry,"jei.des.small_gp");
        this.aDIO(ItemRegister.SMALL_ORANGE_PETAL,registry,"jei.des.small_op");
        this.aDIO(ItemRegister.SMALL_PURPLE_PETAL,registry,"jei.des.small_pp");
        this.aDIO(ItemRegister.SMALL_RED_PETAL,registry,"jei.des.small_rp");
        //Lands of Lelyetia
        this.aDI(ItemRegister.ZHINX_DUST,registry,"zhinx_d");
        this.aDI(ItemRegister.GHOULASM,registry,"ghoulasm");
        this.aDI(ItemRegister.PRIMED_GHOULASM,registry,"primed_ghoulasm");
        //Kai_Bai!
        this.aDI(ItemRegister.OLD_BOOT,registry,"old_b");
        this.aDI(ItemRegister.PHANTASM,registry,"phantasm");
        this.aDI(ItemRegister.PRIMORDIAL_SKULL,registry,"primordial_s");
        this.aDI(ItemRegister.SMALL_BLUE_PETAL,registry,"small_bp");
        this.aDI(ItemRegister.DENSE_ROCK,registry,"dense_r");
        this.aDI(ItemRegister.SHARP_CLAW,registry,"sharp_c");
        this.aDI(ItemRegister.TORN_CLOTH,registry,"torn_c");
        this.aDI(ItemRegister.MUSHROOM_SPORES,registry,"mushroom_s");
        this.aDI(ItemRegister.FLOATING_STONE,registry,"floating_s");
        this.aDI(ItemRegister.ROSID_ROOT,registry,"rosid_r");
        this.aDI(ItemRegister.YELLOW_SPORES,registry,"yellow_s");
        this.aDI(ItemRegister.ORANGE_SPORES,registry,"yellow_s");//描述确实和黄色一模一样
        this.aDI(ItemRegister.VOID_SCALES,registry,"void_s");
        this.aDI(ItemRegister.CHITIN,registry,"chitin");
        this.aDI(ItemRegister.CONFETTI_PILE,registry,"confetti_p");
        this.aDI(ItemRegister.HARDENED_CONFETTI_BALL,registry,"hardened_cb");
        this.aDI(ItemRegister.ENCHANTED_GUNPOWDER,registry,"enchanted_g");
        this.aDI(ItemRegister.FLAMMABLE_DUST,registry,"flammable_d");
        this.aDI(ItemRegister.MAGNET_SHARD,registry,"magnet_s");
        this.aDI(ItemRegister.POWER_CORE,registry,"power_c");
        this.aDI(ItemRegister.SCRAP_METAL,registry,"scrap_m");
        this.aDI(ItemRegister.STICKY_SLIME,registry,"sticky_s");
        this.aDI(ItemRegister.UNSTABLE_GUNPOWDER,registry,"unstable_g");
        this.aDI(ItemRegister.HIVE_CHUNK,registry,"hive_c");
        this.aDI(ItemRegister.FRAGMENTED_ANIMA_STONE,registry,"fragment_as");
        this.aDI(ItemRegister.GLISTENING_INFUSION_STONE,registry,"glistening_is");
        this.aDI(ItemRegister.GLEAMING_INFUSION_STONE,registry,"gleaming_is");
        this.aDI(ItemRegister.SMALL_SKILL_CRYSTAL,registry,"skill_c");
        this.aDI(ItemRegister.MEDIUM_SKILL_CRYSTAL,registry,"skill_c");
        this.aDI(ItemRegister.LARGE_SKILL_CRYSTAL,registry,"skill_c");
        this.aDI(ItemRegister.GIANT_SKILL_CRYSTAL,registry,"skill_c");
        this.aDI(ItemRegister.AMBIENT_INFUSION_STONE,registry,"ambient_is");
        this.aDI(ItemRegister.GLARING_INFUSION_STONE,registry,"glaring_is");
        this.aDI(ItemRegister.GLOWING_INFUSION_STONE,registry,"glowing_is");
        this.aDI(ItemRegister.SHINING_INFUSION_STONE,registry,"shining_is");
        this.aDI(ItemRegister.RADIANT_INFUSION_STONE,registry,"radiant_is");
        this.aDI(ItemRegister.BLOOMING_INFUSION_STONE,registry,"blooming_is");
        this.aDI(ItemRegister.GLISTENING_POWER_STONE,registry,"ps");
        this.aDI(ItemRegister.GLEAMING_POWER_STONE,registry,"ps");
        this.aDI(ItemRegister.AMBIENT_POWER_STONE,registry,"ps");
        this.aDI(ItemRegister.GLARING_POWER_STONE,registry,"ps");
        this.aDI(ItemRegister.GLOWING_POWER_STONE,registry,"ps");
        this.aDI(ItemRegister.SHINING_POWER_STONE,registry,"ps");
        this.aDI(ItemRegister.RADIANT_POWER_STONE,registry,"ps");
        this.aDI(ItemRegister.BLOOMING_POWER_STONE,registry,"ps");
        this.aDI(WeaponRegister.CORAL_CLOGGER,registry,"coral_c");
        this.aDI(WeaponRegister.CYCLONE,registry,"cyclone");
        this.aDI(WeaponRegister.DART_GUN,registry,"dart_g");
        this.aDI(WeaponRegister.DRACO,registry,"draco");
        this.aDI(WeaponRegister.DRAGILATOR,registry,"dragilator");
        this.aDI(WeaponRegister.ELECTINATOR,registry,"electinator");
        this.aDI(WeaponRegister.FLAMING_FURY,registry,"flaming_f");
        this.aDI(WeaponRegister.FLOWERS_FURY,registry,"flowers_f");
        this.aDI(WeaponRegister.FROSTICATOR,registry,"frosticator");
        this.aDI(WeaponRegister.GARDENER,registry,"gardener");
        this.aDI(WeaponRegister.GERMINATOR,registry,"germinator");
        this.aDI(WeaponRegister.MINIGUN,registry,"minigun");
        this.aDI(WeaponRegister.MK,registry,"mk");
        this.aDI(WeaponRegister.NETHENGEIC_SLUGGER,registry,"nethengeic_s");
        this.aDI(WeaponRegister.OVERSHOT,registry,"overshot");
        this.aDI(WeaponRegister.SPECTACLE,registry,"spectacle");
        this.aDI(WeaponRegister.WRECKER,registry,"wrecker");
        this.aDI(WeaponRegister.GAUGE_RIFLE,registry,"gauge_r");
        this.aDI(WeaponRegister.HAUNTER_RIFLE,registry,"haunter_r");
        this.aDI(WeaponRegister.LUNAR_ASSAULT_RIFLE,registry,"lunar_ar");
        this.aDI(WeaponRegister.ROCKER_RIFLE,registry,"rocker_r");







//this.aDI(ItemRegister.,registry,"");
            //Block
            this.aDBO(BlockRegister.CRYSTAL_EXTENSION_SHRINE,registry,"jei.des.ces");
        this.aDB(BlockRegister.AMETHYST_ORE,registry,"amethyst_o");
        this.aDB(BlockRegister.SAPPHIRE_ORE,registry,"sapphire_o");
        this.aDB(BlockRegister.BARONYTE_ORE,registry,"baronyte_o");
        this.aDB(BlockRegister.ELECANIUM_ORE,registry,"elecanium_o");
        this.aDB(BlockRegister.BLAZIUM_ORE,registry,"blazium_o");
        this.aDB(BlockRegister.BLOODSTONE_ORE,registry,"bloodstone_o");
        this.aDB(BlockRegister.BLUE_CRYSTAL_ORE,registry,"blue_co");
        this.aDB(BlockRegister.CHARGED_RUNIUM_ORE,registry,"charged_ro");
        this.aDB(BlockRegister.CHESTBONE_FRAGMENTS_ORE,registry,"chest_fo");
        this.aDB(BlockRegister.CRYSTALLITE_ORE,registry,"crystallite_o");
        this.aDB(BlockRegister.EMBERSTONE_ORE,registry,"emberstone_o");
        this.aDB(BlockRegister.FOOTBONE_FRAGMENTS_ORE,registry,"footbone_fo");
        this.aDB(BlockRegister.GEMENYTE_ORE,registry,"gemenyte_o");
        this.aDB(BlockRegister.GHASTLY_ORE,registry,"ghastly_o");
        this.aDB(BlockRegister.GHOULISH_ORE,registry,"ghoulish_o");
        this.aDB(BlockRegister.GREEN_CRYSTAL_ORE,registry,"green_co");
        this.aDB(BlockRegister.JADE_ORE,registry,"jade_o");
        this.aDB(BlockRegister.JEWELYTE_ORE,registry,"jewelyte_o");
        this.aDB(BlockRegister.LEGBONE_FRAGMENTS_ORE,registry,"legbone_fo");
        this.aDB(BlockRegister.LIMONITE_ORE,registry,"limonite_o");
        this.aDB(BlockRegister.LYON_ORE,registry,"lyon_o");
        this.aDB(BlockRegister.MYSTITE_ORE,registry,"mystite_o");
        this.aDB(BlockRegister.ORNAMYTE_ORE,registry,"ornamyte_o");
        this.aDB(BlockRegister.PURPLE_CRYSTAL_ORE,registry,"purple_co");
        this.aDB(BlockRegister.RED_CRYSTAL_ORE,registry,"red_co");
        this.aDB(BlockRegister.ROSITE_ORE,registry,"rosite_o");
        this.aDB(BlockRegister.RUNIUM_ORE,registry,"runium_o");
        this.aDB(BlockRegister.SHYREGEM_ORE,registry,"shyregem_o");
        this.aDB(BlockRegister.SHYRESTONE_ORE,registry,"shyrestone_o");
        this.aDB(BlockRegister.SKULLBONE_FRAGMENTS_ORE,registry,"skullbone_fo");
        this.aDB(BlockRegister.VARSIUM_ORE,registry,"varsium_o");
        this.aDB(BlockRegister.WHITE_CRYSTAL_ORE,registry,"white_co");
        this.aDB(BlockRegister.YELLOW_CRYSTAL_ORE,registry,"yellow_co");
        this.aDB(BlockRegister.ENIGMA_TABLE,registry,"enigma_t");
        this.aDB(BlockRegister.VOX_CRATE,registry,"vox_c");
        this.aDB(BlockRegister.TEA_SINK,registry,"tea_s");
        this.aDB(BlockRegister.IRO_CRATE,registry,"iro_c");
        this.aDB(BlockRegister.EXTRACTION_DEVICE,registry,"extraction_d");
        this.aDB(BlockRegister.DEEP_CASE,registry,"deep_c");
        this.aDB(BlockRegister.CREATION_FORGE,registry,"creation_f");
        this.aDB(BlockRegister.DIVINE_STATION,registry,"divine_s");
        this.aDB(BlockRegister.INFUSION_TABLE,registry,"infusion_t");
        this.aDB(BlockRegister.LUNAR_CREATION_TABLE,registry,"lunar_ct");
        this.aDB(BlockRegister.LUNAR_ENRICHMENT_TABLE,registry,"lunar_et");
        this.aDB(BlockRegister.MINERALIZATION_STATION,registry,"mineralization_s");
        this.aDB(BlockRegister.PETAL_CRAFTING_STATION,registry,"petal_cs");
        this.aDB(BlockRegister.RUNE_RANDOMIZER,registry,"rune_r");
        this.aDB(BlockRegister.RUNIC_BLOCK,registry,"runic_b");
        this.aDB(BlockRegister.VOX_STORE_CRATE,registry,"vox_sc");
        this.aDB(BlockRegister.WHITEWASHING_TABLE,registry,"whitewashing_t");





//this.aDB(BlockRegister.,registry,"");


    }

    @Optional.Method(modid = "solomon")
    void SolomonSupport(IModRegistry registry){

            this.aDBO(BlockLiakmion.block,registry,"jei.des.lianjin");

    }

    /**
     * 用于为一个物品添加JEI信息
     * @param item 在此输入要添加JEI信息的物品
     * @param registry 用于填入被覆写的register方法的register参数
     * @param key 信息文本的本地化键
     */
    @Deprecated
    private void aDIO(Item item, IModRegistry registry, String key){
        registry.addIngredientInfo(new ItemStack(item,1),ItemStack.class, I18n.format(key));
    }

    /**
     * 用于为一个方块添加JEI信息
     * @param block 在此输入要添加JEI信息的方块
     * @param registry 用于填入被覆写的register方法的register参数
     * @param key 信息文本的本地化键
     */
    @Deprecated
    private void aDBO(Block block, IModRegistry registry, String key){
        registry.addIngredientInfo(new ItemStack(block,1),ItemStack.class, I18n.format(key));
    }

    /**
     * 用于为一个物品添加JEI信息
     * @param item 在此输入要添加JEI信息的物品
     * @param registry 用于填入被覆写的register方法的register参数
     * @param key 信息文本的部分本地化键，实际本地化键会为"jei.des" + 参数
     */
    private void aDI(Item item, IModRegistry registry, String key){
        registry.addIngredientInfo(new ItemStack(item,1),ItemStack.class, I18n.format("jei.des"+key));
    }

    /**
     * 用于为一个方块添加JEI信息
     * @param block 在此输入要添加JEI信息的方块
     * @param registry 用于填入被覆写的register方法的register参数
     * @param key 信息文本的部分本地化键，实际本地化键会为"jei.des" + 参数
     */
    private void aDB(Block block, IModRegistry registry, String key){
        registry.addIngredientInfo(new ItemStack(block,1),ItemStack.class, I18n.format("jei.des"+key));
    }

}
