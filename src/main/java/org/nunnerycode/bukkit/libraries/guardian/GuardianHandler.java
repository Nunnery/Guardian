package org.nunnerycode.bukkit.libraries.guardian;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * A class used for handling various AbstractGuardians.
 */
public final class GuardianHandler {

    private Set<AbstractGuardian> guardianSet;

    /**
     * Instantiates a new GuardianHandler.
     */
    public GuardianHandler() {
        guardianSet = new HashSet<>();
    }

    /**
     * Returns a copy of the currently loaded AbstractGuardians.
     * @return currently loaded AbstractGuardians
     */
    public Set<AbstractGuardian> getGuardians() {
        return new HashSet<>(guardianSet);
    }

    /**
     * Adds an AbstractGuardian to the currently loaded collection.
     * @param guardian AbstractGuardian to check
     * @return if adding was successful
     */
    public boolean addGuardian(AbstractGuardian guardian) {
        return guardian != null && !guardianSet.contains(guardian) && guardianSet.add(guardian);
    }

    /**
     * Removes an AbstractGuardian from the currently loaded collection.
     * @param guardian AbstractGuardian to check
     * @return if removal was successful
     */
    public boolean removeGuardian(AbstractGuardian guardian) {
        return guardian != null && guardianSet.contains(guardian) && guardianSet.remove(guardian);
    }

    /**
     * Checks against all loaded AbstractGuardians if the Player can build at the Location.
     * @param player Player to check
     * @param location Location to check
     * @return true if Player can build, false if not
     */
    public boolean canBuild(Player player, Location location) {
        for (AbstractGuardian guardian : guardianSet) {
            if (guardian.canBuild(player, location)) {
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * Loads all of the default AbstractGuardians.
     */
    public void loadDefaultGuardians() {
        if (Bukkit.getPluginManager().getPlugin("WorldGuard") != null) {
            addGuardian(new WorldGuardGuardian());
        }
        if (Bukkit.getPluginManager().getPlugin("MobArena") != null) {
            addGuardian(new MobArenaGuardian());
        }
    }

}
