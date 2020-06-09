import gg.rsmod.game.message.Message

/**
 * @author Tom <rspsmods@gmail.com>
 */
data class IfSetObjectsMessage(val hash: Int, val item: IntArray, val amount: IntArray) : Message