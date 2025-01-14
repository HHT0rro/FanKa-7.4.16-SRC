package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Functions {
    public static final Function<Object, Object> IDENTITY = new Identity();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Action EMPTY_ACTION = new EmptyAction();
    public static final Consumer<Object> EMPTY_CONSUMER = new EmptyConsumer();
    public static final Consumer<Throwable> ERROR_CONSUMER = new ErrorConsumer();
    public static final Consumer<Throwable> ON_ERROR_MISSING = new OnErrorMissingConsumer();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    public static final Predicate<Object> ALWAYS_TRUE = new TruePredicate();
    public static final Predicate<Object> ALWAYS_FALSE = new FalsePredicate();
    public static final Callable<Object> NULL_SUPPLIER = new NullCallable();
    public static final Comparator<Object> NATURAL_COMPARATOR = new NaturalObjectComparator();
    public static final Consumer<Subscription> REQUEST_MAX = new MaxRequestSubscription();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ActionConsumer<T> implements Consumer<T> {
        public final Action action;

        public ActionConsumer(Action action) {
            this.action = action;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t2) throws Exception {
            this.action.run();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array2Func<T1, T2, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        public final BiFunction<? super T1, ? super T2, ? extends R> f50094f;

        public Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f50094f = biFunction;
        }

        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f50094f.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        public final Function3<T1, T2, T3, R> f50095f;

        public Array3Func(Function3<T1, T2, T3, R> function3) {
            this.f50095f = function3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.f50095f.apply(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array4Func<T1, T2, T3, T4, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        public final Function4<T1, T2, T3, T4, R> f50096f;

        public Array4Func(Function4<T1, T2, T3, T4, R> function4) {
            this.f50096f = function4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.f50096f.apply(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array5Func<T1, T2, T3, T4, T5, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        private final Function5<T1, T2, T3, T4, T5, R> f50097f;

        public Array5Func(Function5<T1, T2, T3, T4, T5, R> function5) {
            this.f50097f = function5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.f50097f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array6Func<T1, T2, T3, T4, T5, T6, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        public final Function6<T1, T2, T3, T4, T5, T6, R> f50098f;

        public Array6Func(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
            this.f50098f = function6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.f50098f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array7Func<T1, T2, T3, T4, T5, T6, T7, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        public final Function7<T1, T2, T3, T4, T5, T6, T7, R> f50099f;

        public Array7Func(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
            this.f50099f = function7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.f50099f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array8Func<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        public final Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> f50100f;

        public Array8Func(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
            this.f50100f = function8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.f50100f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Array9Func<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function<Object[], R> {

        /* renamed from: f, reason: collision with root package name */
        public final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f50101f;

        public Array9Func(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
            this.f50101f = function9;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.f50101f.apply(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ArrayListCapacityCallable<T> implements Callable<List<T>> {
        public final int capacity;

        public ArrayListCapacityCallable(int i10) {
            this.capacity = i10;
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.capacity);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class BooleanSupplierPredicateReverse<T> implements Predicate<T> {
        public final BooleanSupplier supplier;

        public BooleanSupplierPredicateReverse(BooleanSupplier booleanSupplier) {
            this.supplier = booleanSupplier;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t2) throws Exception {
            return !this.supplier.getAsBoolean();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class BoundedConsumer implements Consumer<Subscription> {
        public final int bufferSize;

        public BoundedConsumer(int i10) {
            this.bufferSize = i10;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(this.bufferSize);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CastToClass<T, U> implements Function<T, U> {
        public final Class<U> clazz;

        public CastToClass(Class<U> cls) {
            this.clazz = cls;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t2) throws Exception {
            return this.clazz.cast(t2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ClassFilter<T, U> implements Predicate<T> {
        public final Class<U> clazz;

        public ClassFilter(Class<U> cls) {
            this.clazz = cls;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t2) throws Exception {
            return this.clazz.isInstance(t2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EmptyAction implements Action {
        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EmptyConsumer implements Consumer<Object> {
        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EmptyLongConsumer implements LongConsumer {
        @Override // io.reactivex.functions.LongConsumer
        public void accept(long j10) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EqualsPredicate<T> implements Predicate<T> {
        public final T value;

        public EqualsPredicate(T t2) {
            this.value = t2;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t2) throws Exception {
            return ObjectHelper.equals(t2, this.value);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ErrorConsumer implements Consumer<Throwable> {
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class FalsePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class FutureAction implements Action {
        public final Future<?> future;

        public FutureAction(Future<?> future) {
            this.future = future;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.future.get();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Identity implements Function<Object, Object> {
        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        public final U value;

        public JustValue(U u10) {
            this.value = u10;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t2) throws Exception {
            return this.value;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ListSorter<T> implements Function<List<T>, List<T>> {
        public final Comparator<? super T> comparator;

        public ListSorter(Comparator<? super T> comparator) {
            this.comparator = comparator;
        }

        @Override // io.reactivex.functions.Function
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.comparator);
            return list;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MaxRequestSubscription implements Consumer<Subscription> {
        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NaturalObjectComparator implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NotificationOnComplete<T> implements Action {
        public final Consumer<? super Notification<T>> onNotification;

        public NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
            this.onNotification = consumer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.onNotification.accept(Notification.createOnComplete());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NotificationOnError<T> implements Consumer<Throwable> {
        public final Consumer<? super Notification<T>> onNotification;

        public NotificationOnError(Consumer<? super Notification<T>> consumer) {
            this.onNotification = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            this.onNotification.accept(Notification.createOnError(th));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NotificationOnNext<T> implements Consumer<T> {
        public final Consumer<? super Notification<T>> onNotification;

        public NotificationOnNext(Consumer<? super Notification<T>> consumer) {
            this.onNotification = consumer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t2) throws Exception {
            this.onNotification.accept(Notification.createOnNext(t2));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NullCallable implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TimestampFunction<T> implements Function<T, Timed<T>> {
        public final Scheduler scheduler;
        public final TimeUnit unit;

        public TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((TimestampFunction<T>) obj);
        }

        @Override // io.reactivex.functions.Function
        public Timed<T> apply(T t2) throws Exception {
            return new Timed<>(t2, this.scheduler.now(this.unit), this.unit);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ToMapKeySelector<K, T> implements BiConsumer<Map<K, T>, T> {
        private final Function<? super T, ? extends K> keySelector;

        public ToMapKeySelector(Function<? super T, ? extends K> function) {
            this.keySelector = function;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws Exception {
            accept((Map<K, Map<K, T>>) obj, (Map<K, T>) obj2);
        }

        public void accept(Map<K, T> map, T t2) throws Exception {
            map.put(this.keySelector.apply(t2), t2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ToMapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, V>, T> {
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        public ToMapKeyValueSelector(Function<? super T, ? extends V> function, Function<? super T, ? extends K> function2) {
            this.valueSelector = function;
            this.keySelector = function2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws Exception {
            accept((Map) obj, (Map<K, V>) obj2);
        }

        public void accept(Map<K, V> map, T t2) throws Exception {
            map.put(this.keySelector.apply(t2), this.valueSelector.apply(t2));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ToMultimapKeyValueSelector<K, V, T> implements BiConsumer<Map<K, Collection<V>>, T> {
        private final Function<? super K, ? extends Collection<? super V>> collectionFactory;
        private final Function<? super T, ? extends K> keySelector;
        private final Function<? super T, ? extends V> valueSelector;

        public ToMultimapKeyValueSelector(Function<? super K, ? extends Collection<? super V>> function, Function<? super T, ? extends V> function2, Function<? super T, ? extends K> function3) {
            this.collectionFactory = function;
            this.valueSelector = function2;
            this.keySelector = function3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws Exception {
            accept((Map) obj, (Map<K, Collection<V>>) obj2);
        }

        public void accept(Map<K, Collection<V>> map, T t2) throws Exception {
            K apply = this.keySelector.apply(t2);
            Collection<? super V> collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = this.collectionFactory.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.valueSelector.apply(t2));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TruePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new ActionConsumer(action);
    }

    public static <T> Predicate<T> alwaysFalse() {
        return (Predicate<T>) ALWAYS_FALSE;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return (Predicate<T>) ALWAYS_TRUE;
    }

    public static <T> Consumer<T> boundedConsumer(int i10) {
        return new BoundedConsumer(i10);
    }

    public static <T, U> Function<T, U> castFunction(Class<U> cls) {
        return new CastToClass(cls);
    }

    public static <T> Callable<List<T>> createArrayList(int i10) {
        return new ArrayListCapacityCallable(i10);
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    public static <T> Predicate<T> equalsWith(T t2) {
        return new EqualsPredicate(t2);
    }

    public static Action futureAction(Future<?> future) {
        return new FutureAction(future);
    }

    public static <T> Function<T, T> identity() {
        return (Function<T, T>) IDENTITY;
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> cls) {
        return new ClassFilter(cls);
    }

    public static <T> Callable<T> justCallable(T t2) {
        return new JustValue(t2);
    }

    public static <T, U> Function<T, U> justFunction(U u10) {
        return new JustValue(u10);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> naturalOrder() {
        return (Comparator<T>) NATURAL_COMPARATOR;
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    public static <T> Callable<T> nullSupplier() {
        return (Callable<T>) NULL_SUPPLIER;
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.requireNonNull(function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.requireNonNull(function4, "f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.requireNonNull(function5, "f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.requireNonNull(function6, "f is null");
        return new Array6Func(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.requireNonNull(function7, "f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.requireNonNull(function8, "f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.requireNonNull(function9, "f is null");
        return new Array9Func(function9);
    }
}
