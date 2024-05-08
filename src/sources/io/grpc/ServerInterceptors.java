package io.grpc;

import com.google.common.base.o;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServerInterceptors {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final ServerCallHandler<ReqT, RespT> callHandler;
        private final ServerInterceptor interceptor;

        private InterceptCallHandler(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            this.interceptor = (ServerInterceptor) o.s(serverInterceptor, "interceptor");
            this.callHandler = serverCallHandler;
        }

        public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return new InterceptCallHandler<>(serverInterceptor, serverCallHandler);
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            return this.interceptor.interceptCall(serverCall, metadata, this.callHandler);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class KnownLengthBufferedInputStream extends BufferedInputStream implements KnownLength {
        public KnownLengthBufferedInputStream(InputStream inputStream) {
            super(inputStream);
        }
    }

    private ServerInterceptors() {
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return intercept(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
    public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition serverServiceDefinition) {
        return useMarshalledMessages(serverServiceDefinition, new MethodDescriptor.Marshaller<InputStream>() { // from class: io.grpc.ServerInterceptors.1
            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream stream(InputStream inputStream) {
                return inputStream;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream parse(InputStream inputStream) {
                if (inputStream.markSupported()) {
                    return inputStream;
                }
                if (inputStream instanceof KnownLength) {
                    return new KnownLengthBufferedInputStream(inputStream);
                }
                return new BufferedInputStream(inputStream);
            }
        });
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
    public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<T> marshaller) {
        return useMarshalledMessages(serverServiceDefinition, marshaller, marshaller);
    }

    private static <ReqT, RespT> void wrapAndAddMethod(ServerServiceDefinition.Builder builder, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, List<? extends ServerInterceptor> list) {
        ServerCallHandler<ReqT, RespT> serverCallHandler = serverMethodDefinition.getServerCallHandler();
        Iterator<? extends ServerInterceptor> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            serverCallHandler = InterceptCallHandler.create(iterator2.next(), serverCallHandler);
        }
        builder.addMethod(serverMethodDefinition.withServerCallHandler(serverCallHandler));
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> serverCallHandler, final MethodDescriptor<OReqT, ORespT> methodDescriptor, final MethodDescriptor<WReqT, WRespT> methodDescriptor2) {
        return new ServerCallHandler<WReqT, WRespT>() { // from class: io.grpc.ServerInterceptors.2
            @Override // io.grpc.ServerCallHandler
            public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> serverCall, Metadata metadata) {
                final ServerCall.Listener startCall = serverCallHandler.startCall(new PartialForwardingServerCall<OReqT, ORespT>() { // from class: io.grpc.ServerInterceptors.2.1
                    @Override // io.grpc.PartialForwardingServerCall
                    public ServerCall<WReqT, WRespT> delegate() {
                        return serverCall;
                    }

                    @Override // io.grpc.ServerCall
                    public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                        return MethodDescriptor.this;
                    }

                    @Override // io.grpc.ServerCall
                    public void sendMessage(ORespT orespt) {
                        delegate().sendMessage(methodDescriptor2.parseResponse(MethodDescriptor.this.streamResponse(orespt)));
                    }
                }, metadata);
                return new PartialForwardingServerCallListener<WReqT>() { // from class: io.grpc.ServerInterceptors.2.2
                    @Override // io.grpc.PartialForwardingServerCallListener
                    public ServerCall.Listener<OReqT> delegate() {
                        return startCall;
                    }

                    @Override // io.grpc.ServerCall.Listener
                    public void onMessage(WReqT wreqt) {
                        delegate().onMessage(MethodDescriptor.this.parseRequest(methodDescriptor2.streamRequest(wreqt)));
                    }
                };
            }
        };
    }

    public static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> serverMethodDefinition, MethodDescriptor<WReqT, WRespT> methodDescriptor) {
        return ServerMethodDefinition.create(methodDescriptor, wrapHandler(serverMethodDefinition.getServerCallHandler(), serverMethodDefinition.getMethodDescriptor(), methodDescriptor));
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        o.s(bindableService, "bindableService");
        return intercept(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9870")
    public static <ReqT, RespT> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<ReqT> marshaller, MethodDescriptor.Marshaller<RespT> marshaller2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ServerMethodDefinition<?, ?> serverMethodDefinition : serverServiceDefinition.getMethods()) {
            MethodDescriptor build = serverMethodDefinition.getMethodDescriptor().toBuilder(marshaller, marshaller2).build();
            arrayList2.add(build);
            arrayList.add(wrapMethod(serverMethodDefinition, build));
        }
        ServiceDescriptor.Builder schemaDescriptor = ServiceDescriptor.newBuilder(serverServiceDefinition.getServiceDescriptor().getName()).setSchemaDescriptor(serverServiceDefinition.getServiceDescriptor().getSchemaDescriptor());
        Iterator<E> iterator2 = arrayList2.iterator2();
        while (iterator2.hasNext()) {
            schemaDescriptor.addMethod((MethodDescriptor) iterator2.next());
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(schemaDescriptor.build());
        Iterator<E> iterator22 = arrayList.iterator2();
        while (iterator22.hasNext()) {
            builder.addMethod((ServerMethodDefinition) iterator22.next());
        }
        return builder.build();
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(serverServiceDefinition, arrayList);
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        o.s(serverServiceDefinition, "serviceDef");
        if (list.isEmpty()) {
            return serverServiceDefinition;
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(serverServiceDefinition.getServiceDescriptor());
        Iterator<ServerMethodDefinition<?, ?>> iterator2 = serverServiceDefinition.getMethods().iterator2();
        while (iterator2.hasNext()) {
            wrapAndAddMethod(builder, iterator2.next(), list);
        }
        return builder.build();
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, List<? extends ServerInterceptor> list) {
        return interceptForward(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, List<? extends ServerInterceptor> list) {
        o.s(bindableService, "bindableService");
        return intercept(bindableService.bindService(), list);
    }
}
