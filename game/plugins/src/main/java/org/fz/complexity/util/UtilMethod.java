package org.fz.complexity.util;

import gg.rsmod.game.fs.Definition;
import gg.rsmod.game.fs.DefinitionSet;
import gg.rsmod.game.fs.def.ItemDef;
import gg.rsmod.game.model.World;
import gg.rsmod.game.model.entity.Player;
import gg.rsmod.game.model.item.Item;
import net.runelite.cache.definitions.ItemDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zach (findzach.com)
 *  This will be a buncha methods that I can use quickly.
 */
public class UtilMethod {

    /**
     * Gets a list of items from the String
     * @param ID
     * @return
     */
    public static List<Item> getItemsByName(Player player, String searchName) {
        List<Item> resultItems = new ArrayList<>();

        DefinitionSet defs = player.getWorld().getDefinitions();
        for (int i = 0; i < 10000; i++) {

            ItemDef def = defs.get(ItemDef.class, i);

            System.out.println(def.getName());
        }


        return resultItems;
    }


}
