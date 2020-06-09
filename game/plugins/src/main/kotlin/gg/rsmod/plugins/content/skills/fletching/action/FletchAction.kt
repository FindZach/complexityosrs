package gg.rsmod.plugins.content.skills.fletching.action

import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.ext.message
import gg.rsmod.plugins.api.ext.player
import gg.rsmod.plugins.content.skills.fletching.data.FletchLogData
import kotlin.math.min

/**
 * @author Zach (zach@findzach.com)
 */
object FletchAction {

    val ANIMATION_ID = 1248;

    /**
     * Creates Arrow Shafts/Unstrung Bows/Crossbow Stock
     */
    suspend fun fletchLog(task: QueueTask, fletchData: FletchLogData, productId: Int, amount: Int) {

        //TODO: Add Fletch conditions -> Check level/ ect.

        val player = task.player;
        val inventory = player.inventory;

        val maxCount = min(amount, inventory.getItemCount(fletchData.logId))

        repeat(maxCount) {
            player.animate(ANIMATION_ID, 2);
            task.wait(4);
            inventory.remove(fletchData.logId, 1, true)
            if (productId == 52) {
                inventory.add(productId, fletchData.arrowShaftAmount, true)
            } else {
                inventory.add(productId, 1, true)
            }
            player.addXp(Skills.FLETCHING, getXpDrop(player, productId))
        }
        task.wait(2)
    }

    /**
     * Returns the XP amount based off of item fletched
     */
    fun getXpDrop(player: Player, itemId: Int): Double {
        when (itemId) {
            Items.ARROW_SHAFT -> return 5.0
            Items.YEW_SHORTBOW_U -> return 67.5

            else -> {}
        }
        if(player.inDebugMode()) {
            sendDebugMessage(player, "No Fletching XP for: $itemId");
        }
        return 150.0
    }

    /**
     * Sends fletching debug messages to user
     */
    fun sendDebugMessage(player: Player, message: String) {
        player.message("<col=a83232>[FletchingDebug]</col><col=255> $message</col>")
    }
}