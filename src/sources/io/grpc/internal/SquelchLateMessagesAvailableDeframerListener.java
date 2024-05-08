package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.Closeable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SquelchLateMessagesAvailableDeframerListener extends ForwardingDeframerListener {
    private boolean closed;
    private final MessageDeframer.Listener delegate;

    public SquelchLateMessagesAvailableDeframerListener(MessageDeframer.Listener listener) {
        this.delegate = listener;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable th) {
        this.closed = true;
        super.deframeFailed(th);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean z10) {
        this.closed = true;
        super.deframerClosed(z10);
    }

    @Override // io.grpc.internal.ForwardingDeframerListener
    public MessageDeframer.Listener delegate() {
        return this.delegate;
    }

    @Override // io.grpc.internal.ForwardingDeframerListener, io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        if (this.closed) {
            if (messageProducer instanceof Closeable) {
                GrpcUtil.closeQuietly((Closeable) messageProducer);
                return;
            }
            return;
        }
        super.messagesAvailable(messageProducer);
    }
}
