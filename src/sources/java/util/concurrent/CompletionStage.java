package java.util.concurrent;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CompletionStage<T> {
    CompletionStage<Void> acceptEither(CompletionStage<? extends T> completionStage, Consumer<? super T> consumer);

    CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> completionStage, Consumer<? super T> consumer);

    CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> completionStage, Consumer<? super T> consumer, Executor executor);

    <U> CompletionStage<U> applyToEither(CompletionStage<? extends T> completionStage, Function<? super T, U> function);

    <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> completionStage, Function<? super T, U> function);

    <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> completionStage, Function<? super T, U> function, Executor executor);

    CompletionStage<T> exceptionally(Function<Throwable, ? extends T> function);

    <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> biFunction);

    <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> biFunction);

    <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> biFunction, Executor executor);

    CompletionStage<Void> runAfterBoth(CompletionStage<?> completionStage, Runnable runnable);

    CompletionStage<Void> runAfterBothAsync(CompletionStage<?> completionStage, Runnable runnable);

    CompletionStage<Void> runAfterBothAsync(CompletionStage<?> completionStage, Runnable runnable, Executor executor);

    CompletionStage<Void> runAfterEither(CompletionStage<?> completionStage, Runnable runnable);

    CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> completionStage, Runnable runnable);

    CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> completionStage, Runnable runnable, Executor executor);

    CompletionStage<Void> thenAccept(Consumer<? super T> consumer);

    CompletionStage<Void> thenAcceptAsync(Consumer<? super T> consumer);

    CompletionStage<Void> thenAcceptAsync(Consumer<? super T> consumer, Executor executor);

    <U> CompletionStage<Void> thenAcceptBoth(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> biConsumer);

    <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> biConsumer);

    <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> completionStage, BiConsumer<? super T, ? super U> biConsumer, Executor executor);

    <U> CompletionStage<U> thenApply(Function<? super T, ? extends U> function);

    <U> CompletionStage<U> thenApplyAsync(Function<? super T, ? extends U> function);

    <U> CompletionStage<U> thenApplyAsync(Function<? super T, ? extends U> function, Executor executor);

    <U, V> CompletionStage<V> thenCombine(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction);

    <U, V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction);

    <U, V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> completionStage, BiFunction<? super T, ? super U, ? extends V> biFunction, Executor executor);

    <U> CompletionStage<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> function);

    <U> CompletionStage<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> function);

    <U> CompletionStage<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> function, Executor executor);

    CompletionStage<Void> thenRun(Runnable runnable);

    CompletionStage<Void> thenRunAsync(Runnable runnable);

    CompletionStage<Void> thenRunAsync(Runnable runnable, Executor executor);

    CompletableFuture<T> toCompletableFuture();

    CompletionStage<T> whenComplete(BiConsumer<? super T, ? super Throwable> biConsumer);

    CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> biConsumer);

    CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> biConsumer, Executor executor);

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default CompletionStage lambda$exceptionallyAsync$1(final Function fn, Object r10, Throwable ex) {
        if (ex == null) {
            return this;
        }
        return handleAsync(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda6
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = Function.this.apply((Throwable) obj2);
                return apply;
            }
        });
    }

    default CompletionStage<T> exceptionallyAsync(final Function<Throwable, ? extends T> fn) {
        return handle(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CompletionStage lambda$exceptionallyAsync$1;
                lambda$exceptionallyAsync$1 = CompletionStage.this.lambda$exceptionallyAsync$1(fn, obj, (Throwable) obj2);
                return lambda$exceptionallyAsync$1;
            }
        }).thenCompose(Function.identity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default CompletionStage lambda$exceptionallyAsync$3(final Function fn, Executor executor, Object r10, Throwable ex) {
        if (ex == null) {
            return this;
        }
        return handleAsync(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = Function.this.apply((Throwable) obj2);
                return apply;
            }
        }, executor);
    }

    default CompletionStage<T> exceptionallyAsync(final Function<Throwable, ? extends T> fn, final Executor executor) {
        return handle(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CompletionStage lambda$exceptionallyAsync$3;
                lambda$exceptionallyAsync$3 = CompletionStage.this.lambda$exceptionallyAsync$3(fn, executor, obj, (Throwable) obj2);
                return lambda$exceptionallyAsync$3;
            }
        }).thenCompose(Function.identity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default CompletionStage lambda$exceptionallyCompose$4(Function fn, Object r10, Throwable ex) {
        if (ex == null) {
            return this;
        }
        return (CompletionStage) fn.apply(ex);
    }

    default CompletionStage<T> exceptionallyCompose(final Function<Throwable, ? extends CompletionStage<T>> fn) {
        return handle(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda7
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CompletionStage lambda$exceptionallyCompose$4;
                lambda$exceptionallyCompose$4 = CompletionStage.this.lambda$exceptionallyCompose$4(fn, obj, (Throwable) obj2);
                return lambda$exceptionallyCompose$4;
            }
        }).thenCompose(Function.identity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default CompletionStage lambda$exceptionallyComposeAsync$6(final Function fn, Object r10, Throwable ex) {
        if (ex == null) {
            return this;
        }
        return handleAsync(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda3
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return CompletionStage.lambda$exceptionallyComposeAsync$5(Function.this, obj, (Throwable) obj2);
            }
        }).thenCompose(Function.identity());
    }

    default CompletionStage<T> exceptionallyComposeAsync(final Function<Throwable, ? extends CompletionStage<T>> fn) {
        return handle(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda8
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CompletionStage lambda$exceptionallyComposeAsync$6;
                lambda$exceptionallyComposeAsync$6 = CompletionStage.this.lambda$exceptionallyComposeAsync$6(fn, obj, (Throwable) obj2);
                return lambda$exceptionallyComposeAsync$6;
            }
        }).thenCompose(Function.identity());
    }

    static /* synthetic */ CompletionStage lambda$exceptionallyComposeAsync$5(Function fn, Object r12, Throwable ex1) {
        return (CompletionStage) fn.apply(ex1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default CompletionStage lambda$exceptionallyComposeAsync$8(final Function fn, Executor executor, Object r10, Throwable ex) {
        if (ex == null) {
            return this;
        }
        return handleAsync(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda5
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return CompletionStage.lambda$exceptionallyComposeAsync$7(Function.this, obj, (Throwable) obj2);
            }
        }, executor).thenCompose(Function.identity());
    }

    default CompletionStage<T> exceptionallyComposeAsync(final Function<Throwable, ? extends CompletionStage<T>> fn, final Executor executor) {
        return handle(new BiFunction() { // from class: java.util.concurrent.CompletionStage$$ExternalSyntheticLambda4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CompletionStage lambda$exceptionallyComposeAsync$8;
                lambda$exceptionallyComposeAsync$8 = CompletionStage.this.lambda$exceptionallyComposeAsync$8(fn, executor, obj, (Throwable) obj2);
                return lambda$exceptionallyComposeAsync$8;
            }
        }).thenCompose(Function.identity());
    }

    static /* synthetic */ CompletionStage lambda$exceptionallyComposeAsync$7(Function fn, Object r12, Throwable ex1) {
        return (CompletionStage) fn.apply(ex1);
    }
}
