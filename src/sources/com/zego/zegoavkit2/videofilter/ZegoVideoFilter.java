package com.zego.zegoavkit2.videofilter;

import android.graphics.SurfaceTexture;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ZegoVideoFilter {
    public static final int BUFFER_TYPE_ASYNC_I420_MEM = 64;
    public static final int BUFFER_TYPE_ASYNC_PIXEL_BUFFER = 2;
    public static final int BUFFER_TYPE_HYBRID_MEM_GL_TEXTURE_2D = 16;
    public static final int BUFFER_TYPE_MEM = 1;
    public static final int BUFFER_TYPE_SURFACE_TEXTURE = 8;
    public static final int BUFFER_TYPE_SYNC_GL_TEXTURE_2D = 32;
    public static final int BUFFER_TYPE_SYNC_PIXEL_BUFFER = 4;
    public static final int BUFFER_TYPE_UNKNOWN = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Client {
        int dequeueInputBuffer(int i10, int i11, int i12);

        void destroy();

        ByteBuffer getInputBuffer(int i10);

        SurfaceTexture getSurfaceTexture();

        void onProcessCallback(int i10, int i11, int i12, long j10);

        void queueInputBuffer(int i10, int i11, int i12, int i13, long j10);
    }

    public abstract void allocateAndStart(Client client);

    public abstract int dequeueInputBuffer(int i10, int i11, int i12);

    public abstract ByteBuffer getInputBuffer(int i10);

    public abstract SurfaceTexture getSurfaceTexture();

    public abstract void onProcessCallback(int i10, int i11, int i12, long j10);

    public abstract void queueInputBuffer(int i10, int i11, int i12, int i13, long j10);

    public abstract void stopAndDeAllocate();

    public abstract int supportBufferType();
}
