package com.tencent.cloud.huiyansdkface.facelight.process;

import android.text.TextUtils;
import androidx.annotation.UiThread;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FaceVerifyStatus {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40706a = true;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.b.d f40707b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f40708c;

    /* renamed from: d, reason: collision with root package name */
    private long f40709d;

    /* renamed from: e, reason: collision with root package name */
    private String f40710e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f40711f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.b.b f40712g;

    /* renamed from: h, reason: collision with root package name */
    private int f40713h;

    /* renamed from: i, reason: collision with root package name */
    private int f40714i;

    /* renamed from: j, reason: collision with root package name */
    private String f40715j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f40716k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.b.a f40717l;

    /* renamed from: m, reason: collision with root package name */
    private int f40718m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f40719n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f40720o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f40721p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f40722q;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Mode {
        GRADE
    }

    public FaceVerifyStatus(com.tencent.cloud.huiyansdkface.facelight.process.b.c cVar, com.tencent.cloud.huiyansdkface.facelight.process.b.b bVar, com.tencent.cloud.huiyansdkface.facelight.process.b.a aVar) {
        com.tencent.cloud.huiyansdkface.facelight.process.b.d dVar = new com.tencent.cloud.huiyansdkface.facelight.process.b.d();
        this.f40707b = dVar;
        this.f40713h = 0;
        this.f40718m = 0;
        dVar.a(cVar);
        this.f40712g = bVar;
        this.f40717l = aVar;
    }

    public static /* synthetic */ int d(FaceVerifyStatus faceVerifyStatus) {
        int i10 = faceVerifyStatus.f40713h;
        faceVerifyStatus.f40713h = i10 + 1;
        return i10;
    }

    @UiThread
    private void d(int i10) {
        if (this.f40717l == null) {
            WLogger.d("FaceVerifyStatus", "setCurrentType mActiveDetectInterface == null error!");
            return;
        }
        if (this.f40708c > 4) {
            WLogger.e("FaceVerifyStatus", "curStatus=" + this.f40708c + ",no need to update act.");
            return;
        }
        this.f40716k = i10;
        if (i10 == 1) {
            this.f40717l.b();
            return;
        }
        if (i10 == 2) {
            this.f40717l.c();
        } else if (i10 == 3) {
            this.f40717l.a();
        } else {
            if (i10 != 4) {
                return;
            }
            this.f40717l.d();
        }
    }

    public long a() {
        return this.f40709d;
    }

    public void a(int i10) {
        this.f40714i = i10;
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.process.b.c cVar) {
        this.f40707b.a(cVar);
    }

    public void a(String str) {
        this.f40710e = str;
    }

    public void a(boolean z10) {
        this.f40706a = z10;
    }

    public int b() {
        return this.f40708c;
    }

    @UiThread
    public void b(int i10) {
        String str;
        if (this.f40707b == null) {
            str = "setCurrentStep mInterface == null error!";
        } else {
            if (i10 != 2 || this.f40706a) {
                this.f40708c = i10;
                WLogger.d("FaceVerifyStatus", "setCurrentStep = " + i10 + ", curThread=" + Thread.currentThread().getName());
                switch (i10) {
                    case 1:
                        WLogger.i("FaceVerifyStatus", "Preview status start");
                        this.f40718m = 0;
                        this.f40713h = 0;
                        this.f40707b.h();
                        if (d.z().e().v()) {
                            WLogger.d("FaceVerifyStatus", "skip wait guide voice");
                            return;
                        } else {
                            long aa2 = d.z().e().aa();
                            new CloudFaceCountDownTimer(aa2, aa2 / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus.1
                                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                                public void onFinish() {
                                    String str2;
                                    WLogger.d("FaceVerifyStatus", "preview CountDownTimer onFinish");
                                    if (FaceVerifyStatus.this.b() == 9) {
                                        str2 = "Already finished!";
                                    } else {
                                        FaceVerifyStatus.this.b(2);
                                        str2 = "preview CountDownTimer onFinish setCurrentStep(FaceVerifyStatus.Status.FINDFACE)";
                                    }
                                    WLogger.d("FaceVerifyStatus", str2);
                                }

                                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                                public void onTick(long j10) {
                                }
                            }.start();
                            return;
                        }
                    case 2:
                        this.f40718m = 0;
                        this.f40713h = 0;
                        this.f40709d = System.currentTimeMillis();
                        WLogger.i("FaceVerifyStatus", "FINDFACE start at " + this.f40709d);
                        this.f40707b.i();
                        return;
                    case 3:
                        this.f40718m = 0;
                        this.f40713h = 0;
                        this.f40709d = System.currentTimeMillis();
                        this.f40707b.j();
                        return;
                    case 4:
                        this.f40707b.k();
                        return;
                    case 5:
                        this.f40707b.l();
                        return;
                    case 6:
                        this.f40707b.m();
                        return;
                    case 7:
                        WLogger.i("FaceVerifyStatus", "called outOfTime！");
                        this.f40707b.n();
                        return;
                    case 8:
                        this.f40707b.o();
                        return;
                    case 9:
                        this.f40707b.p();
                        return;
                    default:
                        return;
                }
            }
            str = "no flash res,CANT go to find face.Plz wait flashRes.";
        }
        WLogger.e("FaceVerifyStatus", str);
    }

    public void b(String str) {
        this.f40715j = str;
    }

    public void b(boolean z10) {
        this.f40719n = z10;
    }

    public int c() {
        return this.f40716k;
    }

    @UiThread
    public void c(int i10) {
        if (this.f40712g == null) {
            WLogger.d("FaceVerifyStatus", "setCurrentLiveCheck liveCheckProcess is null");
            return;
        }
        if (this.f40708c > 4) {
            WLogger.e("FaceVerifyStatus", "curStatus=" + this.f40708c + ",no need to update live.");
            return;
        }
        this.f40711f = i10;
        if (i10 == 1) {
            this.f40712g.e();
            return;
        }
        if (i10 == 2) {
            this.f40718m = 0;
            this.f40712g.f();
        } else {
            if (i10 != 3) {
                return;
            }
            this.f40712g.g();
        }
    }

    public void c(boolean z10) {
        this.f40722q = z10;
    }

    public int d() {
        return this.f40711f;
    }

    public int e() {
        return this.f40714i;
    }

    public boolean f() {
        return this.f40719n;
    }

    public boolean g() {
        return this.f40722q;
    }

    public boolean h() {
        return this.f40720o;
    }

    public boolean i() {
        return this.f40721p;
    }

    public void j() {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus.2
            @Override // java.lang.Runnable
            public void run() {
                int length;
                FaceVerifyStatus faceVerifyStatus;
                int i10;
                WLogger.d("FaceVerifyStatus", "checkNextLiveCheck");
                if (FaceVerifyStatus.this.f40710e == null || FaceVerifyStatus.this.f40708c != 4 || (length = FaceVerifyStatus.this.f40710e.length()) == 0) {
                    return;
                }
                WLogger.i("FaceVerifyStatus", "liveIndex=" + FaceVerifyStatus.this.f40713h + "; counts=" + length);
                if (FaceVerifyStatus.this.f40713h < length) {
                    int parseInt = Integer.parseInt(String.valueOf(FaceVerifyStatus.this.f40710e.charAt(FaceVerifyStatus.this.f40713h)));
                    FaceVerifyStatus.d(FaceVerifyStatus.this);
                    if (length - FaceVerifyStatus.this.f40713h == 0) {
                        WLogger.d("FaceVerifyStatus", "last live check BEGIN!");
                    }
                    FaceVerifyStatus.this.c(parseInt);
                    return;
                }
                if (WbFaceModeProviders.isUseWillSdk()) {
                    WLogger.d("FaceVerifyStatus", "need WillExpress,goToWillExpress");
                    faceVerifyStatus = FaceVerifyStatus.this;
                    i10 = 5;
                } else {
                    WLogger.d("FaceVerifyStatus", "already finish live check,goToUpload");
                    faceVerifyStatus = FaceVerifyStatus.this;
                    i10 = 6;
                }
                faceVerifyStatus.b(i10);
            }
        });
    }

    @UiThread
    public void k() {
        int length;
        String str = this.f40715j;
        if (str == null || (length = str.length()) == 0) {
            return;
        }
        WLogger.i("FaceVerifyStatus", "typeOrder is " + this.f40718m + "; typeNums is " + length);
        int i10 = this.f40718m;
        if (i10 >= length) {
            WLogger.d("FaceVerifyStatus", "last act detect END!");
            this.f40721p = true;
            if (TextUtils.isEmpty(this.f40710e) || !"2".equals(this.f40710e) || !d.z().x().m() || this.f40722q) {
                j();
                return;
            } else {
                d(4);
                return;
            }
        }
        int parseInt = Integer.parseInt(String.valueOf(this.f40715j.charAt(i10)));
        this.f40709d = System.currentTimeMillis();
        d(parseInt);
        int i11 = this.f40718m + 1;
        this.f40718m = i11;
        if (length - i11 != 0) {
            this.f40720o = false;
            return;
        }
        WLogger.d("FaceVerifyStatus", "last act detect BEGIN!isLastAct=" + this.f40720o);
        this.f40720o = true;
    }

    public void l() {
        if (this.f40708c == 2 || !this.f40706a) {
            return;
        }
        b(2);
    }
}
