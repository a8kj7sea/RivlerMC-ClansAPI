package me.a8kj.rivlermc.clans.parent.utils;

import java.util.List;

/**
 * Represents a module loader that can load and retrieve modules of type T.
 *
 * @param <T> The type of the modules being loaded.
 */
public interface IModuleLoader<T> {

    /**
     * Loads and returns a list of modules.
     *
     * @return A list of loaded modules.
     */
    List<T> load();

    /**
     * Retrieves a module based on the provided label.
     *
     * @param label The identifier used to retrieve the module.
     * @return The module associated with the given label, or null if not found.
     */
    T get(Object label);
}
