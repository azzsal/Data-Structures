package set.bstset.implementation;

import set.Set;

import java.util.Iterator;
import java.util.Stack;

/**
 * An (unbalanced) Binary-Search Tree based set implementation, the set is sorted according to the
 * natural ordering of its values; so the value type must implement the Comparable interface.
 * The <em>add</em>, <em>contains</em>, <em>remove</em> operations
 * each take &Theta;(<em>h</em>) in the worst case, where h is the height of the tree,
 * (the worst height is n).
 * The <em>size</em> and <em>clear</em> operations each take &Theta;(<em>1</em>).
 * @param <E> the type of values in this set
 *
 * @author aziz
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private static class BSTNode<E> {
        E value;
        BSTNode<E> left;
        BSTNode<E> right;

        BSTNode(E value) {
            this.value = value;
        }
    }

    /**
     * Initializes an empty BST set.
     */
    public BSTSet() {
        this.root = null;
        this.size = 0;
    }

    private BSTNode<E> root;
    private int size;

    /**
     * Removes all the values from the set.
     * Time complexity: takes constant time &Theta;(<em>1</em>).
     */
    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Returns true if this set contains the value, false otherwise.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     *
     * @param value the value to check if this set contains it
     * @return true if this set contains the value.
     */
    @Override
    public boolean contains(E value) {
        return contains(root, value);
    }

    private boolean contains(BSTNode<E> root, E value) {
        if(root == null) {
            return false;
        }
        int cmp = value.compareTo(root.value);
        if(cmp < 0) {
            return contains(root.left, value);
        } else if(cmp > 0) {
            return contains(root.right, value);
        } else {
            return true;
        }
    }

    /**
     * Returns the number of values this set.
     * Time complexity: takes constant time.
     *
     * @return the number of values in this set.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Add the value in this set if not present.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     *
     * @param value value to store in the set if not already present in this set
     */
    @Override
    public void add(E value) {
        this.root = add(root, value);
    }

    private BSTNode<E> add(BSTNode<E> root, E value) {
        if(root == null) {
            size += 1;
            return new BSTNode<E>(value);
        }
        int cmp = value.compareTo(root.value);
        if (cmp < 0) {
            root.left = add(root.left, value);
        } else if (cmp > 0) {
            root.right = add(root.right, value);
        }
        return root;
    }

    /**
     * If the supplied value is in the set, it is removed and the value is returned,
     * otherwise null is returned.
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     *
     * @param value value to be removed from this set
     * @return the removed value if present, else null
     */
    @Override
    public E remove(E value) {
        BSTNode<E> node = get(root, value);
        if(node == null) {
            return null;
        }
        E temp = node.value;
        root = remove(root, value);
        size -= 1;
        return temp;
    }

    private BSTNode<E> get(BSTNode<E> root, E value) {
        if(root == null) {
            return null;
        }
        int cmp = value.compareTo(root.value);
        if(cmp < 0) {
            return get(root.left, value);
        } else if(cmp > 0) {
            return get(root.right, value);
        } else {
            return root;
        }
    }

    private BSTNode<E> remove(BSTNode<E> root, E value) {
        if(root == null) {
            return null;
        }
        int cmp = value.compareTo(root.value);
        if(cmp < 0) {
            root.left = remove(root.left, value);
        } else if(cmp > 0) {
            root.right = remove(root.right, value);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                BSTNode<E> successor = getMinNode(root.right);
                root.value = successor.value;
                root.right = remove(root.right, successor.value);
                size -= 1;
            }
        }
        return root;
    }

    private BSTNode<E> getMinNode(BSTNode<E> node) {
        while(node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Returns a stack based iterator for in-order traversal over the bst.
     * hasNext() method takes constant time, while next() takes &Theta;(<em>h</em>)
     * in the worst case, (where the worst height is n).
     *
     * @return a stack based iterator for in-order traversal over the bst.
     */
    @Override
    public Iterator<E> iterator() {
        return new StackBSTSetIterator();
    }

    private class StackBSTSetIterator implements Iterator<E> {

        Stack<BSTNode<E>> stack;

        StackBSTSetIterator() {
            stack = new Stack<>();
            BSTNode<E> current = root;
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
        public E next() {
            BSTNode<E> current = stack.pop();
            if(current.right != null) {
                BSTNode<E> temp = current.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return current.value;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> it = this.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
