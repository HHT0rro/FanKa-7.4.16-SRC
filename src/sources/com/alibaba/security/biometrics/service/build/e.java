package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.detector.FaceRecapNetImpl;
import com.alibaba.security.biometrics.service.detector.ILocalFaceRecap;
import com.alibaba.security.biometrics.service.detector.OnLocalRecapPreparedListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import org.apache.commons.io.IOUtils;

/* compiled from: ABFaceRecapDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f2703a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static int f2704b = -2;

    /* renamed from: c, reason: collision with root package name */
    public static int f2705c = -3;

    /* renamed from: d, reason: collision with root package name */
    public static int f2706d = -4;

    /* renamed from: e, reason: collision with root package name */
    public static int f2707e = -5;

    /* renamed from: f, reason: collision with root package name */
    public static int f2708f = -6;

    /* renamed from: g, reason: collision with root package name */
    public static final int f2709g = 0;

    /* renamed from: q, reason: collision with root package name */
    private static final String f2710q = "ABFaceRecapDetector";

    /* renamed from: u, reason: collision with root package name */
    private static e f2711u;

    /* renamed from: h, reason: collision with root package name */
    public ILocalFaceRecap f2712h;

    /* renamed from: j, reason: collision with root package name */
    public long f2714j;

    /* renamed from: k, reason: collision with root package name */
    public HandlerThread f2715k;

    /* renamed from: l, reason: collision with root package name */
    public Handler f2716l;

    /* renamed from: r, reason: collision with root package name */
    private Context f2721r;

    /* renamed from: s, reason: collision with root package name */
    private ALBiometricsParams f2722s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f2723t;

    /* renamed from: v, reason: collision with root package name */
    private g f2724v;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2717m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2718n = false;

    /* renamed from: o, reason: collision with root package name */
    public long f2719o = 0;

    /* renamed from: p, reason: collision with root package name */
    public StringBuilder f2720p = new StringBuilder(1024);

    /* renamed from: i, reason: collision with root package name */
    public int f2713i = 0;

    /* compiled from: ABFaceRecapDetector.java */
    /* renamed from: com.alibaba.security.biometrics.service.build.e$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f2727a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2728b = 160;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f2729c = 160;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f2730d = 0;

        public AnonymousClass2(byte[] bArr) {
            this.f2727a = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (e.this.f2717m) {
                return;
            }
            try {
                e.this.f2717m = true;
                if (ALBiometricsJni.IsEnabled()) {
                    e.b(e.this);
                    long currentTimeMillis = System.currentTimeMillis();
                    e.this.f2712h.inference(this.f2727a, this.f2728b, this.f2729c, this.f2730d);
                    e.this.f2714j += System.currentTimeMillis() - currentTimeMillis;
                }
            } catch (Throwable unused) {
            }
            e.this.f2717m = false;
        }
    }

    /* compiled from: ABFaceRecapDetector.java */
    /* renamed from: com.alibaba.security.biometrics.service.build.e$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f2732a;

        public AnonymousClass3(a aVar) {
            this.f2732a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            float recapResult = e.this.f2712h.getRecapResult();
            StringBuilder sb2 = e.this.f2720p;
            sb2.append("LivenessJni.GetCombinedRecapScore scoreResult scoreFinalResult=");
            sb2.append(recapResult);
            sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            a aVar = this.f2732a;
            if (aVar != null) {
                aVar.a(0, new float[]{recapResult}, e.this.f2720p.toString());
            }
        }
    }

    /* compiled from: ABFaceRecapDetector.java */
    /* renamed from: com.alibaba.security.biometrics.service.build.e$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.f2712h.release();
        }
    }

    /* compiled from: ABFaceRecapDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(int i10, float[] fArr, String str);
    }

    private e() {
        this.f2714j = 0L;
        this.f2714j = 0L;
    }

    public static /* synthetic */ int b(e eVar) {
        int i10 = eVar.f2713i;
        eVar.f2713i = i10 + 1;
        return i10;
    }

    public static boolean d() {
        return ALBiometricsJni.isLoaded();
    }

    private void e() {
        if (this.f2715k == null) {
            HandlerThread handlerThread = new HandlerThread("ALBiometrics.ABFaceRecapDetector");
            this.f2715k = handlerThread;
            handlerThread.start();
            this.f2716l = new Handler(this.f2715k.getLooper());
        }
    }

    private void f() {
        Handler handler;
        if (ALBiometricsJni.isLoaded()) {
            ALBiometricsJni.release();
        }
        if (this.f2712h != null && (handler = this.f2716l) != null) {
            handler.post(new AnonymousClass4());
        }
        this.f2713i = 0;
        this.f2714j = 0L;
        this.f2717m = false;
    }

    private int g() {
        return this.f2713i;
    }

    private long h() {
        return this.f2714j;
    }

    public static void b() {
        f2711u = null;
    }

    public final void c() {
        a(this.f2721r, this.f2724v);
        if (ALBiometricsJni.isLoaded()) {
            ALBiometricsJni.release();
        }
        this.f2713i = 0;
        this.f2714j = 0L;
        this.f2717m = false;
        this.f2718n = false;
        StringBuilder sb2 = this.f2720p;
        sb2.delete(0, sb2.length());
    }

    public static e a() {
        if (f2711u == null) {
            f2711u = new e();
        }
        return f2711u;
    }

    public final int a(Context context, ALBiometricsParams aLBiometricsParams, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        this.f2721r = context;
        this.f2722s = aLBiometricsParams;
        this.f2724v = aLBiometricsServiceEventListener;
        if (!ALBiometricsJni.isLoaded()) {
            return f2703a;
        }
        boolean z10 = ALBiometricsJni.checkLicense(context, aLBiometricsServiceEventListener) == 0;
        this.f2723t = z10;
        if (!z10) {
            return f2703a;
        }
        a(context, aLBiometricsServiceEventListener);
        c();
        return 0;
    }

    private void a(Context context, final g gVar) {
        FaceRecapNetImpl faceRecapNetImpl = new FaceRecapNetImpl();
        this.f2712h = faceRecapNetImpl;
        faceRecapNetImpl.prepare(context, new OnLocalRecapPreparedListener() { // from class: com.alibaba.security.biometrics.service.build.e.1
            @Override // com.alibaba.security.biometrics.service.detector.OnLocalRecapPreparedListener
            public final void onFailed(int i10, Throwable th) {
                if (gVar != null) {
                    th.getMessage();
                }
                e.this.f2712h = null;
            }

            @Override // com.alibaba.security.biometrics.service.detector.OnLocalRecapPreparedListener
            public final void onProgressUpdate(int i10) {
            }

            @Override // com.alibaba.security.biometrics.service.detector.OnLocalRecapPreparedListener
            public final void onSucceeded(ILocalFaceRecap iLocalFaceRecap) {
                e.this.f2712h = iLocalFaceRecap;
            }
        });
    }

    private int a(byte[] bArr, float[] fArr) {
        if (!ALBiometricsJni.isLoaded()) {
            return f2703a;
        }
        if (fArr == null) {
            return f2706d;
        }
        if (this.f2712h == null) {
            return f2708f;
        }
        if (this.f2717m || this.f2718n || System.currentTimeMillis() - this.f2719o <= 200) {
            return 0;
        }
        this.f2719o = System.currentTimeMillis();
        if (this.f2715k == null) {
            HandlerThread handlerThread = new HandlerThread("ALBiometrics.ABFaceRecapDetector");
            this.f2715k = handlerThread;
            handlerThread.start();
            this.f2716l = new Handler(this.f2715k.getLooper());
        }
        this.f2716l.post(new AnonymousClass2(bArr));
        return 0;
    }

    private void a(a aVar) {
        Handler handler;
        if (ALBiometricsJni.isLoaded() && ALBiometricsJni.IsEnabled() && this.f2713i > 0 && (handler = this.f2716l) != null) {
            this.f2718n = true;
            handler.post(new AnonymousClass3(aVar));
        } else {
            aVar.a(GlobalErrorCode.ERROR_ALGO_RECAP_INIT_FAIL, null, null);
        }
    }

    private e a(int i10) {
        this.f2713i = i10;
        return this;
    }

    private e a(long j10) {
        this.f2714j = j10;
        return this;
    }
}
