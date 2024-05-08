package java.lang;

import java.io.PrintStream;
import java.lang.Thread;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ThreadGroup implements Thread.UncaughtExceptionHandler {
    static final ThreadGroup mainThreadGroup;
    static final ThreadGroup systemThreadGroup;
    boolean daemon;
    boolean destroyed;
    ThreadGroup[] groups;
    int maxPriority;
    int nUnstartedThreads;
    String name;
    int ngroups;
    int nthreads;
    private final ThreadGroup parent;
    Thread[] threads;

    static {
        ThreadGroup threadGroup = new ThreadGroup();
        systemThreadGroup = threadGroup;
        mainThreadGroup = new ThreadGroup(threadGroup, "main");
    }

    private ThreadGroup() {
        this.nUnstartedThreads = 0;
        this.name = "system";
        this.maxPriority = 10;
        this.parent = null;
    }

    public ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
    }

    public ThreadGroup(ThreadGroup parent, String name) {
        this(checkParentAccess(parent), parent, name);
    }

    private ThreadGroup(Void unused, ThreadGroup parent, String name) {
        this.nUnstartedThreads = 0;
        this.name = name;
        this.maxPriority = parent.maxPriority;
        this.daemon = parent.daemon;
        this.parent = parent;
        parent.add(this);
    }

    private static Void checkParentAccess(ThreadGroup parent) {
        parent.checkAccess();
        return null;
    }

    public final String getName() {
        return this.name;
    }

    public final ThreadGroup getParent() {
        ThreadGroup threadGroup = this.parent;
        if (threadGroup != null) {
            threadGroup.checkAccess();
        }
        return this.parent;
    }

    public final int getMaxPriority() {
        return this.maxPriority;
    }

    public final boolean isDaemon() {
        return this.daemon;
    }

    public synchronized boolean isDestroyed() {
        return this.destroyed;
    }

    public final void setDaemon(boolean daemon) {
        checkAccess();
        this.daemon = daemon;
    }

    public final void setMaxPriority(int pri) {
        int ngroupsSnapshot;
        ThreadGroup[] groupsSnapshot;
        synchronized (this) {
            checkAccess();
            if (pri < 1) {
                pri = 1;
            }
            if (pri > 10) {
                pri = 10;
            }
            ThreadGroup threadGroup = this.parent;
            this.maxPriority = threadGroup != null ? Math.min(pri, threadGroup.maxPriority) : pri;
            ngroupsSnapshot = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, ngroupsSnapshot);
            } else {
                groupsSnapshot = null;
            }
        }
        for (int i10 = 0; i10 < ngroupsSnapshot; i10++) {
            groupsSnapshot[i10].setMaxPriority(pri);
        }
    }

    public final boolean parentOf(ThreadGroup g3) {
        while (g3 != null) {
            if (g3 != this) {
                g3 = g3.parent;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void checkAccess() {
    }

    public int activeCount() {
        ThreadGroup[] groupsSnapshot;
        synchronized (this) {
            if (this.destroyed) {
                return 0;
            }
            int result = this.nthreads;
            int ngroupsSnapshot = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, ngroupsSnapshot);
            } else {
                groupsSnapshot = null;
            }
            for (int i10 = 0; i10 < ngroupsSnapshot; i10++) {
                result += groupsSnapshot[i10].activeCount();
            }
            return result;
        }
    }

    public int enumerate(Thread[] list) {
        checkAccess();
        return enumerate(list, 0, true);
    }

    public int enumerate(Thread[] list, boolean recurse) {
        checkAccess();
        return enumerate(list, 0, recurse);
    }

    private int enumerate(Thread[] list, int n10, boolean recurse) {
        int ngroupsSnapshot = 0;
        ThreadGroup[] groupsSnapshot = null;
        synchronized (this) {
            try {
                if (this.destroyed) {
                    return 0;
                }
                int nt = this.nthreads;
                if (nt > list.length - n10) {
                    nt = list.length - n10;
                }
                for (int i10 = 0; i10 < nt; i10++) {
                    if (this.threads[i10].isAlive()) {
                        int n11 = n10 + 1;
                        try {
                            list[n10] = this.threads[i10];
                            n10 = n11;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                }
                if (recurse) {
                    ngroupsSnapshot = this.ngroups;
                    ThreadGroup[] threadGroupArr = this.groups;
                    if (threadGroupArr != null) {
                        groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, ngroupsSnapshot);
                    } else {
                        groupsSnapshot = null;
                    }
                }
                if (recurse) {
                    for (int i11 = 0; i11 < ngroupsSnapshot; i11++) {
                        n10 = groupsSnapshot[i11].enumerate(list, n10, true);
                    }
                }
                return n10;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public int activeGroupCount() {
        ThreadGroup[] groupsSnapshot;
        synchronized (this) {
            if (this.destroyed) {
                return 0;
            }
            int ngroupsSnapshot = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, ngroupsSnapshot);
            } else {
                groupsSnapshot = null;
            }
            int n10 = ngroupsSnapshot;
            for (int i10 = 0; i10 < ngroupsSnapshot; i10++) {
                n10 += groupsSnapshot[i10].activeGroupCount();
            }
            return n10;
        }
    }

    public int enumerate(ThreadGroup[] list) {
        checkAccess();
        return enumerate(list, 0, true);
    }

    public int enumerate(ThreadGroup[] list, boolean recurse) {
        checkAccess();
        return enumerate(list, 0, recurse);
    }

    private int enumerate(ThreadGroup[] list, int n10, boolean recurse) {
        int ngroupsSnapshot = 0;
        ThreadGroup[] groupsSnapshot = null;
        synchronized (this) {
            if (this.destroyed) {
                return 0;
            }
            int ng = this.ngroups;
            if (ng > list.length - n10) {
                ng = list.length - n10;
            }
            if (ng > 0) {
                System.arraycopy(this.groups, 0, list, n10, ng);
                n10 += ng;
            }
            if (recurse) {
                ngroupsSnapshot = this.ngroups;
                ThreadGroup[] threadGroupArr = this.groups;
                if (threadGroupArr != null) {
                    groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, ngroupsSnapshot);
                } else {
                    groupsSnapshot = null;
                }
            }
            if (recurse) {
                for (int i10 = 0; i10 < ngroupsSnapshot; i10++) {
                    n10 = groupsSnapshot[i10].enumerate(list, n10, true);
                }
            }
            return n10;
        }
    }

    @Deprecated(since = "1.2")
    public final void stop() {
        if (stopOrSuspend(false)) {
            Thread.currentThread().stop();
        }
    }

    public final void interrupt() {
        int i10;
        ThreadGroup[] groupsSnapshot;
        synchronized (this) {
            checkAccess();
            for (int i11 = 0; i11 < this.nthreads; i11++) {
                this.threads[i11].interrupt();
            }
            i10 = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, i10);
            } else {
                groupsSnapshot = null;
            }
        }
        for (int i12 = 0; i12 < i10; i12++) {
            groupsSnapshot[i12].interrupt();
        }
    }

    @Deprecated(since = "1.2")
    public final void suspend() {
        if (stopOrSuspend(true)) {
            Thread.currentThread().suspend();
        }
    }

    private boolean stopOrSuspend(boolean suspend) {
        int i10;
        boolean suicide = false;
        Thread us = Thread.currentThread();
        ThreadGroup[] groupsSnapshot = null;
        synchronized (this) {
            checkAccess();
            for (int i11 = 0; i11 < this.nthreads; i11++) {
                Thread thread = this.threads[i11];
                if (thread == us) {
                    suicide = true;
                } else if (suspend) {
                    thread.suspend();
                } else {
                    thread.stop();
                }
            }
            i10 = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, i10);
            }
        }
        for (int i12 = 0; i12 < i10; i12++) {
            suicide = groupsSnapshot[i12].stopOrSuspend(suspend) || suicide;
        }
        return suicide;
    }

    @Deprecated(since = "1.2")
    public final void resume() {
        int i10;
        ThreadGroup[] groupsSnapshot;
        synchronized (this) {
            checkAccess();
            for (int i11 = 0; i11 < this.nthreads; i11++) {
                this.threads[i11].resume();
            }
            i10 = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, i10);
            } else {
                groupsSnapshot = null;
            }
        }
        for (int i12 = 0; i12 < i10; i12++) {
            groupsSnapshot[i12].resume();
        }
    }

    public final void destroy() {
        int ngroupsSnapshot;
        ThreadGroup[] groupsSnapshot;
        synchronized (this) {
            checkAccess();
            if (this.destroyed || this.nthreads > 0) {
                throw new IllegalThreadStateException();
            }
            ngroupsSnapshot = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, ngroupsSnapshot);
            } else {
                groupsSnapshot = null;
            }
            if (this.parent != null) {
                this.destroyed = true;
                this.ngroups = 0;
                this.groups = null;
                this.nthreads = 0;
                this.threads = null;
            }
        }
        for (int i10 = 0; i10 < ngroupsSnapshot; i10++) {
            groupsSnapshot[i10].destroy();
        }
        ThreadGroup threadGroup = this.parent;
        if (threadGroup != null) {
            threadGroup.remove(this);
        }
    }

    private final void add(ThreadGroup g3) {
        synchronized (this) {
            if (this.destroyed) {
                throw new IllegalThreadStateException();
            }
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr == null) {
                this.groups = new ThreadGroup[4];
            } else {
                int i10 = this.ngroups;
                if (i10 == threadGroupArr.length) {
                    this.groups = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, i10 * 2);
                }
            }
            ThreadGroup[] threadGroupArr2 = this.groups;
            int i11 = this.ngroups;
            threadGroupArr2[i11] = g3;
            this.ngroups = i11 + 1;
        }
    }

    private void remove(ThreadGroup g3) {
        synchronized (this) {
            if (this.destroyed) {
                return;
            }
            int i10 = 0;
            while (true) {
                int i11 = this.ngroups;
                if (i10 >= i11) {
                    break;
                }
                ThreadGroup[] threadGroupArr = this.groups;
                if (threadGroupArr[i10] != g3) {
                    i10++;
                } else {
                    int i12 = i11 - 1;
                    this.ngroups = i12;
                    System.arraycopy(threadGroupArr, i10 + 1, threadGroupArr, i10, i12 - i10);
                    this.groups[this.ngroups] = null;
                    break;
                }
            }
            int i13 = this.nthreads;
            if (i13 == 0) {
                notifyAll();
            }
            if (this.daemon && this.nthreads == 0 && this.nUnstartedThreads == 0 && this.ngroups == 0) {
                destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addUnstarted() {
        synchronized (this) {
            if (this.destroyed) {
                throw new IllegalThreadStateException();
            }
            this.nUnstartedThreads++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(Thread t2) {
        synchronized (this) {
            if (this.destroyed) {
                throw new IllegalThreadStateException();
            }
            Thread[] threadArr = this.threads;
            if (threadArr == null) {
                this.threads = new Thread[4];
            } else {
                int i10 = this.nthreads;
                if (i10 == threadArr.length) {
                    this.threads = (Thread[]) Arrays.copyOf(threadArr, i10 * 2);
                }
            }
            Thread[] threadArr2 = this.threads;
            int i11 = this.nthreads;
            threadArr2[i11] = t2;
            this.nthreads = i11 + 1;
            this.nUnstartedThreads--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void threadStartFailed(Thread t2) {
        synchronized (this) {
            remove(t2);
            this.nUnstartedThreads++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void threadTerminated(Thread t2) {
        synchronized (this) {
            remove(t2);
            if (this.nthreads == 0) {
                notifyAll();
            }
            if (this.daemon && this.nthreads == 0 && this.nUnstartedThreads == 0 && this.ngroups == 0) {
                destroy();
            }
        }
    }

    private void remove(Thread t2) {
        synchronized (this) {
            if (this.destroyed) {
                return;
            }
            int i10 = 0;
            while (true) {
                int i11 = this.nthreads;
                if (i10 >= i11) {
                    break;
                }
                Thread[] threadArr = this.threads;
                if (threadArr[i10] != t2) {
                    i10++;
                } else {
                    int i12 = i11 - 1;
                    this.nthreads = i12;
                    System.arraycopy(threadArr, i10 + 1, threadArr, i10, i12 - i10);
                    this.threads[this.nthreads] = null;
                    break;
                }
            }
        }
    }

    public void list() {
        list(System.out, 0);
    }

    void list(PrintStream out, int indent) {
        int indent2;
        int i10;
        ThreadGroup[] groupsSnapshot;
        synchronized (this) {
            for (int j10 = 0; j10 < indent; j10++) {
                out.print(" ");
            }
            out.println(this);
            indent2 = indent + 4;
            for (int i11 = 0; i11 < this.nthreads; i11++) {
                for (int j11 = 0; j11 < indent2; j11++) {
                    out.print(" ");
                }
                out.println(this.threads[i11]);
            }
            i10 = this.ngroups;
            ThreadGroup[] threadGroupArr = this.groups;
            if (threadGroupArr != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf(threadGroupArr, i10);
            } else {
                groupsSnapshot = null;
            }
        }
        for (int i12 = 0; i12 < i10; i12++) {
            groupsSnapshot[i12].list(out, indent2);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t2, Throwable e2) {
        ThreadGroup threadGroup = this.parent;
        if (threadGroup != null) {
            threadGroup.uncaughtException(t2, e2);
            return;
        }
        Thread.UncaughtExceptionHandler ueh = Thread.getDefaultUncaughtExceptionHandler();
        if (ueh != null) {
            ueh.uncaughtException(t2, e2);
        } else if (!(e2 instanceof ThreadDeath)) {
            System.err.print("Exception in thread \"" + t2.getName() + "\" ");
            e2.printStackTrace(System.err);
        }
    }

    @Deprecated(since = "1.2")
    public boolean allowThreadSuspension(boolean b4) {
        return true;
    }

    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",maxpri=" + this.maxPriority + "]";
    }
}
