package gg.rsmod.plugins.content.npcs.sandcrab

arrayOf(Npcs.SAND_CRAB_7206, Npcs.SAND_CRAB).forEach { npc ->
    set_combat_def(npc) {
        configs {
            attackSpeed = 4
            respawnDelay = 50
        }

        aggro {
            radius = 3
            searchDelay = 1
            aggroMinutes = 10
        }

        stats {
            hitpoints = 60
            attack = 1
            defence = 1
            strength = 1
        }

        anims {
            attack = 1312
            block = 1313
            death = 1314
        }
    }
}