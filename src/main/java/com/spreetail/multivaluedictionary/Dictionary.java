package com.spreetail.multivaluedictionary;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/* Dictionary Class provides a Generic implementation of a Dictionary / Map */
public class Dictionary<K, V> {

    private final Map<K, Set<V>> dictionary = new HashMap<>();

    public Set<V> getItemFromDictionary(K key) {
        return this.dictionary.getOrDefault(key, new LinkedHashSet<>());
    }

    @SafeVarargs
    public final boolean itemExist(K key, V... value) {
        V v = value.length > 0 ? value[0]: null;
        boolean exists = this.dictionary.containsKey(key);
        if(v != null) {
            return exists && this.dictionary.get(key).contains(v);
        }
        return exists;
    }

    @SafeVarargs
    public final boolean removeFromDictionary(K key, V... value) {
        V v = value.length > 0 ? value[0]: null;
        if(v != null) {
            return this.dictionary.get(key).remove(v);
        }
        this.dictionary.remove(key);
        return !dictionary.containsKey(key);
    }

    public boolean addItemToDictionary(K key, V value) {
        if(!dictionary.containsKey(key)) {
            this.dictionary.put(key, new LinkedHashSet<>());
            this.dictionary.get(key).add(value);
            return true;
        }
        return this.dictionary.get(key).add(value);
    }

    public Set<K> getKeySet() {
        return this.dictionary.keySet();
    }

    public int getDictionarySize() {
        return this.dictionary.size();
    }

    public void clearDictionary() {
        dictionary.clear();
    }

    public Set<V> getValueSet() {
        return dictionary.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
    }
}
