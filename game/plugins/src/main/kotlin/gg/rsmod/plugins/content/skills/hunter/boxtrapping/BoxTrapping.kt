package gg.rsmod.plugins.content.skills.hunter.boxtrapping

import gg.rsmod.game.model.MovementQueue
import gg.rsmod.game.model.entity.DynamicObject
import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.game.model.queue.TaskPriority
import gg.rsmod.plugins.api.ext.message
import gg.rsmod.plugins.api.ext.player

object BoxTrapping {

    suspend fun deployTrap(task: QueueTask) {

        var player = task.player;
        val boxTrap = DynamicObject(id = 9380, tile = player.tile, type = 10, rot = 0)
        player.world.spawn(boxTrap)
            player.world.npcs.forEach { npc ->
                repeat(10) {
                    val tile = player.tile;
                    if (npc.id == 2911) {
                        npc.queue {
                            npc.walkTo(task, tile, MovementQueue.StepType.FORCED_WALK, false)
                            wait(5)
                            npc.forceChat("$tile")
                        }
                    }
                }
            }
            player.message("This task is indeed looping...")
    }
}