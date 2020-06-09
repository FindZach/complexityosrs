package gg.rsmod.plugins.content.objs.flax

on_obj_option(obj = FlaxPicking.FLAX_OBJECT_ID, option = 2) {
    val obj = player.getInteractingGameObj()
    player.queue {
            FlaxPicking.pickFlax(this, obj);
    }
}