package gg.rsmod.plugins.content.areas.woodcuttingGuild.objs

on_obj_option(Objs.CARVED_REDWOOD_29682, 1) {
    player.queue {
        player.moveTo(player.tile.x, player.tile.z, player.tile.height - 1)
    }
}

on_obj_option(Objs.CARVED_REDWOOD_29681, 1) {
    player.queue {
        player.moveTo(player.tile.x, player.tile.z, player.tile.height + 1)
    }
}

on_obj_option(Objs.ROPE_LADDER_28858, 1) {
    player.queue {
        player.moveTo(player.tile.x + 1, player.tile.z, player.tile.height - 1)
    }
}

on_obj_option(Objs.ROPE_LADDER_28857, 1) {
    player.queue {
        player.moveTo(player.tile.x - 2, player.tile.z, player.tile.height + 1)
    }
}