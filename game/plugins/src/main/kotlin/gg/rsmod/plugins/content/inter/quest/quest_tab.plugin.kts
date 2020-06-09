package gg.rsmod.plugins.content.inter.quest

import gg.rsmod.plugins.content.inter.attack.AttackTab

on_button(interfaceId = 548, component = 50) {
    player.openInterface(interfaceId = 649, dest = InterfaceDestination.QUEST)
}

on_button(649, 14) {

    player.openInterface(648, InterfaceDestination.MAIN_SCREEN)
}