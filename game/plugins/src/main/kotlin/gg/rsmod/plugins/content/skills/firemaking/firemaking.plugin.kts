package gg.rsmod.plugins.content.skills.firemaking

import gg.rsmod.plugins.content.skills.firemaking.data.LogType

val logs = LogType.values();

logs.forEach { log ->
    on_item_on_item(item1 = 590, item2 = log.itemId) {
        player.queue {
            val isFiremaking = AttributeKey<Boolean>("isFiremaking")
            if (player.attr[isFiremaking] == null) {
                player.attr[isFiremaking] = false
            }
            Firemaking.lightLog(this, log)
        }
    }
}
