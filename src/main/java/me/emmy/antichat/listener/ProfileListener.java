package me.emmy.antichat.listener;

import cc.insidious.akuma.api.AkumaAPI;
import cc.insidious.akuma.api.profile.Profile;
import cc.insidious.akuma.api.punishment.IPunishmentHandler;
import cc.insidious.akuma.api.punishment.repository.PunishmentRepository;
import me.emmy.antichat.AntiChat;
import me.emmy.antichat.core.CoreHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Emmy
 * @project AntiChat
 * @date 18/01/2025 - 17:57
 */
public class JoinListener implements Listener {

    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Profile profile = AkumaAPI.getInstance().getProfileHandler().getProfile(player.getUniqueId());
        CoreHandler coreHandler = AntiChat.getInstance().getCoreHandler();
        if (coreHandler.isPlayerPunished(player.getUniqueId())) {
            //do something here
        }
    }

    private void onProcessCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        Profile profile = AkumaAPI.getInstance().getProfileHandler().getProfile(player.getUniqueId());
        CoreHandler coreHandler = AntiChat.getInstance().getCoreHandler();
        if (coreHandler.isPlayerPunished(player.getUniqueId())) {
            player.sendMessage();
        }
    }
}
