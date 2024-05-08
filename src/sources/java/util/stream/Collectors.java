package java.util.stream;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Collectors {
    static final Set<Collector.Characteristics> CH_CONCURRENT_ID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.CONCURRENT, Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH));
    static final Set<Collector.Characteristics> CH_CONCURRENT_NOID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.CONCURRENT, Collector.Characteristics.UNORDERED));
    static final Set<Collector.Characteristics> CH_ID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
    static final Set<Collector.Characteristics> CH_UNORDERED_ID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH));
    static final Set<Collector.Characteristics> CH_NOID = Collections.emptySet();
    static final Set<Collector.Characteristics> CH_UNORDERED_NOID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED));

    /* renamed from: -$$Nest$smcastingIdentity, reason: not valid java name */
    static /* bridge */ /* synthetic */ Function m3509$$Nest$smcastingIdentity() {
        return castingIdentity();
    }

    private Collectors() {
    }

    private static IllegalStateException duplicateKeyException(Object k10, Object u10, Object v2) {
        return new IllegalStateException(String.format("Duplicate key %s (attempted merging values %s and %s)", k10, u10, v2));
    }

    private static <K, V, M extends Map<K, V>> BinaryOperator<M> uniqKeysMapMerger() {
        return new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda94
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$uniqKeysMapMerger$0((Map) obj, (Map) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$uniqKeysMapMerger$0(Map m12, Map m22) {
        for (Map.Entry entry : m22.entrySet()) {
            Object key = entry.getKey();
            Object requireNonNull = Objects.requireNonNull(entry.getValue());
            Object putIfAbsent = m12.putIfAbsent(key, requireNonNull);
            if (putIfAbsent != null) {
                throw duplicateKeyException(key, putIfAbsent, requireNonNull);
            }
        }
        return m12;
    }

    private static <T, K, V> BiConsumer<Map<K, V>, T> uniqKeysMapAccumulator(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends V> valueMapper) {
        return new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda39
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$uniqKeysMapAccumulator$1(Function.this, valueMapper, (Map) obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$uniqKeysMapAccumulator$1(Function keyMapper, Function valueMapper, Map map, Object element) {
        Object apply = keyMapper.apply(element);
        Object requireNonNull = Objects.requireNonNull(valueMapper.apply(element));
        Object putIfAbsent = map.putIfAbsent(apply, requireNonNull);
        if (putIfAbsent != null) {
            throw duplicateKeyException(apply, putIfAbsent, requireNonNull);
        }
    }

    private static <I, R> Function<I, R> castingIdentity() {
        return new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda15
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$castingIdentity$2(obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$castingIdentity$2(Object i10) {
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CollectorImpl<T, A, R> implements Collector<T, A, R> {
        private final BiConsumer<A, T> accumulator;
        private final Set<Collector.Characteristics> characteristics;
        private final BinaryOperator<A> combiner;
        private final Function<A, R> finisher;
        private final Supplier<A> supplier;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner, Function<A, R> finisher, Set<Collector.Characteristics> characteristics) {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.finisher = finisher;
            this.characteristics = characteristics;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner, Set<Collector.Characteristics> characteristics) {
            this(supplier, accumulator, combiner, Collectors.m3509$$Nest$smcastingIdentity(), characteristics);
        }

        @Override // java.util.stream.Collector
        public BiConsumer<A, T> accumulator() {
            return this.accumulator;
        }

        @Override // java.util.stream.Collector
        public Supplier<A> supplier() {
            return this.supplier;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator<A> combiner() {
            return this.combiner;
        }

        @Override // java.util.stream.Collector
        public Function<A, R> finisher() {
            return this.finisher;
        }

        @Override // java.util.stream.Collector
        public Set<Collector.Characteristics> characteristics() {
            return this.characteristics;
        }
    }

    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> collectionFactory) {
        return new CollectorImpl(collectionFactory, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Collection) obj).add(obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toCollection$3((Collection) obj, (Collection) obj2);
            }
        }, CH_ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Collection lambda$toCollection$3(Collection r12, Collection r22) {
        r12.addAll(r22);
        return r12;
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda74(), new Collectors$$ExternalSyntheticLambda75(), new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda76
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toList$4((List) obj, (List) obj2);
            }
        }, CH_ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List lambda$toList$4(List left, List right) {
        left.addAll(right);
        return left;
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableList() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda74(), new Collectors$$ExternalSyntheticLambda75(), new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda77
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toUnmodifiableList$5((List) obj, (List) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda78
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List of;
                of = List.of(((List) obj).toArray());
                return of;
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List lambda$toUnmodifiableList$5(List left, List right) {
        left.addAll(right);
        return left;
    }

    public static <T> Collector<T, ?, Set<T>> toSet() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda41(), new Collectors$$ExternalSyntheticLambda42(), new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda87
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toSet$7((Set) obj, (Set) obj2);
            }
        }, CH_UNORDERED_ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set lambda$toSet$7(Set left, Set right) {
        if (left.size() < right.size()) {
            right.addAll(left);
            return right;
        }
        left.addAll(right);
        return left;
    }

    public static <T> Collector<T, ?, Set<T>> toUnmodifiableSet() {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda41(), new Collectors$$ExternalSyntheticLambda42(), new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda43
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toUnmodifiableSet$8((Set) obj, (Set) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda44
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Set of;
                of = Set.of(((Set) obj).toArray());
                return of;
            }
        }, CH_UNORDERED_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set lambda$toUnmodifiableSet$8(Set left, Set right) {
        if (left.size() < right.size()) {
            right.addAll(left);
            return right;
        }
        left.addAll(right);
        return left;
    }

    public static Collector<CharSequence, ?, String> joining() {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda83
            @Override // java.util.function.Supplier
            public final Object get() {
                return new StringBuilder();
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda84
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((StringBuilder) obj).append((CharSequence) obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda85
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$joining$10((StringBuilder) obj, (StringBuilder) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda86
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StringBuilder) obj).toString();
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ StringBuilder lambda$joining$10(StringBuilder r12, StringBuilder r22) {
        r12.append((CharSequence) r22);
        return r12;
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence delimiter) {
        return joining(delimiter, "", "");
    }

    public static Collector<CharSequence, ?, String> joining(final CharSequence delimiter, final CharSequence prefix, final CharSequence suffix) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda50
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$joining$11(CharSequence.this, prefix, suffix);
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda51
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((StringJoiner) obj).add((CharSequence) obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda52
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((StringJoiner) obj).merge((StringJoiner) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda53
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StringJoiner) obj).toString();
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ StringJoiner lambda$joining$11(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        return new StringJoiner(delimiter, prefix, suffix);
    }

    private static <K, V, M extends Map<K, V>> BinaryOperator<M> mapMerger(final BinaryOperator<V> mergeFunction) {
        return new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda24
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$mapMerger$12(BinaryOperator.this, (Map) obj, (Map) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$mapMerger$12(BinaryOperator mergeFunction, Map m12, Map m22) {
        for (Map.Entry entry : m22.entrySet()) {
            m12.merge(entry.getKey(), entry.getValue(), mergeFunction);
        }
        return m12;
    }

    public static <T, U, A, R> Collector<T, ?, R> mapping(final Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream) {
        final BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
        return new CollectorImpl(downstream.supplier(), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda34
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                BiConsumer.this.accept(obj, mapper.apply(obj2));
            }
        }, downstream.combiner(), downstream.finisher(), downstream.characteristics());
    }

    public static <T, U, A, R> Collector<T, ?, R> flatMapping(final Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream) {
        final BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
        return new CollectorImpl(downstream.supplier(), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda79
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$flatMapping$15(Function.this, downstreamAccumulator, obj, obj2);
            }
        }, downstream.combiner(), downstream.finisher(), downstream.characteristics());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$flatMapping$15(Function mapper, final BiConsumer downstreamAccumulator, final Object r10, Object t2) {
        Stream stream = (Stream) mapper.apply(t2);
        if (stream != null) {
            try {
                stream.sequential().forEach(new Consumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda88
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        BiConsumer.this.accept(r10, obj);
                    }
                });
            } catch (Throwable th) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (stream != null) {
            stream.close();
        }
    }

    public static <T, A, R> Collector<T, ?, R> filtering(final Predicate<? super T> predicate, Collector<? super T, A, R> downstream) {
        final BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
        return new CollectorImpl(downstream.supplier(), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda35
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$filtering$16(Predicate.this, downstreamAccumulator, obj, obj2);
            }
        }, downstream.combiner(), downstream.finisher(), downstream.characteristics());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$filtering$16(Predicate predicate, BiConsumer downstreamAccumulator, Object r10, Object t2) {
        if (predicate.test(t2)) {
            downstreamAccumulator.accept(r10, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> downstream, Function<R, RR> function) {
        Set<Collector.Characteristics> characteristics = downstream.characteristics();
        if (characteristics.contains(Collector.Characteristics.IDENTITY_FINISH)) {
            if (characteristics.size() == 1) {
                characteristics = CH_NOID;
            } else {
                Set<Collector.Characteristics> characteristics2 = EnumSet.copyOf((Collection) characteristics);
                characteristics2.remove(Collector.Characteristics.IDENTITY_FINISH);
                characteristics = Collections.unmodifiableSet(characteristics2);
            }
        }
        return new CollectorImpl(downstream.supplier(), downstream.accumulator(), downstream.combiner(), downstream.finisher().andThen(function), characteristics);
    }

    public static <T> Collector<T, ?, Long> counting() {
        return summingLong(new ToLongFunction() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda81
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return Collectors.lambda$counting$17(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long lambda$counting$17(Object e2) {
        return 1L;
    }

    public static <T> Collector<T, ?, Optional<T>> minBy(Comparator<? super T> comparator) {
        return reducing(BinaryOperator.minBy(comparator));
    }

    public static <T> Collector<T, ?, Optional<T>> maxBy(Comparator<? super T> comparator) {
        return reducing(BinaryOperator.maxBy(comparator));
    }

    public static <T> Collector<T, ?, Integer> summingInt(final ToIntFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda45
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$summingInt$18();
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda46
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$summingInt$19(ToIntFunction.this, (int[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda47
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summingInt$20((int[]) obj, (int[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda48
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Integer valueOf;
                valueOf = Integer.valueOf(((int[]) obj)[0]);
                return valueOf;
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int[] lambda$summingInt$18() {
        return new int[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$summingInt$19(ToIntFunction mapper, int[] a10, Object t2) {
        a10[0] = a10[0] + mapper.applyAsInt(t2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int[] lambda$summingInt$20(int[] a10, int[] b4) {
        a10[0] = a10[0] + b4[0];
        return a10;
    }

    public static <T> Collector<T, ?, Long> summingLong(final ToLongFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda89
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$summingLong$22();
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda90
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$summingLong$23(ToLongFunction.this, (long[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda91
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summingLong$24((long[]) obj, (long[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda92
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Long valueOf;
                valueOf = Long.valueOf(((long[]) obj)[0]);
                return valueOf;
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$summingLong$22() {
        return new long[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$summingLong$23(ToLongFunction mapper, long[] a10, Object t2) {
        a10[0] = a10[0] + mapper.applyAsLong(t2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$summingLong$24(long[] a10, long[] b4) {
        a10[0] = a10[0] + b4[0];
        return a10;
    }

    public static <T> Collector<T, ?, Double> summingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda66
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$summingDouble$26();
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda67
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$summingDouble$27(ToDoubleFunction.this, (double[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda68
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summingDouble$28((double[]) obj, (double[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda69
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                valueOf = Double.valueOf(Collectors.computeFinalSum((double[]) obj));
                return valueOf;
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$summingDouble$26() {
        return new double[3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$summingDouble$27(ToDoubleFunction mapper, double[] a10, Object t2) {
        double val = mapper.applyAsDouble(t2);
        sumWithCompensation(a10, val);
        a10[2] = a10[2] + val;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$summingDouble$28(double[] a10, double[] b4) {
        sumWithCompensation(a10, b4[0]);
        a10[2] = a10[2] + b4[2];
        return sumWithCompensation(a10, b4[1]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double[] sumWithCompensation(double[] intermediateSum, double value) {
        double tmp = value - intermediateSum[1];
        double sum = intermediateSum[0];
        double velvel = sum + tmp;
        intermediateSum[1] = (velvel - sum) - tmp;
        intermediateSum[0] = velvel;
        return intermediateSum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double computeFinalSum(double[] summands) {
        double tmp = summands[0] + summands[1];
        double simpleSum = summands[summands.length - 1];
        if (Double.isNaN(tmp) && Double.isInfinite(simpleSum)) {
            return simpleSum;
        }
        return tmp;
    }

    public static <T> Collector<T, ?, Double> averagingInt(final ToIntFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$averagingInt$30();
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda10
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$averagingInt$31(ToIntFunction.this, (long[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda11
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$averagingInt$32((long[]) obj, (long[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda12
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                long[] jArr = (long[]) obj;
                valueOf = Double.valueOf(a[1] == 0 ? ShadowDrawableWrapper.COS_45 : jArr[0] / jArr[1]);
                return valueOf;
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingInt$30() {
        return new long[2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$averagingInt$31(ToIntFunction mapper, long[] a10, Object t2) {
        a10[0] = a10[0] + mapper.applyAsInt(t2);
        a10[1] = a10[1] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingInt$32(long[] a10, long[] b4) {
        a10[0] = a10[0] + b4[0];
        a10[1] = a10[1] + b4[1];
        return a10;
    }

    public static <T> Collector<T, ?, Double> averagingLong(final ToLongFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda61
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$averagingLong$34();
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda62
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$averagingLong$35(ToLongFunction.this, (long[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda63
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$averagingLong$36((long[]) obj, (long[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda64
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Double valueOf;
                long[] jArr = (long[]) obj;
                valueOf = Double.valueOf(a[1] == 0 ? ShadowDrawableWrapper.COS_45 : jArr[0] / jArr[1]);
                return valueOf;
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingLong$34() {
        return new long[2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$averagingLong$35(ToLongFunction mapper, long[] a10, Object t2) {
        a10[0] = a10[0] + mapper.applyAsLong(t2);
        a10[1] = a10[1] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$averagingLong$36(long[] a10, long[] b4) {
        a10[0] = a10[0] + b4[0];
        a10[1] = a10[1] + b4[1];
        return a10;
    }

    public static <T> Collector<T, ?, Double> averagingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda70
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$averagingDouble$38();
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda71
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$averagingDouble$39(ToDoubleFunction.this, (double[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda72
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$averagingDouble$40((double[]) obj, (double[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda73
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$averagingDouble$41((double[]) obj);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$averagingDouble$38() {
        return new double[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$averagingDouble$39(ToDoubleFunction mapper, double[] a10, Object t2) {
        double val = mapper.applyAsDouble(t2);
        sumWithCompensation(a10, val);
        a10[2] = a10[2] + 1.0d;
        a10[3] = a10[3] + val;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$averagingDouble$40(double[] a10, double[] b4) {
        sumWithCompensation(a10, b4[0]);
        sumWithCompensation(a10, b4[1]);
        a10[2] = a10[2] + b4[2];
        a10[3] = a10[3] + b4[3];
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double lambda$averagingDouble$41(double[] a10) {
        double d10 = a10[2];
        double d11 = ShadowDrawableWrapper.COS_45;
        if (d10 != ShadowDrawableWrapper.COS_45) {
            d11 = computeFinalSum(a10) / a10[2];
        }
        return Double.valueOf(d11);
    }

    public static <T> Collector<T, ?, T> reducing(T identity, final BinaryOperator<T> op) {
        return new CollectorImpl(boxSupplier(identity), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda31
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$reducing$42(BinaryOperator.this, (Object[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda32
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$reducing$43(BinaryOperator.this, (Object[]) obj, (Object[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda33
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$reducing$44((Object[]) obj);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$reducing$42(BinaryOperator op, Object[] a10, Object t2) {
        a10[0] = op.apply(a10[0], t2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$reducing$43(BinaryOperator op, Object[] a10, Object[] b4) {
        a10[0] = op.apply(a10[0], b4[0]);
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$reducing$44(Object[] a10) {
        return a10[0];
    }

    private static <T> Supplier<T[]> boxSupplier(final T identity) {
        return new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$boxSupplier$45(Object.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$boxSupplier$45(Object identity) {
        return new Object[]{identity};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.Collectors$1OptionalBox, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C1OptionalBox<T> implements Consumer<T> {
        final /* synthetic */ BinaryOperator val$op;
        T value = null;
        boolean present = false;

        C1OptionalBox(BinaryOperator binaryOperator) {
            this.val$op = binaryOperator;
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            if (this.present) {
                this.value = this.val$op.apply(this.value, t2);
            } else {
                this.value = t2;
                this.present = true;
            }
        }
    }

    public static <T> Collector<T, ?, Optional<T>> reducing(final BinaryOperator<T> op) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda16
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$reducing$46(BinaryOperator.this);
            }
        }, new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda17
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Collectors.C1OptionalBox) obj).accept(obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda18
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$reducing$47((Collectors.C1OptionalBox) obj, (Collectors.C1OptionalBox) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda19
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Optional ofNullable;
                ofNullable = Optional.ofNullable(((Collectors.C1OptionalBox) obj).value);
                return ofNullable;
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ C1OptionalBox lambda$reducing$46(BinaryOperator op) {
        return new C1OptionalBox(op);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ C1OptionalBox lambda$reducing$47(C1OptionalBox a10, C1OptionalBox b4) {
        if (b4.present) {
            a10.accept(b4.value);
        }
        return a10;
    }

    public static <T, U> Collector<T, ?, U> reducing(U identity, final Function<? super T, ? extends U> mapper, final BinaryOperator<U> op) {
        return new CollectorImpl(boxSupplier(identity), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda36
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collectors.lambda$reducing$49(BinaryOperator.this, mapper, (Object[]) obj, obj2);
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda37
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$reducing$50(BinaryOperator.this, (Object[]) obj, (Object[]) obj2);
            }
        }, new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda38
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$reducing$51((Object[]) obj);
            }
        }, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$reducing$49(BinaryOperator op, Function mapper, Object[] a10, Object t2) {
        a10[0] = op.apply(a10[0], mapper.apply(t2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$reducing$50(BinaryOperator op, Object[] a10, Object[] b4) {
        a10[0] = op.apply(a10[0], b4[0]);
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$reducing$51(Object[] a10) {
        return a10[0];
    }

    public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier) {
        return groupingBy(classifier, toList());
    }

    public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream) {
        return groupingBy(classifier, new Collectors$$ExternalSyntheticLambda65(), downstream);
    }

    public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(final Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream) {
        final Supplier<A> downstreamSupplier = downstream.supplier();
        final BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
        BiConsumer<Map<K, A>, T> accumulator = new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda56
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                downstreamAccumulator.accept(((Map) obj).computeIfAbsent(Objects.requireNonNull(Function.this.apply(obj2), "element cannot be mapped to a null key"), new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda80
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        Object obj4;
                        obj4 = Supplier.this.get();
                        return obj4;
                    }
                }), obj2);
            }
        };
        BinaryOperator<Map<K, A>> merger = mapMerger(downstream.combiner());
        if (downstream.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return new CollectorImpl(mapFactory, accumulator, merger, CH_ID);
        }
        final Function<A, D> finisher = downstream.finisher();
        Function<Map<K, A>, M> finisher2 = new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda57
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$groupingBy$55(Function.this, (Map) obj);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, merger, finisher2, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$groupingBy$55(final Function downstreamFinisher, Map intermediate) {
        intermediate.replaceAll(new BiFunction() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda93
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = Function.this.apply(obj2);
                return apply;
            }
        });
        return intermediate;
    }

    public static <T, K> Collector<T, ?, ConcurrentMap<K, List<T>>> groupingByConcurrent(Function<? super T, ? extends K> classifier) {
        return groupingByConcurrent(classifier, new Collectors$$ExternalSyntheticLambda23(), toList());
    }

    public static <T, K, A, D> Collector<T, ?, ConcurrentMap<K, D>> groupingByConcurrent(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream) {
        return groupingByConcurrent(classifier, new Collectors$$ExternalSyntheticLambda23(), downstream);
    }

    public static <T, K, A, D, M extends ConcurrentMap<K, D>> Collector<T, ?, M> groupingByConcurrent(final Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream) {
        BiConsumer<ConcurrentMap<K, A>, T> accumulator;
        final Supplier<A> downstreamSupplier = downstream.supplier();
        final BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
        BinaryOperator<ConcurrentMap<K, A>> merger = mapMerger(downstream.combiner());
        if (downstream.characteristics().contains(Collector.Characteristics.CONCURRENT)) {
            accumulator = new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda20
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    downstreamAccumulator.accept(((ConcurrentMap) obj).computeIfAbsent(Objects.requireNonNull(Function.this.apply(obj2), "element cannot be mapped to a null key"), new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda82
                        @Override // java.util.function.Function
                        public final Object apply(Object obj3) {
                            Object obj4;
                            obj4 = Supplier.this.get();
                            return obj4;
                        }
                    }), obj2);
                }
            };
        } else {
            accumulator = new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda21
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Collectors.lambda$groupingByConcurrent$59(Function.this, downstreamSupplier, downstreamAccumulator, (ConcurrentMap) obj, obj2);
                }
            };
        }
        if (downstream.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return new CollectorImpl(mapFactory, accumulator, merger, CH_CONCURRENT_ID);
        }
        final Function<A, D> finisher = downstream.finisher();
        Function<ConcurrentMap<K, A>, M> finisher2 = new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda22
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$groupingByConcurrent$61(Function.this, (ConcurrentMap) obj);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, merger, finisher2, CH_CONCURRENT_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$groupingByConcurrent$59(Function classifier, final Supplier downstreamSupplier, BiConsumer downstreamAccumulator, ConcurrentMap m10, Object t2) {
        Object computeIfAbsent = m10.computeIfAbsent(Objects.requireNonNull(classifier.apply(t2), "element cannot be mapped to a null key"), new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object obj2;
                obj2 = Supplier.this.get();
                return obj2;
            }
        });
        synchronized (computeIfAbsent) {
            downstreamAccumulator.accept(computeIfAbsent, t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ConcurrentMap lambda$groupingByConcurrent$61(final Function downstreamFinisher, ConcurrentMap intermediate) {
        intermediate.replaceAll(new BiFunction() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda40
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = Function.this.apply(obj2);
                return apply;
            }
        });
        return intermediate;
    }

    public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
        return partitioningBy(predicate, toList());
    }

    public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningBy(final Predicate<? super T> predicate, final Collector<? super T, A, D> downstream) {
        final BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
        BiConsumer<Partition<A>, T> accumulator = new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda26
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                BiConsumer biConsumer = BiConsumer.this;
                Predicate predicate2 = predicate;
                biConsumer.accept(predicate.test(t) ? r3.forTrue : ((Collectors.Partition) obj).forFalse, obj2);
            }
        };
        final BinaryOperator<A> op = downstream.combiner();
        BinaryOperator<Partition<A>> merger = new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda27
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$partitioningBy$63(BinaryOperator.this, (Collectors.Partition) obj, (Collectors.Partition) obj2);
            }
        };
        Supplier<Partition<A>> supplier = new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda28
            @Override // java.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$partitioningBy$64(Collector.this);
            }
        };
        if (downstream.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return new CollectorImpl(supplier, accumulator, merger, CH_ID);
        }
        Function<Partition<A>, Map<Boolean, D>> finisher = new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda29
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$partitioningBy$65(Collector.this, (Collectors.Partition) obj);
            }
        };
        return new CollectorImpl(supplier, accumulator, merger, finisher, CH_NOID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Partition lambda$partitioningBy$63(BinaryOperator op, Partition left, Partition right) {
        return new Partition(op.apply(left.forTrue, right.forTrue), op.apply(left.forFalse, right.forFalse));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Partition lambda$partitioningBy$64(Collector downstream) {
        return new Partition(downstream.supplier().get(), downstream.supplier().get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$partitioningBy$65(Collector downstream, Partition par) {
        return new Partition(downstream.finisher().apply(par.forTrue), downstream.finisher().apply(par.forFalse));
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda65(), uniqKeysMapAccumulator(keyMapper, valueMapper), uniqKeysMapMerger(), CH_ID);
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toUnmodifiableMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        Objects.requireNonNull(keyMapper, "keyMapper");
        Objects.requireNonNull(valueMapper, "valueMapper");
        return collectingAndThen(toMap(keyMapper, valueMapper), new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda30
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Map ofEntries;
                ofEntries = Map.ofEntries((Map.Entry[]) ((Map) obj).entrySet().toArray(new Map.Entry[0]));
                return ofEntries;
            }
        });
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction) {
        return toMap(keyMapper, valueMapper, mergeFunction, new Collectors$$ExternalSyntheticLambda65());
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toUnmodifiableMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction) {
        Objects.requireNonNull(keyMapper, "keyMapper");
        Objects.requireNonNull(valueMapper, "valueMapper");
        Objects.requireNonNull(mergeFunction, "mergeFunction");
        return collectingAndThen(toMap(keyMapper, valueMapper, mergeFunction, new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda54
            @Override // java.util.function.Supplier
            public final Object get() {
                return new HashMap();
            }
        }), new Function() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda55
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Map ofEntries;
                ofEntries = Map.ofEntries((Map.Entry[]) ((HashMap) obj).entrySet().toArray(new Map.Entry[0]));
                return ofEntries;
            }
        });
    }

    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends U> valueMapper, final BinaryOperator<U> mergeFunction, Supplier<M> mapFactory) {
        BiConsumer<M, T> accumulator = new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda49
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Map map = (Map) obj;
                map.merge(Function.this.apply(obj2), valueMapper.apply(obj2), mergeFunction);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, mapMerger(mergeFunction), CH_ID);
    }

    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper) {
        return new CollectorImpl(new Supplier() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda25
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ConcurrentHashMap();
            }
        }, uniqKeysMapAccumulator(keyMapper, valueMapper), uniqKeysMapMerger(), CH_CONCURRENT_ID);
    }

    public static <T, K, U> Collector<T, ?, ConcurrentMap<K, U>> toConcurrentMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator<U> mergeFunction) {
        return toConcurrentMap(keyMapper, valueMapper, mergeFunction, new Collectors$$ExternalSyntheticLambda23());
    }

    public static <T, K, U, M extends ConcurrentMap<K, U>> Collector<T, ?, M> toConcurrentMap(final Function<? super T, ? extends K> keyMapper, final Function<? super T, ? extends U> valueMapper, final BinaryOperator<U> mergeFunction, Supplier<M> mapFactory) {
        BiConsumer<M, T> accumulator = new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda14
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ConcurrentMap concurrentMap = (ConcurrentMap) obj;
                concurrentMap.merge(Function.this.apply(obj2), valueMapper.apply(obj2), mergeFunction);
            }
        };
        return new CollectorImpl(mapFactory, accumulator, mapMerger(mergeFunction), CH_CONCURRENT_ID);
    }

    public static <T> Collector<T, ?, IntSummaryStatistics> summarizingInt(final ToIntFunction<? super T> mapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda58(), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda59
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((IntSummaryStatistics) obj).accept(ToIntFunction.this.applyAsInt(obj2));
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda60
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summarizingInt$71((IntSummaryStatistics) obj, (IntSummaryStatistics) obj2);
            }
        }, CH_ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ IntSummaryStatistics lambda$summarizingInt$71(IntSummaryStatistics l10, IntSummaryStatistics r10) {
        l10.combine(r10);
        return l10;
    }

    public static <T> Collector<T, ?, LongSummaryStatistics> summarizingLong(final ToLongFunction<? super T> mapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda5(), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda6
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LongSummaryStatistics) obj).accept(ToLongFunction.this.applyAsLong(obj2));
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda7
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summarizingLong$73((LongSummaryStatistics) obj, (LongSummaryStatistics) obj2);
            }
        }, CH_ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ LongSummaryStatistics lambda$summarizingLong$73(LongSummaryStatistics l10, LongSummaryStatistics r10) {
        l10.combine(r10);
        return l10;
    }

    public static <T> Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(final ToDoubleFunction<? super T> mapper) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda2(), new BiConsumer() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((DoubleSummaryStatistics) obj).accept(ToDoubleFunction.this.applyAsDouble(obj2));
            }
        }, new BinaryOperator() { // from class: java.util.stream.Collectors$$ExternalSyntheticLambda4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$summarizingDouble$75((DoubleSummaryStatistics) obj, (DoubleSummaryStatistics) obj2);
            }
        }, CH_ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DoubleSummaryStatistics lambda$summarizingDouble$75(DoubleSummaryStatistics l10, DoubleSummaryStatistics r10) {
        l10.combine(r10);
        return l10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Partition<T> extends AbstractMap<Boolean, T> implements Map<Boolean, T> {
        final T forFalse;
        final T forTrue;

        Partition(T forTrue, T forFalse) {
            this.forTrue = forTrue;
            this.forFalse = forFalse;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Boolean, T>> entrySet() {
            return new AbstractSet<Map.Entry<Boolean, T>>() { // from class: java.util.stream.Collectors.Partition.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                /* renamed from: iterator */
                public Iterator<Map.Entry<Boolean, T>> iterator2() {
                    Map.Entry<Boolean, T> falseEntry = new AbstractMap.SimpleImmutableEntry<>(false, Partition.this.forFalse);
                    Map.Entry<Boolean, T> trueEntry = new AbstractMap.SimpleImmutableEntry<>(true, Partition.this.forTrue);
                    return List.of(falseEntry, trueEntry).iterator2();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return 2;
                }
            };
        }
    }
}
