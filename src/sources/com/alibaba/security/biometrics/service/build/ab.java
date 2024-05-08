package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.build.e;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;

/* compiled from: FinishState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class ab extends y {

    /* compiled from: FinishState.java */
    /* renamed from: com.alibaba.security.biometrics.service.build.ab$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 implements e.a {
        public AnonymousClass1() {
        }

        @Override // com.alibaba.security.biometrics.service.build.e.a
        public final void a(int i10, float[] fArr, String str) {
            boolean z10;
            int i11;
            ABDetectContext.getInstance().getResult().setRecapResult(i10);
            ABDetectContext.getInstance().getResult().setRecapScore(fArr);
            ABDetectContext.getInstance().getResult().setRecapLog(str);
            ABDetectContext.getInstance().getResult().setRecapFrames(e.a().f2713i);
            if (e.a().f2713i > 0) {
                ABDetectContext.getInstance().getResult().setRecapAvgTime((int) (e.a().f2714j / e.a().f2713i));
            }
            ab abVar = ab.this;
            ALBiometricsParams aLBiometricsParams = abVar.f2860d;
            if (aLBiometricsParams.recapEnable) {
                float f10 = aLBiometricsParams.recapThreshold;
                if (f10 > 0.0f && fArr != null && fArr.length > 0 && fArr[0] > f10) {
                    z10 = true;
                    i11 = aLBiometricsParams.actionWhileCheckFail;
                    if (i11 < 0 && z10) {
                        ALBiometricsParams params = abVar.f2859c.getParams();
                        params.actionCount = i11;
                        ab abVar2 = ab.this;
                        params.strategy = abVar2.f2860d.strategyWhileCheckFail;
                        params.recapEnable = false;
                        params.actionWhileCheckFail = -1;
                        if (i11 > 0) {
                            params.stepAdjust = false;
                        }
                        abVar2.f2858b.b();
                        ab.this.f2858b.c();
                        return;
                    }
                    if (aLBiometricsParams.recapMode != 0 && z10) {
                        abVar.f2862f.a(GlobalErrorCode.ERROR_ALGO_RECAP_FAIL);
                        return;
                    } else {
                        abVar.f2858b.a();
                    }
                }
            }
            z10 = false;
            i11 = aLBiometricsParams.actionWhileCheckFail;
            if (i11 < 0) {
            }
            if (aLBiometricsParams.recapMode != 0) {
            }
            abVar.f2858b.a();
        }
    }

    public ab(t tVar) {
        super(tVar);
    }

    private void e() {
        Handler handler;
        ABDetectContext.getInstance().getResult().setEt(System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putLong("img1_ts", ABDetectContext.getInstance().getResult().getQi().getT());
        bundle.putInt("result", 1);
        bundle.putFloat("bri", ABDetectContext.getInstance().getResult().getQi().getB());
        bundle.putFloat("mblur", ABDetectContext.getInstance().getResult().getQi().getMb());
        bundle.putFloat("gblur", ABDetectContext.getInstance().getResult().getQi().getGb());
        bundle.putFloat("qua", ABDetectContext.getInstance().getResult().getQi().getQ());
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 0) {
            bundle.putLong("img2_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(0).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 1) {
            bundle.putLong("img3_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(1).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 0) {
            bundle.putLong("img4_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(0).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 1) {
            bundle.putLong("img5_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(1).getT());
        }
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        bundle.putString(b.bJ, ABDetectContext.getInstance().getResult().getBgDetectResult());
        a.a().a(b.f2677u, bundle);
        if (this.f2860d.recapEnable) {
            e a10 = e.a();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            if (ALBiometricsJni.isLoaded() && ALBiometricsJni.IsEnabled() && a10.f2713i > 0 && (handler = a10.f2716l) != null) {
                a10.f2718n = true;
                handler.post(new e.AnonymousClass3(anonymousClass1));
                return;
            } else {
                anonymousClass1.a(GlobalErrorCode.ERROR_ALGO_RECAP_INIT_FAIL, null, null);
                return;
            }
        }
        this.f2858b.a();
    }

    private void f() {
        Handler handler;
        ABDetectContext.getInstance().getResult().setEt(System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putLong("img1_ts", ABDetectContext.getInstance().getResult().getQi().getT());
        bundle.putInt("result", 1);
        bundle.putFloat("bri", ABDetectContext.getInstance().getResult().getQi().getB());
        bundle.putFloat("mblur", ABDetectContext.getInstance().getResult().getQi().getMb());
        bundle.putFloat("gblur", ABDetectContext.getInstance().getResult().getQi().getGb());
        bundle.putFloat("qua", ABDetectContext.getInstance().getResult().getQi().getQ());
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 0) {
            bundle.putLong("img2_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(0).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 1) {
            bundle.putLong("img3_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(1).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 0) {
            bundle.putLong("img4_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(0).getT());
        }
        if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 1) {
            bundle.putLong("img5_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(1).getT());
        }
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        bundle.putString(b.bJ, ABDetectContext.getInstance().getResult().getBgDetectResult());
        a.a().a(b.f2677u, bundle);
        if (this.f2860d.recapEnable) {
            e a10 = e.a();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            if (ALBiometricsJni.isLoaded() && ALBiometricsJni.IsEnabled() && a10.f2713i > 0 && (handler = a10.f2716l) != null) {
                a10.f2718n = true;
                handler.post(new e.AnonymousClass3(anonymousClass1));
                return;
            } else {
                anonymousClass1.a(GlobalErrorCode.ERROR_ALGO_RECAP_INIT_FAIL, null, null);
                return;
            }
        }
        this.f2858b.a();
    }

    @Override // com.alibaba.security.biometrics.service.build.y
    public final String a() {
        return "FinishState";
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final boolean a(Message message) {
        Handler handler;
        int i10 = message.what;
        if (i10 == 887) {
            ABDetectContext.getInstance().getResult().setEt(System.currentTimeMillis());
            Bundle bundle = new Bundle();
            bundle.putLong("img1_ts", ABDetectContext.getInstance().getResult().getQi().getT());
            bundle.putInt("result", 1);
            bundle.putFloat("bri", ABDetectContext.getInstance().getResult().getQi().getB());
            bundle.putFloat("mblur", ABDetectContext.getInstance().getResult().getQi().getMb());
            bundle.putFloat("gblur", ABDetectContext.getInstance().getResult().getQi().getGb());
            bundle.putFloat("qua", ABDetectContext.getInstance().getResult().getQi().getQ());
            if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 0) {
                bundle.putLong("img2_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(0).getT());
            }
            if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 0 && ABDetectContext.getInstance().getResult().getAs().get(0).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(0).getIs().size() > 1) {
                bundle.putLong("img3_ts", ABDetectContext.getInstance().getResult().getAs().get(0).getIs().get(1).getT());
            }
            if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 0) {
                bundle.putLong("img4_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(0).getT());
            }
            if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getAs() != null && ABDetectContext.getInstance().getResult().getAs().size() > 1 && ABDetectContext.getInstance().getResult().getAs().get(1).getIs() != null && ABDetectContext.getInstance().getResult().getAs().get(1).getIs().size() > 1) {
                bundle.putLong("img5_ts", ABDetectContext.getInstance().getResult().getAs().get(1).getIs().get(1).getT());
            }
            bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
            bundle.putString(b.bJ, ABDetectContext.getInstance().getResult().getBgDetectResult());
            a.a().a(b.f2677u, bundle);
            if (this.f2860d.recapEnable) {
                e a10 = e.a();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                if (ALBiometricsJni.isLoaded() && ALBiometricsJni.IsEnabled() && a10.f2713i > 0 && (handler = a10.f2716l) != null) {
                    a10.f2718n = true;
                    handler.post(new e.AnonymousClass3(anonymousClass1));
                } else {
                    anonymousClass1.a(GlobalErrorCode.ERROR_ALGO_RECAP_INIT_FAIL, null, null);
                }
            } else {
                this.f2858b.a();
            }
        } else if (i10 != 998) {
            return false;
        }
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.build.y, com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final void b() {
        super.b();
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.FINISH);
    }
}
