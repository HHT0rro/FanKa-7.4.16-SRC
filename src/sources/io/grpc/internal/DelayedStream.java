package io.grpc.internal;

import com.google.common.base.o;
import com.huawei.openalliance.ad.constant.bg;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class DelayedStream implements ClientStream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private DelayedStreamListener delayedListener;
    private Status error;
    private ClientStreamListener listener;
    private volatile boolean passThrough;
    private List<Runnable> pendingCalls = new ArrayList();
    private List<Runnable> preStartPendingCalls = new ArrayList();
    private ClientStream realStream;
    private long startTimeNanos;
    private long streamSetTimeNanos;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class DelayedStreamListener implements ClientStreamListener {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientStreamListener realListener;

        public DelayedStreamListener(ClientStreamListener clientStreamListener) {
            this.realListener = clientStreamListener;
        }

        private void delayOrExecute(Runnable runnable) {
            synchronized (this) {
                if (!this.passThrough) {
                    this.pendingCallbacks.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, rpcProgress, metadata);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainPendingCallbacks() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    if (this.pendingCallbacks.isEmpty()) {
                        this.pendingCallbacks = null;
                        this.passThrough = true;
                        return;
                    } else {
                        list = this.pendingCallbacks;
                        this.pendingCallbacks = arrayList;
                    }
                }
                Iterator iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    ((Runnable) iterator2.next()).run();
                }
                list.clear();
                arrayList = list;
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.headersRead(metadata);
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            if (this.passThrough) {
                this.realListener.messagesAvailable(messageProducer);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.messagesAvailable(messageProducer);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.onReady();
                    }
                });
            }
        }
    }

    private void delayOrExecute(Runnable runnable) {
        o.y(this.listener != null, "May only be called after start");
        synchronized (this) {
            if (!this.passThrough) {
                this.pendingCalls.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        r0 = r1.iterator2();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drainPendingCalls() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.pendingCalls     // Catch: java.lang.Throwable -> L3b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L1d
            r0 = 0
            r3.pendingCalls = r0     // Catch: java.lang.Throwable -> L3b
            r0 = 1
            r3.passThrough = r0     // Catch: java.lang.Throwable -> L3b
            io.grpc.internal.DelayedStream$DelayedStreamListener r0 = r3.delayedListener     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L1c
            r0.drainPendingCallbacks()
        L1c:
            return
        L1d:
            java.util.List<java.lang.Runnable> r1 = r3.pendingCalls     // Catch: java.lang.Throwable -> L3b
            r3.pendingCalls = r0     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            java.util.Iterator r0 = r1.iterator2()
        L26:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L36
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L26
        L36:
            r1.clear()
            r0 = r1
            goto L5
        L3b:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DelayedStream.drainPendingCalls():void");
    }

    private void internalStart(ClientStreamListener clientStreamListener) {
        Iterator<Runnable> iterator2 = this.preStartPendingCalls.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().run();
        }
        this.preStartPendingCalls = null;
        this.realStream.start(clientStreamListener);
    }

    private void setRealStream(ClientStream clientStream) {
        ClientStream clientStream2 = this.realStream;
        o.B(clientStream2 == null, "realStream already set to %s", clientStream2);
        this.realStream = clientStream;
        this.streamSetTimeNanos = System.nanoTime();
    }

    @Override // io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        synchronized (this) {
            if (this.listener == null) {
                return;
            }
            if (this.realStream != null) {
                insightBuilder.appendKeyValue("buffered_nanos", Long.valueOf(this.streamSetTimeNanos - this.startTimeNanos));
                this.realStream.appendTimeoutInsight(insightBuilder);
            } else {
                insightBuilder.appendKeyValue("buffered_nanos", Long.valueOf(System.nanoTime() - this.startTimeNanos));
                insightBuilder.append("waiting_for_connection");
            }
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(final Status status) {
        boolean z10 = true;
        o.y(this.listener != null, "May only be called after start");
        o.s(status, "reason");
        synchronized (this) {
            if (this.realStream == null) {
                setRealStream(NoopClientStream.INSTANCE);
                this.error = status;
                z10 = false;
            }
        }
        if (z10) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.8
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.cancel(status);
                }
            });
            return;
        }
        drainPendingCalls();
        onEarlyCancellation(status);
        this.listener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
        o.y(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.flush();
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.7
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        ClientStream clientStream;
        synchronized (this) {
            clientStream = this.realStream;
        }
        if (clientStream != null) {
            return clientStream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    public ClientStream getRealStream() {
        return this.realStream;
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        o.y(this.listener != null, "May only be called after start");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.9
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        if (this.passThrough) {
            return this.realStream.isReady();
        }
        return false;
    }

    public void onEarlyCancellation(Status status) {
    }

    @Override // io.grpc.internal.Stream
    public void optimizeForDirectExecutor() {
        o.y(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.11
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.optimizeForDirectExecutor();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void request(final int i10) {
        o.y(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.request(i10);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.10
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.request(i10);
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(final String str) {
        o.y(this.listener == null, "May only be called before start");
        o.s(str, "authority");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.5
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(final Compressor compressor) {
        o.y(this.listener == null, "May only be called before start");
        o.s(compressor, "compressor");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.12
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDeadline(final Deadline deadline) {
        o.y(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.3
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        o.y(this.listener == null, "May only be called before start");
        o.s(decompressorRegistry, "decompressorRegistry");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.14
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setFullStreamDecompression(final boolean z10) {
        o.y(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.13
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setFullStreamDecompression(z10);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxInboundMessageSize(final int i10) {
        o.y(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.1
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setMaxInboundMessageSize(i10);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public void setMaxOutboundMessageSize(final int i10) {
        o.y(this.listener == null, "May only be called before start");
        this.preStartPendingCalls.add(new Runnable() { // from class: io.grpc.internal.DelayedStream.2
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setMaxOutboundMessageSize(i10);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(final boolean z10) {
        o.y(this.listener != null, "May only be called after start");
        if (this.passThrough) {
            this.realStream.setMessageCompression(z10);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.15
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.setMessageCompression(z10);
                }
            });
        }
    }

    public final Runnable setStream(ClientStream clientStream) {
        synchronized (this) {
            if (this.realStream != null) {
                return null;
            }
            setRealStream((ClientStream) o.s(clientStream, "stream"));
            ClientStreamListener clientStreamListener = this.listener;
            if (clientStreamListener == null) {
                this.pendingCalls = null;
                this.passThrough = true;
            }
            if (clientStreamListener == null) {
                return null;
            }
            internalStart(clientStreamListener);
            return new Runnable() { // from class: io.grpc.internal.DelayedStream.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.drainPendingCalls();
                }
            };
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        Status status;
        boolean z10;
        o.s(clientStreamListener, bg.e.f32299p);
        o.y(this.listener == null, "already started");
        synchronized (this) {
            status = this.error;
            z10 = this.passThrough;
            if (!z10) {
                DelayedStreamListener delayedStreamListener = new DelayedStreamListener(clientStreamListener);
                this.delayedListener = delayedStreamListener;
                clientStreamListener = delayedStreamListener;
            }
            this.listener = clientStreamListener;
            this.startTimeNanos = System.nanoTime();
        }
        if (status != null) {
            clientStreamListener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
        } else if (z10) {
            internalStart(clientStreamListener);
        }
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(final InputStream inputStream) {
        o.y(this.listener != null, "May only be called after start");
        o.s(inputStream, "message");
        if (this.passThrough) {
            this.realStream.writeMessage(inputStream);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.6
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.writeMessage(inputStream);
                }
            });
        }
    }
}
