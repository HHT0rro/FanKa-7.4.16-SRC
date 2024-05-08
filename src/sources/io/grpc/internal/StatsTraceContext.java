package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.StreamTracer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StatsTraceContext {
    public static final StatsTraceContext NOOP = new StatsTraceContext(new StreamTracer[0]);
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final StreamTracer[] tracers;

    public StatsTraceContext(StreamTracer[] streamTracerArr) {
        this.tracers = streamTracerArr;
    }

    public static StatsTraceContext newClientContext(ClientStreamTracer[] clientStreamTracerArr, Attributes attributes, Metadata metadata) {
        StatsTraceContext statsTraceContext = new StatsTraceContext(clientStreamTracerArr);
        for (ClientStreamTracer clientStreamTracer : clientStreamTracerArr) {
            clientStreamTracer.streamCreated(attributes, metadata);
        }
        return statsTraceContext;
    }

    public static StatsTraceContext newServerContext(List<? extends ServerStreamTracer.Factory> list, String str, Metadata metadata) {
        if (list.isEmpty()) {
            return NOOP;
        }
        int size = list.size();
        StreamTracer[] streamTracerArr = new StreamTracer[size];
        for (int i10 = 0; i10 < size; i10++) {
            streamTracerArr[i10] = list.get(i10).newServerStreamTracer(str, metadata);
        }
        return new StatsTraceContext(streamTracerArr);
    }

    public void clientInboundHeaders() {
        for (StreamTracer streamTracer : this.tracers) {
            ((ClientStreamTracer) streamTracer).inboundHeaders();
        }
    }

    public void clientInboundTrailers(Metadata metadata) {
        for (StreamTracer streamTracer : this.tracers) {
            ((ClientStreamTracer) streamTracer).inboundTrailers(metadata);
        }
    }

    public void clientOutboundHeaders() {
        for (StreamTracer streamTracer : this.tracers) {
            ((ClientStreamTracer) streamTracer).outboundHeaders();
        }
    }

    public List<StreamTracer> getTracersForTest() {
        return new ArrayList(Arrays.asList(this.tracers));
    }

    public void inboundMessage(int i10) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundMessage(i10);
        }
    }

    public void inboundMessageRead(int i10, long j10, long j11) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundMessageRead(i10, j10, j11);
        }
    }

    public void inboundUncompressedSize(long j10) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundUncompressedSize(j10);
        }
    }

    public void inboundWireSize(long j10) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.inboundWireSize(j10);
        }
    }

    public void outboundMessage(int i10) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundMessage(i10);
        }
    }

    public void outboundMessageSent(int i10, long j10, long j11) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundMessageSent(i10, j10, j11);
        }
    }

    public void outboundUncompressedSize(long j10) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundUncompressedSize(j10);
        }
    }

    public void outboundWireSize(long j10) {
        for (StreamTracer streamTracer : this.tracers) {
            streamTracer.outboundWireSize(j10);
        }
    }

    public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> serverCallInfo) {
        for (StreamTracer streamTracer : this.tracers) {
            ((ServerStreamTracer) streamTracer).serverCallStarted(serverCallInfo);
        }
    }

    public <ReqT, RespT> Context serverFilterContext(Context context) {
        Context context2 = (Context) o.s(context, "context");
        for (StreamTracer streamTracer : this.tracers) {
            context2 = ((ServerStreamTracer) streamTracer).filterContext(context2);
            o.t(context2, "%s returns null context", streamTracer);
        }
        return context2;
    }

    public void streamClosed(Status status) {
        if (this.closed.compareAndSet(false, true)) {
            for (StreamTracer streamTracer : this.tracers) {
                streamTracer.streamClosed(status);
            }
        }
    }
}
