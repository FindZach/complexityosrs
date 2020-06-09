package gg.rsmod.plugins.content.skills.cooking.data

import gg.rsmod.plugins.api.cfg.Items


enum class MeatType (val raw: Int,val cooked: Int,val burnt: Int, val levelRequired: Int, val noburnLevel: Int,val xp : Double) {
    SHRIMPS(Items.RAW_SHRIMPS, Items.SHRIMPS, Items.BURNT_FISH, 1,34, 30.0),
    SARDINE(Items.RAW_SARDINE, Items.SARDINE, Items.BURNT_FISH_369, 1,38, 40.0),
    ANCHOVIES(Items.RAW_ANCHOVIES, Items.ANCHOVIES, Items.BURNT_FISH, 1,34, 30.0),
    HERRING(Items.RAW_HERRING, Items.HERRING, Items.BURNT_FISH_357, 5,41, 50.0),
    MACKEREL(Items.RAW_MACKEREL, Items.MACKEREL, Items.BURNT_FISH_357, 10,45, 60.0),
    TROUT(Items.RAW_TROUT, Items.TROUT, Items.BURNT_FISH_343, 15,50, 70.0),
    COD(Items.RAW_TROUT, Items.TROUT, Items.BURNT_FISH_343, 18,52, 75.0),
    PIKE(Items.RAW_PIKE, Items.PIKE, Items.BURNT_FISH_343, 20,53, 80.0),
    SALMON(Items.RAW_SALMON, Items.SALMON, Items.BURNT_FISH_343, 25,58, 90.0),
    SLIMY_EEL(Items.RAW_SLIMY_EEL, Items.COOKED_SLIMY_EEL, Items.BURNT_EEL, 28,58, 95.0),
    TUNA(Items.RAW_TUNA, Items.TUNA, Items.BURNT_FISH_367, 30,65, 100.0),
    BASS(Items.RAW_BASS, Items.BASS, Items.BURNT_FISH_367, 43,80, 130.0),
    KARAMBWAN(Items.RAW_KARAMBWAN, Items.COOKED_KARAMBWAN, Items.BURNT_KARAMBWAN, 30,200, 190.0),
    RAINBOW_FISH(Items.RAW_RAINBOW_FISH, Items.RAINBOW_FISH, Items.BURNT_RAINBOW_FISH, 35,60, 110.0),
    CAVE_EEL(Items.RAW_CAVE_EEL, Items.CAVE_EEL, Items.BURNT_CAVE_EEL, 38,40, 115.0),
    LOBSTER(Items.RAW_LOBSTER, Items.LOBSTER, Items.BURNT_LOBSTER, 40,74, 120.0),
    SWORDFISH(Items.RAW_SWORDFISH, Items.SWORDFISH, Items.BURNT_SWORDFISH, 46,86, 140.0),
    LAVA_EEL(Items.RAW_LAVA_EEL, Items.LAVA_EEL, Items.BURNT_EEL, 53,65, 30.0),
    MONKFISH(Items.RAW_MONKFISH, Items.MONKFISH, Items.BURNT_MONKFISH, 80,65, 150.0),
    SHARK(Items.RAW_SHARK, Items.SHARK, Items.BURNT_SHARK, 82,65, 210.0),
    SEA_TURTLE(Items.RAW_SEA_TURTLE, Items.SEA_TURTLE, Items.BURNT_SEA_TURTLE, 30,65, 212.0),
    MANTA_RAY(Items.RAW_MANTA_RAY, Items.MANTA_RAY, Items.BURNT_MANTA_RAY, 91,150, 216.0),
    ANGLERFISH(Items.RAW_ANGLERFISH, Items.ANGLERFISH, Items.BURNT_ANGLERFISH, 84,99, 230.0),
    DARK_CRAB(Items.RAW_DARK_CRAB, Items.DARK_CRAB, Items.BURNT_DARK_CRAB, 90,185, 215.0);

    companion object {

        /**
         * The cached array of enum definitions
         */
        val values = enumValues<MeatType>()

        /**
         * The map of meat ids to their definitions
         */
        val meatDefinitions = values.associateBy { it.raw }
    }
}