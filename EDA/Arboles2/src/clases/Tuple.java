package clases;

public class Tuple<Key> {
    private Key minKey;
    private Key maxKey;

    public Tuple(Key minKey, Key maxKey) {
        this.minKey = minKey;
        this.maxKey = maxKey;
    }

    public Key getMinKey() {
        return minKey;
    }

    public void setMinKey(Key minKey) {
        this.minKey = minKey;
    }

    public Key getMaxKey() {
        return maxKey;
    }

    public void setMaxKey(Key maxKey) {
        this.maxKey = maxKey;
    }
}
