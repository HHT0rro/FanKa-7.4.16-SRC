package io.grpc.internal;

import com.google.common.base.l;
import com.google.common.base.o;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class RetriableStream<ReqT> implements ClientStream {
    private static final Status CANCELLED_BECAUSE_COMMITTED;
    public static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS;
    public static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS;
    private static Random random;
    private final Executor callExecutor;
    private Status cancellationStatus;
    private final long channelBufferLimit;
    private final ChannelBufferMeter channelBufferUsed;
    private final Metadata headers;
    private final HedgingPolicy hedgingPolicy;
    private boolean isClosed;
    private final boolean isHedging;
    private ClientStreamListener masterListener;
    private final MethodDescriptor<ReqT, ?> method;
    private long nextBackoffIntervalNanos;
    private final long perRpcBufferLimit;
    private long perRpcBufferUsed;
    private final RetryPolicy retryPolicy;
    private SavedCloseMasterListenerReason savedCloseMasterListenerReason;
    private final ScheduledExecutorService scheduledExecutorService;
    private FutureCanceller scheduledHedging;
    private FutureCanceller scheduledRetry;
    private final Throttle throttle;
    private final Executor listenerSerializeExecutor = new SynchronizationContext(new Thread.UncaughtExceptionHandler() { // from class: io.grpc.internal.RetriableStream.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw Status.fromThrowable(th).withDescription("Uncaught exception in the SynchronizationContext. Re-thrown.").asRuntimeException();
        }
    });
    private final Object lock = new Object();
    private final InsightBuilder closedSubstreamsInsight = new InsightBuilder();
    private volatile State state = new State(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    private final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();
    private final AtomicInteger localOnlyTransparentRetries = new AtomicInteger();
    private final AtomicInteger inFlightSubStreams = new AtomicInteger();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface BufferEntry {
        void runWith(Substream substream);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class BufferSizeTracer extends ClientStreamTracer {
        public long bufferNeeded;
        private final Substream substream;

        public BufferSizeTracer(Substream substream) {
            this.substream = substream;
        }

        @Override // io.grpc.StreamTracer
        public void outboundWireSize(long j10) {
            if (RetriableStream.this.state.winningSubstream != null) {
                return;
            }
            synchronized (RetriableStream.this.lock) {
                if (RetriableStream.this.state.winningSubstream == null && !this.substream.closed) {
                    long j11 = this.bufferNeeded + j10;
                    this.bufferNeeded = j11;
                    if (j11 <= RetriableStream.this.perRpcBufferUsed) {
                        return;
                    }
                    if (this.bufferNeeded > RetriableStream.this.perRpcBufferLimit) {
                        this.substream.bufferLimitExceeded = true;
                    } else {
                        long addAndGet = RetriableStream.this.channelBufferUsed.addAndGet(this.bufferNeeded - RetriableStream.this.perRpcBufferUsed);
                        RetriableStream.this.perRpcBufferUsed = this.bufferNeeded;
                        if (addAndGet > RetriableStream.this.channelBufferLimit) {
                            this.substream.bufferLimitExceeded = true;
                        }
                    }
                    Substream substream = this.substream;
                    Runnable commit = substream.bufferLimitExceeded ? RetriableStream.this.commit(substream) : null;
                    if (commit != null) {
                        commit.run();
                    }
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ChannelBufferMeter {
        private final AtomicLong bufferUsed = new AtomicLong();

        public long addAndGet(long j10) {
            return this.bufferUsed.addAndGet(j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class FutureCanceller {
        public boolean cancelled;
        public Future<?> future;
        public final Object lock;

        public FutureCanceller(Object obj) {
            this.lock = obj;
        }

        public boolean isCancelled() {
            return this.cancelled;
        }

        public Future<?> markCancelled() {
            this.cancelled = true;
            return this.future;
        }

        public void setFuture(Future<?> future) {
            synchronized (this.lock) {
                if (!this.cancelled) {
                    this.future = future;
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class HedgingPlan {
        public final Integer hedgingPushbackMillis;
        public final boolean isHedgeable;

        public HedgingPlan(boolean z10, Integer num) {
            this.isHedgeable = z10;
            this.hedgingPushbackMillis = num;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class HedgingRunnable implements Runnable {
        public final FutureCanceller scheduledHedgingRef;

        public HedgingRunnable(FutureCanceller futureCanceller) {
            this.scheduledHedgingRef = futureCanceller;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetriableStream retriableStream = RetriableStream.this;
            final Substream createSubstream = retriableStream.createSubstream(retriableStream.state.hedgingAttemptCount, false);
            if (createSubstream == null) {
                return;
            }
            RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.HedgingRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    FutureCanceller futureCanceller;
                    boolean z10;
                    synchronized (RetriableStream.this.lock) {
                        futureCanceller = null;
                        z10 = false;
                        if (HedgingRunnable.this.scheduledHedgingRef.isCancelled()) {
                            z10 = true;
                        } else {
                            RetriableStream retriableStream2 = RetriableStream.this;
                            retriableStream2.state = retriableStream2.state.addActiveHedge(createSubstream);
                            RetriableStream retriableStream3 = RetriableStream.this;
                            if (retriableStream3.hasPotentialHedging(retriableStream3.state) && (RetriableStream.this.throttle == null || RetriableStream.this.throttle.isAboveThreshold())) {
                                RetriableStream retriableStream4 = RetriableStream.this;
                                futureCanceller = new FutureCanceller(retriableStream4.lock);
                                retriableStream4.scheduledHedging = futureCanceller;
                            } else {
                                RetriableStream retriableStream5 = RetriableStream.this;
                                retriableStream5.state = retriableStream5.state.freezeHedging();
                                RetriableStream.this.scheduledHedging = null;
                            }
                        }
                    }
                    if (z10) {
                        createSubstream.stream.start(new Sublistener(createSubstream));
                        createSubstream.stream.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                    } else {
                        if (futureCanceller != null) {
                            futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), RetriableStream.this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
                        }
                        RetriableStream.this.drain(createSubstream);
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class RetryPlan {
        public final long backoffNanos;
        public final boolean shouldRetry;

        public RetryPlan(boolean z10, long j10) {
            this.shouldRetry = z10;
            this.backoffNanos = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SavedCloseMasterListenerReason {
        private final Metadata metadata;
        private final ClientStreamListener.RpcProgress progress;
        private final Status status;

        public SavedCloseMasterListenerReason(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            this.status = status;
            this.progress = rpcProgress;
            this.metadata = metadata;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class StartEntry implements BufferEntry {
        public StartEntry() {
        }

        @Override // io.grpc.internal.RetriableStream.BufferEntry
        public void runWith(Substream substream) {
            substream.stream.start(new Sublistener(substream));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class State {
        public final Collection<Substream> activeHedges;
        public final List<BufferEntry> buffer;
        public final boolean cancelled;
        public final Collection<Substream> drainedSubstreams;
        public final int hedgingAttemptCount;
        public final boolean hedgingFrozen;
        public final boolean passThrough;
        public final Substream winningSubstream;

        public State(List<BufferEntry> list, Collection<Substream> collection, Collection<Substream> collection2, Substream substream, boolean z10, boolean z11, boolean z12, int i10) {
            this.buffer = list;
            this.drainedSubstreams = (Collection) o.s(collection, "drainedSubstreams");
            this.winningSubstream = substream;
            this.activeHedges = collection2;
            this.cancelled = z10;
            this.passThrough = z11;
            this.hedgingFrozen = z12;
            this.hedgingAttemptCount = i10;
            o.y(!z11 || list == null, "passThrough should imply buffer is null");
            o.y((z11 && substream == null) ? false : true, "passThrough should imply winningSubstream != null");
            o.y(!z11 || (collection.size() == 1 && collection.contains(substream)) || (collection.size() == 0 && substream.closed), "passThrough should imply winningSubstream is drained");
            o.y((z10 && substream == null) ? false : true, "cancelled should imply committed");
        }

        public State addActiveHedge(Substream substream) {
            Collection unmodifiableCollection;
            o.y(!this.hedgingFrozen, "hedging frozen");
            o.y(this.winningSubstream == null, "already committed");
            if (this.activeHedges == null) {
                unmodifiableCollection = Collections.singleton(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.activeHedges);
                arrayList.add(substream);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new State(this.buffer, this.drainedSubstreams, unmodifiableCollection, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount + 1);
        }

        public State cancelled() {
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, true, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        public State committed(Substream substream) {
            List<BufferEntry> list;
            Collection emptyList;
            boolean z10;
            o.y(this.winningSubstream == null, "Already committed");
            List<BufferEntry> list2 = this.buffer;
            if (this.drainedSubstreams.contains(substream)) {
                list = null;
                emptyList = Collections.singleton(substream);
                z10 = true;
            } else {
                list = list2;
                emptyList = Collections.emptyList();
                z10 = false;
            }
            return new State(list, emptyList, this.activeHedges, substream, this.cancelled, z10, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        public State freezeHedging() {
            return this.hedgingFrozen ? this : new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, true, this.hedgingAttemptCount);
        }

        public State removeActiveHedge(Substream substream) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        public State replaceActiveHedge(Substream substream, Substream substream2) {
            ArrayList arrayList = new ArrayList(this.activeHedges);
            arrayList.remove(substream);
            arrayList.add(substream2);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(arrayList), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        public State substreamClosed(Substream substream) {
            substream.closed = true;
            if (!this.drainedSubstreams.contains(substream)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.drainedSubstreams);
            arrayList.remove(substream);
            return new State(this.buffer, Collections.unmodifiableCollection(arrayList), this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        public State substreamDrained(Substream substream) {
            Collection unmodifiableCollection;
            o.y(!this.passThrough, "Already passThrough");
            if (substream.closed) {
                unmodifiableCollection = this.drainedSubstreams;
            } else if (this.drainedSubstreams.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.drainedSubstreams);
                arrayList.add(substream);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            Substream substream2 = this.winningSubstream;
            boolean z10 = substream2 != null;
            List<BufferEntry> list = this.buffer;
            if (z10) {
                o.y(substream2 == substream, "Another RPC attempt has already committed");
                list = null;
            }
            return new State(list, collection, this.activeHedges, this.winningSubstream, this.cancelled, z10, this.hedgingFrozen, this.hedgingAttemptCount);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class Sublistener implements ClientStreamListener {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final Substream substream;

        public Sublistener(Substream substream) {
            this.substream = substream;
        }

        private Integer getPushbackMills(Metadata metadata) {
            String str = (String) metadata.get(RetriableStream.GRPC_RETRY_PUSHBACK_MS);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        private HedgingPlan makeHedgingDecision(Status status, Metadata metadata) {
            Integer pushbackMills = getPushbackMills(metadata);
            boolean z10 = !RetriableStream.this.hedgingPolicy.nonFatalStatusCodes.contains(status.getCode());
            return new HedgingPlan((z10 || ((RetriableStream.this.throttle == null || (z10 && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold() ^ true)) ? false : true, pushbackMills);
        }

        private RetryPlan makeRetryDecision(Status status, Metadata metadata) {
            long j10 = 0;
            boolean z10 = false;
            if (RetriableStream.this.retryPolicy == null) {
                return new RetryPlan(false, 0L);
            }
            boolean contains = RetriableStream.this.retryPolicy.retryableStatusCodes.contains(status.getCode());
            Integer pushbackMills = getPushbackMills(metadata);
            boolean z11 = (RetriableStream.this.throttle == null || (!contains && (pushbackMills == null || pushbackMills.intValue() >= 0))) ? false : !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            if (RetriableStream.this.retryPolicy.maxAttempts > this.substream.previousAttemptCount + 1 && !z11) {
                if (pushbackMills == null) {
                    if (contains) {
                        j10 = (long) (RetriableStream.this.nextBackoffIntervalNanos * RetriableStream.random.nextDouble());
                        RetriableStream.this.nextBackoffIntervalNanos = Math.min((long) (r10.nextBackoffIntervalNanos * RetriableStream.this.retryPolicy.backoffMultiplier), RetriableStream.this.retryPolicy.maxBackoffNanos);
                        z10 = true;
                    }
                } else if (pushbackMills.intValue() >= 0) {
                    j10 = TimeUnit.MILLISECONDS.toNanos(pushbackMills.intValue());
                    RetriableStream retriableStream = RetriableStream.this;
                    retriableStream.nextBackoffIntervalNanos = retriableStream.retryPolicy.initialBackoffNanos;
                    z10 = true;
                }
            }
            return new RetryPlan(z10, j10);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            FutureCanceller futureCanceller;
            synchronized (RetriableStream.this.lock) {
                RetriableStream retriableStream = RetriableStream.this;
                retriableStream.state = retriableStream.state.substreamClosed(this.substream);
                RetriableStream.this.closedSubstreamsInsight.append(status.getCode());
            }
            if (RetriableStream.this.inFlightSubStreams.decrementAndGet() == Integer.MIN_VALUE) {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.isClosed = true;
                        RetriableStream.this.masterListener.closed(RetriableStream.this.savedCloseMasterListenerReason.status, RetriableStream.this.savedCloseMasterListenerReason.progress, RetriableStream.this.savedCloseMasterListenerReason.metadata);
                    }
                });
                return;
            }
            Substream substream = this.substream;
            if (substream.bufferLimitExceeded) {
                RetriableStream.this.commitAndRun(substream);
                if (RetriableStream.this.state.winningSubstream == this.substream) {
                    RetriableStream.this.safeCloseMasterListener(status, rpcProgress, metadata);
                    return;
                }
                return;
            }
            ClientStreamListener.RpcProgress rpcProgress2 = ClientStreamListener.RpcProgress.MISCARRIED;
            if (rpcProgress == rpcProgress2 && RetriableStream.this.localOnlyTransparentRetries.incrementAndGet() > 1000) {
                RetriableStream.this.commitAndRun(this.substream);
                if (RetriableStream.this.state.winningSubstream == this.substream) {
                    RetriableStream.this.safeCloseMasterListener(Status.INTERNAL.withDescription("Too many transparent retries. Might be a bug in gRPC").withCause(status.asRuntimeException()), rpcProgress, metadata);
                    return;
                }
                return;
            }
            if (RetriableStream.this.state.winningSubstream == null) {
                boolean z10 = false;
                if (rpcProgress != rpcProgress2 && (rpcProgress != ClientStreamListener.RpcProgress.REFUSED || !RetriableStream.this.noMoreTransparentRetry.compareAndSet(false, true))) {
                    if (rpcProgress == ClientStreamListener.RpcProgress.DROPPED) {
                        if (RetriableStream.this.isHedging) {
                            RetriableStream.this.freezeHedging();
                        }
                    } else {
                        RetriableStream.this.noMoreTransparentRetry.set(true);
                        if (RetriableStream.this.isHedging) {
                            HedgingPlan makeHedgingDecision = makeHedgingDecision(status, metadata);
                            if (makeHedgingDecision.isHedgeable) {
                                RetriableStream.this.pushbackHedging(makeHedgingDecision.hedgingPushbackMillis);
                            }
                            synchronized (RetriableStream.this.lock) {
                                RetriableStream retriableStream2 = RetriableStream.this;
                                retriableStream2.state = retriableStream2.state.removeActiveHedge(this.substream);
                                if (makeHedgingDecision.isHedgeable) {
                                    RetriableStream retriableStream3 = RetriableStream.this;
                                    if (retriableStream3.hasPotentialHedging(retriableStream3.state) || !RetriableStream.this.state.activeHedges.isEmpty()) {
                                        return;
                                    }
                                }
                            }
                        } else {
                            RetryPlan makeRetryDecision = makeRetryDecision(status, metadata);
                            if (makeRetryDecision.shouldRetry) {
                                final Substream createSubstream = RetriableStream.this.createSubstream(this.substream.previousAttemptCount + 1, false);
                                if (createSubstream == null) {
                                    return;
                                }
                                synchronized (RetriableStream.this.lock) {
                                    RetriableStream retriableStream4 = RetriableStream.this;
                                    futureCanceller = new FutureCanceller(retriableStream4.lock);
                                    retriableStream4.scheduledRetry = futureCanceller;
                                }
                                futureCanceller.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1RetryBackoffRunnable
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1RetryBackoffRunnable.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                C1RetryBackoffRunnable c1RetryBackoffRunnable = C1RetryBackoffRunnable.this;
                                                RetriableStream.this.drain(createSubstream);
                                            }
                                        });
                                    }
                                }, makeRetryDecision.backoffNanos, TimeUnit.NANOSECONDS));
                                return;
                            }
                        }
                    }
                } else {
                    final Substream createSubstream2 = RetriableStream.this.createSubstream(this.substream.previousAttemptCount, true);
                    if (createSubstream2 == null) {
                        return;
                    }
                    if (RetriableStream.this.isHedging) {
                        synchronized (RetriableStream.this.lock) {
                            RetriableStream retriableStream5 = RetriableStream.this;
                            retriableStream5.state = retriableStream5.state.replaceActiveHedge(this.substream, createSubstream2);
                            RetriableStream retriableStream6 = RetriableStream.this;
                            if (!retriableStream6.hasPotentialHedging(retriableStream6.state) && RetriableStream.this.state.activeHedges.size() == 1) {
                                z10 = true;
                            }
                        }
                        if (z10) {
                            RetriableStream.this.commitAndRun(createSubstream2);
                        }
                    } else if (RetriableStream.this.retryPolicy == null || RetriableStream.this.retryPolicy.maxAttempts == 1) {
                        RetriableStream.this.commitAndRun(createSubstream2);
                    }
                    RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RetriableStream.this.drain(createSubstream2);
                        }
                    });
                    return;
                }
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                RetriableStream.this.safeCloseMasterListener(status, rpcProgress, metadata);
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            if (this.substream.previousAttemptCount > 0) {
                Metadata.Key<String> key = RetriableStream.GRPC_PREVIOUS_RPC_ATTEMPTS;
                metadata.discardAll(key);
                metadata.put(key, String.valueOf(this.substream.previousAttemptCount));
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                if (RetriableStream.this.throttle != null) {
                    RetriableStream.this.throttle.onSuccess();
                }
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.masterListener.headersRead(metadata);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            State state = RetriableStream.this.state;
            o.y(state.winningSubstream != null, "Headers should be received prior to messages.");
            if (state.winningSubstream != this.substream) {
                GrpcUtil.closeQuietly(messageProducer);
            } else {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RetriableStream.this.masterListener.messagesAvailable(messageProducer);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (RetriableStream.this.isReady()) {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.Sublistener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RetriableStream.this.isClosed) {
                            return;
                        }
                        RetriableStream.this.masterListener.onReady();
                    }
                });
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Substream {
        public boolean bufferLimitExceeded;
        public boolean closed;
        public final int previousAttemptCount;
        public ClientStream stream;

        public Substream(int i10) {
            this.previousAttemptCount = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Throttle {
        private static final int THREE_DECIMAL_PLACES_SCALE_UP = 1000;
        public final int maxTokens;
        public final int threshold;
        public final AtomicInteger tokenCount;
        public final int tokenRatio;

        public Throttle(float f10, float f11) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.tokenCount = atomicInteger;
            this.tokenRatio = (int) (f11 * 1000.0f);
            int i10 = (int) (f10 * 1000.0f);
            this.maxTokens = i10;
            this.threshold = i10 / 2;
            atomicInteger.set(i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Throttle)) {
                return false;
            }
            Throttle throttle = (Throttle) obj;
            return this.maxTokens == throttle.maxTokens && this.tokenRatio == throttle.tokenRatio;
        }

        public int hashCode() {
            return l.b(Integer.valueOf(this.maxTokens), Integer.valueOf(this.tokenRatio));
        }

        public boolean isAboveThreshold() {
            return this.tokenCount.get() > this.threshold;
        }

        public boolean onQualifiedFailureThenCheckIsAboveThreshold() {
            int i10;
            int i11;
            do {
                i10 = this.tokenCount.get();
                if (i10 == 0) {
                    return false;
                }
                i11 = i10 - 1000;
            } while (!this.tokenCount.compareAndSet(i10, Math.max(i11, 0)));
            return i11 > this.threshold;
        }

        public void onSuccess() {
            int i10;
            int i11;
            do {
                i10 = this.tokenCount.get();
                i11 = this.maxTokens;
                if (i10 == i11) {
                    return;
                }
            } while (!this.tokenCount.compareAndSet(i10, Math.min(this.tokenRatio + i10, i11)));
        }
    }

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.of("grpc-previous-rpc-attempts", asciiMarshaller);
        GRPC_RETRY_PUSHBACK_MS = Metadata.Key.of("grpc-retry-pushback-ms", asciiMarshaller);
        CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
        random = new Random();
    }

    public RetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, Metadata metadata, ChannelBufferMeter channelBufferMeter, long j10, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService, RetryPolicy retryPolicy, HedgingPolicy hedgingPolicy, Throttle throttle) {
        this.method = methodDescriptor;
        this.channelBufferUsed = channelBufferMeter;
        this.perRpcBufferLimit = j10;
        this.channelBufferLimit = j11;
        this.callExecutor = executor;
        this.scheduledExecutorService = scheduledExecutorService;
        this.headers = metadata;
        this.retryPolicy = retryPolicy;
        if (retryPolicy != null) {
            this.nextBackoffIntervalNanos = retryPolicy.initialBackoffNanos;
        }
        this.hedgingPolicy = hedgingPolicy;
        o.e(retryPolicy == null || hedgingPolicy == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.isHedging = hedgingPolicy != null;
        this.throttle = throttle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable commit(final Substream substream) {
        final Future<?> future;
        final Future<?> future2;
        synchronized (this.lock) {
            if (this.state.winningSubstream != null) {
                return null;
            }
            final Collection<Substream> collection = this.state.drainedSubstreams;
            this.state = this.state.committed(substream);
            this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
            FutureCanceller futureCanceller = this.scheduledRetry;
            if (futureCanceller != null) {
                Future<?> markCancelled = futureCanceller.markCancelled();
                this.scheduledRetry = null;
                future = markCancelled;
            } else {
                future = null;
            }
            FutureCanceller futureCanceller2 = this.scheduledHedging;
            if (futureCanceller2 != null) {
                Future<?> markCancelled2 = futureCanceller2.markCancelled();
                this.scheduledHedging = null;
                future2 = markCancelled2;
            } else {
                future2 = null;
            }
            return new Runnable() { // from class: io.grpc.internal.RetriableStream.1CommitTask
                @Override // java.lang.Runnable
                public void run() {
                    for (Substream substream2 : collection) {
                        if (substream2 != substream) {
                            substream2.stream.cancel(RetriableStream.CANCELLED_BECAUSE_COMMITTED);
                        }
                    }
                    Future future3 = future;
                    if (future3 != null) {
                        future3.cancel(false);
                    }
                    Future future4 = future2;
                    if (future4 != null) {
                        future4.cancel(false);
                    }
                    RetriableStream.this.postCommit();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitAndRun(Substream substream) {
        Runnable commit = commit(substream);
        if (commit != null) {
            commit.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Substream createSubstream(int i10, boolean z10) {
        int i11;
        do {
            i11 = this.inFlightSubStreams.get();
            if (i11 < 0) {
                return null;
            }
        } while (!this.inFlightSubStreams.compareAndSet(i11, i11 + 1));
        Substream substream = new Substream(i10);
        final BufferSizeTracer bufferSizeTracer = new BufferSizeTracer(substream);
        substream.stream = newSubstream(updateHeaders(this.headers, i10), new ClientStreamTracer.Factory() { // from class: io.grpc.internal.RetriableStream.2
            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                return bufferSizeTracer;
            }
        }, i10, z10);
        return substream;
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> collection;
        synchronized (this.lock) {
            if (!this.state.passThrough) {
                this.state.buffer.add(bufferEntry);
            }
            collection = this.state.drainedSubstreams;
        }
        Iterator<Substream> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            bufferEntry.runWith(iterator2.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        r8.listenerSerializeExecutor.execute(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (r2 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        r9.stream.start(new io.grpc.internal.RetriableStream.Sublistener(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        r0 = r9.stream;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
    
        if (r8.state.winningSubstream != r9) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r9 = r8.cancellationStatus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r0.cancel(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        r9 = io.grpc.internal.RetriableStream.CANCELLED_BECAUSE_COMMITTED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
    
        r1 = r3.iterator2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
    
        if (r1.hasNext() == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        r4 = (io.grpc.internal.RetriableStream.BufferEntry) r1.next();
        r4.runWith(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
    
        if ((r4 instanceof io.grpc.internal.RetriableStream.StartEntry) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009d, code lost:
    
        r4 = r8.state;
        r5 = r4.winningSubstream;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a1, code lost:
    
        if (r5 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
    
        if (r5 == r9) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a8, code lost:
    
        if (r4.cancelled == false) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drain(io.grpc.internal.RetriableStream.Substream r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r3 = r0
            r2 = 0
        L4:
            java.lang.Object r4 = r8.lock
            monitor-enter(r4)
            io.grpc.internal.RetriableStream$State r5 = r8.state     // Catch: java.lang.Throwable -> Lad
            io.grpc.internal.RetriableStream$Substream r6 = r5.winningSubstream     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto L11
            if (r6 == r9) goto L11
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lad
            goto L33
        L11:
            boolean r6 = r5.cancelled     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto L17
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lad
            goto L33
        L17:
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r6 = r5.buffer     // Catch: java.lang.Throwable -> Lad
            int r6 = r6.size()     // Catch: java.lang.Throwable -> Lad
            if (r1 != r6) goto L58
            io.grpc.internal.RetriableStream$State r0 = r5.substreamDrained(r9)     // Catch: java.lang.Throwable -> Lad
            r8.state = r0     // Catch: java.lang.Throwable -> Lad
            boolean r0 = r8.isReady()     // Catch: java.lang.Throwable -> Lad
            if (r0 != 0) goto L2d
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lad
            return
        L2d:
            io.grpc.internal.RetriableStream$3 r0 = new io.grpc.internal.RetriableStream$3     // Catch: java.lang.Throwable -> Lad
            r0.<init>()     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lad
        L33:
            if (r0 == 0) goto L3b
            java.util.concurrent.Executor r9 = r8.listenerSerializeExecutor
            r9.execute(r0)
            return
        L3b:
            if (r2 != 0) goto L47
            io.grpc.internal.ClientStream r0 = r9.stream
            io.grpc.internal.RetriableStream$Sublistener r1 = new io.grpc.internal.RetriableStream$Sublistener
            r1.<init>(r9)
            r0.start(r1)
        L47:
            io.grpc.internal.ClientStream r0 = r9.stream
            io.grpc.internal.RetriableStream$State r1 = r8.state
            io.grpc.internal.RetriableStream$Substream r1 = r1.winningSubstream
            if (r1 != r9) goto L52
            io.grpc.Status r9 = r8.cancellationStatus
            goto L54
        L52:
            io.grpc.Status r9 = io.grpc.internal.RetriableStream.CANCELLED_BECAUSE_COMMITTED
        L54:
            r0.cancel(r9)
            return
        L58:
            boolean r6 = r9.closed     // Catch: java.lang.Throwable -> Lad
            if (r6 == 0) goto L5e
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lad
            return
        L5e:
            int r6 = r1 + 128
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r7 = r5.buffer     // Catch: java.lang.Throwable -> Lad
            int r7 = r7.size()     // Catch: java.lang.Throwable -> Lad
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> Lad
            if (r3 != 0) goto L78
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lad
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r5 = r5.buffer     // Catch: java.lang.Throwable -> Lad
            java.util.List r1 = r5.subList(r1, r6)     // Catch: java.lang.Throwable -> Lad
            r3.<init>(r1)     // Catch: java.lang.Throwable -> Lad
            goto L84
        L78:
            r3.clear()     // Catch: java.lang.Throwable -> Lad
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r5 = r5.buffer     // Catch: java.lang.Throwable -> Lad
            java.util.List r1 = r5.subList(r1, r6)     // Catch: java.lang.Throwable -> Lad
            r3.addAll(r1)     // Catch: java.lang.Throwable -> Lad
        L84:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lad
            java.util.Iterator r1 = r3.iterator2()
        L89:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto Laa
            java.lang.Object r4 = r1.next()
            io.grpc.internal.RetriableStream$BufferEntry r4 = (io.grpc.internal.RetriableStream.BufferEntry) r4
            r4.runWith(r9)
            boolean r4 = r4 instanceof io.grpc.internal.RetriableStream.StartEntry
            if (r4 == 0) goto L9d
            r2 = 1
        L9d:
            io.grpc.internal.RetriableStream$State r4 = r8.state
            io.grpc.internal.RetriableStream$Substream r5 = r4.winningSubstream
            if (r5 == 0) goto La6
            if (r5 == r9) goto La6
            goto Laa
        La6:
            boolean r4 = r4.cancelled
            if (r4 == 0) goto L89
        Laa:
            r1 = r6
            goto L4
        Lad:
            r9 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lad
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.drain(io.grpc.internal.RetriableStream$Substream):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freezeHedging() {
        Future<?> future;
        synchronized (this.lock) {
            FutureCanceller futureCanceller = this.scheduledHedging;
            future = null;
            if (futureCanceller != null) {
                Future<?> markCancelled = futureCanceller.markCancelled();
                this.scheduledHedging = null;
                future = markCancelled;
            }
            this.state = this.state.freezeHedging();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPotentialHedging(State state) {
        return state.winningSubstream == null && state.hedgingAttemptCount < this.hedgingPolicy.maxAttempts && !state.hedgingFrozen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushbackHedging(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            freezeHedging();
            return;
        }
        synchronized (this.lock) {
            FutureCanceller futureCanceller = this.scheduledHedging;
            if (futureCanceller == null) {
                return;
            }
            Future<?> markCancelled = futureCanceller.markCancelled();
            FutureCanceller futureCanceller2 = new FutureCanceller(this.lock);
            this.scheduledHedging = futureCanceller2;
            if (markCancelled != null) {
                markCancelled.cancel(false);
            }
            futureCanceller2.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller2), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeCloseMasterListener(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
        this.savedCloseMasterListenerReason = new SavedCloseMasterListenerReason(status, rpcProgress, metadata);
        if (this.inFlightSubStreams.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.listenerSerializeExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.4
                @Override // java.lang.Runnable
                public void run() {
                    RetriableStream.this.isClosed = true;
                    RetriableStream.this.masterListener.closed(status, rpcProgress, metadata);
                }
            });
        }
    }

    public static void setRandom(Random random2) {
        random = random2;
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        State state;
        synchronized (this.lock) {
            insightBuilder.appendKeyValue("closed", this.closedSubstreamsInsight);
            state = this.state;
        }
        if (state.winningSubstream != null) {
            InsightBuilder insightBuilder2 = new InsightBuilder();
            state.winningSubstream.stream.appendTimeoutInsight(insightBuilder2);
            insightBuilder.appendKeyValue("committed", insightBuilder2);
            return;
        }
        InsightBuilder insightBuilder3 = new InsightBuilder();
        for (Substream substream : state.drainedSubstreams) {
            InsightBuilder insightBuilder4 = new InsightBuilder();
            substream.stream.appendTimeoutInsight(insightBuilder4);
            insightBuilder3.append(insightBuilder4);
        }
        insightBuilder.appendKeyValue("open", insightBuilder3);
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status status) {
        Substream substream = new Substream(0);
        substream.stream = new NoopClientStream();
        Runnable commit = commit(substream);
        if (commit != null) {
            synchronized (this.lock) {
                this.state = this.state.substreamDrained(substream);
            }
            commit.run();
            safeCloseMasterListener(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
            return;
        }
        Substream substream2 = null;
        synchronized (this.lock) {
            if (this.state.drainedSubstreams.contains(this.state.winningSubstream)) {
                substream2 = this.state.winningSubstream;
            } else {
                this.cancellationStatus = status;
            }
            this.state = this.state.cancelled();
        }
        if (substream2 != null) {
            substream2.stream.cancel(status);
        }
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.flush();
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FlushEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final Attributes getAttributes() {
        if (this.state.winningSubstream != null) {
            return this.state.winningSubstream.stream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1HalfCloseEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final boolean isReady() {
        Iterator<Substream> iterator2 = this.state.drainedSubstreams.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().stream.isReady()) {
                return true;
            }
        }
        return false;
    }

    public abstract ClientStream newSubstream(Metadata metadata, ClientStreamTracer.Factory factory, int i10, boolean z10);

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1OptimizeDirectEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.optimizeForDirectExecutor();
            }
        });
    }

    public abstract void postCommit();

    public abstract Status prestart();

    @Override // io.grpc.internal.Stream
    public final void request(final int i10) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.request(i10);
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1RequestEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.request(i10);
                }
            });
        }
    }

    public final void sendMessage(final ReqT reqt) {
        State state = this.state;
        if (state.passThrough) {
            state.winningSubstream.stream.writeMessage(this.method.streamRequest(reqt));
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1SendMessageEntry
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.stream.writeMessage(RetriableStream.this.method.streamRequest(reqt));
                    substream.stream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void setAuthority(final String str) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1AuthorityEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(final Compressor compressor) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1CompressorEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDeadline(final Deadline deadline) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DeadlineEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1DecompressorRegistryEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(final boolean z10) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1FullStreamDecompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setFullStreamDecompression(z10);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxInboundMessageSize(final int i10) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxInboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxInboundMessageSize(i10);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxOutboundMessageSize(final int i10) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MaxOutboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMaxOutboundMessageSize(i10);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(final boolean z10) {
        delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1MessageCompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.stream.setMessageCompression(z10);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener clientStreamListener) {
        Throttle throttle;
        this.masterListener = clientStreamListener;
        Status prestart = prestart();
        if (prestart != null) {
            cancel(prestart);
            return;
        }
        synchronized (this.lock) {
            this.state.buffer.add(new StartEntry());
        }
        Substream createSubstream = createSubstream(0, false);
        if (createSubstream == null) {
            return;
        }
        if (this.isHedging) {
            FutureCanceller futureCanceller = null;
            synchronized (this.lock) {
                this.state = this.state.addActiveHedge(createSubstream);
                if (hasPotentialHedging(this.state) && ((throttle = this.throttle) == null || throttle.isAboveThreshold())) {
                    futureCanceller = new FutureCanceller(this.lock);
                    this.scheduledHedging = futureCanceller;
                }
            }
            if (futureCanceller != null) {
                futureCanceller.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
            }
        }
        drain(createSubstream);
    }

    public final Metadata updateHeaders(Metadata metadata, int i10) {
        Metadata metadata2 = new Metadata();
        metadata2.merge(metadata);
        if (i10 > 0) {
            metadata2.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(i10));
        }
        return metadata2;
    }

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }
}
