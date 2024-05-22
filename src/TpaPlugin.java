package de.tim.tpaplugin;

import de.tim.tpaplugin.Tpa.TargetCmd;
import de.tim.tpaplugin.Tpa.TpaCmd;
import org.bukkit.plugin.java.JavaPlugin;

public final class TpaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("tpa").setExecutor(new TpaCmd());
        this.getCommand("tpaaccept").setExecutor(new TargetCmd());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
