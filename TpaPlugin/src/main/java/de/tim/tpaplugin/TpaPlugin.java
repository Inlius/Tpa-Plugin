package de.tim.tpaplugin;

import de.tim.tpaplugin.Tpa.TpaAccept;
import de.tim.tpaplugin.Tpa.TpaCmd;
import de.tim.tpaplugin.Tpa.TpaReject;
import org.bukkit.plugin.java.JavaPlugin;

public final class TpaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.getCommand("tpa").setExecutor(new TpaCmd()); //send Tpa to a player

        this.getCommand("tpaaccept").setExecutor(new TpaAccept());  //accept Tpa (command)
        this.getCommand("tpareject").setExecutor(new TpaReject());  //reject Tpa (command)
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
