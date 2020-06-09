package gg.rsmod.plugins.content.skills.woodcutting

import gg.rsmod.plugins.content.skills.woodcutting.Woodcutting.Tree

private val TREES = setOf(
        Tree(TreeType.TREE, obj = 1278, trunk = 1342),
        Tree(TreeType.TREE, obj = 1276, trunk = 1342),
        Tree(TreeType.TREE, obj = 1286, trunk = 1351), // Dead tree
        Tree(TreeType.TREE, obj = 1282, trunk = 1347), // Dead tree
        Tree(TreeType.TREE, obj = 1383, trunk = 1358), // Dead tree
        Tree(TreeType.TREE, obj = 1289, trunk = 1353), // Dead tree
        Tree(TreeType.TREE, obj = 2091, trunk = 1342), // Evergreen
        Tree(TreeType.ACHEY, obj = 2023, trunk = 3371), // achey
        Tree(TreeType.OAK, obj = 10820, trunk = 1356),
        Tree(TreeType.WILLOW, obj = 10819, trunk = 9711),
        Tree(TreeType.WILLOW, obj = 10829, trunk = 9471),
        Tree(TreeType.WILLOW, obj = 10831, trunk = 9471),
        Tree(TreeType.WILLOW, obj = 10833, trunk = 9471),
        Tree(TreeType.TEAK, obj = 9036, trunk = 9037),
        Tree(TreeType.MAPLE, obj = 10832, trunk = 9712),
        Tree(TreeType.HOLLOW, obj = 10821, trunk = 2310),
        Tree(TreeType.HOLLOW, obj = 10830, trunk = 4061),
        Tree(TreeType.MAHOGANY, obj = 9034, trunk = 9035),
        Tree(TreeType.YEW, obj = 10822, trunk = 9714),//wrong trunkid?
        Tree(TreeType.YEW, obj = 10823, trunk = 9714),
        Tree(TreeType.YEW, obj = 10828, trunk = 9714),
        Tree(TreeType.MAGIC, obj = 10834, trunk = 9713),//wrong trunkid?
        Tree(TreeType.MAGIC, obj = 10835, trunk = 9713),
        Tree(TreeType.REDWOOD, obj = 29668, trunk = 29669),
        Tree(TreeType.REDWOOD, obj = 29670, trunk = 29671)
)

TREES.forEach { tree ->
    on_obj_option(obj = tree.obj, option = 1) {
        val obj = player.getInteractingGameObj()
        player.queue {
            Woodcutting.chopDownTree(this, obj, tree.type, tree.trunk)
        }
    }
}