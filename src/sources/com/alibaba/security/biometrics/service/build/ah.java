package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.Md5Utils;
import com.alibaba.security.common.videorecorder.ICameraVideoRecorder;
import com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener;
import com.alibaba.security.common.videorecorder.OnH264EncoderListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: BaseCameraVideoRecorder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ah implements ICameraVideoRecorder {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2595a = "CameraVideoRecorder";

    /* renamed from: b, reason: collision with root package name */
    public static final int f2596b = 30;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2597c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final String f2598d = "video/avc";

    /* renamed from: e, reason: collision with root package name */
    public static final int f2599e = 10000;

    /* renamed from: l, reason: collision with root package name */
    private static final int f2600l = 1;

    /* renamed from: f, reason: collision with root package name */
    public final Context f2601f;

    /* renamed from: g, reason: collision with root package name */
    public int f2602g;

    /* renamed from: h, reason: collision with root package name */
    public int f2603h;

    /* renamed from: j, reason: collision with root package name */
    public String f2605j;

    /* renamed from: k, reason: collision with root package name */
    public BufferedOutputStream f2606k;

    /* renamed from: n, reason: collision with root package name */
    private int f2608n;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2604i = false;

    /* renamed from: m, reason: collision with root package name */
    private c f2607m = new c(this);

    /* compiled from: BaseCameraVideoRecorder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements OnCameraVideoReorderListener {

        /* renamed from: b, reason: collision with root package name */
        private OnCameraVideoReorderListener f2610b;

        public a(OnCameraVideoReorderListener onCameraVideoReorderListener) {
            this.f2610b = onCameraVideoReorderListener;
        }

        @Override // com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener
        public final void onFinish(String str, int i10) {
            d dVar = new d(ah.this, (byte) 0);
            dVar.f2615a = this.f2610b;
            dVar.f2616b = str;
            dVar.f2617c = i10;
            ah.this.f2607m.obtainMessage(1, dVar).sendToTarget();
        }
    }

    /* compiled from: BaseCameraVideoRecorder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f2611a = 0;

        /* renamed from: b, reason: collision with root package name */
        public ByteBuffer f2612b;

        /* renamed from: c, reason: collision with root package name */
        public MediaCodec.BufferInfo f2613c;

        public b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            this.f2612b = byteBuffer;
            this.f2613c = bufferInfo;
        }
    }

    /* compiled from: BaseCameraVideoRecorder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final ah f2614a;

        public c(ah ahVar) {
            super(Looper.getMainLooper());
            this.f2614a = ahVar;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            ah.a(message);
        }
    }

    /* compiled from: BaseCameraVideoRecorder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public OnCameraVideoReorderListener f2615a;

        /* renamed from: b, reason: collision with root package name */
        public String f2616b;

        /* renamed from: c, reason: collision with root package name */
        public int f2617c;

        private d() {
        }

        public /* synthetic */ d(ah ahVar, byte b4) {
            this();
        }
    }

    public ah(Context context) {
        this.f2601f = context.getApplicationContext();
    }

    private String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Md5Utils.md5Str("video_" + System.currentTimeMillis() + (Math.random() * 10000.0d)));
        sb2.append(".mp4");
        return this.f2601f.getExternalCacheDir().toString() + "/" + sb2.toString();
    }

    public abstract void a(boolean z10);

    public abstract void a(byte[] bArr);

    public abstract boolean a();

    public abstract boolean a(int i10, int i11, int i12, int i13);

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void init(int i10, int i11, int i12, int i13) {
        if (this.f2604i) {
            return;
        }
        this.f2608n = i13;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Md5Utils.md5Str("video_" + System.currentTimeMillis() + (Math.random() * 10000.0d)));
        sb2.append(".mp4");
        this.f2605j = this.f2601f.getExternalCacheDir().toString() + "/" + sb2.toString();
        if (a()) {
            try {
                if (!FileUtils.isExist(this.f2605j)) {
                    FileUtils.create(this.f2605j);
                }
                this.f2606k = new BufferedOutputStream(new FileOutputStream(this.f2605j));
            } catch (Exception unused) {
            }
        }
        this.f2602g = i10;
        this.f2603h = i11;
        this.f2604i = a(i10, i11, i12, i13);
    }

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void record(byte[] bArr) {
        if (!this.f2604i) {
            RPLogging.w(f2595a, "record video fail because init fail");
        } else {
            a(bArr);
        }
    }

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void release(OnCameraVideoReorderListener onCameraVideoReorderListener, boolean z10) {
        a(z10);
        this.f2604i = false;
        new a(onCameraVideoReorderListener).onFinish(this.f2605j, this.f2608n);
        BufferedOutputStream bufferedOutputStream = this.f2606k;
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.flush();
                this.f2606k.close();
            } catch (Exception unused) {
            }
        }
        if (z10) {
            FileUtils.delete(this.f2605j);
        }
    }

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void setOnH264EncoderListener(OnH264EncoderListener onH264EncoderListener) {
    }

    public final void a(byte[] bArr, int i10) {
        BufferedOutputStream bufferedOutputStream = this.f2606k;
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.write(bArr, 0, i10);
            } catch (IOException unused) {
            }
        }
    }

    private static void b(Message message) {
        d dVar;
        OnCameraVideoReorderListener onCameraVideoReorderListener;
        if (message.what == 1 && (onCameraVideoReorderListener = (dVar = (d) message.obj).f2615a) != null) {
            onCameraVideoReorderListener.onFinish(dVar.f2616b, dVar.f2617c);
        }
    }

    private static byte[] a(byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = i10 * i11;
        byte[] bArr2 = new byte[(i13 * 3) / 2];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i13);
        for (int i14 = 0; i14 < i13; i14++) {
            bArr2[i14] = bArr[i14];
        }
        int i15 = 0;
        while (true) {
            i12 = i13 / 2;
            if (i15 >= i12) {
                break;
            }
            int i16 = i13 + i15;
            bArr2[i16 - 1] = bArr[i16];
            i15 += 2;
        }
        for (int i17 = 0; i17 < i12; i17 += 2) {
            int i18 = i13 + i17;
            bArr2[i18] = bArr[i18 - 1];
        }
        return bArr2;
    }

    private static void a(d dVar) {
        OnCameraVideoReorderListener onCameraVideoReorderListener = dVar.f2615a;
        if (onCameraVideoReorderListener != null) {
            onCameraVideoReorderListener.onFinish(dVar.f2616b, dVar.f2617c);
        }
    }

    public static /* synthetic */ void a(Message message) {
        d dVar;
        OnCameraVideoReorderListener onCameraVideoReorderListener;
        if (message.what == 1 && (onCameraVideoReorderListener = (dVar = (d) message.obj).f2615a) != null) {
            onCameraVideoReorderListener.onFinish(dVar.f2616b, dVar.f2617c);
        }
    }
}
