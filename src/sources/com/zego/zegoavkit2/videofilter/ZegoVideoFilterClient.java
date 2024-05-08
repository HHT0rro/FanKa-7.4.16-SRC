package com.zego.zegoavkit2.videofilter;

import android.graphics.SurfaceTexture;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoVideoFilterClient implements ZegoVideoFilter.Client {
    private long pthis = 0;

    private static native int dequeue_input_buffer(long j10, int i10, int i11, int i12);

    private static native void destroy(long j10);

    private static native ByteBuffer get_input_buffer(long j10, int i10);

    private static native SurfaceTexture get_surface_texture(long j10);

    private static native void on_process_callback(long j10, int i10, int i11, int i12, long j11);

    private static native void queue_input_buffer(long j10, int i10, int i11, int i12, int i13, long j11);

    private int setThis(long j10) {
        this.pthis = j10;
        return 0;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public int dequeueInputBuffer(int i10, int i11, int i12) {
        return dequeue_input_buffer(this.pthis, i10, i11, i12);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public void destroy() {
        destroy(this.pthis);
        this.pthis = 0L;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public ByteBuffer getInputBuffer(int i10) {
        return get_input_buffer(this.pthis, i10);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public SurfaceTexture getSurfaceTexture() {
        return get_surface_texture(this.pthis);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public void onProcessCallback(int i10, int i11, int i12, long j10) {
        on_process_callback(this.pthis, i10, i11, i12, j10);
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilter.Client
    public void queueInputBuffer(int i10, int i11, int i12, int i13, long j10) {
        queue_input_buffer(this.pthis, i10, i11, i12, i13, j10);
    }
}
