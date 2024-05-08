package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class StreamTracer {
    public void inboundMessage(int i10) {
    }

    public void inboundMessageRead(int i10, long j10, long j11) {
    }

    public void inboundUncompressedSize(long j10) {
    }

    public void inboundWireSize(long j10) {
    }

    public void outboundMessage(int i10) {
    }

    public void outboundMessageSent(int i10, long j10, long j11) {
    }

    public void outboundUncompressedSize(long j10) {
    }

    public void outboundWireSize(long j10) {
    }

    public void streamClosed(Status status) {
    }
}
