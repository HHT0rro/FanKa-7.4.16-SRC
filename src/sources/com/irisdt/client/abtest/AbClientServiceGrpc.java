package com.irisdt.client.abtest;

import com.google.common.util.concurrent.n;
import com.google.protobuf.Descriptors;
import com.irisdt.client.abtest.AbClientProtos;
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
import io.grpc.stub.annotations.GrpcGenerated;
import io.grpc.stub.annotations.RpcMethod;

@GrpcGenerated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class AbClientServiceGrpc {
    private static final int METHODID_GET_AB_RESULT = 0;
    public static final String SERVICE_NAME = "com.irisdt.client.abtest.AbClientService";
    private static volatile MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> getGetAbResultMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class AbClientServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return AbClientProtos.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("AbClientService");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AbClientServiceBlockingStub extends AbstractBlockingStub<AbClientServiceBlockingStub> {
        public AbClientProtos.Response getAbResult(AbClientProtos.Request request) {
            return (AbClientProtos.Response) ClientCalls.blockingUnaryCall(getChannel(), AbClientServiceGrpc.getGetAbResultMethod(), getCallOptions(), request);
        }

        private AbClientServiceBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public AbClientServiceBlockingStub build(Channel channel, CallOptions callOptions) {
            return new AbClientServiceBlockingStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AbClientServiceFileDescriptorSupplier extends AbClientServiceBaseDescriptorSupplier {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AbClientServiceFutureStub extends AbstractFutureStub<AbClientServiceFutureStub> {
        public n<AbClientProtos.Response> getAbResult(AbClientProtos.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(AbClientServiceGrpc.getGetAbResultMethod(), getCallOptions()), request);
        }

        private AbClientServiceFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public AbClientServiceFutureStub build(Channel channel, CallOptions callOptions) {
            return new AbClientServiceFutureStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class AbClientServiceImplBase implements BindableService, AsyncService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return AbClientServiceGrpc.bindService(this);
        }

        @Override // com.irisdt.client.abtest.AbClientServiceGrpc.AsyncService
        public /* synthetic */ void getAbResult(AbClientProtos.Request request, StreamObserver streamObserver) {
            a.a(this, request, streamObserver);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AbClientServiceMethodDescriptorSupplier extends AbClientServiceBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        public AbClientServiceMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class AbClientServiceStub extends AbstractAsyncStub<AbClientServiceStub> {
        public void getAbResult(AbClientProtos.Request request, StreamObserver<AbClientProtos.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(AbClientServiceGrpc.getGetAbResultMethod(), getCallOptions()), request, streamObserver);
        }

        private AbClientServiceStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public AbClientServiceStub build(Channel channel, CallOptions callOptions) {
            return new AbClientServiceStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AsyncService {
        void getAbResult(AbClientProtos.Request request, StreamObserver<AbClientProtos.Response> streamObserver);
    }

    private AbClientServiceGrpc() {
    }

    public static final ServerServiceDefinition bindService(AsyncService asyncService) {
        return ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getGetAbResultMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(asyncService, 0))).build();
    }

    @RpcMethod(fullMethodName = "com.irisdt.client.abtest.AbClientService/getAbResult", methodType = MethodDescriptor.MethodType.UNARY, requestType = AbClientProtos.Request.class, responseType = AbClientProtos.Response.class)
    public static MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> getGetAbResultMethod() {
        MethodDescriptor<AbClientProtos.Request, AbClientProtos.Response> methodDescriptor = getGetAbResultMethod;
        if (methodDescriptor == null) {
            synchronized (AbClientServiceGrpc.class) {
                methodDescriptor = getGetAbResultMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "getAbResult")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(AbClientProtos.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(AbClientProtos.Response.getDefaultInstance())).setSchemaDescriptor(new AbClientServiceMethodDescriptorSupplier("getAbResult")).build();
                    getGetAbResultMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 == null) {
            synchronized (AbClientServiceGrpc.class) {
                serviceDescriptor2 = serviceDescriptor;
                if (serviceDescriptor2 == null) {
                    serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new AbClientServiceFileDescriptorSupplier()).addMethod(getGetAbResultMethod()).build();
                    serviceDescriptor = serviceDescriptor2;
                }
            }
        }
        return serviceDescriptor2;
    }

    public static AbClientServiceBlockingStub newBlockingStub(Channel channel) {
        return (AbClientServiceBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<AbClientServiceBlockingStub>() { // from class: com.irisdt.client.abtest.AbClientServiceGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public AbClientServiceBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new AbClientServiceBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static AbClientServiceFutureStub newFutureStub(Channel channel) {
        return (AbClientServiceFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<AbClientServiceFutureStub>() { // from class: com.irisdt.client.abtest.AbClientServiceGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public AbClientServiceFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new AbClientServiceFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static AbClientServiceStub newStub(Channel channel) {
        return (AbClientServiceStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<AbClientServiceStub>() { // from class: com.irisdt.client.abtest.AbClientServiceGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public AbClientServiceStub newStub(Channel channel2, CallOptions callOptions) {
                return new AbClientServiceStub(channel2, callOptions);
            }
        }, channel);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final AsyncService serviceImpl;

        public MethodHandlers(AsyncService asyncService, int i10) {
            this.serviceImpl = asyncService;
            this.methodId = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId == 0) {
                this.serviceImpl.getAbResult((AbClientProtos.Request) req, streamObserver);
                return;
            }
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }
}
