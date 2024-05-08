package java.util.stream;

import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.DoublePipeline;
import java.util.stream.IntPipeline;
import java.util.stream.LongPipeline;
import java.util.stream.MatchOps;
import java.util.stream.Node;
import java.util.stream.ReferencePipeline;
import java.util.stream.Sink;
import java.util.stream.StreamSpliterators;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class IntPipeline<E_IN> extends AbstractPipeline<E_IN, Integer, IntStream> implements IntStream {
    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    public /* bridge */ /* synthetic */ IntStream parallel() {
        return (IntStream) super.parallel();
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    public /* bridge */ /* synthetic */ IntStream sequential() {
        return (IntStream) super.sequential();
    }

    IntPipeline(Supplier<? extends Spliterator<Integer>> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    IntPipeline(Spliterator<Integer> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    IntPipeline(AbstractPipeline<?, E_IN, ?> upstream, int opFlags) {
        super(upstream, opFlags);
    }

    private static IntConsumer adapt(Sink<Integer> sink) {
        if (sink instanceof IntConsumer) {
            return (IntConsumer) sink;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using IntStream.adapt(Sink<Integer> s)");
        }
        Objects.requireNonNull(sink);
        return new IntPipeline$$ExternalSyntheticLambda1(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.OfInt adapt(Spliterator<Integer> s2) {
        if (s2 instanceof Spliterator.OfInt) {
            return (Spliterator.OfInt) s2;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using IntStream.adapt(Spliterator<Integer> s)");
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    @Override // java.util.stream.AbstractPipeline
    public final StreamShape getOutputShape() {
        return StreamShape.INT_VALUE;
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Node<Integer> evaluateToNode(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<Integer[]> generator) {
        return Nodes.collectInt(helper, spliterator, flattenTree);
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Spliterator<Integer> wrap(PipelineHelper<Integer> ph, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.IntWrappingSpliterator(ph, supplier, isParallel);
    }

    @Override // java.util.stream.AbstractPipeline
    /* renamed from: lazySpliterator */
    public final Spliterator<Integer> lazySpliterator2(Supplier<? extends Spliterator<Integer>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator.OfInt(supplier);
    }

    @Override // java.util.stream.AbstractPipeline
    public final boolean forEachWithCancel(Spliterator<Integer> spliterator, Sink<Integer> sink) {
        boolean cancelled;
        Spliterator.OfInt spl = adapt(spliterator);
        IntConsumer adaptedSink = adapt(sink);
        do {
            cancelled = sink.cancellationRequested();
            if (cancelled) {
                break;
            }
        } while (spl.tryAdvance(adaptedSink));
        return cancelled;
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.PipelineHelper
    public final Node.Builder<Integer> makeNodeBuilder(long exactSizeIfKnown, IntFunction<Integer[]> generator) {
        return Nodes.intBuilder(exactSizeIfKnown);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Spliterator$OfInt] */
    @Override // java.util.stream.BaseStream, java.util.stream.DoubleStream
    public final Iterator<Integer> iterator() {
        return Spliterators.iterator((Spliterator.OfInt) spliterator2());
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    /* renamed from: spliterator */
    public final Spliterator<Integer> spliterator2() {
        return adapt((Spliterator<Integer>) super.spliterator2());
    }

    @Override // java.util.stream.IntStream
    public final LongStream asLongStream() {
        return new LongPipeline.StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.IntPipeline.1
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedInt<Long>(sink) { // from class: java.util.stream.IntPipeline.1.1
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        this.downstream.accept(t2);
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final DoubleStream asDoubleStream() {
        return new DoublePipeline.StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.IntPipeline.2
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedInt<Double>(sink) { // from class: java.util.stream.IntPipeline.2.1
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        this.downstream.accept(t2);
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final Stream<Integer> boxed() {
        return mapToObj(new IntFunction() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda8
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return Integer.valueOf(i10);
            }
        });
    }

    @Override // java.util.stream.IntStream
    public final IntStream map(final IntUnaryOperator mapper) {
        Objects.requireNonNull(mapper);
        return new StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.IntPipeline.3
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedInt<Integer>(sink) { // from class: java.util.stream.IntPipeline.3.1
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        this.downstream.accept(mapper.applyAsInt(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final <U> Stream<U> mapToObj(final IntFunction<? extends U> mapper) {
        Objects.requireNonNull(mapper);
        return new ReferencePipeline.StatelessOp<Integer, U>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.IntPipeline.4
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<U> sink) {
                return new Sink.ChainedInt<U>(sink) { // from class: java.util.stream.IntPipeline.4.1
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        this.downstream.accept(mapper.apply(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final LongStream mapToLong(final IntToLongFunction mapper) {
        Objects.requireNonNull(mapper);
        return new LongPipeline.StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.IntPipeline.5
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedInt<Long>(sink) { // from class: java.util.stream.IntPipeline.5.1
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        this.downstream.accept(mapper.applyAsLong(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final DoubleStream mapToDouble(final IntToDoubleFunction mapper) {
        Objects.requireNonNull(mapper);
        return new DoublePipeline.StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.IntPipeline.6
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedInt<Double>(sink) { // from class: java.util.stream.IntPipeline.6.1
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        this.downstream.accept(mapper.applyAsDouble(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final IntStream flatMap(final IntFunction<? extends IntStream> mapper) {
        return new StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.IntPipeline.7

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* renamed from: java.util.stream.IntPipeline$7$1, reason: invalid class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public class AnonymousClass1 extends Sink.ChainedInt<Integer> {
                AnonymousClass1(Sink sink) {
                    super(sink);
                }

                @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                public void accept(int t2) {
                    IntStream result = (IntStream) mapper.apply(t2);
                    if (result != null) {
                        try {
                            result.sequential().forEach(new IntConsumer() { // from class: java.util.stream.IntPipeline$7$1$$ExternalSyntheticLambda0
                                @Override // java.util.function.IntConsumer
                                public final void accept(int i10) {
                                    IntPipeline.AnonymousClass7.AnonymousClass1.this.lambda$accept$0(i10);
                                }
                            });
                        } catch (Throwable th) {
                            if (result != null) {
                                try {
                                    result.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                    if (result != null) {
                        result.close();
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$accept$0(int i10) {
                    this.downstream.accept(i10);
                }
            }

            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
                return new AnonymousClass1(sink);
            }
        };
    }

    @Override // java.util.stream.BaseStream
    public IntStream unordered() {
        if (!isOrdered()) {
            return this;
        }
        return new StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_ORDERED) { // from class: java.util.stream.IntPipeline.8
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
                return sink;
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final IntStream filter(final IntPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new StatelessOp<Integer>(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.IntPipeline.9
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedInt<Integer>(sink) { // from class: java.util.stream.IntPipeline.9.1
                    @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        if (predicate.test(t2)) {
                            this.downstream.accept(t2);
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final IntStream peek(final IntConsumer action) {
        Objects.requireNonNull(action);
        return new StatelessOp<Integer>(this, StreamShape.INT_VALUE, 0) { // from class: java.util.stream.IntPipeline.10
            @Override // java.util.stream.AbstractPipeline
            public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedInt<Integer>(sink) { // from class: java.util.stream.IntPipeline.10.1
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public void accept(int t2) {
                        action.accept(t2);
                        this.downstream.accept(t2);
                    }
                };
            }
        };
    }

    @Override // java.util.stream.IntStream
    public final IntStream limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }
        return SliceOps.makeInt(this, 0L, maxSize);
    }

    @Override // java.util.stream.IntStream
    public final IntStream skip(long n10) {
        if (n10 < 0) {
            throw new IllegalArgumentException(Long.toString(n10));
        }
        if (n10 == 0) {
            return this;
        }
        return SliceOps.makeInt(this, n10, -1L);
    }

    @Override // java.util.stream.IntStream
    public final IntStream sorted() {
        return SortedOps.makeInt(this);
    }

    @Override // java.util.stream.IntStream
    public final IntStream distinct() {
        return boxed().distinct().mapToInt(new ToIntFunction() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                int intValue;
                intValue = ((Integer) obj).intValue();
                return intValue;
            }
        });
    }

    @Override // java.util.stream.IntStream
    public void forEach(IntConsumer action) {
        evaluate(ForEachOps.makeInt(action, false));
    }

    @Override // java.util.stream.IntStream
    public void forEachOrdered(IntConsumer action) {
        evaluate(ForEachOps.makeInt(action, true));
    }

    @Override // java.util.stream.IntStream
    public final int sum() {
        return reduce(0, new IntBinaryOperator() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda13
            @Override // java.util.function.IntBinaryOperator
            public final int applyAsInt(int i10, int i11) {
                return Integer.sum(i10, i11);
            }
        });
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt min() {
        return reduce(new IntBinaryOperator() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda12
            @Override // java.util.function.IntBinaryOperator
            public final int applyAsInt(int i10, int i11) {
                return Math.min(i10, i11);
            }
        });
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt max() {
        return reduce(new IntBinaryOperator() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda9
            @Override // java.util.function.IntBinaryOperator
            public final int applyAsInt(int i10, int i11) {
                return Math.max(i10, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long lambda$count$1(int e2) {
        return 1L;
    }

    @Override // java.util.stream.IntStream
    public final long count() {
        return mapToLong(new IntToLongFunction() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda10
            @Override // java.util.function.IntToLongFunction
            public final long applyAsLong(int i10) {
                return IntPipeline.lambda$count$1(i10);
            }
        }).sum();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$average$2() {
        return new long[2];
    }

    @Override // java.util.stream.IntStream
    public final OptionalDouble average() {
        long[] avg = (long[]) collect(new Supplier() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return IntPipeline.lambda$average$2();
            }
        }, new ObjIntConsumer() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda5
            @Override // java.util.function.ObjIntConsumer
            public final void accept(Object obj, int i10) {
                IntPipeline.lambda$average$3((long[]) obj, i10);
            }
        }, new BiConsumer() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda6
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                IntPipeline.lambda$average$4((long[]) obj, (long[]) obj2);
            }
        });
        if (avg[0] > 0) {
            return OptionalDouble.of(avg[1] / avg[0]);
        }
        return OptionalDouble.empty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$3(long[] ll, int i10) {
        ll[0] = ll[0] + 1;
        ll[1] = ll[1] + i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$4(long[] ll, long[] rr) {
        ll[0] = ll[0] + rr[0];
        ll[1] = ll[1] + rr[1];
    }

    @Override // java.util.stream.IntStream
    public final IntSummaryStatistics summaryStatistics() {
        return (IntSummaryStatistics) collect(new Collectors$$ExternalSyntheticLambda58(), new ObjIntConsumer() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda2
            @Override // java.util.function.ObjIntConsumer
            public final void accept(Object obj, int i10) {
                ((IntSummaryStatistics) obj).accept(i10);
            }
        }, new BiConsumer() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((IntSummaryStatistics) obj).combine((IntSummaryStatistics) obj2);
            }
        });
    }

    @Override // java.util.stream.IntStream
    public final int reduce(int identity, IntBinaryOperator op) {
        return ((Integer) evaluate(ReduceOps.makeInt(identity, op))).intValue();
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt reduce(IntBinaryOperator op) {
        return (OptionalInt) evaluate(ReduceOps.makeInt(op));
    }

    @Override // java.util.stream.IntStream
    public final <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> objIntConsumer, final BiConsumer<R, R> biConsumer) {
        return (R) evaluate(ReduceOps.makeInt(supplier, objIntConsumer, new BinaryOperator() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda11
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return IntPipeline.lambda$collect$5(BiConsumer.this, obj, obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$collect$5(BiConsumer combiner, Object left, Object right) {
        combiner.accept(left, right);
        return left;
    }

    @Override // java.util.stream.IntStream
    public final boolean anyMatch(IntPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeInt(predicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java.util.stream.IntStream
    public final boolean allMatch(IntPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeInt(predicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java.util.stream.IntStream
    public final boolean noneMatch(IntPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeInt(predicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt findFirst() {
        return (OptionalInt) evaluate(FindOps.makeInt(true));
    }

    @Override // java.util.stream.IntStream
    public final OptionalInt findAny() {
        return (OptionalInt) evaluate(FindOps.makeInt(false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer[] lambda$toArray$6(int x$0) {
        return new Integer[x$0];
    }

    @Override // java.util.stream.IntStream
    public final int[] toArray() {
        return Nodes.flattenInt((Node.OfInt) evaluateToArrayNode(new IntFunction() { // from class: java.util.stream.IntPipeline$$ExternalSyntheticLambda7
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return IntPipeline.lambda$toArray$6(i10);
            }
        })).asPrimitiveArray();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Head<E_IN> extends IntPipeline<E_IN> {
        @Override // java.util.stream.IntPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream parallel() {
            return (IntStream) super.parallel();
        }

        @Override // java.util.stream.IntPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream sequential() {
            return (IntStream) super.sequential();
        }

        public Head(Supplier<? extends Spliterator<Integer>> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        public Head(Spliterator<Integer> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.stream.AbstractPipeline
        public final Sink<E_IN> opWrapSink(int flags, Sink<Integer> sink) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.stream.IntPipeline, java.util.stream.IntStream
        public void forEach(IntConsumer action) {
            if (!isParallel()) {
                IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(action);
            } else {
                super.forEach(action);
            }
        }

        @Override // java.util.stream.IntPipeline, java.util.stream.IntStream
        public void forEachOrdered(IntConsumer action) {
            if (!isParallel()) {
                IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(action);
            } else {
                super.forEachOrdered(action);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class StatelessOp<E_IN> extends IntPipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.stream.IntPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream parallel() {
            return (IntStream) super.parallel();
        }

        @Override // java.util.stream.IntPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream sequential() {
            return (IntStream) super.sequential();
        }

        public StatelessOp(AbstractPipeline<?, E_IN, ?> upstream, StreamShape inputShape, int opFlags) {
            super(upstream, opFlags);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class StatefulOp<E_IN> extends IntPipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.stream.AbstractPipeline
        public abstract <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> intFunction);

        @Override // java.util.stream.IntPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream parallel() {
            return (IntStream) super.parallel();
        }

        @Override // java.util.stream.IntPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream sequential() {
            return (IntStream) super.sequential();
        }

        public StatefulOp(AbstractPipeline<?, E_IN, ?> upstream, StreamShape inputShape, int opFlags) {
            super(upstream, opFlags);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            return true;
        }
    }
}
