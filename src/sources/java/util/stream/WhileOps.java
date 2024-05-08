package java.util.stream;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.DoublePipeline;
import java.util.stream.IntPipeline;
import java.util.stream.LongPipeline;
import java.util.stream.Node;
import java.util.stream.ReferencePipeline;
import java.util.stream.Sink;
import java.util.stream.WhileOps;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class WhileOps {
    static final int TAKE_FLAGS = StreamOpFlag.NOT_SIZED | StreamOpFlag.IS_SHORT_CIRCUIT;
    static final int DROP_FLAGS = StreamOpFlag.NOT_SIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface DropWhileOp<T> {
        DropWhileSink<T> opWrapSink(Sink<T> sink, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface DropWhileSink<T> extends Sink<T> {
        long getDropCount();
    }

    WhileOps() {
    }

    static <T> Stream<T> makeTakeWhileRef(AbstractPipeline<?, T, ?> upstream, final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new ReferencePipeline.StatefulOp<T, T>(upstream, StreamShape.REFERENCE, TAKE_FLAGS) { // from class: java.util.stream.WhileOps.1
            @Override // java.util.stream.AbstractPipeline
            public <P_IN> Spliterator<T> opEvaluateParallelLazy(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                    return opEvaluateParallel(helper, spliterator, Nodes.castingArray()).spliterator();
                }
                return new UnorderedWhileSpliterator.OfRef.Taking(helper.wrapSpliterator(spliterator), false, predicate);
            }

            @Override // java.util.stream.ReferencePipeline.StatefulOp, java.util.stream.AbstractPipeline
            public <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> helper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
                return (Node) new TakeWhileTask(this, helper, spliterator, generator).invoke();
            }

            @Override // java.util.stream.AbstractPipeline
            public Sink<T> opWrapSink(int flags, Sink<T> sink) {
                return new Sink.ChainedReference<T, T>(sink) { // from class: java.util.stream.WhileOps.1.1
                    boolean take = true;

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(T t2) {
                        if (this.take) {
                            boolean test = predicate.test(t2);
                            this.take = test;
                            if (test) {
                                this.downstream.accept(t2);
                            }
                        }
                    }

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public boolean cancellationRequested() {
                        return !this.take || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.WhileOps$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class AnonymousClass2 extends IntPipeline.StatefulOp<Integer> {
        final /* synthetic */ IntPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, IntPredicate intPredicate) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$predicate = intPredicate;
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Integer> opEvaluateParallelLazy(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return opEvaluateParallel(helper, spliterator, new IntFunction() { // from class: java.util.stream.WhileOps$2$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return WhileOps.AnonymousClass2.lambda$opEvaluateParallelLazy$0(i10);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfInt.Taking((Spliterator.OfInt) helper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Integer[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Integer[x$0];
        }

        @Override // java.util.stream.IntPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> generator) {
            return (Node) new TakeWhileTask(this, helper, spliterator, generator).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
            return new Sink.ChainedInt<Integer>(sink) { // from class: java.util.stream.WhileOps.2.1
                boolean take = true;

                @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                public void accept(int t2) {
                    if (this.take) {
                        boolean test = AnonymousClass2.this.val$predicate.test(t2);
                        this.take = test;
                        if (test) {
                            this.downstream.accept(t2);
                        }
                    }
                }

                @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
                public boolean cancellationRequested() {
                    return !this.take || this.downstream.cancellationRequested();
                }
            };
        }
    }

    static IntStream makeTakeWhileInt(AbstractPipeline<?, Integer, ?> upstream, IntPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new AnonymousClass2(upstream, StreamShape.INT_VALUE, TAKE_FLAGS, predicate);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.WhileOps$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class AnonymousClass3 extends LongPipeline.StatefulOp<Long> {
        final /* synthetic */ LongPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, LongPredicate longPredicate) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$predicate = longPredicate;
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Long> opEvaluateParallelLazy(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return opEvaluateParallel(helper, spliterator, new IntFunction() { // from class: java.util.stream.WhileOps$3$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return WhileOps.AnonymousClass3.lambda$opEvaluateParallelLazy$0(i10);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfLong.Taking((Spliterator.OfLong) helper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Long[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Long[x$0];
        }

        @Override // java.util.stream.LongPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator, IntFunction<Long[]> generator) {
            return (Node) new TakeWhileTask(this, helper, spliterator, generator).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
            return new Sink.ChainedLong<Long>(sink) { // from class: java.util.stream.WhileOps.3.1
                boolean take = true;

                @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                public void accept(long t2) {
                    if (this.take) {
                        boolean test = AnonymousClass3.this.val$predicate.test(t2);
                        this.take = test;
                        if (test) {
                            this.downstream.accept(t2);
                        }
                    }
                }

                @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
                public boolean cancellationRequested() {
                    return !this.take || this.downstream.cancellationRequested();
                }
            };
        }
    }

    static LongStream makeTakeWhileLong(AbstractPipeline<?, Long, ?> upstream, LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new AnonymousClass3(upstream, StreamShape.LONG_VALUE, TAKE_FLAGS, predicate);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.WhileOps$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class AnonymousClass4 extends DoublePipeline.StatefulOp<Double> {
        final /* synthetic */ DoublePredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, DoublePredicate doublePredicate) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$predicate = doublePredicate;
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Double> opEvaluateParallelLazy(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return opEvaluateParallel(helper, spliterator, new IntFunction() { // from class: java.util.stream.WhileOps$4$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return WhileOps.AnonymousClass4.lambda$opEvaluateParallelLazy$0(i10);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfDouble.Taking((Spliterator.OfDouble) helper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Double[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Double[x$0];
        }

        @Override // java.util.stream.DoublePipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator, IntFunction<Double[]> generator) {
            return (Node) new TakeWhileTask(this, helper, spliterator, generator).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
            return new Sink.ChainedDouble<Double>(sink) { // from class: java.util.stream.WhileOps.4.1
                boolean take = true;

                @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                public void accept(double t2) {
                    if (this.take) {
                        boolean test = AnonymousClass4.this.val$predicate.test(t2);
                        this.take = test;
                        if (test) {
                            this.downstream.accept(t2);
                        }
                    }
                }

                @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
                public boolean cancellationRequested() {
                    return !this.take || this.downstream.cancellationRequested();
                }
            };
        }
    }

    static DoubleStream makeTakeWhileDouble(AbstractPipeline<?, Double, ?> upstream, DoublePredicate predicate) {
        Objects.requireNonNull(predicate);
        return new AnonymousClass4(upstream, StreamShape.DOUBLE_VALUE, TAKE_FLAGS, predicate);
    }

    static <T> Stream<T> makeDropWhileRef(AbstractPipeline<?, T, ?> upstream, Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new C1Op(upstream, StreamShape.REFERENCE, DROP_FLAGS, predicate);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.WhileOps$1Op, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C1Op<T> extends ReferencePipeline.StatefulOp<T, T> implements DropWhileOp<T> {
        final /* synthetic */ Predicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C1Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, T, ?> abstractPipeline2, StreamShape streamShape, int i10) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i10;
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<T> opEvaluateParallelLazy(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return opEvaluateParallel(helper, spliterator, Nodes.castingArray()).spliterator();
            }
            return new UnorderedWhileSpliterator.OfRef.Dropping(helper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        @Override // java.util.stream.ReferencePipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> helper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
            return (Node) new DropWhileTask(this, helper, spliterator, generator).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<T> opWrapSink(int flags, Sink<T> sink) {
            return opWrapSink((Sink) sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.stream.WhileOps$1Op$1OpSink, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class C1OpSink extends Sink.ChainedReference<T, T> implements DropWhileSink<T> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z10) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z10;
            }

            @Override // java.util.function.Consumer
            public void accept(T t2) {
                boolean z10 = true;
                if (!this.take) {
                    boolean z11 = !C1Op.this.val$predicate.test(t2);
                    this.take = z11;
                    if (!z11) {
                        z10 = false;
                    }
                }
                boolean takeElement = z10;
                boolean z12 = this.val$retainAndCountDroppedElements;
                if (z12 && !takeElement) {
                    this.dropCount++;
                }
                if (z12 || takeElement) {
                    this.downstream.accept(t2);
                }
            }

            @Override // java.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<T> opWrapSink(Sink<T> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    static IntStream makeDropWhileInt(AbstractPipeline<?, Integer, ?> upstream, IntPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new C2Op(upstream, StreamShape.INT_VALUE, DROP_FLAGS, predicate);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.WhileOps$2Op, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C2Op extends IntPipeline.StatefulOp<Integer> implements DropWhileOp<Integer> {
        final /* synthetic */ IntPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C2Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, Integer, ?> abstractPipeline2, StreamShape streamShape, int i10) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i10;
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Integer> opEvaluateParallelLazy(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return opEvaluateParallel(helper, spliterator, new IntFunction() { // from class: java.util.stream.WhileOps$2Op$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return WhileOps.C2Op.lambda$opEvaluateParallelLazy$0(i10);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfInt.Dropping((Spliterator.OfInt) helper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Integer[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Integer[x$0];
        }

        @Override // java.util.stream.IntPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> generator) {
            return (Node) new DropWhileTask(this, helper, spliterator, generator).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.stream.WhileOps$2Op$1OpSink, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class C1OpSink extends Sink.ChainedInt<Integer> implements DropWhileSink<Integer> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z10) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z10;
            }

            @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
            public void accept(int t2) {
                boolean z10 = true;
                if (!this.take) {
                    boolean z11 = !C2Op.this.val$predicate.test(t2);
                    this.take = z11;
                    if (!z11) {
                        z10 = false;
                    }
                }
                boolean takeElement = z10;
                boolean z12 = this.val$retainAndCountDroppedElements;
                if (z12 && !takeElement) {
                    this.dropCount++;
                }
                if (z12 || takeElement) {
                    this.downstream.accept(t2);
                }
            }

            @Override // java.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<Integer> opWrapSink(Sink<Integer> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    static LongStream makeDropWhileLong(AbstractPipeline<?, Long, ?> upstream, LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new C3Op(upstream, StreamShape.LONG_VALUE, DROP_FLAGS, predicate);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.WhileOps$3Op, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C3Op extends LongPipeline.StatefulOp<Long> implements DropWhileOp<Long> {
        final /* synthetic */ LongPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C3Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, Long, ?> abstractPipeline2, StreamShape streamShape, int i10) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i10;
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Long> opEvaluateParallelLazy(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return opEvaluateParallel(helper, spliterator, new IntFunction() { // from class: java.util.stream.WhileOps$3Op$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return WhileOps.C3Op.lambda$opEvaluateParallelLazy$0(i10);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfLong.Dropping((Spliterator.OfLong) helper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Long[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Long[x$0];
        }

        @Override // java.util.stream.LongPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator, IntFunction<Long[]> generator) {
            return (Node) new DropWhileTask(this, helper, spliterator, generator).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.stream.WhileOps$3Op$1OpSink, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class C1OpSink extends Sink.ChainedLong<Long> implements DropWhileSink<Long> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z10) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z10;
            }

            @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
            public void accept(long t2) {
                boolean z10 = true;
                if (!this.take) {
                    boolean z11 = !C3Op.this.val$predicate.test(t2);
                    this.take = z11;
                    if (!z11) {
                        z10 = false;
                    }
                }
                boolean takeElement = z10;
                boolean z12 = this.val$retainAndCountDroppedElements;
                if (z12 && !takeElement) {
                    this.dropCount++;
                }
                if (z12 || takeElement) {
                    this.downstream.accept(t2);
                }
            }

            @Override // java.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<Long> opWrapSink(Sink<Long> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    static DoubleStream makeDropWhileDouble(AbstractPipeline<?, Double, ?> upstream, DoublePredicate predicate) {
        Objects.requireNonNull(predicate);
        return new C4Op(upstream, StreamShape.DOUBLE_VALUE, DROP_FLAGS, predicate);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.WhileOps$4Op, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C4Op extends DoublePipeline.StatefulOp<Double> implements DropWhileOp<Double> {
        final /* synthetic */ DoublePredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C4Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, Double, ?> abstractPipeline2, StreamShape streamShape, int i10) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i10;
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Double> opEvaluateParallelLazy(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return opEvaluateParallel(helper, spliterator, new IntFunction() { // from class: java.util.stream.WhileOps$4Op$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return WhileOps.C4Op.lambda$opEvaluateParallelLazy$0(i10);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfDouble.Dropping((Spliterator.OfDouble) helper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Double[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Double[x$0];
        }

        @Override // java.util.stream.DoublePipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator, IntFunction<Double[]> generator) {
            return (Node) new DropWhileTask(this, helper, spliterator, generator).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.stream.WhileOps$4Op$1OpSink, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class C1OpSink extends Sink.ChainedDouble<Double> implements DropWhileSink<Double> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z10) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z10;
            }

            @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
            public void accept(double t2) {
                boolean z10 = true;
                if (!this.take) {
                    boolean z11 = !C4Op.this.val$predicate.test(t2);
                    this.take = z11;
                    if (!z11) {
                        z10 = false;
                    }
                }
                boolean takeElement = z10;
                boolean z12 = this.val$retainAndCountDroppedElements;
                if (z12 && !takeElement) {
                    this.dropCount++;
                }
                if (z12 || takeElement) {
                    this.downstream.accept(t2);
                }
            }

            @Override // java.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        @Override // java.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<Double> opWrapSink(Sink<Double> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class UnorderedWhileSpliterator<T, T_SPLITR extends Spliterator<T>> implements Spliterator<T> {
        static final int CANCEL_CHECK_COUNT = 63;
        final AtomicBoolean cancel;
        int count;
        final boolean noSplitting;

        /* renamed from: s, reason: collision with root package name */
        final T_SPLITR f50526s;
        boolean takeOrDrop;

        abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr);

        UnorderedWhileSpliterator(T_SPLITR s2, boolean noSplitting) {
            this.takeOrDrop = true;
            this.f50526s = s2;
            this.noSplitting = noSplitting;
            this.cancel = new AtomicBoolean();
        }

        UnorderedWhileSpliterator(T_SPLITR s2, UnorderedWhileSpliterator<T, T_SPLITR> parent) {
            this.takeOrDrop = true;
            this.f50526s = s2;
            this.noSplitting = parent.noSplitting;
            this.cancel = parent.cancel;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f50526s.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f50526s.characteristics() & (-16449);
        }

        @Override // java.util.Spliterator
        public long getExactSizeIfKnown() {
            return -1L;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            return this.f50526s.getComparator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Spliterator
        public T_SPLITR trySplit() {
            Spliterator<T> trySplit = this.noSplitting ? null : this.f50526s.trySplit();
            if (trySplit != null) {
                return (T_SPLITR) makeSpliterator(trySplit);
            }
            return null;
        }

        boolean checkCancelOnCount() {
            return (this.count == 0 && this.cancel.get()) ? false : true;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static abstract class OfRef<T> extends UnorderedWhileSpliterator<T, Spliterator<T>> implements Consumer<T> {

            /* renamed from: p, reason: collision with root package name */
            final Predicate<? super T> f50533p;

            /* renamed from: t, reason: collision with root package name */
            T f50534t;

            OfRef(Spliterator<T> s2, boolean noSplitting, Predicate<? super T> p10) {
                super(s2, noSplitting);
                this.f50533p = p10;
            }

            OfRef(Spliterator<T> s2, OfRef<T> parent) {
                super(s2, parent);
                this.f50533p = parent.f50533p;
            }

            @Override // java.util.function.Consumer
            public void accept(T t2) {
                this.count = (this.count + 1) & 63;
                this.f50534t = t2;
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Taking<T> extends OfRef<T> {
                /* JADX INFO: Access modifiers changed from: package-private */
                public Taking(Spliterator<T> s2, boolean noSplitting, Predicate<? super T> p10) {
                    super(s2, noSplitting, p10);
                }

                Taking(Spliterator<T> s2, Taking<T> parent) {
                    super(s2, parent);
                }

                @Override // java.util.Spliterator
                public boolean tryAdvance(Consumer<? super T> consumer) {
                    boolean z10 = true;
                    if (this.takeOrDrop && checkCancelOnCount() && this.f50526s.tryAdvance(this)) {
                        boolean test = this.f50533p.test(this.f50534t);
                        z10 = test;
                        if (test) {
                            consumer.accept(this.f50534t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!z10) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public Spliterator<T> trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return super.trySplit();
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                Spliterator<T> makeSpliterator(Spliterator<T> s2) {
                    return new Taking(s2, this);
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Dropping<T> extends OfRef<T> {
                /* JADX INFO: Access modifiers changed from: package-private */
                public Dropping(Spliterator<T> s2, boolean noSplitting, Predicate<? super T> p10) {
                    super(s2, noSplitting, p10);
                }

                Dropping(Spliterator<T> s2, Dropping<T> parent) {
                    super(s2, parent);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
                
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
                
                    r4.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
                
                    r5.accept(r4.f50534t);
                 */
                @Override // java.util.Spliterator
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean tryAdvance(java.util.function.Consumer<? super T> r5) {
                    /*
                        r4 = this;
                        boolean r0 = r4.takeOrDrop
                        if (r0 == 0) goto L33
                        r0 = 0
                        r4.takeOrDrop = r0
                        r0 = 0
                    L8:
                        T_SPLITR extends java.util.Spliterator<T> r1 = r4.f50526s
                        boolean r1 = r1.tryAdvance(r4)
                        r2 = r1
                        if (r1 == 0) goto L23
                        boolean r1 = r4.checkCancelOnCount()
                        if (r1 == 0) goto L23
                        java.util.function.Predicate<? super T> r1 = r4.f50533p
                        T r3 = r4.f50534t
                        boolean r1 = r1.test(r3)
                        if (r1 == 0) goto L23
                        r0 = 1
                        goto L8
                    L23:
                        if (r2 == 0) goto L32
                        if (r0 == 0) goto L2d
                        java.util.concurrent.atomic.AtomicBoolean r1 = r4.cancel
                        r3 = 1
                        r1.set(r3)
                    L2d:
                        T r1 = r4.f50534t
                        r5.accept(r1)
                    L32:
                        return r2
                    L33:
                        T_SPLITR extends java.util.Spliterator<T> r0 = r4.f50526s
                        boolean r0 = r0.tryAdvance(r5)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.WhileOps.UnorderedWhileSpliterator.OfRef.Dropping.tryAdvance(java.util.function.Consumer):boolean");
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                Spliterator<T> makeSpliterator(Spliterator<T> s2) {
                    return new Dropping(s2, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static abstract class OfInt extends UnorderedWhileSpliterator<Integer, Spliterator.OfInt> implements IntConsumer, Spliterator.OfInt {

            /* renamed from: p, reason: collision with root package name */
            final IntPredicate f50529p;

            /* renamed from: t, reason: collision with root package name */
            int f50530t;

            @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfInt(Spliterator.OfInt s2, boolean noSplitting, IntPredicate p10) {
                super(s2, noSplitting);
                this.f50529p = p10;
            }

            OfInt(Spliterator.OfInt s2, OfInt parent) {
                super(s2, parent);
                this.f50529p = parent.f50529p;
            }

            @Override // java.util.function.IntConsumer
            public void accept(int t2) {
                this.count = (this.count + 1) & 63;
                this.f50530t = t2;
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Taking extends OfInt {
                Taking(Spliterator.OfInt s2, boolean noSplitting, IntPredicate p10) {
                    super(s2, noSplitting, p10);
                }

                Taking(Spliterator.OfInt s2, OfInt parent) {
                    super(s2, parent);
                }

                @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
                public boolean tryAdvance(IntConsumer action) {
                    boolean test = true;
                    if (this.takeOrDrop && checkCancelOnCount() && ((Spliterator.OfInt) this.f50526s).tryAdvance((IntConsumer) this)) {
                        boolean test2 = this.f50529p.test(this.f50530t);
                        test = test2;
                        if (test2) {
                            action.accept(this.f50530t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!test) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public Spliterator.OfInt trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (Spliterator.OfInt) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s2) {
                    return new Taking(s2, this);
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Dropping extends OfInt {
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                    return (Spliterator.OfInt) super.trySplit();
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                    return (Spliterator.OfPrimitive) super.trySplit();
                }

                Dropping(Spliterator.OfInt s2, boolean noSplitting, IntPredicate p10) {
                    super(s2, noSplitting, p10);
                }

                Dropping(Spliterator.OfInt s2, OfInt parent) {
                    super(s2, parent);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
                
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
                
                    r4.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
                
                    r5.accept(r4.f50530t);
                 */
                @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean tryAdvance(java.util.function.IntConsumer r5) {
                    /*
                        r4 = this;
                        boolean r0 = r4.takeOrDrop
                        if (r0 == 0) goto L35
                        r0 = 0
                        r4.takeOrDrop = r0
                        r0 = 0
                    L8:
                        T_SPLITR extends java.util.Spliterator<T> r1 = r4.f50526s
                        java.util.Spliterator$OfInt r1 = (java.util.Spliterator.OfInt) r1
                        boolean r1 = r1.tryAdvance(r4)
                        r2 = r1
                        if (r1 == 0) goto L25
                        boolean r1 = r4.checkCancelOnCount()
                        if (r1 == 0) goto L25
                        java.util.function.IntPredicate r1 = r4.f50529p
                        int r3 = r4.f50530t
                        boolean r1 = r1.test(r3)
                        if (r1 == 0) goto L25
                        r0 = 1
                        goto L8
                    L25:
                        if (r2 == 0) goto L34
                        if (r0 == 0) goto L2f
                        java.util.concurrent.atomic.AtomicBoolean r1 = r4.cancel
                        r3 = 1
                        r1.set(r3)
                    L2f:
                        int r1 = r4.f50530t
                        r5.accept(r1)
                    L34:
                        return r2
                    L35:
                        T_SPLITR extends java.util.Spliterator<T> r0 = r4.f50526s
                        java.util.Spliterator$OfInt r0 = (java.util.Spliterator.OfInt) r0
                        boolean r0 = r0.tryAdvance(r5)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt.Dropping.tryAdvance(java.util.function.IntConsumer):boolean");
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s2) {
                    return new Dropping(s2, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static abstract class OfLong extends UnorderedWhileSpliterator<Long, Spliterator.OfLong> implements LongConsumer, Spliterator.OfLong {

            /* renamed from: p, reason: collision with root package name */
            final LongPredicate f50531p;

            /* renamed from: t, reason: collision with root package name */
            long f50532t;

            @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfLong(Spliterator.OfLong s2, boolean noSplitting, LongPredicate p10) {
                super(s2, noSplitting);
                this.f50531p = p10;
            }

            OfLong(Spliterator.OfLong s2, OfLong parent) {
                super(s2, parent);
                this.f50531p = parent.f50531p;
            }

            @Override // java.util.function.LongConsumer
            public void accept(long t2) {
                this.count = (this.count + 1) & 63;
                this.f50532t = t2;
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Taking extends OfLong {
                Taking(Spliterator.OfLong s2, boolean noSplitting, LongPredicate p10) {
                    super(s2, noSplitting, p10);
                }

                Taking(Spliterator.OfLong s2, OfLong parent) {
                    super(s2, parent);
                }

                @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
                public boolean tryAdvance(LongConsumer action) {
                    boolean test = true;
                    if (this.takeOrDrop && checkCancelOnCount() && ((Spliterator.OfLong) this.f50526s).tryAdvance((LongConsumer) this)) {
                        boolean test2 = this.f50531p.test(this.f50532t);
                        test = test2;
                        if (test2) {
                            action.accept(this.f50532t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!test) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public Spliterator.OfLong trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (Spliterator.OfLong) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s2) {
                    return new Taking(s2, this);
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Dropping extends OfLong {
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                    return (Spliterator.OfLong) super.trySplit();
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                    return (Spliterator.OfPrimitive) super.trySplit();
                }

                Dropping(Spliterator.OfLong s2, boolean noSplitting, LongPredicate p10) {
                    super(s2, noSplitting, p10);
                }

                Dropping(Spliterator.OfLong s2, OfLong parent) {
                    super(s2, parent);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
                
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
                
                    r5.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
                
                    r6.accept(r5.f50532t);
                 */
                @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean tryAdvance(java.util.function.LongConsumer r6) {
                    /*
                        r5 = this;
                        boolean r0 = r5.takeOrDrop
                        if (r0 == 0) goto L35
                        r0 = 0
                        r5.takeOrDrop = r0
                        r0 = 0
                    L8:
                        T_SPLITR extends java.util.Spliterator<T> r1 = r5.f50526s
                        java.util.Spliterator$OfLong r1 = (java.util.Spliterator.OfLong) r1
                        boolean r1 = r1.tryAdvance(r5)
                        r2 = r1
                        if (r1 == 0) goto L25
                        boolean r1 = r5.checkCancelOnCount()
                        if (r1 == 0) goto L25
                        java.util.function.LongPredicate r1 = r5.f50531p
                        long r3 = r5.f50532t
                        boolean r1 = r1.test(r3)
                        if (r1 == 0) goto L25
                        r0 = 1
                        goto L8
                    L25:
                        if (r2 == 0) goto L34
                        if (r0 == 0) goto L2f
                        java.util.concurrent.atomic.AtomicBoolean r1 = r5.cancel
                        r3 = 1
                        r1.set(r3)
                    L2f:
                        long r3 = r5.f50532t
                        r6.accept(r3)
                    L34:
                        return r2
                    L35:
                        T_SPLITR extends java.util.Spliterator<T> r0 = r5.f50526s
                        java.util.Spliterator$OfLong r0 = (java.util.Spliterator.OfLong) r0
                        boolean r0 = r0.tryAdvance(r6)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong.Dropping.tryAdvance(java.util.function.LongConsumer):boolean");
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s2) {
                    return new Dropping(s2, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static abstract class OfDouble extends UnorderedWhileSpliterator<Double, Spliterator.OfDouble> implements DoubleConsumer, Spliterator.OfDouble {

            /* renamed from: p, reason: collision with root package name */
            final DoublePredicate f50527p;

            /* renamed from: t, reason: collision with root package name */
            double f50528t;

            @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfDouble(Spliterator.OfDouble s2, boolean noSplitting, DoublePredicate p10) {
                super(s2, noSplitting);
                this.f50527p = p10;
            }

            OfDouble(Spliterator.OfDouble s2, OfDouble parent) {
                super(s2, parent);
                this.f50527p = parent.f50527p;
            }

            @Override // java.util.function.DoubleConsumer
            public void accept(double t2) {
                this.count = (this.count + 1) & 63;
                this.f50528t = t2;
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Taking extends OfDouble {
                Taking(Spliterator.OfDouble s2, boolean noSplitting, DoublePredicate p10) {
                    super(s2, noSplitting, p10);
                }

                Taking(Spliterator.OfDouble s2, OfDouble parent) {
                    super(s2, parent);
                }

                @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
                public boolean tryAdvance(DoubleConsumer action) {
                    boolean test = true;
                    if (this.takeOrDrop && checkCancelOnCount() && ((Spliterator.OfDouble) this.f50526s).tryAdvance((DoubleConsumer) this)) {
                        boolean test2 = this.f50527p.test(this.f50528t);
                        test = test2;
                        if (test2) {
                            action.accept(this.f50528t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!test) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public Spliterator.OfDouble trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (Spliterator.OfDouble) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s2) {
                    return new Taking(s2, this);
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            static final class Dropping extends OfDouble {
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                    return (Spliterator.OfDouble) super.trySplit();
                }

                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, java.util.stream.WhileOps.UnorderedWhileSpliterator, java.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                    return (Spliterator.OfPrimitive) super.trySplit();
                }

                Dropping(Spliterator.OfDouble s2, boolean noSplitting, DoublePredicate p10) {
                    super(s2, noSplitting, p10);
                }

                Dropping(Spliterator.OfDouble s2, OfDouble parent) {
                    super(s2, parent);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
                
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
                
                    r5.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
                
                    r6.accept(r5.f50528t);
                 */
                @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean tryAdvance(java.util.function.DoubleConsumer r6) {
                    /*
                        r5 = this;
                        boolean r0 = r5.takeOrDrop
                        if (r0 == 0) goto L35
                        r0 = 0
                        r5.takeOrDrop = r0
                        r0 = 0
                    L8:
                        T_SPLITR extends java.util.Spliterator<T> r1 = r5.f50526s
                        java.util.Spliterator$OfDouble r1 = (java.util.Spliterator.OfDouble) r1
                        boolean r1 = r1.tryAdvance(r5)
                        r2 = r1
                        if (r1 == 0) goto L25
                        boolean r1 = r5.checkCancelOnCount()
                        if (r1 == 0) goto L25
                        java.util.function.DoublePredicate r1 = r5.f50527p
                        double r3 = r5.f50528t
                        boolean r1 = r1.test(r3)
                        if (r1 == 0) goto L25
                        r0 = 1
                        goto L8
                    L25:
                        if (r2 == 0) goto L34
                        if (r0 == 0) goto L2f
                        java.util.concurrent.atomic.AtomicBoolean r1 = r5.cancel
                        r3 = 1
                        r1.set(r3)
                    L2f:
                        double r3 = r5.f50528t
                        r6.accept(r3)
                    L34:
                        return r2
                    L35:
                        T_SPLITR extends java.util.Spliterator<T> r0 = r5.f50526s
                        java.util.Spliterator$OfDouble r0 = (java.util.Spliterator.OfDouble) r0
                        boolean r0 = r0.tryAdvance(r6)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble.Dropping.tryAdvance(java.util.function.DoubleConsumer):boolean");
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // java.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s2) {
                    return new Dropping(s2, this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TakeWhileTask<P_IN, P_OUT> extends AbstractShortCircuitTask<P_IN, P_OUT, Node<P_OUT>, TakeWhileTask<P_IN, P_OUT>> {
        private volatile boolean completed;
        private final IntFunction<P_OUT[]> generator;
        private final boolean isOrdered;
        private final AbstractPipeline<P_OUT, P_OUT, ?> op;
        private boolean shortCircuited;
        private long thisNodeSize;

        TakeWhileTask(AbstractPipeline<P_OUT, P_OUT, ?> op, PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator, IntFunction<P_OUT[]> generator) {
            super(helper, spliterator);
            this.op = op;
            this.generator = generator;
            this.isOrdered = StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags());
        }

        TakeWhileTask(TakeWhileTask<P_IN, P_OUT> parent, Spliterator<P_IN> spliterator) {
            super(parent, spliterator);
            this.op = parent.op;
            this.generator = parent.generator;
            this.isOrdered = parent.isOrdered;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public TakeWhileTask<P_IN, P_OUT> makeChild(Spliterator<P_IN> spliterator) {
            return new TakeWhileTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractShortCircuitTask
        public final Node<P_OUT> getEmptyResult() {
            return Nodes.emptyNode(this.op.getOutputShape());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public final Node<P_OUT> doLeaf() {
            Node.Builder<P_OUT> builder = this.helper.makeNodeBuilder(-1L, this.generator);
            Sink<P_OUT> s2 = this.op.opWrapSink(this.helper.getStreamAndOpFlags(), builder);
            boolean copyIntoWithCancel = this.helper.copyIntoWithCancel(this.helper.wrapSink(s2), this.spliterator);
            this.shortCircuited = copyIntoWithCancel;
            if (copyIntoWithCancel) {
                cancelLaterNodes();
            }
            Node<P_OUT> node = builder.build2();
            this.thisNodeSize = node.count();
            return node;
        }

        @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter<?> caller) {
            Node<P_OUT> result;
            if (!isLeaf()) {
                this.shortCircuited = ((TakeWhileTask) this.leftChild).shortCircuited | ((TakeWhileTask) this.rightChild).shortCircuited;
                if (this.isOrdered && this.canceled) {
                    this.thisNodeSize = 0L;
                    result = getEmptyResult();
                } else if (this.isOrdered && ((TakeWhileTask) this.leftChild).shortCircuited) {
                    this.thisNodeSize = ((TakeWhileTask) this.leftChild).thisNodeSize;
                    result = ((TakeWhileTask) this.leftChild).getLocalResult();
                } else {
                    this.thisNodeSize = ((TakeWhileTask) this.leftChild).thisNodeSize + ((TakeWhileTask) this.rightChild).thisNodeSize;
                    result = merge();
                }
                setLocalResult(result);
            }
            this.completed = true;
            super.onCompletion(caller);
        }

        Node<P_OUT> merge() {
            if (((TakeWhileTask) this.leftChild).thisNodeSize == 0) {
                return ((TakeWhileTask) this.rightChild).getLocalResult();
            }
            if (((TakeWhileTask) this.rightChild).thisNodeSize == 0) {
                return ((TakeWhileTask) this.leftChild).getLocalResult();
            }
            return Nodes.conc(this.op.getOutputShape(), ((TakeWhileTask) this.leftChild).getLocalResult(), ((TakeWhileTask) this.rightChild).getLocalResult());
        }

        @Override // java.util.stream.AbstractShortCircuitTask
        protected void cancel() {
            super.cancel();
            if (this.isOrdered && this.completed) {
                setLocalResult(getEmptyResult());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DropWhileTask<P_IN, P_OUT> extends AbstractTask<P_IN, P_OUT, Node<P_OUT>, DropWhileTask<P_IN, P_OUT>> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final IntFunction<P_OUT[]> generator;
        private long index;
        private final boolean isOrdered;
        private final AbstractPipeline<P_OUT, P_OUT, ?> op;
        private long thisNodeSize;

        DropWhileTask(AbstractPipeline<P_OUT, P_OUT, ?> op, PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator, IntFunction<P_OUT[]> generator) {
            super(helper, spliterator);
            this.op = op;
            this.generator = generator;
            this.isOrdered = StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags());
        }

        DropWhileTask(DropWhileTask<P_IN, P_OUT> parent, Spliterator<P_IN> spliterator) {
            super(parent, spliterator);
            this.op = parent.op;
            this.generator = parent.generator;
            this.isOrdered = parent.isOrdered;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public DropWhileTask<P_IN, P_OUT> makeChild(Spliterator<P_IN> spliterator) {
            return new DropWhileTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public final Node<P_OUT> doLeaf() {
            long j10;
            boolean z10 = !isRoot();
            if (z10 && this.isOrdered && StreamOpFlag.SIZED.isPreserved(this.op.sourceOrOpFlags)) {
                j10 = this.op.exactOutputSizeIfKnown(this.spliterator);
            } else {
                j10 = -1;
            }
            Node.Builder<P_OUT> makeNodeBuilder = this.helper.makeNodeBuilder(j10, this.generator);
            DropWhileSink opWrapSink = ((DropWhileOp) this.op).opWrapSink(makeNodeBuilder, this.isOrdered && z10);
            this.helper.wrapAndCopyInto(opWrapSink, this.spliterator);
            Node<P_OUT> build2 = makeNodeBuilder.build2();
            this.thisNodeSize = build2.count();
            this.index = opWrapSink.getDropCount();
            return build2;
        }

        @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter<?> caller) {
            if (!isLeaf()) {
                if (this.isOrdered) {
                    long j10 = ((DropWhileTask) this.leftChild).index;
                    this.index = j10;
                    if (j10 == ((DropWhileTask) this.leftChild).thisNodeSize) {
                        this.index += ((DropWhileTask) this.rightChild).index;
                    }
                }
                this.thisNodeSize = ((DropWhileTask) this.leftChild).thisNodeSize + ((DropWhileTask) this.rightChild).thisNodeSize;
                Node<P_OUT> result = merge();
                setLocalResult(isRoot() ? doTruncate(result) : result);
            }
            super.onCompletion(caller);
        }

        private Node<P_OUT> merge() {
            if (((DropWhileTask) this.leftChild).thisNodeSize == 0) {
                return ((DropWhileTask) this.rightChild).getLocalResult();
            }
            if (((DropWhileTask) this.rightChild).thisNodeSize == 0) {
                return ((DropWhileTask) this.leftChild).getLocalResult();
            }
            return Nodes.conc(this.op.getOutputShape(), ((DropWhileTask) this.leftChild).getLocalResult(), ((DropWhileTask) this.rightChild).getLocalResult());
        }

        private Node<P_OUT> doTruncate(Node<P_OUT> input) {
            if (this.isOrdered) {
                return input.truncate(this.index, input.count(), this.generator);
            }
            return input;
        }
    }
}
