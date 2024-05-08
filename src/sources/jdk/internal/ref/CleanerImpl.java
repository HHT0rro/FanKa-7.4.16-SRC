package jdk.internal.ref;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.ref.Cleaner;
import java.lang.ref.ReferenceQueue;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import jdk.internal.misc.InnocuousThread;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class CleanerImpl implements Runnable {
    private static Function<java.lang.ref.Cleaner, CleanerImpl> cleanerImplAccess = null;
    final PhantomCleanable<?> phantomCleanableList;
    final ReferenceQueue<Object> queue;

    public static void setCleanerImplAccess(Function<java.lang.ref.Cleaner, CleanerImpl> access) {
        if (cleanerImplAccess == null) {
            cleanerImplAccess = access;
            return;
        }
        throw new InternalError("cleanerImplAccess");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CleanerImpl getCleanerImpl(java.lang.ref.Cleaner cleaner) {
        return cleanerImplAccess.apply(cleaner);
    }

    public CleanerImpl() {
        this.queue = new ReferenceQueue<>();
        this.phantomCleanableList = new PhantomCleanableRef();
    }

    public CleanerImpl(ReferenceQueue<Object> queue) {
        this.queue = queue;
        this.phantomCleanableList = new PhantomCleanableRef();
    }

    public void start(java.lang.ref.Cleaner cleaner, ThreadFactory threadFactory) {
        if (getCleanerImpl(cleaner) != this) {
            throw new AssertionError((Object) "wrong cleaner");
        }
        new CleanerCleanable(cleaner);
        if (threadFactory == null) {
            threadFactory = InnocuousThreadFactory.factory();
        }
        Thread thread = threadFactory.newThread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public void start(java.lang.ref.Cleaner cleaner) {
        if (getCleanerImpl(cleaner) != this) {
            throw new AssertionError((Object) "wrong cleaner");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        InnocuousThread mlThread;
        Thread t2 = Thread.currentThread();
        if (t2 instanceof InnocuousThread) {
            mlThread = (InnocuousThread) t2;
        } else {
            mlThread = null;
        }
        while (!this.phantomCleanableList.isListEmpty()) {
            if (mlThread != null) {
                mlThread.eraseThreadLocals();
            }
            try {
                Cleaner.Cleanable ref = (Cleaner.Cleanable) this.queue.remove(60000L);
                if (ref != null) {
                    ref.clean();
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class PhantomCleanableRef extends PhantomCleanable<Object> {
        private final Runnable action;

        public PhantomCleanableRef(Object obj, java.lang.ref.Cleaner cleaner, Runnable action) {
            super(obj, cleaner);
            this.action = action;
        }

        PhantomCleanableRef() {
            this.action = null;
        }

        @Override // jdk.internal.ref.PhantomCleanable
        protected void performCleanup() {
            this.action.run();
        }

        @Override // java.lang.ref.PhantomReference, java.lang.ref.Reference
        public Object get() {
            throw new UnsupportedOperationException(MonitorConstants.CONNECT_TYPE_GET);
        }

        @Override // jdk.internal.ref.PhantomCleanable, java.lang.ref.Reference
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class InnocuousThreadFactory implements ThreadFactory {
        static final ThreadFactory factory = new InnocuousThreadFactory();
        final AtomicInteger cleanerThreadNumber = new AtomicInteger();

        InnocuousThreadFactory() {
        }

        static ThreadFactory factory() {
            return factory;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r10) {
            return (Thread) AccessController.doPrivileged(new PrivilegedAction<Thread>() { // from class: jdk.internal.ref.CleanerImpl.InnocuousThreadFactory.1
                @Override // java.security.PrivilegedAction
                public Thread run() {
                    Thread t2 = InnocuousThread.newThread(r10);
                    t2.setPriority(8);
                    t2.setName("Cleaner-" + InnocuousThreadFactory.this.cleanerThreadNumber.getAndIncrement());
                    return t2;
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class CleanerCleanable extends PhantomCleanable<java.lang.ref.Cleaner> {
        CleanerCleanable(java.lang.ref.Cleaner cleaner) {
            super(cleaner, cleaner);
        }

        @Override // jdk.internal.ref.PhantomCleanable
        protected void performCleanup() {
        }
    }
}
