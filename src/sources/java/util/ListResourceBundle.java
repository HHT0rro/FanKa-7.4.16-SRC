package java.util;

import sun.util.ResourceBundleEnumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ListResourceBundle extends ResourceBundle {
    private volatile Map<String, Object> lookup;

    protected abstract Object[][] getContents();

    @Override // java.util.ResourceBundle
    public final Object handleGetObject(String key) {
        if (this.lookup == null) {
            loadLookup();
        }
        if (key == null) {
            throw new NullPointerException();
        }
        return this.lookup.get(key);
    }

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        if (this.lookup == null) {
            loadLookup();
        }
        ResourceBundle parent = this.parent;
        return new ResourceBundleEnumeration(this.lookup.keySet(), parent != null ? parent.getKeys() : null);
    }

    @Override // java.util.ResourceBundle
    protected Set<String> handleKeySet() {
        if (this.lookup == null) {
            loadLookup();
        }
        return this.lookup.keySet();
    }

    private synchronized void loadLookup() {
        if (this.lookup != null) {
            return;
        }
        Object[][] contents = getContents();
        HashMap<String, Object> temp = new HashMap<>(contents.length);
        for (Object[] content : contents) {
            String key = (String) content[0];
            Object value = content[1];
            if (key == null || value == null) {
                throw new NullPointerException();
            }
            temp.put(key, value);
        }
        this.lookup = temp;
    }
}
