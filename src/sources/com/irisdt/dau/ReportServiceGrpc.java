package com.irisdt.dau;

import com.google.common.util.concurrent.n;
import com.google.protobuf.Descriptors;
import com.irisdt.dau.DayActiveUserProtos;
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
public final class ReportServiceGrpc {
    private static final int METHODID_REPORT = 0;
    public static final String SERVICE_NAME = "com.irisdt.dau.ReportService";
    private static volatile MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> getReportMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AsyncService {
        void report(DayActiveUserProtos.Request request, StreamObserver<DayActiveUserProtos.Response> streamObserver);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class ReportServiceBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return DayActiveUserProtos.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ReportService");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ReportServiceBlockingStub extends AbstractBlockingStub<ReportServiceBlockingStub> {
        public DayActiveUserProtos.Response report(DayActiveUserProtos.Request request) {
            return (DayActiveUserProtos.Response) ClientCalls.blockingUnaryCall(getChannel(), ReportServiceGrpc.getReportMethod(), getCallOptions(), request);
        }

        private ReportServiceBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ReportServiceBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceBlockingStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ReportServiceFileDescriptorSupplier extends ReportServiceBaseDescriptorSupplier {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ReportServiceFutureStub extends AbstractFutureStub<ReportServiceFutureStub> {
        public n<DayActiveUserProtos.Response> report(DayActiveUserProtos.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(ReportServiceGrpc.getReportMethod(), getCallOptions()), request);
        }

        private ReportServiceFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ReportServiceFutureStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceFutureStub(channel, callOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class ReportServiceImplBase implements BindableService, AsyncService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ReportServiceGrpc.bindService(this);
        }

        @Override // com.irisdt.dau.ReportServiceGrpc.AsyncService
        public /* synthetic */ void report(DayActiveUserProtos.Request request, StreamObserver streamObserver) {
            a.a(this, request, streamObserver);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ReportServiceMethodDescriptorSupplier extends ReportServiceBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        public ReportServiceMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ReportServiceStub extends AbstractAsyncStub<ReportServiceStub> {
        public void report(DayActiveUserProtos.Request request, StreamObserver<DayActiveUserProtos.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(ReportServiceGrpc.getReportMethod(), getCallOptions()), request, streamObserver);
        }

        private ReportServiceStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override // io.grpc.stub.AbstractStub
        public ReportServiceStub build(Channel channel, CallOptions callOptions) {
            return new ReportServiceStub(channel, callOptions);
        }
    }

    private ReportServiceGrpc() {
    }

    public static final ServerServiceDefinition bindService(AsyncService asyncService) {
        return ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getReportMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(asyncService, 0))).build();
    }

    @RpcMethod(fullMethodName = "com.irisdt.dau.ReportService/Report", methodType = MethodDescriptor.MethodType.UNARY, requestType = DayActiveUserProtos.Request.class, responseType = DayActiveUserProtos.Response.class)
    public static MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> getReportMethod() {
        MethodDescriptor<DayActiveUserProtos.Request, DayActiveUserProtos.Response> methodDescriptor = getReportMethod;
        if (methodDescriptor == null) {
            synchronized (ReportServiceGrpc.class) {
                methodDescriptor = getReportMethod;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Report")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(DayActiveUserProtos.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(DayActiveUserProtos.Response.getDefaultInstance())).setSchemaDescriptor(new ReportServiceMethodDescriptorSupplier("Report")).build();
                    getReportMethod = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 == null) {
            synchronized (ReportServiceGrpc.class) {
                serviceDescriptor2 = serviceDescriptor;
                if (serviceDescriptor2 == null) {
                    serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new ReportServiceFileDescriptorSupplier()).addMethod(getReportMethod()).build();
                    serviceDescriptor = serviceDescriptor2;
                }
            }
        }
        return serviceDescriptor2;
    }

    public static ReportServiceBlockingStub newBlockingStub(Channel channel) {
        return (ReportServiceBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<ReportServiceBlockingStub>() { // from class: com.irisdt.dau.ReportServiceGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceFutureStub newFutureStub(Channel channel) {
        return (ReportServiceFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<ReportServiceFutureStub>() { // from class: com.irisdt.dau.ReportServiceGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static ReportServiceStub newStub(Channel channel) {
        return (ReportServiceStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<ReportServiceStub>() { // from class: com.irisdt.dau.ReportServiceGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public ReportServiceStub newStub(Channel channel2, CallOptions callOptions) {
                return new ReportServiceStub(channel2, callOptions);
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
                this.serviceImpl.report((DayActiveUserProtos.Request) req, streamObserver);
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
