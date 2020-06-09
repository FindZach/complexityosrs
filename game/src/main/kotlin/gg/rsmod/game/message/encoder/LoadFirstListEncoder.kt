package gg.rsmod.game.message.encoder;

import gg.rsmod.game.message.MessageEncoder
import gg.rsmod.game.message.impl.LoadFriendListMessage

class LoadFriendListEncoder : MessageEncoder<LoadFriendListMessage>() {

    override fun extract(message: LoadFriendListMessage, key: String): Number = when (key) {
        "online" -> message.online
        "world" -> message.world
        else -> throw Exception("Unhandled value key.")
    }

    override fun extractBytes(message: LoadFriendListMessage, key: String): ByteArray = when(key) {
        "username" -> {
            if (message.username != null) {
                val data = ByteArray(message.username.length + 1)
                System.arraycopy(message.username.toByteArray(), 0, data, 0, data.size - 1)
                data[data.size - 1] = 0
                data
            } else {
                ByteArray(0)
            }
        }
        "previousUsername" -> {
            if (message.previousUsername != null) {
                val data = ByteArray(message.previousUsername.length + 1)
                System.arraycopy(message.previousUsername.toByteArray(), 0, data, 0, data.size - 1)
                data[data.size - 1] = 0
                data
            } else {
                ByteArray(0)
            }
        }
        else -> throw Exception("Unhandled value key.")
    }

}