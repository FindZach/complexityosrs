package gg.rsmod.plugins.content.skills.herblore.herbs

import gg.rsmod.plugins.api.cfg.Items


enum class herbs (val cleanItemId: Int, val dirtyItemId: Int, val unfPotionId: Int, val cleanRequirement: Int){
    GUAM(cleanItemId = Items.GUAM_LEAF, dirtyItemId = Items.GRIMY_GUAM_LEAF, unfPotionId = Items.GUAM_POTION_UNF, cleanRequirement = 1),
    MARRENTILL(cleanItemId = Items.MARRENTILL, dirtyItemId = Items.GRIMY_MARRENTILL, unfPotionId = Items.MARRENTILL_POTION_UNF, cleanRequirement = 5),
    TARROMIN(cleanItemId = Items.TARROMIN, dirtyItemId = Items.GRIMY_TARROMIN, unfPotionId = Items.TARROMIN_POTION_UNF, cleanRequirement = 11),
    HARRALANDER(cleanItemId = Items.HARRALANDER, dirtyItemId = Items.GRIMY_HARRALANDER, unfPotionId = Items.HARRALANDER_POTION_UNF, cleanRequirement = 20),
    RANARR(cleanItemId = Items.RANARR_WEED, dirtyItemId = Items.GRIMY_RANARR_WEED, unfPotionId = Items.RANARR_POTION_UNF, cleanRequirement = 25),
    TOADFLAX(cleanItemId = Items.TOADFLAX, dirtyItemId = Items.GRIMY_TOADFLAX, unfPotionId = Items.TOADFLAX_POTION_UNF, cleanRequirement = 30),
    IRIT(cleanItemId = Items.IRIT_LEAF, dirtyItemId = Items.GRIMY_IRIT_LEAF, unfPotionId = Items.IRIT_POTION_UNF, cleanRequirement = 40),
    AVANTOE(cleanItemId = Items.AVANTOE, dirtyItemId = Items.GRIMY_AVANTOE, unfPotionId = Items.AVANTOE_POTION_UNF, cleanRequirement = 48),
    KWUARM(cleanItemId = Items.KWUARM, dirtyItemId = Items.GRIMY_KWUARM, unfPotionId = Items.KWUARM_POTION_UNF, cleanRequirement = 54),
    SNAPDRAGON(cleanItemId = Items.SNAPDRAGON, dirtyItemId = Items.GRIMY_SNAPDRAGON, unfPotionId = Items.SNAPDRAGON_POTION_UNF, cleanRequirement = 59),
    CADANTINE(cleanItemId = Items.CADANTINE, dirtyItemId = Items.GRIMY_CADANTINE, unfPotionId = Items.CADANTINE_POTION_UNF, cleanRequirement = 65),
    LANTADYME(cleanItemId = Items.LANTADYME, dirtyItemId = Items.GRIMY_LANTADYME, unfPotionId = Items.LANTADYME_POTION_UNF, cleanRequirement = 67),
    DWARF_WEED(cleanItemId = Items.DWARF_WEED, dirtyItemId = Items.GRIMY_DWARF_WEED, unfPotionId = Items.DWARF_WEED_POTION_UNF, cleanRequirement = 70),
    TORSTOL(cleanItemId = Items.TORSTOL, dirtyItemId = Items.GRIMY_TORSTOL, unfPotionId = Items.TORSTOL_POTION_UNF, cleanRequirement = 75);
}