package com.android.internal.infra;

import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import com.android.internal.util.FunctionalUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class RemoteStream<RES, IOSTREAM extends Closeable> extends AndroidFuture<RES> implements Runnable {
    private final FunctionalUtils.ThrowingFunction<IOSTREAM, RES> mHandleStream;
    private volatile ParcelFileDescriptor mLocalPipe;

    protected abstract IOSTREAM createStream(ParcelFileDescriptor parcelFileDescriptor);

    public static <R> AndroidFuture<R> receiveBytes(FunctionalUtils.ThrowingConsumer<ParcelFileDescriptor> ipc, FunctionalUtils.ThrowingFunction<InputStream, R> read) {
        return new RemoteStream<R, InputStream>(ipc, read, AsyncTask.THREAD_POOL_EXECUTOR, true) { // from class: com.android.internal.infra.RemoteStream.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.android.internal.infra.RemoteStream
            public InputStream createStream(ParcelFileDescriptor fd2) {
                return new ParcelFileDescriptor.AutoCloseInputStream(fd2);
            }
        };
    }

    public static AndroidFuture<byte[]> receiveBytes(FunctionalUtils.ThrowingConsumer<ParcelFileDescriptor> ipc) {
        return receiveBytes(ipc, new FunctionalUtils.ThrowingFunction() { // from class: com.android.internal.infra.RemoteStream$$ExternalSyntheticLambda2
            public final Object applyOrThrow(Object obj) {
                return RemoteStream.readAll((InputStream) obj);
            }
        });
    }

    public static byte[] readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream combinedBuffer = new ByteArrayOutputStream();
        byte[] buffer = new byte[16384];
        while (true) {
            int numRead = inputStream.read(buffer);
            if (numRead != -1) {
                combinedBuffer.write(buffer, 0, numRead);
            } else {
                return combinedBuffer.toByteArray();
            }
        }
    }

    public static <R> AndroidFuture<R> sendBytes(FunctionalUtils.ThrowingConsumer<ParcelFileDescriptor> ipc, FunctionalUtils.ThrowingFunction<OutputStream, R> write) {
        return new RemoteStream<R, OutputStream>(ipc, write, AsyncTask.THREAD_POOL_EXECUTOR, false) { // from class: com.android.internal.infra.RemoteStream.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.android.internal.infra.RemoteStream
            public OutputStream createStream(ParcelFileDescriptor fd2) {
                return new ParcelFileDescriptor.AutoCloseOutputStream(fd2);
            }
        };
    }

    public static AndroidFuture<Void> sendBytes(FunctionalUtils.ThrowingConsumer<ParcelFileDescriptor> ipc, final FunctionalUtils.ThrowingConsumer<OutputStream> write) {
        return sendBytes(ipc, new FunctionalUtils.ThrowingFunction() { // from class: com.android.internal.infra.RemoteStream$$ExternalSyntheticLambda0
            public final Object applyOrThrow(Object obj) {
                return RemoteStream.lambda$sendBytes$0(write, (OutputStream) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$sendBytes$0(FunctionalUtils.ThrowingConsumer write, OutputStream os) throws Exception {
        write.acceptOrThrow(os);
        return null;
    }

    public static AndroidFuture<Void> sendBytes(FunctionalUtils.ThrowingConsumer<ParcelFileDescriptor> ipc, final byte[] data) {
        return sendBytes(ipc, new FunctionalUtils.ThrowingFunction() { // from class: com.android.internal.infra.RemoteStream$$ExternalSyntheticLambda1
            public final Object applyOrThrow(Object obj) {
                return RemoteStream.lambda$sendBytes$1(data, (OutputStream) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$sendBytes$1(byte[] data, OutputStream os) throws Exception {
        os.write(data);
        return null;
    }

    private RemoteStream(FunctionalUtils.ThrowingConsumer<ParcelFileDescriptor> ipc, FunctionalUtils.ThrowingFunction<IOSTREAM, RES> handleStream, Executor backgroundExecutor, boolean read) {
        this.mHandleStream = handleStream;
        try {
            ParcelFileDescriptor[] pipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor remotePipe = pipe[read ? (char) 1 : (char) 0];
            try {
                ipc.acceptOrThrow(remotePipe);
                if (remotePipe != null) {
                    remotePipe.close();
                }
                this.mLocalPipe = pipe[read ? (char) 0 : (char) 1];
                backgroundExecutor.execute(this);
                orTimeout(30L, TimeUnit.SECONDS);
            } finally {
            }
        } catch (Throwable e2) {
            completeExceptionally(e2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            IOSTREAM stream = createStream(this.mLocalPipe);
            try {
                complete(this.mHandleStream.applyOrThrow(stream));
                if (stream != null) {
                    stream.close();
                }
            } finally {
            }
        } catch (Throwable t2) {
            completeExceptionally(t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.infra.AndroidFuture
    public void onCompleted(RES res, Throwable err) {
        super.onCompleted(res, err);
        IoUtils.closeQuietly(this.mLocalPipe);
    }
}
