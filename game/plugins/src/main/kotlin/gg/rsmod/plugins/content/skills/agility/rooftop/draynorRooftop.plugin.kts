package gg.rsmod.plugins.content.skills.agility.rooftop

on_obj_option(11405, "cross") {
    player.queue {
        val rope = player.getInteractingGameObj()
        val endTile = Tile(3090, 3277, 3)
        val movement = ForcedMovement.of(player.tile, endTile, clientDuration1 = 15, clientDuration2 = 300, directionAngle = Direction.WEST.angle)

        player.forceMove(this, movement)
        player.moveTo(player.tile.x, player.tile.z - 1, player.tile.height)
    }
}

on_obj_option(11406, "cross") {
    player.queue {
        val rope = player.getInteractingGameObj()
        val endTile = Tile(3092, 3266, 3)
        val movement = ForcedMovement.of(player.tile, endTile, clientDuration1 = 15, clientDuration2 = 300, directionAngle = Direction.SOUTH.angle)

        player.moveTo(player.tile.x + 1, player.tile.z, player.tile.height)
        wait(1)

        player.forceMove(this, movement)
    }
}