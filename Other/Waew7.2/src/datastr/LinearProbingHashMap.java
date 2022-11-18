package datastr;

public class LinearProbingHashMap implements Map {
    private static class Entry {
        Object key, value;

        Entry(Object k, Object v) {
            key = k;
            value = v;
        }
    }

    private Entry[] table;
    private int size;

    public LinearProbingHashMap(int m) {
        table = new Entry[m];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        return table[indexOf(key)] != null;
    }

    private int indexOf(Object key) {
        int h = h(key);
        for (int j = 0; j < table.length; j++) {
            if (table[h] == null) return h;
            if (table[h].key.equals(key)) return h;
            h = (h + 1) % table.length;
        }
        throw new AssertionError("􀑈􀑥􀑖􀑥􀐺􀑯􀑈􀑶􀑔􀑳􀑇􀑳􀒖 􀐺􀀃!");
    }

    private int h(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % table.length;
    }

    public Object get(Object key) {
        Entry e = table[indexOf(key)];
        return e == null ? null : e.value;
    }

    public Object put(Object key, Object value) {
        Object oldValue = null;
        int i = indexOf(key);
        if (table[i] == null) {
            table[i] = new Entry(key, value);
            ++size;
            if (size > table.length / 2) rehash();
        } else {
            oldValue = table[i].value;
            table[i].value = value;
        }
        return oldValue;
    }

    private void rehash() {
        Entry[] oldT = table;
        table = new Entry[2 * table.length];
        for (int i = 0; i < oldT.length; i++) {
            if (oldT[i] != null) table[indexOf(oldT[i].key)] = oldT[i];
        }
    }

    public void remove(Object key) {
        int i = indexOf(key);
        if (table[i] != null) {
            table[i] = null;
            --size;
            for (++i; table[i] != null; i = (i + 1) % table.length) {
                Entry e = table[i];
                table[i] = null;
                table[indexOf(e.key)] = e;
            }
        }
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < table.length; i++){
            if(table[i] != null){
                str = str + "[" + i + "]  =>  ";
                str = str + table[i].key.toString() + " : " + table[i].value + "\n";
            }
            else {
                str = str + "[" + i + "]  =>  null" + "\n";
            }
        }
        return str;
    }
}