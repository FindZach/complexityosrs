package gg.rsmod.plugins.content.skills.firemaking.data

enum class LogType(val level: Int, val xp: Double, val itemId: Int) {
    LOG(level = 1, xp = 15.0, itemId = 1511),
    OAK_LOG(level=15, xp = 40.2, itemId = 1521),
    WILLOW_LOG(level=30, xp = 60.66, itemId = 1519),
    MAPLE_LOG(level = 45, xp = 110.55, itemId = 1517),
    YEW_LOG(level = 65, xp = 150.0, itemId= 1515),
    MAGIC_LOG(level = 75, xp = 180.5, itemId = 1513),
    REDWOOD_LOG(level = 90, xp= 210.5, itemId = 19669)
}