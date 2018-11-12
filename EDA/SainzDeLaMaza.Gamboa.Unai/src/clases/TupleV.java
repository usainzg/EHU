package clases;

public class TupleV<Key, Value> {
    private Key key;
    private Value value;

    public TupleV(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
