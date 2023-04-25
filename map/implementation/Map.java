package map.implementation;

import java.util.Set;

/**
 * An object that maps keys to values. A map cannot contain duplicate keys;
 * each key can map to at most one value.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author aziz
 */
public interface Map<K, V> extends Iterable<K> {

    /**
     * Removes all the mappings from the map.
     */
    void clear();

    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key the key to lookup
     * @return true if this map contains the key.
     */
    boolean containsKey(K key);

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     * @param key the key to lookup
     * @return the value mapped to the key if the key is present, else null.
     */
    V get(K key);

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of mappings in this map.
     */
    int size();

    /**
     * Associates the specified value with the specified key in this map.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with key
     */
    void put(K key, V value);

    /**
     * Returns a Set view of the keys contained in this map.
     * @return a set view of the keys contained in this map
     */
    Set<K> keySet();

    /**
     * Removes the mapping for the specified key from this map, and returns the value
     * associated with the key, else return null if key is not present.
     * @param key key for which the mapping should be removed
     * @return the value associated with key, or null if there was no mapping for key
     */
    V remove(K key);

    /**
     * Removes the entry for the specified key only if key is currently mapped to
     * the specified value, and returns the value. else return null if key is not present.
     * @param key key for which the mapping should be removed
     * @param value value associated with the specified key
     * @return the value associated with key, or null if there was no exact match with key and value
     */
    V remove(K key, V value);
}
