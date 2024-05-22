package de.tim.tpaplugin.Tpa;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class TpaCmd implements CommandExecutor {
    public static HashMap<UUID, UUID> tpaRequests = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("Please specify a player to teleport to.");
            return false;
        }

        Player playerSender = (Player) sender;
        Player targetPlayer = Bukkit.getPlayer(args[0]);

        if (targetPlayer == null) {
            playerSender.sendMessage("Player not found.");
            return false;
        }

        tpaRequests.put(targetPlayer.getUniqueId(), playerSender.getUniqueId());
        targetPlayer.sendMessage(playerSender.getName() + " has requested to teleport to you. Type /tpaaccept to accept.");
        playerSender.sendMessage("Teleport request sent to " + targetPlayer.getName() + ".");
        return true;
    }
}
