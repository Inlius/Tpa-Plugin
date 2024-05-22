package de.tim.tpaplugin.Tpa;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.tim.tpaplugin.Tpa.TpaCmd.tpaRequests;

public class TargetCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Command only for Players");
            return true;
        }

        Player targetPlayer = (Player) sender;
        UUID targetUUID = targetPlayer.getUniqueId();

        if (!tpaRequests.containsKey(targetUUID)) {
            targetPlayer.sendMessage("You have no pending teleport requests.");
            return true;
        }

        UUID senderUUID = tpaRequests.get(targetUUID);
        Player playerSender = Bukkit.getPlayer(senderUUID);

        if (playerSender == null) {
            targetPlayer.sendMessage("The TPA is expired");
            tpaRequests.remove(targetUUID);
            return true;
        }

        playerSender.teleport(targetPlayer.getLocation());
        playerSender.sendMessage("Teleporting to " + targetPlayer.getName() + ".");
        targetPlayer.sendMessage("Acceptet Teloportation request " + playerSender.getName() + ".");
        tpaRequests.remove(targetUUID);
        return true;
    }
}
