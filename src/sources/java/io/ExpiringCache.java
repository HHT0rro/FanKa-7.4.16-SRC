package java.io;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ExpiringCache {
    private int MAX_ENTRIES;
    private Map<String, Entry> map;
    private long millisUntilExpiration;
    private int queryCount;
    private int queryOverflow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Entry {
        private long timestamp;
        private String val;

        Entry(long timestamp, String val) {
            this.timestamp = timestamp;
            this.val = val;
        }

        long timestamp() {
            return this.timestamp;
        }

        void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        String val() {
            return this.val;
        }

        void setVal(String val) {
            this.val = val;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpiringCache() {
        this(30000L);
    }

    ExpiringCache(long millisUntilExpiration) {
        this.queryOverflow = 300;
        this.MAX_ENTRIES = 200;
        this.millisUntilExpiration = millisUntilExpiration;
        this.map = new LinkedHashMap<String, Entry>() { // from class: java.io.ExpiringCache.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, Entry> eldest) {
                return size() > ExpiringCache.this.MAX_ENTRIES;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String get(String key) {
        int i10 = this.queryCount + 1;
        this.queryCount = i10;
        if (i10 >= this.queryOverflow) {
            cleanup();
        }
        Entry entry = entryFor(key);
        if (entry == null) {
            return null;
        }
        return entry.val();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void put(String key, String val) {
        int i10 = this.queryCount + 1;
        this.queryCount = i10;
        if (i10 >= this.queryOverflow) {
            cleanup();
        }
        Entry entry = entryFor(key);
        if (entry != null) {
            entry.setTimestamp(System.currentTimeMillis());
            entry.setVal(val);
        } else {
            this.map.put(key, new Entry(System.currentTimeMillis(), val));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void clear() {
        this.map.clear();
    }

    private Entry entryFor(String key) {
        Entry entry = this.map.get(key);
        if (entry != null) {
            long delta = System.currentTimeMillis() - entry.timestamp();
            if (delta < 0 || delta >= this.millisUntilExpiration) {
                this.map.remove(key);
                return null;
            }
            return entry;
        }
        return entry;
    }

    private void cleanup() {
        Set<String> keySet = this.map.h();
        String[] keys = new String[keySet.size()];
        int i10 = 0;
        for (String key : keySet) {
            keys[i10] = key;
            i10++;
        }
        for (String str : keys) {
            entryFor(str);
        }
        this.queryCount = 0;
    }
}
