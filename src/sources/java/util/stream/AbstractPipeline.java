package java.util.stream;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Node;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractPipeline<E_IN, E_OUT, S extends BaseStream<E_OUT, S>> extends PipelineHelper<E_OUT> implements BaseStream<E_OUT, S> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String MSG_CONSUMED = "source already consumed or closed";
    private static final String MSG_STREAM_LINKED = "stream has already been operated upon or closed";
    private int combinedFlags;
    private int depth;
    private boolean linkedOrConsumed;
    private AbstractPipeline nextStage;
    private boolean parallel;
    private final AbstractPipeline previousStage;
    private boolean sourceAnyStateful;
    private Runnable sourceCloseAction;
    protected final int sourceOrOpFlags;
    private Spliterator<?> sourceSpliterator;
    private final AbstractPipeline sourceStage;
    private Supplier<? extends Spliterator<?>> sourceSupplier;

    public abstract <P_IN> Node<E_OUT> evaluateToNode(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, boolean z10, IntFunction<E_OUT[]> intFunction);

    public abstract boolean forEachWithCancel(Spliterator<E_OUT> spliterator, Sink<E_OUT> sink);

    public abstract StreamShape getOutputShape();

    public abstract Spliterator<E_OUT> lazySpliterator(Supplier<? extends Spliterator<E_OUT>> supplier);

    @Override // java.util.stream.PipelineHelper
    public abstract Node.Builder<E_OUT> makeNodeBuilder(long j10, IntFunction<E_OUT[]> intFunction);

    public abstract boolean opIsStateful();

    public abstract Sink<E_IN> opWrapSink(int i10, Sink<E_OUT> sink);

    public abstract <P_IN> Spliterator<E_OUT> wrap(PipelineHelper<E_OUT> pipelineHelper, Supplier<Spliterator<P_IN>> supplier, boolean z10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPipeline(Supplier<? extends Spliterator<?>> source, int sourceFlags, boolean parallel) {
        this.previousStage = null;
        this.sourceSupplier = source;
        this.sourceStage = this;
        int i10 = StreamOpFlag.STREAM_MASK & sourceFlags;
        this.sourceOrOpFlags = i10;
        this.combinedFlags = (~(i10 << 1)) & StreamOpFlag.INITIAL_OPS_VALUE;
        this.depth = 0;
        this.parallel = parallel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPipeline(Spliterator<?> source, int sourceFlags, boolean parallel) {
        this.previousStage = null;
        this.sourceSpliterator = source;
        this.sourceStage = this;
        int i10 = StreamOpFlag.STREAM_MASK & sourceFlags;
        this.sourceOrOpFlags = i10;
        this.combinedFlags = (~(i10 << 1)) & StreamOpFlag.INITIAL_OPS_VALUE;
        this.depth = 0;
        this.parallel = parallel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPipeline(AbstractPipeline<?, E_IN, ?> previousStage, int opFlags) {
        if (previousStage.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        previousStage.linkedOrConsumed = true;
        previousStage.nextStage = this;
        this.previousStage = previousStage;
        this.sourceOrOpFlags = StreamOpFlag.OP_MASK & opFlags;
        this.combinedFlags = StreamOpFlag.combineOpFlags(opFlags, previousStage.combinedFlags);
        AbstractPipeline abstractPipeline = previousStage.sourceStage;
        this.sourceStage = abstractPipeline;
        if (opIsStateful()) {
            abstractPipeline.sourceAnyStateful = true;
        }
        this.depth = previousStage.depth + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <R> R evaluate(TerminalOp<E_OUT, R> terminalOp) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (isParallel()) {
            return terminalOp.evaluateParallel(this, sourceSpliterator(terminalOp.getOpFlags()));
        }
        return terminalOp.evaluateSequential(this, sourceSpliterator(terminalOp.getOpFlags()));
    }

    public final Node<E_OUT> evaluateToArrayNode(IntFunction<E_OUT[]> generator) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (!isParallel() || this.previousStage == null || !opIsStateful()) {
            return evaluate(sourceSpliterator(0), true, generator);
        }
        this.depth = 0;
        AbstractPipeline abstractPipeline = this.previousStage;
        return opEvaluateParallel(abstractPipeline, abstractPipeline.sourceSpliterator(0), generator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Spliterator<E_OUT> sourceStageSpliterator() {
        AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this.sourceStage;
        if (this != abstractPipeline) {
            throw new IllegalStateException();
        }
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (abstractPipeline.sourceSpliterator != null) {
            Spliterator<E_OUT> spliterator = (Spliterator<E_OUT>) abstractPipeline.sourceSpliterator;
            abstractPipeline.sourceSpliterator = null;
            return spliterator;
        }
        Supplier<? extends Spliterator<?>> supplier = abstractPipeline.sourceSupplier;
        if (supplier != null) {
            Spliterator<E_OUT> spliterator2 = (Spliterator) supplier.get();
            this.sourceStage.sourceSupplier = null;
            return spliterator2;
        }
        throw new IllegalStateException(MSG_CONSUMED);
    }

    @Override // java.util.stream.BaseStream
    public final S sequential() {
        this.sourceStage.parallel = false;
        return this;
    }

    @Override // java.util.stream.BaseStream
    public final S parallel() {
        this.sourceStage.parallel = true;
        return this;
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public void close() {
        this.linkedOrConsumed = true;
        this.sourceSupplier = null;
        this.sourceSpliterator = null;
        AbstractPipeline abstractPipeline = this.sourceStage;
        if (abstractPipeline.sourceCloseAction != null) {
            Runnable closeAction = abstractPipeline.sourceCloseAction;
            abstractPipeline.sourceCloseAction = null;
            closeAction.run();
        }
    }

    @Override // java.util.stream.BaseStream
    public S onClose(Runnable closeHandler) {
        Runnable composeWithExceptions;
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        Objects.requireNonNull(closeHandler);
        AbstractPipeline abstractPipeline = this.sourceStage;
        Runnable existingHandler = abstractPipeline.sourceCloseAction;
        if (existingHandler == null) {
            composeWithExceptions = closeHandler;
        } else {
            composeWithExceptions = Streams.composeWithExceptions(existingHandler, closeHandler);
        }
        abstractPipeline.sourceCloseAction = composeWithExceptions;
        return this;
    }

    @Override // java.util.stream.BaseStream
    /* renamed from: spliterator */
    public Spliterator<E_OUT> spliterator2() {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        AbstractPipeline abstractPipeline = this.sourceStage;
        if (this == abstractPipeline) {
            if (abstractPipeline.sourceSpliterator != null) {
                Spliterator<E_OUT> spliterator = (Spliterator<E_OUT>) abstractPipeline.sourceSpliterator;
                abstractPipeline.sourceSpliterator = null;
                return spliterator;
            }
            if (abstractPipeline.sourceSupplier != null) {
                Supplier supplier = abstractPipeline.sourceSupplier;
                abstractPipeline.sourceSupplier = null;
                return lazySpliterator(supplier);
            }
            throw new IllegalStateException(MSG_CONSUMED);
        }
        return wrap(this, new Supplier() { // from class: java.util.stream.AbstractPipeline$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator lambda$spliterator$0;
                lambda$spliterator$0 = AbstractPipeline.this.lambda$spliterator$0();
                return lambda$spliterator$0;
            }
        }, isParallel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Spliterator lambda$spliterator$0() {
        return sourceSpliterator(0);
    }

    @Override // java.util.stream.BaseStream
    public final boolean isParallel() {
        return this.sourceStage.parallel;
    }

    public final int getStreamFlags() {
        return StreamOpFlag.toStreamFlags(this.combinedFlags);
    }

    private Spliterator<?> sourceSpliterator(int terminalFlags) {
        Spliterator<?> spliterator;
        int i10;
        AbstractPipeline abstractPipeline = this.sourceStage;
        if (abstractPipeline.sourceSpliterator != null) {
            spliterator = abstractPipeline.sourceSpliterator;
            abstractPipeline.sourceSpliterator = null;
        } else {
            Supplier<? extends Spliterator<?>> supplier = abstractPipeline.sourceSupplier;
            if (supplier != null) {
                Spliterator<?> spliterator2 = supplier.get();
                spliterator = spliterator2;
                this.sourceStage.sourceSupplier = null;
            } else {
                throw new IllegalStateException(MSG_CONSUMED);
            }
        }
        if (isParallel()) {
            AbstractPipeline abstractPipeline2 = this.sourceStage;
            if (abstractPipeline2.sourceAnyStateful) {
                int depth = 1;
                AbstractPipeline u10 = this.sourceStage;
                AbstractPipeline p10 = abstractPipeline2.nextStage;
                while (u10 != this) {
                    int thisOpFlags = p10.sourceOrOpFlags;
                    if (p10.opIsStateful()) {
                        depth = 0;
                        if (StreamOpFlag.SHORT_CIRCUIT.isKnown(thisOpFlags)) {
                            thisOpFlags &= ~StreamOpFlag.IS_SHORT_CIRCUIT;
                        }
                        spliterator = p10.opEvaluateParallelLazy(u10, spliterator);
                        if (spliterator.hasCharacteristics(64)) {
                            i10 = ((~StreamOpFlag.NOT_SIZED) & thisOpFlags) | StreamOpFlag.IS_SIZED;
                        } else {
                            i10 = ((~StreamOpFlag.IS_SIZED) & thisOpFlags) | StreamOpFlag.NOT_SIZED;
                        }
                        thisOpFlags = i10;
                    }
                    p10.depth = depth;
                    p10.combinedFlags = StreamOpFlag.combineOpFlags(thisOpFlags, u10.combinedFlags);
                    u10 = p10;
                    p10 = p10.nextStage;
                    depth++;
                }
            }
        }
        if (terminalFlags != 0) {
            this.combinedFlags = StreamOpFlag.combineOpFlags(terminalFlags, this.combinedFlags);
        }
        return spliterator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.util.stream.PipelineHelper
    public final StreamShape getSourceShape() {
        AbstractPipeline p10 = this;
        while (p10.depth > 0) {
            p10 = p10.previousStage;
        }
        return p10.getOutputShape();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.util.stream.PipelineHelper
    public final <P_IN> long exactOutputSizeIfKnown(Spliterator<P_IN> spliterator) {
        int flags = getStreamAndOpFlags();
        long size = StreamOpFlag.SIZED.isKnown(flags) ? spliterator.getExactSizeIfKnown() : -1L;
        if (size != -1 && StreamOpFlag.SIZE_ADJUSTING.isKnown(flags) && !isParallel()) {
            for (AbstractPipeline<?, ?, ?> stage = this.sourceStage.nextStage; stage != null; stage = stage.nextStage) {
                size = stage.exactOutputSize(size);
            }
        }
        return size;
    }

    long exactOutputSize(long previousSize) {
        return previousSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Incorrect return type in method signature: <P_IN:Ljava/lang/Object;S::Ljava/util/stream/Sink<TE_OUT;>;>(TS;Ljava/util/Spliterator<TP_IN;>;)TS; */
    @Override // java.util.stream.PipelineHelper
    public final Sink wrapAndCopyInto(Sink sink, Spliterator spliterator) {
        copyInto(wrapSink((Sink) Objects.requireNonNull(sink)), spliterator);
        return sink;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.util.stream.PipelineHelper
    public final <P_IN> void copyInto(Sink<P_IN> wrappedSink, Spliterator<P_IN> spliterator) {
        Objects.requireNonNull(wrappedSink);
        if (!StreamOpFlag.SHORT_CIRCUIT.isKnown(getStreamAndOpFlags())) {
            wrappedSink.begin(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(wrappedSink);
            wrappedSink.end();
            return;
        }
        copyIntoWithCancel(wrappedSink, spliterator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.util.stream.PipelineHelper
    public final <P_IN> boolean copyIntoWithCancel(Sink<P_IN> sink, Spliterator<P_IN> spliterator) {
        AbstractPipeline p10 = this;
        while (p10.depth > 0) {
            p10 = p10.previousStage;
        }
        sink.begin(spliterator.getExactSizeIfKnown());
        boolean cancelled = p10.forEachWithCancel(spliterator, sink);
        sink.end();
        return cancelled;
    }

    @Override // java.util.stream.PipelineHelper
    public final int getStreamAndOpFlags() {
        return this.combinedFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isOrdered() {
        return StreamOpFlag.ORDERED.isKnown(this.combinedFlags);
    }

    @Override // java.util.stream.PipelineHelper
    public final <P_IN> Sink<P_IN> wrapSink(Sink<E_OUT> sink) {
        Objects.requireNonNull(sink);
        for (AbstractPipeline<E_IN, E_OUT, S> abstractPipeline = this; abstractPipeline.depth > 0; abstractPipeline = abstractPipeline.previousStage) {
            sink = (Sink<P_IN>) abstractPipeline.opWrapSink(abstractPipeline.previousStage.combinedFlags, sink);
        }
        return (Sink<P_IN>) sink;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.stream.PipelineHelper
    public final <P_IN> Spliterator<E_OUT> wrapSpliterator(final Spliterator<P_IN> spliterator) {
        if (this.depth == 0) {
            return spliterator;
        }
        return wrap(this, new Supplier() { // from class: java.util.stream.AbstractPipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return AbstractPipeline.lambda$wrapSpliterator$1(Spliterator.this);
            }
        }, isParallel());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Spliterator lambda$wrapSpliterator$1(Spliterator sourceSpliterator) {
        return sourceSpliterator;
    }

    @Override // java.util.stream.PipelineHelper
    public final <P_IN> Node<E_OUT> evaluate(Spliterator<P_IN> spliterator, boolean flatten, IntFunction<E_OUT[]> generator) {
        if (isParallel()) {
            return evaluateToNode(this, spliterator, flatten, generator);
        }
        Node.Builder<E_OUT> nb2 = makeNodeBuilder(exactOutputSizeIfKnown(spliterator), generator);
        return ((Node.Builder) wrapAndCopyInto(nb2, spliterator)).build2();
    }

    public <P_IN> Node<E_OUT> opEvaluateParallel(PipelineHelper<E_OUT> helper, Spliterator<P_IN> spliterator, IntFunction<E_OUT[]> generator) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$opEvaluateParallelLazy$2(int i10) {
        return new Object[i10];
    }

    public <P_IN> Spliterator<E_OUT> opEvaluateParallelLazy(PipelineHelper<E_OUT> helper, Spliterator<P_IN> spliterator) {
        return opEvaluateParallel(helper, spliterator, new IntFunction() { // from class: java.util.stream.AbstractPipeline$$ExternalSyntheticLambda1
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return AbstractPipeline.lambda$opEvaluateParallelLazy$2(i10);
            }
        }).spliterator();
    }
}
