package com.alibaba.security.biometrics.service.build;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Message;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ALFaceDetectResult;

/* compiled from: FaceDetectState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class aa extends y {
    public aa(t tVar) {
        super(tVar);
    }

    @Override // com.alibaba.security.biometrics.service.build.y
    public final String a() {
        return "FaceDetectState";
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final boolean a(Message message) {
        if (message.what != 99) {
            return false;
        }
        Object obj = message.obj;
        if (obj == null) {
            return true;
        }
        ABFaceFrame aBFaceFrame = (ABFaceFrame) obj;
        ALFaceDetectResult aLFaceDetectResult = new ALFaceDetectResult();
        if (aBFaceFrame != null && aBFaceFrame.getDetectInfo() != null) {
            if (aBFaceFrame.getDetectInfo().i() > 0.0f) {
                aLFaceDetectResult.setFaceQuality(aBFaceFrame.getDetectInfo().i());
            } else if (aBFaceFrame.getDetectInfo().h() >= 0.0f) {
                aLFaceDetectResult.setFaceQuality(aBFaceFrame.getDetectInfo().h());
            }
            if (aBFaceFrame.getDetectInfo().g() >= 0.0f) {
                aLFaceDetectResult.setBrightness(aBFaceFrame.getDetectInfo().g());
            }
            if (aBFaceFrame.getDetectInfo().c() >= 0.0f) {
                aLFaceDetectResult.setGaussianBlur(aBFaceFrame.getDetectInfo().c());
            }
            aLFaceDetectResult.setImageWidth(aBFaceFrame.getImageWidth());
            aLFaceDetectResult.setImageHeight(aBFaceFrame.getImageHeight());
            aLFaceDetectResult.setPitchScore(aBFaceFrame.getDetectInfo().o());
            aLFaceDetectResult.setYawScore(aBFaceFrame.getDetectInfo().p());
            aLFaceDetectResult.setMouthScore(aBFaceFrame.getDetectInfo().q());
            aLFaceDetectResult.setBlinkScore(aBFaceFrame.getDetectInfo().r());
            aLFaceDetectResult.setLandmarkScore(aBFaceFrame.getDetectInfo().s());
            aLFaceDetectResult.setBrightDiff(aBFaceFrame.getDetectInfo().t());
            aLFaceDetectResult.setBackHighlight(aBFaceFrame.getDetectInfo().u());
            aLFaceDetectResult.setFaceSpeed(aBFaceFrame.getDetectInfo().v());
        }
        if (aBFaceFrame != null && aBFaceFrame.hasFace()) {
            aLFaceDetectResult.setFacesDetected(aBFaceFrame.facesDetected());
            if (aBFaceFrame.getFacePos() != null) {
                aLFaceDetectResult.setFacePosition(new RectF(aBFaceFrame.getFacePos()));
            }
            if (aBFaceFrame.getFaceSize() != null) {
                aLFaceDetectResult.setFaceSize(new Rect(aBFaceFrame.getFaceSize()));
            }
            aLFaceDetectResult.setCheckResult(aBFaceFrame.getDetectInfo().n());
            if (aBFaceFrame.getExts() != null && aBFaceFrame.getExts().containsKey(ALBiometricsKeys.KEY_RESULT)) {
                aLFaceDetectResult.setSuccess(aBFaceFrame.getExts().getBoolean(ALBiometricsKeys.KEY_RESULT, false));
                if (aLFaceDetectResult.isSuccess() && this.f2861e.e() != null && this.f2861e.e().size() > 0) {
                    aLFaceDetectResult.setBestImageData(this.f2861e.e().get(0).getImageData());
                }
            }
            if (aBFaceFrame.getExts() != null && aBFaceFrame.getExts().containsKey(ALBiometricsKeys.KEY_ERROR_CODE)) {
                aLFaceDetectResult.setErrors(aBFaceFrame.getExts().getIntArray(ALBiometricsKeys.KEY_ERROR_CODE));
            }
        }
        ABDetectContext.getInstance().getResult().setFaceResult(aLFaceDetectResult);
        this.f2858b.c(100);
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.build.y, com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final void b() {
        super.b();
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.FACE_DETECT);
    }

    private void a(ABFaceFrame aBFaceFrame) {
        ALFaceDetectResult aLFaceDetectResult = new ALFaceDetectResult();
        if (aBFaceFrame != null && aBFaceFrame.getDetectInfo() != null) {
            if (aBFaceFrame.getDetectInfo().i() > 0.0f) {
                aLFaceDetectResult.setFaceQuality(aBFaceFrame.getDetectInfo().i());
            } else if (aBFaceFrame.getDetectInfo().h() >= 0.0f) {
                aLFaceDetectResult.setFaceQuality(aBFaceFrame.getDetectInfo().h());
            }
            if (aBFaceFrame.getDetectInfo().g() >= 0.0f) {
                aLFaceDetectResult.setBrightness(aBFaceFrame.getDetectInfo().g());
            }
            if (aBFaceFrame.getDetectInfo().c() >= 0.0f) {
                aLFaceDetectResult.setGaussianBlur(aBFaceFrame.getDetectInfo().c());
            }
            aLFaceDetectResult.setImageWidth(aBFaceFrame.getImageWidth());
            aLFaceDetectResult.setImageHeight(aBFaceFrame.getImageHeight());
            aLFaceDetectResult.setPitchScore(aBFaceFrame.getDetectInfo().o());
            aLFaceDetectResult.setYawScore(aBFaceFrame.getDetectInfo().p());
            aLFaceDetectResult.setMouthScore(aBFaceFrame.getDetectInfo().q());
            aLFaceDetectResult.setBlinkScore(aBFaceFrame.getDetectInfo().r());
            aLFaceDetectResult.setLandmarkScore(aBFaceFrame.getDetectInfo().s());
            aLFaceDetectResult.setBrightDiff(aBFaceFrame.getDetectInfo().t());
            aLFaceDetectResult.setBackHighlight(aBFaceFrame.getDetectInfo().u());
            aLFaceDetectResult.setFaceSpeed(aBFaceFrame.getDetectInfo().v());
        }
        if (aBFaceFrame != null && aBFaceFrame.hasFace()) {
            aLFaceDetectResult.setFacesDetected(aBFaceFrame.facesDetected());
            if (aBFaceFrame.getFacePos() != null) {
                aLFaceDetectResult.setFacePosition(new RectF(aBFaceFrame.getFacePos()));
            }
            if (aBFaceFrame.getFaceSize() != null) {
                aLFaceDetectResult.setFaceSize(new Rect(aBFaceFrame.getFaceSize()));
            }
            aLFaceDetectResult.setCheckResult(aBFaceFrame.getDetectInfo().n());
            if (aBFaceFrame.getExts() != null && aBFaceFrame.getExts().containsKey(ALBiometricsKeys.KEY_RESULT)) {
                aLFaceDetectResult.setSuccess(aBFaceFrame.getExts().getBoolean(ALBiometricsKeys.KEY_RESULT, false));
                if (aLFaceDetectResult.isSuccess() && this.f2861e.e() != null && this.f2861e.e().size() > 0) {
                    aLFaceDetectResult.setBestImageData(this.f2861e.e().get(0).getImageData());
                }
            }
            if (aBFaceFrame.getExts() != null && aBFaceFrame.getExts().containsKey(ALBiometricsKeys.KEY_ERROR_CODE)) {
                aLFaceDetectResult.setErrors(aBFaceFrame.getExts().getIntArray(ALBiometricsKeys.KEY_ERROR_CODE));
            }
        }
        ABDetectContext.getInstance().getResult().setFaceResult(aLFaceDetectResult);
        this.f2858b.c(100);
    }
}
