package java.util.stream;

import com.android.internal.logging.nano.MetricsProto;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.StreamSpliterators;
import java.util.stream.Streams;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DoubleStream extends BaseStream<Double, DoubleStream> {
    boolean allMatch(DoublePredicate doublePredicate);

    boolean anyMatch(DoublePredicate doublePredicate);

    OptionalDouble average();

    Stream<Double> boxed();

    <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> objDoubleConsumer, BiConsumer<R, R> biConsumer);

    long count();

    DoubleStream distinct();

    DoubleStream filter(DoublePredicate doublePredicate);

    OptionalDouble findAny();

    OptionalDouble findFirst();

    DoubleStream flatMap(DoubleFunction<? extends DoubleStream> doubleFunction);

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    @Override // 
    Iterator<Double> iterator();

    DoubleStream limit(long j10);

    DoubleStream map(DoubleUnaryOperator doubleUnaryOperator);

    IntStream mapToInt(DoubleToIntFunction doubleToIntFunction);

    LongStream mapToLong(DoubleToLongFunction doubleToLongFunction);

    <U> Stream<U> mapToObj(DoubleFunction<? extends U> doubleFunction);

    OptionalDouble max();

    OptionalDouble min();

    boolean noneMatch(DoublePredicate doublePredicate);

    @Override // java.util.stream.BaseStream
    DoubleStream parallel();

    DoubleStream peek(DoubleConsumer doubleConsumer);

    double reduce(double d10, DoubleBinaryOperator doubleBinaryOperator);

    OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator);

    @Override // java.util.stream.BaseStream
    DoubleStream sequential();

    DoubleStream skip(long j10);

    DoubleStream sorted();

    @Override // java.util.stream.BaseStream
    /* renamed from: spliterator */
    Spliterator<Double> spliterator2();

    double sum();

    DoubleSummaryStatistics summaryStatistics();

    double[] toArray();

    static Builder builder() {
        return new Streams.DoubleStreamBuilderImpl();
    }

    static DoubleStream empty() {
        return StreamSupport.doubleStream(Spliterators.emptyDoubleSpliterator(), false);
    }

    static DoubleStream of(double t2) {
        return StreamSupport.doubleStream(new Streams.DoubleStreamBuilderImpl(t2), false);
    }

    static DoubleStream of(double... values) {
        return Arrays.stream(values);
    }

    static DoubleStream iterate(double seed, DoubleUnaryOperator f10) {
        Objects.requireNonNull(f10);
        PrimitiveIterator.OfDouble iterator = new PrimitiveIterator.OfDouble(seed, f10) { // from class: java.util.stream.DoubleStream.1

            /* renamed from: t, reason: collision with root package name */
            double f50503t;
            final /* synthetic */ DoubleUnaryOperator val$f;
            final /* synthetic */ double val$seed;

            {
                this.val$seed = seed;
                this.val$f = f10;
                this.f50503t = seed;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return true;
            }

            @Override // java.util.PrimitiveIterator.OfDouble
            public double nextDouble() {
                double v2 = this.f50503t;
                this.f50503t = this.val$f.applyAsDouble(this.f50503t);
                return v2;
            }
        };
        return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize(iterator, MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_CONNECT), false);
    }

    static DoubleStream generate(DoubleSupplier s2) {
        Objects.requireNonNull(s2);
        return StreamSupport.doubleStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble(Long.MAX_VALUE, s2), false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Spliterator$OfDouble] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Spliterator$OfDouble] */
    static DoubleStream concat(DoubleStream a10, DoubleStream b4) {
        Objects.requireNonNull(a10);
        Objects.requireNonNull(b4);
        Spliterator.OfDouble split = new Streams.ConcatSpliterator.OfDouble(a10.spliterator2(), b4.spliterator2());
        DoubleStream stream = StreamSupport.doubleStream(split, a10.isParallel() || b4.isParallel());
        return stream.onClose(Streams.composedClose(a10, b4));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Builder extends DoubleConsumer {
        @Override // java.util.function.DoubleConsumer
        void accept(double d10);

        DoubleStream build();

        default Builder add(double t2) {
            accept(t2);
            return this;
        }
    }
}
