package java.util;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final /* synthetic */ class PrimitiveIterator$OfLong$$ExternalSyntheticLambda0 implements LongConsumer {
    public final /* synthetic */ Consumer f$0;

    public /* synthetic */ PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(Consumer consumer) {
        this.f$0 = consumer;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j10) {
        this.f$0.accept(Long.valueOf(j10));
    }
}
