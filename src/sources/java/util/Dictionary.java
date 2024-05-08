package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Dictionary<K, V> {
    public abstract Enumeration<V> elements();

    public abstract V get(Object obj);

    public abstract boolean isEmpty();

    public abstract Enumeration<K> keys();

    public abstract V put(K k10, V v2);

    public abstract V remove(Object obj);

    public abstract int size();
}
