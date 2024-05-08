package sun.nio.ch;

import java.security.AccessController;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ThreadPool {
    private static final String DEFAULT_THREAD_POOL_INITIAL_SIZE = "java.nio.channels.DefaultThreadPool.initialSize";
    private static final String DEFAULT_THREAD_POOL_THREAD_FACTORY = "java.nio.channels.DefaultThreadPool.threadFactory";
    private final ExecutorService executor;
    private final boolean isFixed;
    private final int poolSize;

    private ThreadPool(ExecutorService executor, boolean isFixed, int poolSize) {
        this.executor = executor;
        this.isFixed = isFixed;
        this.poolSize = poolSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService executor() {
        return this.executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFixedThreadPool() {
        return this.isFixed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int poolSize() {
        return this.poolSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadFactory defaultThreadFactory() {
        return new ThreadFactory() { // from class: sun.nio.ch.ThreadPool$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ThreadPool.lambda$defaultThreadFactory$0(runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Thread lambda$defaultThreadFactory$0(Runnable r10) {
        Thread t2 = new Thread(r10);
        t2.setDaemon(true);
        return t2;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class DefaultThreadPoolHolder {
        static final ThreadPool defaultThreadPool = ThreadPool.createDefault();

        private DefaultThreadPoolHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPool getDefault() {
        return DefaultThreadPoolHolder.defaultThreadPool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPool createDefault() {
        int initialSize = getDefaultThreadPoolInitialSize();
        if (initialSize < 0) {
            initialSize = Runtime.getRuntime().availableProcessors();
        }
        ThreadFactory threadFactory = getDefaultThreadPoolThreadFactory();
        if (threadFactory == null) {
            threadFactory = defaultThreadFactory();
        }
        ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
        return new ThreadPool(executor, false, initialSize);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPool create(int nThreads, ThreadFactory factory) {
        if (nThreads <= 0) {
            throw new IllegalArgumentException("'nThreads' must be > 0");
        }
        ExecutorService executor = Executors.newFixedThreadPool(nThreads, factory);
        return new ThreadPool(executor, true, nThreads);
    }

    public static ThreadPool wrap(ExecutorService executor, int initialSize) {
        if (executor == null) {
            throw new NullPointerException("'executor' is null");
        }
        if (executor instanceof ThreadPoolExecutor) {
            int max = ((ThreadPoolExecutor) executor).getMaximumPoolSize();
            if (max == Integer.MAX_VALUE) {
                if (initialSize < 0) {
                    initialSize = Runtime.getRuntime().availableProcessors();
                } else {
                    initialSize = 0;
                }
            }
        } else if (initialSize < 0) {
            initialSize = 0;
        }
        return new ThreadPool(executor, false, initialSize);
    }

    private static int getDefaultThreadPoolInitialSize() {
        String propValue = (String) AccessController.doPrivileged(new GetPropertyAction(DEFAULT_THREAD_POOL_INITIAL_SIZE));
        if (propValue != null) {
            try {
                return Integer.parseInt(propValue);
            } catch (NumberFormatException x10) {
                throw new Error("Value of property 'java.nio.channels.DefaultThreadPool.initialSize' is invalid: " + ((Object) x10));
            }
        }
        return -1;
    }

    private static ThreadFactory getDefaultThreadPoolThreadFactory() {
        String propValue = (String) AccessController.doPrivileged(new GetPropertyAction(DEFAULT_THREAD_POOL_THREAD_FACTORY));
        if (propValue != null) {
            try {
                Class<?> c4 = Class.forName(propValue, true, ClassLoader.getSystemClassLoader());
                return (ThreadFactory) c4.newInstance();
            } catch (ClassNotFoundException x10) {
                throw new Error(x10);
            } catch (IllegalAccessException x11) {
                throw new Error(x11);
            } catch (InstantiationException x12) {
                throw new Error(x12);
            }
        }
        return null;
    }
}
