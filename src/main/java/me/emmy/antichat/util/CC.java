package me.emmy.antichat.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

/**
 * @author Emmy
 * @project AntiChat
 * @date 18/01/2025 - 18:03
 */
@UtilityClass
public class CC {
    /**
     * Translate a string with color codes.
     *
     * @param string The string to translate
     * @return The translated string
     */
    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
