package java.util.stream;

import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.stream.Node;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class PipelineHelper<P_OUT> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> void copyInto(Sink<P_IN> sink, Spliterator<P_IN> spliterator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> boolean copyIntoWithCancel(Sink<P_IN> sink, Spliterator<P_IN> spliterator);

    public abstract <P_IN> Node<P_OUT> evaluate(Spliterator<P_IN> spliterator, boolean z10, IntFunction<P_OUT[]> intFunction);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> long exactOutputSizeIfKnown(Spliterator<P_IN> spliterator);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract StreamShape getSourceShape();

    public abstract int getStreamAndOpFlags();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Node.Builder<P_OUT> makeNodeBuilder(long j10, IntFunction<P_OUT[]> intFunction);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN, S extends Sink<P_OUT>> S wrapAndCopyInto(S s2, Spliterator<P_IN> spliterator);

    public abstract <P_IN> Sink<P_IN> wrapSink(Sink<P_OUT> sink);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <P_IN> Spliterator<P_OUT> wrapSpliterator(Spliterator<P_IN> spliterator);
}
