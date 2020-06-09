package gg.rsmod.plugins.content.skills.fletching.data

import gg.rsmod.plugins.api.cfg.Items

enum class FletchableItem(var itemId: Int, exp: Double, level: Int, recipe: IntArray) {
    ARROW_SHAFTS(Items.ARROW_SHAFT, 5.0, 1, intArrayOf(Items.KNIFE, Items.LOGS)),
    HEADLESS_ARROW(Items.HEADLESS_ARROW, 1.0, 1, intArrayOf(Items.ARROW_SHAFT, Items.FEATHER)),
    BRONZE_ARROW(Items.BRONZE_ARROW, 1.33, 1, intArrayOf(Items.HEADLESS_ARROW, Items.BRONZE_ARROWTIPS)),
    SHORTBOW_U(Items.SHORTBOW_U, 5.0, 5, intArrayOf(Items.LOGS)),
    SHORTBOW(Items.SHORTBOW, 5.0, 5, intArrayOf(Items.SHORTBOW_U, Items.BOW_STRING))
}