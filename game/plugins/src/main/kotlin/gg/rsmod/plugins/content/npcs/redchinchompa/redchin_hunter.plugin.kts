package gg.rsmod.plugins.content.npcs.redchinchompa

val trapTime = TimerKey()

on_npc_spawn(2911) {
    npc.walkRadius = 5

    npc.queue {
        npc.timers[trapTime] = 3;
    }
}

on_timer(trapTime) {
    npc.forceChat("TRAP TIMER!")
    //TODO: Check for nearby traps and fuck with them
    npc.timers[trapTime] = 5;
}

