package com.tencent.cloud.huiyansdkface.facelight.process;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.FaceVerifyConfig;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.c.b.b;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.RotateSetting;
import com.tencent.cloud.huiyansdkface.facelight.process.b;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.util.concurrent.Callable;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private long G;
    private long H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private CloudFaceCountDownTimer O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private long W;
    private b.a X;
    private com.tencent.cloud.huiyansdkface.facelight.b.a.b Z;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.cloud.huiyansdkface.facelight.ui.a.c f40725a;

    /* renamed from: b, reason: collision with root package name */
    private YTFaceTracker f40726b;

    /* renamed from: c, reason: collision with root package name */
    private YTFaceTracker.TrackedFace[] f40727c;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f40729e;

    /* renamed from: f, reason: collision with root package name */
    private Context f40730f;

    /* renamed from: h, reason: collision with root package name */
    private FaceVerifyStatus f40732h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f40733i;

    /* renamed from: j, reason: collision with root package name */
    private float f40734j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f40735k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f40736l;

    /* renamed from: m, reason: collision with root package name */
    private int f40737m;

    /* renamed from: n, reason: collision with root package name */
    private int f40738n;

    /* renamed from: o, reason: collision with root package name */
    private long f40739o;

    /* renamed from: p, reason: collision with root package name */
    private String f40740p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.c.b f40741q;

    /* renamed from: r, reason: collision with root package name */
    private int f40742r;

    /* renamed from: s, reason: collision with root package name */
    private int f40743s;

    /* renamed from: t, reason: collision with root package name */
    private int f40744t;

    /* renamed from: u, reason: collision with root package name */
    private long f40745u;

    /* renamed from: v, reason: collision with root package name */
    private float f40746v;

    /* renamed from: w, reason: collision with root package name */
    private float f40747w;

    /* renamed from: x, reason: collision with root package name */
    private float f40748x;

    /* renamed from: y, reason: collision with root package name */
    private float f40749y;

    /* renamed from: z, reason: collision with root package name */
    private float f40750z;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f40728d = null;

    /* renamed from: g, reason: collision with root package name */
    private d f40731g = d.z();
    private String Y = d.z().x().N();

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.process.a$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 implements b.a {
        public AnonymousClass1() {
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        @WorkerThread
        public void a() {
            WLogger.d("FaceDetect", "onCanReflect");
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        @WorkerThread
        public void a(final int i10) {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.1.1
                /* JADX WARN: Removed duplicated region for block: B:13:0x00bc  */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0121  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 373
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.process.a.AnonymousClass1.RunnableC06211.run():void");
                }
            });
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        @WorkerThread
        public void a(int i10, String str, String str2) {
            WLogger.w("FaceDetect", "YTPoseDetectInterface.poseDetect.onFailed: " + i10 + ";" + str + ";" + str2);
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
        @WorkerThread
        public void a(byte[][] bArr, int i10, int i11) {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.1.2
                @Override // java.lang.Runnable
                public void run() {
                    WLogger.d("FaceDetect", "onRecordingDone");
                    if (!a.this.Y.contains("2")) {
                        if ("1".equals(a.this.Y)) {
                            WLogger.i("FaceDetect", "=================onRecordingDone，end silentCheck======================");
                            if (d.z().e().x()) {
                                if (!d.z().x().m() || a.this.f40732h.g()) {
                                    a.this.f40732h.j();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (a.this.f40732h.d() == 2) {
                        if (a.this.Q && !a.this.R) {
                            WLogger.i("FaceDetect", "first act onRecordingDone");
                            a.this.R = true;
                        } else {
                            if (a.this.P) {
                                return;
                            }
                            WLogger.i("FaceDetect", "====================onRecordingDone end!==========================");
                            a.this.P = true;
                            if (a.this.O != null) {
                                WLogger.d("FaceDetect", "cancel record timeout cdt");
                                a.this.O.cancel();
                                a.this.O = null;
                            }
                            a.this.f40732h.k();
                        }
                    }
                }
            });
        }
    }

    public a(Context context, YTFaceTracker yTFaceTracker, com.tencent.cloud.huiyansdkface.facelight.process.c.b bVar) {
        this.f40726b = null;
        this.f40730f = context;
        this.f40726b = yTFaceTracker;
        this.f40741q = bVar;
        WLogger.d("FaceDetect", "liveSequence=" + this.Y);
        c();
        d();
    }

    private Rect a(YTFaceTracker.TrackedFace trackedFace) {
        float[] fArr = trackedFace.faceShape;
        int i10 = 0;
        float f10 = fArr[0];
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[1];
        while (i10 < 180) {
            f10 = Math.min(f10, trackedFace.faceShape[i10]);
            f11 = Math.max(f11, trackedFace.faceShape[i10]);
            int i11 = i10 + 1;
            f12 = Math.min(f12, trackedFace.faceShape[i11]);
            f13 = Math.max(f13, trackedFace.faceShape[i11]);
            i10 = i11 + 1;
        }
        int i12 = this.f40742r;
        float f14 = (i12 - 1) - f10;
        float f15 = (float) (((i12 - 1) - f11) - (((f14 - r2) * 0.1d) / 2.0d));
        float f16 = (float) (f14 + (((f14 - f15) * 0.1d) / 2.0d));
        float f17 = (float) (f12 - (((f13 - f12) * 0.1d) / 2.0d));
        float f18 = (float) (f13 + (((f13 - f17) * 0.1d) / 2.0d));
        if (this.f40744t == 0) {
            if (f15 < 0.0f) {
                f15 = 0.0f;
            }
            if (f16 < 0.0f) {
                f16 = 0.0f;
            }
            if (f15 > i12 - 1) {
                f15 = i12 - 1;
            }
            if (f16 > i12 - 1) {
                f16 = i12 - 1;
            }
            if (f17 < 0.0f) {
                f17 = 0.0f;
            }
            if (f18 < 0.0f) {
                f18 = 0.0f;
            }
            int i13 = this.f40743s;
            if (f17 > i13 - 1) {
                f17 = i13 - 1;
            }
            if (f18 > i13 - 1) {
                f18 = i13 - 1;
            }
        }
        Rect rect = new Rect();
        rect.left = (int) f15;
        rect.top = (int) f17;
        rect.right = (int) f16;
        rect.bottom = (int) f18;
        return rect;
    }

    @UiThread
    private void a(int i10) {
        if (i10 == 2) {
            WLogger.i("FaceDetect", "=================END FindFace======================");
            e();
            this.f40732h.b(3);
        } else if (i10 == 3) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(final com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar) {
        com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar;
        int b4 = this.f40732h.b();
        int d10 = this.f40732h.d();
        int e2 = this.f40732h.e();
        if (this.S || b4 == 1) {
            return;
        }
        if ((b4 == 4 && d10 == 3 && e2 > 1) || b4 == 6 || b4 == 8 || b4 == 7 || b4 == 9 || a(b4, d10)) {
            return;
        }
        final YTFaceTracker.TrackedFace[] trackedFaceArr = bVar.f40599a;
        if (trackedFaceArr == null) {
            WLogger.i("FaceDetect", "faceStatus null");
            if (this.T) {
                this.T = false;
                this.f40731g.s();
                WLogger.d("FaceDetect", "noface after control count=" + this.f40731g.r());
                if (this.f40731g.r() > 9) {
                    WLogger.e("FaceDetect", "风险控制超过次数，错误退出！");
                    this.f40732h.b(8);
                    return;
                }
            }
            if (b4 == 4) {
                WLogger.e("FaceDetect", "live check express detect red!");
                g();
                return;
            }
            if (b4 != 5) {
                a(this.f40731g.f().kyc_no_face);
                return;
            }
            int i10 = this.K + 1;
            this.K = i10;
            if (i10 >= this.I) {
                WLogger.e("FaceDetect", "will express detect red!" + this.K);
                g();
                return;
            }
            return;
        }
        this.T = true;
        if (!this.U) {
            a("FaceDetect", "first has face");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f40730f, "facepage_has_face", null, null);
            this.U = true;
        }
        Rect a10 = a(trackedFaceArr[0]);
        if (b4 != 2 && b4 != 3) {
            if (b4 == 4) {
                com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar2 = this.f40725a;
                if (cVar2 == null) {
                    WLogger.e("FaceDetect", "mFaceLiveView null");
                    return;
                }
                if (!this.f40733i.contains(cVar2.a(a10))) {
                    WLogger.e("FaceDetect", "活体检测过程中人脸偏移出框");
                    g();
                    return;
                } else {
                    if (d10 == 3 || !a(trackedFaceArr[0], false)) {
                        return;
                    }
                    WLogger.e("FaceDetect", "活体检测过程中人脸被遮挡");
                    g();
                    return;
                }
            }
            if (b4 == 5) {
                com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar3 = this.f40725a;
                if (cVar3 == null) {
                    WLogger.e("FaceDetect", "willExpress mFaceLiveView null");
                    return;
                }
                if (!this.f40733i.contains(cVar3.a(a10))) {
                    int i11 = this.L + 1;
                    this.L = i11;
                    if (i11 >= this.I) {
                        WLogger.e("FaceDetect", "will活体检测过程中人脸偏移出框:" + this.L);
                        g();
                        return;
                    }
                    return;
                }
                if (trackedFaceArr[0].yaw < this.f40748x || trackedFaceArr[0].yaw > this.f40749y) {
                    WLogger.w("FaceDetect", "侧脸了 yaw=" + trackedFaceArr[0].yaw);
                    int i12 = this.M + 1;
                    this.M = i12;
                    if (i12 >= this.J) {
                        WLogger.e("FaceDetect", "will侧脸了:" + this.M);
                        g();
                        return;
                    }
                    return;
                }
                if (!this.f40731g.e().d() || !a(trackedFaceArr[0], false)) {
                    WLogger.d("FaceDetect", "will face ok.");
                    this.K = 0;
                    this.L = 0;
                    this.M = 0;
                    this.N = 0;
                    return;
                }
                int i13 = this.N + 1;
                this.N = i13;
                if (i13 >= this.J) {
                    WLogger.e("FaceDetect", "will遮挡了:" + this.N);
                    g();
                    return;
                }
                return;
            }
            return;
        }
        if (FaceVerifyConfig.getInstance().displayInfoInUI() && (cVar = this.f40725a) != null) {
            cVar.a("p|y|r=" + trackedFaceArr[0].pitch + "|" + trackedFaceArr[0].yaw + "|" + trackedFaceArr[0].roll);
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar4 = this.f40725a;
        if (cVar4 == null) {
            WLogger.e("FaceDetect", "mFaceLiveView null");
            return;
        }
        RectF a11 = cVar4.a(a10);
        this.f40725a.onUpdateRealFaceRect(a11);
        RectF r10 = this.f40725a.r();
        this.f40733i = new RectF(r10.left, r10.top, r10.right, r10.bottom + 80.0f);
        this.f40734j = r10.width() * r10.height();
        float width = a11.width() * a11.height();
        WLogger.d("FaceDetect", "faceArea=" + width);
        if (!this.f40733i.contains(a11)) {
            if (width >= this.f40734j) {
                WLogger.e("FaceDetect", "人脸大于框框！");
                a(this.f40731g.f().kyc_fara_way);
                return;
            } else {
                WLogger.d("FaceDetect", "框框不包含人脸。");
                a(this.f40731g.f().kyc_face_out);
                return;
            }
        }
        WLogger.d("FaceDetect", "faceArea=" + width + "; faceBgArea=" + this.f40734j);
        float f10 = width / this.f40734j;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("人脸占人脸框的percent=");
        sb2.append(f10);
        WLogger.d("FaceDetect", sb2.toString());
        if (FaceVerifyConfig.getInstance().displayInfoInUI()) {
            WLogger.d("FaceDetect", "displayInfoInUI");
            com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar5 = this.f40725a;
            if (cVar5 != null) {
                cVar5.b("percent=" + f10);
            }
        }
        if (f10 < this.f40746v) {
            WLogger.w("FaceDetect", "人脸太小！");
            a(this.f40731g.f().kyc_get_closer);
            return;
        }
        if (f10 > this.f40747w) {
            WLogger.w("FaceDetect", "人脸太大！");
            a(this.f40731g.f().kyc_fara_way);
            return;
        }
        WLogger.d("FaceDetect", "人脸大小合适！");
        float f11 = a11.top;
        RectF rectF = this.f40733i;
        if (f11 < rectF.top + (rectF.height() / 8.0f)) {
            WLogger.w("FaceDetect", "人脸下移一点！");
            a(this.f40731g.f().kyc_face_out);
            return;
        }
        if (trackedFaceArr[0].yaw < this.f40748x || trackedFaceArr[0].yaw > this.f40749y) {
            WLogger.w("FaceDetect", "侧脸了 yaw=" + trackedFaceArr[0].yaw);
            a(this.f40731g.f().kyc_turn_side);
            return;
        }
        if (trackedFaceArr[0].pitch < this.f40750z) {
            WLogger.w("FaceDetect", "仰头了 pitch=" + trackedFaceArr[0].pitch);
            a(this.f40731g.f().kyc_look_up);
            return;
        }
        if (trackedFaceArr[0].pitch > this.A) {
            WLogger.w("FaceDetect", "低头了 pitch=" + trackedFaceArr[0].pitch);
            a(this.f40731g.f().kyc_look_down);
            return;
        }
        if (trackedFaceArr[0].roll < this.B || trackedFaceArr[0].roll > this.C) {
            WLogger.w("FaceDetect", "歪头了 roll=" + trackedFaceArr[0].roll);
            a(this.f40731g.f().kyc_turn_side);
            return;
        }
        WLogger.d("FaceDetect", "人脸端正！");
        if (a(trackedFaceArr[0], true)) {
            return;
        }
        WLogger.d("FaceDetect", "人脸符合条件");
        if (this.f40731g.e().C()) {
            float a12 = com.tencent.cloud.huiyansdkface.facelight.c.b.a(trackedFaceArr[0].faceShape);
            WLogger.d("FaceDetect", "eye score:" + a12);
            if (a12 < this.F) {
                WLogger.d("FaceDetect", "闭眼了");
                a(this.f40731g.f().kyc_open_eyes);
                return;
            }
        }
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.6
            @Override // java.lang.Runnable
            public void run() {
                YTFaceTracker.TrackedFace[] trackedFaceArr2 = trackedFaceArr;
                float[] fArr = trackedFaceArr2[0].faceShape;
                float[] fArr2 = trackedFaceArr2[0].faceVisible;
                com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar2 = bVar;
                b.a(fArr, fArr2, 5, bVar2.f40600b, bVar2.f40601c, bVar2.f40602d, trackedFaceArr2[0].pitch, trackedFaceArr2[0].yaw, trackedFaceArr2[0].roll, a.this.X, 1, a.this.f40744t);
            }
        });
        if (!this.f40735k) {
            this.f40739o = System.currentTimeMillis();
            this.f40735k = true;
        }
        if (this.f40736l) {
            this.f40737m++;
            WLogger.d("FaceDetect", "红想变蓝，blueCount=" + this.f40737m);
            if (this.f40737m < 2) {
                return;
            }
            WLogger.d("FaceDetect", "红变蓝成功！");
            this.f40736l = false;
        } else {
            WLogger.d("FaceDetect", "一直蓝");
        }
        this.Z = bVar;
        a(b4);
    }

    private void a(String str) {
        StringBuilder sb2;
        if (this.S) {
            WLogger.d("FaceDetect", "isDestroying");
            return;
        }
        this.f40737m = 0;
        String str2 = ";new=";
        if (!this.f40736l || TextUtils.isEmpty(this.f40740p)) {
            sb2 = new StringBuilder();
            sb2.append("直接切换 蓝变红或者第一次变红 lastRedTip=");
            sb2.append(this.f40740p);
        } else {
            if (this.f40738n < 2) {
                WLogger.d("FaceDetect", "红色想要切换提示语，上一次=" + this.f40740p + ";new=" + str);
                if (this.f40740p.equals(str)) {
                    this.f40738n++;
                    WLogger.d("FaceDetect", "sameCount+1, now samCount=" + this.f40738n);
                } else {
                    WLogger.d("FaceDetect", "不足三次，切换提示语失败");
                    this.f40738n = 0;
                    this.f40740p = str;
                }
                this.f40736l = true;
                this.f40735k = false;
            }
            sb2 = new StringBuilder();
            str2 = "已切换成提示语=";
        }
        sb2.append(str2);
        sb2.append(str);
        WLogger.d("FaceDetect", sb2.toString());
        this.f40738n = 0;
        this.f40740p = str;
        b(str);
        this.f40736l = true;
        this.f40735k = false;
    }

    private void a(String str, String str2) {
        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().b(str, str2);
    }

    private boolean a(int i10, int i11) {
        if ((i10 == 4 && (i11 == 3 || i11 == 1)) || i10 == 5) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f40732h.a();
        WLogger.d("FaceDetect", "check timeout:" + currentTimeMillis);
        if (currentTimeMillis <= this.f40745u) {
            return false;
        }
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.9
            @Override // java.lang.Runnable
            public void run() {
                WLogger.d("FaceDetect", "finish report out of time, set current Status OUTOFTIME");
                a.this.f40732h.b(7);
            }
        });
        return true;
    }

    private boolean a(YTFaceTracker.TrackedFace trackedFace, boolean z10) {
        if (com.tencent.cloud.huiyansdkface.facelight.c.b.a(trackedFace, this.D, this.E)) {
            if (z10) {
                a(this.f40731g.f().kyc_cover_eyes);
            }
            return true;
        }
        if (com.tencent.cloud.huiyansdkface.facelight.c.b.b(trackedFace, this.D, this.E)) {
            if (z10) {
                a(this.f40731g.f().kyc_cover_nose);
            }
            return true;
        }
        if (!com.tencent.cloud.huiyansdkface.facelight.c.b.c(trackedFace, this.D, this.E)) {
            return false;
        }
        if (z10) {
            a(this.f40731g.f().kyc_cover_mouse);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public com.tencent.cloud.huiyansdkface.facelight.b.a.b b(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        this.f40729e = true;
        this.f40728d = bArr;
        if (bArr == null) {
            WLogger.i("FrameData is null!");
        } else if (this.S || this.f40732h.b() == 1 || this.f40732h.b() == 6 || this.f40732h.b() == 8 || this.f40732h.b() == 7 || this.f40732h.b() == 9) {
            WLogger.d("FaceDetect", "isFinishing true");
        } else {
            byte[] bArr2 = (byte[]) bArr.clone();
            if (this.f40732h.d() == 3 && this.f40732h.e() == 2) {
                WLogger.d("FaceDetect", "REFLECT DETECT_DELAY nowTime=" + System.currentTimeMillis());
                YTAGReflectLiveCheckInterface.pushImageData(bArr2, i10, i11, System.currentTimeMillis(), 0, null, 0.0f, 0.0f, 0.0f);
            } else {
                if (this.f40726b != null) {
                    if (!this.V) {
                        this.W = System.currentTimeMillis();
                    }
                    try {
                        this.f40727c = this.f40726b.track(0, this.f40728d, i10, i11, RotateSetting.getRotate(), false, null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        WLogger.e("FaceDetect", e2.toString());
                    }
                    if (!this.V) {
                        long currentTimeMillis = System.currentTimeMillis() - this.W;
                        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().a("FaceDetect", "first track:" + currentTimeMillis);
                        this.V = true;
                        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_first_yttrack", "track:" + currentTimeMillis, null);
                    }
                    YTFaceTracker.TrackedFace[] trackedFaceArr = this.f40727c;
                    if (trackedFaceArr == null || trackedFaceArr.length == 0) {
                        WLogger.w("FaceDetect", "face status is null");
                        this.f40727c = null;
                    }
                    YTFaceTracker.TrackedFace[] trackedFaceArr2 = this.f40727c;
                    if (trackedFaceArr2 != null) {
                        YTFaceTracker.TrackedFace[] a10 = com.tencent.cloud.huiyansdkface.facelight.c.b.a(trackedFaceArr2);
                        this.f40727c = a10;
                        if (a10.length > 1) {
                            int i14 = Integer.MIN_VALUE;
                            int i15 = 0;
                            int i16 = 0;
                            while (true) {
                                YTFaceTracker.TrackedFace[] trackedFaceArr3 = this.f40727c;
                                if (i15 >= trackedFaceArr3.length) {
                                    break;
                                }
                                Rect a11 = a(trackedFaceArr3[i15]);
                                int width = a11.width() * a11.height();
                                if (width >= i14) {
                                    i16 = i15;
                                    i14 = width;
                                }
                                i15++;
                            }
                            if (i16 != 0) {
                                WLogger.i("FaceDetect", "Found max face id:" + i16);
                                YTFaceTracker.TrackedFace[] trackedFaceArr4 = this.f40727c;
                                trackedFaceArr4[0] = trackedFaceArr4[i16];
                            }
                        }
                        if (this.f40732h.b() == 4) {
                            if (this.f40732h.d() == 1) {
                                YTFaceTracker.TrackedFace[] trackedFaceArr5 = this.f40727c;
                                i12 = 3;
                                i13 = 2;
                                b.a(trackedFaceArr5[0].faceShape, trackedFaceArr5[0].faceVisible, 5, bArr2, i10, i11, trackedFaceArr5[0].pitch, trackedFaceArr5[0].yaw, trackedFaceArr5[0].roll, this.X, 1, this.f40744t);
                            } else {
                                i12 = 3;
                                i13 = 2;
                            }
                            if (this.f40732h.d() == i13) {
                                int c4 = this.f40732h.c();
                                if (c4 == i13) {
                                    WLogger.d("FaceDetect", "blink nowTime=" + System.currentTimeMillis());
                                    YTFaceTracker.TrackedFace[] trackedFaceArr6 = this.f40727c;
                                    b.a(trackedFaceArr6[0].faceShape, trackedFaceArr6[0].faceVisible, 1, bArr2, i10, i11, trackedFaceArr6[0].pitch, trackedFaceArr6[0].yaw, trackedFaceArr6[0].roll, this.X, 1, this.f40744t);
                                } else if (c4 == i12) {
                                    WLogger.d("FaceDetect", "openMouth nowTime=" + System.currentTimeMillis());
                                    YTFaceTracker.TrackedFace[] trackedFaceArr7 = this.f40727c;
                                    b.a(trackedFaceArr7[0].faceShape, trackedFaceArr7[0].faceVisible, 2, bArr2, i10, i11, trackedFaceArr7[0].pitch, trackedFaceArr7[0].yaw, trackedFaceArr7[0].roll, this.X, 1, this.f40744t);
                                } else if (c4 == 1) {
                                    WLogger.d("FaceDetect", "shakeHead nowTime=" + System.currentTimeMillis());
                                    YTFaceTracker.TrackedFace[] trackedFaceArr8 = this.f40727c;
                                    b.a(trackedFaceArr8[0].faceShape, trackedFaceArr8[0].faceVisible, 4, bArr2, i10, i11, trackedFaceArr8[0].pitch, trackedFaceArr8[0].yaw, trackedFaceArr8[0].roll, this.X, 1, this.f40744t);
                                }
                            }
                            if (this.f40732h.d() == i12) {
                                if (this.f40732h.e() == 1) {
                                    WLogger.d("FaceDetect", "REFLECT nowTime=" + System.currentTimeMillis());
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    int rotate = RotateSetting.getRotate();
                                    YTFaceTracker.TrackedFace[] trackedFaceArr9 = this.f40727c;
                                    YTAGReflectLiveCheckInterface.pushImageData(bArr2, i10, i11, currentTimeMillis2, rotate, trackedFaceArr9[0].faceShape, trackedFaceArr9[0].pitch, trackedFaceArr9[0].yaw, trackedFaceArr9[0].roll);
                                }
                                if (this.f40731g.e().x()) {
                                    if (YTPoseDetectJNIInterface.isRecordingDone()) {
                                        WLogger.d("FaceDetect", "poseDetect while reflect finished.");
                                    } else {
                                        WLogger.d("FaceDetect", "poseDetect while reflect.");
                                        YTFaceTracker.TrackedFace[] trackedFaceArr10 = this.f40727c;
                                        b.a(trackedFaceArr10[0].faceShape, trackedFaceArr10[0].faceVisible, 5, bArr2, i10, i11, trackedFaceArr10[0].pitch, trackedFaceArr10[0].yaw, trackedFaceArr10[0].roll, this.X, 1, this.f40744t);
                                    }
                                }
                            }
                        }
                    }
                    com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar = new com.tencent.cloud.huiyansdkface.facelight.b.a.b();
                    bVar.f40599a = this.f40727c;
                    bVar.f40600b = bArr2;
                    bVar.f40601c = i10;
                    bVar.f40602d = i11;
                    this.f40729e = false;
                    return bVar;
                }
                WLogger.w("FaceDetect", "faceTracker is null");
            }
        }
        this.f40729e = false;
        return null;
    }

    private void b(final String str) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar;
                Resources resources;
                int i10;
                a aVar = a.this;
                if (aVar.f40725a != null) {
                    if ("custom".equals(aVar.f40731g.x().J())) {
                        a aVar2 = a.this;
                        aVar2.f40725a.onUpdateTipTextColor(aVar2.f40730f.getResources().getColor(R.color.wbcf_custom_tips_text_error));
                        a aVar3 = a.this;
                        cVar = aVar3.f40725a;
                        resources = aVar3.f40730f.getResources();
                        i10 = R.color.wbcf_custom_border_error;
                    } else if (WbCloudFaceContant.BLACK.equals(a.this.f40731g.x().J())) {
                        a aVar4 = a.this;
                        aVar4.f40725a.onUpdateTipTextColor(aVar4.f40730f.getResources().getColor(R.color.wbcf_red));
                        a aVar5 = a.this;
                        cVar = aVar5.f40725a;
                        resources = aVar5.f40730f.getResources();
                        i10 = R.color.wbcf_red;
                    } else {
                        a aVar6 = a.this;
                        aVar6.f40725a.onUpdateTipTextColor(aVar6.f40730f.getResources().getColor(R.color.wbcf_red_white));
                        a aVar7 = a.this;
                        cVar = aVar7.f40725a;
                        resources = aVar7.f40730f.getResources();
                        i10 = R.color.wbcf_red_white;
                    }
                    cVar.onUpdateFaceBorder(resources.getColor(i10));
                    a.this.f40725a.onUpdateTip(str);
                }
            }
        });
    }

    private void c() {
        int j10 = this.f40731g.x().j();
        WLogger.d("FaceDetect", "blink safelevel=" + j10);
        YTPoseDetectJNIInterface.updateParam("frame_num", "20");
        YTPoseDetectJNIInterface.updateParam("last_frame_num", "3");
        YTPoseDetectJNIInterface.updateParam("min_gray_val", "0");
        YTPoseDetectJNIInterface.updateParam("max_gray_val", "255");
        YTPoseDetectJNIInterface.setSafetyLevel(j10);
        this.X = new AnonymousClass1();
    }

    private void d() {
        com.tencent.cloud.huiyansdkface.facelight.a.a.b e2 = this.f40731g.e();
        this.f40745u = e2.U();
        this.f40746v = e2.J();
        this.f40747w = e2.K();
        this.f40748x = e2.L();
        this.f40749y = e2.M();
        this.f40750z = e2.N();
        this.A = e2.O();
        this.B = e2.P();
        this.C = e2.Q();
        this.D = e2.R();
        this.E = e2.S();
        this.F = e2.T();
        this.G = e2.ab();
        this.H = e2.ac();
        this.I = e2.ah();
        this.J = e2.ai();
        WLogger.d("FaceDetect", "outOfTime=" + this.f40745u + "; lightFaceAreaMin=" + this.f40746v + "; lightFaceAreaMax=" + this.f40747w + "; lightFaceYawMin=" + this.f40748x + "; lightFaceYawMax=" + this.f40749y + "; lightFacePitchMin=" + this.f40750z + "; lightFacePitchMax=" + this.A + "; lightFaceRollMin=" + this.B + "; lightFaceRollMax=" + this.C + "; lightPointsPercent=" + this.D + "; lightPointsVis=" + this.E + "; willFaceOutCount=" + this.I + "; willPoseCount=" + this.J);
    }

    private void e() {
        if (this.S) {
            WLogger.d("FaceDetect", "isDestroying");
        } else {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.7
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar;
                    Resources resources;
                    int i10;
                    com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar2;
                    Resources resources2;
                    int i11;
                    a aVar = a.this;
                    if (aVar.f40725a != null) {
                        if (WbCloudFaceContant.BLACK.equals(aVar.f40731g.x().J())) {
                            a aVar2 = a.this;
                            cVar2 = aVar2.f40725a;
                            resources2 = aVar2.f40730f.getResources();
                            i11 = R.color.wbcf_white;
                        } else {
                            if (!WbCloudFaceContant.WHITE.equals(a.this.f40731g.x().J())) {
                                if ("custom".equals(a.this.f40731g.x().J())) {
                                    a aVar3 = a.this;
                                    aVar3.f40725a.onUpdateTipTextColor(aVar3.f40730f.getResources().getColor(R.color.wbcf_custom_tips_text));
                                    a aVar4 = a.this;
                                    cVar = aVar4.f40725a;
                                    resources = aVar4.f40730f.getResources();
                                    i10 = R.color.wbcf_custom_border;
                                    cVar.onUpdateFaceBorder(resources.getColor(i10));
                                }
                                return;
                            }
                            a aVar5 = a.this;
                            cVar2 = aVar5.f40725a;
                            resources2 = aVar5.f40730f.getResources();
                            i11 = R.color.wbcf_black_text;
                        }
                        cVar2.onUpdateTipTextColor(resources2.getColor(i11));
                        a aVar6 = a.this;
                        cVar = aVar6.f40725a;
                        resources = aVar6.f40730f.getResources();
                        i10 = R.color.wbcf_sdk_base_blue;
                        cVar.onUpdateFaceBorder(resources.getColor(i10));
                    }
                }
            });
        }
    }

    @UiThread
    private void f() {
        if (System.currentTimeMillis() - this.f40739o > this.G) {
            WLogger.i("FaceDetect", "=================END PREPARE======================");
            this.f40732h.b(4);
        }
    }

    private void g() {
        if (this.f40731g.q()) {
            WLogger.d("FaceDetect", "already in reset");
        } else {
            b();
            this.f40741q.a();
        }
    }

    public void a() {
        WLogger.d("FaceDetect", "release");
        a("FaceDetect", "faceDetect release");
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.e()) {
                    b.d();
                }
                b.b();
                YTAGReflectLiveCheckInterface.cancel();
                YTAGReflectLiveCheckInterface.releaseModel();
                if (a.this.f40726b != null) {
                    a.this.f40726b = null;
                }
            }
        });
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_release", null, null);
    }

    public void a(int i10, int i11, int i12) {
        this.f40742r = i10;
        this.f40743s = i11;
        this.f40744t = i12;
    }

    public void a(FaceVerifyStatus faceVerifyStatus) {
        this.f40732h = faceVerifyStatus;
    }

    public void a(final com.tencent.cloud.huiyansdkface.facelight.process.c.d dVar) {
        WLogger.i("FaceDetect", "pushBackupData");
        final com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar = this.Z;
        if (bVar == null) {
            WLogger.w("FaceDetect", "backupData is null,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f40730f, "faceservice_push_backup_data", "backupData is null!", null);
            dVar.a(null);
            return;
        }
        YTFaceTracker.TrackedFace[] trackedFaceArr = bVar.f40599a;
        if (trackedFaceArr == null || trackedFaceArr.length <= 0) {
            WLogger.w("FaceDetect", "backupData faces is null,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f40730f, "faceservice_push_backup_data", "backupData faces is null!", null);
            dVar.a(null);
            return;
        }
        YTFaceTracker.TrackedFace trackedFace = trackedFaceArr[0];
        if (trackedFace == null) {
            WLogger.w("FaceDetect", "backupData face[0] is null,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f40730f, "faceservice_push_backup_data", "backupData face[0] is null!", null);
            dVar.a(null);
            return;
        }
        float[] fArr = trackedFace.faceShape;
        if (fArr == null || fArr.length <= 0) {
            WLogger.w("FaceDetect", "backupData face[0] shape is null or empty,return!");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f40730f, "faceservice_push_backup_data", "backupData face[0] shape is null or empty!", null);
            dVar.a(null);
            return;
        }
        WLogger.d("FaceDetect", "backupData shape:" + fArr.length + "," + fArr[0] + "," + bVar.f40601c + LanguageTag.PRIVATEUSE + bVar.f40602d);
        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
        Context context = this.f40730f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("backupData faces[0].faceShape.length=");
        sb2.append(fArr.length);
        kycWaSDK.trackCustomKVEvent(context, "faceservice_push_backup_data", sb2.toString(), null);
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public YTActRefData call() {
                WLogger.i("FaceDetect", "pushBackupData enter");
                YTFaceTracker.TrackedFace[] trackedFaceArr2 = bVar.f40599a;
                WLogger.d("FaceDetect", "data.faces=" + trackedFaceArr2[0].faceShape.length);
                YTActRefImage yTActRefImage = new YTActRefImage();
                yTActRefImage.checksum = "";
                yTActRefImage.xys = trackedFaceArr2[0].faceShape;
                int rotate = RotateSetting.getRotate();
                com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar2 = bVar;
                yTActRefImage.image = RotateSetting.rawCamDataToJpg(rotate, bVar2.f40600b, bVar2.f40601c, bVar2.f40602d, false);
                YTActRefData yTActRefData = new YTActRefData();
                yTActRefData.best = yTActRefImage;
                yTActRefData.eye = yTActRefImage;
                yTActRefData.mouth = yTActRefImage;
                return yTActRefData;
            }
        }, new b.a<YTActRefData>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(YTActRefData yTActRefData) {
                WLogger.i("FaceDetect", "pushBackupData success,get bestImages!");
                dVar.a(yTActRefData);
            }
        });
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.ui.a.c cVar) {
        this.f40725a = cVar;
    }

    public void a(boolean z10) {
        this.S = z10;
    }

    public void a(final byte[] bArr, final int i10, final int i11) {
        if (this.f40729e || this.S || this.f40732h.b() == 1 || this.f40732h.b() == 6 || this.f40732h.b() == 8 || this.f40732h.b() == 7 || this.f40732h.b() == 9) {
            return;
        }
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Callable<com.tencent.cloud.huiyansdkface.facelight.b.a.b>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.4
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.tencent.cloud.huiyansdkface.facelight.b.a.b call() {
                return a.this.b(bArr, i10, i11);
            }
        }, new b.a<com.tencent.cloud.huiyansdkface.facelight.b.a.b>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.5
            @Override // com.tencent.cloud.huiyansdkface.facelight.c.b.b.a
            public void a(com.tencent.cloud.huiyansdkface.facelight.b.a.b bVar) {
                a.this.a(bVar);
            }
        });
    }

    public void b() {
        WLogger.i("FaceDetect", "reset");
        this.f40731g.d(true);
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.Z = null;
        if (this.O != null) {
            WLogger.d("FaceDetect", "reset cancel recordCdt!");
            this.O.cancel();
            this.O = null;
        }
        this.R = false;
        this.P = false;
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.11
            @Override // java.lang.Runnable
            public void run() {
                b.c();
                d.z().k();
                d.z().n();
                YTAGReflectLiveCheckInterface.cancel();
            }
        });
    }
}
