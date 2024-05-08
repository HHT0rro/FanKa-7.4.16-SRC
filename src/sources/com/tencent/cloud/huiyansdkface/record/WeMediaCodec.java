package com.tencent.cloud.huiyansdkface.record;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.WorkerThread;
import com.alibaba.security.biometrics.service.build.ah;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.h264.EncoderDebugger;
import com.tencent.cloud.huiyansdkface.record.h264.NV21Convert;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeMediaCodec {

    /* renamed from: g, reason: collision with root package name */
    private static int f42115g;

    /* renamed from: a, reason: collision with root package name */
    private int f42116a;

    /* renamed from: b, reason: collision with root package name */
    private int f42117b;

    /* renamed from: c, reason: collision with root package name */
    private MediaCodec f42118c;

    /* renamed from: d, reason: collision with root package name */
    private NV21Convert f42119d;

    /* renamed from: e, reason: collision with root package name */
    private WbRecordFinishListener f42120e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f42121f;

    /* renamed from: h, reason: collision with root package name */
    private int f42122h;

    /* renamed from: i, reason: collision with root package name */
    private int f42123i;

    /* renamed from: j, reason: collision with root package name */
    private int f42124j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f42125k = new byte[0];

    /* renamed from: l, reason: collision with root package name */
    private byte[] f42126l = null;

    /* renamed from: m, reason: collision with root package name */
    private WeWrapMp4Jni f42127m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f42128n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f42129o;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f42130p;

    /* renamed from: q, reason: collision with root package name */
    private int f42131q;

    /* renamed from: r, reason: collision with root package name */
    private int f42132r;

    /* renamed from: s, reason: collision with root package name */
    private ByteArrayOutputStream f42133s;

    public WeMediaCodec(Context context, WeWrapMp4Jni weWrapMp4Jni, int i10, int i11, int i12, int i13) {
        this.f42122h = i11;
        this.f42123i = i12;
        this.f42127m = weWrapMp4Jni;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i10, cameraInfo);
        this.f42132r = cameraInfo.orientation;
        int i14 = ((this.f42122h * this.f42123i) * 3) / 2;
        this.f42128n = new byte[i14];
        this.f42129o = new byte[i14];
        this.f42130p = new byte[i14];
        this.f42124j = i13;
        this.f42133s = new ByteArrayOutputStream();
    }

    public void destroy() {
        WLogger.d("WeMediaCodec", LandingPageUtHelper.XAD_UT_LP_DESTROY);
        this.f42126l = null;
        this.f42128n = null;
        this.f42129o = null;
        this.f42130p = null;
        try {
            this.f42133s.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f42133s = null;
        MediaCodec mediaCodec = this.f42118c;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f42118c.release();
            this.f42118c = null;
        }
    }

    public ByteArrayOutputStream getVideoByte() {
        return this.f42133s;
    }

    public boolean initMediaCodec(Context context) {
        WLogger.i("WeMediaCodec", "initMediaCodec");
        f42115g = 0;
        this.f42116a = 30;
        this.f42117b = 1000000;
        try {
            EncoderDebugger debug = EncoderDebugger.debug(context, this.f42122h, this.f42123i);
            this.f42119d = debug.getNV21Convertor();
            this.f42131q = debug.getEncoderColorFormat();
            this.f42118c = MediaCodec.createByCodecName(debug.getEncoderName());
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(ah.f2598d, this.f42122h, this.f42123i);
            createVideoFormat.setInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.f42117b);
            createVideoFormat.setInteger("frame-rate", this.f42116a);
            createVideoFormat.setInteger("color-format", debug.getEncoderColorFormat());
            createVideoFormat.setInteger("i-frame-interval", 5);
            this.f42118c.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f42118c.start();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("WeMediaCodec", "initMediaCodec error:" + e2.toString());
            return false;
        }
    }

    @WorkerThread
    public void onPreviewFrame(byte[] bArr) {
        if (this.f42121f) {
            return;
        }
        if (f42115g > this.f42124j) {
            WLogger.i("WeMediaCodec", "onPreviewFrame*** mVideoFrameCount > MAX_VIDEO_FRAME_NUM,no more record");
            this.f42121f = true;
            WbRecordFinishListener wbRecordFinishListener = this.f42120e;
            if (wbRecordFinishListener != null) {
                wbRecordFinishListener.onRecordFinish();
                return;
            }
            return;
        }
        ByteBuffer[] inputBuffers = this.f42118c.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f42118c.getOutputBuffers();
        try {
            int dequeueInputBuffer = this.f42118c.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                WLogger.e("WeMediaCodec", "No buffer available !");
                return;
            }
            inputBuffers[dequeueInputBuffer].clear();
            this.f42127m.NV21ToTarget(bArr, this.f42130p, this.f42122h, this.f42123i, this.f42131q, this.f42132r, this.f42128n, this.f42129o);
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byte[] bArr2 = this.f42130p;
            byteBuffer.put(bArr2, 0, bArr2.length);
            this.f42118c.queueInputBuffer(dequeueInputBuffer, 0, inputBuffers[dequeueInputBuffer].position(), System.nanoTime() / 1000, 0);
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.f42118c.dequeueOutputBuffer(bufferInfo, 0L);
            f42115g++;
            WLogger.d("WeMediaCodec", "video frame count=" + f42115g);
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                int i10 = bufferInfo.size;
                byte[] bArr3 = new byte[i10];
                byteBuffer2.get(bArr3);
                if (bArr3[0] == 0 && bArr3[1] == 0 && bArr3[2] == 0 && bArr3[3] == 1 && bArr3[4] == 103) {
                    this.f42125k = bArr3;
                } else if (bArr3[0] == 0 && bArr3[1] == 0 && bArr3[2] == 0 && bArr3[3] == 1 && bArr3[4] == 101) {
                    byte[] bArr4 = this.f42125k;
                    byte[] bArr5 = new byte[bArr4.length + i10];
                    System.arraycopy((Object) bArr4, 0, (Object) bArr5, 0, bArr4.length);
                    System.arraycopy((Object) bArr3, 0, (Object) bArr5, this.f42125k.length, i10);
                    bArr3 = bArr5;
                }
                this.f42133s.write(bArr3);
                this.f42118c.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.f42118c.dequeueOutputBuffer(bufferInfo, 0L);
            }
        } catch (Exception e2) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e2.printStackTrace(printWriter);
            String stringWriter2 = stringWriter.toString();
            try {
                stringWriter.close();
                printWriter.close();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            WLogger.e("WeMediaCodec", stringWriter2);
            e2.printStackTrace();
        }
    }

    public void start(WbRecordFinishListener wbRecordFinishListener) {
        this.f42133s.reset();
        f42115g = 0;
        if (wbRecordFinishListener != null) {
            this.f42120e = wbRecordFinishListener;
        }
    }

    public void stop() {
        WLogger.d("WeMediaCodec", "stop:" + f42115g);
    }
}
