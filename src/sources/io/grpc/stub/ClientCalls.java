package io.grpc.stub;

import com.google.common.base.j;
import com.google.common.base.o;
import com.google.common.base.s;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.n;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ClientCalls {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final CallOptions.Key<StubType> STUB_TYPE_OPTION;
    private static final Logger logger = Logger.getLogger(ClientCalls.class.getName());
    public static boolean rejectRunnableOnExecutor;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class BlockingResponseStream<T> implements Iterator<T> {
        private final BlockingQueue<Object> buffer;
        private final ClientCall<?, T> call;
        private Object last;
        private final StartableListener<T> listener;
        private final ThreadlessExecutor threadless;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class QueuingListener extends StartableListener<T> {
            private boolean done;

            public QueuingListener() {
                super();
                this.done = false;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                o.y(!this.done, "ClientCall already closed");
                if (status.isOk()) {
                    BlockingResponseStream.this.buffer.add(BlockingResponseStream.this);
                } else {
                    BlockingResponseStream.this.buffer.add(status.asRuntimeException(metadata));
                }
                this.done = true;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onHeaders(Metadata metadata) {
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(T t2) {
                o.y(!this.done, "ClientCall already closed");
                BlockingResponseStream.this.buffer.add(t2);
            }

            @Override // io.grpc.stub.ClientCalls.StartableListener
            public void onStart() {
                BlockingResponseStream.this.call.request(1);
            }
        }

        public BlockingResponseStream(ClientCall<?, T> clientCall) {
            this(clientCall, null);
        }

        private Object waitForNext() {
            Object take;
            Object poll;
            boolean z10 = false;
            try {
                try {
                    if (this.threadless == null) {
                        while (true) {
                            try {
                                take = this.buffer.take();
                                break;
                            } catch (InterruptedException e2) {
                                this.call.cancel("Thread interrupted", e2);
                                z10 = true;
                            }
                        }
                        if (z10) {
                            Thread.currentThread().interrupt();
                        }
                        return take;
                    }
                    while (true) {
                        poll = this.buffer.poll();
                        if (poll != null) {
                            break;
                        }
                        try {
                            this.threadless.waitAndDrain();
                        } catch (InterruptedException e10) {
                            this.call.cancel("Thread interrupted", e10);
                            z10 = true;
                        }
                    }
                    if (poll == this || (poll instanceof StatusRuntimeException)) {
                        this.threadless.shutdown();
                    }
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    return poll;
                } catch (Throwable th) {
                    th = th;
                    z10 = true;
                }
                th = th;
                z10 = true;
            } catch (Throwable th2) {
                th = th2;
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Object obj;
            while (true) {
                obj = this.last;
                if (obj != null) {
                    break;
                }
                this.last = waitForNext();
            }
            if (!(obj instanceof StatusRuntimeException)) {
                return obj != this;
            }
            StatusRuntimeException statusRuntimeException = (StatusRuntimeException) obj;
            throw statusRuntimeException.getStatus().asRuntimeException(statusRuntimeException.getTrailers());
        }

        public StartableListener<T> listener() {
            return this.listener;
        }

        @Override // java.util.Iterator
        public T next() {
            Object obj = this.last;
            if (!(obj instanceof StatusRuntimeException) && obj != this) {
                this.call.request(1);
            }
            if (hasNext()) {
                T t2 = (T) this.last;
                this.last = null;
                return t2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public BlockingResponseStream(ClientCall<?, T> clientCall, ThreadlessExecutor threadlessExecutor) {
            this.buffer = new ArrayBlockingQueue(3);
            this.listener = new QueuingListener();
            this.call = clientCall;
            this.threadless = threadlessExecutor;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CallToStreamObserverAdapter<ReqT> extends ClientCallStreamObserver<ReqT> {
        private final ClientCall<ReqT, ?> call;
        private boolean frozen;
        private Runnable onReadyHandler;
        private final boolean streamingResponse;
        private int initialRequest = 1;
        private boolean autoRequestEnabled = true;
        private boolean aborted = false;
        private boolean completed = false;

        public CallToStreamObserverAdapter(ClientCall<ReqT, ?> clientCall, boolean z10) {
            this.call = clientCall;
            this.streamingResponse = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.ClientCallStreamObserver
        public void cancel(String str, Throwable th) {
            this.call.cancel(str, th);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void disableAutoInboundFlowControl() {
            disableAutoRequestWithInitial(1);
        }

        @Override // io.grpc.stub.ClientCallStreamObserver
        public void disableAutoRequestWithInitial(int i10) {
            if (!this.frozen) {
                o.e(i10 >= 0, "Initial requests must be non-negative");
                this.initialRequest = i10;
                this.autoRequestEnabled = false;
                return;
            }
            throw new IllegalStateException("Cannot disable auto flow control after call started. Use ClientResponseObserver");
        }

        @Override // io.grpc.stub.ClientCallStreamObserver, io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            this.call.halfClose();
            this.completed = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
            this.call.cancel("Cancelled by client with StreamObserver.onError()", th);
            this.aborted = true;
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(ReqT reqt) {
            o.y(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            o.y(!this.completed, "Stream is already completed, no further calls are allowed");
            this.call.sendMessage(reqt);
        }

        @Override // io.grpc.stub.ClientCallStreamObserver, io.grpc.stub.CallStreamObserver
        public void request(int i10) {
            if (!this.streamingResponse && i10 == 1) {
                this.call.request(2);
            } else {
                this.call.request(i10);
            }
        }

        @Override // io.grpc.stub.ClientCallStreamObserver, io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean z10) {
            this.call.setMessageCompression(z10);
        }

        @Override // io.grpc.stub.ClientCallStreamObserver, io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable runnable) {
            if (!this.frozen) {
                this.onReadyHandler = runnable;
                return;
            }
            throw new IllegalStateException("Cannot alter onReadyHandler after call started. Use ClientResponseObserver");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class GrpcFuture<RespT> extends AbstractFuture<RespT> {
        private final ClientCall<?, RespT> call;

        public GrpcFuture(ClientCall<?, RespT> clientCall) {
            this.call = clientCall;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void interruptTask() {
            this.call.cancel("GrpcFuture was cancelled", null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            return j.c(this).d("clientCall", this.call).toString();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean set(RespT respt) {
            return super.set(respt);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean setException(Throwable th) {
            return super.setException(th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class StartableListener<T> extends ClientCall.Listener<T> {
        private StartableListener() {
        }

        public abstract void onStart();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StreamObserverToCallListenerAdapter<ReqT, RespT> extends StartableListener<RespT> {
        private final CallToStreamObserverAdapter<ReqT> adapter;
        private boolean firstResponseReceived;
        private final StreamObserver<RespT> observer;

        public StreamObserverToCallListenerAdapter(StreamObserver<RespT> streamObserver, CallToStreamObserverAdapter<ReqT> callToStreamObserverAdapter) {
            super();
            this.observer = streamObserver;
            this.adapter = callToStreamObserverAdapter;
            if (streamObserver instanceof ClientResponseObserver) {
                ((ClientResponseObserver) streamObserver).beforeStart(callToStreamObserverAdapter);
            }
            callToStreamObserverAdapter.freeze();
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (status.isOk()) {
                this.observer.onCompleted();
            } else {
                this.observer.onError(status.asRuntimeException(metadata));
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            if (this.firstResponseReceived && !((CallToStreamObserverAdapter) this.adapter).streamingResponse) {
                throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
            }
            this.firstResponseReceived = true;
            this.observer.onNext(respt);
            if (((CallToStreamObserverAdapter) this.adapter).streamingResponse && ((CallToStreamObserverAdapter) this.adapter).autoRequestEnabled) {
                this.adapter.request(1);
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (((CallToStreamObserverAdapter) this.adapter).onReadyHandler != null) {
                ((CallToStreamObserverAdapter) this.adapter).onReadyHandler.run();
            }
        }

        @Override // io.grpc.stub.ClientCalls.StartableListener
        public void onStart() {
            if (((CallToStreamObserverAdapter) this.adapter).initialRequest > 0) {
                CallToStreamObserverAdapter<ReqT> callToStreamObserverAdapter = this.adapter;
                callToStreamObserverAdapter.request(((CallToStreamObserverAdapter) callToStreamObserverAdapter).initialRequest);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum StubType {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ThreadlessExecutor extends ConcurrentLinkedQueue<Runnable> implements Executor {
        private volatile Object waiter;
        private static final Logger log = Logger.getLogger(ThreadlessExecutor.class.getName());
        private static final Object SHUTDOWN = new Object();

        private static void runQuietly(Runnable runnable) {
            try {
                runnable.run();
            } catch (Throwable th) {
                log.log(Level.WARNING, "Runnable threw exception", th);
            }
        }

        private static void throwIfInterrupted() throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            add(runnable);
            Object obj = this.waiter;
            if (obj != SHUTDOWN) {
                LockSupport.unpark((Thread) obj);
            } else if (remove(runnable) && ClientCalls.rejectRunnableOnExecutor) {
                throw new RejectedExecutionException();
            }
        }

        public void shutdown() {
            this.waiter = SHUTDOWN;
            while (true) {
                Runnable poll = poll();
                if (poll == null) {
                    return;
                } else {
                    runQuietly(poll);
                }
            }
        }

        public void waitAndDrain() throws InterruptedException {
            Runnable poll;
            throwIfInterrupted();
            Runnable poll2 = poll();
            if (poll2 == null) {
                this.waiter = Thread.currentThread();
                while (true) {
                    try {
                        poll = poll();
                        if (poll != null) {
                            break;
                        }
                        LockSupport.park(this);
                        throwIfInterrupted();
                    } catch (Throwable th) {
                        this.waiter = null;
                        throw th;
                    }
                }
                this.waiter = null;
                poll2 = poll;
            }
            do {
                runQuietly(poll2);
                poll2 = poll();
            } while (poll2 != null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class UnaryStreamToFuture<RespT> extends StartableListener<RespT> {
        private boolean isValueReceived;
        private final GrpcFuture<RespT> responseFuture;
        private RespT value;

        public UnaryStreamToFuture(GrpcFuture<RespT> grpcFuture) {
            super();
            this.isValueReceived = false;
            this.responseFuture = grpcFuture;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (status.isOk()) {
                if (!this.isValueReceived) {
                    this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(metadata));
                }
                this.responseFuture.set(this.value);
                return;
            }
            this.responseFuture.setException(status.asRuntimeException(metadata));
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            if (!this.isValueReceived) {
                this.value = respt;
                this.isValueReceived = true;
                return;
            }
            throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
        }

        @Override // io.grpc.stub.ClientCalls.StartableListener
        public void onStart() {
            ((GrpcFuture) this.responseFuture).call.request(2);
        }
    }

    static {
        rejectRunnableOnExecutor = !s.b(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        STUB_TYPE_OPTION = CallOptions.Key.create("internal-stub-type");
    }

    private ClientCalls() {
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver) {
        return asyncStreamingRequestCall(clientCall, streamObserver, true);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver) {
        return asyncStreamingRequestCall(clientCall, streamObserver, false);
    }

    public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver) {
        asyncUnaryRequestCall(clientCall, reqt, streamObserver, true);
    }

    private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver, boolean z10) {
        CallToStreamObserverAdapter callToStreamObserverAdapter = new CallToStreamObserverAdapter(clientCall, z10);
        startCall(clientCall, new StreamObserverToCallListenerAdapter(streamObserver, callToStreamObserverAdapter));
        return callToStreamObserverAdapter;
    }

    public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver) {
        asyncUnaryRequestCall(clientCall, reqt, streamObserver, false);
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver, boolean z10) {
        asyncUnaryRequestCall(clientCall, reqt, new StreamObserverToCallListenerAdapter(streamObserver, new CallToStreamObserverAdapter(clientCall, z10)));
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        BlockingResponseStream blockingResponseStream = new BlockingResponseStream(clientCall);
        asyncUnaryRequestCall(clientCall, reqt, blockingResponseStream.listener());
        return blockingResponseStream;
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        try {
            return (RespT) getUnchecked(futureUnaryCall(clientCall, reqt));
        } catch (Error e2) {
            throw cancelThrow(clientCall, e2);
        } catch (RuntimeException e10) {
            throw cancelThrow(clientCall, e10);
        }
    }

    private static RuntimeException cancelThrow(ClientCall<?, ?> clientCall, Throwable th) {
        try {
            clientCall.cancel(null, th);
        } catch (Throwable th2) {
            logger.log(Level.SEVERE, "RuntimeException encountered while closing call", th2);
        }
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new AssertionError(th);
        }
        throw ((RuntimeException) th);
    }

    public static <ReqT, RespT> n<RespT> futureUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        GrpcFuture grpcFuture = new GrpcFuture(clientCall);
        asyncUnaryRequestCall(clientCall, reqt, new UnaryStreamToFuture(grpcFuture));
        return grpcFuture;
    }

    private static <V> V getUnchecked(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withDescription("Thread interrupted").withCause(e2).asRuntimeException();
        } catch (ExecutionException e10) {
            throw toStatusRuntimeException(e10.getCause());
        }
    }

    private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> clientCall, StartableListener<RespT> startableListener) {
        clientCall.start(startableListener, new Metadata());
        startableListener.onStart();
    }

    private static StatusRuntimeException toStatusRuntimeException(Throwable th) {
        for (Throwable th2 = (Throwable) o.s(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                StatusException statusException = (StatusException) th2;
                return new StatusRuntimeException(statusException.getStatus(), statusException.getTrailers());
            }
            if (th2 instanceof StatusRuntimeException) {
                StatusRuntimeException statusRuntimeException = (StatusRuntimeException) th2;
                return new StatusRuntimeException(statusRuntimeException.getStatus(), statusRuntimeException.getTrailers());
            }
        }
        return Status.UNKNOWN.withDescription("unexpected exception").withCause(th).asRuntimeException();
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StartableListener<RespT> startableListener) {
        startCall(clientCall, startableListener);
        try {
            clientCall.sendMessage(reqt);
            clientCall.halfClose();
        } catch (Error e2) {
            throw cancelThrow(clientCall, e2);
        } catch (RuntimeException e10) {
            throw cancelThrow(clientCall, e10);
        }
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel channel, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, ReqT reqt) {
        ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
        ClientCall newCall = channel.newCall(methodDescriptor, callOptions.withOption(STUB_TYPE_OPTION, StubType.BLOCKING).withExecutor(threadlessExecutor));
        BlockingResponseStream blockingResponseStream = new BlockingResponseStream(newCall, threadlessExecutor);
        asyncUnaryRequestCall(newCall, reqt, blockingResponseStream.listener());
        return blockingResponseStream;
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(Channel channel, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, ReqT reqt) {
        ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
        ClientCall newCall = channel.newCall(methodDescriptor, callOptions.withOption(STUB_TYPE_OPTION, StubType.BLOCKING).withExecutor(threadlessExecutor));
        boolean z10 = false;
        try {
            try {
                n futureUnaryCall = futureUnaryCall(newCall, reqt);
                while (!futureUnaryCall.isDone()) {
                    try {
                        threadlessExecutor.waitAndDrain();
                    } catch (InterruptedException e2) {
                        try {
                            newCall.cancel("Thread interrupted", e2);
                            z10 = true;
                        } catch (Error e10) {
                            e = e10;
                            throw cancelThrow(newCall, e);
                        } catch (RuntimeException e11) {
                            e = e11;
                            throw cancelThrow(newCall, e);
                        } catch (Throwable th) {
                            th = th;
                            z10 = true;
                            if (z10) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                threadlessExecutor.shutdown();
                RespT respt = (RespT) getUnchecked(futureUnaryCall);
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                return respt;
            } catch (Error e12) {
                e = e12;
            } catch (RuntimeException e13) {
                e = e13;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
