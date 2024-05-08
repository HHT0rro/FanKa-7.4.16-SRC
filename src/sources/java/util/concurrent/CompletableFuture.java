package java.util.concurrent;

import com.huawei.quickcard.base.Attributes;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.LockSupport;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CompletableFuture<T> implements Future<T>, CompletionStage<T> {
    static final int ASYNC = 1;
    private static final Executor ASYNC_POOL;
    static final int NESTED = -1;
    private static final VarHandle NEXT;
    static final AltResult NIL = new AltResult(null);
    private static final VarHandle RESULT;
    private static final VarHandle STACK;
    static final int SYNC = 0;
    private static final boolean USE_COMMON_POOL;
    volatile Object result;
    volatile Completion stack;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface AsynchronousCompletionTask {
    }

    @Override // java.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterBoth(CompletionStage completionStage, Runnable runnable) {
        return runAfterBoth((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterBothAsync(CompletionStage completionStage, Runnable runnable) {
        return runAfterBothAsync((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterBothAsync(CompletionStage completionStage, Runnable runnable, Executor executor) {
        return runAfterBothAsync((CompletionStage<?>) completionStage, runnable, executor);
    }

    @Override // java.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterEither(CompletionStage completionStage, Runnable runnable) {
        return runAfterEither((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterEitherAsync(CompletionStage completionStage, Runnable runnable) {
        return runAfterEitherAsync((CompletionStage<?>) completionStage, runnable);
    }

    @Override // java.util.concurrent.CompletionStage
    public /* bridge */ /* synthetic */ CompletionStage runAfterEitherAsync(CompletionStage completionStage, Runnable runnable, Executor executor) {
        return runAfterEitherAsync((CompletionStage<?>) completionStage, runnable, executor);
    }

    final boolean internalComplete(Object r10) {
        return (boolean) RESULT.compareAndSet(this, null, r10);
    }

    final boolean tryPushStack(Completion c4) {
        Completion h10 = this.stack;
        (void) NEXT.set(c4, h10);
        return (boolean) STACK.compareAndSet(this, h10, c4);
    }

    final void pushStack(Completion c4) {
        do {
        } while (!tryPushStack(c4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AltResult {
        final Throwable ex;

        AltResult(Throwable x10) {
            this.ex = x10;
        }
    }

    static {
        boolean z10 = ForkJoinPool.getCommonPoolParallelism() > 1;
        USE_COMMON_POOL = z10;
        ASYNC_POOL = z10 ? ForkJoinPool.commonPool() : new ThreadPerTaskExecutor();
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            RESULT = l10.findVarHandle(CompletableFuture.class, "result", Object.class);
            STACK = l10.findVarHandle(CompletableFuture.class, Attributes.Component.STACK, Completion.class);
            NEXT = l10.findVarHandle(Completion.class, "next", Completion.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    final boolean completeNull() {
        return (boolean) RESULT.compareAndSet(this, null, NIL);
    }

    final Object encodeValue(T t2) {
        return t2 == null ? NIL : t2;
    }

    final boolean completeValue(T t2) {
        return (boolean) RESULT.compareAndSet(this, null, t2 == null ? NIL : t2);
    }

    static AltResult encodeThrowable(Throwable x10) {
        return new AltResult(x10 instanceof CompletionException ? x10 : new CompletionException(x10));
    }

    final boolean completeThrowable(Throwable x10) {
        return (boolean) RESULT.compareAndSet(this, null, encodeThrowable(x10));
    }

    static Object encodeThrowable(Throwable x10, Object r10) {
        if (!(x10 instanceof CompletionException)) {
            x10 = new CompletionException(x10);
        } else if ((r10 instanceof AltResult) && x10 == ((AltResult) r10).ex) {
            return r10;
        }
        return new AltResult(x10);
    }

    final boolean completeThrowable(Throwable x10, Object r10) {
        return (boolean) RESULT.compareAndSet(this, null, encodeThrowable(x10, r10));
    }

    Object encodeOutcome(T t2, Throwable x10) {
        return x10 == null ? t2 == null ? NIL : t2 : encodeThrowable(x10);
    }

    static Object encodeRelay(Object r10) {
        Throwable x10;
        if ((r10 instanceof AltResult) && (x10 = ((AltResult) r10).ex) != null && !(x10 instanceof CompletionException)) {
            return new AltResult(new CompletionException(x10));
        }
        return r10;
    }

    final boolean completeRelay(Object r10) {
        return (boolean) RESULT.compareAndSet(this, null, encodeRelay(r10));
    }

    private static Object reportGet(Object r10) throws InterruptedException, ExecutionException {
        Throwable cause;
        if (r10 == null) {
            throw new InterruptedException();
        }
        if (r10 instanceof AltResult) {
            Throwable th = ((AltResult) r10).ex;
            Throwable x10 = th;
            if (th == null) {
                return null;
            }
            if (x10 instanceof CancellationException) {
                throw ((CancellationException) x10);
            }
            if ((x10 instanceof CompletionException) && (cause = x10.getCause()) != null) {
                x10 = cause;
            }
            throw new ExecutionException(x10);
        }
        return r10;
    }

    private static Object reportJoin(Object r10) {
        if (r10 instanceof AltResult) {
            Throwable x10 = ((AltResult) r10).ex;
            if (x10 == null) {
                return null;
            }
            if (x10 instanceof CancellationException) {
                throw ((CancellationException) x10);
            }
            if (x10 instanceof CompletionException) {
                throw ((CompletionException) x10);
            }
            throw new CompletionException(x10);
        }
        return r10;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            Objects.requireNonNull(r10);
            new Thread(r10).start();
        }
    }

    static Executor screenExecutor(Executor e2) {
        if (!USE_COMMON_POOL && e2 == ForkJoinPool.commonPool()) {
            return ASYNC_POOL;
        }
        if (e2 == null) {
            throw new NullPointerException();
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Completion extends ForkJoinTask<Void> implements Runnable, AsynchronousCompletionTask {
        volatile Completion next;

        abstract boolean isLive();

        abstract CompletableFuture<?> tryFire(int i10);

        Completion() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            tryFire(1);
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            tryFire(1);
            return false;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void v2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void postComplete() {
        CompletableFuture completableFuture = this;
        while (true) {
            Completion completion = completableFuture.stack;
            Completion h10 = completion;
            if (completion == null) {
                if (completableFuture == this) {
                    return;
                }
                completableFuture = this;
                Completion completion2 = this.stack;
                h10 = completion2;
                if (completion2 == null) {
                    return;
                }
            }
            VarHandle varHandle = STACK;
            Completion t2 = h10.next;
            if ((boolean) varHandle.compareAndSet(completableFuture, h10, t2)) {
                if (t2 != null) {
                    if (completableFuture != this) {
                        pushStack(h10);
                    } else {
                        (boolean) NEXT.compareAndSet(h10, t2, null);
                    }
                }
                CompletableFuture tryFire = h10.tryFire(-1);
                completableFuture = tryFire == null ? this : tryFire;
            }
        }
    }

    final void cleanStack() {
        Completion p10 = this.stack;
        boolean unlinked = false;
        while (p10 != null) {
            if (p10.isLive()) {
                if (unlinked) {
                    return;
                }
                Completion q10 = p10.next;
                while (q10 != null) {
                    Completion s2 = q10.next;
                    if (q10.isLive()) {
                        p10 = q10;
                        q10 = s2;
                    } else if (!(boolean) NEXT.weakCompareAndSet(p10, q10, s2)) {
                        q10 = p10.next;
                    } else {
                        return;
                    }
                }
                return;
            }
            VarHandle varHandle = STACK;
            Completion p11 = p10.next;
            if ((boolean) varHandle.weakCompareAndSet(this, p10, p11)) {
                unlinked = true;
                p10 = p11;
            } else {
                p10 = this.stack;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class UniCompletion<T, V> extends Completion {
        CompletableFuture<V> dep;
        Executor executor;
        CompletableFuture<T> src;

        UniCompletion(Executor executor, CompletableFuture<V> dep, CompletableFuture<T> src) {
            this.executor = executor;
            this.dep = dep;
            this.src = src;
        }

        final boolean claim() {
            Executor e2 = this.executor;
            if (compareAndSetForkJoinTaskTag((short) 0, (short) 1)) {
                if (e2 == null) {
                    return true;
                }
                this.executor = null;
                e2.execute(this);
            }
            return false;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            return this.dep != null;
        }
    }

    final void unipush(Completion c4) {
        if (c4 == null) {
            return;
        }
        while (true) {
            if (tryPushStack(c4)) {
                break;
            } else if (this.result != null) {
                (void) NEXT.set(c4, null);
                break;
            }
        }
        if (this.result != null) {
            c4.tryFire(0);
        }
    }

    final CompletableFuture<T> postFire(CompletableFuture<?> a10, int mode) {
        if (a10 != null && a10.stack != null) {
            Object r10 = a10.result;
            if (r10 == null) {
                a10.cleanStack();
            }
            if (mode >= 0 && (r10 != null || a10.result != null)) {
                a10.postComplete();
            }
        }
        if (this.result != null && this.stack != null) {
            if (mode < 0) {
                return this;
            }
            postComplete();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniApply<T, V> extends UniCompletion<T, V> {
        Function<? super T, ? extends V> fn;

        UniApply(Executor executor, CompletableFuture<V> dep, CompletableFuture<T> src, Function<? super T, ? extends V> fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int mode) {
            CompletableFuture<V> d10;
            Function<? super T, ? extends V> f10;
            CompletableFuture<T> a10 = this.src;
            if (a10 != null) {
                Object obj = a10.result;
                Object r10 = obj;
                if (obj != null && (d10 = this.dep) != null && (f10 = this.fn) != null) {
                    if (d10.result == null) {
                        if (r10 instanceof AltResult) {
                            Throwable x10 = ((AltResult) r10).ex;
                            if (x10 != null) {
                                d10.completeThrowable(x10, r10);
                            } else {
                                r10 = null;
                            }
                        }
                        if (mode <= 0) {
                            try {
                                if (!claim()) {
                                    return null;
                                }
                            } catch (Throwable ex) {
                                d10.completeThrowable(ex);
                            }
                        }
                        d10.completeValue(f10.apply(r10));
                    }
                    this.src = null;
                    this.dep = null;
                    this.fn = null;
                    return d10.postFire(a10, mode);
                }
            }
            return null;
        }
    }

    private <V> CompletableFuture<V> uniApplyStage(Executor executor, Function<? super T, ? extends V> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        Object obj = this.result;
        if (obj != null) {
            return uniApplyNow(obj, executor, function);
        }
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        unipush(new UniApply(executor, completableFuture, this, function));
        return completableFuture;
    }

    private <V> CompletableFuture<V> uniApplyNow(Object obj, Executor executor, Function<? super T, ? extends V> function) {
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        if (obj instanceof AltResult) {
            Throwable th = ((AltResult) obj).ex;
            if (th != null) {
                completableFuture.result = encodeThrowable(th, obj);
                return completableFuture;
            }
            obj = null;
        }
        try {
            if (executor != null) {
                executor.execute(new UniApply(null, completableFuture, this, function));
            } else {
                completableFuture.result = completableFuture.encodeValue(function.apply(obj));
            }
        } catch (Throwable th2) {
            completableFuture.result = encodeThrowable(th2);
        }
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniAccept<T> extends UniCompletion<T, Void> {
        Consumer<? super T> fn;

        UniAccept(Executor executor, CompletableFuture<Void> dep, CompletableFuture<T> src, Consumer<? super T> fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<Void> tryFire(int mode) {
            CompletableFuture<V> completableFuture;
            Consumer<? super T> f10;
            CompletableFuture<T> a10 = this.src;
            if (a10 != null) {
                Object obj = a10.result;
                Object r10 = obj;
                if (obj != null && (completableFuture = this.dep) != 0 && (f10 = this.fn) != null) {
                    if (completableFuture.result == null) {
                        if (r10 instanceof AltResult) {
                            Throwable x10 = ((AltResult) r10).ex;
                            if (x10 != null) {
                                completableFuture.completeThrowable(x10, r10);
                            } else {
                                r10 = null;
                            }
                        }
                        if (mode <= 0) {
                            try {
                                if (!claim()) {
                                    return null;
                                }
                            } catch (Throwable ex) {
                                completableFuture.completeThrowable(ex);
                            }
                        }
                        f10.accept(r10);
                        completableFuture.completeNull();
                    }
                    this.src = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture.postFire(a10, mode);
                }
            }
            return null;
        }
    }

    private CompletableFuture<Void> uniAcceptStage(Executor e2, Consumer<? super T> f10) {
        if (f10 == null) {
            throw new NullPointerException();
        }
        Object r10 = this.result;
        if (r10 != null) {
            return uniAcceptNow(r10, e2, f10);
        }
        CompletableFuture newIncompleteFuture = newIncompleteFuture();
        unipush(new UniAccept(e2, newIncompleteFuture, this, f10));
        return newIncompleteFuture;
    }

    private CompletableFuture<Void> uniAcceptNow(Object r10, Executor e2, Consumer<? super T> f10) {
        CompletableFuture newIncompleteFuture = newIncompleteFuture();
        if (r10 instanceof AltResult) {
            Throwable x10 = ((AltResult) r10).ex;
            if (x10 != null) {
                newIncompleteFuture.result = encodeThrowable(x10, r10);
                return newIncompleteFuture;
            }
            r10 = null;
        }
        try {
            if (e2 != null) {
                e2.execute(new UniAccept(null, newIncompleteFuture, this, f10));
            } else {
                f10.accept(r10);
                newIncompleteFuture.result = NIL;
            }
        } catch (Throwable ex) {
            newIncompleteFuture.result = encodeThrowable(ex);
        }
        return newIncompleteFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniRun<T> extends UniCompletion<T, Void> {
        Runnable fn;

        UniRun(Executor executor, CompletableFuture<Void> dep, CompletableFuture<T> src, Runnable fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<Void> tryFire(int mode) {
            Object r10;
            CompletableFuture<V> completableFuture;
            Runnable f10;
            Throwable x10;
            CompletableFuture<T> a10 = this.src;
            if (a10 == null || (r10 = a10.result) == null || (completableFuture = this.dep) == 0 || (f10 = this.fn) == null) {
                return null;
            }
            if (completableFuture.result == null) {
                if ((r10 instanceof AltResult) && (x10 = ((AltResult) r10).ex) != null) {
                    completableFuture.completeThrowable(x10, r10);
                } else {
                    if (mode <= 0) {
                        try {
                            if (!claim()) {
                                return null;
                            }
                        } catch (Throwable ex) {
                            completableFuture.completeThrowable(ex);
                        }
                    }
                    f10.run();
                    completableFuture.completeNull();
                }
            }
            this.src = null;
            this.dep = null;
            this.fn = null;
            return completableFuture.postFire(a10, mode);
        }
    }

    private CompletableFuture<Void> uniRunStage(Executor e2, Runnable f10) {
        if (f10 == null) {
            throw new NullPointerException();
        }
        Object r10 = this.result;
        if (r10 != null) {
            return uniRunNow(r10, e2, f10);
        }
        CompletableFuture newIncompleteFuture = newIncompleteFuture();
        unipush(new UniRun(e2, newIncompleteFuture, this, f10));
        return newIncompleteFuture;
    }

    private CompletableFuture<Void> uniRunNow(Object r10, Executor e2, Runnable f10) {
        Throwable x10;
        CompletableFuture newIncompleteFuture = newIncompleteFuture();
        if ((r10 instanceof AltResult) && (x10 = ((AltResult) r10).ex) != null) {
            newIncompleteFuture.result = encodeThrowable(x10, r10);
        } else {
            try {
                if (e2 != null) {
                    e2.execute(new UniRun(null, newIncompleteFuture, this, f10));
                } else {
                    f10.run();
                    newIncompleteFuture.result = NIL;
                }
            } catch (Throwable ex) {
                newIncompleteFuture.result = encodeThrowable(ex);
            }
        }
        return newIncompleteFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniWhenComplete<T> extends UniCompletion<T, T> {
        BiConsumer<? super T, ? super Throwable> fn;

        UniWhenComplete(Executor executor, CompletableFuture<T> dep, CompletableFuture<T> src, BiConsumer<? super T, ? super Throwable> fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<T> tryFire(int mode) {
            Object r10;
            CompletableFuture<V> completableFuture;
            BiConsumer<? super T, ? super Throwable> f10;
            CompletableFuture<T> a10 = this.src;
            if (a10 != null && (r10 = a10.result) != null && (completableFuture = this.dep) != 0 && (f10 = this.fn) != null) {
                if (completableFuture.uniWhenComplete(r10, f10, mode > 0 ? null : this)) {
                    this.src = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture.postFire(a10, mode);
                }
            }
            return null;
        }
    }

    final boolean uniWhenComplete(Object r10, BiConsumer<? super T, ? super Throwable> f10, UniWhenComplete<T> c4) {
        Object obj;
        Throwable x10 = null;
        if (this.result == null) {
            if (c4 != null) {
                try {
                    if (!c4.claim()) {
                        return false;
                    }
                } catch (Throwable ex) {
                    if (x10 == null) {
                        x10 = ex;
                    } else if (x10 != ex) {
                        x10.addSuppressed(ex);
                    }
                }
            }
            if (r10 instanceof AltResult) {
                x10 = ((AltResult) r10).ex;
                obj = null;
            } else {
                obj = r10;
            }
            f10.accept(obj, x10);
            if (x10 == null) {
                internalComplete(r10);
                return true;
            }
            completeThrowable(x10, r10);
        }
        return true;
    }

    private CompletableFuture<T> uniWhenCompleteStage(Executor executor, BiConsumer<? super T, ? super Throwable> biConsumer) {
        if (biConsumer == null) {
            throw new NullPointerException();
        }
        CompletableFuture<T> completableFuture = (CompletableFuture<T>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniWhenComplete(executor, completableFuture, this, biConsumer));
        } else if (executor == null) {
            completableFuture.uniWhenComplete(obj, biConsumer, null);
        } else {
            try {
                executor.execute(new UniWhenComplete(null, completableFuture, this, biConsumer));
            } catch (Throwable th) {
                completableFuture.result = encodeThrowable(th);
            }
        }
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniHandle<T, V> extends UniCompletion<T, V> {
        BiFunction<? super T, Throwable, ? extends V> fn;

        UniHandle(Executor executor, CompletableFuture<V> dep, CompletableFuture<T> src, BiFunction<? super T, Throwable, ? extends V> fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int i10) {
            Object obj;
            CompletableFuture<V> completableFuture;
            BiFunction<? super T, Throwable, ? extends V> biFunction;
            CompletableFuture<T> completableFuture2 = this.src;
            if (completableFuture2 != null && (obj = completableFuture2.result) != null && (completableFuture = this.dep) != null && (biFunction = this.fn) != null) {
                if (completableFuture.uniHandle(obj, biFunction, i10 > 0 ? null : this)) {
                    this.src = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture.postFire(completableFuture2, i10);
                }
            }
            return null;
        }
    }

    final <S> boolean uniHandle(Object r10, BiFunction<? super S, Throwable, ? extends T> f10, UniHandle<S, T> c4) {
        Throwable x10;
        Object obj;
        if (this.result == null) {
            if (c4 != null) {
                try {
                    if (!c4.claim()) {
                        return false;
                    }
                } catch (Throwable ex) {
                    completeThrowable(ex);
                    return true;
                }
            }
            if (r10 instanceof AltResult) {
                x10 = ((AltResult) r10).ex;
                obj = null;
            } else {
                x10 = null;
                obj = r10;
            }
            completeValue(f10.apply(obj, x10));
            return true;
        }
        return true;
    }

    private <V> CompletableFuture<V> uniHandleStage(Executor executor, BiFunction<? super T, Throwable, ? extends V> biFunction) {
        if (biFunction == null) {
            throw new NullPointerException();
        }
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniHandle(executor, completableFuture, this, biFunction));
        } else if (executor == null) {
            completableFuture.uniHandle(obj, biFunction, null);
        } else {
            try {
                executor.execute(new UniHandle(null, completableFuture, this, biFunction));
            } catch (Throwable th) {
                completableFuture.result = encodeThrowable(th);
            }
        }
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniExceptionally<T> extends UniCompletion<T, T> {
        Function<? super Throwable, ? extends T> fn;

        UniExceptionally(Executor executor, CompletableFuture<T> dep, CompletableFuture<T> src, Function<? super Throwable, ? extends T> fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<T> tryFire(int mode) {
            Object r10;
            CompletableFuture<V> completableFuture;
            Function<? super Throwable, ? extends T> f10;
            CompletableFuture<T> a10 = this.src;
            if (a10 != null && (r10 = a10.result) != null && (completableFuture = this.dep) != 0 && (f10 = this.fn) != null) {
                if (completableFuture.uniExceptionally(r10, f10, mode > 0 ? null : this)) {
                    this.src = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture.postFire(a10, mode);
                }
            }
            return null;
        }
    }

    final boolean uniExceptionally(Object r10, Function<? super Throwable, ? extends T> f10, UniExceptionally<T> c4) {
        Throwable x10;
        if (this.result == null) {
            if (c4 != null) {
                try {
                    if (!c4.claim()) {
                        return false;
                    }
                } catch (Throwable ex) {
                    completeThrowable(ex);
                    return true;
                }
            }
            if ((r10 instanceof AltResult) && (x10 = ((AltResult) r10).ex) != null) {
                completeValue(f10.apply(x10));
                return true;
            }
            internalComplete(r10);
            return true;
        }
        return true;
    }

    private CompletableFuture<T> uniExceptionallyStage(Executor executor, Function<Throwable, ? extends T> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        CompletableFuture<T> completableFuture = (CompletableFuture<T>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniExceptionally(executor, completableFuture, this, function));
        } else if (executor == null) {
            completableFuture.uniExceptionally(obj, function, null);
        } else {
            try {
                executor.execute(new UniExceptionally(null, completableFuture, this, function));
            } catch (Throwable th) {
                completableFuture.result = encodeThrowable(th);
            }
        }
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniComposeExceptionally<T> extends UniCompletion<T, T> {
        Function<Throwable, ? extends CompletionStage<T>> fn;

        UniComposeExceptionally(Executor executor, CompletableFuture<T> dep, CompletableFuture<T> src, Function<Throwable, ? extends CompletionStage<T>> fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<T> tryFire(int mode) {
            Object r10;
            CompletableFuture<V> completableFuture;
            Function<Throwable, ? extends CompletionStage<T>> f10;
            Throwable x10;
            CompletableFuture<T> a10 = this.src;
            if (a10 == null || (r10 = a10.result) == null || (completableFuture = this.dep) == 0 || (f10 = this.fn) == null) {
                return null;
            }
            if (completableFuture.result == null) {
                if ((r10 instanceof AltResult) && (x10 = ((AltResult) r10).ex) != null) {
                    if (mode <= 0) {
                        try {
                            if (!claim()) {
                                return null;
                            }
                        } catch (Throwable ex) {
                            completableFuture.completeThrowable(ex);
                        }
                    }
                    CompletableFuture<T> g3 = f10.apply(x10).toCompletableFuture();
                    Object r11 = g3.result;
                    if (r11 != null) {
                        completableFuture.completeRelay(r11);
                    } else {
                        g3.unipush(new UniRelay(completableFuture, g3));
                        if (completableFuture.result == null) {
                            return null;
                        }
                    }
                } else {
                    completableFuture.internalComplete(r10);
                }
            }
            this.src = null;
            this.dep = null;
            this.fn = null;
            return completableFuture.postFire(a10, mode);
        }
    }

    private CompletableFuture<T> uniComposeExceptionallyStage(Executor executor, Function<Throwable, ? extends CompletionStage<T>> function) {
        Throwable th;
        if (function == null) {
            throw new NullPointerException();
        }
        CompletableFuture<T> completableFuture = (CompletableFuture<T>) newIncompleteFuture();
        Object obj = this.result;
        if (obj == null) {
            unipush(new UniComposeExceptionally(executor, completableFuture, this, function));
        } else if (!(obj instanceof AltResult) || (th = ((AltResult) obj).ex) == null) {
            completableFuture.internalComplete(obj);
        } else {
            try {
                if (executor != null) {
                    executor.execute(new UniComposeExceptionally(null, completableFuture, this, function));
                } else {
                    CompletableFuture<T> completableFuture2 = function.apply(th).toCompletableFuture();
                    Object obj2 = completableFuture2.result;
                    if (obj2 != null) {
                        completableFuture.result = encodeRelay(obj2);
                    } else {
                        completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
                    }
                }
            } catch (Throwable th2) {
                completableFuture.result = encodeThrowable(th2);
            }
        }
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniRelay<U, T extends U> extends UniCompletion<T, U> {
        UniRelay(CompletableFuture<U> dep, CompletableFuture<T> src) {
            super(null, dep, src);
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<U> tryFire(int mode) {
            Object r10;
            CompletableFuture<V> completableFuture;
            CompletableFuture<T> completableFuture2 = this.src;
            if (completableFuture2 == null || (r10 = completableFuture2.result) == null || (completableFuture = this.dep) == 0) {
                return null;
            }
            if (completableFuture.result == null) {
                completableFuture.completeRelay(r10);
            }
            this.src = null;
            this.dep = null;
            return completableFuture.postFire(completableFuture2, mode);
        }
    }

    private static <U, T extends U> CompletableFuture<U> uniCopyStage(CompletableFuture<T> src) {
        CompletableFuture<U> d10 = src.newIncompleteFuture();
        Object r10 = src.result;
        if (r10 != null) {
            d10.result = encodeRelay(r10);
        } else {
            src.unipush(new UniRelay(d10, src));
        }
        return d10;
    }

    private MinimalStage<T> uniAsMinimalStage() {
        Object r10 = this.result;
        if (r10 != null) {
            return new MinimalStage<>(encodeRelay(r10));
        }
        MinimalStage<T> d10 = new MinimalStage<>();
        unipush(new UniRelay(d10, this));
        return d10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class UniCompose<T, V> extends UniCompletion<T, V> {
        Function<? super T, ? extends CompletionStage<V>> fn;

        UniCompose(Executor executor, CompletableFuture<V> dep, CompletableFuture<T> src, Function<? super T, ? extends CompletionStage<V>> fn) {
            super(executor, dep, src);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int mode) {
            CompletableFuture<V> d10;
            Function<? super T, ? extends CompletionStage<V>> f10;
            CompletableFuture<T> a10 = this.src;
            if (a10 != null) {
                Object obj = a10.result;
                Object r10 = obj;
                if (obj != null && (d10 = this.dep) != null && (f10 = this.fn) != null) {
                    if (d10.result == null) {
                        if (r10 instanceof AltResult) {
                            Throwable x10 = ((AltResult) r10).ex;
                            if (x10 != null) {
                                d10.completeThrowable(x10, r10);
                            } else {
                                r10 = null;
                            }
                        }
                        if (mode <= 0) {
                            try {
                                if (!claim()) {
                                    return null;
                                }
                            } catch (Throwable ex) {
                                d10.completeThrowable(ex);
                            }
                        }
                        CompletableFuture<V> g3 = f10.apply(r10).toCompletableFuture();
                        Object r11 = g3.result;
                        if (r11 != null) {
                            d10.completeRelay(r11);
                        } else {
                            g3.unipush(new UniRelay(d10, g3));
                            if (d10.result == null) {
                                return null;
                            }
                        }
                    }
                    this.src = null;
                    this.dep = null;
                    this.fn = null;
                    return d10.postFire(a10, mode);
                }
            }
            return null;
        }
    }

    private <V> CompletableFuture<V> uniComposeStage(Executor executor, Function<? super T, ? extends CompletionStage<V>> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        CompletableFuture<V> completableFuture = (CompletableFuture<V>) newIncompleteFuture();
        Object obj = this.result;
        Object obj2 = obj;
        if (obj == null) {
            unipush(new UniCompose(executor, completableFuture, this, function));
        } else {
            if (obj2 instanceof AltResult) {
                Throwable th = ((AltResult) obj2).ex;
                if (th != null) {
                    completableFuture.result = encodeThrowable(th, obj2);
                    return completableFuture;
                }
                obj2 = null;
            }
            try {
                if (executor != null) {
                    executor.execute(new UniCompose(null, completableFuture, this, function));
                } else {
                    CompletableFuture<V> completableFuture2 = function.apply(obj2).toCompletableFuture();
                    Object obj3 = completableFuture2.result;
                    if (obj3 != null) {
                        completableFuture.result = encodeRelay(obj3);
                    } else {
                        completableFuture2.unipush(new UniRelay(completableFuture, completableFuture2));
                    }
                }
            } catch (Throwable th2) {
                completableFuture.result = encodeThrowable(th2);
            }
        }
        return completableFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class BiCompletion<T, U, V> extends UniCompletion<T, V> {
        CompletableFuture<U> snd;

        BiCompletion(Executor executor, CompletableFuture<V> dep, CompletableFuture<T> src, CompletableFuture<U> snd) {
            super(executor, dep, src);
            this.snd = snd;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CoCompletion extends Completion {
        BiCompletion<?, ?, ?> base;

        CoCompletion(BiCompletion<?, ?, ?> base) {
            this.base = base;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<?> tryFire(int mode) {
            CompletableFuture<?> d10;
            BiCompletion<?, ?, ?> c4 = this.base;
            if (c4 == null || (d10 = c4.tryFire(mode)) == null) {
                return null;
            }
            this.base = null;
            return d10;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            BiCompletion<?, ?, ?> c4 = this.base;
            return (c4 == null || c4.dep == null) ? false : true;
        }
    }

    final void bipush(CompletableFuture<?> b4, BiCompletion<?, ?, ?> c4) {
        if (c4 == null) {
            return;
        }
        while (this.result == null) {
            if (tryPushStack(c4)) {
                if (b4.result == null) {
                    b4.unipush(new CoCompletion(c4));
                    return;
                } else {
                    if (this.result != null) {
                        c4.tryFire(0);
                        return;
                    }
                    return;
                }
            }
        }
        b4.unipush(c4);
    }

    final CompletableFuture<T> postFire(CompletableFuture<?> a10, CompletableFuture<?> b4, int mode) {
        if (b4 != null && b4.stack != null) {
            Object r10 = b4.result;
            if (r10 == null) {
                b4.cleanStack();
            }
            if (mode >= 0 && (r10 != null || b4.result != null)) {
                b4.postComplete();
            }
        }
        return postFire(a10, mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class BiApply<T, U, V> extends BiCompletion<T, U, V> {
        BiFunction<? super T, ? super U, ? extends V> fn;

        BiApply(Executor executor, CompletableFuture<V> dep, CompletableFuture<T> src, CompletableFuture<U> snd, BiFunction<? super T, ? super U, ? extends V> fn) {
            super(executor, dep, src, snd);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<V> tryFire(int i10) {
            Object obj;
            CompletableFuture<U> completableFuture;
            Object obj2;
            CompletableFuture<V> completableFuture2;
            BiFunction<? super T, ? super U, ? extends V> biFunction;
            CompletableFuture<T> completableFuture3 = this.src;
            if (completableFuture3 != null && (obj = completableFuture3.result) != null && (completableFuture = this.snd) != null && (obj2 = completableFuture.result) != null && (completableFuture2 = this.dep) != null && (biFunction = this.fn) != null) {
                if (completableFuture2.biApply(obj, obj2, biFunction, i10 > 0 ? null : this)) {
                    this.src = null;
                    this.snd = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture2.postFire(completableFuture3, completableFuture, i10);
                }
            }
            return null;
        }
    }

    final <R, S> boolean biApply(Object r10, Object s2, BiFunction<? super R, ? super S, ? extends T> f10, BiApply<R, S, T> c4) {
        if (this.result == null) {
            if (r10 instanceof AltResult) {
                Throwable x10 = ((AltResult) r10).ex;
                if (x10 != null) {
                    completeThrowable(x10, r10);
                    return true;
                }
                r10 = null;
            }
            if (s2 instanceof AltResult) {
                Throwable x11 = ((AltResult) s2).ex;
                if (x11 != null) {
                    completeThrowable(x11, s2);
                    return true;
                }
                s2 = null;
            }
            if (c4 != null) {
                try {
                    if (!c4.claim()) {
                        return false;
                    }
                } catch (Throwable ex) {
                    completeThrowable(ex);
                    return true;
                }
            }
            completeValue(f10.apply(r10, s2));
            return true;
        }
        return true;
    }

    private <U, V> CompletableFuture<V> biApplyStage(Executor executor, CompletionStage<U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        CompletableFuture<U> completableFuture;
        Object obj;
        if (biFunction == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw new NullPointerException();
        }
        CompletableFuture<U> newIncompleteFuture = newIncompleteFuture();
        Object obj2 = this.result;
        if (obj2 == null || (obj = completableFuture.result) == null) {
            bipush(completableFuture, new BiApply(executor, newIncompleteFuture, this, completableFuture, biFunction));
        } else if (executor == null) {
            newIncompleteFuture.biApply(obj2, obj, biFunction, null);
        } else {
            try {
                executor.execute(new BiApply(null, newIncompleteFuture, this, completableFuture, biFunction));
            } catch (Throwable th) {
                newIncompleteFuture.result = encodeThrowable(th);
            }
        }
        return newIncompleteFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class BiAccept<T, U> extends BiCompletion<T, U, Void> {
        BiConsumer<? super T, ? super U> fn;

        BiAccept(Executor executor, CompletableFuture<Void> dep, CompletableFuture<T> src, CompletableFuture<U> snd, BiConsumer<? super T, ? super U> fn) {
            super(executor, dep, src, snd);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<Void> tryFire(int mode) {
            Object r10;
            CompletableFuture<U> b4;
            Object s2;
            CompletableFuture<V> completableFuture;
            BiConsumer<? super T, ? super U> f10;
            CompletableFuture<T> a10 = this.src;
            if (a10 != null && (r10 = a10.result) != null && (b4 = this.snd) != null && (s2 = b4.result) != null && (completableFuture = this.dep) != 0 && (f10 = this.fn) != null) {
                if (completableFuture.biAccept(r10, s2, f10, mode > 0 ? null : this)) {
                    this.src = null;
                    this.snd = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture.postFire(a10, b4, mode);
                }
            }
            return null;
        }
    }

    final <R, S> boolean biAccept(Object r10, Object s2, BiConsumer<? super R, ? super S> f10, BiAccept<R, S> c4) {
        if (this.result == null) {
            if (r10 instanceof AltResult) {
                Throwable x10 = ((AltResult) r10).ex;
                if (x10 != null) {
                    completeThrowable(x10, r10);
                    return true;
                }
                r10 = null;
            }
            if (s2 instanceof AltResult) {
                Throwable x11 = ((AltResult) s2).ex;
                if (x11 != null) {
                    completeThrowable(x11, s2);
                    return true;
                }
                s2 = null;
            }
            if (c4 != null) {
                try {
                    if (!c4.claim()) {
                        return false;
                    }
                } catch (Throwable ex) {
                    completeThrowable(ex);
                    return true;
                }
            }
            f10.accept(r10, s2);
            completeNull();
            return true;
        }
        return true;
    }

    private <U> CompletableFuture<Void> biAcceptStage(Executor executor, CompletionStage<U> completionStage, BiConsumer<? super T, ? super U> biConsumer) {
        CompletableFuture<U> completableFuture;
        Object obj;
        if (biConsumer == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw new NullPointerException();
        }
        CompletableFuture<U> newIncompleteFuture = newIncompleteFuture();
        Object obj2 = this.result;
        if (obj2 == null || (obj = completableFuture.result) == null) {
            bipush(completableFuture, new BiAccept(executor, newIncompleteFuture, this, completableFuture, biConsumer));
        } else if (executor == null) {
            newIncompleteFuture.biAccept(obj2, obj, biConsumer, null);
        } else {
            try {
                executor.execute(new BiAccept(null, newIncompleteFuture, this, completableFuture, biConsumer));
            } catch (Throwable th) {
                newIncompleteFuture.result = encodeThrowable(th);
            }
        }
        return newIncompleteFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class BiRun<T, U> extends BiCompletion<T, U, Void> {
        Runnable fn;

        BiRun(Executor executor, CompletableFuture<Void> dep, CompletableFuture<T> src, CompletableFuture<U> snd, Runnable fn) {
            super(executor, dep, src, snd);
            this.fn = fn;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<Void> tryFire(int mode) {
            Object r10;
            CompletableFuture<U> b4;
            Object s2;
            CompletableFuture<V> completableFuture;
            Runnable f10;
            CompletableFuture<T> a10 = this.src;
            if (a10 != null && (r10 = a10.result) != null && (b4 = this.snd) != null && (s2 = b4.result) != null && (completableFuture = this.dep) != 0 && (f10 = this.fn) != null) {
                if (completableFuture.biRun(r10, s2, f10, mode > 0 ? null : this)) {
                    this.src = null;
                    this.snd = null;
                    this.dep = null;
                    this.fn = null;
                    return completableFuture.postFire(a10, b4, mode);
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if (r1 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        completeThrowable(r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean biRun(java.lang.Object r4, java.lang.Object r5, java.lang.Runnable r6, java.util.concurrent.CompletableFuture.BiRun<?, ?> r7) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.result
            if (r0 != 0) goto L37
            boolean r0 = r4 instanceof java.util.concurrent.CompletableFuture.AltResult
            if (r0 == 0) goto L11
            r0 = r4
            r1 = r4
            java.util.concurrent.CompletableFuture$AltResult r1 = (java.util.concurrent.CompletableFuture.AltResult) r1
            java.lang.Throwable r1 = r1.ex
            r2 = r1
            if (r1 != 0) goto L1e
        L11:
            boolean r0 = r5 instanceof java.util.concurrent.CompletableFuture.AltResult
            if (r0 == 0) goto L22
            r0 = r5
            r1 = r5
            java.util.concurrent.CompletableFuture$AltResult r1 = (java.util.concurrent.CompletableFuture.AltResult) r1
            java.lang.Throwable r1 = r1.ex
            r2 = r1
            if (r1 == 0) goto L22
        L1e:
            r3.completeThrowable(r2, r0)
            goto L37
        L22:
            if (r7 == 0) goto L2c
            boolean r0 = r7.claim()     // Catch: java.lang.Throwable -> L33
            if (r0 != 0) goto L2c
            r0 = 0
            return r0
        L2c:
            r6.run()     // Catch: java.lang.Throwable -> L33
            r3.completeNull()     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r0 = move-exception
            r3.completeThrowable(r0)
        L37:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.CompletableFuture.biRun(java.lang.Object, java.lang.Object, java.lang.Runnable, java.util.concurrent.CompletableFuture$BiRun):boolean");
    }

    private CompletableFuture<Void> biRunStage(Executor e2, CompletionStage<?> o10, Runnable f10) {
        CompletableFuture<?> b4;
        Object s2;
        if (f10 == null || (b4 = o10.toCompletableFuture()) == null) {
            throw new NullPointerException();
        }
        CompletableFuture newIncompleteFuture = newIncompleteFuture();
        Object r10 = this.result;
        if (r10 == null || (s2 = b4.result) == null) {
            bipush(b4, new BiRun(e2, newIncompleteFuture, this, b4, f10));
        } else if (e2 == null) {
            newIncompleteFuture.biRun(r10, s2, f10, null);
        } else {
            try {
                e2.execute(new BiRun(null, newIncompleteFuture, this, b4, f10));
            } catch (Throwable ex) {
                newIncompleteFuture.result = encodeThrowable(ex);
            }
        }
        return newIncompleteFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class BiRelay<T, U> extends BiCompletion<T, U, Void> {
        BiRelay(CompletableFuture<Void> dep, CompletableFuture<T> src, CompletableFuture<U> snd) {
            super(null, dep, src, snd);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        
            if (r7 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        
            r0.completeThrowable(r8, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        
            if (r7 != null) goto L23;
         */
        @Override // java.util.concurrent.CompletableFuture.Completion
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r10) {
            /*
                r9 = this;
                java.util.concurrent.CompletableFuture<T> r0 = r9.src
                r1 = r0
                r2 = 0
                if (r0 == 0) goto L4b
                java.lang.Object r0 = r1.result
                r3 = r0
                if (r0 == 0) goto L4b
                java.util.concurrent.CompletableFuture<U> r0 = r9.snd
                r4 = r0
                if (r0 == 0) goto L4b
                java.lang.Object r0 = r4.result
                r5 = r0
                if (r0 == 0) goto L4b
                java.util.concurrent.CompletableFuture<V> r0 = r9.dep
                r6 = r0
                if (r0 != 0) goto L1b
                goto L4b
            L1b:
                java.lang.Object r0 = r6.result
                if (r0 != 0) goto L40
                boolean r0 = r3 instanceof java.util.concurrent.CompletableFuture.AltResult
                if (r0 == 0) goto L2c
                r0 = r3
                r7 = r3
                java.util.concurrent.CompletableFuture$AltResult r7 = (java.util.concurrent.CompletableFuture.AltResult) r7
                java.lang.Throwable r7 = r7.ex
                r8 = r7
                if (r7 != 0) goto L39
            L2c:
                boolean r0 = r5 instanceof java.util.concurrent.CompletableFuture.AltResult
                if (r0 == 0) goto L3d
                r0 = r5
                r7 = r5
                java.util.concurrent.CompletableFuture$AltResult r7 = (java.util.concurrent.CompletableFuture.AltResult) r7
                java.lang.Throwable r7 = r7.ex
                r8 = r7
                if (r7 == 0) goto L3d
            L39:
                r6.completeThrowable(r8, r0)
                goto L40
            L3d:
                r6.completeNull()
            L40:
                r9.src = r2
                r9.snd = r2
                r9.dep = r2
                java.util.concurrent.CompletableFuture r0 = r6.postFire(r1, r4, r10)
                return r0
            L4b:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.CompletableFuture.BiRelay.tryFire(int):java.util.concurrent.CompletableFuture");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        if (r7 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        r0.result = encodeThrowable(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        if (r7 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.concurrent.CompletableFuture<java.lang.Void> andTree(java.util.concurrent.CompletableFuture<?>[] r9, int r10, int r11) {
        /*
            java.util.concurrent.CompletableFuture r0 = new java.util.concurrent.CompletableFuture
            r0.<init>()
            if (r10 <= r11) goto Ld
            java.util.concurrent.CompletableFuture$AltResult r1 = java.util.concurrent.CompletableFuture.NIL
            r0.result = r1
            goto L6a
        Ld:
            int r1 = r10 + r11
            int r1 = r1 >>> 1
            if (r10 != r1) goto L16
            r2 = r9[r10]
            goto L1a
        L16:
            java.util.concurrent.CompletableFuture r2 = andTree(r9, r10, r1)
        L1a:
            r3 = r2
            if (r2 == 0) goto L6b
            if (r10 != r11) goto L21
            r2 = r3
            goto L2e
        L21:
            int r2 = r1 + 1
            if (r11 != r2) goto L28
            r2 = r9[r11]
            goto L2e
        L28:
            int r2 = r1 + 1
            java.util.concurrent.CompletableFuture r2 = andTree(r9, r2, r11)
        L2e:
            r4 = r2
            if (r2 == 0) goto L6b
            java.lang.Object r2 = r3.result
            r5 = r2
            if (r2 == 0) goto L62
            java.lang.Object r2 = r4.result
            r6 = r2
            if (r2 != 0) goto L3c
            goto L62
        L3c:
            boolean r2 = r5 instanceof java.util.concurrent.CompletableFuture.AltResult
            if (r2 == 0) goto L49
            r2 = r5
            r7 = r5
            java.util.concurrent.CompletableFuture$AltResult r7 = (java.util.concurrent.CompletableFuture.AltResult) r7
            java.lang.Throwable r7 = r7.ex
            r8 = r7
            if (r7 != 0) goto L56
        L49:
            boolean r2 = r6 instanceof java.util.concurrent.CompletableFuture.AltResult
            if (r2 == 0) goto L5d
            r2 = r6
            r7 = r6
            java.util.concurrent.CompletableFuture$AltResult r7 = (java.util.concurrent.CompletableFuture.AltResult) r7
            java.lang.Throwable r7 = r7.ex
            r8 = r7
            if (r7 == 0) goto L5d
        L56:
            java.lang.Object r7 = encodeThrowable(r8, r2)
            r0.result = r7
            goto L6a
        L5d:
            java.util.concurrent.CompletableFuture$AltResult r2 = java.util.concurrent.CompletableFuture.NIL
            r0.result = r2
            goto L6a
        L62:
            java.util.concurrent.CompletableFuture$BiRelay r2 = new java.util.concurrent.CompletableFuture$BiRelay
            r2.<init>(r0, r3, r4)
            r3.bipush(r4, r2)
        L6a:
            return r0
        L6b:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.CompletableFuture.andTree(java.util.concurrent.CompletableFuture[], int, int):java.util.concurrent.CompletableFuture");
    }

    final void orpush(CompletableFuture<?> b4, BiCompletion<?, ?, ?> c4) {
        if (c4 == null) {
            return;
        }
        while (true) {
            if (tryPushStack(c4)) {
                break;
            } else if (this.result != null) {
                (void) NEXT.set(c4, null);
                break;
            }
        }
        if (this.result != null) {
            c4.tryFire(0);
        } else {
            b4.unipush(new CoCompletion(c4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OrApply<T, U extends T, V> extends BiCompletion<T, U, V> {
        Function<? super T, ? extends V> fn;

        OrApply(Executor executor, CompletableFuture<V> dep, CompletableFuture<T> src, CompletableFuture<U> snd, Function<? super T, ? extends V> fn) {
            super(executor, dep, src, snd);
            this.fn = fn;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        
            if (r0 != null) goto L10;
         */
        @Override // java.util.concurrent.CompletableFuture.Completion
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.CompletableFuture<V> tryFire(int r9) {
            /*
                r8 = this;
                java.util.concurrent.CompletableFuture<T> r0 = r8.src
                r1 = r0
                r2 = 0
                if (r0 == 0) goto L59
                java.util.concurrent.CompletableFuture<U> r0 = r8.snd
                r3 = r0
                if (r0 == 0) goto L59
                java.lang.Object r0 = r1.result
                r4 = r0
                if (r0 != 0) goto L15
                java.lang.Object r0 = r3.result
                r4 = r0
                if (r0 == 0) goto L59
            L15:
                java.util.concurrent.CompletableFuture<V> r0 = r8.dep
                r5 = r0
                if (r0 == 0) goto L59
                java.util.function.Function<? super T, ? extends V> r0 = r8.fn
                r6 = r0
                if (r0 != 0) goto L20
                goto L59
            L20:
                java.lang.Object r0 = r5.result
                if (r0 != 0) goto L4c
                if (r9 > 0) goto L2d
                boolean r0 = r8.claim()     // Catch: java.lang.Throwable -> L48
                if (r0 != 0) goto L2d
                return r2
            L2d:
                boolean r0 = r4 instanceof java.util.concurrent.CompletableFuture.AltResult     // Catch: java.lang.Throwable -> L48
                if (r0 == 0) goto L3e
                r0 = r4
                java.util.concurrent.CompletableFuture$AltResult r0 = (java.util.concurrent.CompletableFuture.AltResult) r0     // Catch: java.lang.Throwable -> L48
                java.lang.Throwable r0 = r0.ex     // Catch: java.lang.Throwable -> L48
                r7 = r0
                if (r0 == 0) goto L3d
                r5.completeThrowable(r7, r4)     // Catch: java.lang.Throwable -> L48
                goto L4c
            L3d:
                r4 = 0
            L3e:
                r0 = r4
                java.lang.Object r7 = r6.apply(r0)     // Catch: java.lang.Throwable -> L48
                r5.completeValue(r7)     // Catch: java.lang.Throwable -> L48
                goto L4c
            L48:
                r0 = move-exception
                r5.completeThrowable(r0)
            L4c:
                r8.src = r2
                r8.snd = r2
                r8.dep = r2
                r8.fn = r2
                java.util.concurrent.CompletableFuture r0 = r5.postFire(r1, r3, r9)
                return r0
            L59:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.CompletableFuture.OrApply.tryFire(int):java.util.concurrent.CompletableFuture");
        }
    }

    private <U extends T, V> CompletableFuture<V> orApplyStage(Executor executor, CompletionStage<U> completionStage, Function<? super T, ? extends V> function) {
        CompletableFuture<U> completableFuture;
        if (function == null || (completableFuture = completionStage.toCompletableFuture()) == null) {
            throw new NullPointerException();
        }
        CompletableFuture completableFuture2 = this;
        Object obj = this.result;
        Object obj2 = obj;
        if (obj == null) {
            completableFuture2 = completableFuture;
            Object obj3 = completableFuture.result;
            if (obj3 == null) {
                CompletableFuture<V> completableFuture3 = (CompletableFuture<V>) newIncompleteFuture();
                orpush(completableFuture, new OrApply(executor, completableFuture3, this, completableFuture, function));
                return completableFuture3;
            }
            obj2 = obj3;
        }
        return completableFuture2.uniApplyNow(obj2, executor, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OrAccept<T, U extends T> extends BiCompletion<T, U, Void> {
        Consumer<? super T> fn;

        OrAccept(Executor executor, CompletableFuture<Void> dep, CompletableFuture<T> src, CompletableFuture<U> snd, Consumer<? super T> fn) {
            super(executor, dep, src, snd);
            this.fn = fn;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        
            if (r0 != null) goto L10;
         */
        @Override // java.util.concurrent.CompletableFuture.Completion
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r9) {
            /*
                r8 = this;
                java.util.concurrent.CompletableFuture<T> r0 = r8.src
                r1 = r0
                r2 = 0
                if (r0 == 0) goto L58
                java.util.concurrent.CompletableFuture<U> r0 = r8.snd
                r3 = r0
                if (r0 == 0) goto L58
                java.lang.Object r0 = r1.result
                r4 = r0
                if (r0 != 0) goto L15
                java.lang.Object r0 = r3.result
                r4 = r0
                if (r0 == 0) goto L58
            L15:
                java.util.concurrent.CompletableFuture<V> r0 = r8.dep
                r5 = r0
                if (r0 == 0) goto L58
                java.util.function.Consumer<? super T> r0 = r8.fn
                r6 = r0
                if (r0 != 0) goto L20
                goto L58
            L20:
                java.lang.Object r0 = r5.result
                if (r0 != 0) goto L4b
                if (r9 > 0) goto L2d
                boolean r0 = r8.claim()     // Catch: java.lang.Throwable -> L47
                if (r0 != 0) goto L2d
                return r2
            L2d:
                boolean r0 = r4 instanceof java.util.concurrent.CompletableFuture.AltResult     // Catch: java.lang.Throwable -> L47
                if (r0 == 0) goto L3e
                r0 = r4
                java.util.concurrent.CompletableFuture$AltResult r0 = (java.util.concurrent.CompletableFuture.AltResult) r0     // Catch: java.lang.Throwable -> L47
                java.lang.Throwable r0 = r0.ex     // Catch: java.lang.Throwable -> L47
                r7 = r0
                if (r0 == 0) goto L3d
                r5.completeThrowable(r7, r4)     // Catch: java.lang.Throwable -> L47
                goto L4b
            L3d:
                r4 = 0
            L3e:
                r0 = r4
                r6.accept(r0)     // Catch: java.lang.Throwable -> L47
                r5.completeNull()     // Catch: java.lang.Throwable -> L47
                goto L4b
            L47:
                r0 = move-exception
                r5.completeThrowable(r0)
            L4b:
                r8.src = r2
                r8.snd = r2
                r8.dep = r2
                r8.fn = r2
                java.util.concurrent.CompletableFuture r0 = r5.postFire(r1, r3, r9)
                return r0
            L58:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.CompletableFuture.OrAccept.tryFire(int):java.util.concurrent.CompletableFuture");
        }
    }

    private <U extends T> CompletableFuture<Void> orAcceptStage(Executor e2, CompletionStage<U> o10, Consumer<? super T> f10) {
        CompletableFuture<T> completableFuture;
        if (f10 == null || (completableFuture = o10.toCompletableFuture()) == null) {
            throw new NullPointerException();
        }
        CompletableFuture<T> completableFuture2 = this;
        Object obj = this.result;
        Object r10 = obj;
        if (obj == null) {
            completableFuture2 = completableFuture;
            Object r11 = completableFuture.result;
            if (r11 == null) {
                CompletableFuture newIncompleteFuture = newIncompleteFuture();
                orpush(completableFuture, new OrAccept(e2, newIncompleteFuture, this, completableFuture, f10));
                return newIncompleteFuture;
            }
            r10 = r11;
        }
        return completableFuture2.uniAcceptNow(r10, e2, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OrRun<T, U> extends BiCompletion<T, U, Void> {
        Runnable fn;

        OrRun(Executor executor, CompletableFuture<Void> dep, CompletableFuture<T> src, CompletableFuture<U> snd, Runnable fn) {
            super(executor, dep, src, snd);
            this.fn = fn;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        
            if (r0 != null) goto L10;
         */
        @Override // java.util.concurrent.CompletableFuture.Completion
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.CompletableFuture<java.lang.Void> tryFire(int r9) {
            /*
                r8 = this;
                java.util.concurrent.CompletableFuture<T> r0 = r8.src
                r1 = r0
                r2 = 0
                if (r0 == 0) goto L55
                java.util.concurrent.CompletableFuture<U> r0 = r8.snd
                r3 = r0
                if (r0 == 0) goto L55
                java.lang.Object r0 = r1.result
                r4 = r0
                if (r0 != 0) goto L15
                java.lang.Object r0 = r3.result
                r4 = r0
                if (r0 == 0) goto L55
            L15:
                java.util.concurrent.CompletableFuture<V> r0 = r8.dep
                r5 = r0
                if (r0 == 0) goto L55
                java.lang.Runnable r0 = r8.fn
                r6 = r0
                if (r0 != 0) goto L20
                goto L55
            L20:
                java.lang.Object r0 = r5.result
                if (r0 != 0) goto L48
                if (r9 > 0) goto L2d
                boolean r0 = r8.claim()     // Catch: java.lang.Throwable -> L44
                if (r0 != 0) goto L2d
                return r2
            L2d:
                boolean r0 = r4 instanceof java.util.concurrent.CompletableFuture.AltResult     // Catch: java.lang.Throwable -> L44
                if (r0 == 0) goto L3d
                r0 = r4
                java.util.concurrent.CompletableFuture$AltResult r0 = (java.util.concurrent.CompletableFuture.AltResult) r0     // Catch: java.lang.Throwable -> L44
                java.lang.Throwable r0 = r0.ex     // Catch: java.lang.Throwable -> L44
                r7 = r0
                if (r0 == 0) goto L3d
                r5.completeThrowable(r7, r4)     // Catch: java.lang.Throwable -> L44
                goto L43
            L3d:
                r6.run()     // Catch: java.lang.Throwable -> L44
                r5.completeNull()     // Catch: java.lang.Throwable -> L44
            L43:
                goto L48
            L44:
                r0 = move-exception
                r5.completeThrowable(r0)
            L48:
                r8.src = r2
                r8.snd = r2
                r8.dep = r2
                r8.fn = r2
                java.util.concurrent.CompletableFuture r0 = r5.postFire(r1, r3, r9)
                return r0
            L55:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.CompletableFuture.OrRun.tryFire(int):java.util.concurrent.CompletableFuture");
        }
    }

    private CompletableFuture<Void> orRunStage(Executor e2, CompletionStage<?> o10, Runnable f10) {
        CompletableFuture<T> completableFuture;
        if (f10 == null || (completableFuture = o10.toCompletableFuture()) == null) {
            throw new NullPointerException();
        }
        CompletableFuture<T> completableFuture2 = this;
        Object obj = this.result;
        Object r10 = obj;
        if (obj == null) {
            completableFuture2 = completableFuture;
            Object r11 = completableFuture.result;
            if (r11 == null) {
                CompletableFuture newIncompleteFuture = newIncompleteFuture();
                orpush(completableFuture, new OrRun(e2, newIncompleteFuture, this, completableFuture, f10));
                return newIncompleteFuture;
            }
            r10 = r11;
        }
        return completableFuture2.uniRunNow(r10, e2, f10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class AnyOf extends Completion {
        CompletableFuture<Object> dep;
        CompletableFuture<?> src;
        CompletableFuture<?>[] srcs;

        AnyOf(CompletableFuture<Object> dep, CompletableFuture<?> src, CompletableFuture<?>[] srcs) {
            this.dep = dep;
            this.src = src;
            this.srcs = srcs;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<Object> tryFire(int mode) {
            Object r10;
            CompletableFuture<Object> d10;
            CompletableFuture<?>[] as;
            CompletableFuture<?> a10 = this.src;
            if (a10 == null || (r10 = a10.result) == null || (d10 = this.dep) == null || (as = this.srcs) == null) {
                return null;
            }
            this.src = null;
            this.dep = null;
            this.srcs = null;
            if (d10.completeRelay(r10)) {
                for (CompletableFuture<?> b4 : as) {
                    if (b4 != a10) {
                        b4.cleanStack();
                    }
                }
                if (mode < 0) {
                    return d10;
                }
                d10.postComplete();
            }
            return null;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            CompletableFuture<Object> d10 = this.dep;
            return d10 != null && d10.result == null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AsyncSupply<T> extends ForkJoinTask<Void> implements Runnable, AsynchronousCompletionTask {
        CompletableFuture<T> dep;
        Supplier<? extends T> fn;

        AsyncSupply(CompletableFuture<T> dep, Supplier<? extends T> fn) {
            this.dep = dep;
            this.fn = fn;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void v2) {
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            run();
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Supplier<? extends T> f10;
            CompletableFuture<T> d10 = this.dep;
            if (d10 != null && (f10 = this.fn) != null) {
                this.dep = null;
                this.fn = null;
                if (d10.result == null) {
                    try {
                        d10.completeValue(f10.get());
                    } catch (Throwable ex) {
                        d10.completeThrowable(ex);
                    }
                }
                d10.postComplete();
            }
        }
    }

    static <U> CompletableFuture<U> asyncSupplyStage(Executor e2, Supplier<U> f10) {
        if (f10 == null) {
            throw new NullPointerException();
        }
        CompletableFuture<U> d10 = new CompletableFuture<>();
        e2.execute(new AsyncSupply(d10, f10));
        return d10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AsyncRun extends ForkJoinTask<Void> implements Runnable, AsynchronousCompletionTask {
        CompletableFuture<Void> dep;
        Runnable fn;

        AsyncRun(CompletableFuture<Void> dep, Runnable fn) {
            this.dep = dep;
            this.fn = fn;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void v2) {
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            run();
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable f10;
            CompletableFuture<Void> d10 = this.dep;
            if (d10 != null && (f10 = this.fn) != null) {
                this.dep = null;
                this.fn = null;
                if (d10.result == null) {
                    try {
                        f10.run();
                        d10.completeNull();
                    } catch (Throwable ex) {
                        d10.completeThrowable(ex);
                    }
                }
                d10.postComplete();
            }
        }
    }

    static CompletableFuture<Void> asyncRunStage(Executor e2, Runnable f10) {
        if (f10 == null) {
            throw new NullPointerException();
        }
        CompletableFuture<Void> d10 = new CompletableFuture<>();
        e2.execute(new AsyncRun(d10, f10));
        return d10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Signaller extends Completion implements ForkJoinPool.ManagedBlocker {
        final long deadline;
        boolean interrupted;
        final boolean interruptible;
        long nanos;
        volatile Thread thread = Thread.currentThread();

        Signaller(boolean interruptible, long nanos, long deadline) {
            this.interruptible = interruptible;
            this.nanos = nanos;
            this.deadline = deadline;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final CompletableFuture<?> tryFire(int ignore) {
            Thread w3 = this.thread;
            if (w3 != null) {
                this.thread = null;
                LockSupport.unpark(w3);
            }
            return null;
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public boolean isReleasable() {
            if (Thread.interrupted()) {
                this.interrupted = true;
            }
            if (this.interrupted && this.interruptible) {
                return true;
            }
            long j10 = this.deadline;
            if (j10 != 0) {
                if (this.nanos <= 0) {
                    return true;
                }
                long nanoTime = j10 - System.nanoTime();
                this.nanos = nanoTime;
                if (nanoTime <= 0) {
                    return true;
                }
            }
            return this.thread == null;
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public boolean block() {
            while (!isReleasable()) {
                if (this.deadline == 0) {
                    LockSupport.park(this);
                } else {
                    LockSupport.parkNanos(this, this.nanos);
                }
            }
            return true;
        }

        @Override // java.util.concurrent.CompletableFuture.Completion
        final boolean isLive() {
            return this.thread != null;
        }
    }

    private Object waitingGet(boolean interruptible) {
        if (interruptible && Thread.interrupted()) {
            return null;
        }
        Signaller q10 = null;
        boolean queued = false;
        while (true) {
            Object r10 = this.result;
            if (r10 == null) {
                if (q10 == null) {
                    q10 = new Signaller(interruptible, 0L, 0L);
                    if (Thread.currentThread() instanceof ForkJoinWorkerThread) {
                        ForkJoinPool.helpAsyncBlocker(defaultExecutor(), q10);
                    }
                } else if (!queued) {
                    queued = tryPushStack(q10);
                } else {
                    if (interruptible && q10.interrupted) {
                        q10.thread = null;
                        cleanStack();
                        return null;
                    }
                    try {
                        ForkJoinPool.managedBlock(q10);
                    } catch (InterruptedException e2) {
                        q10.interrupted = true;
                    }
                }
            } else {
                if (q10 != null) {
                    q10.thread = null;
                    if (q10.interrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
                postComplete();
                return r10;
            }
        }
    }

    private Object timedGet(long nanos) throws TimeoutException {
        boolean interrupted;
        Object r10;
        long d10 = System.nanoTime() + nanos;
        long deadline = d10 == 0 ? 1L : d10;
        boolean interrupted2 = false;
        Object r11 = null;
        boolean queued = false;
        Signaller q10 = null;
        long nanos2 = nanos;
        while (true) {
            if (interrupted2) {
                break;
            }
            interrupted = Thread.interrupted();
            if (interrupted) {
                interrupted2 = interrupted;
                break;
            }
            r10 = this.result;
            if (r10 == null && nanos2 > 0) {
                if (q10 == null) {
                    q10 = new Signaller(true, nanos2, deadline);
                    if (Thread.currentThread() instanceof ForkJoinWorkerThread) {
                        ForkJoinPool.helpAsyncBlocker(defaultExecutor(), q10);
                    }
                    interrupted2 = interrupted;
                    r11 = r10;
                } else if (!queued) {
                    queued = tryPushStack(q10);
                    interrupted2 = interrupted;
                    r11 = r10;
                } else {
                    try {
                        ForkJoinPool.managedBlock(q10);
                        boolean interrupted3 = q10.interrupted;
                        try {
                            nanos2 = q10.nanos;
                            interrupted2 = interrupted3;
                            r11 = r10;
                        } catch (InterruptedException e2) {
                            interrupted2 = true;
                            r11 = r10;
                        }
                    } catch (InterruptedException e10) {
                    }
                }
            }
        }
        interrupted2 = interrupted;
        r11 = r10;
        if (q10 != null) {
            q10.thread = null;
            if (r11 == null) {
                cleanStack();
            }
        }
        if (r11 != null) {
            if (interrupted2) {
                Thread.currentThread().interrupt();
            }
            postComplete();
            return r11;
        }
        if (interrupted2) {
            return null;
        }
        throw new TimeoutException();
    }

    public CompletableFuture() {
    }

    CompletableFuture(Object r10) {
        (void) RESULT.setRelease(this, r10);
    }

    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return asyncSupplyStage(ASYNC_POOL, supplier);
    }

    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor) {
        return asyncSupplyStage(screenExecutor(executor), supplier);
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        return asyncRunStage(ASYNC_POOL, runnable);
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor) {
        return asyncRunStage(screenExecutor(executor), runnable);
    }

    public static <U> CompletableFuture<U> completedFuture(U value) {
        return new CompletableFuture<>(value == null ? NIL : value);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.result != null;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        Object obj = this.result;
        Object obj2 = obj;
        if (obj == null) {
            obj2 = waitingGet(true);
        }
        return (T) reportGet(obj2);
    }

    @Override // java.util.concurrent.Future
    public T get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        Object obj = this.result;
        Object obj2 = obj;
        if (obj == null) {
            obj2 = timedGet(nanos);
        }
        return (T) reportGet(obj2);
    }

    public T join() {
        Object obj = this.result;
        Object obj2 = obj;
        if (obj == null) {
            obj2 = waitingGet(false);
        }
        return (T) reportJoin(obj2);
    }

    public T getNow(T t2) {
        Object obj = this.result;
        return obj == null ? t2 : (T) reportJoin(obj);
    }

    public boolean complete(T value) {
        boolean triggered = completeValue(value);
        postComplete();
        return triggered;
    }

    public boolean completeExceptionally(Throwable ex) {
        if (ex == null) {
            throw new NullPointerException();
        }
        boolean triggered = internalComplete(new AltResult(ex));
        postComplete();
        return triggered;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <U> CompletableFuture<U> thenApply(Function<? super T, ? extends U> function) {
        return (CompletableFuture<U>) uniApplyStage(null, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenApplyAsync(Function<? super T, ? extends U> function) {
        return (CompletableFuture<U>) uniApplyStage(defaultExecutor(), function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <U> CompletableFuture<U> thenApplyAsync(Function<? super T, ? extends U> function, Executor executor) {
        return (CompletableFuture<U>) uniApplyStage(screenExecutor(executor), function);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenAccept(Consumer<? super T> action) {
        return uniAcceptStage(null, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action) {
        return uniAcceptStage(defaultExecutor(), action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor) {
        return uniAcceptStage(screenExecutor(executor), action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenRun(Runnable action) {
        return uniRunStage(null, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenRunAsync(Runnable action) {
        return uniRunStage(defaultExecutor(), action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> thenRunAsync(Runnable action, Executor executor) {
        return uniRunStage(screenExecutor(executor), action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <U, V> CompletableFuture<V> thenCombine(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> fn) {
        return biApplyStage(null, completionStage, fn);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U, V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> fn) {
        return biApplyStage(defaultExecutor(), completionStage, fn);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U, V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> fn, Executor executor) {
        return biApplyStage(screenExecutor(executor), completionStage, fn);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<Void> thenAcceptBoth(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> action) {
        return biAcceptStage(null, completionStage, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> action) {
        return biAcceptStage(defaultExecutor(), completionStage, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> action, Executor executor) {
        return biAcceptStage(screenExecutor(executor), completionStage, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterBoth(CompletionStage<?> other, Runnable action) {
        return biRunStage(null, other, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action) {
        return biRunStage(defaultExecutor(), other, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return biRunStage(screenExecutor(executor), other, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> applyToEither(CompletionStage<? extends T> completionStage, Function<? super T, U> function) {
        return (CompletableFuture<U>) orApplyStage(null, completionStage, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> applyToEitherAsync(CompletionStage<? extends T> completionStage, Function<? super T, U> function) {
        return (CompletableFuture<U>) orApplyStage(defaultExecutor(), completionStage, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> applyToEitherAsync(CompletionStage<? extends T> completionStage, Function<? super T, U> function, Executor executor) {
        return (CompletableFuture<U>) orApplyStage(screenExecutor(executor), completionStage, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> acceptEither(CompletionStage<? extends T> completionStage, Consumer<? super T> action) {
        return orAcceptStage(null, completionStage, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> completionStage, Consumer<? super T> action) {
        return orAcceptStage(defaultExecutor(), completionStage, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> completionStage, Consumer<? super T> action, Executor executor) {
        return orAcceptStage(screenExecutor(executor), completionStage, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterEither(CompletionStage<?> other, Runnable action) {
        return orRunStage(null, other, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action) {
        return orRunStage(defaultExecutor(), other, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor) {
        return orRunStage(screenExecutor(executor), other, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <U> CompletableFuture<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> function) {
        return (CompletableFuture<U>) uniComposeStage(null, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> function) {
        return (CompletableFuture<U>) uniComposeStage(defaultExecutor(), function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <U> CompletableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> function, Executor executor) {
        return (CompletableFuture<U>) uniComposeStage(screenExecutor(executor), function);
    }

    public CompletableFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action) {
        return uniWhenCompleteStage(null, action);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action) {
        return uniWhenCompleteStage(defaultExecutor(), action);
    }

    public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action, Executor executor) {
        return uniWhenCompleteStage(screenExecutor(executor), action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> biFunction) {
        return (CompletableFuture<U>) uniHandleStage(null, biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> biFunction) {
        return (CompletableFuture<U>) uniHandleStage(defaultExecutor(), biFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.CompletionStage
    public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> biFunction, Executor executor) {
        return (CompletableFuture<U>) uniHandleStage(screenExecutor(executor), biFunction);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> toCompletableFuture() {
        return this;
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionally(Function<Throwable, ? extends T> fn) {
        return uniExceptionallyStage(null, fn);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyAsync(Function<Throwable, ? extends T> fn) {
        return uniExceptionallyStage(defaultExecutor(), fn);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyAsync(Function<Throwable, ? extends T> fn, Executor executor) {
        return uniExceptionallyStage(screenExecutor(executor), fn);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyCompose(Function<Throwable, ? extends CompletionStage<T>> fn) {
        return uniComposeExceptionallyStage(null, fn);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyComposeAsync(Function<Throwable, ? extends CompletionStage<T>> fn) {
        return uniComposeExceptionallyStage(defaultExecutor(), fn);
    }

    @Override // java.util.concurrent.CompletionStage
    public CompletableFuture<T> exceptionallyComposeAsync(Function<Throwable, ? extends CompletionStage<T>> fn, Executor executor) {
        return uniComposeExceptionallyStage(screenExecutor(executor), fn);
    }

    public static CompletableFuture<Void> allOf(CompletableFuture<?>... cfs) {
        return andTree(cfs, 0, cfs.length - 1);
    }

    public static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs) {
        int n10 = cfs.length;
        if (n10 <= 1) {
            if (n10 == 0) {
                return new CompletableFuture<>();
            }
            return uniCopyStage(cfs[0]);
        }
        for (CompletableFuture<?> completableFuture : cfs) {
            Object r10 = completableFuture.result;
            if (r10 != null) {
                return new CompletableFuture<>(encodeRelay(r10));
            }
        }
        CompletableFuture<?>[] cfs2 = (CompletableFuture[]) cfs.clone();
        CompletableFuture<Object> d10 = new CompletableFuture<>();
        for (CompletableFuture<?> cf : cfs2) {
            cf.unipush(new AnyOf(d10, cf, cfs2));
        }
        if (d10.result != null) {
            int i10 = 0;
            int len = cfs2.length;
            while (i10 < len) {
                if (cfs2[i10].result != null) {
                    while (true) {
                        i10++;
                        if (i10 < len) {
                            if (cfs2[i10].result == null) {
                                cfs2[i10].cleanStack();
                            }
                        }
                    }
                }
                i10++;
            }
        }
        return d10;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        boolean cancelled = this.result == null && internalComplete(new AltResult(new CancellationException()));
        postComplete();
        return cancelled || isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Object r10 = this.result;
        return (r10 instanceof AltResult) && (((AltResult) r10).ex instanceof CancellationException);
    }

    public boolean isCompletedExceptionally() {
        Object r10 = this.result;
        return (r10 instanceof AltResult) && r10 != NIL;
    }

    public void obtrudeValue(T value) {
        this.result = value == null ? NIL : value;
        postComplete();
    }

    public void obtrudeException(Throwable ex) {
        if (ex == null) {
            throw new NullPointerException();
        }
        this.result = new AltResult(ex);
        postComplete();
    }

    public int getNumberOfDependents() {
        int count = 0;
        for (Completion p10 = this.stack; p10 != null; p10 = p10.next) {
            count++;
        }
        return count;
    }

    public String toString() {
        String str;
        Object r10 = this.result;
        int count = 0;
        for (Completion p10 = this.stack; p10 != null; p10 = p10.next) {
            count++;
        }
        StringBuilder append = new StringBuilder().append(super.toString());
        if (r10 == null) {
            if (count == 0) {
                str = "[Not completed]";
            } else {
                str = "[Not completed, " + count + " dependents]";
            }
        } else if ((r10 instanceof AltResult) && ((AltResult) r10).ex != null) {
            str = "[Completed exceptionally: " + ((Object) ((AltResult) r10).ex) + "]";
        } else {
            str = "[Completed normally]";
        }
        return append.append(str).toString();
    }

    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new CompletableFuture<>();
    }

    public Executor defaultExecutor() {
        return ASYNC_POOL;
    }

    public CompletableFuture<T> copy() {
        return uniCopyStage(this);
    }

    public CompletionStage<T> minimalCompletionStage() {
        return uniAsMinimalStage();
    }

    public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier, Executor executor) {
        if (supplier == null || executor == null) {
            throw new NullPointerException();
        }
        executor.execute(new AsyncSupply(this, supplier));
        return this;
    }

    public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier) {
        return completeAsync(supplier, defaultExecutor());
    }

    public CompletableFuture<T> orTimeout(long timeout, TimeUnit unit) {
        if (unit == null) {
            throw new NullPointerException();
        }
        if (this.result == null) {
            whenComplete((BiConsumer) new Canceller(Delayer.delay(new Timeout(this), timeout, unit)));
        }
        return this;
    }

    public CompletableFuture<T> completeOnTimeout(T value, long timeout, TimeUnit unit) {
        if (unit == null) {
            throw new NullPointerException();
        }
        if (this.result == null) {
            whenComplete((BiConsumer) new Canceller(Delayer.delay(new DelayedCompleter(this, value), timeout, unit)));
        }
        return this;
    }

    public static Executor delayedExecutor(long delay, TimeUnit unit, Executor executor) {
        if (unit == null || executor == null) {
            throw new NullPointerException();
        }
        return new DelayedExecutor(delay, unit, executor);
    }

    public static Executor delayedExecutor(long delay, TimeUnit unit) {
        if (unit == null) {
            throw new NullPointerException();
        }
        return new DelayedExecutor(delay, unit, ASYNC_POOL);
    }

    public static <U> CompletionStage<U> completedStage(U value) {
        return new MinimalStage(value == null ? NIL : value);
    }

    public static <U> CompletableFuture<U> failedFuture(Throwable ex) {
        if (ex == null) {
            throw new NullPointerException();
        }
        return new CompletableFuture<>(new AltResult(ex));
    }

    public static <U> CompletionStage<U> failedStage(Throwable ex) {
        if (ex == null) {
            throw new NullPointerException();
        }
        return new MinimalStage(new AltResult(ex));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Delayer {
        static final ScheduledThreadPoolExecutor delayer;

        Delayer() {
        }

        static ScheduledFuture<?> delay(Runnable command, long delay, TimeUnit unit) {
            return delayer.schedule(command, delay, unit);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class DaemonThreadFactory implements ThreadFactory {
            DaemonThreadFactory() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r10) {
                Thread t2 = new Thread(r10);
                t2.setDaemon(true);
                t2.setName("CompletableFutureDelayScheduler");
                return t2;
            }
        }

        static {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new DaemonThreadFactory());
            delayer = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class DelayedExecutor implements Executor {
        final long delay;
        final Executor executor;
        final TimeUnit unit;

        DelayedExecutor(long delay, TimeUnit unit, Executor executor) {
            this.delay = delay;
            this.unit = unit;
            this.executor = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            Delayer.delay(new TaskSubmitter(this.executor, r10), this.delay, this.unit);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class TaskSubmitter implements Runnable {
        final Runnable action;
        final Executor executor;

        TaskSubmitter(Executor executor, Runnable action) {
            this.executor = executor;
            this.action = action;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.executor.execute(this.action);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class Timeout implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final CompletableFuture<?> f50492f;

        Timeout(CompletableFuture<?> f10) {
            this.f50492f = f10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompletableFuture<?> completableFuture = this.f50492f;
            if (completableFuture != null && !completableFuture.isDone()) {
                this.f50492f.completeExceptionally(new TimeoutException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DelayedCompleter<U> implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final CompletableFuture<U> f50490f;

        /* renamed from: u, reason: collision with root package name */
        final U f50491u;

        DelayedCompleter(CompletableFuture<U> f10, U u10) {
            this.f50490f = f10;
            this.f50491u = u10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CompletableFuture<U> completableFuture = this.f50490f;
            if (completableFuture != null) {
                completableFuture.complete(this.f50491u);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Canceller implements BiConsumer<Object, Throwable> {

        /* renamed from: f, reason: collision with root package name */
        final Future<?> f50489f;

        Canceller(Future<?> f10) {
            this.f50489f = f10;
        }

        @Override // java.util.function.BiConsumer
        public void accept(Object ignore, Throwable ex) {
            Future<?> future;
            if (ex == null && (future = this.f50489f) != null && !future.isDone()) {
                this.f50489f.cancel(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class MinimalStage<T> extends CompletableFuture<T> {
        MinimalStage() {
        }

        MinimalStage(Object r10) {
            super(r10);
        }

        @Override // java.util.concurrent.CompletableFuture
        public <U> CompletableFuture<U> newIncompleteFuture() {
            return new MinimalStage();
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public T get() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public T get(long timeout, TimeUnit unit) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public T getNow(T valueIfAbsent) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public T join() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public boolean complete(T value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public boolean completeExceptionally(Throwable ex) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public void obtrudeValue(T value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public void obtrudeException(Throwable ex) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean isDone() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public boolean isCompletedExceptionally() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public int getNumberOfDependents() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier, Executor executor) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public CompletableFuture<T> completeAsync(Supplier<? extends T> supplier) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public CompletableFuture<T> orTimeout(long timeout, TimeUnit unit) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture
        public CompletableFuture<T> completeOnTimeout(T value, long timeout, TimeUnit unit) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.CompletionStage
        public CompletableFuture<T> toCompletableFuture() {
            Object r10 = this.result;
            if (r10 != null) {
                return new CompletableFuture<>(encodeRelay(r10));
            }
            CompletableFuture<T> d10 = new CompletableFuture<>();
            unipush(new UniRelay(d10, this));
            return d10;
        }
    }
}
