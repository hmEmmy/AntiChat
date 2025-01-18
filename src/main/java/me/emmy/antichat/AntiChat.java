package me.emmy.antichat;

import lombok.Getter;
import me.emmy.antichat.core.CoreHandler;
import me.emmy.antichat.listener.ProfileListener;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class AntiChat extends JavaPlugin {

    @Getter private static AntiChat instance;

    private CoreHandler coreHandler;

    @Override
    public void onEnable() {
        instance = this;

        this.coreHandler = new CoreHandler();

        this.getServer().getPluginManager().registerEvents(new ProfileListener(this.coreHandler), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
