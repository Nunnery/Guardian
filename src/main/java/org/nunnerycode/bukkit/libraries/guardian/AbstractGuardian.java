package org.nunnerycode.bukkit.libraries.guardian;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * A base class for checking if a player can build at a location.
 */
public abstract class AbstractGuardian {

    private final String name;

    protected AbstractGuardian(String name) {
        this.name = name;
    }

    /**
     * Checks if the given {@link Player} can build at the given {@link Location}.
     * @param player Player to check
     * @param location Location to check
     * @return if the Player can build at the Location
     */
    public abstract boolean canBuild(Player player, Location location);

    /**
     * Returns the name of the plugin this AbstractGuardian represents.
     * @return name of represented plugin
     */
    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractGuardian)) {
            return false;
        }

        AbstractGuardian that = (AbstractGuardian) o;

        return !(name != null ? !name.equals(that.name) : that.name != null);
    }

    @Override
    public final int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
