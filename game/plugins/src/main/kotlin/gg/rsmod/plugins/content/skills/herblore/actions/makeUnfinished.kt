package gg.rsmod.plugins.content.skills.herblore.actions

import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.ext.player

class makeUnfinished {

    /*

     */
    suspend fun initialize(task: QueueTask, unfPotionId: Int, herbId: Int, vialOfWater: Int)    {
        val player = task.player
        val a = player.inventory.getItemCount(herbId)

        repeat(a)   {
            if(player.inventory.getItemCount(herbId) < 1 || player.inventory.getItemCount(vialOfWater) < 1) {
                player.animate(-1)
                return
            }

            player.animate(HERB_ANIM)
            player.inventory.remove(herbId,1)
            player.inventory.remove(vialOfWater, 1)
            player.inventory.add(unfPotionId,1)
            player.addXp(Skills.HERBLORE, 10.0)
            task.wait(WAIT_CYCLE);
        }
    }
    companion object {

        /**
         * The animation played when smelting a herb
         */
        const val HERB_ANIM = 363

        /**
         * The number of ticks between starting the animation, and locking the player to the action
         */
        const val ANIMATION_CYCLE = 2

        /**
         * The number of ticks before automatically continuing the produce the next herb
         */
        const val WAIT_CYCLE = 2
    }
}