package java.lang;

import java.lang.ThreadLocal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InheritableThreadLocal<T> extends ThreadLocal<T> {
    @Override // java.lang.ThreadLocal
    protected T childValue(T parentValue) {
        return parentValue;
    }

    @Override // java.lang.ThreadLocal
    ThreadLocal.ThreadLocalMap getMap(Thread t2) {
        return t2.inheritableThreadLocals;
    }

    @Override // java.lang.ThreadLocal
    void createMap(Thread t2, T firstValue) {
        t2.inheritableThreadLocals = new ThreadLocal.ThreadLocalMap(this, firstValue);
    }
}
