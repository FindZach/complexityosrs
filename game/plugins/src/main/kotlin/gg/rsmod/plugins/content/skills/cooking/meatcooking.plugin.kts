import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.cfg.Objs
import gg.rsmod.plugins.api.ext.player
import gg.rsmod.plugins.api.ext.produceItemBox
import gg.rsmod.plugins.content.skills.cooking.action.CookAction
import gg.rsmod.plugins.content.skills.cooking.action.CookAction.Companion.CROUCHING_COOKING_ANIM
import gg.rsmod.plugins.content.skills.cooking.action.CookAction.Companion.STANDING_COOKING_ANIM
import gg.rsmod.plugins.content.skills.cooking.FireObject.FIRE
import gg.rsmod.plugins.content.skills.cooking.data.MeatType
/**
 * The map of meat item ids to their definitions
 */
val meatDefs = MeatType.meatDefinitions

/**
 * The set of meat item ids
 */
val meatIds = meatDefs.keys
/**
 * The cooking action instance
 */
val cooking = CookAction(world.definitions)

/**
 * Handles the cooking of the meat
 *
 * @param player    The player instance
 * @param item      The item the player is trying to cook
 * @param amount    The number of meat the player is trying to cook
 */
fun cookMeatCrouching(player: Player, item: Int, amount: Int = 28) {
    val def = meatDefs[item] ?: return
    player.queue { cooking.cook(this, def, amount, CROUCHING_COOKING_ANIM) }
}
fun cookMeatStanding(player: Player, item: Int, amount: Int = 28) {
    val def = meatDefs[item] ?: return
    player.queue { cooking.cook(this, def, amount, STANDING_COOKING_ANIM) }
}
/**
 * The set of cooking objects when standing is required
 */
private val cookingObjects = setOf(
        FIRE(obj = Objs.COOKING_RANGE, cookAnimId = STANDING_COOKING_ANIM, clickAble = true),
        FIRE(obj = 26181, cookAnimId = STANDING_COOKING_ANIM, clickAble = true),
        FIRE(Objs.COOKING_POT_3662, STANDING_COOKING_ANIM,false),
        FIRE(Objs.COOKING_RANGE_4172,STANDING_COOKING_ANIM,false),
        FIRE(Objs.STOVE,STANDING_COOKING_ANIM,false),
        FIRE(Objs.STOVE_12269,STANDING_COOKING_ANIM,true),
        FIRE(Objs.STOVE_9086,STANDING_COOKING_ANIM,false),
        FIRE(Objs.STOVE_9087,STANDING_COOKING_ANIM,false),
        FIRE(Objs.GOBLIN_STOVE_25441,STANDING_COOKING_ANIM,false),
        FIRE(Objs.FIRE_5249, CROUCHING_COOKING_ANIM,false),
        FIRE(Objs.FIRE_26577, CROUCHING_COOKING_ANIM,false),
        FIRE(Objs.SPIT_ROAST_5608, CROUCHING_COOKING_ANIM,false)
)

cookingObjects.forEach {fire ->
    if(fire.clickAble)
        on_obj_option(obj = fire.obj, option = "cook") { cookMeatInitial(player, fire.cookAnimId) }


    meatIds.forEach { meat ->
        on_item_on_obj(obj = fire.obj, item = meat)
        { cookMeatInitial(player, meat, fire) }
    }
}
/**
 * Opens the proompt to cook meat
 *
 * @param player    The player instance
 */
fun cookMeatInitial(player: Player, meatId : Int, fire :FIRE) {
    if(fire.cookAnimId == STANDING_COOKING_ANIM)
        player.queue { produceItemBox(meatId, title = "How many would you like to cook?", logic = :: cookMeatStanding) }
    else
        player.queue { produceItemBox(meatId, title = "How many would you like to cook?", logic = :: cookMeatCrouching) }

}
fun cookMeatInitial(player: Player, cookAnimId :Int) {

    val inventoryRawMeat = meatIds.filter { player.inventory.contains(it) }.map { it }.toIntArray()

    if(inventoryRawMeat.isNotEmpty()) {
        if (cookAnimId == STANDING_COOKING_ANIM)
            player.queue { produceItemBox(*inventoryRawMeat, title = "How many would you like to cook?", logic = ::cookMeatStanding) }
        else
            player.queue { produceItemBox(*inventoryRawMeat, title = "How many would you like to cook?", logic = ::cookMeatCrouching) }
    }
}