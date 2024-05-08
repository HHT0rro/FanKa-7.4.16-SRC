package io.grpc.internal;

import com.google.common.base.j;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class ForwardingClientStreamListener implements ClientStreamListener {
    @Override // io.grpc.internal.ClientStreamListener
    public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
        delegate().closed(status, rpcProgress, metadata);
    }

    public abstract ClientStreamListener delegate();

    @Override // io.grpc.internal.ClientStreamListener
    public void headersRead(Metadata metadata) {
        delegate().headersRead(metadata);
    }

    @Override // io.grpc.internal.StreamListener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        delegate().messagesAvailable(messageProducer);
    }

    @Override // io.grpc.internal.StreamListener
    public void onReady() {
        delegate().onReady();
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }
}
