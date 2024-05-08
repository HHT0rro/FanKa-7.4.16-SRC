package com.tencent.cloud.huiyansdkface.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    public static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0015, code lost:
        
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.awaitTimeout()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r2 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout asyncTimeout = head.next;
        long nanoTime = System.nanoTime();
        if (asyncTimeout == null) {
            AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
        if (remainingNanos > 0) {
            long j10 = remainingNanos / 1000000;
            AsyncTimeout.class.wait(j10, (int) (remainingNanos - (1000000 * j10)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000b, code lost:
    
        r1.next = r3.next;
        r3.next = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized boolean cancelScheduledTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r3) {
        /*
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-enter(r0)
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L19
        L5:
            if (r1 == 0) goto L17
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r2 = r1.next     // Catch: java.lang.Throwable -> L19
            if (r2 != r3) goto L15
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r2 = r3.next     // Catch: java.lang.Throwable -> L19
            r1.next = r2     // Catch: java.lang.Throwable -> L19
            r1 = 0
            r3.next = r1     // Catch: java.lang.Throwable -> L19
            r3 = 0
        L13:
            monitor-exit(r0)
            return r3
        L15:
            r1 = r2
            goto L5
        L17:
            r3 = 1
            goto L13
        L19:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.cancelScheduledTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout):boolean");
    }

    private long remainingNanos(long j10) {
        return this.timeoutAt - j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0016, B:10:0x0022, B:11:0x002b, B:12:0x003a, B:13:0x0040, B:15:0x0044, B:17:0x004d, B:20:0x0050, B:22:0x005a, B:30:0x0034, B:31:0x005f, B:32:0x0064), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void scheduleTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r6, long r7, boolean r9) {
        /*
            java.lang.Class<com.tencent.cloud.huiyansdkface.okio.AsyncTimeout> r0 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.class
            monitor-enter(r0)
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L65
            if (r1 != 0) goto L16
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r1 = new com.tencent.cloud.huiyansdkface.okio.AsyncTimeout     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head = r1     // Catch: java.lang.Throwable -> L65
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout$Watchdog r1 = new com.tencent.cloud.huiyansdkface.okio.AsyncTimeout$Watchdog     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            r1.start()     // Catch: java.lang.Throwable -> L65
        L16:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L65
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L2f
            if (r9 == 0) goto L2f
            long r3 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L65
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L65
        L2b:
            long r7 = r7 + r1
            r6.timeoutAt = r7     // Catch: java.lang.Throwable -> L65
            goto L3a
        L2f:
            if (r5 == 0) goto L32
            goto L2b
        L32:
            if (r9 == 0) goto L5f
            long r7 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L65
            r6.timeoutAt = r7     // Catch: java.lang.Throwable -> L65
        L3a:
            long r7 = r6.remainingNanos(r1)     // Catch: java.lang.Throwable -> L65
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r9 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L65
        L40:
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r3 = r9.next     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L50
            long r3 = r3.remainingNanos(r1)     // Catch: java.lang.Throwable -> L65
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L4d
            goto L50
        L4d:
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r9 = r9.next     // Catch: java.lang.Throwable -> L65
            goto L40
        L50:
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r7 = r9.next     // Catch: java.lang.Throwable -> L65
            r6.next = r7     // Catch: java.lang.Throwable -> L65
            r9.next = r6     // Catch: java.lang.Throwable -> L65
            com.tencent.cloud.huiyansdkface.okio.AsyncTimeout r6 = com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L65
            if (r9 != r6) goto L5d
            r0.notify()     // Catch: java.lang.Throwable -> L65
        L5d:
            monitor-exit(r0)
            return
        L5f:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L65
            r6.<init>()     // Catch: java.lang.Throwable -> L65
            throw r6     // Catch: java.lang.Throwable -> L65
        L65:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.scheduleTimeout(com.tencent.cloud.huiyansdkface.okio.AsyncTimeout, long, boolean):void");
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    public final IOException exit(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    public final void exit(boolean z10) throws IOException {
        if (exit() && z10) {
            throw newTimeoutException(null);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        return new Sink() { // from class: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.1
            @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + ((Object) sink) + ")";
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink
            public void write(Buffer buffer, long j10) throws IOException {
                Util.checkOffsetAndCount(buffer.size, 0L, j10);
                while (true) {
                    long j11 = 0;
                    if (j10 <= 0) {
                        return;
                    }
                    Segment segment = buffer.head;
                    while (true) {
                        if (j11 >= 65536) {
                            break;
                        }
                        j11 += segment.limit - segment.pos;
                        if (j11 >= j10) {
                            j11 = j10;
                            break;
                        }
                        segment = segment.next;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j11);
                            j10 -= j11;
                            AsyncTimeout.this.exit(true);
                        } catch (IOException e2) {
                            throw AsyncTimeout.this.exit(e2);
                        }
                    } catch (Throwable th) {
                        AsyncTimeout.this.exit(false);
                        throw th;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() { // from class: com.tencent.cloud.huiyansdkface.okio.AsyncTimeout.2
            @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Source
            public long read(Buffer buffer, long j10) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        long read = source.read(buffer, j10);
                        AsyncTimeout.this.exit(true);
                        return read;
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Source
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + ((Object) source) + ")";
            }
        };
    }

    public void timedOut() {
    }
}
