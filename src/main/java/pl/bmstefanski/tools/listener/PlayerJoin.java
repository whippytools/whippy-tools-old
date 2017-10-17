package pl.bmstefanski.tools.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.bmstefanski.tools.object.User;
import pl.bmstefanski.tools.object.util.UserUtils;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        User.get(event.getPlayer());
    }
}