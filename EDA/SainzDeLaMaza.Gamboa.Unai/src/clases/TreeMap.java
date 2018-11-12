package clases;

import java.util.*;

public class TreeMap<Key, Value> {
	private BinaryNode<Key, Value> root;
	
	private int size;
	
	private final Comparator<? super Key> keyComparator;

	public TreeMap(Comparator<? super Key> keyComparator) {
		this.root = null;
		this.keyComparator = keyComparator;
		this.size = 0;
	}
	
	public Value put(Key key, Value value) {
		if (key == null) throw new NullPointerException();
		if (value == null) throw new IllegalArgumentException();

		if (root == null) {
		    this.root = new BinaryNode<>(key, value);
		    this.root.parent = null;
		    size++;
		    return null;
        } else {
		    return root.insert(key, value, keyComparator, root);
        }
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
		
		if (node.parent != null)
		    System.out.println("Parent KEY: " + node.parent.key);
		else
		    System.out.println("No Tiene PADRE");
		
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

    /* TIPO 0 */
    public void printByLevel() {
    	if (this.root == null) {
    		System.out.println("Lista vacia");
    		return;
    	}
    	printByLevel(this.root);
    }
    
    private void printByLevel(BinaryNode<Key, Value> node) {
        if(node == null) return;

        Queue<BinaryNode<Key, Value>> q = new LinkedList<>();
        q.add(node);


        while(true) {
            int c = q.size();
            if(c == 0) break;

            while(c > 0) {
                BinaryNode<Key, Value> n = q.peek();
                System.out.print(n.key + " ");
                q.remove();
                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);
                c--;
            }
            System.out.println();
        }
    }
    
    public Value remove(Key key) {
        if (key == null) throw new NullPointerException();
        Value prev = get(key);
        this.root = removeR(this.root, key);
        return prev;
    }

    private BinaryNode<Key, Value> removeR(BinaryNode<Key, Value> node, Key key) {
        if (node == null) return null;

        int cmp = keyComparator.compare(key, node.key);
        if (cmp < 0) {
            node.left = removeR(node.left, key);
        } else if (cmp > 0) {
            node.right = removeR(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            BinaryNode<Key, Value> min = getMinimum(node.right);
            node.key = min.key;
            node.right = removeR(node.right, node.key);
        }
        return node;
    }

    private BinaryNode<Key, Value> getMinimum(BinaryNode<Key, Value> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public List<TupleV<Key, Value>> toList() {
        if (root == null) return null;
        List<TupleV<Key, Value>> lista = new ArrayList<>();
        toListR(this.root, lista);
        return lista;
    }

    private void toListR(BinaryNode<Key, Value> node, List<TupleV<Key, Value>> list) {
        if (node == null) return;

        toListR(node.left, list);
        list.add(new TupleV<>(node.key, node.value));
        toListR(node.right, list);
    }

    public List<TupleV<Key, Value>> leavesRec() {
        if (root == null) return null;
        List<TupleV<Key, Value>> lista = new ArrayList<>();
        leavesRecR(this.root, lista);
        return lista;
    }

    private void leavesRecR(BinaryNode<Key, Value> node, List<TupleV<Key, Value>> list) {
        if (node == null) return;

        leavesRecR(node.left, list);
        if (node.left == null && node.right == null) {
            TupleV<Key, Value> t = new TupleV<>(node.key, node.value);
            list.add(t);
        }
        leavesRecR(node.right, list);
    }

    public List<TupleV<Key, Value>> leavesIter() {
        if (root == null) return null;
        List<TupleV<Key, Value>> lista = new ArrayList<>();
        leavesIterI(this.root, lista);
        return lista;
    }

    private void leavesIterI(BinaryNode<Key, Value> node, List<TupleV<Key, Value>> list) {
        if(node == null) return;

        Queue<BinaryNode<Key, Value>> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            BinaryNode<Key, Value> n = q.remove();

            if (n.left == null && n.right == null)
                list.add(new TupleV<>(n.key, n.value));
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    /* TIPO 1 */
    public Key getFloor(Key k) {
        if (this.root == null) return null;
        Key key = null;
        getFloorR(this.root, key, k);
        return key;
    }

    private void getFloorR(BinaryNode<Key, Value> node, Key key, Key k) {
        if (node == null) return;

        getFloorR(node.left, key, k);
        int cmp = keyComparator.compare(node.key, k);
        if (cmp < 0 || cmp == 0) {
            int cmpK = keyComparator.compare(key, node.key);
            if (cmpK < 0) {
                System.out.println("CAMBIANDO");
                key = node.key;
            }
        }
        getFloorR(node.right, key, k);

    }

    private static class BinaryNode<Key, Value> {
		Key key;
		Value value;
        BinaryNode<Key, Value> left;
        BinaryNode<Key, Value> right;
        BinaryNode<Key, Value> parent;

        BinaryNode(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        Value insert(Key key, Value value, Comparator<? super Key> keyComp, BinaryNode<Key, Value> node) {
            int cmp = keyComp.compare(key, this.key);
            if (cmp == 0) {
                Value old = this.value;
                this.value = value;
                return old;
            } else if (cmp < 0) {
                if (left == null) {
                    left = new BinaryNode<>(key, value);
                    left.parent = node;
                    return null;
                } else {
                    return left.insert(key, value, keyComp, left);
                }
            } else {
                if (right == null) {
                    right = new BinaryNode<>(key, value);
                    right.parent = node;
                    return null;
                } else {
                    return right.insert(key, value, keyComp, right);
                }
            }
        }
	}
}
