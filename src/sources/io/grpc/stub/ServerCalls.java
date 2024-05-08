package io.grpc.stub;

import com.google.common.base.o;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServerCalls {
    public static final String MISSING_REQUEST = "Half-closed without a request";
    public static final String TOO_MANY_REQUESTS = "Too many requests";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface BidiStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ClientStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class NoopStreamObserver<V> implements StreamObserver<V> {
        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(V v2) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerCallStreamObserverImpl<ReqT, RespT> extends ServerCallStreamObserver<RespT> {
        public final ServerCall<ReqT, RespT> call;
        public volatile boolean cancelled;
        private boolean frozen;
        private Runnable onCancelHandler;
        private Runnable onCloseHandler;
        private Runnable onReadyHandler;
        private boolean sentHeaders;
        private final boolean serverStreamingOrBidi;
        private boolean autoRequestEnabled = true;
        private boolean aborted = false;
        private boolean completed = false;

        public ServerCallStreamObserverImpl(ServerCall<ReqT, RespT> serverCall, boolean z10) {
            this.call = serverCall;
            this.serverStreamingOrBidi = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void disableAutoInboundFlowControl() {
            disableAutoRequest();
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void disableAutoRequest() {
            o.y(!this.frozen, "Cannot disable auto flow control after initialization");
            this.autoRequestEnabled = false;
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public boolean isCancelled() {
            return this.call.isCancelled();
        }

        @Override // io.grpc.stub.ServerCallStreamObserver, io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            this.call.close(Status.OK, new Metadata());
            this.completed = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
            Metadata trailersFromThrowable = Status.trailersFromThrowable(th);
            if (trailersFromThrowable == null) {
                trailersFromThrowable = new Metadata();
            }
            this.call.close(Status.fromThrowable(th), trailersFromThrowable);
            this.aborted = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(RespT respt) {
            if (this.cancelled && this.serverStreamingOrBidi) {
                throw Status.CANCELLED.withDescription("call already cancelled. Use ServerCallStreamObserver.setOnCancelHandler() to disable this exception").asRuntimeException();
            }
            o.y(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            o.y(!this.completed, "Stream is already completed, no further calls are allowed");
            if (!this.sentHeaders) {
                this.call.sendHeaders(new Metadata());
                this.sentHeaders = true;
            }
            this.call.sendMessage(respt);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver, io.grpc.stub.CallStreamObserver
        public void request(int i10) {
            this.call.request(i10);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setCompression(String str) {
            this.call.setCompression(str);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver, io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean z10) {
            this.call.setMessageCompression(z10);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setOnCancelHandler(Runnable runnable) {
            o.y(!this.frozen, "Cannot alter onCancelHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.onCancelHandler = runnable;
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setOnCloseHandler(Runnable runnable) {
            o.y(!this.frozen, "Cannot alter onCloseHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.onCloseHandler = runnable;
        }

        @Override // io.grpc.stub.ServerCallStreamObserver, io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable runnable) {
            o.y(!this.frozen, "Cannot alter onReadyHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.onReadyHandler = runnable;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ServerStreamingMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface StreamingRequestMethod<ReqT, RespT> {
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StreamingServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final boolean bidi;
        private final StreamingRequestMethod<ReqT, RespT> method;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class StreamingServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean halfClosed = false;
            private final StreamObserver<ReqT> requestObserver;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;

            public StreamingServerCallListener(StreamObserver<ReqT> streamObserver, ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl, ServerCall<ReqT, RespT> serverCall) {
                this.requestObserver = streamObserver;
                this.responseObserver = serverCallStreamObserverImpl;
                this.call = serverCall;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                } else {
                    this.responseObserver.cancelled = true;
                }
                if (this.halfClosed) {
                    return;
                }
                this.requestObserver.onError(Status.CANCELLED.withDescription("client cancelled").asRuntimeException());
            }

            @Override // io.grpc.ServerCall.Listener
            public void onComplete() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCloseHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCloseHandler.run();
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                this.halfClosed = true;
                this.requestObserver.onCompleted();
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                this.requestObserver.onNext(reqt);
                if (((ServerCallStreamObserverImpl) this.responseObserver).autoRequestEnabled) {
                    this.call.request(1);
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
                }
            }
        }

        public StreamingServerCallHandler(StreamingRequestMethod<ReqT, RespT> streamingRequestMethod, boolean z10) {
            this.method = streamingRequestMethod;
            this.bidi = z10;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall, this.bidi);
            StreamObserver<ReqT> invoke = this.method.invoke(serverCallStreamObserverImpl);
            serverCallStreamObserverImpl.freeze();
            if (serverCallStreamObserverImpl.autoRequestEnabled) {
                serverCall.request(1);
            }
            return new StreamingServerCallListener(invoke, serverCallStreamObserverImpl, serverCall);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface UnaryMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
        @Override // io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface UnaryRequestMethod<ReqT, RespT> {
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class UnaryServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final UnaryRequestMethod<ReqT, RespT> method;
        private final boolean serverStreaming;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class UnaryServerCallListener extends ServerCall.Listener<ReqT> {
            private final ServerCall<ReqT, RespT> call;
            private boolean canInvoke = true;
            private ReqT request;
            private final ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;
            private boolean wasReady;

            public UnaryServerCallListener(ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl, ServerCall<ReqT, RespT> serverCall) {
                this.call = serverCall;
                this.responseObserver = serverCallStreamObserverImpl;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onCancel() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCancelHandler.run();
                } else {
                    this.responseObserver.cancelled = true;
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onComplete() {
                if (((ServerCallStreamObserverImpl) this.responseObserver).onCloseHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onCloseHandler.run();
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onHalfClose() {
                if (this.canInvoke) {
                    if (this.request == null) {
                        this.call.close(Status.INTERNAL.withDescription(ServerCalls.MISSING_REQUEST), new Metadata());
                        return;
                    }
                    UnaryServerCallHandler.this.method.invoke(this.request, this.responseObserver);
                    this.request = null;
                    this.responseObserver.freeze();
                    if (this.wasReady) {
                        onReady();
                    }
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                if (this.request != null) {
                    this.call.close(Status.INTERNAL.withDescription(ServerCalls.TOO_MANY_REQUESTS), new Metadata());
                    this.canInvoke = false;
                } else {
                    this.request = reqt;
                }
            }

            @Override // io.grpc.ServerCall.Listener
            public void onReady() {
                this.wasReady = true;
                if (((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler != null) {
                    ((ServerCallStreamObserverImpl) this.responseObserver).onReadyHandler.run();
                }
            }
        }

        public UnaryServerCallHandler(UnaryRequestMethod<ReqT, RespT> unaryRequestMethod, boolean z10) {
            this.method = unaryRequestMethod;
            this.serverStreaming = z10;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            o.e(serverCall.getMethodDescriptor().getType().clientSendsOneMessage(), "asyncUnaryRequestCall is only for clientSendsOneMessage methods");
            ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall, this.serverStreaming);
            serverCall.request(2);
            return new UnaryServerCallListener(serverCallStreamObserverImpl, serverCall);
        }
    }

    private ServerCalls() {
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncBidiStreamingCall(BidiStreamingMethod<ReqT, RespT> bidiStreamingMethod) {
        return new StreamingServerCallHandler(bidiStreamingMethod, true);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncClientStreamingCall(ClientStreamingMethod<ReqT, RespT> clientStreamingMethod) {
        return new StreamingServerCallHandler(clientStreamingMethod, false);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncServerStreamingCall(ServerStreamingMethod<ReqT, RespT> serverStreamingMethod) {
        return new UnaryServerCallHandler(serverStreamingMethod, true);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryCall(UnaryMethod<ReqT, RespT> unaryMethod) {
        return new UnaryServerCallHandler(unaryMethod, false);
    }

    public static <ReqT> StreamObserver<ReqT> asyncUnimplementedStreamingCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        asyncUnimplementedUnaryCall(methodDescriptor, streamObserver);
        return new NoopStreamObserver();
    }

    public static void asyncUnimplementedUnaryCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        o.s(methodDescriptor, "methodDescriptor");
        o.s(streamObserver, "responseObserver");
        streamObserver.onError(Status.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented", methodDescriptor.getFullMethodName())).asRuntimeException());
    }
}
