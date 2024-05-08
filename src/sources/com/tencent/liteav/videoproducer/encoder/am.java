package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.SpsInfo;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.bq;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class am {
    private long A;
    private long B;
    private long C;
    private long D;
    private final Deque<Long> E;
    private int F;
    private final AtomicLong G;
    private final List<Long> H;
    private final AtomicLong I;

    /* renamed from: a, reason: collision with root package name */
    public String f44525a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f44526b;

    /* renamed from: c, reason: collision with root package name */
    public CustomHandler f44527c;

    /* renamed from: d, reason: collision with root package name */
    public MediaCodec f44528d;

    /* renamed from: e, reason: collision with root package name */
    public bq.a f44529e;

    /* renamed from: f, reason: collision with root package name */
    public VideoEncodeParams f44530f;

    /* renamed from: g, reason: collision with root package name */
    public long f44531g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.liteav.base.util.w f44532h;

    /* renamed from: i, reason: collision with root package name */
    public ServerVideoProducerConfig f44533i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f44534j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    private final IVideoReporter f44535k;

    /* renamed from: l, reason: collision with root package name */
    private final VideoProducerDef.StreamType f44536l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f44537m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f44538n;

    /* renamed from: o, reason: collision with root package name */
    private long f44539o;

    /* renamed from: p, reason: collision with root package name */
    private long f44540p;

    /* renamed from: q, reason: collision with root package name */
    private long f44541q;

    /* renamed from: r, reason: collision with root package name */
    private int f44542r;

    /* renamed from: s, reason: collision with root package name */
    private final Deque<Long> f44543s;

    /* renamed from: t, reason: collision with root package name */
    private long f44544t;

    /* renamed from: u, reason: collision with root package name */
    private long f44545u;

    /* renamed from: v, reason: collision with root package name */
    private long f44546v;

    /* renamed from: w, reason: collision with root package name */
    private long f44547w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f44548x;

    /* renamed from: y, reason: collision with root package name */
    private double f44549y;

    /* renamed from: z, reason: collision with root package name */
    private long f44550z;

    public am(Bundle bundle, @NonNull IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.f44537m = null;
        this.f44538n = true;
        this.f44531g = 0L;
        this.f44532h = null;
        this.f44539o = 0L;
        this.f44540p = 0L;
        this.f44541q = 0L;
        this.f44542r = -1;
        this.f44543s = new LinkedList();
        this.f44544t = 0L;
        this.f44545u = 0L;
        this.f44546v = 0L;
        this.f44547w = Long.MIN_VALUE;
        this.f44548x = false;
        this.f44549y = ShadowDrawableWrapper.COS_45;
        this.f44550z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = new LinkedList();
        this.F = 0;
        this.G = new AtomicLong(0L);
        this.H = new ArrayList();
        this.I = new AtomicLong(0L);
        this.f44534j = an.a(this);
        this.f44535k = iVideoReporter;
        this.f44526b = bundle;
        this.f44536l = streamType;
        this.f44525a = "SurfaceInputVideoEncoder_" + ((Object) streamType) + "_" + hashCode();
    }

    public static /* synthetic */ void a(am amVar) {
        if (amVar.f44529e != null) {
            LiteavLog.w(amVar.f44525a, "onRequestRestart");
            amVar.f44529e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ByteBuffer byteBuffer;
        int i10;
        byte[] a10;
        if (this.f44528d == null) {
            return;
        }
        while (true) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            try {
                int dequeueOutputBuffer = this.f44528d.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(4L));
                if (dequeueOutputBuffer == -1) {
                    break;
                }
                if (dequeueOutputBuffer == -3) {
                    LiteavLog.i(this.f44525a, "encoder output buffers changed");
                } else {
                    boolean z10 = true;
                    if (dequeueOutputBuffer == -2) {
                        try {
                            MediaFormat outputFormat = this.f44528d.getOutputFormat();
                            bq.a aVar = this.f44529e;
                            if (aVar != null) {
                                aVar.onOutputFormatChanged(outputFormat);
                            }
                            LiteavLog.i(this.f44525a, "encoder output format changed: %s", outputFormat);
                        } catch (Throwable th) {
                            a("getOutputFormat failed." + th.getMessage());
                        }
                    } else {
                        if (dequeueOutputBuffer < 0) {
                            a("dequeueOutputBuffer return ".concat(String.valueOf(dequeueOutputBuffer)));
                            break;
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        this.H.add(Long.valueOf(elapsedRealtime - this.G.getAndSet(elapsedRealtime)));
                        try {
                            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                                byteBuffer = this.f44528d.getOutputBuffer(dequeueOutputBuffer);
                            } else {
                                byteBuffer = this.f44528d.getOutputBuffers()[dequeueOutputBuffer];
                            }
                            if (byteBuffer != null && ((i10 = bufferInfo.size) != 0 || (bufferInfo.flags & 4) != 0)) {
                                byte[] a11 = com.tencent.liteav.videobase.utils.j.a(i10);
                                if (a11 == null) {
                                    a10 = null;
                                } else {
                                    byteBuffer.position(bufferInfo.offset);
                                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                    byteBuffer.get(a11);
                                    a10 = a(a11);
                                    VideoEncodeParams videoEncodeParams = this.f44530f;
                                    if (videoEncodeParams != null && !videoEncodeParams.annexb) {
                                        a10 = b(a10);
                                    }
                                }
                                if (a10 == null) {
                                    a("modifyEncodedData return null byte array");
                                } else {
                                    int i11 = bufferInfo.flags;
                                    boolean z11 = (i11 & 2) > 0;
                                    boolean z12 = (i11 & 1) > 0;
                                    if (z11 && z12) {
                                        VideoEncodeParams videoEncodeParams2 = this.f44530f;
                                        boolean z13 = videoEncodeParams2 == null || videoEncodeParams2.codecType == CodecType.H264;
                                        if (videoEncodeParams2 != null && !videoEncodeParams2.annexb) {
                                            z10 = false;
                                        }
                                        this.f44537m = SpsInfo.nativeGetSpsPps(a10, z13, z10);
                                        a(a10, bufferInfo);
                                    } else if (z11) {
                                        this.f44537m = (byte[]) a10.clone();
                                    } else {
                                        if (this.f44538n && z12) {
                                            byte[] bArr = this.f44537m;
                                            if (bArr != null) {
                                                byte[] a12 = com.tencent.liteav.videobase.utils.j.a(bArr.length + a10.length);
                                                if (a12 != null) {
                                                    byte[] bArr2 = this.f44537m;
                                                    System.arraycopy((Object) bArr2, 0, (Object) a12, 0, bArr2.length);
                                                    System.arraycopy((Object) a10, 0, (Object) a12, this.f44537m.length, a10.length);
                                                    a10 = a12;
                                                } else {
                                                    a("add spspps for I frame, allocate buffer failed.");
                                                }
                                            } else {
                                                a("mSpsPps is null.");
                                            }
                                        }
                                        a(a10, bufferInfo);
                                    }
                                }
                            } else {
                                a("size is zero, but it isn't end of stream");
                            }
                            try {
                                this.f44528d.releaseOutputBuffer(dequeueOutputBuffer, false);
                            } catch (Throwable th2) {
                                a("releaseOutputBuffer failed." + th2.getMessage());
                            }
                        } catch (Throwable th3) {
                            a("getOutputBuffer failed." + th3.getMessage());
                        }
                    }
                }
            } catch (Throwable th4) {
                a("dequeueOutputBuffer failed." + th4.getMessage());
            }
        }
        synchronized (this.f44543s) {
            if (this.f44543s.isEmpty()) {
                return;
            }
            int i12 = this.f44530f.fps;
            int i13 = i12 != 0 ? 500 / i12 : 10;
            if (this.f44527c.hasMessages(10)) {
                return;
            }
            this.f44527c.sendEmptyMessageDelayed(10, i13);
        }
    }

    private void i() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime <= this.f44550z + TimeUnit.SECONDS.toMillis(2L)) {
            this.A++;
            return;
        }
        this.f44549y = (this.A * 1000.0d) / (elapsedRealtime - this.f44550z);
        this.A = 1L;
        this.f44550z = elapsedRealtime;
        long j10 = -1;
        Iterator<Long> iterator2 = this.H.iterator2();
        while (iterator2.hasNext()) {
            long longValue = iterator2.next().longValue();
            if (j10 < longValue) {
                j10 = longValue;
            }
        }
        this.I.set(j10);
        this.H.clear();
    }

    private long j() {
        long longValue;
        synchronized (this.f44543s) {
            Long pollFirst = this.f44543s.pollFirst();
            longValue = pollFirst == null ? 0L : pollFirst.longValue();
        }
        return longValue;
    }

    private void k() {
        Long peekFirst;
        if (this.E.isEmpty()) {
            return;
        }
        int i10 = this.f44530f.fps;
        if (((float) (i10 - this.f44549y)) <= Math.max(i10 / 2.0f, 5.0f) && (peekFirst = this.E.peekFirst()) != null && SystemClock.elapsedRealtime() > peekFirst.longValue()) {
            this.E.removeFirst();
            if (this.F - this.B > Math.max(this.f44530f.bitrate / 2, 100)) {
                LiteavLog.w(this.f44525a, "restart hardware encoder because real bitrate is too low.expectBitrate: " + this.F + ", realBitrate=" + this.B);
                this.f44526b.putBoolean("need_restart_when_down_bitrate", true);
                this.f44534j.run();
                this.E.clear();
            }
        }
    }

    public final void c() {
        this.f44527c.post(au.a(this));
    }

    public final void d() {
        LiteavLog.i(this.f44525a, "stopSync");
        this.f44527c.runAndWaitDone(aw.a(this), 2000L);
    }

    public final void e() {
        LiteavLog.d(this.f44525a, "uninitialize");
        this.f44527c.quitLooper();
    }

    public final void f() {
        if (this.f44532h != null) {
            LiteavLog.i(this.f44525a, "stopEosTimer");
            this.f44532h.a();
            this.f44532h = null;
        }
    }

    public final void g() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 19 || this.f44528d == null) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.f44528d.setParameters(bundle);
        } catch (Throwable th) {
            LiteavLog.e(this.f44525a, "requestSyncFrame failed.", th);
        }
    }

    public final void b() {
        this.f44527c.post(at.a(this));
    }

    public final void b(int i10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i11 = 1; i11 <= 3; i11++) {
            this.E.addLast(Long.valueOf((i11 * 2000) + elapsedRealtime));
        }
        this.F = i10;
    }

    public final void a() {
        LiteavLog.d(this.f44525a, "initialize");
        HandlerThread handlerThread = new HandlerThread("hw-video-encoder");
        handlerThread.start();
        this.f44527c = new CustomHandler(handlerThread.getLooper()) { // from class: com.tencent.liteav.videoproducer.encoder.am.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 10) {
                    am.this.h();
                }
            }
        };
    }

    private static byte[] b(byte[] bArr) {
        int i10;
        int length = bArr.length;
        ArrayList<int[]> arrayList = new ArrayList(20);
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 <= length) {
            int i14 = i11 + 2;
            if (i14 < length && bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i14] == 1) {
                i10 = 3;
            } else {
                int i15 = i11 + 3;
                i10 = (i15 < length && bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i14] == 0 && bArr[i15] == 1) ? 4 : 1;
            }
            if (i10 == 3 || i10 == 4 || i11 == length) {
                if (i13 != i11) {
                    arrayList.add(new int[]{i13, i11});
                    i12 += i11 - i13;
                }
                i13 = i11 + i10;
            }
            i11 += i10;
        }
        byte[] a10 = com.tencent.liteav.videobase.utils.j.a(i12 + (arrayList.size() * 4));
        if (a10 == null) {
            return bArr;
        }
        int i16 = 0;
        for (int[] iArr : arrayList) {
            int i17 = iArr[1] - iArr[0];
            ByteBuffer order = ByteBuffer.wrap(new byte[4]).order(ByteOrder.BIG_ENDIAN);
            order.putInt(i17);
            System.arraycopy((Object) order.array(), 0, (Object) a10, i16, 4);
            int i18 = i16 + 4;
            System.arraycopy((Object) bArr, iArr[0], (Object) a10, i18, i17);
            i16 = i18 + i17;
        }
        return a10;
    }

    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44527c.post(aq.a(this, serverVideoProducerConfig));
    }

    public final Pair<Surface, Size> a(VideoEncodeParams videoEncodeParams, bq.a aVar) {
        LiteavLog.d(this.f44525a, "start");
        Surface[] surfaceArr = new Surface[1];
        LiteavLog.i(this.f44525a, "startCodecInternal success: ".concat(String.valueOf(this.f44527c.runAndWaitDone(ar.a(this, aVar, surfaceArr, videoEncodeParams), 5000L))));
        Size size = new Size(MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280);
        VideoEncodeParams videoEncodeParams2 = this.f44530f;
        if (videoEncodeParams2 != null) {
            size.set(videoEncodeParams2.width, videoEncodeParams2.height);
        }
        return new Pair<>(surfaceArr[0], size);
    }

    public final void a(long j10) {
        synchronized (this.f44543s) {
            if (this.f44543s.isEmpty()) {
                this.G.set(SystemClock.elapsedRealtime());
            }
            this.f44543s.addLast(Long.valueOf(j10));
        }
        this.f44527c.sendEmptyMessageDelayed(10, 10L);
    }

    private MediaCodec b(String str) throws Throwable {
        String str2;
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        try {
            str2 = createEncoderByType.getName();
        } catch (Throwable th) {
            LiteavLog.e(this.f44525a, "mediaCodec getName failed.", th);
            str2 = null;
        }
        LiteavLog.i(this.f44525a, "codecName=".concat(String.valueOf(str2)));
        if (str2 == null || !str2.equals("OMX.google.h264.encoder")) {
            return createEncoderByType;
        }
        LiteavLog.w(this.f44525a, "will be destroyed codecName=".concat(str2));
        a(createEncoderByType);
        throw new IOException("this is a Google H264 soft encoder. cancel use MediaCodec.");
    }

    public final void a(int i10) {
        this.f44527c.post(as.a(this, i10));
    }

    public final void a(MediaCodec mediaCodec, int i10) {
        if (mediaCodec == null || LiteavSystemInfo.getSystemOSVersionInt() < 19) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i10 * 1024);
            mediaCodec.setParameters(bundle);
        } catch (Throwable th) {
            LiteavLog.e(this.f44525a, "updateBitrateToMediaCodec failed.", th);
        }
    }

    public final void a(String str) {
        LiteavLog.e(this.f44525a, "notifyEncodeError message = ".concat(String.valueOf(str)));
        this.f44527c.post(av.a(this));
    }

    private void a(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
        boolean z10 = true;
        boolean z11 = (bufferInfo.flags & 1) > 0;
        a(z11);
        a(z11, bArr.length);
        i();
        if (z11) {
            this.f44540p++;
            this.f44541q = 0L;
        } else {
            this.f44541q++;
        }
        this.f44539o++;
        long j10 = j();
        long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
        if (this.f44544t == 0) {
            this.f44544t = j10;
        }
        if (this.f44545u == 0) {
            this.f44545u = millis;
        }
        long j11 = millis + (this.f44544t - this.f44545u);
        long j12 = this.f44546v;
        if (j10 <= j12) {
            j10 = j12 + 1;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        this.f44546v = j10;
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        VideoEncodeParams videoEncodeParams = this.f44530f;
        if (videoEncodeParams != null && videoEncodeParams.isEnablesUnlimitedGop()) {
            encodedVideoFrame.nalType = z11 ? com.tencent.liteav.videobase.common.c.IDR : com.tencent.liteav.videobase.common.c.P_MULTI_REF;
        } else {
            encodedVideoFrame.nalType = z11 ? com.tencent.liteav.videobase.common.c.IDR : com.tencent.liteav.videobase.common.c.P;
        }
        ByteBuffer b4 = com.tencent.liteav.videobase.utils.j.b(bArr.length);
        encodedVideoFrame.data = b4;
        if (b4 == null) {
            a("allocate direct buffer for nal failed");
            return;
        }
        b4.put(bArr);
        encodedVideoFrame.data.rewind();
        encodedVideoFrame.dts = j10;
        encodedVideoFrame.pts = j11;
        encodedVideoFrame.info = bufferInfo;
        encodedVideoFrame.gopIndex = this.f44540p;
        long j13 = this.f44541q;
        encodedVideoFrame.frameIndex = j13;
        encodedVideoFrame.gopFrameIndex = j13;
        if (!z11) {
            j13--;
        }
        encodedVideoFrame.refFrameIndex = j13;
        encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.d.BASELINE;
        VideoEncodeParams videoEncodeParams2 = this.f44530f;
        encodedVideoFrame.codecType = videoEncodeParams2.codecType;
        encodedVideoFrame.width = videoEncodeParams2.width;
        encodedVideoFrame.height = videoEncodeParams2.height;
        if ((bufferInfo.flags & 4) > 0) {
            f();
        } else {
            a(encodedVideoFrame);
            z10 = false;
        }
        bq.a aVar = this.f44529e;
        if (aVar != null) {
            aVar.onEncodedNAL(encodedVideoFrame, z10);
        }
    }

    public am(Bundle bundle, @NonNull IVideoReporter iVideoReporter, String str) {
        this.f44537m = null;
        this.f44538n = true;
        this.f44531g = 0L;
        this.f44532h = null;
        this.f44539o = 0L;
        this.f44540p = 0L;
        this.f44541q = 0L;
        this.f44542r = -1;
        this.f44543s = new LinkedList();
        this.f44544t = 0L;
        this.f44545u = 0L;
        this.f44546v = 0L;
        this.f44547w = Long.MIN_VALUE;
        this.f44548x = false;
        this.f44549y = ShadowDrawableWrapper.COS_45;
        this.f44550z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = new LinkedList();
        this.F = 0;
        this.G = new AtomicLong(0L);
        this.H = new ArrayList();
        this.I = new AtomicLong(0L);
        this.f44534j = ap.a(this);
        this.f44535k = iVideoReporter;
        this.f44526b = bundle;
        this.f44536l = VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO;
        this.f44525a = str + "SurfaceInputVideoEncoder_" + hashCode();
    }

    private void a(EncodedVideoFrame encodedVideoFrame) {
        boolean z10 = this.f44530f.enableBFrame;
        if (!z10 && !this.f44548x && encodedVideoFrame.pts < this.f44547w) {
            LiteavLog.i(this.f44525a, "has B frame,isEnablesBframe=%b,mLastPresentationTimestamp=%d,packet.pts=%d", Boolean.valueOf(z10), Long.valueOf(this.f44547w), Long.valueOf(encodedVideoFrame.pts));
            this.f44548x = true;
            PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
            persistStorage.put("Liteav.Video.android.local.rtc.enable.high.profile", 0);
            persistStorage.commit();
            bq.a aVar = this.f44529e;
            if (aVar != null) {
                aVar.a();
            }
        }
        this.f44547w = encodedVideoFrame.pts;
    }

    private void a(boolean z10) {
        if (z10) {
            this.f44542r = -1;
        }
        VideoEncodeParams videoEncodeParams = this.f44530f;
        if (videoEncodeParams == null || videoEncodeParams.fullIFrame) {
            return;
        }
        int i10 = this.f44542r + 1;
        this.f44542r = i10;
        if (i10 == videoEncodeParams.fps * videoEncodeParams.gop) {
            g();
        }
    }

    public final Surface a(VideoEncodeParams videoEncodeParams) {
        ServerVideoProducerConfig serverVideoProducerConfig;
        Surface surface;
        MediaCodec mediaCodec;
        this.f44531g = SystemClock.elapsedRealtime();
        this.f44547w = Long.MIN_VALUE;
        if (videoEncodeParams.bitrate == 0) {
            int i10 = videoEncodeParams.width;
            int i11 = videoEncodeParams.height;
            videoEncodeParams.bitrate = (int) (Math.sqrt((i10 * i10) + (i11 * i11)) * 1.2d);
        }
        VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
        this.f44530f = videoEncodeParams2;
        this.f44539o = videoEncodeParams2.baseFrameIndex;
        this.f44540p = videoEncodeParams2.baseGopIndex;
        this.f44541q = 0L;
        String str = videoEncodeParams2.codecType == CodecType.H265 ? "video/hevc" : com.alibaba.security.biometrics.service.build.ah.f2598d;
        VideoEncoderDef.EncoderProfile encoderProfile = videoEncodeParams2.encoderProfile;
        VideoEncoderDef.EncoderProfile encoderProfile2 = VideoEncoderDef.EncoderProfile.PROFILE_MAIN;
        if (encoderProfile == encoderProfile2) {
            videoEncodeParams2.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        }
        VideoEncoderDef.EncoderProfile encoderProfile3 = videoEncodeParams2.encoderProfile;
        VideoEncoderDef.EncoderProfile encoderProfile4 = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        if ((encoderProfile3 == encoderProfile4 || encoderProfile3 == encoderProfile2) && (serverVideoProducerConfig = this.f44533i) != null && !serverVideoProducerConfig.isHardwareEncoderHighProfileAllowed()) {
            this.f44530f.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
        }
        VideoEncodeParams videoEncodeParams3 = this.f44530f;
        VideoEncoderDef.EncoderProfile encoderProfile5 = videoEncodeParams3.encoderProfile;
        if ((encoderProfile5 == encoderProfile4 || encoderProfile5 == encoderProfile2) && !videoEncodeParams3.enableBFrame) {
            Integer num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt("Liteav.Video.android.local.rtc.enable.high.profile");
            LiteavLog.i(this.f44525a, "enable high profile from persist storage:".concat(String.valueOf(num)));
            if (num != null && num.intValue() == 0) {
                this.f44530f.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
            }
        }
        try {
            MediaCodec b4 = b(str);
            try {
                x xVar = new x(b4, str, this.f44530f, this.f44533i);
                boolean z10 = true;
                xVar.f44724a = true;
                MediaFormat a10 = xVar.a();
                if (!a(b4, a10)) {
                    xVar.f44725b = false;
                    a10 = xVar.a();
                    if (!a(b4, a10)) {
                        z10 = false;
                    }
                }
                if (z10) {
                    Surface createInputSurface = b4.createInputSurface();
                    try {
                        b4.start();
                        try {
                            this.f44530f.width = a10.getInteger("width");
                            this.f44530f.height = a10.getInteger("height");
                            this.f44530f.bitrate = a10.getInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) / 1024;
                            int i12 = this.f44530f.bitrate;
                            if (LiteavSystemInfo.getSystemOSVersionInt() > 30) {
                                LiteavLog.i(this.f44525a, "resetBitrateAfterApiLevel30,bitrate=".concat(String.valueOf(i12)));
                                a(b4, i12);
                            }
                        } catch (Throwable th) {
                            LiteavLog.e(this.f44525a, "MediaFormat get key fail", th);
                        }
                        LiteavLog.i(this.f44525a, "start MediaCodec with format: ".concat(String.valueOf(a10)));
                        this.f44528d = b4;
                        return createInputSurface;
                    } catch (Throwable th2) {
                        surface = createInputSurface;
                        th = th2;
                        mediaCodec = b4;
                        if (surface != null) {
                            surface.release();
                        }
                        a(mediaCodec);
                        h.c cVar = h.c.WARNING_VIDEO_ENCODE_START_FAILED;
                        String str2 = "Start encoder failed:" + th.getMessage();
                        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && (th instanceof MediaCodec.CodecException) && th.getErrorCode() == 1100) {
                            cVar = h.c.WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE;
                            str2 = "Insufficient resource, Start encoder failed:" + th.getMessage();
                        }
                        this.f44535k.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_HW_ENCODE_START_ERROR_TYPE, this.f44536l.mValue, Integer.valueOf(cVar.mValue));
                        this.f44535k.notifyWarning(cVar, str2);
                        LiteavLog.e(this.f44525a, "Start MediaCodec failed,encode params:" + ((Object) this.f44530f), th);
                        return null;
                    }
                }
                throw new IOException("configure encoder failed.");
            } catch (Throwable th3) {
                th = th3;
                mediaCodec = b4;
                surface = null;
            }
        } catch (Throwable th4) {
            th = th4;
            surface = null;
            mediaCodec = null;
        }
    }

    private boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return false;
        }
        try {
            LiteavLog.i(this.f44525a, "configure format: %s", mediaFormat);
            mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Throwable th) {
            LiteavLog.e(this.f44525a, "configure failed.", th);
            return false;
        }
    }

    private void a(boolean z10, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (z10) {
            if (elapsedRealtime > 1000 + this.C) {
                this.B = (long) (((this.D * 8000.0d) / (elapsedRealtime - r2)) / 1024.0d);
                this.D = 0L;
                this.C = elapsedRealtime;
                k();
            }
        }
        this.D += j10;
    }

    private static byte[] a(byte[] bArr) {
        byte[] a10;
        if (bArr.length > 5 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 3;
                if (i11 >= bArr.length) {
                    i10 = 0;
                    break;
                }
                if ((bArr[i10] == 0 && bArr[i10 + 1] == 0 && bArr[i10 + 2] == 0 && bArr[i11] == 1) || (bArr[i10] == 0 && bArr[i10 + 1] == 0 && bArr[i10 + 2] == 1)) {
                    break;
                }
                i10++;
            }
            if (i10 == 0 || (a10 = com.tencent.liteav.videobase.utils.j.a(bArr.length - i10)) == null) {
                return bArr;
            }
            System.arraycopy((Object) bArr, i10, (Object) a10, 0, a10.length);
            return a10;
        }
        return bArr;
    }

    public final void a(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Throwable th) {
                LiteavLog.e(this.f44525a, "destroy mediaCodec stop failed.", th);
            }
            try {
                mediaCodec.release();
            } catch (Throwable th2) {
                LiteavLog.e(this.f44525a, "destroy mediaCodec release failed.", th2);
            }
            LiteavLog.i(this.f44525a, "destroy mediaCodec");
        }
    }
}
