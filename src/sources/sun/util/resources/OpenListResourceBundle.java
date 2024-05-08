package sun.util.resources;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import sun.util.ResourceBundleEnumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class OpenListResourceBundle extends ResourceBundle {
    private volatile Set<String> keyset;
    private volatile Map<String, Object> lookup;

    protected abstract Object[][] getContents();

    protected OpenListResourceBundle() {
    }

    @Override // java.util.ResourceBundle
    protected Object handleGetObject(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        loadLookupTablesIfNecessary();
        return this.lookup.get(key);
    }

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        ResourceBundle parentBundle = this.parent;
        return new ResourceBundleEnumeration(handleKeySet(), parentBundle != null ? parentBundle.getKeys() : null);
    }

    @Override // java.util.ResourceBundle
    protected Set<String> handleKeySet() {
        loadLookupTablesIfNecessary();
        return this.lookup.h();
    }

    @Override // java.util.ResourceBundle
    public Set<String> keySet() {
        if (this.keyset != null) {
            return this.keyset;
        }
        Set<String> ks = createSet();
        ks.addAll(handleKeySet());
        if (this.parent != null) {
            ks.addAll(this.parent.keySet());
        }
        synchronized (this) {
            if (this.keyset == null) {
                this.keyset = ks;
            }
        }
        return this.keyset;
    }

    void loadLookupTablesIfNecessary() {
        if (this.lookup == null) {
            loadLookup();
        }
    }

    private void loadLookup() {
        Object[][] contents = getContents();
        Map<String, Object> temp = createMap(contents.length);
        for (int i10 = 0; i10 < contents.length; i10++) {
            String key = (String) contents[i10][0];
            Object value = contents[i10][1];
            if (key == null || value == null) {
                throw new NullPointerException();
            }
            temp.put(key, value);
        }
        synchronized (this) {
            if (this.lookup == null) {
                this.lookup = temp;
            }
        }
    }

    protected <K, V> Map<K, V> createMap(int size) {
        return new HashMap(size);
    }

    protected <E> Set<E> createSet() {
        return new HashSet();
    }
}
