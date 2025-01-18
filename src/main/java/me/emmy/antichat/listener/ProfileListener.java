package me.emmy.antichat.listener;

import me.emmy.antichat.AntiChat;
import me.emmy.antichat.core.CoreHandler;
import me.emmy.antichat.util.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * @author Emmy
 * @project AntiChat
 * @date 18/01/2025 - 17:57
 */
public class ProfileListener implements Listener {
    protected final CoreHandler coreHandler;

    /**
     * Constructor for the JoinListener class.
     *
     * @param coreHandler The core handler instance
     */
    public ProfileListener(CoreHandler coreHandler) {
        this.coreHandler = coreHandler;
    }

    @EventHandler
    private void onProcessCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        CoreHandler coreHandler = AntiChat.getInstance().getCoreHandler();
        if (coreHandler.isPlayerPunished(player.getUniqueId())) {
            player.sendMessage(CC.translate("&cYou cannot execute commands while being punished."));
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        CoreHandler coreHandler = AntiChat.getInstance().getCoreHandler();
        if (coreHandler.isPlayerPunished(player.getUniqueId())) {
            player.sendMessage(CC.translate("&cYou cannot chat while being punished."));
            event.setCancelled(true);
        }
    }
}
