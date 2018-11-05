package clases;

public class Tuple<Key> {
    private Key keyKey;
    private Key valueKey;

    public Tuple(Key keyKey, Key valueKey) {
        this.keyKey = keyKey;
        this.valueKey = valueKey;
    }

    public Key getKeyKey() {
        return keyKey;
    }

    public void setKeyKey(Key keyKey) {
        this.keyKey = keyKey;
    }

    public Key getValueKey() {
        return valueKey;
    }

    public void setValueKey(Key valueKey) {
        this.valueKey = valueKey;
    }
}
