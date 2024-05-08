package com.ss.android.socialbase.downloader.reader;

import android.os.Process;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.segment.Buffer;
import com.ss.android.socialbase.downloader.segment.StreamClosedException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AsyncStreamReader implements IStreamReader {
    private static final String TAG = "AsyncStreamReader";
    private int bufferCount;
    private final int bufferSize;
    private volatile boolean closed;
    private final InputStream inputStream;
    private final int maxBufferCount;
    private volatile Future rFuture;
    private Buffer rHead;
    private Buffer rSafe;
    private Buffer rTail;
    private volatile boolean terminated;
    private volatile Throwable throwable;
    private Buffer wHead;
    private Buffer wSafe;
    private Buffer wTail;
    private final Object rLock = new Object();
    private final Object wLock = new Object();
    private final Runnable rRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.reader.AsyncStreamReader.1
        @Override // java.lang.Runnable
        public void run() {
            Buffer dequeueReadBuffer;
            Process.setThreadPriority(10);
            do {
                try {
                    dequeueReadBuffer = AsyncStreamReader.this.dequeueReadBuffer();
                    dequeueReadBuffer.size = AsyncStreamReader.this.inputStream.read(dequeueReadBuffer.data);
                    AsyncStreamReader.this.enqueueWriteBuffer(dequeueReadBuffer);
                } catch (Throwable th) {
                    try {
                        AsyncStreamReader.this.throwable = th;
                        th.printStackTrace();
                        synchronized (AsyncStreamReader.this.wLock) {
                            AsyncStreamReader.this.terminated = true;
                            AsyncStreamReader.this.wLock.notify();
                            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (AsyncStreamReader.this.wLock) {
                            AsyncStreamReader.this.terminated = true;
                            AsyncStreamReader.this.wLock.notify();
                            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
                            throw th2;
                        }
                    }
                }
            } while (dequeueReadBuffer.size != -1);
            synchronized (AsyncStreamReader.this.wLock) {
                AsyncStreamReader.this.terminated = true;
                AsyncStreamReader.this.wLock.notify();
            }
            DownloadUtils.safeClose(AsyncStreamReader.this.inputStream);
        }
    };

    public AsyncStreamReader(InputStream inputStream, int i10, int i11) throws Throwable {
        this.inputStream = inputStream;
        this.bufferSize = i10;
        if (i11 < 1) {
            i11 = 1;
        } else if (i11 > 64) {
            i11 = 64;
        }
        this.maxBufferCount = i11;
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Buffer dequeueReadBuffer() throws StreamClosedException, InterruptedException {
        int i10;
        Buffer buffer = this.rSafe;
        if (buffer != null) {
            if (!this.closed) {
                this.rSafe = buffer.next;
                buffer.next = null;
                return buffer;
            }
            throw new StreamClosedException("");
        }
        synchronized (this.rLock) {
            if (!this.closed) {
                Buffer buffer2 = this.rHead;
                if (buffer2 == null && (i10 = this.bufferCount) < this.maxBufferCount) {
                    this.bufferCount = i10 + 1;
                    return new Buffer(this.bufferSize);
                }
                while (buffer2 == null) {
                    this.rLock.wait();
                    if (!this.closed) {
                        buffer2 = this.rHead;
                    } else {
                        throw new StreamClosedException("");
                    }
                }
                this.rSafe = buffer2.next;
                this.rTail = null;
                this.rHead = null;
                buffer2.next = null;
                return buffer2;
            }
            throw new StreamClosedException("");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
    
        if (r4.terminated == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
    
        handleTerminated();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        r4.wLock.wait();
        r2 = r4.wHead;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
    
        r4.wSafe = r2.next;
        r4.wTail = null;
        r4.wHead = null;
        r2.next = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.segment.Buffer dequeueWriteBuffer() throws com.ss.android.socialbase.downloader.exception.BaseException, java.lang.InterruptedException {
        /*
            r4 = this;
            com.ss.android.socialbase.downloader.segment.Buffer r0 = r4.wSafe
            r1 = 0
            if (r0 == 0) goto Lc
            com.ss.android.socialbase.downloader.segment.Buffer r2 = r0.next
            r4.wSafe = r2
            r0.next = r1
            return r0
        Lc:
            java.lang.Object r0 = r4.wLock
            monitor-enter(r0)
            com.ss.android.socialbase.downloader.segment.Buffer r2 = r4.wHead     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L23
        L13:
            boolean r2 = r4.terminated     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L1a
            r4.handleTerminated()     // Catch: java.lang.Throwable -> L2f
        L1a:
            java.lang.Object r2 = r4.wLock     // Catch: java.lang.Throwable -> L2f
            r2.wait()     // Catch: java.lang.Throwable -> L2f
            com.ss.android.socialbase.downloader.segment.Buffer r2 = r4.wHead     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L13
        L23:
            com.ss.android.socialbase.downloader.segment.Buffer r3 = r2.next     // Catch: java.lang.Throwable -> L2f
            r4.wSafe = r3     // Catch: java.lang.Throwable -> L2f
            r4.wTail = r1     // Catch: java.lang.Throwable -> L2f
            r4.wHead = r1     // Catch: java.lang.Throwable -> L2f
            r2.next = r1     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2f
            return r2
        L2f:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.reader.AsyncStreamReader.dequeueWriteBuffer():com.ss.android.socialbase.downloader.segment.Buffer");
    }

    private void enqueueReadBuffer(Buffer buffer) {
        synchronized (this.rLock) {
            Buffer buffer2 = this.rTail;
            if (buffer2 == null) {
                this.rTail = buffer;
                this.rHead = buffer;
                this.rLock.notify();
            } else {
                buffer2.next = buffer;
                this.rTail = buffer;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueWriteBuffer(Buffer buffer) {
        synchronized (this.wLock) {
            Buffer buffer2 = this.wTail;
            if (buffer2 == null) {
                this.wTail = buffer;
                this.wHead = buffer;
                this.wLock.notify();
            } else {
                buffer2.next = buffer;
                this.wTail = buffer;
            }
        }
    }

    private void handleTerminated() throws BaseException {
        Throwable th = this.throwable;
        if (th != null) {
            if (th instanceof StreamClosedException) {
                throw new BaseException(DownloadErrorCode.ERROR_STREAM_CLOSED, "async reader closed!");
            }
            DownloadUtils.parseException(th, "async_read");
        }
        throw new BaseException(DownloadErrorCode.ERROR_STREAM_TERMINATED, "async reader terminated!");
    }

    private void start() throws Throwable {
        this.rFuture = DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(this.rRunnable);
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void close() {
        synchronized (this.rLock) {
            this.closed = true;
            this.rLock.notify();
        }
        Future future = this.rFuture;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.rFuture = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public Buffer read() throws BaseException, InterruptedException {
        return dequeueWriteBuffer();
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void recycle(Buffer buffer) {
        enqueueReadBuffer(buffer);
    }
}
