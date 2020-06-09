package gg.rsmod.plugins.content.skills.firemaking

import gg.rsmod.game.model.Direction
import gg.rsmod.game.model.MovementQueue
import gg.rsmod.game.model.attr.AttributeKey
import gg.rsmod.game.model.entity.DynamicObject
import gg.rsmod.game.model.entity.GameObject
import gg.rsmod.game.model.entity.GroundItem
import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.ext.message
import gg.rsmod.plugins.api.ext.player
import gg.rsmod.plugins.content.skills.firemaking.data.LogType
import gg.rsmod.plugins.content.skills.woodcutting.TreeType

/**
 * @author Zach (zach@findzach.com)
 *
 * Simple firemaking skill
 */
object Firemaking {

    suspend fun lightLog(it: QueueTask, log: LogType) {

        var player = it.player
        var tile = player.tile

        player.stopMovement();

        val isFiremaking = AttributeKey<Boolean>("isFiremaking")

        //verifys no objects (such as a fire/plant) is not already here
        if (player.world.getObject(tile, 10) == null) {

            player.inventory.remove(log.itemId)
            player.world.spawn(GroundItem(item = log.itemId, amount = 1, tile = player.tile))
            if (player.attr[isFiremaking] == false || player.attr[isFiremaking] == null) {
                player.attr[isFiremaking] = true;
            } else return
            player.animate(733);
            it.wait(5)//TODO: ADD MORE CALCULATED FIRE DELAY CYCLES
            val fire = DynamicObject(id = 26185, tile = player.tile, type = 10, rot = 0)

            player.world.remove(GroundItem(item = log.itemId, amount = 1, tile = player.tile))
            player.world.queue {
                player.world.spawn(fire)
                wait(30) //TODO: Add proper fire death data
                player.world.remove(fire)
                player.world.spawn(GroundItem(item = 592, amount = 1, tile = fire.tile))
            }
            player.addXp(Skills.FIREMAKING, log.xp)
            player.attr[isFiremaking] = false;
            player.walkTo(player.tile.step(Direction.WEST), MovementQueue.StepType.NORMAL)
        } else {
            player.message("You cannot start a fire here!")
            return
        }
    }


}