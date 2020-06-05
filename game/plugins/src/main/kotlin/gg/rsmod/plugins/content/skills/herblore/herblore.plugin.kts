import gg.rsmod.plugins.content.skills.herblore.herbs.herbs
import gg.rsmod.plugins.content.skills.herblore.actions.cleanHerb;
import gg.rsmod.plugins.content.skills.herblore.actions.makeUnfinished;
import gg.rsmod.plugins.content.skills.herblore.actions.createPotion;
import gg.rsmod.plugins.api.cfg.Items

/**
 * @author Mathlide : Discord   mathlide#6338
 */

/*
    Parameters for Herb Objects
 */
data class Herb(val clean: Int, val dirty: Int, val levelReq: Int, val xpGained: Double, val unfPotionId: Int)
data class Potion(val potionId: Int, val unfPotionId: Int, val secondary: Int, val levelReq: Int, val xpGained: Double)
data class Comb(val potionId: Int)

/*
    Vial of Water ItemId
 */
val waterVial = Items.VIAL_OF_WATER

/*
    Set of herbs for clickItem action (Cleaning)
    Set of herbs for Herb on vial Of water action (Making Unfinished)
 */
private val HERBS = setOf(
        Herb(clean = herbs.GUAM.cleanItemId, dirty = herbs.GUAM.dirtyItemId, levelReq = herbs.GUAM.cleanRequirement, xpGained = 2.5, unfPotionId = herbs.GUAM.unfPotionId),
        Herb(clean = herbs.MARRENTILL.cleanItemId, dirty = herbs.MARRENTILL.dirtyItemId, levelReq = herbs.MARRENTILL.cleanRequirement, xpGained = 3.8, unfPotionId = herbs.MARRENTILL.unfPotionId),
        Herb(clean = herbs.TARROMIN.cleanItemId, dirty = herbs.TARROMIN.dirtyItemId, levelReq = herbs.TARROMIN.cleanRequirement, xpGained = 5.0, unfPotionId = herbs.TARROMIN.unfPotionId),
        Herb(clean = herbs.HARRALANDER.cleanItemId, dirty = herbs.HARRALANDER.dirtyItemId, levelReq = herbs.HARRALANDER.cleanRequirement, xpGained = 6.3, unfPotionId = herbs.HARRALANDER.unfPotionId),
        Herb(clean = herbs.RANARR.cleanItemId, dirty = herbs.RANARR.dirtyItemId, levelReq = herbs.RANARR.cleanRequirement, xpGained = 7.5, unfPotionId = herbs.RANARR.unfPotionId),
        Herb(clean = herbs.TOADFLAX.cleanItemId, dirty = herbs.TOADFLAX.dirtyItemId, levelReq = herbs.TOADFLAX.cleanRequirement, xpGained = 8.0, unfPotionId = herbs.TOADFLAX.unfPotionId),
        Herb(clean = herbs.IRIT.cleanItemId, dirty = herbs.IRIT.dirtyItemId, levelReq = herbs.IRIT.cleanRequirement, xpGained = 8.8, unfPotionId = herbs.IRIT.unfPotionId),
        Herb(clean = herbs.AVANTOE.cleanItemId, dirty = herbs.AVANTOE.dirtyItemId, levelReq = herbs.AVANTOE.cleanRequirement, xpGained = 10.0, unfPotionId = herbs.AVANTOE.unfPotionId),
        Herb(clean = herbs.KWUARM.cleanItemId, dirty = herbs.KWUARM.dirtyItemId, levelReq = herbs.KWUARM.cleanRequirement, xpGained = 11.3, unfPotionId = herbs.KWUARM.unfPotionId),
        Herb(clean = herbs.SNAPDRAGON.cleanItemId, dirty = herbs.SNAPDRAGON.dirtyItemId, levelReq = herbs.SNAPDRAGON.cleanRequirement, xpGained = 11.8, unfPotionId = herbs.SNAPDRAGON.unfPotionId),
        Herb(clean = herbs.CADANTINE.cleanItemId, dirty = herbs.CADANTINE.dirtyItemId, levelReq = herbs.CADANTINE.cleanRequirement, xpGained = 12.5, unfPotionId = herbs.CADANTINE.unfPotionId),
        Herb(clean = herbs.LANTADYME.cleanItemId, dirty = herbs.LANTADYME.dirtyItemId, levelReq = herbs.LANTADYME.cleanRequirement, xpGained = 13.1, unfPotionId = herbs.LANTADYME.unfPotionId),
        Herb(clean = herbs.DWARF_WEED.cleanItemId, dirty = herbs.DWARF_WEED.dirtyItemId, levelReq = herbs.DWARF_WEED.cleanRequirement, xpGained = 13.8, unfPotionId = herbs.DWARF_WEED.unfPotionId),
        Herb(clean = herbs.TORSTOL.cleanItemId, dirty = herbs.TORSTOL.dirtyItemId, levelReq = herbs.TORSTOL.cleanRequirement, xpGained = 15.0, unfPotionId = herbs.TORSTOL.unfPotionId))


/*
    Set of Potions that require UnfinishedPotion - > Secondary Action
 */
private val POTIONS = setOf(
        Potion(potionId = Items.ATTACK_POTION3, unfPotionId = herbs.GUAM.unfPotionId, secondary = Items.EYE_OF_NEWT, xpGained = 25.0, levelReq = 1),
        Potion(potionId = Items.PRAYER_POTION3, unfPotionId = herbs.RANARR.unfPotionId, secondary = Items.SNAPE_GRASS, xpGained = 87.5, levelReq = 36),
        Potion(potionId = Items.ANTIPOISON3, unfPotionId = herbs.MARRENTILL.unfPotionId, secondary = Items.UNICORN_HORN_DUST, xpGained = 37.5, levelReq = 5),
        Potion(potionId = Items.STRENGTH_POTION3, unfPotionId = herbs.TARROMIN.unfPotionId, secondary = Items.LIMPWURT_ROOT, xpGained = 50.0, levelReq = 12),
        Potion(potionId = Items.RESTORE_POTION3, unfPotionId = herbs.HARRALANDER.unfPotionId, secondary = Items.RED_SPIDERS_EGGS, xpGained = 62.5, levelReq = 22),
        Potion(potionId = Items.ENERGY_POTION3, unfPotionId = herbs.HARRALANDER.unfPotionId, secondary = Items.CHOCOLATE_DUST, xpGained = 67.5, levelReq = 26),
        Potion(potionId = Items.DEFENCE_POTION3, unfPotionId = herbs.RANARR.unfPotionId, secondary = Items.WHITE_BERRIES, xpGained = 75.0, levelReq = 30),
        Potion(potionId = Items.SARADOMIN_BREW3, unfPotionId = herbs.TOADFLAX.unfPotionId, secondary = Items.CRUSHED_NEST, xpGained = 180.0, levelReq = 81),
        Potion(potionId = Items.SUPER_ATTACK3, unfPotionId = herbs.IRIT.unfPotionId, secondary = Items.EYE_OF_NEWT, xpGained = 125.0, levelReq = 55),
        Potion(potionId = Items.SUPERANTIPOISON3, unfPotionId = herbs.IRIT.unfPotionId, secondary = Items.UNICORN_HORN_DUST, xpGained = 106.3, levelReq = 48),
        Potion(potionId = Items.SUPER_ENERGY3, unfPotionId = herbs.AVANTOE.unfPotionId, secondary = Items.MORT_MYRE_FUNGUS, xpGained = 117.5, levelReq = 52),
        Potion(potionId = Items.SUPER_STRENGTH3, unfPotionId = herbs.KWUARM.unfPotionId, secondary = Items.LIMPWURT_ROOT, xpGained = 125.0, levelReq = 55),
        Potion(potionId = Items.SUPER_RESTORE3, unfPotionId = herbs.SNAPDRAGON.unfPotionId, secondary = Items.RED_SPIDERS_EGGS, xpGained = 142.5, levelReq = 63),
        Potion(potionId = Items.SUPER_DEFENCE3, unfPotionId = herbs.CADANTINE.unfPotionId, secondary = Items.WHITE_BERRIES, xpGained = 150.0, levelReq = 66),
        Potion(potionId = Items.ANTIFIRE_POTION3, unfPotionId = herbs.LANTADYME.unfPotionId, secondary = Items.DRAGON_SCALE_DUST, xpGained = 157.5, levelReq = 69),
        Potion(potionId = Items.RANGING_POTION3, unfPotionId = herbs.DWARF_WEED.unfPotionId, secondary = Items.WINE_OF_ZAMORAK, xpGained = 162.5, levelReq = 72),
        Potion(potionId = Items.MAGIC_POTION3, unfPotionId = herbs.LANTADYME.unfPotionId, secondary = Items.POTATO_CACTUS, xpGained = 172.5, levelReq = 76),
        Potion(potionId = Items.ZAMORAK_BREW3, unfPotionId = herbs.TORSTOL.unfPotionId, secondary = Items.JANGERBERRIES, xpGained = 175.0, levelReq = 78))

private val SUPCOMB = setOf(
        Comb(potionId = Items.SUPER_ATTACK4),
        Comb(potionId = Items.SUPER_DEFENCE4),
        Comb(potionId = Items.SUPER_STRENGTH4)
)

/*
    Checks for inventory actions
    *Cleaning Herbs
    *Making Unfinished Potions
    *Making Potions (Unfinished on Secondary)
 */
HERBS.forEach { Herb ->
    /*
        Cleaning Herbs
     */
    on_item_option(Herb.dirty,1) {
        player.queue {
            if(cleanHerb().canClean(this, Herb.levelReq)) {
                cleanHerb().clean(this, Herb.dirty, Herb.clean, Herb.xpGained)
            }
        }
    }

    /*
        Making Unfinished Potions
     */
    fun startMixingUnf(player: Player, unfPotionId: Int, amount: Int = 28)    {
        player.queue {
            makeUnfinished().initialize(this,Herb.unfPotionId,Herb.clean,waterVial)
        }
    }
    on_item_on_item(Herb.clean, waterVial) {
        player.queue {
            produceItemBox(Herb.unfPotionId, title = "How many potions would you like to make?", logic = ::startMixingUnf)

        }

    }
}

/*
  Making Potions(3 dose)
*/
POTIONS.forEach() { Potion ->
    fun startMakingPotion(player: Player, unfPotionId: Int, amount: Int = 28) {
        player.queue {
            createPotion().createNewPotion(this, Potion.potionId, Potion.unfPotionId, Potion.xpGained, Potion.levelReq, Potion.secondary)
        }
    }


    on_item_on_item(Potion.unfPotionId, Potion.secondary) {
        player.queue {
            if (cleanHerb().canMake(this, Potion.levelReq)) {
                produceItemBox(Potion.potionId, title = "How many potions would you like to make?", logic = ::startMakingPotion)
            }
        }
    }
}

/*
    Super Combat Potions
 */
SUPCOMB.forEach() { Comb ->
    fun makeSuperCombatPotion(player: Player, unfPotionId: Int, amount: Int = 28) {
        player.queue {
            createPotion().createSuperCombatPotion(this)
        }
    }
    on_item_on_item(Comb.potionId, Items.TORSTOL) {
        player.queue {
            if (cleanHerb().canMake(this, 90)) {
                produceItemBox(Items.SUPER_COMBAT_POTION4, title = "How many potions would you like to make?", logic = ::makeSuperCombatPotion)
            }
        }
    }

}