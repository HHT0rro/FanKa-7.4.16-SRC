package jdk.internal.misc;

import java.lang.Thread;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class InnocuousThread extends Thread {
    private static final AccessControlContext ACC;
    private static final long CONTEXTCLASSLOADER;
    private static final long INHERITABLE_THREAD_LOCALS;
    private static final long INHERITEDACCESSCONTROLCONTEXT;
    private static final ThreadGroup INNOCUOUSTHREADGROUP;
    private static final long THREAD_LOCALS;
    private static final Unsafe UNSAFE;
    private static final AtomicInteger threadNumber = new AtomicInteger(1);
    private volatile boolean hasRun;

    static {
        try {
            ACC = new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, null)});
            Unsafe unsafe = Unsafe.getUnsafe();
            UNSAFE = unsafe;
            THREAD_LOCALS = unsafe.objectFieldOffset(Thread.class, "threadLocals");
            INHERITABLE_THREAD_LOCALS = unsafe.objectFieldOffset(Thread.class, "inheritableThreadLocals");
            INHERITEDACCESSCONTROLCONTEXT = unsafe.objectFieldOffset(Thread.class, "inheritedAccessControlContext");
            CONTEXTCLASSLOADER = unsafe.objectFieldOffset(Thread.class, "contextClassLoader");
            long tg = unsafe.objectFieldOffset(Thread.class, "group");
            long gp = unsafe.objectFieldOffset(ThreadGroup.class, "parent");
            ThreadGroup group = (ThreadGroup) unsafe.getReference(Thread.currentThread(), tg);
            while (group != null) {
                ThreadGroup parent = (ThreadGroup) UNSAFE.getReference(group, gp);
                if (parent == null) {
                    break;
                } else {
                    group = parent;
                }
            }
            final ThreadGroup root = group;
            INNOCUOUSTHREADGROUP = (ThreadGroup) AccessController.doPrivileged(new PrivilegedAction<ThreadGroup>() { // from class: jdk.internal.misc.InnocuousThread.3
                @Override // java.security.PrivilegedAction
                public ThreadGroup run() {
                    return new ThreadGroup(ThreadGroup.this, "InnocuousThreadGroup");
                }
            });
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    private static String newName() {
        return "InnocuousThread-" + threadNumber.getAndIncrement();
    }

    public static Thread newThread(Runnable target) {
        return newThread(newName(), target);
    }

    public static Thread newThread(final String name, final Runnable target) {
        return (Thread) AccessController.doPrivileged(new PrivilegedAction<Thread>() { // from class: jdk.internal.misc.InnocuousThread.1
            @Override // java.security.PrivilegedAction
            public Thread run() {
                return new InnocuousThread(InnocuousThread.INNOCUOUSTHREADGROUP, Runnable.this, name, ClassLoader.getSystemClassLoader());
            }
        });
    }

    public static Thread newSystemThread(Runnable target) {
        return newSystemThread(newName(), target);
    }

    public static Thread newSystemThread(final String name, final Runnable target) {
        return (Thread) AccessController.doPrivileged(new PrivilegedAction<Thread>() { // from class: jdk.internal.misc.InnocuousThread.2
            @Override // java.security.PrivilegedAction
            public Thread run() {
                return new InnocuousThread(InnocuousThread.INNOCUOUSTHREADGROUP, Runnable.this, name, null);
            }
        });
    }

    private InnocuousThread(ThreadGroup group, Runnable target, String name, ClassLoader tccl) {
        super(group, target, name, 0L, false);
        Unsafe unsafe = UNSAFE;
        unsafe.putReferenceRelease(this, INHERITEDACCESSCONTROLCONTEXT, ACC);
        unsafe.putReferenceRelease(this, CONTEXTCLASSLOADER, tccl);
    }

    @Override // java.lang.Thread
    public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler x10) {
    }

    @Override // java.lang.Thread
    public void setContextClassLoader(ClassLoader cl) {
        if (cl == null) {
            super.setContextClassLoader(null);
            return;
        }
        throw new SecurityException("setContextClassLoader");
    }

    public final void eraseThreadLocals() {
        Unsafe unsafe = UNSAFE;
        unsafe.putReference(this, THREAD_LOCALS, null);
        unsafe.putReference(this, INHERITABLE_THREAD_LOCALS, null);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (Thread.currentThread() == this && !this.hasRun) {
            this.hasRun = true;
            super.run();
        }
    }
}
