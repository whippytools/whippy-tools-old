package pl.bmstefanski.tools.command;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.bmstefanski.tools.command.basic.CommandContext;
import pl.bmstefanski.tools.command.basic.CommandInfo;
import pl.bmstefanski.tools.impl.configuration.Messages;
import pl.bmstefanski.tools.util.MessageUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkbenchCommand {

    @CommandInfo (
            name = {"workbench", "wb", "crafting"},
            description = "workbench command",
            permission = "workbench",
            userOnly = true,
            usage = "[player]",
            completer = "workbenchCompleter"
    )

    public void workbench(CommandSender commandSender, CommandContext context) {

        Player player = (Player) commandSender;

        if (context.getArgs().length == 0) {
            player.openInventory(player.getInventory());
            return;
        }

        if (Bukkit.getPlayer(context.getParam(0)) == null) {
            MessageUtils.sendMessage(player, StringUtils.replace(Messages.PLAYER_NOT_FOUND, "%player%", context.getParam(0)));
            return;
        }

        Player target = Bukkit.getPlayer(context.getParam(0));
        player.openInventory(target.getInventory());
    }

    public List<String> workbenchCompleter(CommandSender commandSender, CommandContext context) {
        if (context.getArgs().length == 1) {
            List<String> availableList = new ArrayList<>();

            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getName().startsWith(context.getParam(0).toLowerCase())) {
                    availableList.add(player.getName());
                }
            }

            Collections.sort(availableList);
            return availableList;
        }

        return null;
    }

}