package me.emmy.antichat.core;

import cc.insidious.akuma.api.AkumaAPI;
import cc.insidious.akuma.api.punishment.IPunishmentHandler;
import cc.insidious.akuma.api.punishment.type.PunishmentType;
import lombok.Getter;
import me.emmy.antichat.util.CC;
import org.bukkit.Bukkit;

import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Emmy
 * @project AntiChat
 * @date 18/01/2025 - 17:56
 */
@Getter
public class CoreHandler {
    private final Set<PunishmentType> BAN_TYPES = EnumSet.of(
            PunishmentType.TEMPORARY_BAN,
            PunishmentType.BAN,
            PunishmentType.TEMPORARY_IP_BAN,
            PunishmentType.IP_BAN,
            PunishmentType.BLACKLIST
    );

    /**
     * Check if a player is punished based on Akuma's punishment system.
     *
     * @param uuid The UUID of the player
     * @return true if the player is punished, false otherwise
     */
    public boolean isPlayerPunished(UUID uuid) {
        IPunishmentHandler punishmentHandler = AkumaAPI.getInstance().getPunishmentHandler();

        for (PunishmentType type : this.BAN_TYPES) {
            if (punishmentHandler.getActivePunishment(uuid, type).isActive()) {
                Bukkit.getConsoleSender().sendMessage(CC.translate("&4[DEBUG] &cPlayer " + Bukkit.getPlayer(uuid).getName() + " is punished with type " + type.name() + "."));
                return true;
            }
        }

        return false;
    }
}