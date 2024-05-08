package io.grpc.okhttp;

import io.grpc.internal.WritableBuffer;
import io.grpc.internal.WritableBufferAllocator;
import okio.Buffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class OkHttpWritableBufferAllocator implements WritableBufferAllocator {
    private static final int MAX_BUFFER = 1048576;
    private static final int MIN_BUFFER = 4096;

    @Override // io.grpc.internal.WritableBufferAllocator
    public WritableBuffer allocate(int i10) {
        return new OkHttpWritableBuffer(new Buffer(), Math.min(1048576, Math.max(4096, i10)));
    }
}
