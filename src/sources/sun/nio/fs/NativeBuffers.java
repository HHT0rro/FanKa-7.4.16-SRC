package sun.nio.fs;

import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class NativeBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int TEMP_BUF_POOL_SIZE = 3;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static ThreadLocal<NativeBuffer[]> threadLocal = new ThreadLocal<>();

    private NativeBuffers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeBuffer allocNativeBuffer(int size) {
        if (size < 2048) {
            size = 2048;
        }
        return new NativeBuffer(size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeBuffer getNativeBufferFromCache(int size) {
        NativeBuffer[] buffers = threadLocal.get();
        if (buffers != null) {
            for (int i10 = 0; i10 < 3; i10++) {
                NativeBuffer buffer = buffers[i10];
                if (buffer != null && buffer.size() >= size) {
                    buffers[i10] = null;
                    return buffer;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeBuffer getNativeBuffer(int size) {
        NativeBuffer buffer = getNativeBufferFromCache(size);
        if (buffer != null) {
            buffer.setOwner(null);
            return buffer;
        }
        return allocNativeBuffer(size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void releaseNativeBuffer(NativeBuffer buffer) {
        NativeBuffer[] buffers = threadLocal.get();
        if (buffers == null) {
            NativeBuffer[] buffers2 = new NativeBuffer[3];
            buffers2[0] = buffer;
            threadLocal.set(buffers2);
            return;
        }
        for (int i10 = 0; i10 < 3; i10++) {
            if (buffers[i10] == null) {
                buffers[i10] = buffer;
                return;
            }
        }
        for (int i11 = 0; i11 < 3; i11++) {
            NativeBuffer existing = buffers[i11];
            if (existing.size() < buffer.size()) {
                existing.cleaner().clean();
                buffers[i11] = buffer;
                return;
            }
        }
        buffer.cleaner().clean();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyCStringToNativeBuffer(byte[] cstr, NativeBuffer buffer) {
        long len = cstr.length;
        for (int i10 = 0; i10 < len; i10++) {
            unsafe.putByte(buffer.address() + i10, cstr[i10]);
        }
        unsafe.putByte(buffer.address() + len, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeBuffer asNativeBuffer(byte[] cstr) {
        NativeBuffer buffer = getNativeBuffer(cstr.length + 1);
        copyCStringToNativeBuffer(cstr, buffer);
        return buffer;
    }
}
