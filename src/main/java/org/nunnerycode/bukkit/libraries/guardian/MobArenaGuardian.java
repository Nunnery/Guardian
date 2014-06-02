package org.nunnerycode.bukkit.libraries.guardian;

import com.garbagemule.MobArena.MobArena;
import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.framework.ArenaMaster;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class MobArenaGuardian extends AbstractGuardian {

    private MobArena mobArena;
    private ArenaMaster arenaMaster;

    public MobArenaGuardian() {
        super("MobArena");
        Plugin plugin = Bukkit.getPluginManager().getPlugin("MobArena");
        if (plugin == null || !(plugin instanceof MobArena)) {
            return;
        }
        mobArena = (MobArena) plugin;
        arenaMaster = mobArena.getArenaMaster();
    }

    @Override
    public boolean canBuild(Player player, Location location) {
        if (mobArena == null || arenaMaster == null) {
            return true;
        }
        Arena arena = arenaMaster.getArenaAtLocation(location);
        return arena == null || arena.inEditMode() || !arena.getSettings().getBoolean("protect");
    }

}
