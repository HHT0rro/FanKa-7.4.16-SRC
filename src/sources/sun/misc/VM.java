package sun.misc;

import java.lang.Thread;
import java.util.Properties;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class VM {
    private static final int JVMTI_THREAD_STATE_ALIVE = 1;
    private static final int JVMTI_THREAD_STATE_BLOCKED_ON_MONITOR_ENTER = 1024;
    private static final int JVMTI_THREAD_STATE_RUNNABLE = 4;
    private static final int JVMTI_THREAD_STATE_TERMINATED = 2;
    private static final int JVMTI_THREAD_STATE_WAITING_INDEFINITELY = 16;
    private static final int JVMTI_THREAD_STATE_WAITING_WITH_TIMEOUT = 32;

    @Deprecated
    public static final int STATE_GREEN = 1;

    @Deprecated
    public static final int STATE_RED = 3;

    @Deprecated
    public static final int STATE_YELLOW = 2;
    private static boolean pageAlignDirectMemory;
    private static boolean suspended = false;
    private static volatile boolean booted = false;
    private static final Object lock = new Object();
    private static long directMemory = 67108864;
    private static boolean defaultAllowArraySyntax = false;
    private static boolean allowArraySyntax = false;
    private static final Properties savedProps = new Properties();
    private static volatile int finalRefCount = 0;
    private static volatile int peakFinalRefCount = 0;

    @Deprecated
    public static boolean threadsSuspended() {
        return suspended;
    }

    public static boolean allowThreadSuspension(ThreadGroup g3, boolean b4) {
        return g3.allowThreadSuspension(b4);
    }

    @Deprecated
    public static boolean suspendThreads() {
        suspended = true;
        return true;
    }

    @Deprecated
    public static void unsuspendThreads() {
        suspended = false;
    }

    @Deprecated
    public static void unsuspendSomeThreads() {
    }

    @Deprecated
    public static final int getState() {
        return 1;
    }

    @Deprecated
    public static void asChange(int as_old, int as_new) {
    }

    @Deprecated
    public static void asChange_otherthread(int as_old, int as_new) {
    }

    public static void booted() {
        Object obj = lock;
        synchronized (obj) {
            booted = true;
            obj.notifyAll();
        }
    }

    public static boolean isBooted() {
        return booted;
    }

    public static void awaitBooted() throws InterruptedException {
        synchronized (lock) {
            while (!booted) {
                lock.wait();
            }
        }
    }

    public static long maxDirectMemory() {
        return directMemory;
    }

    public static boolean isDirectMemoryPageAligned() {
        return pageAlignDirectMemory;
    }

    public static boolean allowArraySyntax() {
        return allowArraySyntax;
    }

    public static String getSavedProperty(String key) {
        return savedProps.getProperty(key);
    }

    public static void saveAndRemoveProperties(Properties props) {
        boolean parseBoolean;
        if (booted) {
            throw new IllegalStateException("System initialization has completed");
        }
        savedProps.putAll(props);
        String s2 = (String) props.remove("sun.nio.MaxDirectMemorySize");
        if (s2 != null) {
            if (s2.equals("-1")) {
                directMemory = Runtime.getRuntime().maxMemory();
            } else {
                long l10 = Long.parseLong(s2);
                if (l10 > -1) {
                    directMemory = l10;
                }
            }
        }
        if ("true".equals((String) props.remove("sun.nio.PageAlignDirectMemory"))) {
            pageAlignDirectMemory = true;
        }
        String s10 = props.getProperty("sun.lang.ClassLoader.allowArraySyntax");
        if (s10 == null) {
            parseBoolean = defaultAllowArraySyntax;
        } else {
            parseBoolean = Boolean.parseBoolean(s10);
        }
        allowArraySyntax = parseBoolean;
        props.remove("java.lang.Integer.IntegerCache.high");
        props.remove("sun.zip.disableMemoryMapping");
        props.remove("sun.java.launcher.diag");
        props.remove("sun.cds.enableSharedLookupCache");
    }

    public static void initializeOSEnvironment() {
    }

    public static int getFinalRefCount() {
        return finalRefCount;
    }

    public static int getPeakFinalRefCount() {
        return peakFinalRefCount;
    }

    public static void addFinalRefCount(int n10) {
        finalRefCount += n10;
        if (finalRefCount > peakFinalRefCount) {
            peakFinalRefCount = finalRefCount;
        }
    }

    public static Thread.State toThreadState(int threadStatus) {
        if ((threadStatus & 4) != 0) {
            return Thread.State.RUNNABLE;
        }
        if ((threadStatus & 1024) != 0) {
            return Thread.State.BLOCKED;
        }
        if ((threadStatus & 16) != 0) {
            return Thread.State.WAITING;
        }
        if ((threadStatus & 32) != 0) {
            return Thread.State.TIMED_WAITING;
        }
        if ((threadStatus & 2) != 0) {
            return Thread.State.TERMINATED;
        }
        if ((threadStatus & 1) == 0) {
            return Thread.State.NEW;
        }
        return Thread.State.RUNNABLE;
    }
}
