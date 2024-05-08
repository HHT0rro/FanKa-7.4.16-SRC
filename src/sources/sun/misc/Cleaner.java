package sun.misc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Cleaner extends PhantomReference<Object> {
    private static final ReferenceQueue<Object> dummyQueue = new ReferenceQueue<>();
    private static Cleaner first = null;
    private Cleaner next;
    private Cleaner prev;
    private final Runnable thunk;

    private static synchronized Cleaner add(Cleaner cl) {
        synchronized (Cleaner.class) {
            Cleaner cleaner = first;
            if (cleaner != null) {
                cl.next = cleaner;
                cleaner.prev = cl;
            }
            first = cl;
        }
        return cl;
    }

    private static synchronized boolean remove(Cleaner cl) {
        synchronized (Cleaner.class) {
            Cleaner cleaner = cl.next;
            if (cleaner == cl) {
                return false;
            }
            if (first == cl) {
                if (cleaner != null) {
                    first = cleaner;
                } else {
                    first = cl.prev;
                }
            }
            if (cleaner != null) {
                cleaner.prev = cl.prev;
            }
            Cleaner cleaner2 = cl.prev;
            if (cleaner2 != null) {
                cleaner2.next = cleaner;
            }
            cl.next = cl;
            cl.prev = cl;
            return true;
        }
    }

    private Cleaner(Object referent, Runnable thunk) {
        super(referent, dummyQueue);
        this.next = null;
        this.prev = null;
        this.thunk = thunk;
    }

    public static boolean isCleanerQueue(ReferenceQueue q10) {
        return q10 == dummyQueue;
    }

    public Runnable getThunk() {
        return this.thunk;
    }

    public static Cleaner create(Object ob2, Runnable thunk) {
        if (thunk == null) {
            return null;
        }
        return add(new Cleaner(ob2, thunk));
    }

    public void clean() {
        if (!remove(this)) {
            return;
        }
        try {
            this.thunk.run();
        } catch (Throwable x10) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: sun.misc.Cleaner.1
                @Override // java.security.PrivilegedAction
                public Void run() {
                    if (System.err != null) {
                        new Error("Cleaner terminated abnormally", x10).printStackTrace();
                    }
                    System.exit(1);
                    return null;
                }
            });
        }
    }
}
