package me.a8kj.rivlermc.clans.parent.entity.clan.relation.impl;

import java.util.Set;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;
import me.a8kj.rivlermc.clans.parent.entity.clan.relation.Relation;

/**
 * A concrete implementation of the Relation class representing an ally
 * relationship with a set of IClan entities.
 */
public abstract class AllyRelation extends Relation<IClan> {

    /**
     * Constructs an AllayRelation instance with the default metadata "friend".
     */
    public AllyRelation() {
        super("friend");
    }

    /**
     * Returns the set of related IClan entities.
     *
     * @return The set of related IClan entities.
     */
    @Override
    public Set<IClan> getRelationSet() {
        return super.getRelationSet();
    }
}
