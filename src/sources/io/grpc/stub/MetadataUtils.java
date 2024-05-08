package io.grpc.stub;

import com.google.common.base.o;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MetadataUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class HeaderAttachingClientInterceptor implements ClientInterceptor {
        private final Metadata extraHeaders;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class HeaderAttachingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
            public HeaderAttachingClientCall(ClientCall<ReqT, RespT> clientCall) {
                super(clientCall);
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                metadata.merge(HeaderAttachingClientInterceptor.this.extraHeaders);
                super.start(listener, metadata);
            }
        }

        public HeaderAttachingClientInterceptor(Metadata metadata) {
            this.extraHeaders = (Metadata) o.s(metadata, "extraHeaders");
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new HeaderAttachingClientCall(channel.newCall(methodDescriptor, callOptions));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MetadataCapturingClientInterceptor implements ClientInterceptor {
        public final AtomicReference<Metadata> headersCapture;
        public final AtomicReference<Metadata> trailersCapture;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class MetadataCapturingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public final class MetadataCapturingClientCallListener extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {
                public MetadataCapturingClientCallListener(ClientCall.Listener<RespT> listener) {
                    super(listener);
                }

                @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                public void onClose(Status status, Metadata metadata) {
                    MetadataCapturingClientInterceptor.this.trailersCapture.set(metadata);
                    super.onClose(status, metadata);
                }

                @Override // io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener, io.grpc.ForwardingClientCallListener, io.grpc.PartialForwardingClientCallListener, io.grpc.ClientCall.Listener
                public void onHeaders(Metadata metadata) {
                    MetadataCapturingClientInterceptor.this.headersCapture.set(metadata);
                    super.onHeaders(metadata);
                }
            }

            public MetadataCapturingClientCall(ClientCall<ReqT, RespT> clientCall) {
                super(clientCall);
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                MetadataCapturingClientInterceptor.this.headersCapture.set(null);
                MetadataCapturingClientInterceptor.this.trailersCapture.set(null);
                super.start(new MetadataCapturingClientCallListener(listener), metadata);
            }
        }

        public MetadataCapturingClientInterceptor(AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
            this.headersCapture = (AtomicReference) o.s(atomicReference, "headersCapture");
            this.trailersCapture = (AtomicReference) o.s(atomicReference2, "trailersCapture");
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new MetadataCapturingClientCall(channel.newCall(methodDescriptor, callOptions));
        }
    }

    private MetadataUtils() {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
    @Deprecated
    public static <T extends AbstractStub<T>> T attachHeaders(T t2, Metadata metadata) {
        return (T) t2.withInterceptors(newAttachHeadersInterceptor(metadata));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1789")
    @Deprecated
    public static <T extends AbstractStub<T>> T captureMetadata(T t2, AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return (T) t2.withInterceptors(newCaptureMetadataInterceptor(atomicReference, atomicReference2));
    }

    public static ClientInterceptor newAttachHeadersInterceptor(Metadata metadata) {
        return new HeaderAttachingClientInterceptor(metadata);
    }

    public static ClientInterceptor newCaptureMetadataInterceptor(AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return new MetadataCapturingClientInterceptor(atomicReference, atomicReference2);
    }
}
