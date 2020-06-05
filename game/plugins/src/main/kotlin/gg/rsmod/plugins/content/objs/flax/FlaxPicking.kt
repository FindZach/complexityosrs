package gg.rsmod.plugins.content.objs.flax

import gg.rsmod.game.fs.def.ItemDef
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

    data class Flax(val objId: Int, val animId: Int)

    const val FLAX_OBJECT_ID = 14896;
    private const val FLAX_ANIM_ID = 2244;

    suspend fun pickFlax(it: QueueTask, obj: GameObject) {
        val flaxData = Flax(objId = FLAX_OBJECT_ID, animId = FLAX_ANIM_ID);

        val player = it.player;


        while (true) {
            player.animate(flaxData.animId)
            it.wait(1)
            if (!canPickFlax(player)) {
                player.animate(-1)
                break
            }

            val level = player.getSkills().getCurrentLevel(Skills.FARMING)
            if (level.interpolate(minChance = 100, maxChance = 200, minLvl = 1, maxLvl = 99, cap = 210)) {
                player.filterableMessage("You find manage to pick some flax!")
                player.playSound(3599)
                player.inventory.add(1779)
                player.addXp(Skills.FARMING, 100.0)
            } else {
                player.filterableMessage("You rip the flax as you try to pick it");
                    player.animate(-1);
                    val world = player.world;
                    val savedobj = DynamicObject(obj)

                    world.queue {
                        world.remove(obj)
                        wait(10);
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