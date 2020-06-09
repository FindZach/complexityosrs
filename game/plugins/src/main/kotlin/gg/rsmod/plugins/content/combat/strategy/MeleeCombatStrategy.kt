package gg.rsmod.plugins.content.combat.strategy

import gg.rsmod.game.model.combat.XpMode
import gg.rsmod.game.model.entity.Npc
import gg.rsmod.game.model.entity.Pawn
import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.EquipmentType
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.WeaponType
import gg.rsmod.plugins.api.cfg.Items
import gg.rsmod.plugins.api.ext.*
import gg.rsmod.plugins.content.combat.Combat
import gg.rsmod.plugins.content.combat.CombatConfigs
import gg.rsmod.plugins.content.combat.dealHit
import gg.rsmod.plugins.content.combat.formula.MeleeCombatFormula

/**
 * @author Tom <rspsmods@gmail.com>
 */
object MeleeCombatStrategy : CombatStrategy {

    override fun getAttackRange(pawn: Pawn): Int {
        if (pawn is Player) {
            val halberd = pawn.hasWeaponType(WeaponType.HALBERD)
            return if (halberd) 2 else 1
        }
        return 1
    }

    override fun canAttack(pawn: Pawn, target: Pawn): Boolean {
        return true
    }

    override fun attack(pawn: Pawn, target: Pawn) {
        val world = pawn.world

        val animation = CombatConfigs.getAttackAnimation(pawn)
        pawn.animate(animation)

        val formula = MeleeCombatFormula
        val accuracy = formula.getAccuracy(pawn, target)
        val maxHit = formula.getMaxHit(pawn, target)
        val landHit = accuracy >= world.randomDouble()

        if (pawn.entityType.isPlayer) {
            val player: Player = pawn as Player;
            if (player.hasEquipped(EquipmentType.WEAPON, Items.SCYTHE_OF_VITUR)) {
                player.graphic(478)
                player.queue {
                    val damage = pawn.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = 1).hit.hitmarks.sumBy{it.damage}
                    wait(1)
                    val damage2 = pawn.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = 1).hit.hitmarks.sumBy{it.damage}
                    val total = damage+damage2

                    if (total > 0 && pawn.entityType.isPlayer) {
                        addCombatXp(pawn as Player, target, total)
                    }
                }
                return
            }
        }

        val damage = pawn.dealHit(target = target, maxHit = maxHit, landHit = landHit, delay = 1).hit.hitmarks.sumBy{it.damage}

        if (damage > 0 && pawn.entityType.isPlayer) {
            addCombatXp(pawn as Player, target, damage)
        }
    }

    private fun addCombatXp(player: Player, target: Pawn, damage: Int) {
        val modDamage = if (target.entityType.isNpc) Math.min(target.getCurrentHp(), damage) else damage
        val mode = CombatConfigs.getXpMode(player)
        val multiplier = if (target is Npc) Combat.getNpcXpMultiplier(target) else 1.0
        
        when (mode) {
            XpMode.ATTACK -> {
                player.addXp(Skills.ATTACK, modDamage * 4.0 * multiplier)
                player.addXp(Skills.HITPOINTS, modDamage * 1.33 * multiplier)
            }
            XpMode.STRENGTH -> {
                player.addXp(Skills.STRENGTH, modDamage * 4.0 * multiplier)
                player.addXp(Skills.HITPOINTS, modDamage * 1.33 * multiplier)
            }
            XpMode.DEFENCE -> {
                player.addXp(Skills.DEFENCE, modDamage * 4.0 * multiplier)
                player.addXp(Skills.HITPOINTS, modDamage * 1.33 * multiplier)
            }
            XpMode.SHARED -> {
                player.addXp(Skills.ATTACK, modDamage * 1.33 * multiplier)
                player.addXp(Skills.STRENGTH, modDamage * 1.33 * multiplier)
                player.addXp(Skills.DEFENCE, modDamage * 1.33 * multiplier)
                player.addXp(Skills.HITPOINTS, modDamage * 1.33 * multiplier)
            }
        }
    }
}