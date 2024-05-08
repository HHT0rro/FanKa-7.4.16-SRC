package java.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final /* synthetic */ class PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0 implements DoubleConsumer {
    public final /* synthetic */ Consumer f$0;

    public /* synthetic */ PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(Consumer consumer) {
        this.f$0 = consumer;
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d10) {
        this.f$0.accept(Double.valueOf(d10));
    }
}
