package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.detector.MineInfo;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.track.model.TrackLog;

/* compiled from: ABDetectListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class s implements ad, k {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2838b = "ABDetectListener";

    /* renamed from: a, reason: collision with root package name */
    public ALBiometricsParams f2839a;

    /* renamed from: c, reason: collision with root package name */
    private t f2840c;

    /* renamed from: d, reason: collision with root package name */
    private ALBiometricsService f2841d;

    /* renamed from: e, reason: collision with root package name */
    private r f2842e;

    public s(t tVar) {
        this.f2840c = tVar;
        ALBiometricsService aLBiometricsService = tVar.f2843o;
        this.f2841d = aLBiometricsService;
        this.f2839a = aLBiometricsService.getParams();
        this.f2842e = this.f2840c.f2850v;
    }

    private static int b(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 6 ? GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OTHER : GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION : GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE : GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION;
    }

    @Override // com.alibaba.security.biometrics.service.build.k
    public final void a(ABDetectFrame aBDetectFrame) {
        int value = ABDetectContext.getInstance().getCurrentPhase().getValue();
        ABDetectPhase aBDetectPhase = ABDetectPhase.FINISH;
        if (value >= aBDetectPhase.getValue()) {
            return;
        }
        if (this.f2839a.faceOnly) {
            this.f2840c.b(99, aBDetectFrame);
            return;
        }
        ABDetectContext.getInstance().setFrameCount(ABDetectContext.getInstance().getFrameCount() + 1);
        if (aBDetectFrame.facesDetected() > 0 && !ABDetectContext.getInstance().isEverFaceDetected()) {
            ABDetectContext.getInstance().setEverFaceDetected(true);
        }
        if (ABDetectContext.getInstance().getCurrentPhase() == ABDetectPhase.INIT) {
            a();
        }
        this.f2840c.a(11, (Object) aBDetectFrame);
        if (ABDetectContext.getInstance().getCurrentPhase() == ABDetectPhase.ADJUST_END && this.f2839a.actionCount > 0) {
            this.f2840c.b(4, ABDetectContext.getInstance().offerAction());
        }
        if (this.f2840c.f2849u.a()) {
            ABDetectContext.getInstance().stop();
            a(GlobalErrorCode.ERROR_BIO_TIMEOUT);
        }
        int a10 = this.f2842e.a();
        if (a10 == 0 || ABDetectContext.getInstance().getCurrentPhase().getValue() >= aBDetectPhase.getValue()) {
            return;
        }
        a(a10);
    }

    @Override // com.alibaba.security.biometrics.service.build.k
    public final void b(int i10, Bundle bundle) {
        e(i10, bundle);
    }

    @Override // com.alibaba.security.biometrics.service.build.k
    public final void c(int i10, Bundle bundle) {
        e(i10, bundle);
    }

    public final void d(int i10, Bundle bundle) {
        int value = ABDetectContext.getInstance().getCurrentPhase().getValue();
        ABDetectPhase aBDetectPhase = ABDetectPhase.FINISH;
        if (value < aBDetectPhase.getValue() && ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ACTION_END) {
            if (2 == i10) {
                ABDetectContext.getInstance().stop();
                if (ABDetectContext.getInstance().getCurrentPhase().getValue() <= ABDetectPhase.ADJUST_END.getValue()) {
                    e(GlobalErrorCode.ERROR_ALGO_TIMEOUT_ADJUST, bundle);
                    return;
                } else {
                    e(GlobalErrorCode.ERROR_ALGO_TIMEOUT_ACTION, bundle);
                    return;
                }
            }
            int value2 = ABDetectContext.getInstance().getCurrentPhase().getValue();
            ABDetectPhase aBDetectPhase2 = ABDetectPhase.ACTION_BEGIN;
            if (value2 < aBDetectPhase2.getValue()) {
                ABDetectContext.getInstance().setBestFrame(null);
                return;
            }
            ABDetectContext.getInstance().getCurrentActionResult().setEc(bundle.getInt("ec", -1));
            ABDetectContext.getInstance().getCurrentActionResult().setEtcc(bundle.getInt("etcc", -1));
            ABDetectContext.getInstance().getCurrentActionResult().setEcpc(bundle.getInt("ecpc", -1));
            ABDetectContext.getInstance().getCurrentActionResult().setEcResult(bundle.getString("ecResult", ""));
            if (ABDetectContext.getInstance().getCurrentPhase().getValue() < aBDetectPhase2.getValue() || ABDetectContext.getInstance().getCurrentPhase().getValue() >= aBDetectPhase.getValue()) {
                return;
            }
            this.f2842e.a(c(i10), true, false);
        }
    }

    public final void e(int i10, Bundle bundle) {
        if (r.d(i10)) {
            this.f2841d.stop();
            this.f2840c.a(i10, bundle);
        } else if (r.c(i10)) {
            this.f2840c.a(12, (Object) new q(i10, bundle));
        }
    }

    private ABDetectType c(int i10) {
        ABDetectContext.getInstance().setLastDetectFailedType(i10);
        ABDetectContext.getInstance().getCurrentActionResult().addMine(new MineInfo(i10, System.currentTimeMillis()));
        ABDetectContext.getInstance().getCurrentActionResult().setEt(System.currentTimeMillis());
        a(b(i10));
        return ABDetectContext.getInstance().getCurrentAction();
    }

    @Override // com.alibaba.security.biometrics.service.build.k
    public final ABDetectType a(ABFaceFrame aBFaceFrame, ABDetectType aBDetectType) {
        f fVar = this.f2840c.f2847s;
        if (ABDetectContext.getInstance().getCurrentPhase().getValue() >= ABDetectPhase.FINISH.getValue()) {
            return ABDetectType.DONE;
        }
        int value = ABDetectContext.getInstance().getCurrentPhase().getValue();
        ABDetectPhase aBDetectPhase = ABDetectPhase.ACTION_BEGIN;
        if (value < aBDetectPhase.getValue()) {
            if (!this.f2842e.a(fVar)) {
                a(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
                return ABDetectType.AIMLESS;
            }
            this.f2842e.b(fVar);
            this.f2842e.c(fVar);
            this.f2840c.b(3, aBFaceFrame);
            return ABDetectType.AIMLESS;
        }
        if (aBDetectType == ABDetectType.KEEP_STILL) {
            return ABDetectType.AIMLESS;
        }
        if (ABDetectContext.getInstance().getCurrentPhase() != aBDetectPhase) {
            return ABDetectType.AIMLESS;
        }
        this.f2840c.b(5, aBFaceFrame);
        if (!ABDetectContext.getInstance().isLastAction()) {
            return ABDetectType.AIMLESS;
        }
        return ABDetectType.DONE;
    }

    public final void a(TrackLog trackLog) {
        if (this.f2841d.getABEventListener() != null) {
            this.f2841d.getABEventListener().onLogTrack(trackLog);
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.k
    public final void a(int i10, Bundle bundle) {
        d(i10, bundle);
    }

    private void a(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.f2839a = aLBiometricsParams;
        }
    }

    public final void a(int i10) {
        e(i10, new Bundle());
    }

    private void a() {
        this.f2840c.a(1);
        this.f2840c.c(1);
    }
}
