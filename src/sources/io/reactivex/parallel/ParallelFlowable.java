package io.reactivex.parallel;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelConcatMap;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.internal.operators.parallel.ParallelFlatMap;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelMap;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.internal.util.MergerBiFunction;
import io.reactivex.internal.util.SorterFunction;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ParallelFlowable<T> {
    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> publisher) {
        return from(publisher, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public static <T> ParallelFlowable<T> fromArray(@NonNull Publisher<T>... publisherArr) {
        if (publisherArr.length != 0) {
            return RxJavaPlugins.onAssembly(new ParallelFromArray(publisherArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @CheckReturnValue
    @NonNull
    public final <R> R as(@NonNull ParallelFlowableConverter<T, R> parallelFlowableConverter) {
        return (R) ((ParallelFlowableConverter) ObjectHelper.requireNonNull(parallelFlowableConverter, "converter is null")).apply(this);
    }

    @CheckReturnValue
    @NonNull
    public final <C> ParallelFlowable<C> collect(@NonNull Callable<? extends C> callable, @NonNull BiConsumer<? super C, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.onAssembly(new ParallelCollect(this, callable, biConsumer));
    }

    @CheckReturnValue
    @NonNull
    public final <U> ParallelFlowable<U> compose(@NonNull ParallelTransformer<T, U> parallelTransformer) {
        return RxJavaPlugins.onAssembly(((ParallelTransformer) ObjectHelper.requireNonNull(parallelTransformer, "composer is null")).apply(this));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMap(function, 2);
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z10) {
        return concatMapDelayError(function, 2, z10);
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doAfterNext(@NonNull Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, consumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doAfterTerminated(@NonNull Action action) {
        ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnCancel(@NonNull Action action) {
        ObjectHelper.requireNonNull(action, "onCancel is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnComplete(@NonNull Action action) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnError(@NonNull Consumer<Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, consumer, emptyConsumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnRequest(@NonNull LongConsumer longConsumer) {
        ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, Functions.emptyConsumer(), longConsumer, action));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnSubscribe(@NonNull Consumer<? super Subscription> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate");
        return RxJavaPlugins.onAssembly(new ParallelFilter(this, predicate));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return flatMap(function, false, Integer.MAX_VALUE, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper");
        return RxJavaPlugins.onAssembly(new ParallelMap(this, function));
    }

    public abstract int parallelism();

    @CheckReturnValue
    @NonNull
    public final Flowable<T> reduce(@NonNull BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "reducer");
        return RxJavaPlugins.onAssembly(new ParallelReduceFull(this, biFunction));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> runOn(@NonNull Scheduler scheduler) {
        return runOn(scheduler, Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sequential() {
        return sequential(Flowable.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequentialDelayError() {
        return sequentialDelayError(Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<T> sorted(@NonNull Comparator<? super T> comparator) {
        return sorted(comparator, 16);
    }

    public abstract void subscribe(@NonNull Subscriber<? super T>[] subscriberArr);

    @CheckReturnValue
    @NonNull
    public final <U> U to(@NonNull Function<? super ParallelFlowable<T>, U> function) {
        try {
            return (U) ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> comparator) {
        return toSortedList(comparator, 16);
    }

    public final boolean validate(@NonNull Subscriber<?>[] subscriberArr) {
        int parallelism = parallelism();
        if (subscriberArr.length == parallelism) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + parallelism + ", subscribers = " + subscriberArr.length);
        for (Subscriber<?> subscriber : subscriberArr) {
            EmptySubscription.error(illegalArgumentException, subscriber);
        }
        return false;
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> publisher, int i10) {
        return from(publisher, i10, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i10) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i10, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, function, i10, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i10, boolean z10) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i10, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, function, i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z10) {
        return flatMap(function, z10, Integer.MAX_VALUE, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> runOn(@NonNull Scheduler scheduler, int i10) {
        ObjectHelper.requireNonNull(scheduler, "scheduler");
        ObjectHelper.verifyPositive(i10, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelRunOn(this, scheduler, i10));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequential(int i10) {
        ObjectHelper.verifyPositive(i10, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelJoin(this, i10, false));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequentialDelayError(int i10) {
        ObjectHelper.verifyPositive(i10, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelJoin(this, i10, true));
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<T> sorted(@NonNull Comparator<? super T> comparator, int i10) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        ObjectHelper.verifyPositive(i10, "capacityHint");
        return RxJavaPlugins.onAssembly(new ParallelSortedJoin(reduce(Functions.createArrayList((i10 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)), comparator));
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> comparator, int i10) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        ObjectHelper.verifyPositive(i10, "capacityHint");
        return RxJavaPlugins.onAssembly(reduce(Functions.createArrayList((i10 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)).reduce(new MergerBiFunction(comparator)));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> publisher, int i10, int i11) {
        ObjectHelper.requireNonNull(publisher, "source");
        ObjectHelper.verifyPositive(i10, "parallelism");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelFromPublisher(publisher, i10, i11));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> predicate, @NonNull ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(predicate, "predicate");
        ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, predicate, parallelFailureHandling));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z10, int i10) {
        return flatMap(function, z10, i10, Flowable.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> function, @NonNull ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(function, "mapper");
        ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelMapTry(this, function, parallelFailureHandling));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> reduce(@NonNull Callable<R> callable, @NonNull BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "initialSupplier");
        ObjectHelper.requireNonNull(biFunction, "reducer");
        return RxJavaPlugins.onAssembly(new ParallelReduce(this, callable, biFunction));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z10, int i10, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i10, "maxConcurrency");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ParallelFlatMap(this, function, z10, i10, i11));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> predicate, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(predicate, "predicate");
        ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, predicate, biFunction));
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> function, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(function, "mapper");
        ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelMapTry(this, function, biFunction));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> consumer, @NonNull ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, consumer, parallelFailureHandling));
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> consumer, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
        return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, consumer, biFunction));
    }
}
