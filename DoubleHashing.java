public class LinearProbing<T> implements HashTable<T> {

    private String[] keys;
    private T[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public LinearProbing(int capacity) {
        keys = new String[capacity];
        values = (T[]) new Object[capacity];
        size = capacity;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    @Override
    public void insert(String key, T value) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            i = (i + 1) % size;
        }
        keys[i] = key;
        values[i] = value;
    }

    @Override
    public T search(String key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
            i = (i + 1) % size;
        }
        return null;
    }

    @Override
    public void delete(String key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                values[i] = null;
                return;
            }
            i = (i + 1) % size;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ");
            if (keys[i] != null) {
                sb.append(keys[i]).append(" -> ").append(values[i]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
