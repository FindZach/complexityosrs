package gg.rsmod.plugins.content.objs.flax

import gg.rsmod.game.model.attr.AttributeKey
import gg.rsmod.game.model.entity.DynamicObject
import gg.rsmod.game.model.entity.GameObject
import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.ext.*


/**
 * @author Zach (zach@findzach.com)
 */
object FlaxPicking {
    //Camelot Flax Field object ID
    const val FLAX_OBJECT_ID = 14896
    //ItemID of Flax
    private const val FLAX_ITEM_ID = 1779
    //For the way I am doing it I am rewarding Farming XP. Simply remove line 41 if you don't want this.
    private const val FARMING_XP = 100.0
    private const val FLAX_ANIM_ID = 2244

    suspend fun pickFlax(it: QueueTask, obj: GameObject) {
        val player = it.player;


        while (true) {
            player.animate(FLAX_ANIM_ID)
            it.wait(1)
            if (!canPickFlax(player)) {
                player.animate(-1) //reset users animation status
                break
            }

            val level = player.getSkills().getCurrentLevel(Skills.FARMING)
            if (level.interpolate(minChance = 100, maxChance = 200, minLvl = 1, maxLvl = 99, cap = 210)) {
                player.filterableMessage("You find manage to pick some flax!")
                player.playSound(3599)
                player.inventory.add(FLAX_ITEM_ID)
                player.addXp(Skills.FARMING, FARMING_XP)

                var flaxCounter = AttributeKey<Int>("flaxCount")

                var total: Int = 0;
                if (player.attr[flaxCounter] == null) {
                    player.attr[flaxCounter] = total; //If we didn't have this it would throw error;
                }

                total = (player.attr[flaxCounter]?.toInt() ?: player.attr[flaxCounter]) as Int; //Must be an easier way to handle this...
                total += 1;

                player.attr[flaxCounter] = total;

                player.filterableMessage("<col=255>You have collected ${total} total flax!");


            } else {
                player.filterableMessage("You rip the flax as you try to pick it");
                    player.animate(-1); //reset users animation status

                    val world = player.world;
                    val savedobj = DynamicObject(obj)

                    world.queue {
                        world.remove(obj)
                        wait(25); //25 ticks until flax respawns
                        world.spawn(DynamicObject(savedobj))
                    }
                    break
                }
            it.wait(1)
            }
    }

    /**
     * Will check a few factors to see if user is able to pick flax
     */
    private fun canPickFlax(player: Player): Boolean {

        if (player.inventory.isFull) {
            player.message("Your inventory is too full to pick flax!")
            return false
        }
        return true
    }
}