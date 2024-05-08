package io.grpc;

import io.grpc.PersistentHashArrayMappedTrie;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Context {
    public static final int CONTEXT_DEPTH_WARN_THRESH = 1000;
    public final CancellableContext cancellableAncestor;
    public final int generation;
    public final PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries;
    public static final Logger log = Logger.getLogger(Context.class.getName());
    public static final Context ROOT = new Context();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface CanIgnoreReturnValue {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface CancellationListener {
        void cancelled(Context context);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface CheckReturnValue {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ExecutableListener implements Runnable {
        private final Context context;
        private final Executor executor;
        public final CancellationListener listener;

        public ExecutableListener(Executor executor, CancellationListener cancellationListener, Context context) {
            this.executor = executor;
            this.listener = cancellationListener;
            this.context = context;
        }

        public void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable th) {
                Context.log.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.listener.cancelled(this.context);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        public Key(String str) {
            this(str, null);
        }

        public T get() {
            return get(Context.current());
        }

        public String toString() {
            return this.name;
        }

        public Key(String str, T t2) {
            this.name = (String) Context.checkNotNull(str, "name");
            this.defaultValue = t2;
        }

        public T get(Context context) {
            T t2 = (T) PersistentHashArrayMappedTrie.get(context.keyValueEntries, this);
            return t2 == null ? this.defaultValue : t2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class LazyStorage {
        public static final Storage storage;

        static {
            AtomicReference atomicReference = new AtomicReference();
            storage = createStorage(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        private LazyStorage() {
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                atomicReference.set(e2);
                return new ThreadLocalContextStorage();
            } catch (Exception e10) {
                throw new RuntimeException("Storage override failed to initialize", e10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Storage {
        @Deprecated
        public void attach(Context context) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        public Context doAttach(Context context) {
            Context current = current();
            attach(context);
            return current;
        }
    }

    public static CancellableContext cancellableAncestor(Context context) {
        if (context instanceof CancellableContext) {
            return (CancellableContext) context;
        }
        return context.cancellableAncestor;
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static Context current() {
        Context current = storage().current();
        return current == null ? ROOT : current;
    }

    public static Executor currentContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1CurrentContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Executor.this.execute(Context.current().wrap(runnable));
            }
        };
    }

    public static <T> Key<T> key(String str) {
        return new Key<>(str);
    }

    public static <T> Key<T> keyWithDefault(String str, T t2) {
        return new Key<>(str, t2);
    }

    public static Storage storage() {
        return LazyStorage.storage;
    }

    private static void validateGeneration(int i10) {
        if (i10 == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        checkNotNull(cancellationListener, "cancellationListener");
        checkNotNull(executor, "executor");
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return;
        }
        cancellableContext.addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
    }

    public Context attach() {
        Context doAttach = storage().doAttach(this);
        return doAttach == null ? ROOT : doAttach;
    }

    @CanIgnoreReturnValue
    public <V> V call(Callable<V> callable) throws Exception {
        Context attach = attach();
        try {
            return callable.call();
        } finally {
            detach(attach);
        }
    }

    public Throwable cancellationCause() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.cancellationCause();
    }

    public void detach(Context context) {
        checkNotNull(context, "toAttach");
        storage().detach(this, context);
    }

    public Executor fixedContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1FixedContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Context.this.wrap(runnable));
            }
        };
    }

    public Context fork() {
        return new Context(this.keyValueEntries, this.generation + 1);
    }

    public Deadline getDeadline() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.getDeadline();
    }

    public boolean isCancelled() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return false;
        }
        return cancellableContext.isCancelled();
    }

    public boolean isCurrent() {
        return current() == this;
    }

    public int listenerCount() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return 0;
        }
        return cancellableContext.listenerCount();
    }

    public void removeListener(CancellationListener cancellationListener) {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return;
        }
        cancellableContext.removeListenerInternal(cancellationListener, this);
    }

    public void run(Runnable runnable) {
        Context attach = attach();
        try {
            runnable.run();
        } finally {
            detach(attach);
        }
    }

    public CancellableContext withCancellation() {
        return new CancellableContext();
    }

    public CancellableContext withDeadline(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
        boolean z10;
        checkNotNull(deadline, "deadline");
        checkNotNull(scheduledExecutorService, "scheduler");
        Deadline deadline2 = getDeadline();
        if (deadline2 == null || deadline2.compareTo(deadline) > 0) {
            z10 = true;
        } else {
            deadline = deadline2;
            z10 = false;
        }
        CancellableContext cancellableContext = new CancellableContext(deadline);
        if (z10) {
            cancellableContext.setUpDeadlineCancellation(deadline, scheduledExecutorService);
        }
        return cancellableContext;
    }

    public CancellableContext withDeadlineAfter(long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return withDeadline(Deadline.after(j10, timeUnit), scheduledExecutorService);
    }

    public <V> Context withValue(Key<V> key, V v2) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v2));
    }

    public <V1, V2> Context withValues(Key<V1> key, V1 v12, Key<V2> key2, V2 v2) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v12), key2, v2));
    }

    public Runnable wrap(final Runnable runnable) {
        return new Runnable() { // from class: io.grpc.Context.1
            @Override // java.lang.Runnable
            public void run() {
                Context attach = Context.this.attach();
                try {
                    runnable.run();
                } finally {
                    Context.this.detach(attach);
                }
            }
        };
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CancellableContext extends Context implements Closeable {
        private Throwable cancellationCause;
        private boolean cancelled;
        private final Deadline deadline;
        private ArrayList<ExecutableListener> listeners;
        private CancellationListener parentListener;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        /* JADX INFO: Access modifiers changed from: private */
        public void addListenerInternal(ExecutableListener executableListener) {
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.deliver();
                } else {
                    ArrayList<ExecutableListener> arrayList = this.listeners;
                    if (arrayList == null) {
                        ArrayList<ExecutableListener> arrayList2 = new ArrayList<>();
                        this.listeners = arrayList2;
                        arrayList2.add(executableListener);
                        if (this.cancellableAncestor != null) {
                            CancellationListener cancellationListener = new CancellationListener() { // from class: io.grpc.Context.CancellableContext.1
                                @Override // io.grpc.Context.CancellationListener
                                public void cancelled(Context context) {
                                    CancellableContext.this.cancel(context.cancellationCause());
                                }
                            };
                            this.parentListener = cancellationListener;
                            this.cancellableAncestor.addListenerInternal(new ExecutableListener(DirectExecutor.INSTANCE, cancellationListener, this));
                        }
                    } else {
                        arrayList.add(executableListener);
                    }
                }
            }
        }

        private void notifyAndClearListeners() {
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                if (arrayList == null) {
                    return;
                }
                CancellationListener cancellationListener = this.parentListener;
                this.parentListener = null;
                this.listeners = null;
                Iterator<ExecutableListener> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    ExecutableListener next = iterator2.next();
                    if (next.context == this) {
                        next.deliver();
                    }
                }
                Iterator<ExecutableListener> iterator22 = arrayList.iterator2();
                while (iterator22.hasNext()) {
                    ExecutableListener next2 = iterator22.next();
                    if (next2.context != this) {
                        next2.deliver();
                    }
                }
                CancellableContext cancellableContext = this.cancellableAncestor;
                if (cancellableContext != null) {
                    cancellableContext.removeListener(cancellationListener);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeListenerInternal(CancellationListener cancellationListener, Context context) {
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                if (arrayList != null) {
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        ExecutableListener executableListener = this.listeners.get(size);
                        if (executableListener.listener == cancellationListener && executableListener.context == context) {
                            this.listeners.remove(size);
                            break;
                        }
                        size--;
                    }
                    if (this.listeners.isEmpty()) {
                        CancellableContext cancellableContext = this.cancellableAncestor;
                        if (cancellableContext != null) {
                            cancellableContext.removeListener(this.parentListener);
                        }
                        this.parentListener = null;
                        this.listeners = null;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpDeadlineCancellation(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
            if (!deadline.isExpired()) {
                synchronized (this) {
                    this.pendingDeadline = deadline.runOnExpiration(new Runnable() { // from class: io.grpc.Context.CancellableContext.1CancelOnExpiration
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CancellableContext.this.cancel(new TimeoutException("context timed out"));
                            } catch (Throwable th) {
                                Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", th);
                            }
                        }
                    }, scheduledExecutorService);
                }
            } else {
                cancel(new TimeoutException("context timed out"));
            }
        }

        @Override // io.grpc.Context
        public void addListener(CancellationListener cancellationListener, Executor executor) {
            Context.checkNotNull(cancellationListener, "cancellationListener");
            Context.checkNotNull(executor, "executor");
            addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
        }

        @Override // io.grpc.Context
        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        @CanIgnoreReturnValue
        public boolean cancel(Throwable th) {
            boolean z10;
            ScheduledFuture<?> scheduledFuture;
            synchronized (this) {
                z10 = true;
                scheduledFuture = null;
                if (this.cancelled) {
                    z10 = false;
                } else {
                    this.cancelled = true;
                    ScheduledFuture<?> scheduledFuture2 = this.pendingDeadline;
                    if (scheduledFuture2 != null) {
                        this.pendingDeadline = null;
                        scheduledFuture = scheduledFuture2;
                    }
                    this.cancellationCause = th;
                }
            }
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (z10) {
                notifyAndClearListeners();
            }
            return z10;
        }

        @Override // io.grpc.Context
        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            cancel(null);
        }

        @Override // io.grpc.Context
        public void detach(Context context) {
            this.uncancellableSurrogate.detach(context);
        }

        public void detachAndCancel(Context context, Throwable th) {
            try {
                detach(context);
            } finally {
                cancel(th);
            }
        }

        @Override // io.grpc.Context
        public Deadline getDeadline() {
            return this.deadline;
        }

        @Override // io.grpc.Context
        public boolean isCancelled() {
            synchronized (this) {
                if (this.cancelled) {
                    return true;
                }
                if (!super.isCancelled()) {
                    return false;
                }
                cancel(super.cancellationCause());
                return true;
            }
        }

        @Override // io.grpc.Context
        @Deprecated
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }

        @Override // io.grpc.Context
        public int listenerCount() {
            int size;
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                size = arrayList == null ? 0 : arrayList.size();
            }
            return size;
        }

        @Override // io.grpc.Context
        public void removeListener(CancellationListener cancellationListener) {
            removeListenerInternal(cancellationListener, this);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private CancellableContext(io.grpc.Context r3) {
            /*
                r2 = this;
                io.grpc.PersistentHashArrayMappedTrie$Node<io.grpc.Context$Key<?>, java.lang.Object> r0 = r3.keyValueEntries
                r1 = 0
                r2.<init>(r0)
                io.grpc.Deadline r3 = r3.getDeadline()
                r2.deadline = r3
                io.grpc.Context r3 = new io.grpc.Context
                io.grpc.PersistentHashArrayMappedTrie$Node<io.grpc.Context$Key<?>, java.lang.Object> r0 = r2.keyValueEntries
                r3.<init>(r0)
                r2.uncancellableSurrogate = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.CancellableContext.<init>(io.grpc.Context):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private CancellableContext(io.grpc.Context r3, io.grpc.Deadline r4) {
            /*
                r2 = this;
                io.grpc.PersistentHashArrayMappedTrie$Node<io.grpc.Context$Key<?>, java.lang.Object> r0 = r3.keyValueEntries
                r1 = 0
                r2.<init>(r0)
                r2.deadline = r4
                io.grpc.Context r3 = new io.grpc.Context
                io.grpc.PersistentHashArrayMappedTrie$Node<io.grpc.Context$Key<?>, java.lang.Object> r4 = r2.keyValueEntries
                r3.<init>(r4)
                r2.uncancellableSurrogate = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.CancellableContext.<init>(io.grpc.Context, io.grpc.Deadline):void");
        }
    }

    private Context(PersistentHashArrayMappedTrie.Node<Key<?>, Object> node, int i10) {
        this.cancellableAncestor = null;
        this.keyValueEntries = node;
        this.generation = i10;
        validateGeneration(i10);
    }

    public <C> Callable<C> wrap(final Callable<C> callable) {
        return new Callable<C>() { // from class: io.grpc.Context.2
            @Override // java.util.concurrent.Callable
            public C call() throws Exception {
                Context attach = Context.this.attach();
                try {
                    return (C) callable.call();
                } finally {
                    Context.this.detach(attach);
                }
            }
        };
    }

    public <V1, V2, V3> Context withValues(Key<V1> key, V1 v12, Key<V2> key2, V2 v2, Key<V3> key3, V3 v32) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v12), key2, v2), key3, v32));
    }

    private Context(Context context, PersistentHashArrayMappedTrie.Node<Key<?>, Object> node) {
        this.cancellableAncestor = cancellableAncestor(context);
        this.keyValueEntries = node;
        int i10 = context.generation + 1;
        this.generation = i10;
        validateGeneration(i10);
    }

    public <V1, V2, V3, V4> Context withValues(Key<V1> key, V1 v12, Key<V2> key2, V2 v2, Key<V3> key3, V3 v32, Key<V4> key4, V4 v42) {
        return new Context(this, (PersistentHashArrayMappedTrie.Node<Key<?>, Object>) PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, key, v12), key2, v2), key3, v32), key4, v42));
    }

    private Context() {
        this.cancellableAncestor = null;
        this.keyValueEntries = null;
        this.generation = 0;
        validateGeneration(0);
    }
}
