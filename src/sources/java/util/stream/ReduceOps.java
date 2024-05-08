package java.util.stream;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Sink;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class ReduceOps {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface AccumulatingSink<T, R, K extends AccumulatingSink<T, R, K>> extends TerminalSink<T, R> {
        void combine(K k10);
    }

    private ReduceOps() {
    }

    public static <T, U> TerminalOp<T, U> makeRef(final U seed, final BiFunction<U, ? super T, U> reducer, final BinaryOperator<U> combiner) {
        Objects.requireNonNull(reducer);
        Objects.requireNonNull(combiner);
        return new ReduceOp<T, U, C1ReducingSink>(StreamShape.REFERENCE) { // from class: java.util.stream.ReduceOps.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C1ReducingSink makeSink() {
                return new C1ReducingSink(seed, reducer, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T, U] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$1ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C1ReducingSink<T, U> extends Box<U> implements AccumulatingSink<T, U, C1ReducingSink> {
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ BiFunction val$reducer;
        final /* synthetic */ Object val$seed;

        C1ReducingSink(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
            this.val$seed = obj;
            this.val$reducer = biFunction;
            this.val$combiner = binaryOperator;
        }

        @Override // java.util.stream.Sink
        public void begin(long j10) {
            this.state = (U) this.val$seed;
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            this.state = (U) this.val$reducer.apply(this.state, t2);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C1ReducingSink c1ReducingSink) {
            this.state = (U) this.val$combiner.apply(this.state, c1ReducingSink.state);
        }
    }

    public static <T> TerminalOp<T, Optional<T>> makeRef(final BinaryOperator<T> operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<T, Optional<T>, C2ReducingSink>(StreamShape.REFERENCE) { // from class: java.util.stream.ReduceOps.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C2ReducingSink makeSink() {
                final BinaryOperator binaryOperator = operator;
                return new AccumulatingSink<T, Optional<T>, C2ReducingSink>() { // from class: java.util.stream.ReduceOps.2ReducingSink
                    private boolean empty;
                    private T state;

                    @Override // java.util.stream.Sink
                    public void begin(long size) {
                        this.empty = true;
                        this.state = null;
                    }

                    @Override // java.util.function.Consumer
                    public void accept(T t2) {
                        if (this.empty) {
                            this.empty = false;
                            this.state = t2;
                        } else {
                            this.state = BinaryOperator.this.apply(this.state, t2);
                        }
                    }

                    @Override // java.util.function.Supplier
                    public Optional<T> get() {
                        return this.empty ? Optional.empty() : Optional.of(this.state);
                    }

                    @Override // java.util.stream.ReduceOps.AccumulatingSink
                    public void combine(C2ReducingSink other) {
                        if (!other.empty) {
                            accept((C2ReducingSink<T>) other.state);
                        }
                    }
                };
            }
        };
    }

    public static <T, I> TerminalOp<T, I> makeRef(final Collector<? super T, I, ?> collector) {
        final Supplier<I> supplier = ((Collector) Objects.requireNonNull(collector)).supplier();
        final BiConsumer<I, ? super T> accumulator = collector.accumulator();
        final BinaryOperator<I> combiner = collector.combiner();
        return new ReduceOp<T, I, C3ReducingSink>(StreamShape.REFERENCE) { // from class: java.util.stream.ReduceOps.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C3ReducingSink makeSink() {
                return new C3ReducingSink(supplier, accumulator, combiner);
            }

            @Override // java.util.stream.TerminalOp
            public int getOpFlags() {
                if (collector.characteristics().contains(Collector.Characteristics.UNORDERED)) {
                    return StreamOpFlag.NOT_ORDERED;
                }
                return 0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T, I] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$3ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C3ReducingSink<I, T> extends Box<I> implements AccumulatingSink<T, I, C3ReducingSink> {
        final /* synthetic */ BiConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        C3ReducingSink(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = biConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            this.val$accumulator.accept(this.state, t2);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C3ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    public static <T, R> TerminalOp<T, R> makeRef(final Supplier<R> seedFactory, final BiConsumer<R, ? super T> accumulator, final BiConsumer<R, R> reducer) {
        Objects.requireNonNull(seedFactory);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(reducer);
        return new ReduceOp<T, R, C4ReducingSink>(StreamShape.REFERENCE) { // from class: java.util.stream.ReduceOps.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C4ReducingSink makeSink() {
                return new C4ReducingSink(seedFactory, accumulator, reducer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$4ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C4ReducingSink<R, T> extends Box<R> implements AccumulatingSink<T, R, C4ReducingSink> {
        final /* synthetic */ BiConsumer val$accumulator;
        final /* synthetic */ BiConsumer val$reducer;
        final /* synthetic */ Supplier val$seedFactory;

        C4ReducingSink(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
            this.val$seedFactory = supplier;
            this.val$accumulator = biConsumer;
            this.val$reducer = biConsumer2;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$seedFactory.get();
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            this.val$accumulator.accept(this.state, t2);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C4ReducingSink other) {
            this.val$reducer.accept(this.state, other.state);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$5ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C5ReducingSink implements AccumulatingSink<Integer, Integer, C5ReducingSink>, Sink.OfInt {
        private int state;
        final /* synthetic */ int val$identity;
        final /* synthetic */ IntBinaryOperator val$operator;

        C5ReducingSink(int i10, IntBinaryOperator intBinaryOperator) {
            this.val$identity = i10;
            this.val$operator = intBinaryOperator;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$identity;
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfInt, java.util.function.IntConsumer
        public void accept(int t2) {
            this.state = this.val$operator.applyAsInt(this.state, t2);
        }

        @Override // java.util.function.Supplier
        public Integer get() {
            return Integer.valueOf(this.state);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C5ReducingSink other) {
            accept(other.state);
        }
    }

    public static TerminalOp<Integer, Integer> makeInt(final int identity, final IntBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Integer, Integer, C5ReducingSink>(StreamShape.INT_VALUE) { // from class: java.util.stream.ReduceOps.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C5ReducingSink makeSink() {
                return new C5ReducingSink(identity, operator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$6ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C6ReducingSink implements AccumulatingSink<Integer, OptionalInt, C6ReducingSink>, Sink.OfInt {
        private boolean empty;
        private int state;
        final /* synthetic */ IntBinaryOperator val$operator;

        C6ReducingSink(IntBinaryOperator intBinaryOperator) {
            this.val$operator = intBinaryOperator;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.empty = true;
            this.state = 0;
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfInt, java.util.function.IntConsumer
        public void accept(int t2) {
            if (this.empty) {
                this.empty = false;
                this.state = t2;
            } else {
                this.state = this.val$operator.applyAsInt(this.state, t2);
            }
        }

        @Override // java.util.function.Supplier
        public OptionalInt get() {
            return this.empty ? OptionalInt.empty() : OptionalInt.of(this.state);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C6ReducingSink other) {
            if (!other.empty) {
                accept(other.state);
            }
        }
    }

    public static TerminalOp<Integer, OptionalInt> makeInt(final IntBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Integer, OptionalInt, C6ReducingSink>(StreamShape.INT_VALUE) { // from class: java.util.stream.ReduceOps.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C6ReducingSink makeSink() {
                return new C6ReducingSink(operator);
            }
        };
    }

    public static <R> TerminalOp<Integer, R> makeInt(final Supplier<R> supplier, final ObjIntConsumer<R> accumulator, final BinaryOperator<R> combiner) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        return new ReduceOp<Integer, R, C7ReducingSink>(StreamShape.INT_VALUE) { // from class: java.util.stream.ReduceOps.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C7ReducingSink makeSink() {
                return new C7ReducingSink(supplier, accumulator, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$7ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C7ReducingSink<R> extends Box<R> implements AccumulatingSink<Integer, R, C7ReducingSink>, Sink.OfInt {
        final /* synthetic */ ObjIntConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        C7ReducingSink(Supplier supplier, ObjIntConsumer objIntConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objIntConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfInt, java.util.function.IntConsumer
        public void accept(int t2) {
            this.val$accumulator.accept(this.state, t2);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C7ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$8ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C8ReducingSink implements AccumulatingSink<Long, Long, C8ReducingSink>, Sink.OfLong {
        private long state;
        final /* synthetic */ long val$identity;
        final /* synthetic */ LongBinaryOperator val$operator;

        C8ReducingSink(long j10, LongBinaryOperator longBinaryOperator) {
            this.val$identity = j10;
            this.val$operator = longBinaryOperator;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$identity;
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfLong, java.util.function.LongConsumer
        public void accept(long t2) {
            this.state = this.val$operator.applyAsLong(this.state, t2);
        }

        @Override // java.util.function.Supplier
        public Long get() {
            return Long.valueOf(this.state);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C8ReducingSink other) {
            accept(other.state);
        }
    }

    public static TerminalOp<Long, Long> makeLong(final long identity, final LongBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Long, Long, C8ReducingSink>(StreamShape.LONG_VALUE) { // from class: java.util.stream.ReduceOps.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C8ReducingSink makeSink() {
                return new C8ReducingSink(identity, operator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$9ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C9ReducingSink implements AccumulatingSink<Long, OptionalLong, C9ReducingSink>, Sink.OfLong {
        private boolean empty;
        private long state;
        final /* synthetic */ LongBinaryOperator val$operator;

        C9ReducingSink(LongBinaryOperator longBinaryOperator) {
            this.val$operator = longBinaryOperator;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.empty = true;
            this.state = 0L;
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfLong, java.util.function.LongConsumer
        public void accept(long t2) {
            if (this.empty) {
                this.empty = false;
                this.state = t2;
            } else {
                this.state = this.val$operator.applyAsLong(this.state, t2);
            }
        }

        @Override // java.util.function.Supplier
        public OptionalLong get() {
            return this.empty ? OptionalLong.empty() : OptionalLong.of(this.state);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C9ReducingSink other) {
            if (!other.empty) {
                accept(other.state);
            }
        }
    }

    public static TerminalOp<Long, OptionalLong> makeLong(final LongBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Long, OptionalLong, C9ReducingSink>(StreamShape.LONG_VALUE) { // from class: java.util.stream.ReduceOps.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C9ReducingSink makeSink() {
                return new C9ReducingSink(operator);
            }
        };
    }

    public static <R> TerminalOp<Long, R> makeLong(final Supplier<R> supplier, final ObjLongConsumer<R> accumulator, final BinaryOperator<R> combiner) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        return new ReduceOp<Long, R, C10ReducingSink>(StreamShape.LONG_VALUE) { // from class: java.util.stream.ReduceOps.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C10ReducingSink makeSink() {
                return new C10ReducingSink(supplier, accumulator, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$10ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C10ReducingSink<R> extends Box<R> implements AccumulatingSink<Long, R, C10ReducingSink>, Sink.OfLong {
        final /* synthetic */ ObjLongConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        C10ReducingSink(Supplier supplier, ObjLongConsumer objLongConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objLongConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // java.util.stream.Sink, java.util.stream.Sink.OfLong, java.util.function.LongConsumer
        public void accept(long t2) {
            this.val$accumulator.accept(this.state, t2);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C10ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$11ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C11ReducingSink implements AccumulatingSink<Double, Double, C11ReducingSink>, Sink.OfDouble {
        private double state;
        final /* synthetic */ double val$identity;
        final /* synthetic */ DoubleBinaryOperator val$operator;

        C11ReducingSink(double d10, DoubleBinaryOperator doubleBinaryOperator) {
            this.val$identity = d10;
            this.val$operator = doubleBinaryOperator;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$identity;
        }

        @Override // java.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t2) {
            this.state = this.val$operator.applyAsDouble(this.state, t2);
        }

        @Override // java.util.function.Supplier
        public Double get() {
            return Double.valueOf(this.state);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C11ReducingSink other) {
            accept(other.state);
        }
    }

    public static TerminalOp<Double, Double> makeDouble(final double identity, final DoubleBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Double, Double, C11ReducingSink>(StreamShape.DOUBLE_VALUE) { // from class: java.util.stream.ReduceOps.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C11ReducingSink makeSink() {
                return new C11ReducingSink(identity, operator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$12ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C12ReducingSink implements AccumulatingSink<Double, OptionalDouble, C12ReducingSink>, Sink.OfDouble {
        private boolean empty;
        private double state;
        final /* synthetic */ DoubleBinaryOperator val$operator;

        C12ReducingSink(DoubleBinaryOperator doubleBinaryOperator) {
            this.val$operator = doubleBinaryOperator;
        }

        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.empty = true;
            this.state = ShadowDrawableWrapper.COS_45;
        }

        @Override // java.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t2) {
            if (this.empty) {
                this.empty = false;
                this.state = t2;
            } else {
                this.state = this.val$operator.applyAsDouble(this.state, t2);
            }
        }

        @Override // java.util.function.Supplier
        public OptionalDouble get() {
            return this.empty ? OptionalDouble.empty() : OptionalDouble.of(this.state);
        }

        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C12ReducingSink other) {
            if (!other.empty) {
                accept(other.state);
            }
        }
    }

    public static TerminalOp<Double, OptionalDouble> makeDouble(final DoubleBinaryOperator operator) {
        Objects.requireNonNull(operator);
        return new ReduceOp<Double, OptionalDouble, C12ReducingSink>(StreamShape.DOUBLE_VALUE) { // from class: java.util.stream.ReduceOps.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C12ReducingSink makeSink() {
                return new C12ReducingSink(operator);
            }
        };
    }

    public static <R> TerminalOp<Double, R> makeDouble(final Supplier<R> supplier, final ObjDoubleConsumer<R> accumulator, final BinaryOperator<R> combiner) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(accumulator);
        Objects.requireNonNull(combiner);
        return new ReduceOp<Double, R, C13ReducingSink>(StreamShape.DOUBLE_VALUE) { // from class: java.util.stream.ReduceOps.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.ReduceOps.ReduceOp
            public C13ReducingSink makeSink() {
                return new C13ReducingSink(supplier, accumulator, combiner);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.ReduceOps$13ReducingSink, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C13ReducingSink<R> extends Box<R> implements AccumulatingSink<Double, R, C13ReducingSink>, Sink.OfDouble {
        final /* synthetic */ ObjDoubleConsumer val$accumulator;
        final /* synthetic */ BinaryOperator val$combiner;
        final /* synthetic */ Supplier val$supplier;

        C13ReducingSink(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BinaryOperator binaryOperator) {
            this.val$supplier = supplier;
            this.val$accumulator = objDoubleConsumer;
            this.val$combiner = binaryOperator;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.Sink
        public void begin(long size) {
            this.state = this.val$supplier.get();
        }

        @Override // java.util.stream.Sink, java.util.function.DoubleConsumer
        public void accept(double t2) {
            this.val$accumulator.accept(this.state, t2);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [U, java.lang.Object] */
        @Override // java.util.stream.ReduceOps.AccumulatingSink
        public void combine(C13ReducingSink other) {
            this.state = this.val$combiner.apply(this.state, other.state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Box<U> {
        U state;

        Box() {
        }

        public U get() {
            return this.state;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ReduceOp<T, R, S extends AccumulatingSink<T, R, S>> implements TerminalOp<T, R> {
        private final StreamShape inputShape;

        public abstract S makeSink();

        ReduceOp(StreamShape shape) {
            this.inputShape = shape;
        }

        @Override // java.util.stream.TerminalOp
        public StreamShape inputShape() {
            return this.inputShape;
        }

        @Override // java.util.stream.TerminalOp
        public <P_IN> R evaluateSequential(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
            return ((AccumulatingSink) helper.wrapAndCopyInto(makeSink(), spliterator)).get();
        }

        @Override // java.util.stream.TerminalOp
        public <P_IN> R evaluateParallel(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
            return ((AccumulatingSink) new ReduceTask(this, helper, spliterator).invoke()).get();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class ReduceTask<P_IN, P_OUT, R, S extends AccumulatingSink<P_OUT, R, S>> extends AbstractTask<P_IN, P_OUT, S, ReduceTask<P_IN, P_OUT, R, S>> {
        private final ReduceOp<P_OUT, R, S> op;

        ReduceTask(ReduceOp<P_OUT, R, S> op, PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator) {
            super(helper, spliterator);
            this.op = op;
        }

        ReduceTask(ReduceTask<P_IN, P_OUT, R, S> parent, Spliterator<P_IN> spliterator) {
            super(parent, spliterator);
            this.op = parent.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public ReduceTask<P_IN, P_OUT, R, S> makeChild(Spliterator<P_IN> spliterator) {
            return new ReduceTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public S doLeaf() {
            return (S) this.helper.wrapAndCopyInto(this.op.makeSink(), this.spliterator);
        }

        @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter<?> caller) {
            if (!isLeaf()) {
                AccumulatingSink accumulatingSink = (AccumulatingSink) ((ReduceTask) this.leftChild).getLocalResult();
                accumulatingSink.combine((AccumulatingSink) ((ReduceTask) this.rightChild).getLocalResult());
                setLocalResult(accumulatingSink);
            }
            super.onCompletion(caller);
        }
    }
}
