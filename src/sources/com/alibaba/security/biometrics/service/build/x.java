package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;

/* compiled from: AdjustEndState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class x extends y {
    public x(t tVar) {
        super(tVar);
    }

    @Override // com.alibaba.security.biometrics.service.build.y
    public final String a() {
        return "AdjustEndState";
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final boolean a(Message message) {
        if (message.what != 3) {
            return false;
        }
        ABFaceFrame aBFaceFrame = (ABFaceFrame) message.obj;
        if (ABDetectContext.getInstance().getCurrentPhase() == ABDetectPhase.ADJUST_BEGIN) {
            ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ADJUST_END);
            ABDetectContext.getInstance().setBestFrame(aBFaceFrame);
            t.a(aBFaceFrame, ABDetectContext.getInstance().getResult().getQi());
            ABDetectContext.getInstance().getResult().getAdjustAction().setEc(aBFaceFrame.getDetectInfo().y());
            ABDetectContext.getInstance().getResult().getAdjustAction().setEtcc(aBFaceFrame.getDetectInfo().A());
            ABDetectContext.getInstance().getResult().getAdjustAction().setEcpc(aBFaceFrame.getDetectInfo().z());
            ABDetectContext.getInstance().getResult().getAdjustAction().setEcResult(aBFaceFrame.getDetectInfo().B());
            this.f2858b.a(4);
            Bundle bundle = new Bundle();
            bundle.putInt("result", 1);
            bundle.putInt("frm_c", ABDetectContext.getInstance().getFrameCount());
            a.a().a(b.f2668l, bundle);
            if (this.f2860d.actionCount == 0) {
                this.f2858b.c(887);
            }
            ALBiometricsParams aLBiometricsParams = this.f2860d;
            if (aLBiometricsParams.actionCount == 0 && aLBiometricsParams.needDisplayWaitingView && aLBiometricsParams.imageCount > 1) {
                ABDetectContext.getInstance().setQualityImageTime(System.currentTimeMillis());
                ABDetectContext.getInstance().setQualityImageCount(1);
                ABDetectContext.getInstance().setNeedContinueImage(true);
            }
        }
        return true;
    }

    private void a(ABFaceFrame aBFaceFrame) {
        if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ADJUST_BEGIN) {
            return;
        }
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ADJUST_END);
        ABDetectContext.getInstance().setBestFrame(aBFaceFrame);
        t.a(aBFaceFrame, ABDetectContext.getInstance().getResult().getQi());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEc(aBFaceFrame.getDetectInfo().y());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEtcc(aBFaceFrame.getDetectInfo().A());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEcpc(aBFaceFrame.getDetectInfo().z());
        ABDetectContext.getInstance().getResult().getAdjustAction().setEcResult(aBFaceFrame.getDetectInfo().B());
        this.f2858b.a(4);
        Bundle bundle = new Bundle();
        bundle.putInt("result", 1);
        bundle.putInt("frm_c", ABDetectContext.getInstance().getFrameCount());
        a.a().a(b.f2668l, bundle);
        if (this.f2860d.actionCount == 0) {
            this.f2858b.c(887);
        }
        ALBiometricsParams aLBiometricsParams = this.f2860d;
        if (aLBiometricsParams.actionCount == 0 && aLBiometricsParams.needDisplayWaitingView && aLBiometricsParams.imageCount > 1) {
            ABDetectContext.getInstance().setQualityImageTime(System.currentTimeMillis());
            ABDetectContext.getInstance().setQualityImageCount(1);
            ABDetectContext.getInstance().setNeedContinueImage(true);
        }
    }
}
