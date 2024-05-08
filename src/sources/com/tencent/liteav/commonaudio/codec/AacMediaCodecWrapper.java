package com.tencent.liteav.commonaudio.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AacMediaCodecWrapper {

    /* renamed from: a, reason: collision with root package name */
    public MediaFormat f43105a;

    /* renamed from: b, reason: collision with root package name */
    public int f43106b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final String f43107c;

    /* renamed from: d, reason: collision with root package name */
    private final int f43108d;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec f43109e;

    /* renamed from: f, reason: collision with root package name */
    private final MediaCodec.BufferInfo f43110f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f43111a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f43112b = 2;

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ int[] f43113c = {1, 2};
    }

    public AacMediaCodecWrapper(int i10) {
        this.f43108d = i10;
        this.f43107c = i10 == a.f43111a ? "HardwareAacEncoder" : "HardwareAacDecoder";
        this.f43110f = new MediaCodec.BufferInfo();
    }

    private ByteBuffer b() {
        ByteBuffer byteBuffer;
        try {
            int dequeueOutputBuffer = this.f43109e.dequeueOutputBuffer(this.f43110f, TimeUnit.MILLISECONDS.toMicros(5L));
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                Log.i(this.f43107c, "codec output buffers changed.", new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer == -2) {
                this.f43105a = this.f43109e.getOutputFormat();
                Log.i(this.f43107c, "codec output format changed: " + ((Object) this.f43105a), new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer < 0) {
                Log.e(this.f43107c, "unexpected result from dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)), new Object[0]);
                return null;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                byteBuffer = this.f43109e.getOutputBuffer(dequeueOutputBuffer);
            } else {
                byteBuffer = this.f43109e.getOutputBuffers()[dequeueOutputBuffer];
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f43110f.size);
            allocateDirect.put(byteBuffer);
            this.f43109e.releaseOutputBuffer(dequeueOutputBuffer, false);
            int i10 = this.f43106b;
            if (i10 > 0) {
                this.f43106b = i10 - 1;
            }
            return allocateDirect;
        } catch (Exception e2) {
            Log.e(this.f43107c, "dequeueOutputBuffer failed. ".concat(String.valueOf(e2)), new Object[0]);
            return null;
        }
    }

    public final boolean a(MediaFormat mediaFormat) {
        if (this.f43109e == null && mediaFormat != null) {
            try {
                boolean z10 = this.f43108d == a.f43111a;
                if (z10) {
                    this.f43109e = MediaCodec.createEncoderByType("audio/mp4a-latm");
                } else {
                    this.f43109e = MediaCodec.createDecoderByType("audio/mp4a-latm");
                }
                this.f43109e.configure(mediaFormat, (Surface) null, (MediaCrypto) null, z10 ? 1 : 0);
                this.f43109e.start();
                return true;
            } catch (IOException e2) {
                Log.e(this.f43107c, "create codec failed. ".concat(String.valueOf(e2)), new Object[0]);
                a();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0063 -> B:14:0x0059). Please report as a decompilation issue!!! */
    @com.tencent.liteav.base.annotations.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.ByteBuffer processFrame(java.nio.ByteBuffer r14) {
        /*
            r13 = this;
            android.media.MediaCodec r0 = r13.f43109e
            r1 = 0
            if (r0 == 0) goto L66
            if (r14 != 0) goto L8
            goto L66
        L8:
            r2 = 0
            java.nio.ByteBuffer[] r0 = r0.getInputBuffers()     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L3d
            int r3 = r0.length     // Catch: java.lang.Exception -> L47
            if (r3 > 0) goto L13
            goto L3d
        L13:
            android.media.MediaCodec r3 = r13.f43109e     // Catch: java.lang.Exception -> L47
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L47
            r5 = 5
            long r4 = r4.toMicros(r5)     // Catch: java.lang.Exception -> L47
            int r7 = r3.dequeueInputBuffer(r4)     // Catch: java.lang.Exception -> L47
            if (r7 >= 0) goto L24
            goto L59
        L24:
            int r9 = r14.remaining()     // Catch: java.lang.Exception -> L47
            r0 = r0[r7]     // Catch: java.lang.Exception -> L47
            r0.put(r14)     // Catch: java.lang.Exception -> L47
            android.media.MediaCodec r6 = r13.f43109e     // Catch: java.lang.Exception -> L47
            r8 = 0
            r10 = 0
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch: java.lang.Exception -> L47
            int r14 = r13.f43106b     // Catch: java.lang.Exception -> L47
            int r14 = r14 + 1
            r13.f43106b = r14     // Catch: java.lang.Exception -> L47
            goto L59
        L3d:
            java.lang.String r14 = r13.f43107c     // Catch: java.lang.Exception -> L47
            java.lang.String r0 = "get invalid input buffers."
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L47
            com.tencent.liteav.base.Log.e(r14, r0, r3)     // Catch: java.lang.Exception -> L47
            goto L59
        L47:
            r14 = move-exception
            java.lang.String r0 = r13.f43107c
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r3 = "feedData failed. "
            java.lang.String r14 = r3.concat(r14)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.tencent.liteav.base.Log.e(r0, r14, r3)
        L59:
            r14 = 3
            if (r2 >= r14) goto L66
            java.nio.ByteBuffer r14 = r13.b()
            if (r14 == 0) goto L63
            return r14
        L63:
            int r2 = r2 + 1
            goto L59
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.commonaudio.codec.AacMediaCodecWrapper.processFrame(java.nio.ByteBuffer):java.nio.ByteBuffer");
    }

    public final void a() {
        MediaCodec mediaCodec = this.f43109e;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.stop();
        } catch (Exception e2) {
            Log.e(this.f43107c, "codec stop failed.".concat(String.valueOf(e2)), new Object[0]);
        }
        try {
            this.f43109e.release();
        } catch (Exception e10) {
            Log.e(this.f43107c, "codec release failed.".concat(String.valueOf(e10)), new Object[0]);
        }
        this.f43109e = null;
        this.f43106b = 0;
    }
}
