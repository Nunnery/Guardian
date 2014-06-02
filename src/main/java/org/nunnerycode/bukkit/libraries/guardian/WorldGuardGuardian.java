package org.nunnerycode.bukkit.libraries.guardian;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class WorldGuardGuardian extends AbstractGuardian {

    private WorldGuardPlugin worldGuardPlugin;

    public WorldGuardGuardian() {
        super("WorldGuard");
        Plugin plugin = Bukkit.getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return;
        }
        worldGuardPlugin = (WorldGuardPlugin) plugin;
    }

    @Override
    public boolean canBuild(Player player, Location location) {
        return worldGuardPlugin == null || worldGuardPlugin.canBuild(player, location);
    }

}
