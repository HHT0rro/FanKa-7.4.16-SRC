package java.util.stream;

import com.android.internal.logging.nano.MetricsProto;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LongSummaryStatistics;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.StreamSpliterators;
import java.util.stream.Streams;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface LongStream extends BaseStream<Long, LongStream> {
    boolean allMatch(LongPredicate longPredicate);

    boolean anyMatch(LongPredicate longPredicate);

    DoubleStream asDoubleStream();

    OptionalDouble average();

    Stream<Long> boxed();

    <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> objLongConsumer, BiConsumer<R, R> biConsumer);

    long count();

    LongStream distinct();

    LongStream filter(LongPredicate longPredicate);

    OptionalLong findAny();

    OptionalLong findFirst();

    LongStream flatMap(LongFunction<? extends LongStream> longFunction);

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    @Override // java.util.stream.BaseStream, java.util.stream.DoubleStream
    Iterator<Long> iterator();

    LongStream limit(long j10);

    LongStream map(LongUnaryOperator longUnaryOperator);

    DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction);

    IntStream mapToInt(LongToIntFunction longToIntFunction);

    <U> Stream<U> mapToObj(LongFunction<? extends U> longFunction);

    OptionalLong max();

    OptionalLong min();

    boolean noneMatch(LongPredicate longPredicate);

    @Override // java.util.stream.BaseStream
    LongStream parallel();

    LongStream peek(LongConsumer longConsumer);

    long reduce(long j10, LongBinaryOperator longBinaryOperator);

    OptionalLong reduce(LongBinaryOperator longBinaryOperator);

    @Override // java.util.stream.BaseStream
    LongStream sequential();

    LongStream skip(long j10);

    LongStream sorted();

    @Override // java.util.stream.BaseStream
    /* renamed from: spliterator */
    Spliterator<Long> spliterator2();

    long sum();

    LongSummaryStatistics summaryStatistics();

    long[] toArray();

    static Builder builder() {
        return new Streams.LongStreamBuilderImpl();
    }

    static LongStream empty() {
        return StreamSupport.longStream(Spliterators.emptyLongSpliterator(), false);
    }

    static LongStream of(long t2) {
        return StreamSupport.longStream(new Streams.LongStreamBuilderImpl(t2), false);
    }

    static LongStream of(long... values) {
        return Arrays.stream(values);
    }

    static LongStream iterate(long seed, LongUnaryOperator f10) {
        Objects.requireNonNull(f10);
        PrimitiveIterator.OfLong iterator = new PrimitiveIterator.OfLong(seed, f10) { // from class: java.util.stream.LongStream.1

            /* renamed from: t, reason: collision with root package name */
            long f50505t;
            final /* synthetic */ LongUnaryOperator val$f;
            final /* synthetic */ long val$seed;

            {
                this.val$seed = seed;
                this.val$f = f10;
                this.f50505t = seed;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return true;
            }

            @Override // java.util.PrimitiveIterator.OfLong
            public long nextLong() {
                long v2 = this.f50505t;
                this.f50505t = this.val$f.applyAsLong(this.f50505t);
                return v2;
            }
        };
        return StreamSupport.longStream(Spliterators.spliteratorUnknownSize(iterator, MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_CONNECT), false);
    }

    static LongStream generate(LongSupplier s2) {
        Objects.requireNonNull(s2);
        return StreamSupport.longStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfLong(Long.MAX_VALUE, s2), false);
    }

    static LongStream range(long startInclusive, long endExclusive) {
        if (startInclusive >= endExclusive) {
            return empty();
        }
        if (endExclusive - startInclusive < 0) {
            long m10 = Long.divideUnsigned(endExclusive - startInclusive, 2L) + startInclusive + 1;
            return concat(range(startInclusive, m10), range(m10, endExclusive));
        }
        return StreamSupport.longStream(new Streams.RangeLongSpliterator(startInclusive, endExclusive, false), false);
    }

    static LongStream rangeClosed(long startInclusive, long endInclusive) {
        if (startInclusive > endInclusive) {
            return empty();
        }
        if ((endInclusive - startInclusive) + 1 <= 0) {
            long m10 = Long.divideUnsigned(endInclusive - startInclusive, 2L) + startInclusive + 1;
            return concat(range(startInclusive, m10), rangeClosed(m10, endInclusive));
        }
        return StreamSupport.longStream(new Streams.RangeLongSpliterator(startInclusive, endInclusive, true), false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Spliterator$OfLong] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Spliterator$OfLong] */
    static LongStream concat(LongStream a10, LongStream b4) {
        Objects.requireNonNull(a10);
        Objects.requireNonNull(b4);
        Spliterator.OfLong split = new Streams.ConcatSpliterator.OfLong(a10.spliterator2(), b4.spliterator2());
        LongStream stream = StreamSupport.longStream(split, a10.isParallel() || b4.isParallel());
        return stream.onClose(Streams.composedClose(a10, b4));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Builder extends LongConsumer {
        @Override // java.util.function.LongConsumer
        void accept(long j10);

        LongStream build();

        default Builder add(long t2) {
            accept(t2);
            return this;
        }
    }
}
