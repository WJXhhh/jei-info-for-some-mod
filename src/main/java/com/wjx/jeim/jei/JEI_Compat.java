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
import net.tslat.aoa3.common.registration.ToolRegister;
import net.tslat.aoa3.common.registration.WeaponRegister;

import java.util.IllegalFormatException;
import java.util.Locale;

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
        this.aDI(WeaponRegister.AQUA_CANNON,registry,"aqua_c");
        this.aDI(WeaponRegister.BALLOON_BOMBER,registry,"balloon_b");
        this.aDI(WeaponRegister.BIG_BLAST,registry,"big_b");
        this.aDI(WeaponRegister.BOULDER_BOMBER,registry,"boulder_b");
        this.aDI(WeaponRegister.CLOWN_CANNON,registry,"clown_c");
        this.aDI(WeaponRegister.CORAL_CANNON,registry,"coral_c");
        this.aDI(WeaponRegister.DISCHARGE_CANNON,registry,"discharge_c");
        this.aDI(WeaponRegister.EREBON_STICKLER,registry,"erebon_s");
        this.aDI(WeaponRegister.GIGA_CANNON,registry,"giga_c");
        this.aDI(WeaponRegister.IRO_CANNON,registry,"iro_c");
        this.aDI(WeaponRegister.LUXON_STICKLER,registry,"luxon_s");
        this.aDI(WeaponRegister.MINI_CANNON,registry,"mini_c");
        this.aDI(WeaponRegister.PLUTON_STICKLER,registry,"pluton_s");
        this.aDI(WeaponRegister.SELYAN_STICKLER,registry,"selyan_s");
        this.aDI(WeaponRegister.SUPER_CANNON,registry,"super_c");
        this.aDI(WeaponRegister.ULTRA_CANNON,registry,"ultra_c");
        this.aDI(WeaponRegister.VOX_CANNON,registry,"vox_c");
        this.aDI(WeaponRegister.WITHER_CANNON,registry,"wither_c");
        this.aDI(WeaponRegister.BARON_SSR,registry,"baron_s");
        this.aDI(WeaponRegister.HEAD_HUNTER,registry,"head_h");
        this.aDI(WeaponRegister.MONSTER,registry,"monster");
        this.aDI(WeaponRegister.ROSID_RIFLE,registry,"rosid_r");
        this.aDI(WeaponRegister.BLAST_BARREL,registry,"blast_b");
        this.aDI(WeaponRegister.DEMOLISHER,registry,"demolisher");
        this.aDI(WeaponRegister.DISCHARGE_SHOTGUN,registry,"discharge_s");
        this.aDI(WeaponRegister.GIMMICK,registry,"gimmick");
        this.aDI(WeaponRegister.BEAMER,registry,"beamer");
        this.aDI(WeaponRegister.COLOUR_CANNON,registry,"colour_c");
        this.aDI(WeaponRegister.CONFETTI_CANNON,registry,"confetti_c");
        this.aDI(WeaponRegister.CONFETTI_CLUSTER,registry,"confetti_c");
        this.aDI(WeaponRegister.DARK_DESTROYER,registry,"dark_d");
        this.aDI(WeaponRegister.FLOWERCORNE,registry,"flowercorne");
        this.aDI(WeaponRegister.ILLUSION_SMG,registry,"illusion_s");
        this.aDI(WeaponRegister.IRO_MINER,registry,"iro_m");
        this.aDI(WeaponRegister.LASER_BLASTER,registry,"laser_b");
        this.aDI(WeaponRegister.PARALYZER,registry,"paralyzer");
        this.aDI(WeaponRegister.POWER_RAY,registry,"power_r");
        this.aDI(WeaponRegister.PROTON,registry,"proton");
        this.aDI(WeaponRegister.REEFER,registry,"reefer");
        this.aDI(WeaponRegister.SOUL_SPARK,registry,"soul_s");
        this.aDI(WeaponRegister.SPIRIT_SHOWER,registry,"spirit_s");
        this.aDI(WeaponRegister.VORTEX_BLASTER,registry,"vortex_b");
        this.aDI(WeaponRegister.WITHERS_WRATH,registry,"withers_w");
        this.aDI(ItemRegister.BALLOON,registry,"balloon");
        this.aDI(ItemRegister.COMPASS_RUNE,registry,"compass_r");
        this.aDI(ItemRegister.DISCHARGE_CAPSULE,registry,"discharge_ca");
        this.aDI(ItemRegister.DISTORTION_RUNE,registry,"distortion_r");
        this.aDI(ItemRegister.ENERGY_RUNE,registry,"energy_r");
        this.aDI(ItemRegister.FIRE_RUNE,registry,"fire_r");
        this.aDI(ItemRegister.POP_SHOT,registry,"pop_s");
        this.aDI(ItemRegister.KINETIC_RUNE,registry,"kinetic_r");
        this.aDI(ItemRegister.LIFE_RUNE,registry,"life_r");
        this.aDI(ItemRegister.LUNAR_RUNE,registry,"lunar_r");
        this.aDI(ItemRegister.POISON_RUNE,registry,"poison_r");
        this.aDI(ItemRegister.POWER_RUNE,registry,"power_r");
        this.aDI(ItemRegister.STORM_RUNE,registry,"storm_r");
        this.aDI(ItemRegister.STRIKE_RUNE,registry,"strike_r");
        this.aDI(ItemRegister.WATER_RUNE,registry,"water_r");
        this.aDI(ItemRegister.WIND_RUNE,registry,"wind_r");
        this.aDI(ItemRegister.WITHER_RUNE,registry,"wither_r");
        this.aDI(WeaponRegister.SLICE_STAR,registry,"slice_s");
        this.aDI(WeaponRegister.VULKRAM,registry,"vulkram");
        this.aDI(WeaponRegister.CHAKRAM,registry,"chakram");
        this.aDI(WeaponRegister.RUNIC_BOMB,registry,"runic_bo");
        this.aDI(WeaponRegister.GOO_BALL,registry,"goo_b");
        this.aDI(WeaponRegister.HELLFIRE,registry,"hellfire");
        this.aDI(WeaponRegister.CRYSTAL_MAUL,registry,"crystal_m");
        this.aDI(WeaponRegister.VULCAMMER_MAUL,registry,"vulcammer_m");
        this.aDI(WeaponRegister.ELECTRON_MAUL,registry,"electron_m");
        this.aDI(WeaponRegister.PRIMAL_SWORD,registry,"primal_s");
        this.aDI(WeaponRegister.BARON_SWORD,registry,"baron_s");
        this.aDI(WeaponRegister.CARAMEL_CARVER,registry,"caramel_c");
        this.aDI(WeaponRegister.CORALSTORM_SWORD,registry,"CORALSTORM_SWORD");
        this.aDI(WeaponRegister.CREEPIFIED_SWORD,registry,"CREEPIFIED_SWORD");
        this.aDI(WeaponRegister.EXPLOCHRON_SWORD,registry,"EXPLOCHRON_SWORD");
        this.aDI(WeaponRegister.GUARDIANS_SWORD,registry,"GUARDIANS_SWORD");
        this.aDI(WeaponRegister.HARVESTER_SWORD,registry,"HARVESTER_SWORD");
        this.aDI(WeaponRegister.HOLY_SWORD,registry,"HOLY_SWORD");
        this.aDI(WeaponRegister.ILLUSION_SWORD,registry,"ILLUSION_SWORD");
        this.aDI(WeaponRegister.LEGBONE_SWORD,registry,"LEGBONE_SWORD");
        this.aDI(WeaponRegister.NETHENGEIC_SWORD,registry,"NETHENGEIC_SWORD");
        this.aDI(WeaponRegister.ROCKBASHER_SWORD,registry,"ROCKBASHER_SWORD");
        this.aDI(WeaponRegister.ROCK_PICK_SWORD,registry,"ROCK_PICK_SWORD");
        this.aDI(WeaponRegister.ROSIDIAN_SWORD,registry,"ROSIDIAN_SWORD");
        this.aDI(WeaponRegister.RUNIC_SWORD,registry,"RUNIC_SWORD");
        this.aDI(WeaponRegister.SHROOMUS_SWORD,registry,"SHROOMUS_SWORD");
        this.aDI(WeaponRegister.SKELETAL_SWORD,registry,"SKELETAL_SWORD");
        this.aDI(WeaponRegister.TROLL_BASHER_AXE,registry,"TROLL_BASHER_AXE");
        this.aDI(WeaponRegister.ULTRAFLAME,registry,"ULTRAFLAME");
        this.aDI(WeaponRegister.VOID_SWORD,registry,"VOID_SWORD");
        this.aDI(WeaponRegister.BARON_GREATBLADE,registry,"BARON_GREATBLADE");
        this.aDI(WeaponRegister.CANDY_BLADE,registry,"CANDY_BLADE");
        this.aDI(WeaponRegister.COTTON_CRUSHER,registry,"COTTON_CRUSHER");
        this.aDI(WeaponRegister.CRYSTAL_GREATBLADE,registry,"CRYSTAL_GREATBLADE");
        this.aDI(WeaponRegister.GODS_GREATBLADE,registry,"GODS_GREATBLADE");
        this.aDI(WeaponRegister.LUNAR_GREATBLADE,registry,"LUNAR_GREATBLADE");
        this.aDI(WeaponRegister.HAUNTED_GREATBLADE,registry,"HAUNTED_GREATBLADE");
        this.aDI(WeaponRegister.LYONIC_GREATBLADE,registry,"LYONIC_GREATBLADE");
        this.aDI(WeaponRegister.NOXIOUS_GREATBLADE,registry,"NOXIOUS_GREATBLADE");
        this.aDI(WeaponRegister.PRIMORDIAL_GREATBLADE,registry,"PRIMORDIAL_GREATBLADE");
        this.aDI(WeaponRegister.ROSIDIAN_GREATBLADE,registry,"ROSIDIAN_GREATBLADE");
        this.aDI(WeaponRegister.SUBTERRANEAN_GREATBLADE,registry,"SUBTERRANEAN_GREATBLADE");
        this.aDI(WeaponRegister.TIDAL_GREATBLADE,registry,"TIDAL_GREATBLADE");
        this.aDI(WeaponRegister.DAYBREAKER_BOW,registry,"DAYBREAKER_BOW");
        this.aDI(WeaponRegister.EXPLOSIVE_BOW,registry,"EXPLOSIVE_BOW");
        this.aDI(WeaponRegister.POISON_BOW,registry,"POISON_BOW");
        this.aDI(WeaponRegister.RUNIC_BOW,registry,"RUNIC_BOW");
        this.aDI(WeaponRegister.SLINGSHOT,registry,"SLINGSHOT");
        this.aDI(WeaponRegister.SUNSHINE_BOW,registry,"SUNSHINE_BOW");
        this.aDI(WeaponRegister.WITHER_BOW,registry,"WITHER_BOW");
        this.aDI(WeaponRegister.BOREIC_BOW,registry,"BOREIC_BOW");
        this.aDI(WeaponRegister.DEEP_BOW,registry,"DEEP_BOW");
        this.aDI(WeaponRegister.PRIMORDIAL_BOW,registry,"PRIMORDIAL_BOW");
        this.aDI(WeaponRegister.SKYDRIVER_BOW,registry,"SKYDRIVER_BOW");
        this.aDI(WeaponRegister.LIGHTSHINE,registry,"LIGHTSHINE");
        this.aDI(WeaponRegister.WARLOCK_STAFF,registry,"WARLOCK_STAFF");
        this.aDI(WeaponRegister.ATLANTIC_STAFF,registry,"ATLANTIC_STAFF");
        this.aDI(WeaponRegister.CANDY_STAFF,registry,"CANDY_STAFF");
        this.aDI(WeaponRegister.CONCUSSION_STAFF,registry,"CONCUSSION_STAFF");
        this.aDI(WeaponRegister.CORAL_STAFF,registry,"CORAL_STAFF");
        this.aDI(WeaponRegister.CRYSTAL_STAFF,registry,"CRYSTAL_STAFF");
        this.aDI(WeaponRegister.CRYSTON_STAFF,registry,"CRYSTON_STAFF");
        this.aDI(WeaponRegister.EVERFIGHT_STAFF,registry,"coral_c");
        this.aDI(WeaponRegister.EVERMIGHT_STAFF,registry,"coral_c");
        this.aDI(WeaponRegister.FIREFLY_STAFF,registry,"FIREFLY_STAFF");
        this.aDI(WeaponRegister.FUNGAL_STAFF,registry,"FUNGAL_STAFF");
        this.aDI(WeaponRegister.GHOUL_STAFF,registry,"GHOUL_STAFF");
        this.aDI(WeaponRegister.HAUNTERS_STAFF,registry,"HAUNTERS_STAFF");
        this.aDI(WeaponRegister.HIVE_STAFF,registry,"HIVE_STAFF");
        this.aDI(WeaponRegister.JOKER_STAFF,registry,"JOKER_STAFF");
        this.aDI(WeaponRegister.KAIYU_STAFF,registry,"KAIYU_STAFF");
        this.aDI(WeaponRegister.LUNAR_STAFF,registry,"LUNAR_STAFF");
        this.aDI(WeaponRegister.METEOR_STAFF,registry,"METEOR_STAFF");
        this.aDI(WeaponRegister.NATURE_STAFF,registry,"NATURE_STAFF");
        this.aDI(WeaponRegister.NIGHTMARE_STAFF,registry,"NIGHTMARE_STAFF");
        this.aDI(WeaponRegister.NOXIOUS_STAFF,registry,"NOXIOUS_STAFF");
        this.aDI(WeaponRegister.PHANTOM_STAFF,registry,"PHANTOM_STAFF");
        this.aDI(WeaponRegister.PRIMORDIAL_STAFF,registry,"PRIMORDIAL_STAFF");
        this.aDI(WeaponRegister.REEF_STAFF,registry,"REEF_STAFF");
        this.aDI(WeaponRegister.RUNIC_STAFF,registry,"RUNIC_STAFF");
        this.aDI(WeaponRegister.SHADOWLORD_STAFF,registry,"SHADOWLORD_STAFF");
        this.aDI(WeaponRegister.SUN_STAFF,registry,"SUN_STAFF");
        this.aDI(WeaponRegister.TANGLE_STAFF,registry,"TANGLE_STAFF");
        this.aDI(WeaponRegister.ULTIMATUM_STAFF,registry,"ULTIMATUM_STAFF");
        this.aDI(WeaponRegister.WEB_STAFF,registry,"WEB_STAFF");
        this.aDI(WeaponRegister.WIZARDS_STAFF,registry,"WIZARDS_STAFF");
        this.aDI(WeaponRegister.VULCANE,registry,"VULCANE");
        this.aDI(ItemRegister.INCOMPLETE_MECHA_BOW,registry,"INCOMPLETE_MECHA_BOW");
        this.aDI(ItemRegister.INCOMPLETE_MECHA_CANNON,registry,"INCOMPLETE_MECHA_BOW");
        this.aDI(ItemRegister.INCOMPLETE_MECHANICAL_ASSAULT_RIFLE,registry,"INCOMPLETE_MECHA_BOW");
        this.aDI(ItemRegister.INCOMPLETE_MECHA_STAFF,registry,"INCOMPLETE_MECHA_BOW");
        this.aDI(ItemRegister.INCOMPLETE_MECHYRO,registry,"INCOMPLETE_MECHA_BOW");
        this.aDI(ItemRegister.INCOMPLETE_MECHA_ARCHERGUN,registry,"INCOMPLETE_MECHA_BOW");
        this.aDI(ItemRegister.MECHA_GEAR,registry,"MECHA_GEAR");
        this.aDI(ItemRegister.APOCO_STONE,registry,"APOCO_STONE");
        this.aDI(ItemRegister.UNCHARGED_STONE,registry,"UNCHARGED_STONE");
        this.aDI(ItemRegister.GRAVITATOR,registry,"GRAVITATOR");
        this.aDI(ItemRegister.WORN_BOOK,registry,"WORN_BOOK");
        this.aDI(ItemRegister.AMPHIBIYTE_LUNG,registry,"AMPHIBIYTE_LUNG");
        this.aDI(ItemRegister.GOLD_SPRING,registry,"GOLD_SPRING");
        this.aDI(ItemRegister.HIVE_EGG,registry,"HIVE_EGG");
        this.aDI(ItemRegister.ANCIENT_RING,registry,"ANCIENT_RING");
        this.aDI(ItemRegister.BOOK_OF_SHADOWS,registry,"BOOK_OF_SHADOWS");
        this.aDI(ItemRegister.CALL_OF_THE_DRAKE,registry,"CALL_OF_THE_DRAKE");
        this.aDI(ItemRegister.EXPLOSIVE_IDOL,registry,"EXPLOSIVE_IDOL");
        this.aDI(ItemRegister.GUARDIANS_EYE,registry,"GUARDIANS_EYE");
        this.aDI(ItemRegister.HAUNTED_IDOL,registry,"HAUNTED_IDOL");
        this.aDI(ItemRegister.HEAVY_BOULDER,registry,"HEAVY_BOULDER");
        this.aDI(ItemRegister.NETHENGEIC_CALLSTONE,registry,"NETHENGEIC_CALLSTONE");
        this.aDI(ItemRegister.OBSERVING_EYE,registry,"OBSERVING_EYE");
        this.aDI(ItemRegister.STARING_EYE,registry,"STARING_EYE");
        this.aDI(ItemRegister.TOY_GYROCOPTER,registry,"TOY_GYROCOPTER");
        this.aDI(ItemRegister.TREAT_BAG,registry,"TREAT_BAG");
        this.aDI(ItemRegister.VOLIANT_HEART,registry,"VOLIANT_HEART");
        this.aDI(ItemRegister.CANDY_CORN,registry,"CANDY_CORN");
        this.aDI(ItemRegister.GINGERBREAD_COOKIE,registry,"GINGERBREAD_COOKIE");
        this.aDI(ItemRegister.GINGERBREAD_WING,registry,"GINGERBREAD_WING");
        this.aDI(ItemRegister.PEPPERMINT_CANDY,registry,"PEPPERMINT_CANDY");
        this.aDI(ItemRegister.SPEARMINT_CANDY,registry,"SPEARMINT_CANDY");
        this.aDI(ItemRegister.SOUR_CANDY,registry,"SOUR_CANDY");
        this.aDI(ItemRegister.SOUR_GUMMY,registry,"SOUR_GUMMY");
        this.aDI(ItemRegister.SOUR_POP,registry,"SOUR_POP");
        this.aDI(ToolRegister.OCCULT_AXE,registry,"OCCULT_AXE");
        this.aDI(ToolRegister.OCCULT_PICKAXE,registry,"OCCULT_PICKAXE");
        this.aDI(ToolRegister.OCCULT_SHOVEL,registry,"OCCULT_SHOVEL");
        this.aDI(ToolRegister.SOULSTONE_AXE,registry,"SOULSTONE_AXE");
        this.aDI(ToolRegister.SOULSTONE_PICKAXE,registry,"SOULSTONE_AXE");
        this.aDI(ToolRegister.SOULSTONE_SHOVEL,registry,"SOULSTONE_AXE");
        this.aDI(ToolRegister.ENERGISTIC_AXE,registry,"SOULSTONE_AXE");
        this.aDI(ToolRegister.ENERGISTIC_PICKAXE,registry,"SOULSTONE_AXE");
        this.aDI(ToolRegister.ENERGISTIC_SHOVEL,registry,"SOULSTONE_AXE");
        this.aDI(ToolRegister.CHAINSAW,registry,"CHAINSAW");
        this.aDI(ItemRegister.SCREAM_SHIELD,registry,"SCREAM_SHIELD");
        this.aDI(WeaponRegister.PYRO_ARCHERGUN,registry,"PYRO_ARCHERGUN");
        this.aDI(WeaponRegister.ROSIDIAN_ARCHERGUN,registry,"TROSIDIAN_ARCHERGUN");
        this.aDI(WeaponRegister.SKELETAL_ARCHERGUN,registry,"SKELETAL_ARCHERGUN");
        this.aDI(WeaponRegister.TROLLS_ARCHERGUN,registry,"TROLLS_ARCHERGUN");
        this.aDI(ItemRegister.HYDRO_STONE,registry,"HYDRO_STONE");
        this.aDI(ItemRegister.PURE_WATER_STONE,registry,"PURE_WATER_STONE");




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
        this.aDB(BlockRegister.ILLUSION_ALTAR,registry,"ILLUSION_ALTAR");
        this.aDB(BlockRegister.GUARDIAN_ALTAR,registry,"GUARDIAN_ALTAR");
        this.aDB(BlockRegister.SHADOW_ALTAR,registry,"SHADOW_ALTAR");
        this.aDB(BlockRegister.VINOCORNE_SHRINE,registry,"VINOCORNE_SHRINE");
        this.aDB(BlockRegister.ARMY_BLOCK,registry,"ARMY_BLOCK");
        this.aDB(BlockRegister.BARONESS_ALTAR,registry,"BARONESS_ALTAR");
        this.aDB(BlockRegister.CLUNKHEAD_ALTAR,registry,"CLUNKHEAD_ALTAR");
        this.aDB(BlockRegister.CRAEXXEUS_ALTAR,registry,"CRAEXXEUS_ALTAR");
        this.aDB(BlockRegister.CREEP_ALTAR,registry,"CREEP_ALTAR");
        this.aDB(BlockRegister.DRACYON_ALTAR,registry,"DRACYON_ALTAR");
        this.aDB(BlockRegister.GRAW_ALTAR,registry,"GRAW_ALTAR");
        this.aDB(BlockRegister.HIVE_SPAWNER,registry,"HIVE_SPAWNER");
        this.aDB(BlockRegister.KROR_ALTAR,registry,"KROR_ALTAR");
        this.aDB(BlockRegister.MECHBOT_ALTAR,registry,"MECHBOT_ALTAR");
        this.aDB(BlockRegister.PRIMORDIAL_SHRINE,registry,"PRIMORDIAL_SHRINE");






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
     * @param key 信息文本的部分本地化键，实际本地化键会为"jei.des" + 参数，会自动将大写转小写
     */
    private void aDI(Item item, IModRegistry registry, String key){
        String key_o = key.toLowerCase();
        registry.addIngredientInfo(new ItemStack(item,1),ItemStack.class, I18n.format("jei.des."+key_o));
    }

    /**
     * 用于为一个方块添加JEI信息
     * @param block 在此输入要添加JEI信息的方块
     * @param registry 用于填入被覆写的register方法的register参数
     * @param key 信息文本的部分本地化键，实际本地化键会为"jei.des" + 参数
     */
    private void aDB(Block block, IModRegistry registry, String key){
        registry.addIngredientInfo(new ItemStack(block,1),ItemStack.class, I18n.format("jei.des."+key));
    }

}
