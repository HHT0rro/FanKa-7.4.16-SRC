package jdk.internal.misc;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TerminatingThreadLocal<T> extends ThreadLocal<T> {
    public static final ThreadLocal<Collection<TerminatingThreadLocal<?>>> REGISTRY = new ThreadLocal<Collection<TerminatingThreadLocal<?>>>() { // from class: jdk.internal.misc.TerminatingThreadLocal.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Collection<TerminatingThreadLocal<?>> initialValue() {
            return Collections.newSetFromMap(new IdentityHashMap(4));
        }
    };

    @Override // java.lang.ThreadLocal
    public void set(T value) {
        super.set(value);
        register(this);
    }

    @Override // java.lang.ThreadLocal
    public void remove() {
        super.remove();
        unregister(this);
    }

    protected void threadTerminated(T value) {
    }

    public static void threadTerminated() {
        for (TerminatingThreadLocal<?> ttl : REGISTRY.get()) {
            ttl._threadTerminated();
        }
    }

    private void _threadTerminated() {
        threadTerminated(get());
    }

    public static void register(TerminatingThreadLocal<?> tl) {
        REGISTRY.get().add(tl);
    }

    private static void unregister(TerminatingThreadLocal<?> tl) {
        REGISTRY.get().remove(tl);
    }
}
