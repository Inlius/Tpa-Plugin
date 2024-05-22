package de.tim.tpaplugin.Tpa;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.tim.tpaplugin.Tpa.TpaCmd.tpaRequests;


public class TpaReject implements CommandExecutor {

    /** Removes player from the Hashmap */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player targetPlayer = (Player) sender;
        UUID targetUUID = targetPlayer.getUniqueId();

        tpaRequests.remove(targetUUID);
        return false;
    }
}
