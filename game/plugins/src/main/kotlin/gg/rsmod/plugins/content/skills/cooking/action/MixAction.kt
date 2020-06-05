package gg.rsmod.plugins.content.skills.cooking.action

import gg.rsmod.game.fs.DefinitionSet
import gg.rsmod.game.fs.def.ItemDef
import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.ext.message
import gg.rsmod.plugins.api.ext.messageBox
import gg.rsmod.plugins.api.ext.player
import gg.rsmod.plugins.api.ext.prefixAn
import gg.rsmod.plugins.content.skills.cooking.data.MixType
import gg.rsmod.plugins.content.skills.cooking.data.ReUsable
import kotlin.math.min

class MixAction(private val defs: DefinitionSet) {

    companion object {

        /**
         * The number of ticks between starting the animation, and locking the player to the action
         */
        const val ANIMATION_CYCLE = 1

        /**
         * The number of ticks before automatically continuing the produce the next bar
         */
        const val WAIT_CYCLE = 2
    }

    private val reUsables = ReUsable.reusablesDefinitions

    suspend fun mixComponents(task: QueueTask, mix: MixType, amount: Int, mixResult : Int) {
        if (!canMix(task,mix, mixResult)) {
            return
        }
        val player = task.player
        val inventory = player.inventory

        val maxCount = min(amount, min(mix.firstComponent, mix.secondComponent))

        repeat(maxCount) {

            task.wait(ANIMATION_CYCLE * 2)

            if (!canMix(task,mix, mixResult)) {
                player.animate(-1)
                return
            }
            val removePrimary = inventory.remove(mix.firstComponent)
            val reusable1 = reUsables[mix.firstComponent] ?: null
            if (reusable1 != null) {
                inventory.add(reusable1.emptyItem)
            }
            val removeSecondary = inventory.remove(mix.secondComponent)
            val reusable2 = reUsables[mix.secondComponent] ?: null
            if (reusable2 != null) {
                inventory.add(reusable2.emptyItem)
            }
            if(removePrimary.hasSucceeded() && removeSecondary.hasSucceeded()) {
                inventory.add(mixResult)
                when(mix.xp > 0.0) { true-> player.addXp(Skills.COOKING, mix.xp) }
            }

        }
        task.wait(WAIT_CYCLE)

    }

    private suspend fun canMix(task: QueueTask, mix: MixType, mixResult : Int) : Boolean {
        val p = task.player

        if (!p.inventory.contains(mix.firstComponent) ||!p.inventory.contains(mix.secondComponent)) {
            return false
        }
        if (p.getSkills().getCurrentLevel(Skills.COOKING) < mix.reqLevel) {
            task.messageBox("You need a ${Skills.getSkillName(p.world, Skills.COOKING)} level of at least ${mix.reqLevel} to make ${defs.get(ItemDef::class.java, mixResult).name.toLowerCase()?.prefixAn()}.")
            return false
        }

        if (p.inventory.isFull && mix.extraSlotNeeded) {
            p.message("You don't have any space to make any dough")
            return false
        }
        return true

    }
}
