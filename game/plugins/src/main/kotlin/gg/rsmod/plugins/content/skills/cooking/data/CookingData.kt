package gg.rsmod.plugins.content.skills.cooking.data

import gg.rsmod.plugins.api.cfg.Items

enum class MixType(val firstComponent : Int , val secondComponent : Int,val  reqLevel : Int ,val xp : Double,val possibleMixResults: IntArray, val extraSlotNeeded : Boolean) {

    DOUGH_JUG(Items.POT_OF_FLOUR,Items.JUG_OF_WATER, 1, 0.0 ,intArrayOf(Items.BREAD_DOUGH , Items.PASTRY_DOUGH, Items.PIZZA_BASE),true),
    DOUGH_BUCKET(Items.POT_OF_FLOUR, Items.BUCKET_OF_WATER,1, 0.0 , intArrayOf(Items.BREAD_DOUGH , Items.PASTRY_DOUGH, Items.PIZZA_BASE),true),

    PIE_SHELL(Items.PASTRY_DOUGH,Items.PIE_DISH,1, 0.0 ,intArrayOf(Items.PIE_SHELL),false),
    UNCOOKED_BERRY_PIE(Items.PIE_SHELL,Items.REDBERRIES,10, 0.0 ,intArrayOf(Items.UNCOOKED_BERRY_PIE),false),
    UNCOOKED_MEAT_PIE(Items.PIE_SHELL,Items.COOKED_MEAT,20, 0.0 ,intArrayOf(Items.UNCOOKED_MEAT_PIE),false),
    UNCOOKED_APPLE_PIE(Items.PIE_SHELL,Items.COOKING_APPLE,30, 0.0 ,intArrayOf(Items.UNCOOKED_APPLE_PIE),false),
    UNCOOKED_BOTANICAL_PIE(Items.PIE_SHELL,Items.GOLOVANOVA_FRUIT_TOP,52, 0.0 ,intArrayOf(Items.UNCOOKED_BOTANICAL_PIE),false),
    UNCOOKED_MUSHROOM_PIE(Items.PIE_SHELL,Items.SULLIUSCEP_CAP,60, 0.0 ,intArrayOf(Items.UNCOOKED_MUSHROOM_PIE),false),
    UNCOOKED_DRAGONFRUIT_PIE(Items.PIE_SHELL,Items.DRAGONFRUIT,73, 0.0 ,intArrayOf(Items.UNCOOKED_DRAGONFRUIT_PIE),false),

    PART_GARDEN_1(Items.PIE_SHELL,Items.TOMATO,34, 0.0 ,intArrayOf(Items.PART_GARDEN_PIE),false),
    PART_GARDEN_2(Items.PART_GARDEN_PIE,Items.ONION,34, 0.0 ,intArrayOf(Items.PART_GARDEN_PIE_7174),false),
    RAW_GARDEN_PIE(Items.PART_GARDEN_PIE_7174,Items.CABBAGE,34, 0.0 ,intArrayOf(Items.RAW_GARDEN_PIE),false),

    PART_FISH_1(Items.PIE_SHELL,Items.TROUT,47, 0.0 ,intArrayOf(Items.PART_FISH_PIE),false),
    PART_FISH_2(Items.PART_FISH_PIE,Items.COD,47, 0.0 ,intArrayOf(Items.PART_FISH_PIE_7184),false),
    RAW_FISH_PIE(Items.PART_FISH_PIE_7184,Items.POTATO,47, 0.0 ,intArrayOf(Items.RAW_FISH_PIE),false),
    //ADMIRAL PIE
    PART_ADMIRAL_1(Items.PIE_SHELL,Items.SALMON,70, 0.0 ,intArrayOf(Items.PART_ADMIRAL_PIE),false),
    PART_ADMIRAL_2(Items.PART_ADMIRAL_PIE,Items.TUNA,70, 0.0 ,intArrayOf(Items.PART_ADMIRAL_PIE_7194),false),
    RAW_ADMIRAL_PIE(Items.PART_ADMIRAL_PIE_7194,Items.POTATO,70, 0.0 ,intArrayOf(Items.RAW_ADMIRAL_PIE),false),

    PART_WILD_1(Items.PIE_SHELL,Items.RAW_BEAR_MEAT,85, 0.0 ,intArrayOf(Items.PART_WILD_PIE),false),
    PART_WILD_2(Items.PART_FISH_PIE,Items.RAW_CHOMPY,85, 0.0 ,intArrayOf(Items.PART_WILD_PIE_7204),false),
    RAW_WILD_PIE(Items.PART_WILD_PIE_7204,Items.RAW_RABBIT,85, 0.0 ,intArrayOf(Items.RAW_WILD_PIE),false),

    PART_SUMMER_1(Items.PIE_SHELL,Items.STRAWBERRY,95, 0.0 ,intArrayOf(Items.PART_SUMMER_PIE),false),
    PART_SUMMER_2(Items.PART_SUMMER_PIE,Items.WATERMELON,95, 0.0 ,intArrayOf(Items.PART_SUMMER_PIE_7214),false),
    RAW_SUMMER_PIE(Items.PART_SUMMER_PIE_7214,Items.COOKING_APPLE,95, 0.0 ,intArrayOf(Items.RAW_SUMMER_PIE),false);

    companion object {

        /**
         * The cached array of enum definitions
         */
        val values = enumValues<MixType>()

        val mixDefinitionsResults = values.associateBy { it.possibleMixResults }
        /**
         * The map of mix ids to their definitions
         */
        val mixDefinitions = values.associateBy { it.firstComponent }
        //val mixDefinitions = values. { it.firstComponent }
    }
}