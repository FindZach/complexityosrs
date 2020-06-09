package gg.rsmod.plugins.content.skills.fletching.data

import gg.rsmod.plugins.api.cfg.Items

enum class FletchLogData(var logId: Int, var arrowShaftAmount: Int, var fletchItems: IntArray) {
    NORMAL(logId = 1511, arrowShaftAmount = 15, fletchItems = intArrayOf(Items.ARROW_SHAFT , Items.SHORTBOW_U, Items.LONGBOW_U, Items.WOODEN_STOCK, Items.WOODEN_SHIELD)),
    OAK(logId = 1521, arrowShaftAmount = 30, fletchItems = intArrayOf(Items.ARROW_SHAFT, Items.OAK_SHORTBOW_U, Items.OAK_LONGBOW_U, Items.OAK_STOCK, Items.OAK_SHIELD)),
    WILLOW(logId = 1519, arrowShaftAmount = 45, fletchItems = intArrayOf(Items.ARROW_SHAFT, Items.WILLOW_SHORTBOW_U, Items.WILLOW_LONGBOW_U, Items.WILLOW_STOCK, Items.WILLOW_SHIELD)),
    MAPLE(logId = 1517, arrowShaftAmount = 60, fletchItems = intArrayOf(Items.ARROW_SHAFT, Items.MAPLE_SHORTBOW_U, Items.MAPLE_LONGBOW_U, Items.MAPLE_STOCK, Items.MAPLE_SHIELD)),
    YEW(logId = 1515, arrowShaftAmount = 75, fletchItems = intArrayOf(Items.ARROW_SHAFT, Items.YEW_SHORTBOW_U, Items.YEW_LONGBOW_U, Items.YEW_STOCK, Items.YEW_SHIELD)),
    MAGIC(logId = 1513, arrowShaftAmount = 90, fletchItems = intArrayOf(Items.ARROW_SHAFT, Items.MAGIC_SHORTBOW_U, Items.MAGIC_LONGBOW_U, Items.MAGIC_SHIELD)),
    REDWOOD(logId = 19669, arrowShaftAmount = 110, fletchItems = intArrayOf(Items.ARROW_SHAFT, Items.REDWOOD_SHIELD))
    ;

    companion object {

        /**
         * The cached array of enum definitions
         */
        val values = enumValues<FletchLogData>()

    }
}