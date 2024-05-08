package io.grpc.util;

import com.google.common.util.concurrent.p;
import com.google.common.util.concurrent.t;
import io.grpc.Attributes;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.SerializingExecutor;
import java.util.concurrent.ExecutionException;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2189")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TransmitStatusRuntimeExceptionInterceptor implements ServerInterceptor {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SerializingServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT> {
        private static final String ERROR_MSG = "Encountered error during serialized access";
        private boolean closeCalled;
        private final SerializingExecutor serializingExecutor;

        public SerializingServerCall(ServerCall<ReqT, RespT> serverCall) {
            super(serverCall);
            this.serializingExecutor = new SerializingExecutor(p.a());
            this.closeCalled = false;
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void close(final Status status, final Metadata metadata) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.4
                @Override // java.lang.Runnable
                public void run() {
                    if (SerializingServerCall.this.closeCalled) {
                        return;
                    }
                    SerializingServerCall.this.closeCalled = true;
                    SerializingServerCall.super.close(status, metadata);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public Attributes getAttributes() {
            final t a10 = t.a();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.9
                @Override // java.lang.Runnable
                public void run() {
                    a10.set(SerializingServerCall.super.getAttributes());
                }
            });
            try {
                return (Attributes) a10.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e10) {
                throw new RuntimeException(ERROR_MSG, e10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public String getAuthority() {
            final t a10 = t.a();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.10
                @Override // java.lang.Runnable
                public void run() {
                    a10.set(SerializingServerCall.super.getAuthority());
                }
            });
            try {
                return (String) a10.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e10) {
                throw new RuntimeException(ERROR_MSG, e10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isCancelled() {
            final t a10 = t.a();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.6
                @Override // java.lang.Runnable
                public void run() {
                    a10.set(Boolean.valueOf(SerializingServerCall.super.isCancelled()));
                }
            });
            try {
                return ((Boolean) a10.get()).booleanValue();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e10) {
                throw new RuntimeException(ERROR_MSG, e10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public boolean isReady() {
            final t a10 = t.a();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.5
                @Override // java.lang.Runnable
                public void run() {
                    a10.set(Boolean.valueOf(SerializingServerCall.super.isReady()));
                }
            });
            try {
                return ((Boolean) a10.get()).booleanValue();
            } catch (InterruptedException e2) {
                throw new RuntimeException(ERROR_MSG, e2);
            } catch (ExecutionException e10) {
                throw new RuntimeException(ERROR_MSG, e10);
            }
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void request(final int i10) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.2
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.request(i10);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void sendHeaders(final Metadata metadata) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.3
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.sendHeaders(metadata);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall, io.grpc.ServerCall
        public void sendMessage(final RespT respt) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.1
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.sendMessage(respt);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void setCompression(final String str) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.8
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.setCompression(str);
                }
            });
        }

        @Override // io.grpc.ForwardingServerCall.SimpleForwardingServerCall, io.grpc.ForwardingServerCall, io.grpc.PartialForwardingServerCall, io.grpc.ServerCall
        public void setMessageCompression(final boolean z10) {
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.7
                @Override // java.lang.Runnable
                public void run() {
                    SerializingServerCall.super.setMessageCompression(z10);
                }
            });
        }
    }

    private TransmitStatusRuntimeExceptionInterceptor() {
    }

    public static ServerInterceptor instance() {
        return new TransmitStatusRuntimeExceptionInterceptor();
    }

    @Override // io.grpc.ServerInterceptor
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        final SerializingServerCall serializingServerCall = new SerializingServerCall(serverCall);
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(serverCallHandler.startCall(serializingServerCall, metadata)) { // from class: io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.1
            private void closeWithException(StatusRuntimeException statusRuntimeException) {
                Metadata trailers = statusRuntimeException.getTrailers();
                if (trailers == null) {
                    trailers = new Metadata();
                }
                serializingServerCall.close(statusRuntimeException.getStatus(), trailers);
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onCancel() {
                try {
                    super.onCancel();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onComplete() {
                try {
                    super.onComplete();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onHalfClose() {
                try {
                    super.onHalfClose();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onMessage(ReqT reqt) {
                try {
                    super.onMessage(reqt);
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }

            @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
            public void onReady() {
                try {
                    super.onReady();
                } catch (StatusRuntimeException e2) {
                    closeWithException(e2);
                }
            }
        };
    }
}
