package gg.rsmod.plugins.content.skills.cooking.data

import gg.rsmod.plugins.api.cfg.Items

enum class ReUsable(val original_item : Int ,val  emptyItem : Int)  {
    POT_OF_FLOUR(Items.POT_OF_FLOUR, Items.POT),
    JUG_OF_WATER(Items.JUG_OF_WATER, Items.JUG),
    BUCKET_OF_WATER(Items.BUCKET_OF_WATER,Items.BUCKET),
    BOWEL_OF_WATER(Items.BOWL_OF_WATER,Items.BOWL);

    companion object {

        /**
         * The cached array of enum definitions
         */
        val values = enumValues<ReUsable>()

        /**
         * The map of reusables ids to their definitions
         */
        val reusablesDefinitions = values.associateBy { it.original_item}
    }
}