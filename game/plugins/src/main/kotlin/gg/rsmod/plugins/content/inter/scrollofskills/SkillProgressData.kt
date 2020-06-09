package gg.rsmod.plugins.content.inter.scrollofskills

import gg.rsmod.game.fs.def.EnumDef
import gg.rsmod.game.model.Tile
import gg.rsmod.game.model.World

enum class SkillProgressData(var view: String, var progress: Double, var teleportLocation: Tile) {
    ATTACK("<col=FF0000>Attack</col>",50.0, Tile(0, 0,0)),
    DEFENCE("<col=FF0000>Defence</col>",50.0, Tile(0, 0,0)),
    THIEVING("<col=581845>Thieving</col>",33.33, Tile(0, 0,0)),
    STRENGTH("<col=FF0000>Strength</col>",50.0, Tile(0, 0,0)),
    HITPOINTS("<col=FF0000>Hitpoints</col>",50.0, Tile(0, 0,0)),
    RANGED("<col=236C00>Ranged</col>",50.0, Tile(0, 0,0)),
    PRAYER("<col=CEF0E8>Prayer</col>",35.2, Tile(0, 0,0)),
    MAGIC("<col=53DFD6>Magic</col>",25.4, Tile(0, 0,0)),
    COOKING("<col=AD550E>Cooking</col",76.30, Tile(0, 0,0)),
    WOODCUTTING("<col=669C5D>Woodcutting</col>",85.3, Tile(0, 0,0)),
    FLETCHING("<col=2A4A36>Fletching</col>",63.20, Tile(0, 0,0)),
    FISHING("<col=205EC5>Fishing</col>",25.0, Tile(0, 0,0)),
    FIREMAKING("<col=7D0E00>Firemaking</col>",90.2, Tile(0, 0,0)),
    CRAFTING("<col=CBD087>Crafting</col>",33.3, Tile(2933, 3285,0)),
    SMITHING("<col=58431C>Smithing</col>",80.50, Tile(2974, 3369,0)),
    MINING("<col=58431C>Mining</col>",66.35, Tile(3029, 9739,0)),
    HERBLORE("<col=38B20A>Herblore</col>",91.5, Tile(0, 0,0)),
    AGILITY("<col=0A0E6F>Agility</col>",0.0, Tile(3100, 3277,3)),
    SLAYER("<col=C9B2B2>Slayer</col>",5.2, Tile(0, 0,0)),
    FARMING("<col=89F268>Farming</col>",0.0, Tile(0, 0,0)),
    RUNECRAFTING("<col=EFBB83>Runecrafting</col>",75.0, Tile(0, 0,0)),
    HUNTER("<col=B83741>Hunter</col>",3.6, Tile(2556, 2934,0)),
    CONSTRUCTION("<col=503E0E>Construction</col>",0.0, Tile(0, 0,0));

}