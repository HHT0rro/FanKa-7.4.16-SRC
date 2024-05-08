package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.common.MediaCodecAbility;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class ad {

    /* renamed from: b, reason: collision with root package name */
    public b f43830b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final Size f43831c;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f43834f;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f43836h;

    /* renamed from: j, reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.h f43838j;

    /* renamed from: l, reason: collision with root package name */
    private volatile CustomHandler f43840l;

    /* renamed from: a, reason: collision with root package name */
    public String f43829a = "MediaCodecDecoder";

    /* renamed from: i, reason: collision with root package name */
    private MediaCodec f43837i = null;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodec.BufferInfo f43832d = new MediaCodec.BufferInfo();

    /* renamed from: e, reason: collision with root package name */
    public boolean f43833e = false;

    /* renamed from: k, reason: collision with root package name */
    private final t f43839k = new t();

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.liteav.base.b.b f43835g = new com.tencent.liteav.base.b.b();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f43841a = true;

        /* renamed from: b, reason: collision with root package name */
        public h.c f43842b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f43843c = "";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void a(PixelFrame pixelFrame, boolean z10);

        void a(h.c cVar, String str);
    }

    public ad(com.tencent.liteav.videobase.utils.h hVar, @NonNull Size size, @NonNull IVideoReporter iVideoReporter, boolean z10, b bVar, CustomHandler customHandler) {
        this.f43838j = hVar;
        this.f43831c = size;
        this.f43834f = iVideoReporter;
        this.f43836h = z10;
        this.f43830b = bVar;
        this.f43840l = customHandler;
    }

    private void c() {
        if (this.f43837i == null) {
            return;
        }
        try {
            LiteavLog.i(this.f43829a, "mediaCodec stop");
            this.f43837i.stop();
        } catch (Throwable th) {
            try {
                LiteavLog.e(this.f43829a, "stop MediaCodec failed." + th.getMessage());
                try {
                    LiteavLog.i(this.f43829a, "mediaCodec release");
                    this.f43837i.release();
                } catch (Throwable th2) {
                    LiteavLog.e(this.f43829a, "release MediaCodec failed.", th2);
                }
                this.f43837i = null;
            } finally {
                try {
                    LiteavLog.i(this.f43829a, "mediaCodec release");
                    this.f43837i.release();
                } catch (Throwable th3) {
                    LiteavLog.e(this.f43829a, "release MediaCodec failed.", th3);
                }
                this.f43837i = null;
            }
        }
    }

    public abstract void a(MediaCodec mediaCodec);

    public abstract boolean a(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i10);

    public abstract boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat);

    public final boolean a(EncodedVideoFrame encodedVideoFrame) {
        byte[] a10;
        byte[] bArr;
        ByteBuffer b4;
        ByteBuffer byteBuffer;
        if (this.f43837i == null) {
            return false;
        }
        if (encodedVideoFrame != null && (encodedVideoFrame.isEosFrame || ((byteBuffer = encodedVideoFrame.data) != null && byteBuffer.remaining() != 0))) {
            ByteBuffer[] inputBuffers = this.f43837i.getInputBuffers();
            if (com.tencent.liteav.videobase.utils.c.a(inputBuffers)) {
                LiteavLog.e(this.f43829a, "get invalid input buffers.");
                return false;
            }
            int dequeueInputBuffer = this.f43837i.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                return false;
            }
            if (!encodedVideoFrame.isEosFrame) {
                if (encodedVideoFrame.isIDRFrame() && encodedVideoFrame.codecType == CodecType.H264 && this.f43833e && (a10 = com.tencent.liteav.videobase.utils.j.a(encodedVideoFrame.data.remaining())) != null) {
                    encodedVideoFrame.data.get(a10);
                    encodedVideoFrame.data.rewind();
                    int[] iArr = {-1};
                    int i10 = 0;
                    while (true) {
                        if (i10 + 4 >= a10.length || (i10 = EncodedVideoFrame.getNextNALHeaderPos(i10, ByteBuffer.wrap(a10))) < 0) {
                            break;
                        }
                        if ((a10[i10] & 31) == 7) {
                            iArr[0] = i10;
                            break;
                        }
                    }
                    byte[] bArr2 = null;
                    if (iArr[0] < 0) {
                        bArr = null;
                    } else {
                        int length = a10.length - iArr[0];
                        int i11 = iArr[0];
                        while (true) {
                            int i12 = i11 + 3;
                            if (i12 >= a10.length) {
                                break;
                            }
                            if ((a10[i11] != 0 || a10[i11 + 1] != 0 || a10[i11 + 2] != 1) && (a10[i11] != 0 || a10[i11 + 1] != 0 || a10[i11 + 2] != 0 || a10[i12] != 1)) {
                                i11++;
                            }
                        }
                        length = i11 - iArr[0];
                        bArr = new byte[length];
                        System.arraycopy((Object) a10, iArr[0], (Object) bArr, 0, length);
                    }
                    if (bArr != null && iArr[0] >= 0) {
                        try {
                            bArr2 = this.f43839k.a(bArr);
                        } catch (Throwable th) {
                            LiteavLog.e(this.f43829a, "modify dec buffer error ", th);
                        }
                        if (bArr2 != null && (b4 = com.tencent.liteav.videobase.utils.j.b((a10.length - bArr.length) + bArr2.length)) != null) {
                            encodedVideoFrame.data = b4;
                            if (iArr[0] > 0) {
                                b4.put(a10, 0, iArr[0]);
                            }
                            encodedVideoFrame.data.put(bArr2);
                            encodedVideoFrame.data.put(a10, iArr[0] + bArr.length, (a10.length - iArr[0]) - bArr.length);
                            encodedVideoFrame.data.rewind();
                        }
                    }
                }
                int remaining = encodedVideoFrame.data.remaining();
                inputBuffers[dequeueInputBuffer].put(encodedVideoFrame.data);
                am.a(this.f43837i, dequeueInputBuffer, remaining, TimeUnit.MILLISECONDS.toMicros(encodedVideoFrame.pts), 0);
            } else {
                LiteavLog.i(this.f43829a, "feedDataToMediaCodec BUFFER_FLAG_END_OF_STREAM");
                am.a(this.f43837i, dequeueInputBuffer, 0, 0L, 4);
            }
            return true;
        }
        LiteavLog.w(this.f43829a, "receive empty buffer.");
        return true;
    }

    public abstract boolean a(Object obj);

    public void b() {
        c();
    }

    public final boolean a() {
        int dequeueOutputBuffer;
        if (this.f43837i == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= 3 || (dequeueOutputBuffer = this.f43837i.dequeueOutputBuffer(this.f43832d, TimeUnit.MILLISECONDS.toMicros(10L))) == -1) {
                return false;
            }
            if (dequeueOutputBuffer == -3) {
                LiteavLog.i(this.f43829a, "on output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                a(this.f43837i.getOutputFormat());
            } else {
                if (dequeueOutputBuffer >= 0) {
                    return a(this.f43837i, this.f43832d, dequeueOutputBuffer);
                }
                LiteavLog.d(this.f43829a, "dequeueOutputBuffer get invalid index: %d", Integer.valueOf(dequeueOutputBuffer));
            }
            i10++;
        }
    }

    public final a a(boolean z10, MediaCodec mediaCodec) {
        String str;
        h.c cVar;
        MediaCodec createDecoderByType;
        com.tencent.liteav.videobase.utils.h hVar = this.f43838j;
        hVar.f43505f = z10;
        MediaFormat a10 = hVar.a();
        a aVar = new a();
        h.c cVar2 = h.c.WARNING_VIDEO_DECODE_START_FAILED;
        boolean z11 = false;
        String str2 = "";
        try {
            if (mediaCodec != null) {
                this.f43837i = mediaCodec;
                a(mediaCodec);
                LiteavLog.i(this.f43829a, "preload MediaCodec update surface success (%s)", this.f43837i.getName());
                z11 = true;
            } else {
                String string = a10.getString(DatabaseSourceInfoStorage.COLUMN_MIME);
                if (this.f43836h) {
                    loop0: for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                        if (!mediaCodecInfo.isEncoder()) {
                            for (String str3 : supportedTypes) {
                                if (str3.contains(string) && MediaCodecAbility.isSoftOnlyDecoder(mediaCodecInfo)) {
                                    LiteavLog.i(this.f43829a, "Use soft only decoder:%s", mediaCodecInfo.getName());
                                    createDecoderByType = MediaCodec.createByCodecName(mediaCodecInfo.getName());
                                    break loop0;
                                }
                            }
                        }
                    }
                }
                createDecoderByType = MediaCodec.createDecoderByType(string);
                this.f43837i = createDecoderByType;
                createDecoderByType.setVideoScalingMode(1);
                boolean a11 = a(this.f43837i, a10);
                if (a11) {
                    LiteavLog.i(this.f43829a, "configure MediaCodec with ".concat(String.valueOf(a10)));
                    this.f43837i.start();
                    LiteavLog.i(this.f43829a, "start MediaCodec(%s) success.", this.f43837i.getName());
                }
                z11 = a11;
            }
        } catch (Throwable th) {
            LiteavLog.e(this.f43829a, "start MediaCodec failed.", th);
            if (th instanceof IllegalArgumentException) {
                cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT;
                str = "VideoDecode: illegal argument, Start decoder failed";
            } else if (th instanceof IllegalStateException) {
                cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE;
                str = "VideoDecode: illegal state, Start decoder failed";
            } else {
                str = "VideoDecode: Start decoder failed";
                cVar = cVar2;
            }
            str2 = "decoder config fail, message:" + str + " exception:" + th.getMessage();
            cVar2 = cVar;
        }
        aVar.f43841a = z11;
        if (!z11) {
            c();
            aVar.f43842b = cVar2;
            aVar.f43843c = str2;
        }
        return aVar;
    }

    public void a(MediaFormat mediaFormat) {
        LiteavLog.i(this.f43829a, "decode output format changed: ".concat(String.valueOf(mediaFormat)));
        LiteavLog.i(this.f43829a, "cropWidth: %d, cropHeight: %d, frameWidth: %d, frameHeight: %d", Integer.valueOf(Math.abs(mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1), Integer.valueOf(Math.abs(mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1), Integer.valueOf(mediaFormat.getInteger("width")), Integer.valueOf(mediaFormat.getInteger("height")));
    }

    public final void a(Runnable runnable) {
        if (this.f43840l != null) {
            this.f43840l.runOrPost(runnable);
        }
    }
}
