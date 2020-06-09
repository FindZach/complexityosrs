package gg.rsmod.plugins.content.skills.cooking.action

import gg.rsmod.game.fs.DefinitionSet
import gg.rsmod.game.fs.def.ItemDef
import gg.rsmod.game.model.queue.QueueTask
import gg.rsmod.plugins.api.EquipmentType
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.ext.*
import gg.rsmod.plugins.content.skills.cooking.data.MeatType

class CookAction(private val defs: DefinitionSet) {


    private val meatName = MeatType.values.associate { it.cooked to  defs.get(ItemDef::class.java, it.cooked).name.toLowerCase() }
    /**
     * Handles the cooking of a meat
     *
     * @param task      The queued action task
     * @param rawMeat       The meat definition
     * @param amount    The amount the player is trying to cook
     */
    suspend fun cook(task: QueueTask, rawMeat: MeatType, amount: Int, cookAnim : Int) {

        if (!canCook(task, rawMeat))
            return

        val player = task.player
        val inventory = player.inventory

        val rawMeatCount = inventory.getItemCount(rawMeat.raw)
        val maxCount = Math.min(amount, rawMeatCount)
        val meatName = player.world.definitions.get(ItemDef::class.java, rawMeat.cooked).name

        repeat(maxCount) {

            player.animate(cookAnim)
            task.wait(ANIMATION_CYCLE)
            player.lock()
            task.wait(ANIMATION_CYCLE)

            if (!canCook(task, rawMeat)) {
                player.animate(-1)
                return
            }

            val removeRaw = inventory.remove(item = rawMeat.raw)

            if (removeRaw.hasSucceeded()) {
                if(successfulAteempt(task, rawMeat)){
                    player.filterableMessage("You successfully cook some ${meatName.pluralSuffix(2).toLowerCase()}.")
                    inventory.add(rawMeat.cooked)
                    player.addXp(Skills.COOKING, rawMeat.xp)
                } else {

                    player.filterableMessage("You accidentally burn the ${meatName.pluralSuffix(2).toLowerCase()}.")
                    inventory.add(rawMeat.burnt)
                }
            }

            player.unlock()
            task.wait(WAIT_CYCLE)
        }
    }

    /**
     * Calcuate successful cooking chance if noburnLevel is not met
     */
    private suspend fun successfulAteempt(task: QueueTask, rawMeat: MeatType): Boolean {
        val p = task.player
        val boostedSkill = p.getSkills().getCurrentLevel(Skills.COOKING)+getCookingBoost(task)
        if(boostedSkill >= rawMeat.noburnLevel)
            return true

        return Skills.isSuccess(boostedSkill, rawMeat.levelRequired)
    }
    /**
     * Calcuate player cooking boost bonus
     */

    private fun getCookingBoost(task: QueueTask): Int {
        if(task.player.hasEquipped(EquipmentType.GLOVES, Items.COOKING_GAUNTLETS))
            return 3
        return 0
    }

    /**
     * Check if player can cook rawMeat Type
     */
    private suspend fun canCook(task: QueueTask, rawMeat: MeatType) : Boolean {
        val p = task.player
        val inventory = p.inventory

        if (!inventory.contains(rawMeat.raw)) {
            task.messageBox("You don't have any  ${meatName[rawMeat.cooked]} to cook.")
            return false
        }

        if (p.getSkills().getCurrentLevel(Skills.COOKING) < rawMeat.levelRequired) {
            task.messageBox("You need a ${Skills.getSkillName(p.world, Skills.COOKING)} level of at least ${rawMeat.levelRequired} to cook ${meatName[rawMeat.cooked]?.prefixAn()}.")
            return false
        }

        return true

    }
    companion object {

        /**
         * The animation played when cooking meat while standing
         */
        const val STANDING_COOKING_ANIM = 896
        /**
         * The animation played when cooking meat on a ground level fire
         */
        const val CROUCHING_COOKING_ANIM = 897

        /**
         * The sound played when smelting a bar
         */
        const val COOKING_SOUND = 2725 //CANT FIND YET

        /**
         * The number of ticks between starting the animation, and locking the player to the action
         */
        const val ANIMATION_CYCLE = 2

        /**
         * The number of ticks before automatically continuing the produce the next bar
         */
        const val WAIT_CYCLE = 3
    }
}