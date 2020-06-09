package gg.rsmod.plugins.content.inter.scrollofskills

import java.util.*

for (i in 8 until 31) {
    on_button(648, i) {
        val skill = SkillProgressData.values()[i-8]
        player.message("You've teleported to the ${skill.view} location!")
        player.moveTo(skill.teleportLocation)
    }
}
on_button(648, 2) {
    player.closeInterface(InterfaceDestination.MAIN_SCREEN);
}



on_interface_open(648) {
    for (i in 8 until 31) {
        val skill = SkillProgressData.values()[i-8]
        val skillString = skill.view
        val progress = getColorFromProgress(skill.progress)
        player.setComponentText(648, i, "$skillString - <col=C4F1C2>Progress: </col>$progress")
    }
}

fun getColorFromProgress(progress: Double): String {

    if (progress < 15) {
        return "<col=FF0000>$progress</col>"
    } else
    if (progress > 14 && progress < 50) {
        return "<col=FF7800>$progress</col>"
    } else
    if (progress > 49 && progress < 65) {
        return "<col=FFC900>$progress</col>"
    }
    if (progress > 64 && progress < 75) {
        return "<col=F3FF00>$progress</col>"
    }
    if (progress > 74 && progress < 90) {
        return "<col=B2FF00>$progress</col>"
    }
    if (progress > 89 && progress < 1000) {
        return "<col=2EFF00>$progress</col>"
    }
    return ""
}

