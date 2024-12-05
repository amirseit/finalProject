package ast;

import java.util.HashMap;
import java.util.Map;

public class Heap {
    private Map<Integer, Object> storage;
    private int nextAddress;

    public Heap() {
        this.storage = new HashMap<>();
        this.nextAddress = 3;  // Start at 3 because 0, 1, 2 are reserved
        preAllocate();         // Call this method to pre-allocate True, False, None
    }

    private void preAllocate() { //OPTIMIZATION
        storage.put(0, Boolean.TRUE);
        storage.put(1, Boolean.FALSE);
        storage.put(2, null);  // Using null to represent "None"
    }

    public int allocate(Object value) {
        int address = nextAddress++;
        storage.put(address, value);
        return address;
    }

    public Object retrieve(int address) {
        return storage.get(address);
    }

    public void update(int address, Object value) {
        if (address < 3) {
            throw new IllegalStateException("Attempted to modify a protected address.");
        }
        storage.put(address, value);
    }

    public Map<Integer, Object> getAllValues() {
        return new HashMap<>(storage);
    }
}

