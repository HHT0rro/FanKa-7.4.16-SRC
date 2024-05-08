package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.build.ag;
import com.alibaba.security.biometrics.service.build.e;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.biometrics.service.model.strategy.ActionStrategy;
import com.alibaba.security.biometrics.service.model.strategy.FixActionStrategy;
import com.alibaba.security.biometrics.service.model.strategy.GroupActionStrategy;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.common.utils.StringUtils;
import com.alibaba.security.common.utils.SystemUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* compiled from: ABStateMachine.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class t extends ag implements ad, n {
    private static final String I = "ABStateMachine";
    public v A;
    public ab B;
    public boolean C;
    private Context J;
    private WindowManager K;
    private HandlerThread L;
    private Handler M;
    private ActionStrategy N;
    private z O;
    private ac P;

    /* renamed from: o, reason: collision with root package name */
    public ALBiometricsService f2843o;

    /* renamed from: p, reason: collision with root package name */
    public ALBiometricsParams f2844p;

    /* renamed from: q, reason: collision with root package name */
    public c f2845q;

    /* renamed from: r, reason: collision with root package name */
    public Handler f2846r;

    /* renamed from: s, reason: collision with root package name */
    public f f2847s;

    /* renamed from: t, reason: collision with root package name */
    public s f2848t;

    /* renamed from: u, reason: collision with root package name */
    public h f2849u;

    /* renamed from: v, reason: collision with root package name */
    public r f2850v;

    /* renamed from: w, reason: collision with root package name */
    public aa f2851w;

    /* renamed from: x, reason: collision with root package name */
    public w f2852x;

    /* renamed from: y, reason: collision with root package name */
    public x f2853y;

    /* renamed from: z, reason: collision with root package name */
    public u f2854z;

    public t(ALBiometricsService aLBiometricsService) {
        super(I);
        this.f2843o = aLBiometricsService;
        this.f2844p = aLBiometricsService.getParams();
        this.J = this.f2843o.getContext();
        this.K = (WindowManager) this.f2843o.getContext().getSystemService("window");
        c cVar = new c(this.J, this);
        this.f2845q = cVar;
        SensorManager sensorManager = (SensorManager) cVar.f2685b.getSystemService("sensor");
        cVar.f2686c = sensorManager;
        if (sensorManager != null) {
            cVar.f2687d = sensorManager.getDefaultSensor(4);
            cVar.f2688e = cVar.f2686c.getDefaultSensor(5);
            cVar.f2686c.registerListener(cVar.f2690g, cVar.f2687d, 3);
            cVar.f2686c.registerListener(cVar.f2691h, cVar.f2688e, 3);
        }
        this.f2846r = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("face_recognize_thread");
        this.L = handlerThread;
        handlerThread.start();
        this.M = new Handler(this.L.getLooper());
        f fVar = new f(this, aLBiometricsService.getABEventListener());
        this.f2847s = fVar;
        this.f2850v = new r(this.J, this.f2843o, fVar);
        s sVar = new s(this);
        this.f2848t = sVar;
        this.f2847s.a(sVar);
        b();
        f();
    }

    private void A() {
        ALBiometricsParams aLBiometricsParams = this.f2844p;
        if (aLBiometricsParams.faceOnly || ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
            return;
        }
        List<ABDetectType> detectTypes = this.N.getDetectTypes(this.f2844p.actionCount);
        if (!this.f2844p.stepAdjust && detectTypes.size() > 0) {
            ABDetectType aBDetectType = detectTypes.get(0);
            if (aBDetectType == ABDetectType.BLINK) {
                aBDetectType = ABDetectType.BLINK_STILL;
            } else if (aBDetectType == ABDetectType.MOUTH) {
                aBDetectType = ABDetectType.MOUTH_STILL;
            } else if (aBDetectType == ABDetectType.POS_YAW) {
                aBDetectType = ABDetectType.YAW_STILL;
            } else if (aBDetectType == ABDetectType.POS_PITCH || aBDetectType == ABDetectType.POS_PITCH_UP || aBDetectType == ABDetectType.POS_PITCH_DOWN) {
                aBDetectType = ABDetectType.PITCH_STILL;
            }
            detectTypes.set(0, aBDetectType);
        }
        ABDetectContext.getInstance().setActions(detectTypes);
    }

    private boolean B() {
        return this.f2849u.a();
    }

    private ALBiometricsService C() {
        return this.f2843o;
    }

    private void D() {
        d();
    }

    private void E() {
        HashMap hashMap = new HashMap();
        hashMap.put("detectType", ALBiometricsType.isDazzle(this.f2844p.mBiometricsType) ? "colorful" : "action");
        hashMap.put("timeout", Integer.valueOf(this.f2844p.timeout));
        ALBiometricsJni.bhL(6, JsonUtils.toJSON(hashMap));
        b(this.f2844p.timeout);
    }

    private static boolean F() {
        return System.currentTimeMillis() - ABDetectContext.getInstance().getResult().getBt() > 200 && ABDetectContext.getInstance().getCurrentPhase().getValue() < ABDetectPhase.FINISH.getValue();
    }

    private void G() {
        try {
            ABDetectContext.getInstance().stop();
            h hVar = this.f2849u;
            if (hVar != null) {
                hVar.d();
            }
            c(998);
        } catch (Throwable th) {
            a.a().a(th);
        }
    }

    private void H() {
        ABDetectContext.getInstance().getResult().increaseRetryTime();
        ABDetectContext.getInstance().setRetryTimes(ABDetectContext.getInstance().getRetryTimes() + 1);
        if (ABDetectContext.getInstance().getRetryTimes() > this.f2844p.retryThreshold) {
            this.f2848t.a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED);
        } else {
            c();
        }
    }

    private void I() {
        Handler handler;
        if (this.f_) {
            this.f_ = false;
            ag.c.h(this.g_);
        }
        f fVar = this.f2847s;
        if (fVar != null) {
            fVar.f2745j = null;
            if (fVar.f2746k) {
                ALBiometricsJni.release();
            }
            e eVar = fVar.f2752q;
            if (eVar != null) {
                if (ALBiometricsJni.isLoaded()) {
                    ALBiometricsJni.release();
                }
                if (eVar.f2712h != null && (handler = eVar.f2716l) != null) {
                    handler.post(new e.AnonymousClass4());
                }
                eVar.f2713i = 0;
                eVar.f2714j = 0L;
                eVar.f2717m = false;
            }
        }
        e.b();
        ABDetectContext.getInstance().destroy();
        h hVar = this.f2849u;
        if (hVar != null) {
            hVar.f2760c = null;
        }
        c cVar = this.f2845q;
        if (cVar != null) {
            SensorManager sensorManager = cVar.f2686c;
            if (sensorManager != null) {
                sensorManager.unregisterListener(cVar.f2689f);
                cVar.f2686c.unregisterListener(cVar.f2690g);
                cVar.f2686c.unregisterListener(cVar.f2691h);
            }
            cVar.f2686c = null;
            cVar.f2689f = null;
            cVar.f2690g = null;
            cVar.f2691h = null;
        }
        this.C = false;
    }

    private boolean a(ABActionResult aBActionResult) {
        return this.f2850v.a(this.f2847s, aBActionResult);
    }

    private void d(int i10) {
        SharedPreferences.Editor edit = this.f2850v.f2832a.getContext().getSharedPreferences("reflect", 0).edit();
        edit.putInt("abrpft", i10);
        edit.commit();
    }

    private boolean e() {
        this.C = false;
        boolean a10 = this.f2847s.a(this.J, this.f2844p);
        if (!a10) {
            a10 = this.f2847s.a(this.J, this.f2844p);
        }
        this.C = a10;
        return a10;
    }

    private void f() {
        this.O = new z(this);
        this.P = new ac(this);
        if (!ALBiometricsType.isDazzle(this.f2844p.mBiometricsType)) {
            if (this.f2844p.faceOnly) {
                this.f2851w = new aa(this);
            } else {
                this.f2852x = new w(this);
                this.f2853y = new x(this);
                this.f2854z = new u(this);
                this.A = new v(this);
            }
        }
        this.B = new ab(this);
        g();
    }

    private void g() {
        a((af) this.O);
        a(this.P, this.O);
        if (!ALBiometricsType.isDazzle(this.f2844p.mBiometricsType)) {
            if (this.f2844p.faceOnly) {
                a(this.f2851w, this.P);
            } else {
                a(this.f2852x, this.P);
                a(this.f2853y, this.P);
                a(this.f2854z, this.P);
                a(this.A, this.P);
            }
        }
        a(this.B, this.P);
    }

    private z h() {
        return this.O;
    }

    private ac i() {
        return this.P;
    }

    private aa j() {
        return this.f2851w;
    }

    private w k() {
        return this.f2852x;
    }

    private x l() {
        return this.f2853y;
    }

    private u m() {
        return this.f2854z;
    }

    private v n() {
        return this.A;
    }

    private ab o() {
        return this.B;
    }

    private Handler p() {
        return this.f2846r;
    }

    private Handler q() {
        return this.M;
    }

    private f r() {
        return this.f2847s;
    }

    private r s() {
        return this.f2850v;
    }

    private s t() {
        return this.f2848t;
    }

    private boolean u() {
        return this.f2850v.a(this.f2847s);
    }

    private boolean v() {
        return this.f2850v.b(this.f2847s);
    }

    private boolean w() {
        return this.f2850v.c(this.f2847s);
    }

    private static boolean x() {
        return (ABDetectContext.getInstance().getResult() == null || ABDetectContext.getInstance().getResult().getQi() == null || ABDetectContext.getInstance().getResult().getQi().getP() == null) ? false : true;
    }

    private boolean y() {
        return this.f2850v.b();
    }

    private int z() {
        return this.f2850v.f2832a.getContext().getSharedPreferences("reflect", 0).getInt("abrpft", 0);
    }

    public final void b() {
        ALBiometricsParams aLBiometricsParams = this.f2844p;
        if (aLBiometricsParams.faceOnly || ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
            return;
        }
        int[] iArr = this.f2844p.strategy;
        if (iArr != null && iArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i10 : this.f2844p.strategy) {
                arrayList.add(ABDetectType.valueOf(i10));
            }
            this.N = new FixActionStrategy(arrayList);
            return;
        }
        this.N = new GroupActionStrategy();
    }

    public final void c() {
        if (!this.f2844p.supportX86 && SystemUtils.isCpuX86()) {
            this.f2848t.a(GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86);
            return;
        }
        if (!this.C) {
            this.C = false;
            boolean a10 = this.f2847s.a(this.J, this.f2844p);
            if (!a10) {
                a10 = this.f2847s.a(this.J, this.f2844p);
            }
            this.C = a10;
            if (!a10) {
                return;
            }
        }
        if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.INIT) {
            c(0);
        }
        a.a().a(this.f2844p.sensorDataIntervals);
        HashMap hashMap = new HashMap();
        hashMap.put("detectType", ALBiometricsType.isDazzle(this.f2844p.mBiometricsType) ? "colorful" : "action");
        hashMap.put("timeout", Integer.valueOf(this.f2844p.timeout));
        ALBiometricsJni.bhL(6, JsonUtils.toJSON(hashMap));
        b(this.f2844p.timeout);
        b();
        f();
        ALBiometricsParams aLBiometricsParams = this.f2844p;
        if (!aLBiometricsParams.faceOnly && !ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
            List<ABDetectType> detectTypes = this.N.getDetectTypes(this.f2844p.actionCount);
            if (!this.f2844p.stepAdjust && detectTypes.size() > 0) {
                ABDetectType aBDetectType = detectTypes.get(0);
                if (aBDetectType == ABDetectType.BLINK) {
                    aBDetectType = ABDetectType.BLINK_STILL;
                } else if (aBDetectType == ABDetectType.MOUTH) {
                    aBDetectType = ABDetectType.MOUTH_STILL;
                } else if (aBDetectType == ABDetectType.POS_YAW) {
                    aBDetectType = ABDetectType.YAW_STILL;
                } else if (aBDetectType == ABDetectType.POS_PITCH || aBDetectType == ABDetectType.POS_PITCH_UP || aBDetectType == ABDetectType.POS_PITCH_DOWN) {
                    aBDetectType = ABDetectType.PITCH_STILL;
                }
                detectTypes.set(0, aBDetectType);
            }
            ABDetectContext.getInstance().setActions(detectTypes);
        }
        ABDetectContext.getInstance().reset();
        ABDetectContext.getInstance().start();
        Display defaultDisplay = this.K.getDefaultDisplay();
        ABDetectContext.getInstance().setDisplayWidth(defaultDisplay.getWidth());
        ABDetectContext.getInstance().setDisplayHeight(defaultDisplay.getHeight());
        ALBiometricsResult aLBiometricsResult = new ALBiometricsResult();
        aLBiometricsResult.setBt(System.currentTimeMillis());
        aLBiometricsResult.setAid(this.f2844p.appId);
        aLBiometricsResult.setDid(this.f2844p.deviceId);
        aLBiometricsResult.setSid(this.f2844p.sceneId);
        aLBiometricsResult.setUid(this.f2844p.uid);
        aLBiometricsResult.setQi(new ABImageResult());
        aLBiometricsResult.setK(StringUtils.toBase64String(ALBiometricsJni.generateKeyToken(this.f2844p.secToken)));
        aLBiometricsResult.setLid(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        ABDetectContext.getInstance().setResult(aLBiometricsResult);
        a(ABDetectType.AIMLESS, true, true);
        if (this.f2844p.recapEnable) {
            e.a().c();
        }
        a.a().a(this.f2844p);
        ag.c.a(this.g_, (af) this.P);
    }

    private boolean a(ABFaceFrame aBFaceFrame) {
        return this.f2850v.a(aBFaceFrame);
    }

    public final void a(int i10) {
        this.f2850v.a(i10);
    }

    public final void a(int i10, Object obj) {
        this.f2850v.a(i10, obj);
    }

    public final void a(int i10, Bundle bundle) {
        this.f2850v.a(i10, bundle);
    }

    public final void a() {
        this.f2843o.stop();
        r rVar = this.f2850v;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("succ", 1);
        bundle2.putInt("reason", 0);
        bundle2.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        if (ABDetectContext.getInstance().getResult() != null) {
            bundle2.putString("r_json", ABDetectContext.getInstance().getResult().toJson());
        }
        bundle2.putInt("time_adj_enable", rVar.f2833b.stepAdjust ? 1 : 0);
        bundle.putBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA, bundle2);
        bundle.putAll(r.b(0));
        rVar.a(13, new q(0, bundle));
    }

    public final void b(int i10) {
        if (this.f2849u == null) {
            this.f2849u = new h(i10);
        }
        this.f2849u.b();
        this.f2849u.c();
    }

    public final void a(ABDetectType aBDetectType, boolean z10, boolean z11) {
        this.f2850v.a(aBDetectType, z10, z11);
    }

    private void a(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.f2844p = aLBiometricsParams;
            r rVar = this.f2850v;
            if (rVar != null) {
                rVar.f2833b = aLBiometricsParams;
            }
            s sVar = this.f2848t;
            if (sVar != null) {
                sVar.f2839a = aLBiometricsParams;
            }
            b(999, aLBiometricsParams);
        }
    }

    public final void a(SensorEvent sensorEvent) {
        if (ABDetectContext.getInstance().isRunning()) {
            this.f2850v.a(sensorEvent);
        }
    }

    private void a(byte[] bArr, int i10, int i11, int i12) {
        if (ABDetectContext.getInstance().isRunning()) {
            if (bArr == null) {
                this.f2848t.a(GlobalErrorCode.ERROR_DEVICE_CAMERA_DATA_FAIL);
                return;
            }
            ABDetectContext.getInstance().setDisplayWidth(i10);
            ABDetectContext.getInstance().setDisplayHeight(i11);
            ABDetectContext.getInstance().setRotationAngle(i12);
            boolean z10 = true;
            if (System.currentTimeMillis() - ABDetectContext.getInstance().getResult().getBt() > 200 && ABDetectContext.getInstance().getCurrentPhase().getValue() < ABDetectPhase.FINISH.getValue()) {
                this.f2847s.a(bArr, i10, i11, i12);
            } else {
                z10 = false;
            }
            if (z10 && (i12 == 90 || i12 == 270)) {
                i12 = 0;
                i11 = i10;
                i10 = i11;
            }
            this.f2850v.a(bArr, i10, i11, i12);
        }
    }

    public final void a(float f10) {
        f fVar = this.f2847s;
        if (fVar != null) {
            fVar.f2754s = f10;
        }
    }

    private void a(ae aeVar) {
        if (aeVar != null) {
            this.g_.a(aeVar);
        }
    }

    private void a(Message message) {
        ag.c.a(this.g_, message);
    }

    public static void a(ABFaceFrame aBFaceFrame, ABImageResult aBImageResult) {
        aBImageResult.setMb(aBFaceFrame.getDetectInfo().e());
        aBImageResult.setGb(aBFaceFrame.getDetectInfo().c());
        aBImageResult.setQ(aBFaceFrame.getDetectInfo().h());
        aBImageResult.setB(aBFaceFrame.getDetectInfo().g());
        aBImageResult.setT(System.currentTimeMillis());
    }

    private static boolean a(m mVar) {
        if (mVar != null && mVar.w() != null && mVar.w().length >= 20) {
            int i10 = (int) (mVar.w()[12] - mVar.w()[8]);
            int i11 = (int) (mVar.w()[15] - mVar.w()[11]);
            int i12 = (int) (mVar.w()[20] - mVar.w()[16]);
            int i13 = (int) (mVar.w()[23] - mVar.w()[19]);
            if (i11 <= 0 || i11 <= 0 || i11 * 7 <= i10) {
                return i13 > 0 && i13 > 0 && i13 * 7 > i12;
            }
            return true;
        }
        RPLogging.e("ABDetectHelper", "isEyeOpen... fail, detectInfo == null || detectInfo.getLandmarks() == null || detectInfo.getLandmarks().length < 20");
        return false;
    }
}
