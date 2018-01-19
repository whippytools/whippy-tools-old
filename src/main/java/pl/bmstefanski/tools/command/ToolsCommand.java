package pl.bmstefanski.tools.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.bmstefanski.tools.Tools;
import pl.bmstefanski.tools.command.basic.CommandContext;
import pl.bmstefanski.tools.command.basic.CommandInfo;
import pl.bmstefanski.tools.storage.configuration.PluginConfig;
import pl.bmstefanski.tools.util.MessageUtils;

public class ToolsCommand {

    private final Tools plugin;
    private final PluginConfig config;

    public ToolsCommand(Tools plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfiguration();
    }

    @CommandInfo(
            name = {"tools"},
            description = "tools command",
            permission = "tools",
            userOnly = true
    )
    public void tools(CommandSender commandSender, CommandContext context) {

        Player player = (Player) commandSender;

        MessageUtils.sendMessage(player, "&e" + plugin.getDescription().getName() +
                                        "&f(" + config.getLanguage().toUpperCase() +
                                        ") &7" + plugin.getDescription().getVersion() +
                                        " by §e" + plugin.getDescription().getAuthors());
    }
}
