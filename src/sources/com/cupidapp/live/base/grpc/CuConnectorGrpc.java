package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.google.protobuf.Descriptors;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.ProtoFileDescriptorSupplier;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import io.grpc.protobuf.ProtoServiceDescriptorSupplier;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractFutureStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.RpcMethod;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CuConnectorGrpc {
    private static final int METHODID_COMMUNICATE = 0;
    public static final String SERVICE_NAME = "connector.CuConnector";
    private static volatile MethodDescriptor<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> getCommunicateMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class CuConnectorBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return CuConnectorOuterClass.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("CuConnector");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class CuConnectorBlockingStub extends AbstractBlockingStub<CuConnectorBlockingStub> {
        private CuConnectorBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CuConnectorBlockingStub build(Channel channel, CallOptions callOptions) {
            return new CuConnectorBlockingStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class CuConnectorFileDescriptorSupplier extends CuConnectorBaseDescriptorSupplier {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class CuConnectorFutureStub extends AbstractFutureStub<CuConnectorFutureStub> {
        private CuConnectorFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public CuConnectorFutureStub build(Channel channel, CallOptions callOptions) {
            return new CuConnectorFutureStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class CuConnectorImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(CuConnectorGrpc.getServiceDescriptor()).addMethod(CuConnectorGrpc.getCommunicateMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 0))).build();
        }

        public StreamObserver<CuConnectorOuterClass.ConnectorMessage> communicate(StreamObserver<CuConnectorOuterClass.ConnectorMessage> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(CuConnectorGrpc.getCommunicateMethod(), streamObserver);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class CuConnectorMethodDescriptorSupplier extends CuConnectorBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        public CuConnectorMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class CuConnectorStub extends AbstractAsyncStub<CuConnectorStub> {
        private CuConnectorStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        public StreamObserver<CuConnectorOuterClass.ConnectorMessage> communicate(StreamObserver<CuConnectorOuterClass.ConnectorMessage> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(CuConnectorGrpc.getCommunicateMethod(), getCallOptions()), streamObserver);
        }

        @Override // io.grpc.stub.AbstractStub
        public CuConnectorStub build(Channel channel, CallOptions callOptions) {
            return new CuConnectorStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final CuConnectorImplBase serviceImpl;

        public MethodHandlers(CuConnectorImplBase cuConnectorImplBase, int i10) {
            this.serviceImpl = cuConnectorImplBase;
            this.methodId = i10;
        }

        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            if (this.methodId == 0) {
                return (StreamObserver<Req>) this.serviceImpl.communicate(streamObserver);
            }
            throw new AssertionError();
        }
    }

    private CuConnectorGrpc() {
    }

    @RpcMethod(fullMethodName = "connector.CuConnector/communicate", methodType = MethodDescriptor.MethodType.BIDI_STREAMING, requestType = CuConnectorOuterClass.ConnectorMessage.class, responseType = CuConnectorOuterClass.ConnectorMessage.class)
    public static MethodDescriptor<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> getCommunicateMethod() {
        MethodDescriptor<CuConnectorOuterClass.ConnectorMessage, CuConnectorOuterClass.ConnectorMessage> methodDescriptor = getCommunicateMethod;
        if (methodDescriptor == null) {
            synchronized (CuConnectorGrpc.class) {
                methodDescriptor = getCommunicateMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "communicate")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(CuConnectorOuterClass.ConnectorMessage.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(CuConnectorOuterClass.ConnectorMessage.getDefaultInstance())).setSchemaDescriptor(new CuConnectorMethodDescriptorSupplier("communicate")).build();
                    getCommunicateMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 == null) {
            synchronized (CuConnectorGrpc.class) {
                serviceDescriptor2 = serviceDescriptor;
                if (serviceDescriptor2 == null) {
                    serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new CuConnectorFileDescriptorSupplier()).addMethod(getCommunicateMethod()).build();
                    serviceDescriptor = serviceDescriptor2;
                }
            }
        }
        return serviceDescriptor2;
    }

    public static CuConnectorBlockingStub newBlockingStub(Channel channel) {
        return (CuConnectorBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<CuConnectorBlockingStub>() { // from class: com.cupidapp.live.base.grpc.CuConnectorGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CuConnectorBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new CuConnectorBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static CuConnectorFutureStub newFutureStub(Channel channel) {
        return (CuConnectorFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<CuConnectorFutureStub>() { // from class: com.cupidapp.live.base.grpc.CuConnectorGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CuConnectorFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new CuConnectorFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static CuConnectorStub newStub(Channel channel) {
        return (CuConnectorStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<CuConnectorStub>() { // from class: com.cupidapp.live.base.grpc.CuConnectorGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public CuConnectorStub newStub(Channel channel2, CallOptions callOptions) {
                return new CuConnectorStub(channel2, callOptions);
            }
        }, channel);
    }
}
