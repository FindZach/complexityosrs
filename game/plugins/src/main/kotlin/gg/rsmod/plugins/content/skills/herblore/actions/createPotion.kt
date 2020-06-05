package gg.rsmod.plugins.content.skills.herblore.actions

import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.ext.message
import gg.rsmod.plugins.api.ext.player

class createPotion {

    suspend fun createNewPotion(task: QueueTask, potionId: Int, unfPotionId: Int, gainedXp: Double, levelReq: Int, secondary: Int) {
        val player = task.player
        if(player.getSkills()[Skills.HERBLORE].currentLevel >= levelReq) {
            val a = player.inventory.getItemCount(unfPotionId)

            repeat(a) {
                if (player.inventory.getItemCount(unfPotionId) < 1 || player.inventory.getItemCount(secondary) < 1) {
                    player.animate(-1)
                    return
                }

                player.animate(HERB_ANIM)
                player.inventory.remove(unfPotionId, 1)
                player.inventory.remove(secondary, 1)
                player.inventory.add(potionId, 1)
                player.addXp(Skills.HERBLORE, gainedXp);
                task.wait(WAIT_CYCLE);
            }
        }
    }
    suspend fun createSuperCombatPotion(task: QueueTask) {
        val player = task.player
        val a = player.inventory.getItemCount(Items.TORSTOL)

        repeat(a)   {
            if(player.inventory.getItemCount(Items.SUPER_DEFENCE4) < 1 || player.inventory.getItemCount(Items.SUPER_ATTACK4) < 1 || player.inventory.getItemCount(Items.SUPER_STRENGTH4) < 1 || player.inventory.getItemCount(Items.TORSTOL) < 1) {
                player.animate(-1)
                return
            }

            player.animate(HERB_ANIM)
            player.inventory.remove(Items.SUPER_DEFENCE4,1)
            player.inventory.remove(Items.SUPER_STRENGTH4,1)
            player.inventory.remove(Items.SUPER_ATTACK4,1)
            player.inventory.remove(Items.TORSTOL,1)
            player.inventory.add(Items.SUPER_COMBAT_POTION4,1)
            player.addXp(Skills.HERBLORE, 150.0)
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
        const val WAIT_CYCLE = 3
    }


}