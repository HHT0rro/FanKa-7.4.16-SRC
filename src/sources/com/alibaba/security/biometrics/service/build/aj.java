package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import android.view.Surface;
import com.alibaba.security.biometrics.jni.YuvEngineWrap;
import com.alibaba.security.biometrics.service.build.ah;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: MediaCodeApi15CameraVideoRecorder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aj extends ah {

    /* renamed from: l, reason: collision with root package name */
    public MediaCodec f2619l;

    /* renamed from: m, reason: collision with root package name */
    private long f2620m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f2621n;

    /* renamed from: o, reason: collision with root package name */
    private MediaCodec.BufferInfo f2622o;

    /* renamed from: p, reason: collision with root package name */
    private al f2623p;

    /* renamed from: q, reason: collision with root package name */
    private LinkedBlockingQueue<byte[]> f2624q;

    /* renamed from: r, reason: collision with root package name */
    private Thread f2625r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f2626s;

    /* renamed from: t, reason: collision with root package name */
    private ak f2627t;

    /* renamed from: u, reason: collision with root package name */
    private long f2628u;

    /* renamed from: v, reason: collision with root package name */
    private long f2629v;

    /* renamed from: w, reason: collision with root package name */
    private long f2630w;

    /* renamed from: x, reason: collision with root package name */
    private int f2631x;

    /* renamed from: y, reason: collision with root package name */
    private byte[] f2632y;

    public aj(Context context) {
        super(context);
        this.f2631x = -1;
        this.f2627t = new ak(context);
        this.f2622o = new MediaCodec.BufferInfo();
        this.f2624q = new LinkedBlockingQueue<>();
    }

    private static boolean a(int i10) {
        return i10 == 19 || i10 == 21;
    }

    private void c(byte[] bArr) {
        try {
            int i10 = this.f2631x;
            if (i10 == 21) {
                YuvEngineWrap.getInstance().Nv21ToNv12(bArr, this.f2632y, this.f2602g, this.f2603h);
            } else if (i10 == 19) {
                YuvEngineWrap.getInstance().Nv21ToI420(bArr, this.f2632y, this.f2602g, this.f2603h);
            } else if (i10 == 39) {
                System.arraycopy((Object) bArr, 0, (Object) this.f2632y, 0, ((this.f2602g * this.f2603h) * 3) / 2);
            } else if (i10 == 20) {
                YuvEngineWrap.getInstance().Nv21ToYv12(bArr, this.f2632y, this.f2602g, this.f2603h);
            }
            ByteBuffer[] inputBuffers = this.f2619l.getInputBuffers();
            int dequeueInputBuffer = this.f2619l.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(this.f2632y);
                long currentTimeMillis = (System.currentTimeMillis() * 1000) - this.f2620m;
                if (this.f2621n) {
                    this.f2619l.queueInputBuffer(dequeueInputBuffer, 0, this.f2632y.length, currentTimeMillis, 4);
                } else {
                    this.f2619l.queueInputBuffer(dequeueInputBuffer, 0, this.f2632y.length, currentTimeMillis, 0);
                }
            }
            ByteBuffer[] outputBuffers = this.f2619l.getOutputBuffers();
            int dequeueOutputBuffer = this.f2619l.dequeueOutputBuffer(this.f2622o, 10000L);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f2619l.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.f2619l.getOutputFormat();
                if (this.f2623p != null && !this.f2621n) {
                    al alVar = this.f2623p;
                    MediaMuxer mediaMuxer = alVar.f2641a;
                    if (mediaMuxer != null) {
                        alVar.f2643c = mediaMuxer.addTrack(outputFormat);
                    }
                    alVar.a();
                }
            }
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 == null) {
                    return;
                }
                MediaCodec.BufferInfo bufferInfo = this.f2622o;
                if ((bufferInfo.flags & 2) != 0) {
                    bufferInfo.size = 0;
                }
                if (bufferInfo.size != 0 && this.f2623p != null && !this.f2621n) {
                    long j10 = this.f2629v;
                    if (j10 > 0) {
                        MediaCodec.BufferInfo bufferInfo2 = this.f2622o;
                        if (bufferInfo2.presentationTimeUs < j10) {
                            bufferInfo2.presentationTimeUs = j10 + 10000;
                        }
                    }
                    MediaCodec.BufferInfo bufferInfo3 = this.f2622o;
                    long j11 = bufferInfo3.presentationTimeUs;
                    this.f2629v = j11;
                    long j12 = this.f2628u;
                    if (j12 == 0) {
                        this.f2628u = j11;
                    } else {
                        this.f2630w = j11 - j12;
                    }
                    byteBuffer2.position(bufferInfo3.offset);
                    MediaCodec.BufferInfo bufferInfo4 = this.f2622o;
                    byteBuffer2.limit(bufferInfo4.offset + bufferInfo4.size);
                    try {
                        this.f2623p.f2644d.put(new ah.b(byteBuffer2, this.f2622o));
                    } catch (InterruptedException unused) {
                    }
                }
                this.f2619l.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.f2619l.dequeueOutputBuffer(this.f2622o, 0L);
                if ((this.f2622o.flags & 4) != 0) {
                    this.f2625r.interrupt();
                    this.f2626s = false;
                    return;
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void d(byte[] bArr) {
        try {
            int i10 = this.f2631x;
            if (i10 == 21) {
                YuvEngineWrap.getInstance().Nv21ToNv12(bArr, this.f2632y, this.f2602g, this.f2603h);
            } else if (i10 == 19) {
                YuvEngineWrap.getInstance().Nv21ToI420(bArr, this.f2632y, this.f2602g, this.f2603h);
            } else if (i10 == 39) {
                System.arraycopy((Object) bArr, 0, (Object) this.f2632y, 0, ((this.f2602g * this.f2603h) * 3) / 2);
            } else if (i10 == 20) {
                YuvEngineWrap.getInstance().Nv21ToYv12(bArr, this.f2632y, this.f2602g, this.f2603h);
            }
            ByteBuffer[] inputBuffers = this.f2619l.getInputBuffers();
            int dequeueInputBuffer = this.f2619l.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(this.f2632y);
                long currentTimeMillis = (System.currentTimeMillis() * 1000) - this.f2620m;
                if (this.f2621n) {
                    this.f2619l.queueInputBuffer(dequeueInputBuffer, 0, this.f2632y.length, currentTimeMillis, 4);
                } else {
                    this.f2619l.queueInputBuffer(dequeueInputBuffer, 0, this.f2632y.length, currentTimeMillis, 0);
                }
            }
            ByteBuffer[] outputBuffers = this.f2619l.getOutputBuffers();
            int dequeueOutputBuffer = this.f2619l.dequeueOutputBuffer(this.f2622o, 10000L);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f2619l.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.f2619l.getOutputFormat();
                if (this.f2623p != null && !this.f2621n) {
                    al alVar = this.f2623p;
                    MediaMuxer mediaMuxer = alVar.f2641a;
                    if (mediaMuxer != null) {
                        alVar.f2643c = mediaMuxer.addTrack(outputFormat);
                    }
                    alVar.a();
                }
            }
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 == null) {
                    return;
                }
                MediaCodec.BufferInfo bufferInfo = this.f2622o;
                if ((bufferInfo.flags & 2) != 0) {
                    bufferInfo.size = 0;
                }
                if (bufferInfo.size != 0 && this.f2623p != null && !this.f2621n) {
                    long j10 = this.f2629v;
                    if (j10 > 0) {
                        MediaCodec.BufferInfo bufferInfo2 = this.f2622o;
                        if (bufferInfo2.presentationTimeUs < j10) {
                            bufferInfo2.presentationTimeUs = j10 + 10000;
                        }
                    }
                    MediaCodec.BufferInfo bufferInfo3 = this.f2622o;
                    long j11 = bufferInfo3.presentationTimeUs;
                    this.f2629v = j11;
                    long j12 = this.f2628u;
                    if (j12 == 0) {
                        this.f2628u = j11;
                    } else {
                        this.f2630w = j11 - j12;
                    }
                    byteBuffer2.position(bufferInfo3.offset);
                    MediaCodec.BufferInfo bufferInfo4 = this.f2622o;
                    byteBuffer2.limit(bufferInfo4.offset + bufferInfo4.size);
                    try {
                        this.f2623p.f2644d.put(new ah.b(byteBuffer2, this.f2622o));
                    } catch (InterruptedException unused) {
                    }
                }
                this.f2619l.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.f2619l.dequeueOutputBuffer(this.f2622o, 0L);
                if ((this.f2622o.flags & 4) != 0) {
                    this.f2625r.interrupt();
                    this.f2626s = false;
                    return;
                }
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final boolean a() {
        return false;
    }

    private void b(byte[] bArr) {
        try {
            LinkedBlockingQueue<byte[]> linkedBlockingQueue = this.f2624q;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.put(bArr);
            }
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final boolean a(int i10, int i11, int i12, int i13) {
        return b(i10, i11, i12, i13);
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final void a(byte[] bArr) {
        if (this.f2619l == null) {
            return;
        }
        try {
            LinkedBlockingQueue<byte[]> linkedBlockingQueue = this.f2624q;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.put(bArr);
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean b(int i10, int i11, int i12, int i13) {
        MediaCodecInfo mediaCodecInfo;
        try {
            ak akVar = this.f2627t;
            String str = akVar.f2638b;
            this.f2631x = akVar.f2639c;
            if (TextUtils.isEmpty(str) || this.f2631x == -1) {
                int codecCount = MediaCodecList.getCodecCount();
                int i14 = 0;
                loop0: while (true) {
                    if (i14 >= codecCount) {
                        mediaCodecInfo = null;
                        break;
                    }
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i14);
                    if (mediaCodecInfo.isEncoder()) {
                        for (String str2 : mediaCodecInfo.getSupportedTypes()) {
                            if (str2.equalsIgnoreCase(ah.f2598d)) {
                                break loop0;
                            }
                        }
                    }
                    i14++;
                }
                if (mediaCodecInfo == null) {
                    return false;
                }
                str = mediaCodecInfo.getName();
                ak akVar2 = this.f2627t;
                akVar2.f2638b = str;
                SharedPreferences.Editor edit = akVar2.f2637a.edit();
                edit.putString("libstreaming-encode-encodeName", str);
                edit.apply();
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(ah.f2598d);
                ArrayList arrayList = new ArrayList();
                int i15 = 0;
                while (true) {
                    int[] iArr = capabilitiesForType.colorFormats;
                    if (i15 >= iArr.length) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(iArr[i15]));
                    i15++;
                }
                int i16 = 0;
                while (true) {
                    if (i16 >= arrayList.size()) {
                        break;
                    }
                    int intValue = ((Integer) arrayList.get(i16)).intValue();
                    if (intValue == 19 || intValue == 21) {
                        this.f2631x = ((Integer) arrayList.get(i16)).intValue();
                        break;
                    }
                    i16++;
                }
                int i17 = this.f2631x;
                if (i17 == -1) {
                    return false;
                }
                ak akVar3 = this.f2627t;
                akVar3.f2639c = i17;
                SharedPreferences.Editor edit2 = akVar3.f2637a.edit();
                edit2.putInt("libstreaming-encode-colorFormat", i17);
                edit2.apply();
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(ah.f2598d, i10, i11);
            createVideoFormat.setInteger("bitrate-mode", 2);
            createVideoFormat.setInteger(FFmpegMediaMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i10 * i11 * 3);
            createVideoFormat.setInteger("frame-rate", i12);
            createVideoFormat.setInteger("color-format", this.f2631x);
            createVideoFormat.setInteger("i-frame-interval", 1);
            createVideoFormat.setInteger("rotation-degrees", i13);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            this.f2619l = createByCodecName;
            createByCodecName.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f2619l.start();
            this.f2621n = false;
            this.f2620m = System.currentTimeMillis() * 1000;
            this.f2632y = new byte[((this.f2602g * this.f2603h) * 3) / 2];
            al alVar = new al(this.f2601f);
            this.f2623p = alVar;
            alVar.a(this.f2605j, i13);
            Thread thread = new Thread("video_record_thread") { // from class: com.alibaba.security.biometrics.service.build.aj.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    while (aj.this.f2626s && !Thread.interrupted()) {
                        try {
                            aj.a(aj.this, (byte[]) aj.this.f2624q.take());
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
            };
            this.f2625r = thread;
            this.f2626s = true;
            thread.start();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final void a(boolean z10) {
        try {
            this.f2621n = true;
            MediaCodec mediaCodec = this.f2619l;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f2619l.release();
            }
            al alVar = this.f2623p;
            if (alVar != null) {
                alVar.b();
                al alVar2 = this.f2623p;
                alVar2.f2646f = false;
                Thread thread = alVar2.f2642b;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static List<Integer> a(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i10 >= iArr.length) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(iArr[i10]));
            i10++;
        }
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

    private void a(MediaCodec.BufferInfo bufferInfo) {
        long j10 = bufferInfo.presentationTimeUs;
        this.f2629v = j10;
        long j11 = this.f2628u;
        if (j11 == 0) {
            this.f2628u = j10;
        } else {
            this.f2630w = j10 - j11;
        }
    }

    public static /* synthetic */ void a(aj ajVar, byte[] bArr) {
        try {
            int i10 = ajVar.f2631x;
            if (i10 == 21) {
                YuvEngineWrap.getInstance().Nv21ToNv12(bArr, ajVar.f2632y, ajVar.f2602g, ajVar.f2603h);
            } else if (i10 == 19) {
                YuvEngineWrap.getInstance().Nv21ToI420(bArr, ajVar.f2632y, ajVar.f2602g, ajVar.f2603h);
            } else if (i10 == 39) {
                System.arraycopy((Object) bArr, 0, (Object) ajVar.f2632y, 0, ((ajVar.f2602g * ajVar.f2603h) * 3) / 2);
            } else if (i10 == 20) {
                YuvEngineWrap.getInstance().Nv21ToYv12(bArr, ajVar.f2632y, ajVar.f2602g, ajVar.f2603h);
            }
            ByteBuffer[] inputBuffers = ajVar.f2619l.getInputBuffers();
            int dequeueInputBuffer = ajVar.f2619l.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(ajVar.f2632y);
                long currentTimeMillis = (System.currentTimeMillis() * 1000) - ajVar.f2620m;
                if (ajVar.f2621n) {
                    ajVar.f2619l.queueInputBuffer(dequeueInputBuffer, 0, ajVar.f2632y.length, currentTimeMillis, 4);
                } else {
                    ajVar.f2619l.queueInputBuffer(dequeueInputBuffer, 0, ajVar.f2632y.length, currentTimeMillis, 0);
                }
            }
            ByteBuffer[] outputBuffers = ajVar.f2619l.getOutputBuffers();
            int dequeueOutputBuffer = ajVar.f2619l.dequeueOutputBuffer(ajVar.f2622o, 10000L);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = ajVar.f2619l.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = ajVar.f2619l.getOutputFormat();
                if (ajVar.f2623p != null && !ajVar.f2621n) {
                    al alVar = ajVar.f2623p;
                    MediaMuxer mediaMuxer = alVar.f2641a;
                    if (mediaMuxer != null) {
                        alVar.f2643c = mediaMuxer.addTrack(outputFormat);
                    }
                    alVar.a();
                }
            }
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 == null) {
                    return;
                }
                MediaCodec.BufferInfo bufferInfo = ajVar.f2622o;
                if ((bufferInfo.flags & 2) != 0) {
                    bufferInfo.size = 0;
                }
                if (bufferInfo.size != 0 && ajVar.f2623p != null && !ajVar.f2621n) {
                    long j10 = ajVar.f2629v;
                    if (j10 > 0) {
                        MediaCodec.BufferInfo bufferInfo2 = ajVar.f2622o;
                        if (bufferInfo2.presentationTimeUs < j10) {
                            bufferInfo2.presentationTimeUs = j10 + 10000;
                        }
                    }
                    MediaCodec.BufferInfo bufferInfo3 = ajVar.f2622o;
                    long j11 = bufferInfo3.presentationTimeUs;
                    ajVar.f2629v = j11;
                    long j12 = ajVar.f2628u;
                    if (j12 == 0) {
                        ajVar.f2628u = j11;
                    } else {
                        ajVar.f2630w = j11 - j12;
                    }
                    byteBuffer2.position(bufferInfo3.offset);
                    MediaCodec.BufferInfo bufferInfo4 = ajVar.f2622o;
                    byteBuffer2.limit(bufferInfo4.offset + bufferInfo4.size);
                    try {
                        ajVar.f2623p.f2644d.put(new ah.b(byteBuffer2, ajVar.f2622o));
                    } catch (InterruptedException unused) {
                    }
                }
                ajVar.f2619l.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = ajVar.f2619l.dequeueOutputBuffer(ajVar.f2622o, 0L);
                if ((ajVar.f2622o.flags & 4) != 0) {
                    ajVar.f2625r.interrupt();
                    ajVar.f2626s = false;
                    return;
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
