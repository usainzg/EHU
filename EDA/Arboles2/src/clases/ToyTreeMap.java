package clases;

import java.util.Comparator;

public class ToyTreeMap<Key, Value> {
	private BinaryNode<Key, Value> root;
	
	private int size;
	
	private final Comparator<? super Key> keyComparator;
	
	public ToyTreeMap(Comparator<? super Key> keyComparator) {
		this.root = null;
		this.keyComparator = keyComparator;
		this.size = 0;
	}
	
	/* TIPO 0 */
	public Value put(Key key, Value value) {
		return put(key, value, this.root);
	}
	
	private Value put(Key key, Value value, BinaryNode<Key, Value> node) {
		if (key == null) throw new NullPointerException();
		if (value == null) throw new IllegalArgumentException();
		
		// VACIA
		if (node == null) {
			BinaryNode<Key, Value> bNode = new BinaryNode<Key, Value>(key, value);
			this.root = bNode;
			size++;
			return null;
		}
		
		int cmp = keyComparator.compare(key, node.key);
		if (cmp < 0) return put(key, value, node.left);
		if (cmp > 0) return put(key, value, node.right);
		
		node.value = value;
		return value;
	}
	
	public Value get(Key key) {
		if(key == null) throw new NullPointerException();
		return get(key, this.root);
	}
	
	private Value get(Key key, BinaryNode<Key, Value> node) {
		if (node == null) return null;
		int cmp = keyComparator.compare(key, node.key);
		if (cmp < 0) return get(key, node.left);
		if (cmp > 0) return get(key, node.right);
		return node.value;
	}
	
	public int size() {
		return size;
	}
	
	public int clear() {
		int sizeRet = this.size;
		this.root = null;
		size = 0;
		return sizeRet;
	}
	
	public void printLexicographically() {
		
	}
	
	private BinaryNode<Key, Value> getNode(Key key) {
		if(key == null) throw new NullPointerException();
		return getNode(key, this.root);
	}
	
	private BinaryNode<Key, Value> getNode(Key key, BinaryNode<Key, Value> node) {
		if (node == null) return null;
		int cmp = keyComparator.compare(key, node.key);
		if (cmp < 0) return getNode(key, node.left);
		if (cmp > 0) return getNode(key, node.right);
		return node;
	}
	
	private boolean contains(Key key) {
		return contains(key, this.root);
	}
	
	private boolean contains(Key key, BinaryNode<Key, Value> node) {
		if (key == null) return false;
		int cmp = keyComparator.compare(key, node.key);
		if (cmp < 0) return contains(key, node.left);
		if (cmp > 0) return contains(key, node.right);
		return true;
	}

	/* TIPO 1 */
    public boolean isBST() {
        BinaryNode<Key, Value> previous = null;
        return isBST(this.root, previous);
    }

    private boolean isBST(BinaryNode<Key, Value> node, BinaryNode<Key, Value> prev) {
        if (node != null) {
            if (!isBST(node.left, prev)) return false;

            if (prev != null) {
                int cmp = keyComparator.compare(node.key, prev.key);
                if (cmp <= 0) return false;
            }
            prev = node;
            return isBST(node.right, prev);
        }
        return true;
    }
	
	
	private static class BinaryNode<Key, Value> {
		Key key;
		Value value;
        BinaryNode<Key, Value> left;
        BinaryNode<Key, Value> right;

        BinaryNode(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
	}
}
