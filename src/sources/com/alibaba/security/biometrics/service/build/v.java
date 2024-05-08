package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;

/* compiled from: ActionDetectEndState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class v extends y {

    /* compiled from: ActionDetectEndState.java */
    /* renamed from: com.alibaba.security.biometrics.service.build.v$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ABDetectType f2855a;

        public AnonymousClass1(ABDetectType aBDetectType) {
            this.f2855a = aBDetectType;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f2855a == ABDetectType.DONE || !ABDetectContext.getInstance().isRunning()) {
                return;
            }
            v.this.f2858b.b(4, this.f2855a);
        }
    }

    public v(t tVar) {
        super(tVar);
    }

    private void e() {
        ABDetectType currentAction = ABDetectContext.getInstance().getCurrentAction();
        if (currentAction == ABDetectType.DONE) {
            if ((ABDetectContext.getInstance().getResult() == null || ABDetectContext.getInstance().getResult().getQi() == null || ABDetectContext.getInstance().getResult().getQi().getP() == null) ? false : true) {
                this.f2858b.c(887);
            } else {
                this.f2862f.a(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
            }
        }
        this.f2858b.f2846r.postDelayed(new AnonymousClass1(currentAction), 100L);
    }

    @Override // com.alibaba.security.biometrics.service.build.y
    public final String a() {
        return "ActionDetectEndState";
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final boolean a(Message message) {
        boolean z10 = false;
        if (message.what != 5) {
            return false;
        }
        ABFaceFrame aBFaceFrame = (ABFaceFrame) message.obj;
        if (ABDetectContext.getInstance().getCurrentPhase() == ABDetectPhase.ACTION_BEGIN) {
            ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ACTION_END);
            ABDetectContext.getInstance().getCurrentActionResult().setEt(System.currentTimeMillis());
            ABDetectContext.getInstance().getCurrentActionResult().setEc(aBFaceFrame.getDetectInfo().y());
            ABDetectContext.getInstance().getCurrentActionResult().setEtcc(aBFaceFrame.getDetectInfo().A());
            ABDetectContext.getInstance().getCurrentActionResult().setEcpc(aBFaceFrame.getDetectInfo().z());
            ABDetectContext.getInstance().getCurrentActionResult().setEcResult(aBFaceFrame.getDetectInfo().B());
            if (ABDetectContext.getInstance().getBestFrame() == null || this.f2861e.d() == ABDetectType.BLINK || this.f2861e.d() == ABDetectType.MOUTH || this.f2861e.d() == ABDetectType.BLINK_STILL || this.f2861e.d() == ABDetectType.MOUTH_STILL) {
                t tVar = this.f2858b;
                if (!tVar.f2850v.a(tVar.f2847s)) {
                    this.f2862f.a(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
                } else {
                    t tVar2 = this.f2858b;
                    tVar2.f2850v.b(tVar2.f2847s);
                    t tVar3 = this.f2858b;
                    tVar3.f2850v.c(tVar3.f2847s);
                    ABDetectContext.getInstance().setBestFrame(aBFaceFrame);
                    t.a(aBFaceFrame, ABDetectContext.getInstance().getResult().getQi());
                }
            }
            if (aBFaceFrame.getDetectInfo() != null) {
                ABDetectContext.getInstance().getCurrentActionResult().setTd(aBFaceFrame.getDetectInfo().j() ? 1 : 0);
            }
            this.f2858b.a(6, (Object) new p(ABDetectContext.getInstance().getCurrentAction(), ABDetectContext.getInstance().getCurrentActionIndex(), ABDetectContext.getInstance().getActionCount()));
            ABActionResult currentActionResult = ABDetectContext.getInstance().getCurrentActionResult();
            Bundle bundle = new Bundle();
            bundle.putInt("result", 1);
            bundle.putInt("act_idx", ABDetectContext.getInstance().getCurrentActionStep());
            bundle.putInt("act_type", ABDetectContext.getInstance().getCurrentAction().getValue());
            bundle.putInt("frm_c", ABDetectContext.getInstance().getFrameCount());
            bundle.putFloat("bri", aBFaceFrame.getDetectInfo().g());
            bundle.putFloat("gblur", aBFaceFrame.getDetectInfo().c());
            bundle.putFloat("mblur", aBFaceFrame.getDetectInfo().e());
            bundle.putFloat("qua", aBFaceFrame.getDetectInfo().h());
            a.a().a(b.f2672p, bundle);
            t tVar4 = this.f2858b;
            tVar4.f2850v.a(tVar4.f2847s, currentActionResult);
            ABDetectContext.getInstance().offerAction();
            ABDetectType currentAction = ABDetectContext.getInstance().getCurrentAction();
            if (currentAction == ABDetectType.DONE) {
                if (ABDetectContext.getInstance().getResult() != null && ABDetectContext.getInstance().getResult().getQi() != null && ABDetectContext.getInstance().getResult().getQi().getP() != null) {
                    z10 = true;
                }
                if (z10) {
                    this.f2858b.c(887);
                } else {
                    this.f2862f.a(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
                }
            }
            this.f2858b.f2846r.postDelayed(new AnonymousClass1(currentAction), 100L);
        }
        return true;
    }

    private void a(ABFaceFrame aBFaceFrame) {
        if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ACTION_BEGIN) {
            return;
        }
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ACTION_END);
        ABDetectContext.getInstance().getCurrentActionResult().setEt(System.currentTimeMillis());
        ABDetectContext.getInstance().getCurrentActionResult().setEc(aBFaceFrame.getDetectInfo().y());
        ABDetectContext.getInstance().getCurrentActionResult().setEtcc(aBFaceFrame.getDetectInfo().A());
        ABDetectContext.getInstance().getCurrentActionResult().setEcpc(aBFaceFrame.getDetectInfo().z());
        ABDetectContext.getInstance().getCurrentActionResult().setEcResult(aBFaceFrame.getDetectInfo().B());
        if (ABDetectContext.getInstance().getBestFrame() == null || this.f2861e.d() == ABDetectType.BLINK || this.f2861e.d() == ABDetectType.MOUTH || this.f2861e.d() == ABDetectType.BLINK_STILL || this.f2861e.d() == ABDetectType.MOUTH_STILL) {
            t tVar = this.f2858b;
            if (!tVar.f2850v.a(tVar.f2847s)) {
                this.f2862f.a(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
                return;
            }
            t tVar2 = this.f2858b;
            tVar2.f2850v.b(tVar2.f2847s);
            t tVar3 = this.f2858b;
            tVar3.f2850v.c(tVar3.f2847s);
            ABDetectContext.getInstance().setBestFrame(aBFaceFrame);
            t.a(aBFaceFrame, ABDetectContext.getInstance().getResult().getQi());
        }
        if (aBFaceFrame.getDetectInfo() != null) {
            ABDetectContext.getInstance().getCurrentActionResult().setTd(aBFaceFrame.getDetectInfo().j() ? 1 : 0);
        }
        this.f2858b.a(6, (Object) new p(ABDetectContext.getInstance().getCurrentAction(), ABDetectContext.getInstance().getCurrentActionIndex(), ABDetectContext.getInstance().getActionCount()));
        ABActionResult currentActionResult = ABDetectContext.getInstance().getCurrentActionResult();
        Bundle bundle = new Bundle();
        bundle.putInt("result", 1);
        bundle.putInt("act_idx", ABDetectContext.getInstance().getCurrentActionStep());
        bundle.putInt("act_type", ABDetectContext.getInstance().getCurrentAction().getValue());
        bundle.putInt("frm_c", ABDetectContext.getInstance().getFrameCount());
        bundle.putFloat("bri", aBFaceFrame.getDetectInfo().g());
        bundle.putFloat("gblur", aBFaceFrame.getDetectInfo().c());
        bundle.putFloat("mblur", aBFaceFrame.getDetectInfo().e());
        bundle.putFloat("qua", aBFaceFrame.getDetectInfo().h());
        a.a().a(b.f2672p, bundle);
        t tVar4 = this.f2858b;
        tVar4.f2850v.a(tVar4.f2847s, currentActionResult);
        ABDetectContext.getInstance().offerAction();
        ABDetectType currentAction = ABDetectContext.getInstance().getCurrentAction();
        if (currentAction == ABDetectType.DONE) {
            if ((ABDetectContext.getInstance().getResult() == null || ABDetectContext.getInstance().getResult().getQi() == null || ABDetectContext.getInstance().getResult().getQi().getP() == null) ? false : true) {
                this.f2858b.c(887);
            } else {
                this.f2862f.a(GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE);
            }
        }
        this.f2858b.f2846r.postDelayed(new AnonymousClass1(currentAction), 100L);
    }
}
