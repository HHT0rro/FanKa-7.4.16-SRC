package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import com.google.common.util.concurrent.i;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.p;
import com.google.common.util.concurrent.t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.grpc.Attributes;
import io.grpc.BinaryLog;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.InternalServerInterceptors;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallExecutorSupplier;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServerImpl extends Server implements InternalInstrumented<InternalChannelz.ServerStats> {
    private final BinaryLog binlog;
    private final InternalChannelz channelz;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    private Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final ServerCallExecutorSupplier executorSupplier;
    private final HandlerRegistry fallbackRegistry;
    private final long handshakeTimeoutMillis;
    private final ServerInterceptor[] interceptors;
    private final HandlerRegistry registry;
    private final Context rootContext;
    private final CallTracer serverCallTracer;
    private boolean serverShutdownCallbackInvoked;
    private boolean shutdown;
    private Status shutdownNowStatus;
    private boolean started;
    private boolean terminated;
    private final Deadline.Ticker ticker;
    private final List<ServerTransportFilter> transportFilters;
    private final InternalServer transportServer;
    private boolean transportServersTerminated;
    private static final Logger log = Logger.getLogger(ServerImpl.class.getName());
    private static final ServerStreamListener NOOP_LISTENER = new NoopListener();
    private final Object lock = new Object();
    private final Set<ServerTransport> transports = new HashSet();
    private final InternalLogId logId = InternalLogId.allocate("Server", String.valueOf(getListenSocketsIgnoringLifecycle()));

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ContextCloser implements Runnable {
        private final Throwable cause;
        private final Context.CancellableContext context;

        public ContextCloser(Context.CancellableContext cancellableContext, Throwable th) {
            this.context = cancellableContext;
            this.cause = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.context.cancel(this.cause);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class JumpToApplicationThreadServerStreamListener implements ServerStreamListener {
        private final Executor callExecutor;
        private final Executor cancelExecutor;
        private final Context.CancellableContext context;
        private ServerStreamListener listener;
        private final ServerStream stream;
        private final Tag tag;

        public JumpToApplicationThreadServerStreamListener(Executor executor, Executor executor2, ServerStream serverStream, Context.CancellableContext cancellableContext, Tag tag) {
            this.callExecutor = executor;
            this.cancelExecutor = executor2;
            this.stream = serverStream;
            this.context = cancellableContext;
            this.tag = tag;
        }

        private void closedInternal(final Status status) {
            if (!status.isOk()) {
                Throwable cause = status.getCause();
                if (cause == null) {
                    cause = InternalStatus.asRuntimeException(Status.CANCELLED.withDescription("RPC cancelled"), null, false);
                }
                this.cancelExecutor.execute(new ContextCloser(this.context, cause));
            }
            final Link linkOut = PerfMark.linkOut();
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1Closed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(JumpToApplicationThreadServerStreamListener.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ServerCallListener(app).closed", JumpToApplicationThreadServerStreamListener.this.tag);
                    PerfMark.linkIn(linkOut);
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().closed(status);
                    } finally {
                        PerfMark.stopTask("ServerCallListener(app).closed", JumpToApplicationThreadServerStreamListener.this.tag);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ServerStreamListener getListener() {
            ServerStreamListener serverStreamListener = this.listener;
            if (serverStreamListener != null) {
                return serverStreamListener;
            }
            throw new IllegalStateException("listener unset");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void internalClose(Throwable th) {
            this.stream.close(Status.UNKNOWN.withCause(th), new Metadata());
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
            PerfMark.startTask("ServerStreamListener.closed", this.tag);
            try {
                closedInternal(status);
            } finally {
                PerfMark.stopTask("ServerStreamListener.closed", this.tag);
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            PerfMark.startTask("ServerStreamListener.halfClosed", this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1HalfClosed
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).halfClosed", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
                        } finally {
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ServerStreamListener.halfClosed", this.tag);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            PerfMark.startTask("ServerStreamListener.messagesAvailable", this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1MessagesAvailable
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).messagesAvailable", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().messagesAvailable(messageProducer);
                        } finally {
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ServerStreamListener.messagesAvailable", this.tag);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            PerfMark.startTask("ServerStreamListener.onReady", this.tag);
            final Link linkOut = PerfMark.linkOut();
            try {
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1OnReady
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(JumpToApplicationThreadServerStreamListener.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        PerfMark.startTask("ServerCallListener(app).onReady", JumpToApplicationThreadServerStreamListener.this.tag);
                        PerfMark.linkIn(linkOut);
                        try {
                            JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
                        } finally {
                        }
                    }
                });
            } finally {
                PerfMark.stopTask("ServerStreamListener.onReady", this.tag);
            }
        }

        public void setListener(ServerStreamListener serverStreamListener) {
            o.s(serverStreamListener, "listener must not be null");
            o.y(this.listener == null, "Listener already set");
            this.listener = serverStreamListener;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NoopListener implements ServerStreamListener {
        private NoopListener() {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            while (true) {
                InputStream next = messageProducer.next();
                if (next == null) {
                    return;
                }
                try {
                    next.close();
                } catch (IOException e2) {
                    while (true) {
                        InputStream next2 = messageProducer.next();
                        if (next2 == null) {
                            break;
                        }
                        try {
                            next2.close();
                        } catch (IOException e10) {
                            ServerImpl.log.log(Level.WARNING, "Exception closing stream", (Throwable) e10);
                        }
                    }
                    throw new RuntimeException(e2);
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class ServerListenerImpl implements ServerListener {
        private ServerListenerImpl() {
        }

        @Override // io.grpc.internal.ServerListener
        public void serverShutdown() {
            synchronized (ServerImpl.this.lock) {
                if (ServerImpl.this.serverShutdownCallbackInvoked) {
                    return;
                }
                ArrayList arrayList = new ArrayList(ServerImpl.this.transports);
                Status status = ServerImpl.this.shutdownNowStatus;
                ServerImpl.this.serverShutdownCallbackInvoked = true;
                Iterator iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    ServerTransport serverTransport = (ServerTransport) iterator2.next();
                    if (status == null) {
                        serverTransport.shutdown();
                    } else {
                        serverTransport.shutdownNow(status);
                    }
                }
                synchronized (ServerImpl.this.lock) {
                    ServerImpl.this.transportServersTerminated = true;
                    ServerImpl.this.checkForTermination();
                }
            }
        }

        @Override // io.grpc.internal.ServerListener
        public ServerTransportListener transportCreated(ServerTransport serverTransport) {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.this.transports.add(serverTransport);
            }
            ServerTransportListenerImpl serverTransportListenerImpl = new ServerTransportListenerImpl(serverTransport);
            serverTransportListenerImpl.init();
            return serverTransportListenerImpl;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class ServerTransportListenerImpl implements ServerTransportListener {
        private Attributes attributes;
        private Future<?> handshakeTimeoutFuture;
        private final ServerTransport transport;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class ServerCallParameters<ReqT, RespT> {
            public ServerCallImpl<ReqT, RespT> call;
            public ServerCallHandler<ReqT, RespT> callHandler;

            public ServerCallParameters(ServerCallImpl<ReqT, RespT> serverCallImpl, ServerCallHandler<ReqT, RespT> serverCallHandler) {
                this.call = serverCallImpl;
                this.callHandler = serverCallHandler;
            }
        }

        public ServerTransportListenerImpl(ServerTransport serverTransport) {
            this.transport = serverTransport;
        }

        private Context.CancellableContext createContext(Metadata metadata, StatsTraceContext statsTraceContext) {
            Long l10 = (Long) metadata.get(GrpcUtil.TIMEOUT_KEY);
            Context withValue = statsTraceContext.serverFilterContext(ServerImpl.this.rootContext).withValue(io.grpc.InternalServer.SERVER_CONTEXT_KEY, ServerImpl.this);
            if (l10 == null) {
                return withValue.withCancellation();
            }
            return withValue.withDeadline(Deadline.after(l10.longValue(), TimeUnit.NANOSECONDS, ServerImpl.this.ticker), this.transport.getScheduledExecutorService());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <WReqT, WRespT> ServerStreamListener startWrappedCall(String str, ServerCallParameters<WReqT, WRespT> serverCallParameters, Metadata metadata) {
            ServerCall.Listener<WReqT> startCall = serverCallParameters.callHandler.startCall(serverCallParameters.call, metadata);
            if (startCall != null) {
                return serverCallParameters.call.newServerStreamListener(startCall);
            }
            throw new NullPointerException("startCall() returned a null listener for method " + str);
        }

        private void streamCreatedInternal(ServerStream serverStream, String str, Metadata metadata, Tag tag) {
            Executor serializingExecutor;
            if (ServerImpl.this.executorSupplier == null && ServerImpl.this.executor == p.a()) {
                serializingExecutor = new SerializeReentrantCallsDirectExecutor();
                serverStream.optimizeForDirectExecutor();
            } else {
                serializingExecutor = new SerializingExecutor(ServerImpl.this.executor);
            }
            Executor executor = serializingExecutor;
            Metadata.Key<String> key = GrpcUtil.MESSAGE_ENCODING_KEY;
            if (metadata.containsKey(key)) {
                String str2 = (String) metadata.get(key);
                Decompressor lookupDecompressor = ServerImpl.this.decompressorRegistry.lookupDecompressor(str2);
                if (lookupDecompressor == null) {
                    serverStream.setListener(ServerImpl.NOOP_LISTENER);
                    serverStream.close(Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", str2)), new Metadata());
                    return;
                }
                serverStream.setDecompressor(lookupDecompressor);
            }
            StatsTraceContext statsTraceContext = (StatsTraceContext) o.s(serverStream.statsTraceContext(), "statsTraceCtx not present from stream");
            Context.CancellableContext createContext = createContext(metadata, statsTraceContext);
            Link linkOut = PerfMark.linkOut();
            JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener = new JumpToApplicationThreadServerStreamListener(executor, ServerImpl.this.executor, serverStream, createContext, tag);
            serverStream.setListener(jumpToApplicationThreadServerStreamListener);
            t a10 = t.a();
            executor.execute(new ContextRunnable(createContext, tag, linkOut, str, serverStream, jumpToApplicationThreadServerStreamListener, a10, statsTraceContext, metadata, executor) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1MethodLookup
                public final /* synthetic */ Context.CancellableContext val$context;
                public final /* synthetic */ t val$future;
                public final /* synthetic */ Metadata val$headers;
                public final /* synthetic */ JumpToApplicationThreadServerStreamListener val$jumpListener;
                public final /* synthetic */ Link val$link;
                public final /* synthetic */ String val$methodName;
                public final /* synthetic */ StatsTraceContext val$statsTraceCtx;
                public final /* synthetic */ ServerStream val$stream;
                public final /* synthetic */ Tag val$tag;
                public final /* synthetic */ Executor val$wrappedExecutor;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(createContext);
                    this.val$context = createContext;
                    this.val$tag = tag;
                    this.val$link = linkOut;
                    this.val$methodName = str;
                    this.val$stream = serverStream;
                    this.val$jumpListener = jumpToApplicationThreadServerStreamListener;
                    this.val$future = a10;
                    this.val$statsTraceCtx = statsTraceContext;
                    this.val$headers = metadata;
                    this.val$wrappedExecutor = executor;
                }

                private <ReqT, RespT> ServerCallParameters<ReqT, RespT> maySwitchExecutor(ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, ServerStream serverStream2, Metadata metadata2, Context.CancellableContext cancellableContext, Tag tag2) {
                    Executor executor2;
                    ServerCallImpl serverCallImpl = new ServerCallImpl(serverStream2, serverMethodDefinition.getMethodDescriptor(), metadata2, cancellableContext, ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry, ServerImpl.this.serverCallTracer, tag2);
                    if (ServerImpl.this.executorSupplier != null && (executor2 = ServerImpl.this.executorSupplier.getExecutor(serverCallImpl, metadata2)) != null) {
                        ((SerializingExecutor) this.val$wrappedExecutor).setExecutor(executor2);
                    }
                    return new ServerCallParameters<>(serverCallImpl, serverMethodDefinition.getServerCallHandler());
                }

                private void runInternal() {
                    try {
                        ServerMethodDefinition<?, ?> lookupMethod = ServerImpl.this.registry.lookupMethod(this.val$methodName);
                        if (lookupMethod == null) {
                            lookupMethod = ServerImpl.this.fallbackRegistry.lookupMethod(this.val$methodName, this.val$stream.getAuthority());
                        }
                        if (lookupMethod == null) {
                            Status withDescription = Status.UNIMPLEMENTED.withDescription("Method not found: " + this.val$methodName);
                            this.val$jumpListener.setListener(ServerImpl.NOOP_LISTENER);
                            this.val$stream.close(withDescription, new Metadata());
                            this.val$context.cancel(null);
                            this.val$future.cancel(false);
                            return;
                        }
                        this.val$future.set(maySwitchExecutor(ServerTransportListenerImpl.this.wrapMethod(this.val$stream, lookupMethod, this.val$statsTraceCtx), this.val$stream, this.val$headers, this.val$context, this.val$tag));
                    } catch (Throwable th) {
                        this.val$jumpListener.setListener(ServerImpl.NOOP_LISTENER);
                        this.val$stream.close(Status.fromThrowable(th), new Metadata());
                        this.val$context.cancel(null);
                        this.val$future.cancel(false);
                        throw th;
                    }
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ServerTransportListener$MethodLookup.startCall", this.val$tag);
                    PerfMark.linkIn(this.val$link);
                    try {
                        runInternal();
                    } finally {
                        PerfMark.stopTask("ServerTransportListener$MethodLookup.startCall", this.val$tag);
                    }
                }
            });
            executor.execute(new ContextRunnable(createContext, tag, linkOut, a10, str, metadata, serverStream, jumpToApplicationThreadServerStreamListener) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1HandleServerCall
                public final /* synthetic */ Context.CancellableContext val$context;
                public final /* synthetic */ t val$future;
                public final /* synthetic */ Metadata val$headers;
                public final /* synthetic */ JumpToApplicationThreadServerStreamListener val$jumpListener;
                public final /* synthetic */ Link val$link;
                public final /* synthetic */ String val$methodName;
                public final /* synthetic */ ServerStream val$stream;
                public final /* synthetic */ Tag val$tag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(createContext);
                    this.val$context = createContext;
                    this.val$tag = tag;
                    this.val$link = linkOut;
                    this.val$future = a10;
                    this.val$methodName = str;
                    this.val$headers = metadata;
                    this.val$stream = serverStream;
                    this.val$jumpListener = jumpToApplicationThreadServerStreamListener;
                }

                private void runInternal() {
                    ServerStreamListener serverStreamListener = ServerImpl.NOOP_LISTENER;
                    if (this.val$future.isCancelled()) {
                        return;
                    }
                    try {
                        this.val$jumpListener.setListener(ServerTransportListenerImpl.this.startWrappedCall(this.val$methodName, (ServerCallParameters) i.a(this.val$future), this.val$headers));
                        this.val$context.addListener(new Context.CancellationListener() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1HandleServerCall.1ServerStreamCancellationListener
                            @Override // io.grpc.Context.CancellationListener
                            public void cancelled(Context context) {
                                Status statusFromCancelled = Contexts.statusFromCancelled(context);
                                if (Status.DEADLINE_EXCEEDED.getCode().equals(statusFromCancelled.getCode())) {
                                    C1HandleServerCall.this.val$stream.cancel(statusFromCancelled);
                                }
                            }
                        }, p.a());
                    } finally {
                    }
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    PerfMark.startTask("ServerTransportListener$HandleServerCall.startCall", this.val$tag);
                    PerfMark.linkIn(this.val$link);
                    try {
                        runInternal();
                    } finally {
                        PerfMark.stopTask("ServerTransportListener$HandleServerCall.startCall", this.val$tag);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> ServerMethodDefinition<?, ?> wrapMethod(ServerStream serverStream, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, StatsTraceContext statsTraceContext) {
            statsTraceContext.serverCallStarted(new ServerCallInfoImpl(serverMethodDefinition.getMethodDescriptor(), serverStream.getAttributes(), serverStream.getAuthority()));
            ServerCallHandler<ReqT, RespT> serverCallHandler = serverMethodDefinition.getServerCallHandler();
            for (ServerInterceptor serverInterceptor : ServerImpl.this.interceptors) {
                serverCallHandler = InternalServerInterceptors.interceptCallHandlerCreate(serverInterceptor, serverCallHandler);
            }
            ServerMethodDefinition<ReqT, RespT> withServerCallHandler = serverMethodDefinition.withServerCallHandler(serverCallHandler);
            return ServerImpl.this.binlog == null ? withServerCallHandler : ServerImpl.this.binlog.wrapMethodDefinition(withServerCallHandler);
        }

        public void init() {
            if (ServerImpl.this.handshakeTimeoutMillis != Long.MAX_VALUE) {
                this.handshakeTimeoutFuture = this.transport.getScheduledExecutorService().schedule(new Runnable() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1TransportShutdownNow
                    @Override // java.lang.Runnable
                    public void run() {
                        ServerTransportListenerImpl.this.transport.shutdownNow(Status.CANCELLED.withDescription("Handshake timeout exceeded"));
                    }
                }, ServerImpl.this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
            } else {
                this.handshakeTimeoutFuture = new FutureTask(new Runnable() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                }, null);
            }
            ServerImpl.this.channelz.addServerSocket(ServerImpl.this, this.transport);
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void streamCreated(ServerStream serverStream, String str, Metadata metadata) {
            Tag createTag = PerfMark.createTag(str, serverStream.streamId());
            PerfMark.startTask("ServerTransportListener.streamCreated", createTag);
            try {
                streamCreatedInternal(serverStream, str, metadata, createTag);
            } finally {
                PerfMark.stopTask("ServerTransportListener.streamCreated", createTag);
            }
        }

        @Override // io.grpc.internal.ServerTransportListener
        public Attributes transportReady(Attributes attributes) {
            this.handshakeTimeoutFuture.cancel(false);
            this.handshakeTimeoutFuture = null;
            for (ServerTransportFilter serverTransportFilter : ServerImpl.this.transportFilters) {
                attributes = (Attributes) o.t(serverTransportFilter.transportReady(attributes), "Filter %s returned null", serverTransportFilter);
            }
            this.attributes = attributes;
            return attributes;
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void transportTerminated() {
            Future<?> future = this.handshakeTimeoutFuture;
            if (future != null) {
                future.cancel(false);
                this.handshakeTimeoutFuture = null;
            }
            Iterator iterator2 = ServerImpl.this.transportFilters.iterator2();
            while (iterator2.hasNext()) {
                ((ServerTransportFilter) iterator2.next()).transportTerminated(this.attributes);
            }
            ServerImpl.this.transportClosed(this.transport);
        }
    }

    public ServerImpl(ServerImplBuilder serverImplBuilder, InternalServer internalServer, Context context) {
        this.executorPool = (ObjectPool) o.s(serverImplBuilder.executorPool, "executorPool");
        this.registry = (HandlerRegistry) o.s(serverImplBuilder.registryBuilder.build(), "registryBuilder");
        this.fallbackRegistry = (HandlerRegistry) o.s(serverImplBuilder.fallbackRegistry, "fallbackRegistry");
        this.transportServer = (InternalServer) o.s(internalServer, "transportServer");
        this.rootContext = ((Context) o.s(context, "rootContext")).fork();
        this.decompressorRegistry = serverImplBuilder.decompressorRegistry;
        this.compressorRegistry = serverImplBuilder.compressorRegistry;
        this.transportFilters = Collections.unmodifiableList(new ArrayList(serverImplBuilder.transportFilters));
        List<ServerInterceptor> list = serverImplBuilder.interceptors;
        this.interceptors = (ServerInterceptor[]) list.toArray(new ServerInterceptor[list.size()]);
        this.handshakeTimeoutMillis = serverImplBuilder.handshakeTimeoutMillis;
        this.binlog = serverImplBuilder.binlog;
        InternalChannelz internalChannelz = serverImplBuilder.channelz;
        this.channelz = internalChannelz;
        this.serverCallTracer = serverImplBuilder.callTracerFactory.create();
        this.ticker = (Deadline.Ticker) o.s(serverImplBuilder.ticker, RemoteMessageConst.Notification.TICKER);
        internalChannelz.addServer(this);
        this.executorSupplier = serverImplBuilder.executorSupplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForTermination() {
        synchronized (this.lock) {
            if (this.shutdown && this.transports.isEmpty() && this.transportServersTerminated) {
                if (!this.terminated) {
                    this.terminated = true;
                    this.channelz.removeServer(this);
                    Executor executor = this.executor;
                    if (executor != null) {
                        this.executor = this.executorPool.returnObject(executor);
                    }
                    this.lock.notifyAll();
                } else {
                    throw new AssertionError((Object) "Server already terminated");
                }
            }
        }
    }

    private List<SocketAddress> getListenSocketsIgnoringLifecycle() {
        List<SocketAddress> unmodifiableList;
        synchronized (this.lock) {
            unmodifiableList = Collections.unmodifiableList(this.transportServer.getListenSocketAddresses());
        }
        return unmodifiableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transportClosed(ServerTransport serverTransport) {
        synchronized (this.lock) {
            if (this.transports.remove(serverTransport)) {
                this.channelz.removeServerSocket(this, serverTransport);
                checkForTermination();
            } else {
                throw new AssertionError((Object) "Transport already removed");
            }
        }
    }

    @Override // io.grpc.Server
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean z10;
        synchronized (this.lock) {
            long nanoTime = System.nanoTime() + timeUnit.toNanos(j10);
            while (!this.terminated) {
                long nanoTime2 = nanoTime - System.nanoTime();
                if (nanoTime2 <= 0) {
                    break;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, nanoTime2);
            }
            z10 = this.terminated;
        }
        return z10;
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getImmutableServices() {
        return this.registry.getServices();
    }

    @Override // io.grpc.Server
    public List<SocketAddress> getListenSockets() {
        List<SocketAddress> listenSocketsIgnoringLifecycle;
        synchronized (this.lock) {
            o.y(this.started, "Not started");
            o.y(!this.terminated, "Already terminated");
            listenSocketsIgnoringLifecycle = getListenSocketsIgnoringLifecycle();
        }
        return listenSocketsIgnoringLifecycle;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.unmodifiableList(this.fallbackRegistry.getServices());
    }

    @Override // io.grpc.Server
    public int getPort() {
        synchronized (this.lock) {
            o.y(this.started, "Not started");
            o.y(!this.terminated, "Already terminated");
            for (SocketAddress socketAddress : this.transportServer.getListenSocketAddresses()) {
                if (socketAddress instanceof InetSocketAddress) {
                    return ((InetSocketAddress) socketAddress).getPort();
                }
            }
            return -1;
        }
    }

    @Override // io.grpc.Server
    public List<ServerServiceDefinition> getServices() {
        List<ServerServiceDefinition> services = this.fallbackRegistry.getServices();
        if (services.isEmpty()) {
            return this.registry.getServices();
        }
        List<ServerServiceDefinition> services2 = this.registry.getServices();
        ArrayList arrayList = new ArrayList(services2.size() + services.size());
        arrayList.addAll(services2);
        arrayList.addAll(services);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // io.grpc.InternalInstrumented
    public n<InternalChannelz.ServerStats> getStats() {
        InternalChannelz.ServerStats.Builder builder = new InternalChannelz.ServerStats.Builder();
        List<InternalInstrumented<InternalChannelz.SocketStats>> listenSocketStatsList = this.transportServer.getListenSocketStatsList();
        if (listenSocketStatsList != null) {
            builder.addListenSockets(listenSocketStatsList);
        }
        this.serverCallTracer.updateBuilder(builder);
        t a10 = t.a();
        a10.set(builder.build());
        return a10;
    }

    @Override // io.grpc.Server
    public boolean isShutdown() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.shutdown;
        }
        return z10;
    }

    @Override // io.grpc.Server
    public boolean isTerminated() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.terminated;
        }
        return z10;
    }

    public String toString() {
        return j.c(this).c("logId", this.logId.getId()).d("transportServer", this.transportServer).toString();
    }

    @Override // io.grpc.Server
    public ServerImpl shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return this;
            }
            this.shutdown = true;
            boolean z10 = this.started;
            if (!z10) {
                this.transportServersTerminated = true;
                checkForTermination();
            }
            if (z10) {
                this.transportServer.shutdown();
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public ServerImpl shutdownNow() {
        shutdown();
        Status withDescription = Status.UNAVAILABLE.withDescription("Server shutdownNow invoked");
        synchronized (this.lock) {
            if (this.shutdownNowStatus != null) {
                return this;
            }
            this.shutdownNowStatus = withDescription;
            ArrayList arrayList = new ArrayList(this.transports);
            boolean z10 = this.serverShutdownCallbackInvoked;
            if (z10) {
                Iterator<E> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    ((ServerTransport) iterator2.next()).shutdownNow(withDescription);
                }
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public ServerImpl start() throws IOException {
        synchronized (this.lock) {
            o.y(!this.started, "Already started");
            o.y(this.shutdown ? false : true, "Shutting down");
            this.transportServer.start(new ServerListenerImpl());
            this.executor = (Executor) o.s(this.executorPool.getObject(), "executor");
            this.started = true;
        }
        return this;
    }

    @Override // io.grpc.Server
    public void awaitTermination() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.terminated) {
                this.lock.wait();
            }
        }
    }
}
