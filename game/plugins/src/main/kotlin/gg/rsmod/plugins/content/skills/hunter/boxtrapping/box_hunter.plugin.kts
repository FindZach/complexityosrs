package gg.rsmod.plugins.content.skills.hunter.boxtrapping

val A_TIMER = TimerKey()

on_item_option(10008, 1) {

    player.queue {
        BoxTrapping.deployTrap(this)
        player.timers.set(A_TIMER, 3)
    }
}



spawn_npc(npc = Npcs.CARNIVOROUS_CHINCHOMPA, x = 2556, z = 2933, direction = Direction.NORTH)
spawn_npc(npc = Npcs.CARNIVOROUS_CHINCHOMPA, x = 2555, z = 2932, direction = Direction.NORTH)