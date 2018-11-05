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
	    if (this.root == null) {
            BinaryNode<Key, Value> bNode = new BinaryNode<Key, Value>(key, value);
            this.root = bNode;
            size++;
            return null;
        }
		return put(key, value, this.root);
	}
	
	private Value put(Key key, Value value, BinaryNode<Key, Value> node) {
		if (key == null) throw new NullPointerException();
		if (value == null) throw new IllegalArgumentException();

        int cmp = keyComparator.compare(key, node.key);
        if (node.left == null && cmp < 0) {
            node.left = new BinaryNode<>(key, value);
            size++;
            return null;
        }
        if (node.right == null && cmp > 0) {
            node.right = new BinaryNode<>(key, value);
            size++;
            return null;
        }


        if (node.left != null && cmp < 0) return put(key, value, node.left);
        if (node.right != null && cmp > 0) return put(key, value, node.right);

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
		printLexicographically(this.root);
	}

	private void printLexicographically(BinaryNode<Key, Value> node) {
	    if (node == null) return;

        System.out.println("Key: " + node.key + ", Value: " + node.value);
	    printLexicographically(node.left);
	    printLexicographically(node.right);
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

	/* TIPO 1 */
    public Tuple<Key> findMinMax() {
        Tuple<Key> tuple = new Tuple<>(null, null);
        if (this.root == null) return tuple;

        tuple.setMinKey(this.root.key);
        tuple.setMaxKey(this.root.key);

        findMinMax(tuple);
        return tuple;
    }

    private void findMinMax(Tuple<Key> tuple) {
        if (this.root == null) return;
        BinaryNode<Key, Value> left = this.root;

        while (left != null) {
            tuple.setMinKey(left.key);
            left = left.left;
        }

        BinaryNode<Key, Value> right = this.root;
        while (right != null) {
           tuple.setMaxKey(right.key);
           right = right.right;
        }
    }

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

    public Value remove(Key key) {
        if (key == null) throw new NullPointerException();
        Value prev = null;
        this.root = removeR(this.root, key, prev);
        return prev;
    }

    private BinaryNode<Key, Value> removeR(BinaryNode<Key, Value> node, Key key, Value prev) {
        if (node == null) return null;

        int cmp = keyComparator.compare(key, node.key);
        if (cmp < 0) {
            node.left = removeR(node.left, key, prev);
        } else if (cmp > 0) {
            node.right = removeR(node.right, key, prev);
        } else {
            prev = node.value;
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            BinaryNode<Key, Value> min = getMinimum(node.right);
            node.key = min.key;
            node.right = removeR(node.right, node.key, prev);
        }
        return node;
    }

    private BinaryNode<Key, Value> getMinimum(BinaryNode<Key, Value> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
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
