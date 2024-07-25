package me.a8kj.rivlermc.clans.parent.utils;

import java.util.Collection;

public class SimpleCollectionManager<V> implements Manager {

    @Override
    public MetaData getMetaData() {
        return new MetaData("managers.java.collections");
    }

    private Collection<V> collection;

    public SimpleCollectionManager(Collection<V> newCollection) {
        this.collection = newCollection;
    }

    public void add(V value) {
        if (contains(value))
            return;
        this.collection.add(value);
    }

    public void remove(V value) {
        if (contains(value))
            return;
        this.collection.remove(value);
    }

    public void clearAll(V value) {
        if (collection.isEmpty())
            return;
        this.collection.clear();
    }

    public boolean contains(V value) {
        return this.collection.contains(value);
    }

    @SuppressWarnings("unchecked")
    public void updateCollection(@SuppressWarnings("rawtypes") Collection newCollection) {
        this.collection = newCollection;
    }

    public Collection<V> getCollection() {
        return collection;
    }

}