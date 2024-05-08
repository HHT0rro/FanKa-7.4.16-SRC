package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class ForwardingDeframerListener implements MessageDeframer.Listener {
    @Override // io.grpc.internal.MessageDeframer.Listener
    public void bytesRead(int i10) {
        delegate().bytesRead(i10);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable th) {
        delegate().deframeFailed(th);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean z10) {
        delegate().deframerClosed(z10);
    }

    public abstract MessageDeframer.Listener delegate();

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        delegate().messagesAvailable(messageProducer);
    }
}
