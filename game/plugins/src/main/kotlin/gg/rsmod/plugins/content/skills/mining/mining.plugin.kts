package gg.rsmod.plugins.content.skills.mining

import gg.rsmod.plugins.content.skills.mining.Mining.Rock
import gg.rsmod.plugins.content.skills.mining.data.RockType

private val ROCKS = setOf(
        Rock(RockType.RUNITE, obj = 11377, depletedRock = 8829),
        Rock(RockType.RUNITE, obj = 11376, depletedRock = 8828),
        Rock(RockType.ADAMANTITE, obj = 11375, depletedRock = 8829),
        Rock(RockType.ADAMANTITE, obj = 11374, depletedRock = 8828),
        Rock(RockType.MITHRIL, obj = 11373, depletedRock = 8829),
        Rock(RockType.MITHRIL, obj = 11372, depletedRock = 8828),
        Rock(RockType.GOLD, obj = 11371, depletedRock = 8829),
        Rock(RockType.GOLD, obj = 11370, depletedRock = 8828),
        Rock(RockType.SILVER, obj = 11369, depletedRock = 8829),
        Rock(RockType.SILVER, obj = 11368, depletedRock = 8828),
        Rock(RockType.COAL, obj = 11367, depletedRock = 8829),
        Rock(RockType.COAL, obj = 11366, depletedRock = 8828),
        Rock(RockType.IRON, obj = 11365, depletedRock = 8829),
        Rock(RockType.IRON, obj = 11364, depletedRock = 8828),
        Rock(RockType.GOLD, obj = 11363, depletedRock = 8829),
        Rock(RockType.GOLD, obj = 11362, depletedRock = 8828),
        Rock(RockType.TIN, obj = 11361, depletedRock = 8829),
        Rock(RockType.TIN, obj = 11360, depletedRock = 8828),
        Rock(RockType.COPPER, obj = 11161, depletedRock = 8829), //copper
        Rock(RockType.COPPER, obj = 10943, depletedRock = 8828) //copper
)
ROCKS.forEach { rock ->
    on_obj_option(obj = rock.obj, option = 1) {
        val obj = player.getInteractingGameObj()
        player.queue {
            Mining.mineRock(this, obj, rock.type, rock.depletedRock)
        }
    }
}