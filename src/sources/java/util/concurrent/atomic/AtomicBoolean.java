package java.util.concurrent.atomic;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AtomicBoolean implements Serializable {
    private static final VarHandle VALUE;
    private static final long serialVersionUID = 4654671469794556979L;
    private volatile int value;

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            VALUE = l10.findVarHandle(AtomicBoolean.class, "value", Integer.TYPE);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public AtomicBoolean(boolean initialValue) {
        if (initialValue) {
            this.value = 1;
        }
    }

    public AtomicBoolean() {
    }

    public final boolean get() {
        return this.value != 0;
    }

    public final boolean compareAndSet(boolean z10, boolean z11) {
        return (boolean) VALUE.compareAndSet(this, z10 ? 1 : 0, z11 ? 1 : 0);
    }

    @Deprecated(since = "9")
    public boolean weakCompareAndSet(boolean z10, boolean z11) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, z10 ? 1 : 0, z11 ? 1 : 0);
    }

    public boolean weakCompareAndSetPlain(boolean z10, boolean z11) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, z10 ? 1 : 0, z11 ? 1 : 0);
    }

    public final void set(boolean z10) {
        this.value = z10 ? 1 : 0;
    }

    public final void lazySet(boolean z10) {
        (void) VALUE.setRelease(this, z10 ? 1 : 0);
    }

    public final boolean getAndSet(boolean z10) {
        return (int) VALUE.getAndSet(this, z10 ? 1 : 0) != 0;
    }

    public String toString() {
        return Boolean.toString(get());
    }

    public final boolean getPlain() {
        return (int) VALUE.get(this) != 0;
    }

    public final void setPlain(boolean z10) {
        (void) VALUE.set(this, z10 ? 1 : 0);
    }

    public final boolean getOpaque() {
        return (int) VALUE.getOpaque(this) != 0;
    }

    public final void setOpaque(boolean z10) {
        (void) VALUE.setOpaque(this, z10 ? 1 : 0);
    }

    public final boolean getAcquire() {
        return (int) VALUE.getAcquire(this) != 0;
    }

    public final void setRelease(boolean z10) {
        (void) VALUE.setRelease(this, z10 ? 1 : 0);
    }

    public final boolean compareAndExchange(boolean z10, boolean z11) {
        return (int) VALUE.compareAndExchange(this, z10 ? 1 : 0, z11 ? 1 : 0) != 0;
    }

    public final boolean compareAndExchangeAcquire(boolean z10, boolean z11) {
        return (int) VALUE.compareAndExchangeAcquire(this, z10 ? 1 : 0, z11 ? 1 : 0) != 0;
    }

    public final boolean compareAndExchangeRelease(boolean z10, boolean z11) {
        return (int) VALUE.compareAndExchangeRelease(this, z10 ? 1 : 0, z11 ? 1 : 0) != 0;
    }

    public final boolean weakCompareAndSetVolatile(boolean z10, boolean z11) {
        return (boolean) VALUE.weakCompareAndSet(this, z10 ? 1 : 0, z11 ? 1 : 0);
    }

    public final boolean weakCompareAndSetAcquire(boolean z10, boolean z11) {
        return (boolean) VALUE.weakCompareAndSetAcquire(this, z10 ? 1 : 0, z11 ? 1 : 0);
    }

    public final boolean weakCompareAndSetRelease(boolean z10, boolean z11) {
        return (boolean) VALUE.weakCompareAndSetRelease(this, z10 ? 1 : 0, z11 ? 1 : 0);
    }
}
