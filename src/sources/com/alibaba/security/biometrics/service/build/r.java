package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.Md5Utils;
import com.alibaba.security.realidentity.build.cc;
import java.io.File;
import java.util.logging.Logger;

/* compiled from: ABDetectHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    private static final String f2830c = "ABDetectHelper";

    /* renamed from: d, reason: collision with root package name */
    private static final int f2831d = 1;

    /* renamed from: a, reason: collision with root package name */
    public ALBiometricsService f2832a;

    /* renamed from: b, reason: collision with root package name */
    public ALBiometricsParams f2833b;

    /* renamed from: e, reason: collision with root package name */
    private Context f2834e;

    /* renamed from: f, reason: collision with root package name */
    private f f2835f;

    /* renamed from: g, reason: collision with root package name */
    private d f2836g;

    /* renamed from: h, reason: collision with root package name */
    private o f2837h;

    public r(Context context, ALBiometricsService aLBiometricsService, f fVar) {
        this.f2834e = context;
        this.f2832a = aLBiometricsService;
        this.f2835f = fVar;
        this.f2833b = aLBiometricsService.getParams();
        this.f2836g = new d(this.f2834e);
        this.f2837h = new o(this.f2832a);
    }

    private void a(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.f2833b = aLBiometricsParams;
        }
    }

    private Message b(int i10, Object obj) {
        return Message.obtain(this.f2837h.f2822o, i10, obj);
    }

    private boolean c() {
        return this.f2836g.f2696a;
    }

    public static boolean c(int i10) {
        if (i10 == -10219 || i10 == 1004 || i10 == 1013 || i10 == 1060 || i10 == 1090 || i10 == 1001 || i10 == 1002) {
            return true;
        }
        switch (i10) {
            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION /* -10215 */:
            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE /* -10214 */:
            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION /* -10213 */:
                return true;
            default:
                switch (i10) {
                    case 1006:
                    case 1007:
                    case 1008:
                        return true;
                    default:
                        switch (i10) {
                            case 1053:
                            case 1054:
                            case 1055:
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    private void d(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        ABImageResult li = ABDetectContext.getInstance().getResult().getLi();
        if (li == null) {
            li = new ABImageResult();
        }
        if (a(bArr, "local", li, ".png")) {
            aLBiometricsResult.setLi(li);
        }
    }

    public static boolean d(int i10) {
        if (i10 == -10407 || i10 == -10405 || i10 == -10217 || i10 == -10106 || i10 == -10100) {
            return true;
        }
        switch (i10) {
            case GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE /* -10212 */:
            case GlobalErrorCode.ERROR_ALGO_REFLECT_FAIL /* -10211 */:
            case GlobalErrorCode.ERROR_ALGO_REFLECT_NO_FACE /* -10210 */:
            case GlobalErrorCode.ERROR_ALGO_RECAP_FAIL /* -10209 */:
                return true;
            default:
                switch (i10) {
                    case GlobalErrorCode.ERROR_ALGO_MODEL_COPY_FAIL /* -10207 */:
                    case GlobalErrorCode.ERROR_ALGO_MUCH_MINE /* -10206 */:
                    case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ADJUST /* -10205 */:
                    case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ACTION /* -10204 */:
                        return true;
                    default:
                        switch (i10) {
                            case GlobalErrorCode.ERROR_ALGO_CONFIG_FAIL /* -10202 */:
                            case GlobalErrorCode.ERROR_ALGO_INIT_FAIL /* -10201 */:
                            case GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL /* -10200 */:
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    private Message e(int i10) {
        return Message.obtain(this.f2837h.f2822o, i10);
    }

    private void f(int i10) {
        SharedPreferences.Editor edit = this.f2832a.getContext().getSharedPreferences("reflect", 0).edit();
        edit.putInt("abrpft", i10);
        edit.commit();
    }

    private Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putInt("succ", 1);
        bundle.putInt("reason", 0);
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        if (ABDetectContext.getInstance().getResult() != null) {
            bundle.putString("r_json", ABDetectContext.getInstance().getResult().toJson());
        }
        bundle.putInt("time_adj_enable", this.f2833b.stepAdjust ? 1 : 0);
        return bundle;
    }

    public final void a(int i10) {
        o oVar = this.f2837h;
        oVar.a(Message.obtain(oVar.f2822o, i10));
    }

    private int e() {
        return this.f2832a.getContext().getSharedPreferences("reflect", 0).getInt("abrpft", 0);
    }

    public final boolean b(j jVar) {
        try {
            if (ABDetectContext.getInstance().getResult().getGi() == null) {
                ABDetectContext.getInstance().getResult().setGi(new ABImageResult());
            }
            ABDetectContext.getInstance().getResult().getGi().setT(System.currentTimeMillis());
            byte[] i10 = jVar.i();
            if (i10 == null) {
                return false;
            }
            ALBiometricsResult result = ABDetectContext.getInstance().getResult();
            ABImageResult gi = ABDetectContext.getInstance().getResult().getGi();
            if (gi == null) {
                gi = new ABImageResult();
            }
            if (!a(i10, Logger.GLOBAL_LOGGER_NAME, gi, ".png")) {
                return true;
            }
            result.setGi(gi);
            return true;
        } catch (Throwable th) {
            RPLogging.e(f2830c, th);
            a.a().a(th);
            return false;
        }
    }

    public final boolean c(j jVar) {
        try {
            if (ABDetectContext.getInstance().getResult().getLi() == null) {
                ABDetectContext.getInstance().getResult().setLi(new ABImageResult());
            }
            ABDetectContext.getInstance().getResult().getLi().setT(System.currentTimeMillis());
            byte[] j10 = jVar.j();
            if (j10 == null) {
                return false;
            }
            ALBiometricsResult result = ABDetectContext.getInstance().getResult();
            ABImageResult li = ABDetectContext.getInstance().getResult().getLi();
            if (li == null) {
                li = new ABImageResult();
            }
            if (!a(j10, "local", li, ".png")) {
                return true;
            }
            result.setLi(li);
            return true;
        } catch (Throwable th) {
            RPLogging.e(f2830c, th);
            a.a().a(th);
            return false;
        }
    }

    private static boolean d() {
        return (ABDetectContext.getInstance().getResult() == null || ABDetectContext.getInstance().getResult().getQi() == null || ABDetectContext.getInstance().getResult().getQi().getP() == null) ? false : true;
    }

    private void f() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("succ", 1);
        bundle2.putInt("reason", 0);
        bundle2.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        if (ABDetectContext.getInstance().getResult() != null) {
            bundle2.putString("r_json", ABDetectContext.getInstance().getResult().toJson());
        }
        bundle2.putInt("time_adj_enable", this.f2833b.stepAdjust ? 1 : 0);
        bundle.putBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA, bundle2);
        bundle.putAll(b(0));
        a(13, new q(0, bundle));
    }

    public final void a(int i10, Object obj) {
        o oVar = this.f2837h;
        oVar.a(Message.obtain(oVar.f2822o, i10, obj));
    }

    private Bundle g(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("succ", 0);
        bundle.putInt("reason", i10);
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        if (ABDetectContext.getInstance().getResult() != null) {
            bundle.putString("r_json", ABDetectContext.getInstance().getResult().toJson());
        }
        bundle.putInt("time_adj_enable", this.f2833b.stepAdjust ? 1 : 0);
        return bundle;
    }

    public final void a(SensorEvent sensorEvent) {
        this.f2836g.onSensorChanged(sensorEvent);
    }

    public final void a(byte[] bArr, int i10, int i11, int i12) {
        int i13;
        int i14;
        byte[] byteArray;
        try {
            ABDetectContext aBDetectContext = ABDetectContext.getInstance();
            if (this.f2835f == null || aBDetectContext == null || !aBDetectContext.isNeedContinueImage()) {
                return;
            }
            int qualityImageCount = aBDetectContext.getQualityImageCount();
            ALBiometricsParams aLBiometricsParams = this.f2833b;
            int i15 = aLBiometricsParams.imageCount;
            if (qualityImageCount < i15 && i15 <= 3) {
                int i16 = i15 - 1;
                int i17 = aLBiometricsParams.imageIntervals;
                long qualityImageTime = aBDetectContext.getQualityImageTime();
                long j10 = i17;
                long j11 = (i16 * i17) + qualityImageTime + j10;
                long currentTimeMillis = System.currentTimeMillis();
                int i18 = 0;
                if (currentTimeMillis > j11) {
                    aBDetectContext.setNeedContinueImage(false);
                    return;
                }
                while (i18 < i16) {
                    int i19 = i18 + 1;
                    long j12 = (i19 * i17) + qualityImageTime;
                    long j13 = j12 + j10;
                    if (currentTimeMillis <= j12 || currentTimeMillis >= j13 || aBDetectContext.getQualityImageCount() >= i18 + 2) {
                        i13 = i17;
                    } else {
                        i13 = i17;
                        Bundle b4 = this.f2835f.b(bArr, i10, i11, i12);
                        if (b4 != null && (byteArray = b4.getByteArray("img")) != null) {
                            ABImageResult aBImageResult = new ABImageResult();
                            i14 = i16;
                            if (a(byteArray, "continue".concat(String.valueOf(i18)), aBImageResult)) {
                                aBDetectContext.setQualityImageCount(aBDetectContext.getQualityImageCount() + 1);
                                if (aBDetectContext.getResult() != null) {
                                    aBDetectContext.getResult().getContinueImages().add(aBImageResult);
                                }
                                a(2, aBImageResult);
                            }
                            i18 = i19;
                            i17 = i13;
                            i16 = i14;
                        }
                    }
                    i14 = i16;
                    i18 = i19;
                    i17 = i13;
                    i16 = i14;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            RPLogging.e(f2830c, "saveQualityImageData... save best quality image fail imageData=null");
            return;
        }
        ABImageResult qi = ABDetectContext.getInstance().getResult().getQi();
        if (qi == null) {
            qi = new ABImageResult();
        }
        if (a(bArr, "best", qi)) {
            aLBiometricsResult.setQi(qi);
        }
    }

    private void c(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        ABImageResult gi = ABDetectContext.getInstance().getResult().getGi();
        if (gi == null) {
            gi = new ABImageResult();
        }
        if (a(bArr, Logger.GLOBAL_LOGGER_NAME, gi, ".png")) {
            aLBiometricsResult.setGi(gi);
        }
    }

    public final boolean b() {
        int i10 = this.f2833b.reflectILThreshold;
        if (i10 <= 0) {
            return false;
        }
        float f10 = this.f2835f.f2754s;
        return ((double) f10) >= -0.1d && f10 < ((float) i10);
    }

    public static Bundle b(int i10) {
        Bundle bundle = new Bundle();
        long currentTimeMillis = System.currentTimeMillis();
        if (ABDetectContext.getInstance().getResult() != null) {
            ABDetectContext.getInstance().getResult().setEt(currentTimeMillis);
            ABDetectContext.getInstance().getResult().setR(i10);
            ABDetectContext.getInstance().getResult().setRt(ABDetectContext.getInstance().getRetryTimes());
            if (ABDetectContext.getInstance().getCurrentActionResult() != null) {
                ABDetectContext.getInstance().getCurrentActionResult().setEt(currentTimeMillis);
                ABDetectContext.getInstance().getCurrentActionResult().setR(i10);
            }
            bundle.putSerializable(ALBiometricsKeys.KEY_RESULT_DATA, ABDetectContext.getInstance().getResult());
            bundle.putInt(ALBiometricsKeys.KEY_RESULT_RETRYTIMES, ABDetectContext.getInstance().getRetryTimes());
        }
        return bundle;
    }

    public final void a(ABDetectType aBDetectType, boolean z10, boolean z11) {
        f fVar = this.f2835f;
        if (fVar != null) {
            if (z10 && fVar.f2746k) {
                ALBiometricsJni.Reset(z11);
            }
            this.f2835f.a(aBDetectType, z11);
        }
    }

    public final boolean a(j jVar) {
        byte[] k10;
        byte[] k11;
        try {
            ABDetectContext.getInstance().getResult().getQi().setT(System.currentTimeMillis());
            if (this.f2833b.lessImageMode) {
                k10 = jVar.g();
                ABDetectContext.getInstance().getResult().getQi().setLandmarks(jVar.h());
            } else {
                k10 = jVar.k();
                ABDetectContext.getInstance().getResult().getQi().setLandmarks(jVar.l());
            }
            if (k10 == null) {
                return false;
            }
            ALBiometricsResult result = ABDetectContext.getInstance().getResult();
            ABImageResult qi = ABDetectContext.getInstance().getResult().getQi();
            if (qi == null) {
                qi = new ABImageResult();
            }
            if (a(k10, "best", qi)) {
                result.setQi(qi);
            }
            if (this.f2833b.needOriginalImage && (k11 = jVar.k()) != null) {
                ALBiometricsResult result2 = ABDetectContext.getInstance().getResult();
                ABImageResult oi = ABDetectContext.getInstance().getResult().getOi();
                if (oi == null) {
                    oi = new ABImageResult();
                }
                if (a(k11, cc.f3296y, oi)) {
                    result2.setOi(oi);
                }
            }
            if (jVar.f() != null) {
                ABDetectContext.getInstance().getResult().getQi().setFr(new int[]{jVar.f().left, jVar.f().top, jVar.f().width(), jVar.f().height()});
            }
            return true;
        } catch (Throwable th) {
            RPLogging.e(f2830c, th);
            a.a().a(th);
            return false;
        }
    }

    private void a(ALBiometricsResult aLBiometricsResult, byte[] bArr) {
        if (bArr == null) {
            RPLogging.e(f2830c, "saveOriginImageData... Save origin image fail imageData=null");
            return;
        }
        ABImageResult oi = ABDetectContext.getInstance().getResult().getOi();
        if (oi == null) {
            oi = new ABImageResult();
        }
        if (a(bArr, cc.f3296y, oi)) {
            aLBiometricsResult.setOi(oi);
        }
    }

    private boolean a(byte[] bArr, String str, ABImageResult aBImageResult) {
        return a(bArr, str, aBImageResult, ".jpeg");
    }

    private boolean a(byte[] bArr, String str, ABImageResult aBImageResult, String str2) {
        aBImageResult.setBf(bArr);
        aBImageResult.setD(Md5Utils.md5(bArr));
        aBImageResult.setDt(0);
        if (!this.f2833b.saveImagesFile) {
            return true;
        }
        String str3 = this.f2834e.getFilesDir().toString() + File.separator + (Md5Utils.md5Str(str) + str2);
        boolean save = FileUtils.save(new File(str3), bArr);
        aBImageResult.setP(str3);
        return save;
    }

    public final boolean a(j jVar, ABActionResult aBActionResult) {
        try {
            aBActionResult.getIs().clear();
            for (int i10 = 0; i10 < 2; i10++) {
                ABImageResult aBImageResult = new ABImageResult();
                if (a(jVar.e().get(i10).getImageData(), "action_" + ABDetectContext.getInstance().getCurrentActionIndex() + "_" + i10, aBImageResult)) {
                    aBActionResult.addImageResult(aBImageResult);
                }
            }
            return true;
        } catch (Throwable th) {
            a.a().a(th);
            return false;
        }
    }

    private static void a(ABFaceFrame aBFaceFrame, ABImageResult aBImageResult) {
        aBImageResult.setMb(aBFaceFrame.getDetectInfo().e());
        aBImageResult.setGb(aBFaceFrame.getDetectInfo().c());
        aBImageResult.setQ(aBFaceFrame.getDetectInfo().h());
        aBImageResult.setB(aBFaceFrame.getDetectInfo().g());
        aBImageResult.setT(System.currentTimeMillis());
    }

    public final boolean a(ABFaceFrame aBFaceFrame) {
        if (aBFaceFrame == null) {
            return true;
        }
        try {
            if (aBFaceFrame.facesDetected() > 0) {
                return ((float) (aBFaceFrame.getFaceSize().width() * 2)) >= this.f2833b.reflectDistanceThreshold * ((float) Math.min(aBFaceFrame.getImageWidth(), aBFaceFrame.getImageHeight()));
            }
            return true;
        } catch (Exception e2) {
            RPLogging.e(f2830c, e2);
            return true;
        }
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
        RPLogging.e(f2830c, "isEyeOpen... fail, detectInfo == null || detectInfo.getLandmarks() == null || detectInfo.getLandmarks().length < 20");
        return false;
    }

    public final void a(int i10, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("succ", 0);
        bundle3.putInt("reason", i10);
        bundle3.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        if (ABDetectContext.getInstance().getResult() != null) {
            bundle3.putString("r_json", ABDetectContext.getInstance().getResult().toJson());
        }
        bundle3.putInt("time_adj_enable", this.f2833b.stepAdjust ? 1 : 0);
        bundle2.putBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA, bundle3);
        bundle2.putAll(b(i10));
        bundle2.putInt(ALBiometricsKeys.KEY_ERROR_CODE, i10);
        a(13, new q(1, bundle2));
    }

    public final int a() {
        if (this.f2836g.f2696a) {
            return 1004;
        }
        return !b() ? 1060 : 0;
    }
}
