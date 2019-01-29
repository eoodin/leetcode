package eoodin.property;

import java.util.*;

public class MyProperties extends Properties {
    private transient HashMap<Object, Object> map = new HashMap<>();

    public String getProperty(String key) {
        Object oval = this.map.get(key);
        String sval = oval instanceof String ? (String) oval : null;
        return sval == null && this.defaults != null ? this.defaults.getProperty(key) : sval;
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Enumeration<Object> keys() {
        return Collections.enumeration(this.map.keySet());
    }

    public Enumeration<Object> elements() {
        return Collections.enumeration(this.map.values());
    }

    public boolean contains(Object value) {
        return this.map.containsValue(value);
    }

    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    public Object get(Object key) {
        return this.map.get(key);
    }

    public synchronized Object put(Object key, Object value) {
        return this.map.put(key, value);
    }

    public synchronized Object remove(Object key) {
        return this.map.remove(key);
    }

    public synchronized void putAll(Map<?, ?> t) {
        this.map.putAll(t);
    }

    public synchronized void clear() {
        this.map.clear();
    }

    public synchronized String toString() {
        return this.map.toString();
    }

    public Set<Object> keySet() {
        return this.map.keySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.map.entrySet();
    }

    public synchronized boolean equals(Object o) {
        return this.map.equals(o);
    }

    public synchronized int hashCode() {
        return this.map.hashCode();
    }
}
