package java.util.stream;

import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;
import java.util.stream.DoublePipeline;
import java.util.stream.IntPipeline;
import java.util.stream.LongPipeline;
import java.util.stream.Node;
import java.util.stream.ReferencePipeline;
import java.util.stream.Sink;
import java.util.stream.SliceOps;
import java.util.stream.StreamSpliterators;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class SliceOps {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: -$$Nest$smcastingArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntFunction m3521$$Nest$smcastingArray() {
        return castingArray();
    }

    private SliceOps() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long calcSize(long size, long skip, long limit) {
        if (size >= 0) {
            return Math.max(-1L, Math.min(size - skip, limit));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long calcSliceFence(long skip, long limit) {
        long sliceFence = limit >= 0 ? skip + limit : Long.MAX_VALUE;
        if (sliceFence >= 0) {
            return sliceFence;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <P_IN> Spliterator<P_IN> sliceSpliterator(StreamShape shape, Spliterator<P_IN> s2, long skip, long limit) {
        long sliceFence = calcSliceFence(skip, limit);
        switch (AnonymousClass5.$SwitchMap$java$util$stream$StreamShape[shape.ordinal()]) {
            case 1:
                return new StreamSpliterators.SliceSpliterator.OfRef(s2, skip, sliceFence);
            case 2:
                return new StreamSpliterators.SliceSpliterator.OfInt((Spliterator.OfInt) s2, skip, sliceFence);
            case 3:
                return new StreamSpliterators.SliceSpliterator.OfLong((Spliterator.OfLong) s2, skip, sliceFence);
            case 4:
                return new StreamSpliterators.SliceSpliterator.OfDouble((Spliterator.OfDouble) s2, skip, sliceFence);
            default:
                throw new IllegalStateException("Unknown shape " + ((Object) shape));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.SliceOps$5, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$java$util$stream$StreamShape;

        static {
            int[] iArr = new int[StreamShape.values().length];
            $SwitchMap$java$util$stream$StreamShape = iArr;
            try {
                iArr[StreamShape.REFERENCE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.INT_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.LONG_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    private static <T> IntFunction<T[]> castingArray() {
        return new IntFunction() { // from class: java.util.stream.SliceOps$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return SliceOps.lambda$castingArray$0(i10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$castingArray$0(int size) {
        return new Object[size];
    }

    public static <T> Stream<T> makeRef(AbstractPipeline<?, T, ?> upstream, final long skip, final long limit) {
        if (skip < 0) {
            throw new IllegalArgumentException("Skip must be non-negative: " + skip);
        }
        return new ReferencePipeline.StatefulOp<T, T>(upstream, StreamShape.REFERENCE, flags(limit)) { // from class: java.util.stream.SliceOps.1
            Spliterator<T> unorderedSkipLimitSpliterator(Spliterator<T> s2, long skip2, long limit2, long sizeIfKnown) {
                if (skip2 <= sizeIfKnown) {
                    limit2 = limit2 >= 0 ? Math.min(limit2, sizeIfKnown - skip2) : sizeIfKnown - skip2;
                    skip2 = 0;
                }
                return new StreamSpliterators.UnorderedSliceSpliterator.OfRef(s2, skip2, limit2);
            }

            @Override // java.util.stream.AbstractPipeline
            public <P_IN> Spliterator<T> opEvaluateParallelLazy(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
                long size = helper.exactOutputSizeIfKnown(spliterator);
                if (size > 0 && spliterator.hasCharacteristics(16384)) {
                    Spliterator<T> wrapSpliterator = helper.wrapSpliterator(spliterator);
                    long j10 = skip;
                    return new StreamSpliterators.SliceSpliterator.OfRef(wrapSpliterator, j10, SliceOps.calcSliceFence(j10, limit));
                }
                if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                    return unorderedSkipLimitSpliterator(helper.wrapSpliterator(spliterator), skip, limit, size);
                }
                return new SliceTask(this, helper, spliterator, SliceOps.m3521$$Nest$smcastingArray(), skip, limit).invoke().spliterator();
            }

            @Override // java.util.stream.ReferencePipeline.StatefulOp, java.util.stream.AbstractPipeline
            public <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> helper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
                long size = helper.exactOutputSizeIfKnown(spliterator);
                if (size > 0 && spliterator.hasCharacteristics(16384)) {
                    Spliterator<P_IN> s2 = SliceOps.sliceSpliterator(helper.getSourceShape(), spliterator, skip, limit);
                    return Nodes.collect(helper, s2, true, generator);
                }
                if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                    Spliterator<T> s10 = unorderedSkipLimitSpliterator(helper.wrapSpliterator(spliterator), skip, limit, size);
                    return Nodes.collect(this, s10, true, generator);
                }
                return (Node) new SliceTask(this, helper, spliterator, generator, skip, limit).invoke();
            }

            @Override // java.util.stream.AbstractPipeline
            public Sink<T> opWrapSink(int flags, Sink<T> sink) {
                return new Sink.ChainedReference<T, T>(sink) { // from class: java.util.stream.SliceOps.1.1

                    /* renamed from: m, reason: collision with root package name */
                    long f50507m;

                    /* renamed from: n, reason: collision with root package name */
                    long f50508n;

                    {
                        this.f50508n = skip;
                        this.f50507m = limit >= 0 ? limit : Long.MAX_VALUE;
                    }

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(SliceOps.calcSize(size, skip, this.f50507m));
                    }

                    @Override // java.util.function.Consumer
                    public void accept(T t2) {
                        long j10 = this.f50508n;
                        if (j10 == 0) {
                            long j11 = this.f50507m;
                            if (j11 > 0) {
                                this.f50507m = j11 - 1;
                                this.downstream.accept(t2);
                                return;
                            }
                            return;
                        }
                        this.f50508n = j10 - 1;
                    }

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public boolean cancellationRequested() {
                        return this.f50507m == 0 || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    public static IntStream makeInt(AbstractPipeline<?, Integer, ?> upstream, long skip, long limit) {
        if (skip < 0) {
            throw new IllegalArgumentException("Skip must be non-negative: " + skip);
        }
        return new AnonymousClass2(upstream, StreamShape.INT_VALUE, flags(limit), skip, limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.SliceOps$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class AnonymousClass2 extends IntPipeline.StatefulOp<Integer> {
        final /* synthetic */ long val$limit;
        final /* synthetic */ long val$skip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, long j10, long j11) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$skip = j10;
            this.val$limit = j11;
        }

        Spliterator.OfInt unorderedSkipLimitSpliterator(Spliterator.OfInt s2, long skip, long limit, long sizeIfKnown) {
            if (skip <= sizeIfKnown) {
                limit = limit >= 0 ? Math.min(limit, sizeIfKnown - skip) : sizeIfKnown - skip;
                skip = 0;
            }
            return new StreamSpliterators.UnorderedSliceSpliterator.OfInt(s2, skip, limit);
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Integer> opEvaluateParallelLazy(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator) {
            long size = helper.exactOutputSizeIfKnown(spliterator);
            if (size > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.OfInt ofInt = (Spliterator.OfInt) helper.wrapSpliterator(spliterator);
                long j10 = this.val$skip;
                return new StreamSpliterators.SliceSpliterator.OfInt(ofInt, j10, SliceOps.calcSliceFence(j10, this.val$limit));
            }
            if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return unorderedSkipLimitSpliterator((Spliterator.OfInt) helper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, size);
            }
            return new SliceTask(this, helper, spliterator, new IntFunction() { // from class: java.util.stream.SliceOps$2$$ExternalSyntheticLambda0
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    return SliceOps.AnonymousClass2.lambda$opEvaluateParallelLazy$0(i10);
                }
            }, this.val$skip, this.val$limit).invoke().spliterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Integer[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Integer[x$0];
        }

        @Override // java.util.stream.IntPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> generator) {
            long size = helper.exactOutputSizeIfKnown(spliterator);
            if (size > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator<P_IN> s2 = SliceOps.sliceSpliterator(helper.getSourceShape(), spliterator, this.val$skip, this.val$limit);
                return Nodes.collectInt(helper, s2, true);
            }
            if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                Spliterator.OfInt s10 = unorderedSkipLimitSpliterator((Spliterator.OfInt) helper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, size);
                return Nodes.collectInt(this, s10, true);
            }
            return (Node) new SliceTask(this, helper, spliterator, generator, this.val$skip, this.val$limit).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
            return new Sink.ChainedInt<Integer>(sink) { // from class: java.util.stream.SliceOps.2.1

                /* renamed from: m, reason: collision with root package name */
                long f50509m;

                /* renamed from: n, reason: collision with root package name */
                long f50510n;

                {
                    this.f50510n = AnonymousClass2.this.val$skip;
                    this.f50509m = AnonymousClass2.this.val$limit >= 0 ? AnonymousClass2.this.val$limit : Long.MAX_VALUE;
                }

                @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(SliceOps.calcSize(size, AnonymousClass2.this.val$skip, this.f50509m));
                }

                @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                public void accept(int t2) {
                    long j10 = this.f50510n;
                    if (j10 == 0) {
                        long j11 = this.f50509m;
                        if (j11 > 0) {
                            this.f50509m = j11 - 1;
                            this.downstream.accept(t2);
                            return;
                        }
                        return;
                    }
                    this.f50510n = j10 - 1;
                }

                @Override // java.util.stream.Sink.ChainedInt, java.util.stream.Sink
                public boolean cancellationRequested() {
                    return this.f50509m == 0 || this.downstream.cancellationRequested();
                }
            };
        }
    }

    public static LongStream makeLong(AbstractPipeline<?, Long, ?> upstream, long skip, long limit) {
        if (skip < 0) {
            throw new IllegalArgumentException("Skip must be non-negative: " + skip);
        }
        return new AnonymousClass3(upstream, StreamShape.LONG_VALUE, flags(limit), skip, limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.SliceOps$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class AnonymousClass3 extends LongPipeline.StatefulOp<Long> {
        final /* synthetic */ long val$limit;
        final /* synthetic */ long val$skip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, long j10, long j11) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$skip = j10;
            this.val$limit = j11;
        }

        Spliterator.OfLong unorderedSkipLimitSpliterator(Spliterator.OfLong s2, long skip, long limit, long sizeIfKnown) {
            if (skip <= sizeIfKnown) {
                limit = limit >= 0 ? Math.min(limit, sizeIfKnown - skip) : sizeIfKnown - skip;
                skip = 0;
            }
            return new StreamSpliterators.UnorderedSliceSpliterator.OfLong(s2, skip, limit);
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Long> opEvaluateParallelLazy(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator) {
            long size = helper.exactOutputSizeIfKnown(spliterator);
            if (size > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.OfLong ofLong = (Spliterator.OfLong) helper.wrapSpliterator(spliterator);
                long j10 = this.val$skip;
                return new StreamSpliterators.SliceSpliterator.OfLong(ofLong, j10, SliceOps.calcSliceFence(j10, this.val$limit));
            }
            if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return unorderedSkipLimitSpliterator((Spliterator.OfLong) helper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, size);
            }
            return new SliceTask(this, helper, spliterator, new IntFunction() { // from class: java.util.stream.SliceOps$3$$ExternalSyntheticLambda0
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    return SliceOps.AnonymousClass3.lambda$opEvaluateParallelLazy$0(i10);
                }
            }, this.val$skip, this.val$limit).invoke().spliterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Long[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Long[x$0];
        }

        @Override // java.util.stream.LongPipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator, IntFunction<Long[]> generator) {
            long size = helper.exactOutputSizeIfKnown(spliterator);
            if (size > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator<P_IN> s2 = SliceOps.sliceSpliterator(helper.getSourceShape(), spliterator, this.val$skip, this.val$limit);
                return Nodes.collectLong(helper, s2, true);
            }
            if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                Spliterator.OfLong s10 = unorderedSkipLimitSpliterator((Spliterator.OfLong) helper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, size);
                return Nodes.collectLong(this, s10, true);
            }
            return (Node) new SliceTask(this, helper, spliterator, generator, this.val$skip, this.val$limit).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
            return new Sink.ChainedLong<Long>(sink) { // from class: java.util.stream.SliceOps.3.1

                /* renamed from: m, reason: collision with root package name */
                long f50511m;

                /* renamed from: n, reason: collision with root package name */
                long f50512n;

                {
                    this.f50512n = AnonymousClass3.this.val$skip;
                    this.f50511m = AnonymousClass3.this.val$limit >= 0 ? AnonymousClass3.this.val$limit : Long.MAX_VALUE;
                }

                @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(SliceOps.calcSize(size, AnonymousClass3.this.val$skip, this.f50511m));
                }

                @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                public void accept(long t2) {
                    long j10 = this.f50512n;
                    if (j10 == 0) {
                        long j11 = this.f50511m;
                        if (j11 > 0) {
                            this.f50511m = j11 - 1;
                            this.downstream.accept(t2);
                            return;
                        }
                        return;
                    }
                    this.f50512n = j10 - 1;
                }

                @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
                public boolean cancellationRequested() {
                    return this.f50511m == 0 || this.downstream.cancellationRequested();
                }
            };
        }
    }

    public static DoubleStream makeDouble(AbstractPipeline<?, Double, ?> upstream, long skip, long limit) {
        if (skip < 0) {
            throw new IllegalArgumentException("Skip must be non-negative: " + skip);
        }
        return new AnonymousClass4(upstream, StreamShape.DOUBLE_VALUE, flags(limit), skip, limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.SliceOps$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class AnonymousClass4 extends DoublePipeline.StatefulOp<Double> {
        final /* synthetic */ long val$limit;
        final /* synthetic */ long val$skip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, long j10, long j11) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$skip = j10;
            this.val$limit = j11;
        }

        Spliterator.OfDouble unorderedSkipLimitSpliterator(Spliterator.OfDouble s2, long skip, long limit, long sizeIfKnown) {
            if (skip <= sizeIfKnown) {
                limit = limit >= 0 ? Math.min(limit, sizeIfKnown - skip) : sizeIfKnown - skip;
                skip = 0;
            }
            return new StreamSpliterators.UnorderedSliceSpliterator.OfDouble(s2, skip, limit);
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<Double> opEvaluateParallelLazy(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator) {
            long size = helper.exactOutputSizeIfKnown(spliterator);
            if (size > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.OfDouble ofDouble = (Spliterator.OfDouble) helper.wrapSpliterator(spliterator);
                long j10 = this.val$skip;
                return new StreamSpliterators.SliceSpliterator.OfDouble(ofDouble, j10, SliceOps.calcSliceFence(j10, this.val$limit));
            }
            if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return unorderedSkipLimitSpliterator((Spliterator.OfDouble) helper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, size);
            }
            return new SliceTask(this, helper, spliterator, new IntFunction() { // from class: java.util.stream.SliceOps$4$$ExternalSyntheticLambda0
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    return SliceOps.AnonymousClass4.lambda$opEvaluateParallelLazy$0(i10);
                }
            }, this.val$skip, this.val$limit).invoke().spliterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Double[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Double[x$0];
        }

        @Override // java.util.stream.DoublePipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator, IntFunction<Double[]> generator) {
            long size = helper.exactOutputSizeIfKnown(spliterator);
            if (size > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator<P_IN> s2 = SliceOps.sliceSpliterator(helper.getSourceShape(), spliterator, this.val$skip, this.val$limit);
                return Nodes.collectDouble(helper, s2, true);
            }
            if (!StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                Spliterator.OfDouble s10 = unorderedSkipLimitSpliterator((Spliterator.OfDouble) helper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, size);
                return Nodes.collectDouble(this, s10, true);
            }
            return (Node) new SliceTask(this, helper, spliterator, generator, this.val$skip, this.val$limit).invoke();
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
            return new Sink.ChainedDouble<Double>(sink) { // from class: java.util.stream.SliceOps.4.1

                /* renamed from: m, reason: collision with root package name */
                long f50513m;

                /* renamed from: n, reason: collision with root package name */
                long f50514n;

                {
                    this.f50514n = AnonymousClass4.this.val$skip;
                    this.f50513m = AnonymousClass4.this.val$limit >= 0 ? AnonymousClass4.this.val$limit : Long.MAX_VALUE;
                }

                @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(SliceOps.calcSize(size, AnonymousClass4.this.val$skip, this.f50513m));
                }

                @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                public void accept(double t2) {
                    long j10 = this.f50514n;
                    if (j10 == 0) {
                        long j11 = this.f50513m;
                        if (j11 > 0) {
                            this.f50513m = j11 - 1;
                            this.downstream.accept(t2);
                            return;
                        }
                        return;
                    }
                    this.f50514n = j10 - 1;
                }

                @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
                public boolean cancellationRequested() {
                    return this.f50513m == 0 || this.downstream.cancellationRequested();
                }
            };
        }
    }

    private static int flags(long limit) {
        return StreamOpFlag.NOT_SIZED | (limit != -1 ? StreamOpFlag.IS_SHORT_CIRCUIT : 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class SliceTask<P_IN, P_OUT> extends AbstractShortCircuitTask<P_IN, P_OUT, Node<P_OUT>, SliceTask<P_IN, P_OUT>> {
        private volatile boolean completed;
        private final IntFunction<P_OUT[]> generator;
        private final AbstractPipeline<P_OUT, P_OUT, ?> op;
        private final long targetOffset;
        private final long targetSize;
        private long thisNodeSize;

        SliceTask(AbstractPipeline<P_OUT, P_OUT, ?> op, PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator, IntFunction<P_OUT[]> generator, long offset, long size) {
            super(helper, spliterator);
            this.op = op;
            this.generator = generator;
            this.targetOffset = offset;
            this.targetSize = size;
        }

        SliceTask(SliceTask<P_IN, P_OUT> parent, Spliterator<P_IN> spliterator) {
            super(parent, spliterator);
            this.op = parent.op;
            this.generator = parent.generator;
            this.targetOffset = parent.targetOffset;
            this.targetSize = parent.targetSize;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public SliceTask<P_IN, P_OUT> makeChild(Spliterator<P_IN> spliterator) {
            return new SliceTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractShortCircuitTask
        public final Node<P_OUT> getEmptyResult() {
            return Nodes.emptyNode(this.op.getOutputShape());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public final Node<P_OUT> doLeaf() {
            if (isRoot()) {
                long sizeIfKnown = StreamOpFlag.SIZED.isPreserved(this.op.sourceOrOpFlags) ? this.op.exactOutputSizeIfKnown(this.spliterator) : -1L;
                Node.Builder<P_OUT> nb2 = this.op.makeNodeBuilder(sizeIfKnown, this.generator);
                Sink<P_OUT> opSink = this.op.opWrapSink(this.helper.getStreamAndOpFlags(), nb2);
                this.helper.copyIntoWithCancel(this.helper.wrapSink(opSink), this.spliterator);
                return nb2.build2();
            }
            Node<P_OUT> node = ((Node.Builder) this.helper.wrapAndCopyInto(this.helper.makeNodeBuilder(-1L, this.generator), this.spliterator)).build2();
            this.thisNodeSize = node.count();
            this.completed = true;
            this.spliterator = null;
            return node;
        }

        @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter<?> caller) {
            Node<P_OUT> result;
            if (!isLeaf()) {
                this.thisNodeSize = ((SliceTask) this.leftChild).thisNodeSize + ((SliceTask) this.rightChild).thisNodeSize;
                if (this.canceled) {
                    this.thisNodeSize = 0L;
                    result = getEmptyResult();
                } else if (this.thisNodeSize == 0) {
                    result = getEmptyResult();
                } else if (((SliceTask) this.leftChild).thisNodeSize == 0) {
                    result = ((SliceTask) this.rightChild).getLocalResult();
                } else {
                    result = Nodes.conc(this.op.getOutputShape(), ((SliceTask) this.leftChild).getLocalResult(), ((SliceTask) this.rightChild).getLocalResult());
                }
                setLocalResult(isRoot() ? doTruncate(result) : result);
                this.completed = true;
            }
            if (this.targetSize >= 0 && !isRoot() && isLeftCompleted(this.targetOffset + this.targetSize)) {
                cancelLaterNodes();
            }
            super.onCompletion(caller);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractShortCircuitTask
        public void cancel() {
            super.cancel();
            if (this.completed) {
                setLocalResult(getEmptyResult());
            }
        }

        private Node<P_OUT> doTruncate(Node<P_OUT> input) {
            long to = this.targetSize >= 0 ? Math.min(input.count(), this.targetOffset + this.targetSize) : this.thisNodeSize;
            return input.truncate(this.targetOffset, to, this.generator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean isLeftCompleted(long target) {
            SliceTask<P_IN, P_OUT> left;
            long size = this.completed ? this.thisNodeSize : completedSize(target);
            if (size >= target) {
                return true;
            }
            SliceTask<P_IN, P_OUT> node = this;
            for (SliceTask<P_IN, P_OUT> parent = (SliceTask) getParent(); parent != null; parent = (SliceTask) parent.getParent()) {
                if (node == parent.rightChild && (left = (SliceTask) parent.leftChild) != null) {
                    size += left.completedSize(target);
                    if (size >= target) {
                        return true;
                    }
                }
                node = parent;
            }
            return size >= target;
        }

        private long completedSize(long target) {
            if (this.completed) {
                return this.thisNodeSize;
            }
            SliceTask<P_IN, P_OUT> left = (SliceTask) this.leftChild;
            SliceTask<P_IN, P_OUT> right = (SliceTask) this.rightChild;
            if (left == null || right == null) {
                return this.thisNodeSize;
            }
            long leftSize = left.completedSize(target);
            return leftSize >= target ? leftSize : right.completedSize(target) + leftSize;
        }
    }
}
