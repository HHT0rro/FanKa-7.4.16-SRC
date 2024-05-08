package java.util.stream;

import com.android.internal.logging.nano.MetricsProto;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.StreamSpliterators;
import java.util.stream.Streams;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface IntStream extends BaseStream<Integer, IntStream> {
    boolean allMatch(IntPredicate intPredicate);

    boolean anyMatch(IntPredicate intPredicate);

    DoubleStream asDoubleStream();

    LongStream asLongStream();

    OptionalDouble average();

    Stream<Integer> boxed();

    <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> objIntConsumer, BiConsumer<R, R> biConsumer);

    long count();

    IntStream distinct();

    IntStream filter(IntPredicate intPredicate);

    OptionalInt findAny();

    OptionalInt findFirst();

    IntStream flatMap(IntFunction<? extends IntStream> intFunction);

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    @Override // java.util.stream.BaseStream, java.util.stream.DoubleStream
    Iterator<Integer> iterator();

    IntStream limit(long j10);

    IntStream map(IntUnaryOperator intUnaryOperator);

    DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction);

    LongStream mapToLong(IntToLongFunction intToLongFunction);

    <U> Stream<U> mapToObj(IntFunction<? extends U> intFunction);

    OptionalInt max();

    OptionalInt min();

    boolean noneMatch(IntPredicate intPredicate);

    @Override // java.util.stream.BaseStream
    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    int reduce(int i10, IntBinaryOperator intBinaryOperator);

    OptionalInt reduce(IntBinaryOperator intBinaryOperator);

    @Override // java.util.stream.BaseStream
    IntStream sequential();

    IntStream skip(long j10);

    IntStream sorted();

    @Override // java.util.stream.BaseStream
    /* renamed from: spliterator, reason: merged with bridge method [inline-methods] */
    Spliterator<Integer> spliterator2();

    int sum();

    IntSummaryStatistics summaryStatistics();

    int[] toArray();

    static Builder builder() {
        return new Streams.IntStreamBuilderImpl();
    }

    static IntStream empty() {
        return StreamSupport.intStream(Spliterators.emptyIntSpliterator(), false);
    }

    static IntStream of(int t2) {
        return StreamSupport.intStream(new Streams.IntStreamBuilderImpl(t2), false);
    }

    static IntStream of(int... values) {
        return Arrays.stream(values);
    }

    static IntStream iterate(int seed, IntUnaryOperator f10) {
        Objects.requireNonNull(f10);
        PrimitiveIterator.OfInt iterator = new PrimitiveIterator.OfInt(seed, f10) { // from class: java.util.stream.IntStream.1

            /* renamed from: t, reason: collision with root package name */
            int f50504t;
            final /* synthetic */ IntUnaryOperator val$f;
            final /* synthetic */ int val$seed;

            {
                this.val$seed = seed;
                this.val$f = f10;
                this.f50504t = seed;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return true;
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                int v2 = this.f50504t;
                this.f50504t = this.val$f.applyAsInt(this.f50504t);
                return v2;
            }
        };
        return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(iterator, MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_CONNECT), false);
    }

    static IntStream generate(IntSupplier s2) {
        Objects.requireNonNull(s2);
        return StreamSupport.intStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfInt(Long.MAX_VALUE, s2), false);
    }

    static IntStream range(int startInclusive, int endExclusive) {
        if (startInclusive >= endExclusive) {
            return empty();
        }
        return StreamSupport.intStream(new Streams.RangeIntSpliterator(startInclusive, endExclusive, false), false);
    }

    static IntStream rangeClosed(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            return empty();
        }
        return StreamSupport.intStream(new Streams.RangeIntSpliterator(startInclusive, endInclusive, true), false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Spliterator$OfInt] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Spliterator$OfInt] */
    static IntStream concat(IntStream a10, IntStream b4) {
        Objects.requireNonNull(a10);
        Objects.requireNonNull(b4);
        Spliterator.OfInt split = new Streams.ConcatSpliterator.OfInt(a10.spliterator2(), b4.spliterator2());
        IntStream stream = StreamSupport.intStream(split, a10.isParallel() || b4.isParallel());
        return stream.onClose(Streams.composedClose(a10, b4));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Builder extends IntConsumer {
        @Override // java.util.function.IntConsumer
        void accept(int i10);

        IntStream build();

        default Builder add(int t2) {
            accept(t2);
            return this;
        }
    }
}
