package java.lang;

import dalvik.annotation.optimization.FastNative;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Object {
    private transient Class<?> shadow$_klass_;
    private transient int shadow$_monitor_;

    @FastNative
    private static native int identityHashCodeNative(Object obj);

    @FastNative
    private native Object internalClone();

    @FastNative
    public final native void notify();

    @FastNative
    public final native void notifyAll();

    @FastNative
    public final native void wait(long j10, int i10) throws InterruptedException;

    public final Class<?> getClass() {
        return this.shadow$_klass_;
    }

    public int hashCode() {
        return identityHashCode(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int identityHashCode(Object obj) {
        int lockWord = obj.shadow$_monitor_;
        if (((-1073741824) & lockWord) == Integer.MIN_VALUE) {
            return 268435455 & lockWord;
        }
        return identityHashCodeNative(obj);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        if (!(this instanceof Cloneable)) {
            throw new CloneNotSupportedException("Class " + getClass().getName() + " doesn't implement Cloneable");
        }
        return internalClone();
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public final void wait(long timeoutMillis) throws InterruptedException {
        wait(timeoutMillis, 0);
    }

    public final void wait() throws InterruptedException {
        wait(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
    }
}
