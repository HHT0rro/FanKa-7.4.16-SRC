package io.grpc.internal;

import com.google.common.base.j;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingClientStreamTracer extends ClientStreamTracer {
    public abstract ClientStreamTracer delegate();

    @Override // io.grpc.ClientStreamTracer
    public void inboundHeaders() {
        delegate().inboundHeaders();
    }

    @Override // io.grpc.StreamTracer
    public void inboundMessage(int i10) {
        delegate().inboundMessage(i10);
    }

    @Override // io.grpc.StreamTracer
    public void inboundMessageRead(int i10, long j10, long j11) {
        delegate().inboundMessageRead(i10, j10, j11);
    }

    @Override // io.grpc.ClientStreamTracer
    public void inboundTrailers(Metadata metadata) {
        delegate().inboundTrailers(metadata);
    }

    @Override // io.grpc.StreamTracer
    public void inboundUncompressedSize(long j10) {
        delegate().inboundUncompressedSize(j10);
    }

    @Override // io.grpc.StreamTracer
    public void inboundWireSize(long j10) {
        delegate().inboundWireSize(j10);
    }

    @Override // io.grpc.ClientStreamTracer
    public void outboundHeaders() {
        delegate().outboundHeaders();
    }

    @Override // io.grpc.StreamTracer
    public void outboundMessage(int i10) {
        delegate().outboundMessage(i10);
    }

    @Override // io.grpc.StreamTracer
    public void outboundMessageSent(int i10, long j10, long j11) {
        delegate().outboundMessageSent(i10, j10, j11);
    }

    @Override // io.grpc.StreamTracer
    public void outboundUncompressedSize(long j10) {
        delegate().outboundUncompressedSize(j10);
    }

    @Override // io.grpc.StreamTracer
    public void outboundWireSize(long j10) {
        delegate().outboundWireSize(j10);
    }

    @Override // io.grpc.StreamTracer
    public void streamClosed(Status status) {
        delegate().streamClosed(status);
    }

    @Override // io.grpc.ClientStreamTracer
    public void streamCreated(Attributes attributes, Metadata metadata) {
        delegate().streamCreated(attributes, metadata);
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }
}
