package java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.DoublePipeline;
import java.util.stream.IntPipeline;
import java.util.stream.LongPipeline;
import java.util.stream.Node;
import java.util.stream.ReferencePipeline;
import java.util.stream.Sink;
import java.util.stream.SpinedBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class SortedOps {
    private SortedOps() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Stream<T> makeRef(AbstractPipeline<?, T, ?> upstream) {
        return new OfRef(upstream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Stream<T> makeRef(AbstractPipeline<?, T, ?> upstream, Comparator<? super T> comparator) {
        return new OfRef(upstream, comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> IntStream makeInt(AbstractPipeline<?, Integer, ?> upstream) {
        return new OfInt(upstream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> LongStream makeLong(AbstractPipeline<?, Long, ?> upstream) {
        return new OfLong(upstream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> DoubleStream makeDouble(AbstractPipeline<?, Double, ?> upstream) {
        return new OfDouble(upstream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OfRef<T> extends ReferencePipeline.StatefulOp<T, T> {
        private final Comparator<? super T> comparator;
        private final boolean isNaturalSort;

        OfRef(AbstractPipeline<?, T, ?> upstream) {
            super(upstream, StreamShape.REFERENCE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
            this.isNaturalSort = true;
            Comparator<? super T> comp = Comparator.naturalOrder();
            this.comparator = comp;
        }

        OfRef(AbstractPipeline<?, T, ?> upstream, Comparator<? super T> comparator) {
            super(upstream, StreamShape.REFERENCE, StreamOpFlag.IS_ORDERED | StreamOpFlag.NOT_SORTED);
            this.isNaturalSort = false;
            this.comparator = (Comparator) Objects.requireNonNull(comparator);
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<T> opWrapSink(int flags, Sink<T> sink) {
            Objects.requireNonNull(sink);
            if (StreamOpFlag.SORTED.isKnown(flags) && this.isNaturalSort) {
                return sink;
            }
            if (StreamOpFlag.SIZED.isKnown(flags)) {
                return new SizedRefSortingSink(sink, this.comparator);
            }
            return new RefSortingSink(sink, this.comparator);
        }

        @Override // java.util.stream.ReferencePipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> helper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
            if (StreamOpFlag.SORTED.isKnown(helper.getStreamAndOpFlags()) && this.isNaturalSort) {
                return helper.evaluate(spliterator, false, generator);
            }
            T[] flattenedData = helper.evaluate(spliterator, true, generator).asArray(generator);
            Arrays.parallelSort(flattenedData, this.comparator);
            return Nodes.node(flattenedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OfInt extends IntPipeline.StatefulOp<Integer> {
        OfInt(AbstractPipeline<?, Integer, ?> upstream) {
            super(upstream, StreamShape.INT_VALUE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
            Objects.requireNonNull(sink);
            if (StreamOpFlag.SORTED.isKnown(flags)) {
                return sink;
            }
            if (StreamOpFlag.SIZED.isKnown(flags)) {
                return new SizedIntSortingSink(sink);
            }
            return new IntSortingSink(sink);
        }

        @Override // java.util.stream.IntPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> generator) {
            if (StreamOpFlag.SORTED.isKnown(helper.getStreamAndOpFlags())) {
                return helper.evaluate(spliterator, false, generator);
            }
            Node.OfInt n10 = (Node.OfInt) helper.evaluate(spliterator, true, generator);
            int[] content = n10.asPrimitiveArray();
            Arrays.parallelSort(content);
            return Nodes.node(content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OfLong extends LongPipeline.StatefulOp<Long> {
        OfLong(AbstractPipeline<?, Long, ?> upstream) {
            super(upstream, StreamShape.LONG_VALUE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
            Objects.requireNonNull(sink);
            if (StreamOpFlag.SORTED.isKnown(flags)) {
                return sink;
            }
            if (StreamOpFlag.SIZED.isKnown(flags)) {
                return new SizedLongSortingSink(sink);
            }
            return new LongSortingSink(sink);
        }

        @Override // java.util.stream.LongPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator, IntFunction<Long[]> generator) {
            if (StreamOpFlag.SORTED.isKnown(helper.getStreamAndOpFlags())) {
                return helper.evaluate(spliterator, false, generator);
            }
            Node.OfLong n10 = (Node.OfLong) helper.evaluate(spliterator, true, generator);
            long[] content = n10.asPrimitiveArray();
            Arrays.parallelSort(content);
            return Nodes.node(content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OfDouble extends DoublePipeline.StatefulOp<Double> {
        OfDouble(AbstractPipeline<?, Double, ?> upstream) {
            super(upstream, StreamShape.DOUBLE_VALUE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
            Objects.requireNonNull(sink);
            if (StreamOpFlag.SORTED.isKnown(flags)) {
                return sink;
            }
            if (StreamOpFlag.SIZED.isKnown(flags)) {
                return new SizedDoubleSortingSink(sink);
            }
            return new DoubleSortingSink(sink);
        }

        @Override // java.util.stream.DoublePipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator, IntFunction<Double[]> generator) {
            if (StreamOpFlag.SORTED.isKnown(helper.getStreamAndOpFlags())) {
                return helper.evaluate(spliterator, false, generator);
            }
            Node.OfDouble n10 = (Node.OfDouble) helper.evaluate(spliterator, true, generator);
            double[] content = n10.asPrimitiveArray();
            Arrays.parallelSort(content);
            return Nodes.node(content);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class AbstractRefSortingSink<T> extends Sink.ChainedReference<T, T> {
        protected boolean cancellationWasRequested;
        protected final Comparator<? super T> comparator;

        AbstractRefSortingSink(Sink<? super T> downstream, Comparator<? super T> comparator) {
            super(downstream);
            this.comparator = comparator;
        }

        @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationWasRequested = true;
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class SizedRefSortingSink<T> extends AbstractRefSortingSink<T> {
        private T[] array;
        private int offset;

        SizedRefSortingSink(Sink<? super T> sink, Comparator<? super T> comparator) {
            super(sink, comparator);
        }

        @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
        public void begin(long j10) {
            if (j10 >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = (T[]) new Object[(int) j10];
        }

        @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
        public void end() {
            Arrays.sort(this.array, 0, this.offset, this.comparator);
            this.downstream.begin(this.offset);
            if (!this.cancellationWasRequested) {
                for (int i10 = 0; i10 < this.offset; i10++) {
                    this.downstream.accept(this.array[i10]);
                }
            } else {
                for (int i11 = 0; i11 < this.offset && !this.downstream.cancellationRequested(); i11++) {
                    this.downstream.accept(this.array[i11]);
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            T[] tArr = this.array;
            int i10 = this.offset;
            this.offset = i10 + 1;
            tArr[i10] = t2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class RefSortingSink<T> extends AbstractRefSortingSink<T> {
        private ArrayList<T> list;

        RefSortingSink(Sink<? super T> sink, Comparator<? super T> comparator) {
            super(sink, comparator);
        }

        @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
        public void begin(long size) {
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.list = size >= 0 ? new ArrayList<>((int) size) : new ArrayList<>();
        }

        @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
        public void end() {
            this.list.sort(this.comparator);
            this.downstream.begin(this.list.size());
            if (!this.cancellationWasRequested) {
                ArrayList<T> arrayList = this.list;
                final Sink<? super E_OUT> sink = this.downstream;
                Objects.requireNonNull(sink);
                arrayList.forEach(new Consumer() { // from class: java.util.stream.SortedOps$RefSortingSink$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Sink.this.accept((Sink) obj);
                    }
                });
            } else {
                Iterator<T> iterator2 = this.list.iterator2();
                while (iterator2.hasNext()) {
                    T t2 = iterator2.next();
                    if (this.downstream.cancellationRequested()) {
                        break;
                    } else {
                        this.downstream.accept(t2);
                    }
                }
            }
            this.downstream.end();
            this.list = null;
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            this.list.add(t2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class AbstractIntSortingSink extends Sink.ChainedInt<Integer> {
        protected boolean cancellationWasRequested;

        AbstractIntSortingSink(Sink<? super Integer> downstream) {
            super(downstream);
        }

        @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationWasRequested = true;
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class SizedIntSortingSink extends AbstractIntSortingSink {
        private int[] array;
        private int offset;

        SizedIntSortingSink(Sink<? super Integer> downstream) {
            super(downstream);
        }

        @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
        public void begin(long size) {
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = new int[(int) size];
        }

        @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
        public void end() {
            Arrays.sort(this.array, 0, this.offset);
            this.downstream.begin(this.offset);
            if (!this.cancellationWasRequested) {
                for (int i10 = 0; i10 < this.offset; i10++) {
                    this.downstream.accept(this.array[i10]);
                }
            } else {
                for (int i11 = 0; i11 < this.offset && !this.downstream.cancellationRequested(); i11++) {
                    this.downstream.accept(this.array[i11]);
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
        public void accept(int t2) {
            int[] iArr = this.array;
            int i10 = this.offset;
            this.offset = i10 + 1;
            iArr[i10] = t2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class IntSortingSink extends AbstractIntSortingSink {

        /* renamed from: b, reason: collision with root package name */
        private SpinedBuffer.OfInt f50516b;

        IntSortingSink(Sink<? super Integer> sink) {
            super(sink);
        }

        @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
        public void begin(long size) {
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.f50516b = size > 0 ? new SpinedBuffer.OfInt((int) size) : new SpinedBuffer.OfInt();
        }

        @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
        public void end() {
            int[] ints = (int[]) this.f50516b.asPrimitiveArray();
            Arrays.sort(ints);
            this.downstream.begin(ints.length);
            int i10 = 0;
            if (!this.cancellationWasRequested) {
                int length = ints.length;
                while (i10 < length) {
                    int anInt = ints[i10];
                    this.downstream.accept(anInt);
                    i10++;
                }
            } else {
                int length2 = ints.length;
                while (i10 < length2) {
                    int anInt2 = ints[i10];
                    if (this.downstream.cancellationRequested()) {
                        break;
                    }
                    this.downstream.accept(anInt2);
                    i10++;
                }
            }
            this.downstream.end();
        }

        @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
        public void accept(int t2) {
            this.f50516b.accept(t2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class AbstractLongSortingSink extends Sink.ChainedLong<Long> {
        protected boolean cancellationWasRequested;

        AbstractLongSortingSink(Sink<? super Long> downstream) {
            super(downstream);
        }

        @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationWasRequested = true;
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class SizedLongSortingSink extends AbstractLongSortingSink {
        private long[] array;
        private int offset;

        SizedLongSortingSink(Sink<? super Long> downstream) {
            super(downstream);
        }

        @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
        public void begin(long size) {
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = new long[(int) size];
        }

        @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
        public void end() {
            Arrays.sort(this.array, 0, this.offset);
            this.downstream.begin(this.offset);
            if (!this.cancellationWasRequested) {
                for (int i10 = 0; i10 < this.offset; i10++) {
                    this.downstream.accept(this.array[i10]);
                }
            } else {
                for (int i11 = 0; i11 < this.offset && !this.downstream.cancellationRequested(); i11++) {
                    this.downstream.accept(this.array[i11]);
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
        public void accept(long t2) {
            long[] jArr = this.array;
            int i10 = this.offset;
            this.offset = i10 + 1;
            jArr[i10] = t2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class LongSortingSink extends AbstractLongSortingSink {

        /* renamed from: b, reason: collision with root package name */
        private SpinedBuffer.OfLong f50517b;

        LongSortingSink(Sink<? super Long> sink) {
            super(sink);
        }

        @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
        public void begin(long size) {
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.f50517b = size > 0 ? new SpinedBuffer.OfLong((int) size) : new SpinedBuffer.OfLong();
        }

        @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
        public void end() {
            long[] longs = (long[]) this.f50517b.asPrimitiveArray();
            Arrays.sort(longs);
            this.downstream.begin(longs.length);
            int i10 = 0;
            if (!this.cancellationWasRequested) {
                int length = longs.length;
                while (i10 < length) {
                    long aLong = longs[i10];
                    this.downstream.accept(aLong);
                    i10++;
                }
            } else {
                int length2 = longs.length;
                while (i10 < length2) {
                    long aLong2 = longs[i10];
                    if (this.downstream.cancellationRequested()) {
                        break;
                    }
                    this.downstream.accept(aLong2);
                    i10++;
                }
            }
            this.downstream.end();
        }

        @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
        public void accept(long t2) {
            this.f50517b.accept(t2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class AbstractDoubleSortingSink extends Sink.ChainedDouble<Double> {
        protected boolean cancellationWasRequested;

        AbstractDoubleSortingSink(Sink<? super Double> downstream) {
            super(downstream);
        }

        @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
        public final boolean cancellationRequested() {
            this.cancellationWasRequested = true;
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class SizedDoubleSortingSink extends AbstractDoubleSortingSink {
        private double[] array;
        private int offset;

        SizedDoubleSortingSink(Sink<? super Double> downstream) {
            super(downstream);
        }

        @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
        public void begin(long size) {
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.array = new double[(int) size];
        }

        @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
        public void end() {
            Arrays.sort(this.array, 0, this.offset);
            this.downstream.begin(this.offset);
            if (!this.cancellationWasRequested) {
                for (int i10 = 0; i10 < this.offset; i10++) {
                    this.downstream.accept(this.array[i10]);
                }
            } else {
                for (int i11 = 0; i11 < this.offset && !this.downstream.cancellationRequested(); i11++) {
                    this.downstream.accept(this.array[i11]);
                }
            }
            this.downstream.end();
            this.array = null;
        }

        @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t2) {
            double[] dArr = this.array;
            int i10 = this.offset;
            this.offset = i10 + 1;
            dArr[i10] = t2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class DoubleSortingSink extends AbstractDoubleSortingSink {

        /* renamed from: b, reason: collision with root package name */
        private SpinedBuffer.OfDouble f50515b;

        DoubleSortingSink(Sink<? super Double> sink) {
            super(sink);
        }

        @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
        public void begin(long size) {
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.f50515b = size > 0 ? new SpinedBuffer.OfDouble((int) size) : new SpinedBuffer.OfDouble();
        }

        @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
        public void end() {
            double[] doubles = (double[]) this.f50515b.asPrimitiveArray();
            Arrays.sort(doubles);
            this.downstream.begin(doubles.length);
            int i10 = 0;
            if (!this.cancellationWasRequested) {
                int length = doubles.length;
                while (i10 < length) {
                    double aDouble = doubles[i10];
                    this.downstream.accept(aDouble);
                    i10++;
                }
            } else {
                int length2 = doubles.length;
                while (i10 < length2) {
                    double aDouble2 = doubles[i10];
                    if (this.downstream.cancellationRequested()) {
                        break;
                    }
                    this.downstream.accept(aDouble2);
                    i10++;
                }
            }
            this.downstream.end();
        }

        @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t2) {
            this.f50515b.accept(t2);
        }
    }
}
