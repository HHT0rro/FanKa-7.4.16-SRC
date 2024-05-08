package com.zego.zegoavkit2;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoVideoCaptureClient implements ZegoVideoCaptureDevice.Client {
    private long pthis = 0;

    private static native void destroy(long j10);

    private static native SurfaceTexture get_surface_texture(long j10);

    private static native int on_byte_array_frame_captured(long j10, byte[] bArr, int i10, int i11, int i12, int[] iArr, int i13, int i14, long j11, int i15);

    private static native int on_byte_buffer_frame_captured(long j10, ByteBuffer byteBuffer, int i10, int i11, int i12, int[] iArr, int i13, int i14, long j11, int i15);

    private static native int on_encoded_frame_captured(long j10, ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, boolean z10, double d10);

    private static native int on_take_snapshot(long j10, Bitmap bitmap);

    private static native int on_texture_captured(long j10, int i10, int i11, int i12, double d10);

    private static native void reset_texture_context(long j10);

    private int setThis(long j10) {
        this.pthis = j10;
        return 0;
    }

    private static native void set_fill_mode(long j10, int i10);

    private static native void set_flip_mode(long j10, int i10);

    private static native void set_rotation(long j10, int i10);

    private static native void set_status_reason(long j10, boolean z10, int i10);

    private static native void set_texture_resolution(long j10, int i10, int i11);

    private static native void set_transform_matrix(long j10, float[] fArr);

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void destroy() {
        destroy(this.pthis);
        this.pthis = 0L;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public SurfaceTexture getSurfaceTexture() {
        long j10 = this.pthis;
        if (j10 != 0) {
            return get_surface_texture(j10);
        }
        return null;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onByteBufferFrameCaptured(byte[] bArr, int i10, ZegoVideoCaptureDevice.VideoCaptureFormat videoCaptureFormat, long j10, int i11) {
        long j11 = this.pthis;
        if (j11 != 0) {
            on_byte_array_frame_captured(j11, bArr, i10, videoCaptureFormat.width, videoCaptureFormat.height, videoCaptureFormat.strides, videoCaptureFormat.rotation, videoCaptureFormat.pixel_format, j10, i11);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onEncodedFrameCaptured(ByteBuffer byteBuffer, int i10, ZegoVideoCaptureDevice.VideoCodecConfig videoCodecConfig, boolean z10, double d10) {
        long j10 = this.pthis;
        if (j10 != 0) {
            on_encoded_frame_captured(j10, byteBuffer, i10, videoCodecConfig.width, videoCodecConfig.height, videoCodecConfig.codec_type, videoCodecConfig.rotation, z10, d10);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onTakeSnapshot(Bitmap bitmap) {
        long j10 = this.pthis;
        if (j10 != 0) {
            on_take_snapshot(j10, bitmap);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onTextureCaptured(int i10, int i11, int i12, double d10) {
        long j10 = this.pthis;
        if (j10 != 0) {
            on_texture_captured(j10, i10, i11, i12, d10);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void resetTextureContext() {
        long j10 = this.pthis;
        if (j10 != 0) {
            reset_texture_context(j10);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setFillMode(int i10) {
        long j10 = this.pthis;
        if (j10 != 0) {
            set_fill_mode(j10, i10);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setFlipMode(int i10) {
        long j10 = this.pthis;
        if (j10 != 0) {
            set_flip_mode(j10, i10);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setRotation(int i10) {
        long j10 = this.pthis;
        if (j10 != 0) {
            set_rotation(j10, i10);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setStatusReason(boolean z10, int i10) {
        long j10 = this.pthis;
        if (j10 != 0) {
            set_status_reason(j10, z10, i10);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setTextureResolution(int i10, int i11) {
        long j10 = this.pthis;
        if (j10 != 0) {
            set_texture_resolution(j10, i10, i11);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setTransformMatrix(float[] fArr) {
        long j10 = this.pthis;
        if (j10 != 0) {
            set_transform_matrix(j10, fArr);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onByteBufferFrameCaptured(ByteBuffer byteBuffer, int i10, ZegoVideoCaptureDevice.VideoCaptureFormat videoCaptureFormat, long j10, int i11) {
        long j11 = this.pthis;
        if (j11 != 0) {
            on_byte_buffer_frame_captured(j11, byteBuffer, i10, videoCaptureFormat.width, videoCaptureFormat.height, videoCaptureFormat.strides, videoCaptureFormat.rotation, videoCaptureFormat.pixel_format, j10, i11);
        }
    }
}
