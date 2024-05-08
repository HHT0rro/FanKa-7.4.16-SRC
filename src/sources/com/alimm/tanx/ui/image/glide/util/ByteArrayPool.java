package com.alimm.tanx.ui.image.glide.util;

import android.util.Log;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ByteArrayPool {
    public static final ByteArrayPool BYTE_ARRAY_POOL = new ByteArrayPool();
    public static final int MAX_BYTE_ARRAY_COUNT = 32;
    public static final int MAX_SIZE = 2146304;
    public static final String TAG = "ByteArrayPool";
    public static final int TEMP_BYTES_SIZE = 65536;
    public final Queue<byte[]> tempQueue = Util.createQueue(0);

    public static ByteArrayPool get() {
        return BYTE_ARRAY_POOL;
    }

    public void clear() {
        synchronized (this.tempQueue) {
            this.tempQueue.clear();
        }
    }

    public byte[] getBytes() {
        byte[] poll;
        synchronized (this.tempQueue) {
            poll = this.tempQueue.poll();
        }
        if (poll != null) {
            return poll;
        }
        byte[] bArr = new byte[65536];
        Log.isLoggable(TAG, 3);
        return bArr;
    }

    public boolean releaseBytes(byte[] bArr) {
        boolean z10 = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.tempQueue) {
            if (this.tempQueue.size() < 32) {
                z10 = true;
                this.tempQueue.offer(bArr);
            }
        }
        return z10;
    }
}
