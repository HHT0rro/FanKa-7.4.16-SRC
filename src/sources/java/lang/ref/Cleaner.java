package java.lang.ref;

import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.function.Function;
import jdk.internal.ref.CleanerImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Cleaner {
    final CleanerImpl impl;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Cleanable {
        void clean();
    }

    static {
        CleanerImpl.setCleanerImplAccess(new Function<Cleaner, CleanerImpl>() { // from class: java.lang.ref.Cleaner.1
            @Override // java.util.function.Function
            public CleanerImpl apply(Cleaner cleaner) {
                return cleaner.impl;
            }
        });
    }

    private Cleaner() {
        this.impl = new CleanerImpl();
    }

    private Cleaner(ReferenceQueue queue) {
        this.impl = new CleanerImpl(queue);
    }

    public static Cleaner create() {
        Cleaner cleaner = new Cleaner();
        cleaner.impl.start(cleaner, null);
        return cleaner;
    }

    public static Cleaner create(ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory");
        Cleaner cleaner = new Cleaner();
        cleaner.impl.start(cleaner, threadFactory);
        return cleaner;
    }

    public static Cleaner createSystemCleaner() {
        Cleaner cleaner = new Cleaner(FinalizerReference.queue);
        cleaner.impl.start(cleaner);
        return cleaner;
    }

    public Cleanable register(Object obj, Runnable action) {
        Objects.requireNonNull(obj, IconCompat.EXTRA_OBJ);
        Objects.requireNonNull(action, "action");
        return new CleanerImpl.PhantomCleanableRef(obj, this, action);
    }
}
