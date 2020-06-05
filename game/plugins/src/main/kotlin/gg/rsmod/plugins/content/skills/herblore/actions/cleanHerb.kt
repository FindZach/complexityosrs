package gg.rsmod.plugins.content.skills.herblore.actions

import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.ext.message
import gg.rsmod.plugins.api.ext.player

class cleanHerb {


    /*
        checks if the player has the required herblore level to clean the herb
     */
    public suspend fun canClean(task: QueueTask, levelReq: Int) : Boolean {
        val player = task.player
        if(player.getSkills()[Skills.HERBLORE].currentLevel >= levelReq)  {
            return true;
        }
        player.message("You require a level of $levelReq in order to clean this herb.");
        return false;
    }

    /*
       checks if the player has the required herblore level to make the potion
    */
    public suspend fun canMake(task: QueueTask, levelReq: Int) : Boolean {
        val player = task.player
        if(player.getSkills()[Skills.HERBLORE].currentLevel >= levelReq)  {
            return true;
        }
        player.message("You require a level of $levelReq in order to make this potion.");
        return false;
    }

    public suspend fun clean(task: QueueTask, dirty: Int, clean: Int, xpGained: Double) {
        val player = task.player
        player.inventory.remove(dirty,1)
        player.inventory.add(clean,1)
        player.addXp(Skills.HERBLORE, xpGained);
    }
}