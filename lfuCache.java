import java.util.*;

class LFUCache {
    private final int capacity;
    private int minFreq;
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        // Eviction
        if (keyToVal.size() >= capacity) {
            evictLFU();
        }

       
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, z -> new LinkedHashSet<>()).add(key);
        minFreq = 1; 
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) minFreq++;
        }

        // Add to new freq list
        freqToKeys.computeIfAbsent(freq + 1, z -> new LinkedHashSet<>()).add(key);
    }

    private void evictLFU() {
        LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(minFreq);
        int evictKey = minFreqKeys.iterator().next();
        minFreqKeys.remove(evictKey);
        if (minFreqKeys.isEmpty()) {
            freqToKeys.remove(minFreq);
        }

        keyToVal.remove(evictKey);
        keyToFreq.remove(evictKey);
    }
}
