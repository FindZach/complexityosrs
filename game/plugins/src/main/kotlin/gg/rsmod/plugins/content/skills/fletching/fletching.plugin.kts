package gg.rsmod.plugins.content.skills.fletching

import gg.rsmod.plugins.content.skills.fletching.data.FletchLogData
import gg.rsmod.plugins.content.skills.fletching.action.FletchAction

FletchLogData.values.forEach { fletchLog ->
    on_item_on_item(item1 = 946, item2 = fletchLog.logId) {
       openFletchInterface(player, fletchLog);
    }
}

fun openFletchInterface(player: Player, log: FletchLogData) {
    player.queue {
        var fletchData = AttributeKey<FletchLogData>("lastFletch")

        player.attr[fletchData] = log;
        produceItemBox(*log.fletchItems, title = "What would you like to create?", logic = ::startMixingUnf)
    }
}

fun startMixingUnf(player: Player, i: Int, i1: Int) {
    var fletchData = AttributeKey<FletchLogData>("lastFletch")
    player.queue {
        player.attr[fletchData]?.let { it1 -> FletchAction.fletchLog(this, it1, i, i1) }
    }

}
