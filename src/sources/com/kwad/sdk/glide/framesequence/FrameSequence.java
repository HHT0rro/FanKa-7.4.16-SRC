package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FrameSequence implements Serializable {
    private static final AtomicBoolean ISLOADED;
    private int mDefaultLoopCount;
    private int mFrameCount;
    private int mHeight;
    private long mNativeFrameSequence;
    private boolean mOpaque;
    private int mWidth;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class State implements Serializable {
        private long mNativeState;

        public State(long j10) {
            this.mNativeState = j10;
        }

        public void destroy() {
            long j10 = this.mNativeState;
            if (j10 != 0) {
                FrameSequence.nativeDestroyState(j10);
                this.mNativeState = 0L;
            }
        }

        public long getFrame(int i10, Bitmap bitmap, int i11) {
            if (bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                long j10 = this.mNativeState;
                if (j10 != 0) {
                    return FrameSequence.nativeGetFrame(j10, i10, bitmap, i11);
                }
                throw new IllegalStateException("attempted to draw destroyed FrameSequenceState");
            }
            throw new IllegalArgumentException("Bitmap passed must be non-null and ARGB_8888");
        }
    }

    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ISLOADED = atomicBoolean;
        try {
            System.loadLibrary("framesequencev2");
            atomicBoolean.set(true);
        } catch (Throwable unused) {
            ISLOADED.set(false);
        }
    }

    public FrameSequence() {
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr) {
        if (ISLOADED.get()) {
            return decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Nullable
    public static FrameSequence decodeByteBuffer(ByteBuffer byteBuffer) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (byteBuffer != null) {
            if (!byteBuffer.isDirect()) {
                if (byteBuffer.hasArray()) {
                    return decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
            }
            return nativeDecodeByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
        }
        throw new IllegalArgumentException();
    }

    @Nullable
    public static FrameSequence decodeStream(InputStream inputStream) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (inputStream != null) {
            return nativeDecodeStream(inputStream, new byte[16384]);
        }
        throw new IllegalArgumentException();
    }

    public static boolean isEnable() {
        return ISLOADED.get();
    }

    private static native long nativeCreateState(long j10);

    private static native FrameSequence nativeDecodeByteArray(byte[] bArr, int i10, int i11);

    private static native FrameSequence nativeDecodeByteBuffer(ByteBuffer byteBuffer, int i10, int i11);

    private static native FrameSequence nativeDecodeStream(InputStream inputStream, byte[] bArr);

    private static native void nativeDestroyFrameSequence(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroyState(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeGetFrame(long j10, int i10, Bitmap bitmap, int i11);

    public State createState() {
        long j10 = this.mNativeFrameSequence;
        if (j10 != 0) {
            long nativeCreateState = nativeCreateState(j10);
            if (nativeCreateState == 0) {
                return null;
            }
            return new State(nativeCreateState);
        }
        throw new IllegalStateException("attempted to use incorrectly built FrameSequence");
    }

    public void destroy() {
        long j10 = this.mNativeFrameSequence;
        if (j10 != 0) {
            nativeDestroyFrameSequence(j10);
        }
    }

    public int getDefaultLoopCount() {
        return this.mDefaultLoopCount;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }

    private FrameSequence(long j10, int i10, int i11, boolean z10, int i12, int i13) {
        this.mNativeFrameSequence = j10;
        this.mWidth = i10;
        this.mHeight = i11;
        this.mOpaque = z10;
        this.mFrameCount = i12;
        this.mDefaultLoopCount = i13;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr, int i10, int i11) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (bArr != null) {
            if (i10 >= 0 && i11 >= 0 && i10 + i11 <= bArr.length) {
                return nativeDecodeByteArray(bArr, i10, i11);
            }
            throw new IllegalArgumentException("invalid offset/length parameters");
        }
        throw new IllegalArgumentException();
    }
}
