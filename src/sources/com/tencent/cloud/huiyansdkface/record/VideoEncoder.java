package com.tencent.cloud.huiyansdkface.record;

import android.graphics.YuvImage;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.alibaba.security.biometrics.service.build.ah;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoEncoder {
    public static final int COLOR_FORMAT_YUV_420_SEMI_PLANAR = 21;

    /* renamed from: a, reason: collision with root package name */
    private static final String f42088a = "VideoEncoder";

    /* renamed from: m, reason: collision with root package name */
    private static int f42089m;

    /* renamed from: n, reason: collision with root package name */
    private static int f42090n;

    /* renamed from: b, reason: collision with root package name */
    private IYUVToVideoEncoderCallback f42091b;

    /* renamed from: c, reason: collision with root package name */
    private File f42092c;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f42095f;

    /* renamed from: g, reason: collision with root package name */
    private MediaCodec f42096g;

    /* renamed from: h, reason: collision with root package name */
    private MediaMuxer f42097h;

    /* renamed from: l, reason: collision with root package name */
    private CountDownLatch f42101l;

    /* renamed from: o, reason: collision with root package name */
    private boolean f42102o;

    /* renamed from: q, reason: collision with root package name */
    private int f42104q;

    /* renamed from: y, reason: collision with root package name */
    private ByteArrayOutputStream f42112y;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentLinkedQueue<YuvImage> f42093d = new ConcurrentLinkedQueue<>();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentLinkedQueue<Object> f42094e = new ConcurrentLinkedQueue<>();

    /* renamed from: i, reason: collision with root package name */
    private boolean f42098i = false;

    /* renamed from: j, reason: collision with root package name */
    private final Object f42099j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private final Object f42100k = new Object();

    /* renamed from: p, reason: collision with root package name */
    private int f42103p = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f42105r = 0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f42106s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f42107t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f42108u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f42109v = 21;

    /* renamed from: w, reason: collision with root package name */
    private int f42110w = 0;

    /* renamed from: x, reason: collision with root package name */
    private byte[] f42111x = new byte[0];

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface IYUVToVideoEncoderCallback {
        void onEncodingComplete(File file);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        VideoType
    }

    public VideoEncoder(IYUVToVideoEncoderCallback iYUVToVideoEncoderCallback, boolean z10) {
        this.f42091b = iYUVToVideoEncoderCallback;
        this.f42102o = z10;
    }

    private static int a(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i10 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i10 >= iArr.length) {
                return 0;
            }
            int i11 = iArr[i10];
            WLogger.d(f42088a, "found colorformat: " + i11);
            if (a(i11)) {
                return i11;
            }
            i10++;
        }
    }

    private long a(long j10, int i10) {
        return ((j10 * 1000000) / i10) + 132;
    }

    private static MediaCodecInfo a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i10 = 0; i10 < codecCount; i10++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    private ByteBuffer a(a aVar, int i10) {
        return this.f42096g.getInputBuffer(i10);
    }

    private void a() {
        WLogger.d(f42088a, "release");
        synchronized (this.f42100k) {
            MediaCodec mediaCodec = this.f42096g;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    WLogger.w(f42088a, "videoEncoder stop failed:" + e2.toString());
                }
                this.f42096g.release();
                this.f42096g = null;
                WLogger.d(f42088a, "RELEASE Video CODEC");
            }
            MediaMuxer mediaMuxer = this.f42097h;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.stop();
                    this.f42097h.release();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    WLogger.e(f42088a, "media muxer stop failed:" + e10.toString());
                }
                this.f42097h = null;
                this.f42098i = false;
                WLogger.d(f42088a, "RELEASE MUXER");
            }
        }
    }

    private void a(a aVar, MediaFormat mediaFormat) {
        synchronized (this.f42100k) {
            if (!this.f42098i) {
                if (aVar == a.VideoType) {
                    this.f42104q = this.f42097h.addTrack(mediaFormat);
                    this.f42105r++;
                }
                if (this.f42105r >= 1) {
                    WLogger.d(f42088a, "Media muxer is starting...");
                    this.f42097h.start();
                    this.f42098i = true;
                    this.f42100k.notifyAll();
                }
            }
        }
    }

    private static boolean a(int i10) {
        if (i10 == 39 || i10 == 2130706688) {
            return true;
        }
        switch (i10) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    private byte[] a(int i10, int i11, YuvImage yuvImage) {
        return this.f42109v == 21 ? b(i10, i11, yuvImage) : c(i10, i11, yuvImage);
    }

    private ByteBuffer b(a aVar, int i10) {
        return this.f42096g.getOutputBuffer(i10);
    }

    private byte[] b(int i10, int i11, YuvImage yuvImage) {
        if (this.f42095f == null) {
            this.f42095f = new byte[((i10 * i11) * 3) / 2];
        }
        byte[] yuvData = yuvImage.getYuvData();
        int i12 = i10 * i11;
        if (i12 >= 0) {
            System.arraycopy((Object) yuvData, 0, (Object) this.f42095f, 0, i12);
        }
        int i13 = i12;
        while (i13 < (i12 * 3) / 2) {
            int i14 = i13 + 1;
            if (i14 % 2 == 0) {
                byte[] bArr = this.f42095f;
                int i15 = i13 - 1;
                bArr[i13] = yuvData[i15];
                bArr[i15] = yuvData[i13];
            }
            i13 = i14;
        }
        return this.f42095f;
    }

    private byte[] c(int i10, int i11, YuvImage yuvImage) {
        if (this.f42095f == null) {
            this.f42095f = new byte[((i10 * i11) * 3) / 2];
        }
        byte[] yuvData = yuvImage.getYuvData();
        int i12 = i10 * i11;
        if (i12 >= 0) {
            System.arraycopy((Object) yuvData, 0, (Object) this.f42095f, 0, i12);
        }
        int i13 = (i12 / 4) + i12;
        int i14 = i12;
        int i15 = i14;
        while (i14 < (i12 * 3) / 2) {
            byte[] bArr = this.f42095f;
            bArr[i13] = yuvData[i14];
            bArr[i15] = yuvData[i14 + 1];
            i13++;
            i15++;
            i14 += 2;
        }
        return this.f42095f;
    }

    public void abortEncoding() {
        this.f42108u = false;
        if (this.f42092c != null) {
            WLogger.d(f42088a, "Clean up record file");
            this.f42092c.delete();
            this.f42092c = null;
        }
        ByteArrayOutputStream byteArrayOutputStream = this.f42112y;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                WLogger.e(f42088a, "byteOutput close failed:" + e2.toString());
            }
            this.f42112y = null;
            WLogger.d(f42088a, "RELEASE byteOutput");
        }
        if (this.f42102o) {
            if (this.f42096g == null || this.f42097h == null) {
                WLogger.i(f42088a, "Failed to abort encoding since it never started");
                return;
            }
            WLogger.i(f42088a, "Aborting encoding");
            a();
            this.f42106s = true;
            this.f42107t = true;
            this.f42093d = new ConcurrentLinkedQueue<>();
            synchronized (this.f42099j) {
                CountDownLatch countDownLatch = this.f42101l;
                if (countDownLatch != null && countDownLatch.getCount() > 0) {
                    this.f42101l.countDown();
                }
            }
        }
    }

    public void encode() {
        String str;
        String str2;
        CountDownLatch countDownLatch;
        if (this.f42102o && this.f42108u) {
            if (this.f42106s && this.f42093d.size() == 0) {
                return;
            }
            YuvImage poll = this.f42093d.poll();
            if (poll == null) {
                synchronized (this.f42099j) {
                    countDownLatch = new CountDownLatch(1);
                    this.f42101l = countDownLatch;
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                poll = this.f42093d.poll();
            }
            if (poll != null) {
                try {
                    byte[] a10 = a(f42089m, f42090n, poll);
                    int dequeueInputBuffer = this.f42096g.dequeueInputBuffer(200000L);
                    long a11 = a(this.f42103p, 30);
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer a12 = a(a.VideoType, dequeueInputBuffer);
                        a12.clear();
                        a12.put(a10);
                        this.f42096g.queueInputBuffer(dequeueInputBuffer, 0, a10.length, a11, 0);
                        this.f42103p++;
                    }
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int dequeueOutputBuffer = this.f42096g.dequeueOutputBuffer(bufferInfo, 200000L);
                    if (dequeueOutputBuffer == -1) {
                        str = f42088a;
                        str2 = "No output from encoder available";
                    } else {
                        if (dequeueOutputBuffer == -2) {
                            a(a.VideoType, this.f42096g.getOutputFormat());
                            return;
                        }
                        if (dequeueOutputBuffer < 0) {
                            str = f42088a;
                            str2 = "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer;
                        } else {
                            if (bufferInfo.size == 0) {
                                return;
                            }
                            ByteBuffer b4 = b(a.VideoType, dequeueOutputBuffer);
                            if (b4 != null) {
                                b4.position(bufferInfo.offset);
                                b4.limit(bufferInfo.offset + bufferInfo.size);
                                WLogger.d(f42088a, "media muxer write video data outputindex " + this.f42103p);
                                synchronized (this.f42097h) {
                                    this.f42097h.writeSampleData(this.f42104q, b4, bufferInfo);
                                }
                                this.f42096g.releaseOutputBuffer(dequeueOutputBuffer, false);
                                return;
                            }
                            str = f42088a;
                            str2 = "encoderOutputBuffer " + dequeueOutputBuffer + " was null";
                        }
                    }
                    WLogger.e(str, str2);
                } catch (Exception e10) {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    e10.printStackTrace(printWriter);
                    String stringWriter2 = stringWriter.toString();
                    try {
                        stringWriter.close();
                        printWriter.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    WLogger.e(f42088a, stringWriter2);
                    e10.printStackTrace();
                }
            }
        }
    }

    public void encodeH264() {
        String str;
        String str2;
        String str3;
        String str4;
        CountDownLatch countDownLatch;
        if (this.f42102o && this.f42108u) {
            WLogger.d(f42088a, "Encoder started");
            if (this.f42106s && this.f42093d.size() == 0) {
                return;
            }
            YuvImage poll = this.f42093d.poll();
            if (poll == null) {
                synchronized (this.f42099j) {
                    countDownLatch = new CountDownLatch(1);
                    this.f42101l = countDownLatch;
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                poll = this.f42093d.poll();
            }
            if (poll != null) {
                try {
                    byte[] a10 = a(f42089m, f42090n, poll);
                    int dequeueInputBuffer = this.f42096g.dequeueInputBuffer(200000L);
                    long a11 = a(this.f42103p, 30);
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer a12 = a(a.VideoType, dequeueInputBuffer);
                        a12.clear();
                        a12.put(a10);
                        this.f42096g.queueInputBuffer(dequeueInputBuffer, 0, a10.length, a11, 0);
                        this.f42103p++;
                    }
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int dequeueOutputBuffer = this.f42096g.dequeueOutputBuffer(bufferInfo, 200000L);
                    if (dequeueOutputBuffer != -1) {
                        if (dequeueOutputBuffer == -2) {
                            str = f42088a;
                            str2 = "start output";
                        } else if (dequeueOutputBuffer < 0) {
                            str3 = f42088a;
                            str4 = "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer;
                        } else {
                            if (bufferInfo.size == 0) {
                                return;
                            }
                            ByteBuffer b4 = b(a.VideoType, dequeueOutputBuffer);
                            int i10 = bufferInfo.size;
                            byte[] bArr = new byte[i10];
                            b4.get(bArr);
                            if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && bArr[4] == 103) {
                                this.f42111x = bArr;
                            } else if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && bArr[4] == 101) {
                                byte[] bArr2 = this.f42111x;
                                byte[] bArr3 = new byte[bArr2.length + i10];
                                System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, bArr2.length);
                                System.arraycopy((Object) bArr, 0, (Object) bArr3, this.f42111x.length, i10);
                                bArr = bArr3;
                            }
                            this.f42112y.write(bArr);
                            this.f42096g.releaseOutputBuffer(dequeueOutputBuffer, false);
                            str = f42088a;
                            str2 = "videoEncoder releaseOutputBuffer";
                        }
                        WLogger.d(str, str2);
                        return;
                    }
                    str3 = f42088a;
                    str4 = "No output from encoder available";
                    WLogger.e(str3, str4);
                } catch (Exception e10) {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    e10.printStackTrace(printWriter);
                    String stringWriter2 = stringWriter.toString();
                    try {
                        stringWriter.close();
                        printWriter.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    WLogger.e(f42088a, stringWriter2);
                    e10.printStackTrace();
                }
            }
        }
    }

    public int getColorFormat() {
        return this.f42110w;
    }

    public int getYUVImageSize() {
        return this.f42093d.size();
    }

    public boolean isEncodingStarted() {
        return this.f42108u;
    }

    public void queueFrame(YuvImage yuvImage) {
        if (!this.f42102o || this.f42096g == null || this.f42097h == null) {
            return;
        }
        WLogger.d(f42088a, "Queueing frame");
        this.f42093d.add(yuvImage);
        synchronized (this.f42099j) {
            CountDownLatch countDownLatch = this.f42101l;
            if (countDownLatch != null && countDownLatch.getCount() > 0) {
                this.f42101l.countDown();
            }
        }
    }

    public void queueFrameH264(YuvImage yuvImage) {
        if (this.f42102o && this.f42096g != null) {
            this.f42093d.add(yuvImage);
            synchronized (this.f42099j) {
                CountDownLatch countDownLatch = this.f42101l;
                if (countDownLatch != null && countDownLatch.getCount() > 0) {
                    this.f42101l.countDown();
                }
            }
        }
    }

    public void startEncoding(int i10, int i11, File file, int i12, int i13, int i14) {
        String str = f42088a;
        WLogger.d(str, "startEncoding");
        if (this.f42102o) {
            f42089m = i10;
            f42090n = i11;
            this.f42092c = file;
            try {
                String canonicalPath = file.getCanonicalPath();
                WLogger.d(str, "new MediaMuxer");
                if (this.f42097h == null) {
                    this.f42097h = new MediaMuxer(canonicalPath, 0);
                }
                WLogger.d(str, "selectCodec");
                MediaCodecInfo a10 = a(ah.f2598d);
                if (a10 == null) {
                    WLogger.e(str, "Unable to find an appropriate codec for video/avc");
                    return;
                }
                WLogger.i(str, "found codec: " + a10.getName());
                this.f42109v = 21;
                try {
                    int a11 = a(a10, ah.f2598d);
                    this.f42109v = a11;
                    this.f42110w = a11;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    WLogger.e(f42088a, "Unable to find color format use default");
                    this.f42109v = 21;
                }
                try {
                    this.f42096g = MediaCodec.createByCodecName(a10.getName());
                    String str2 = f42088a;
                    WLogger.d(str2, "Create videoEncoder createByCodecName");
                    try {
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(ah.f2598d, f42089m, f42090n);
                        createVideoFormat.setInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i12);
                        createVideoFormat.setInteger("frame-rate", i13);
                        createVideoFormat.setInteger("color-format", this.f42109v);
                        createVideoFormat.setInteger("i-frame-interval", i14);
                        this.f42096g.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.f42096g.start();
                        WLogger.i(str2, "Initialization complete. Starting encoder..." + Thread.currentThread().getName());
                        this.f42108u = true;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        WLogger.e(f42088a, "encoder configure failed:" + e10.toString());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    WLogger.w(f42088a, "Unable to create MediaCodec " + e11.toString());
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                WLogger.w(f42088a, "Unable to get path for " + ((Object) file) + "," + e12.toString());
            }
        }
    }

    public void startEncodingH264(int i10, int i11, ByteArrayOutputStream byteArrayOutputStream, int i12, int i13, int i14) {
        String str = f42088a;
        WLogger.d(str, "startEncoding:" + i10 + "," + i11);
        if (this.f42102o) {
            f42089m = i10;
            f42090n = i11;
            this.f42112y = byteArrayOutputStream;
            WLogger.d(str, "selectCodec");
            MediaCodecInfo a10 = a(ah.f2598d);
            if (a10 == null) {
                WLogger.e(str, "Unable to find an appropriate codec for video/avc");
                return;
            }
            WLogger.i(str, "found codec: " + a10.getName());
            this.f42109v = 21;
            try {
                int a11 = a(a10, ah.f2598d);
                this.f42109v = a11;
                this.f42110w = a11;
            } catch (Exception e2) {
                e2.printStackTrace();
                WLogger.e(f42088a, "Unable to find color format use default");
                this.f42109v = 21;
            }
            try {
                this.f42096g = MediaCodec.createByCodecName(a10.getName());
                String str2 = f42088a;
                WLogger.d(str2, "Create videoEncoder createByCodecName");
                try {
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(ah.f2598d, f42089m, f42090n);
                    createVideoFormat.setInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i12);
                    createVideoFormat.setInteger("frame-rate", i13);
                    createVideoFormat.setInteger("color-format", this.f42109v);
                    createVideoFormat.setInteger("i-frame-interval", i14);
                    this.f42096g.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.f42096g.start();
                    WLogger.i(str2, "Initialization complete. Starting encoder..." + Thread.currentThread().getName());
                    this.f42108u = true;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    WLogger.e(f42088a, "encoder configure failed:" + e10.toString());
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                WLogger.w(f42088a, "Unable to create MediaCodec " + e11.toString());
            }
        }
    }

    public void stopEncoding() {
        this.f42108u = false;
        if (!this.f42102o || this.f42096g == null || this.f42097h == null) {
            return;
        }
        WLogger.i(f42088a, "Stopping encoding");
        this.f42106s = true;
        synchronized (this.f42099j) {
            CountDownLatch countDownLatch = this.f42101l;
            if (countDownLatch != null && countDownLatch.getCount() > 0) {
                this.f42101l.countDown();
            }
        }
        a();
    }

    public void stopEncodingH264() {
        this.f42108u = false;
        if (this.f42102o && this.f42096g != null) {
            WLogger.i(f42088a, "Stopping encodingH264");
            this.f42106s = true;
            synchronized (this.f42099j) {
                CountDownLatch countDownLatch = this.f42101l;
                if (countDownLatch != null && countDownLatch.getCount() > 0) {
                    this.f42101l.countDown();
                }
            }
            a();
        }
    }
}
