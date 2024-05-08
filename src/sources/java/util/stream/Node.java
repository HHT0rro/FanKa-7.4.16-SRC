package java.util.stream;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.stream.Node;
import java.util.stream.Sink;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Node<T> {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Builder<T> extends Sink<T> {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public interface OfDouble extends Builder<Double>, Sink.OfDouble {
            @Override // java.util.stream.Node.Builder
            /* renamed from: build */
            Node<Double> build2();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public interface OfInt extends Builder<Integer>, Sink.OfInt {
            @Override // java.util.stream.Node.Builder
            /* renamed from: build */
            Node<Integer> build2();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public interface OfLong extends Builder<Long>, Sink.OfLong {
            @Override // java.util.stream.Node.Builder
            /* renamed from: build */
            Node<Long> build2();
        }

        /* renamed from: build */
        Node<T> build2();
    }

    T[] asArray(IntFunction<T[]> intFunction);

    void copyInto(T[] tArr, int i10);

    long count();

    void forEach(Consumer<? super T> consumer);

    Spliterator<T> spliterator();

    default int getChildCount() {
        return 0;
    }

    default Node<T> getChild(int i10) {
        throw new IndexOutOfBoundsException();
    }

    default Node<T> truncate(long from, long to, IntFunction<T[]> generator) {
        if (from == 0 && to == count()) {
            return this;
        }
        Spliterator<T> spliterator = spliterator();
        long size = to - from;
        Builder<T> nodeBuilder = Nodes.builder(size, generator);
        nodeBuilder.begin(size);
        for (int i10 = 0; i10 < from && spliterator.tryAdvance(new Consumer() { // from class: java.util.stream.Node$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Node.lambda$truncate$0(obj);
            }
        }); i10++) {
        }
        for (int i11 = 0; i11 < size && spliterator.tryAdvance(nodeBuilder); i11++) {
        }
        nodeBuilder.end();
        return nodeBuilder.build2();
    }

    static /* synthetic */ void lambda$truncate$0(Object e2) {
    }

    default StreamShape getShape() {
        return StreamShape.REFERENCE;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends Node<T> {
        T_ARR asPrimitiveArray();

        void copyInto(T_ARR t_arr, int i10);

        void forEach(T_CONS t_cons);

        T_ARR newArray(int i10);

        @Override // java.util.stream.Node
        T_SPLITR spliterator();

        @Override // java.util.stream.Node
        T_NODE truncate(long j10, long j11, IntFunction<T[]> intFunction);

        @Override // java.util.stream.Node
        default T_NODE getChild(int i10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.stream.Node
        default T[] asArray(IntFunction<T[]> generator) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Node.OfPrimitive.asArray");
            }
            long size = count();
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            T[] boxed = generator.apply((int) count());
            copyInto((Object[]) boxed, 0);
            return boxed;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, OfInt> {
        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        /* bridge */ /* synthetic */ default OfPrimitive truncate(long j10, long j11, IntFunction intFunction) {
            return truncate(j10, j11, (IntFunction<Integer[]>) intFunction);
        }

        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        /* bridge */ /* synthetic */ default Node truncate(long j10, long j11, IntFunction intFunction) {
            return truncate(j10, j11, (IntFunction<Integer[]>) intFunction);
        }

        @Override // java.util.stream.Node
        default void forEach(Consumer<? super Integer> consumer) {
            if (consumer instanceof IntConsumer) {
                forEach((OfInt) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        @Override // java.util.stream.Node
        default void copyInto(Integer[] boxed, int offset) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            }
            int[] array = asPrimitiveArray();
            for (int i10 = 0; i10 < array.length; i10++) {
                boxed[offset + i10] = Integer.valueOf(array[i10]);
            }
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [java.util.stream.Node$OfInt] */
        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        default OfInt truncate(long from, long to, IntFunction<Integer[]> generator) {
            if (from == 0 && to == count()) {
                return this;
            }
            long size = to - from;
            Spliterator.OfInt spliterator = spliterator();
            Builder.OfInt nodeBuilder = Nodes.intBuilder(size);
            nodeBuilder.begin(size);
            for (int i10 = 0; i10 < from && spliterator.tryAdvance(new IntConsumer() { // from class: java.util.stream.Node$OfInt$$ExternalSyntheticLambda0
                @Override // java.util.function.IntConsumer
                public final void accept(int i11) {
                    Node.OfInt.lambda$truncate$0(i11);
                }
            }); i10++) {
            }
            for (int i11 = 0; i11 < size && spliterator.tryAdvance((IntConsumer) nodeBuilder); i11++) {
            }
            nodeBuilder.end();
            return nodeBuilder.build2();
        }

        static /* synthetic */ void lambda$truncate$0(int e2) {
        }

        @Override // java.util.stream.Node.OfPrimitive
        default int[] newArray(int count) {
            return new int[count];
        }

        @Override // java.util.stream.Node
        default StreamShape getShape() {
            return StreamShape.INT_VALUE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, OfLong> {
        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        /* bridge */ /* synthetic */ default OfPrimitive truncate(long j10, long j11, IntFunction intFunction) {
            return truncate(j10, j11, (IntFunction<Long[]>) intFunction);
        }

        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        /* bridge */ /* synthetic */ default Node truncate(long j10, long j11, IntFunction intFunction) {
            return truncate(j10, j11, (IntFunction<Long[]>) intFunction);
        }

        @Override // java.util.stream.Node
        default void forEach(Consumer<? super Long> consumer) {
            if (consumer instanceof LongConsumer) {
                forEach((OfLong) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        @Override // java.util.stream.Node
        default void copyInto(Long[] boxed, int offset) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            }
            long[] array = asPrimitiveArray();
            for (int i10 = 0; i10 < array.length; i10++) {
                boxed[offset + i10] = Long.valueOf(array[i10]);
            }
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [java.util.stream.Node$OfLong] */
        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        default OfLong truncate(long from, long to, IntFunction<Long[]> generator) {
            if (from == 0 && to == count()) {
                return this;
            }
            long size = to - from;
            Spliterator.OfLong spliterator = spliterator();
            Builder.OfLong nodeBuilder = Nodes.longBuilder(size);
            nodeBuilder.begin(size);
            for (int i10 = 0; i10 < from && spliterator.tryAdvance(new LongConsumer() { // from class: java.util.stream.Node$OfLong$$ExternalSyntheticLambda0
                @Override // java.util.function.LongConsumer
                public final void accept(long j10) {
                    Node.OfLong.lambda$truncate$0(j10);
                }
            }); i10++) {
            }
            for (int i11 = 0; i11 < size && spliterator.tryAdvance((LongConsumer) nodeBuilder); i11++) {
            }
            nodeBuilder.end();
            return nodeBuilder.build2();
        }

        static /* synthetic */ void lambda$truncate$0(long e2) {
        }

        @Override // java.util.stream.Node.OfPrimitive
        default long[] newArray(int count) {
            return new long[count];
        }

        @Override // java.util.stream.Node
        default StreamShape getShape() {
            return StreamShape.LONG_VALUE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, OfDouble> {
        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        /* bridge */ /* synthetic */ default OfPrimitive truncate(long j10, long j11, IntFunction intFunction) {
            return truncate(j10, j11, (IntFunction<Double[]>) intFunction);
        }

        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        /* bridge */ /* synthetic */ default Node truncate(long j10, long j11, IntFunction intFunction) {
            return truncate(j10, j11, (IntFunction<Double[]>) intFunction);
        }

        @Override // java.util.stream.Node
        default void forEach(Consumer<? super Double> consumer) {
            if (consumer instanceof DoubleConsumer) {
                forEach((OfDouble) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        @Override // java.util.stream.Node
        default void copyInto(Double[] boxed, int offset) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            }
            double[] array = asPrimitiveArray();
            for (int i10 = 0; i10 < array.length; i10++) {
                boxed[offset + i10] = Double.valueOf(array[i10]);
            }
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [java.util.stream.Node$OfDouble] */
        @Override // java.util.stream.Node.OfPrimitive, java.util.stream.Node
        default OfDouble truncate(long from, long to, IntFunction<Double[]> generator) {
            if (from == 0 && to == count()) {
                return this;
            }
            long size = to - from;
            Spliterator.OfDouble spliterator = spliterator();
            Builder.OfDouble nodeBuilder = Nodes.doubleBuilder(size);
            nodeBuilder.begin(size);
            for (int i10 = 0; i10 < from && spliterator.tryAdvance(new DoubleConsumer() { // from class: java.util.stream.Node$OfDouble$$ExternalSyntheticLambda0
                @Override // java.util.function.DoubleConsumer
                public final void accept(double d10) {
                    Node.OfDouble.lambda$truncate$0(d10);
                }
            }); i10++) {
            }
            for (int i11 = 0; i11 < size && spliterator.tryAdvance((DoubleConsumer) nodeBuilder); i11++) {
            }
            nodeBuilder.end();
            return nodeBuilder.build2();
        }

        static /* synthetic */ void lambda$truncate$0(double e2) {
        }

        @Override // java.util.stream.Node.OfPrimitive
        default double[] newArray(int count) {
            return new double[count];
        }

        @Override // java.util.stream.Node
        default StreamShape getShape() {
            return StreamShape.DOUBLE_VALUE;
        }
    }
}
