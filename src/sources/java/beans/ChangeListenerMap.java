package java.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ChangeListenerMap<L extends EventListener> {
    private Map<String, L[]> map;

    public abstract L extract(L l10);

    protected abstract L[] newArray(int i10);

    protected abstract L newProxy(String str, L l10);

    public final synchronized void add(String name, L listener) {
        int size;
        if (this.map == null) {
            this.map = new HashMap();
        }
        L[] array = this.map.get(name);
        if (array != null) {
            size = array.length;
        } else {
            size = 0;
        }
        L[] clone = newArray(size + 1);
        clone[size] = listener;
        if (array != null) {
            System.arraycopy(array, 0, clone, 0, size);
        }
        this.map.put(name, clone);
    }

    public final synchronized void remove(String name, L listener) {
        L[] array;
        Map<String, L[]> map = this.map;
        if (map != null && (array = map.get(name)) != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= array.length) {
                    break;
                }
                if (!listener.equals(array[i10])) {
                    i10++;
                } else {
                    int size = array.length - 1;
                    if (size > 0) {
                        L[] clone = newArray(size);
                        System.arraycopy(array, 0, clone, 0, i10);
                        System.arraycopy(array, i10 + 1, clone, i10, size - i10);
                        this.map.put(name, clone);
                    } else {
                        this.map.remove(name);
                        if (this.map.isEmpty()) {
                            this.map = null;
                        }
                    }
                }
            }
        }
    }

    public final synchronized L[] get(String name) {
        L[] lArr;
        Map<String, L[]> map = this.map;
        if (map != null) {
            lArr = map.get(name);
        } else {
            lArr = null;
        }
        return lArr;
    }

    public final void set(String name, L[] listeners) {
        if (listeners != null) {
            if (this.map == null) {
                this.map = new HashMap();
            }
            this.map.put(name, listeners);
            return;
        }
        Map<String, L[]> map = this.map;
        if (map != null) {
            map.remove(name);
            if (this.map.isEmpty()) {
                this.map = null;
            }
        }
    }

    public final synchronized L[] getListeners() {
        if (this.map == null) {
            return newArray(0);
        }
        ArrayList arrayList = new ArrayList();
        L[] lArr = this.map.get(null);
        if (lArr != null) {
            for (L l10 : lArr) {
                arrayList.add(l10);
            }
        }
        for (Map.Entry<String, L[]> entry : this.map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                for (L l11 : entry.getValue()) {
                    arrayList.add(newProxy(key, l11));
                }
            }
        }
        return (L[]) ((EventListener[]) arrayList.toArray(newArray(arrayList.size())));
    }

    public final L[] getListeners(String str) {
        L[] lArr;
        if (str != null && (lArr = get(str)) != null) {
            return (L[]) ((EventListener[]) lArr.clone());
        }
        return newArray(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0019, code lost:
    
        if (r3.map.get(r4) != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean hasListeners(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.String, L extends java.util.EventListener[]> r0 = r3.map     // Catch: java.lang.Throwable -> L1e
            r1 = 0
            if (r0 != 0) goto L8
            monitor-exit(r3)
            return r1
        L8:
            r2 = 0
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L1e
            java.util.EventListener[] r0 = (java.util.EventListener[]) r0     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L1b
            if (r4 == 0) goto L1c
            java.util.Map<java.lang.String, L extends java.util.EventListener[]> r2 = r3.map     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L1e
            if (r2 == 0) goto L1c
        L1b:
            r1 = 1
        L1c:
            monitor-exit(r3)
            return r1
        L1e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.beans.ChangeListenerMap.hasListeners(java.lang.String):boolean");
    }

    public final Set<Map.Entry<String, L[]>> getEntries() {
        Map<String, L[]> map = this.map;
        if (map != null) {
            return map.entrySet();
        }
        return Collections.emptySet();
    }
}
