package io.grpc.internal;

import com.google.common.base.o;
import com.google.common.base.u;
import com.google.common.util.concurrent.p;
import io.grpc.Attributes;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.ServerCall;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.StreamListener;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServerCallImpl<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    public static final String MISSING_RESPONSE = "Completed without a response";
    public static final String TOO_MANY_RESPONSES = "Too many responses";
    private static final Logger log = Logger.getLogger(ServerCallImpl.class.getName());
    private volatile boolean cancelled;
    private boolean closeCalled;
    private Compressor compressor;
    private final CompressorRegistry compressorRegistry;
    private final Context.CancellableContext context;
    private final DecompressorRegistry decompressorRegistry;
    private final byte[] messageAcceptEncoding;
    private boolean messageSent;
    private final MethodDescriptor<ReqT, RespT> method;
    private boolean sendHeadersCalled;
    private CallTracer serverCallTracer;
    private final ServerStream stream;
    private final Tag tag;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerStreamListenerImpl<ReqT> implements ServerStreamListener {
        private final ServerCallImpl<ReqT, ?> call;
        private final Context.CancellableContext context;
        private final ServerCall.Listener<ReqT> listener;

        public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> serverCallImpl, ServerCall.Listener<ReqT> listener, Context.CancellableContext cancellableContext) {
            this.call = (ServerCallImpl) o.s(serverCallImpl, "call");
            this.listener = (ServerCall.Listener) o.s(listener, "listener must not be null");
            Context.CancellableContext cancellableContext2 = (Context.CancellableContext) o.s(cancellableContext, "context");
            this.context = cancellableContext2;
            cancellableContext2.addListener(new Context.CancellationListener() { // from class: io.grpc.internal.ServerCallImpl.ServerStreamListenerImpl.1
                @Override // io.grpc.Context.CancellationListener
                public void cancelled(Context context) {
                    if (context.cancellationCause() != null) {
                        ServerStreamListenerImpl.this.call.cancelled = true;
                    }
                }
            }, p.a());
        }

        private void closedInternal(Status status) {
            StatusRuntimeException statusRuntimeException = null;
            try {
                if (status.isOk()) {
                    this.listener.onComplete();
                } else {
                    ((ServerCallImpl) this.call).cancelled = true;
                    this.listener.onCancel();
                    statusRuntimeException = InternalStatus.asRuntimeException(Status.CANCELLED.withDescription("RPC cancelled"), null, false);
                }
            } finally {
                this.context.cancel(null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void messagesAvailableInternal(StreamListener.MessageProducer messageProducer) {
            if (((ServerCallImpl) this.call).cancelled) {
                GrpcUtil.closeQuietly(messageProducer);
                return;
            }
            while (true) {
                try {
                    InputStream next = messageProducer.next();
                    if (next == null) {
                        return;
                    }
                    try {
                        this.listener.onMessage(((ServerCallImpl) this.call).method.parseRequest(next));
                        next.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    GrpcUtil.closeQuietly(messageProducer);
                    u.f(th);
                    throw new RuntimeException(th);
                }
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
            PerfMark.startTask("ServerStreamListener.closed", ((ServerCallImpl) this.call).tag);
            try {
                closedInternal(status);
            } finally {
                PerfMark.stopTask("ServerStreamListener.closed", ((ServerCallImpl) this.call).tag);
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            PerfMark.startTask("ServerStreamListener.halfClosed", ((ServerCallImpl) this.call).tag);
            try {
                if (((ServerCallImpl) this.call).cancelled) {
                    return;
                }
                this.listener.onHalfClose();
            } finally {
                PerfMark.stopTask("ServerStreamListener.halfClosed", ((ServerCallImpl) this.call).tag);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            PerfMark.startTask("ServerStreamListener.messagesAvailable", ((ServerCallImpl) this.call).tag);
            try {
                messagesAvailableInternal(messageProducer);
            } finally {
                PerfMark.stopTask("ServerStreamListener.messagesAvailable", ((ServerCallImpl) this.call).tag);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            PerfMark.startTask("ServerStreamListener.onReady", ((ServerCallImpl) this.call).tag);
            try {
                if (((ServerCallImpl) this.call).cancelled) {
                    return;
                }
                this.listener.onReady();
            } finally {
                PerfMark.stopTask("ServerCall.closed", ((ServerCallImpl) this.call).tag);
            }
        }
    }

    public ServerCallImpl(ServerStream serverStream, MethodDescriptor<ReqT, RespT> methodDescriptor, Metadata metadata, Context.CancellableContext cancellableContext, DecompressorRegistry decompressorRegistry, CompressorRegistry compressorRegistry, CallTracer callTracer, Tag tag) {
        this.stream = serverStream;
        this.method = methodDescriptor;
        this.context = cancellableContext;
        this.messageAcceptEncoding = (byte[]) metadata.get(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        this.decompressorRegistry = decompressorRegistry;
        this.compressorRegistry = compressorRegistry;
        this.serverCallTracer = callTracer;
        callTracer.reportCallStarted();
        this.tag = tag;
    }

    private void closeInternal(Status status, Metadata metadata) {
        o.y(!this.closeCalled, "call already closed");
        try {
            this.closeCalled = true;
            if (status.isOk() && this.method.getType().serverSendsOneMessage() && !this.messageSent) {
                internalClose(Status.INTERNAL.withDescription(MISSING_RESPONSE));
            } else {
                this.stream.close(status, metadata);
            }
        } finally {
            this.serverCallTracer.reportCallEnded(status.isOk());
        }
    }

    private void internalClose(Status status) {
        log.log(Level.WARNING, "Cancelling the stream with status {0}", new Object[]{status});
        this.stream.cancel(status);
        this.serverCallTracer.reportCallEnded(status.isOk());
    }

    private void sendHeadersInternal(Metadata metadata) {
        o.y(!this.sendHeadersCalled, "sendHeaders has already been called");
        o.y(!this.closeCalled, "call is closed");
        metadata.discardAll(GrpcUtil.CONTENT_LENGTH_KEY);
        Metadata.Key<String> key = GrpcUtil.MESSAGE_ENCODING_KEY;
        metadata.discardAll(key);
        if (this.compressor == null) {
            this.compressor = Codec.Identity.NONE;
        } else {
            byte[] bArr = this.messageAcceptEncoding;
            if (bArr != null) {
                if (!GrpcUtil.iterableContains(GrpcUtil.ACCEPT_ENCODING_SPLITTER.g(new String(bArr, GrpcUtil.US_ASCII)), this.compressor.getMessageEncoding())) {
                    this.compressor = Codec.Identity.NONE;
                }
            } else {
                this.compressor = Codec.Identity.NONE;
            }
        }
        metadata.put(key, this.compressor.getMessageEncoding());
        this.stream.setCompressor(this.compressor);
        Metadata.Key<byte[]> key2 = GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY;
        metadata.discardAll(key2);
        byte[] rawAdvertisedMessageEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(this.decompressorRegistry);
        if (rawAdvertisedMessageEncodings.length != 0) {
            metadata.put(key2, rawAdvertisedMessageEncodings);
        }
        this.sendHeadersCalled = true;
        this.stream.writeHeaders(metadata);
    }

    private void sendMessageInternal(RespT respt) {
        o.y(this.sendHeadersCalled, "sendHeaders has not been called");
        o.y(!this.closeCalled, "call is closed");
        if (this.method.getType().serverSendsOneMessage() && this.messageSent) {
            internalClose(Status.INTERNAL.withDescription(TOO_MANY_RESPONSES));
            return;
        }
        this.messageSent = true;
        try {
            this.stream.writeMessage(this.method.streamResponse(respt));
            if (getMethodDescriptor().getType().serverSendsOneMessage()) {
                return;
            }
            this.stream.flush();
        } catch (Error e2) {
            close(Status.CANCELLED.withDescription("Server sendMessage() failed with Error"), new Metadata());
            throw e2;
        } catch (RuntimeException e10) {
            close(Status.fromThrowable(e10), new Metadata());
        }
    }

    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata metadata) {
        PerfMark.startTask("ServerCall.close", this.tag);
        try {
            closeInternal(status, metadata);
        } finally {
            PerfMark.stopTask("ServerCall.close", this.tag);
        }
    }

    @Override // io.grpc.ServerCall
    public Attributes getAttributes() {
        return this.stream.getAttributes();
    }

    @Override // io.grpc.ServerCall
    public String getAuthority() {
        return this.stream.getAuthority();
    }

    @Override // io.grpc.ServerCall
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.method;
    }

    @Override // io.grpc.ServerCall
    public SecurityLevel getSecurityLevel() {
        Attributes attributes = getAttributes();
        if (attributes == null) {
            return super.getSecurityLevel();
        }
        SecurityLevel securityLevel = (SecurityLevel) attributes.get(GrpcAttributes.ATTR_SECURITY_LEVEL);
        return securityLevel == null ? super.getSecurityLevel() : securityLevel;
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        if (this.closeCalled) {
            return false;
        }
        return this.stream.isReady();
    }

    public ServerStreamListener newServerStreamListener(ServerCall.Listener<ReqT> listener) {
        return new ServerStreamListenerImpl(this, listener, this.context);
    }

    @Override // io.grpc.ServerCall
    public void request(int i10) {
        PerfMark.startTask("ServerCall.request", this.tag);
        try {
            this.stream.request(i10);
        } finally {
            PerfMark.stopTask("ServerCall.request", this.tag);
        }
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata metadata) {
        PerfMark.startTask("ServerCall.sendHeaders", this.tag);
        try {
            sendHeadersInternal(metadata);
        } finally {
            PerfMark.stopTask("ServerCall.sendHeaders", this.tag);
        }
    }

    @Override // io.grpc.ServerCall
    public void sendMessage(RespT respt) {
        PerfMark.startTask("ServerCall.sendMessage", this.tag);
        try {
            sendMessageInternal(respt);
        } finally {
            PerfMark.stopTask("ServerCall.sendMessage", this.tag);
        }
    }

    @Override // io.grpc.ServerCall
    public void setCompression(String str) {
        o.y(!this.sendHeadersCalled, "sendHeaders has been called");
        Compressor lookupCompressor = this.compressorRegistry.lookupCompressor(str);
        this.compressor = lookupCompressor;
        o.m(lookupCompressor != null, "Unable to find compressor by name %s", str);
    }

    @Override // io.grpc.ServerCall
    public void setMessageCompression(boolean z10) {
        this.stream.setMessageCompression(z10);
    }
}
