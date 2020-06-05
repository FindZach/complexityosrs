package gg.rsmod.plugins.content.skills.cooking

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.message
import gg.rsmod.plugins.api.ext.player
import gg.rsmod.plugins.api.ext.produceItemBox
import gg.rsmod.plugins.content.skills.cooking.data.MixType
import gg.rsmod.plugins.content.skills.cooking.action.MixAction
import kotlin.math.min

/**
 * The map of meat item ids to their definitions
 */
val mixComponents = MixType.values

val mixing = MixAction(world.definitions)


mixComponents.forEach { component ->
    on_item_on_item(component.firstComponent, component.secondComponent) { mixComponents(player, component) }
}

fun mixComponents(player: Player, mix : MixType) {
    if (player.inventory.isFull && mix.extraSlotNeeded) {
        player.message("You don't have any space to make any dough")
        return
    }
    player.queue { produceItemBox(*mix.possibleMixResults, title = "How many would you like to make?",maxItems = min(player.inventory.getItemCount(mix.firstComponent), player.inventory.getItemCount(mix.secondComponent)), logic = ::mixComponents) }

}
fun mixComponents(player: Player, item: Int, amount: Int = 28) {
    mixComponents.forEach { component ->
        when (component.possibleMixResults.contains(item)) {
            true ->
                player.queue { mixing.mixComponents(this, component, amount, item) }
        }
    }
}