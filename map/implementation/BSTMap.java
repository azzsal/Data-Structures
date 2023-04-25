package map.implementation;


import java.util.*;
import java.util.function.Consumer;

/**
 * An (unbalanced) Binary-Search Tree based map implementation, the map is sorted according the
 * natural ordering of its keys; so the key type must implement the Comparable interface.
 * This implementation allows for null values, thus setting a key to a null,
 * does not delete it (no lazy deletion).
 * The <em>put</em>, <em>containsKey</em>, <em>remove</em> and <em>get</em> operations
 * each take &Theta;(<em>h</em>) in the worst case, where h is the height of the tree,
 * (the worst height is n).
 * The <em>size</em> and <em>clear</em> operations each take &Theta;(<em>1</em>).
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author aziz
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        BSTNode (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private BSTNode<K, V> root;
    private int size;

    /**
     * Initializes an empty BST map.
     */
    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Removes all the mappings from the map.
     * Time complexity: takes constant time &Theta;(<em>1</em>).
     */
    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param key the key to lookup
     * @return true if this map contains the key.
     */
    @Override
    public boolean containsKey(K key) {
        return get(root, key) != null;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param key the key to lookup
     * @return the value mapped to the key if the key is present, else null.
     */
    @Override
    public V get(K key) {
        BSTNode<K, V> node = get(root, key);
        return node != null ? node.value : null;
    }

    private BSTNode<K, V> get(BSTNode<K, V> root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            return get(root.left, key);
        }
        else if (cmp > 0) {
            return get(root.right, key);
        }
        else {
            return root;
        }
    }

    /**
     * Returns the number of key-value mappings in this map.
     * Time complexity: takes constant time.
     * @return the number of mappings in this map.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with key
     */
    @Override
    public void put(K key, V value) {
        this.root = put(root, key, value);
    }

    private BSTNode<K, V> put(BSTNode<K, V> root, K key, V value) {
        if (root == null) {
            this.size += 1;
            return new BSTNode<K, V>(key, value);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        }
        else if (cmp > 0) {
            root.right = put(root.right, key, value);
        }
        return root;
    }

    /**
     * Traverses the bst in order, printing each item.
     * Time complexity: &Theta;(<em>n</em>).
     */
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BSTNode<K, V> root) {
        traverseInOrder(root, (BSTNode<K, V> node) ->
                System.out.print(node.key + ":" + node.value + "  "));
        System.out.println();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     * Time complexity: &Theta;(<em>n</em>).
     * @return a set view of the keys contained in this map
     */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new TreeSet<>();
        traverseInOrder(root, (BSTNode<K, V> node) -> keys.add(node.key));
        return keys;
    }

    private void traverseInOrder(BSTNode<K, V> root, Consumer<BSTNode<K, V>> processNode) {
        if(root == null) {
            return;
        }
        traverseInOrder(root.left, processNode);
        processNode.accept(root);
        traverseInOrder(root.right, processNode);
    }

    /**
     * Removes the mapping for the specified key from this map, and returns the value
     * associated with the key, else return null if key is not present.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param key key for which the mapping should be removed
     * @return the value associated with key, or null if there was no mapping for key
     */
    @Override
    public V remove(K key) {
        BSTNode<K, V> node = get(root, key);
        if (node == null) {
            return null;
        }
        V value = node.value;
        root = remove(root, key);
        size -= 1;
        return value;
    }

    private BSTNode<K, V> remove(BSTNode<K, V> root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = remove(root.left, key);
        }
        else if (cmp > 0) {
            root.right = remove(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            else {
                BSTNode<K, V> successor = getMinNode(root.right);
                root.key = successor.key;
                root.value = successor.value;
                root.right = remove(root.right, successor.key);
            }
        }
        return root;
    }

    private BSTNode<K, V> getMinNode(BSTNode<K, V> root) {
        if (root == null) {
            return null;
        }
        else if (root.left == null) {
            return root;
        }
        return getMinNode(root.left);
    }

    /**
     * Removes the entry for the specified key only if key is currently mapped to
     * the specified value, and returns the value. else return null if key is not present.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param key key for which the mapping should be removed
     * @param value value associated with the specified key
     * @return the value associated with key, or null if there was no exact match with key and value
     */
    @Override
    public V remove(K key, V value) {
        BSTNode<K, V> node = get(root, key);
        if(node == null || node.value != value) {
            return null;
        }
        V nodeValue = node.value;
        root = remove(root, key);
        size -= 1;
        return nodeValue;
    }

    /**
     * Returns a stack based iterator for in-order traversal over the bst.
     * hasNext() method takes constant time, while next() takes &Theta;(<em>h</em>)
     * in the worst case, (where the worst height is n).
     * @return a stack based iterator for in-order traversal over the bst.
     */
    @Override
    public Iterator<K> iterator() {
        return new StackBSTMapIterator();
    }

    private class StackBSTMapIterator implements Iterator<K> {

        Stack<BSTNode<K, V>> stack;

        StackBSTMapIterator() {
            stack = new Stack<>();
            BSTNode<K, V> current = root;
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public K next() {
            BSTNode<K, V> current = stack.pop();
            if(current.right != null) {
                BSTNode<K, V> temp = current.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return current.key;
        }
    }

}


