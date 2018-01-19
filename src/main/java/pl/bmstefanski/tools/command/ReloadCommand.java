package pl.bmstefanski.tools.command;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import pl.bmstefanski.tools.Tools;
import pl.bmstefanski.tools.command.basic.CommandContext;
import pl.bmstefanski.tools.command.basic.CommandInfo;
import pl.bmstefanski.tools.storage.configuration.Messages;
import pl.bmstefanski.tools.util.MessageUtils;

public class ReloadCommand {

    private final Tools plugin;
    private final Messages messages;

    public ReloadCommand(Tools plugin) {
        this.plugin = plugin;
        this.messages = plugin.getMessages();
    }

    @CommandInfo(
            name = "tools-reload",
            description = "reload command",
            permission = "reload",
            userOnly = true
    )
    public void reload(CommandSender commandSender, CommandContext context) {

        long startedTime = System.currentTimeMillis();

        // todo CHUUUUJ

        long elapsedTime = (System.currentTimeMillis() - startedTime);
        float elapsedTimeSecond = elapsedTime / 1000F;

        MessageUtils.sendMessage(commandSender, StringUtils.replace(messages.getSuccessfullyReloaded(), "%time%", elapsedTimeSecond + ""));
    }
}
