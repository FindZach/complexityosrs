package gg.rsmod.plugins.content.mechanics.displayname

import java.nio.file.Files
import java.nio.file.Paths

on_button(261, 75) {
    player.openInterface(interfaceId = 589, dest = InterfaceDestination.TAB_AREA)
    player.setComponentText(interfaceId = 589, component = 6, text = "Next free change:")
    player.setComponentText(interfaceId = 589, component = 7, text = "Now!") // Make this a method to pull last updated date from your database, return that date, or "Now!"
    player.setInterfaceEvents(interfaceId = 589, component = 18, range = 0..9, setting = 0)
    player.setVarbit(5605, 1)
}

on_button(589, 18) {
    player.queue {
        val name = inputString("What name would you like to check (maximum of 12 characters)?")
        player.setComponentText(interfaceId = 589, component = 15, text = name)
        player.setVarbit(5605, 2)
        //this is just checking flat file names, write logic to actually check display names
        val path = Paths.get("./data/saves/", name)
        //“simulating a wait”, ignore this
        wait(2)
        //replace this entire block with actual logic
        if (Files.exists(path)) {
            player.setComponentText(interfaceId = 589, component = 15, text = "<col=ffffff>Not available")
            player.setVarbit(5605, 1)
        } else {
            player.setInterfaceEvents(interfaceId = 589, component = 19, range = 0..9, setting = 0)
            player.setVarbit(5605, 4)
            player.setVarbit(5606, 1)
            player.setVarbit(5607, 0)
            player.setComponentText(interfaceId = 589, component = 15, text = "<col=00ff00>Not taken")
            player.runClientScript(635, name)
        }
    }
}

on_button(589, 19) {
    player.queue {
        player.setVarbit(5605, 1)
        player.setComponentText(interfaceId = 589, component = 15, text = "")
        player.queue {
            messageBox("Your display name request was accepted. Please log out and in for your changes to take effect.")
        }
    }
}

on_button(589, 2) {
    player.closeInterface(589)
}