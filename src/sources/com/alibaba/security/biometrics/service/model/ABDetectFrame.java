package com.alibaba.security.biometrics.service.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.alibaba.security.biometrics.jni.ABJniDetectResult;
import com.alibaba.security.biometrics.jni.ABJniDetectType;
import com.alibaba.security.biometrics.service.build.m;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ABDetectFrame extends ABFaceFrame {
    private static final String TAG = "ABDetectFrame";
    public int imageAngle;
    public byte[] imageData;
    public int imageHeight;
    public int imageWidth;
    private final float iso;
    public ABJniDetectResult jniDetectResult;
    private int msgCode;

    public ABDetectFrame(ABJniDetectResult aBJniDetectResult, byte[] bArr, int i10, int i11, int i12) {
        int i13;
        int i14;
        this.jniDetectResult = aBJniDetectResult;
        this.imageData = bArr;
        this.imageWidth = i10;
        this.imageHeight = i11;
        this.imageAngle = i12;
        this.iso = aBJniDetectResult.iso;
        if (i12 == 90 || i12 == 270) {
            i13 = i10;
            i14 = i11;
        } else {
            i14 = i10;
            i13 = i11;
        }
        setDetectInfo(new m());
        this.detectInfo.a(aBJniDetectResult.faceRectSmooth);
        RectF rectF = new RectF();
        if (i14 > 1 && i13 > 1) {
            float f10 = i14;
            rectF.left = r0.left / f10;
            rectF.right = r0.right / f10;
            float f11 = i13;
            rectF.top = r0.top / f11;
            rectF.bottom = r0.bottom / f11;
        }
        this.detectInfo.a(rectF);
        Rect rect = new Rect();
        float[] fArr = aBJniDetectResult.faceKeyPoint;
        rect.left = (int) fArr[8];
        rect.right = (int) fArr[12];
        rect.top = (int) fArr[11];
        rect.bottom = (int) fArr[15];
        int max = Math.max(rect.width(), rect.height()) / 8;
        rect.left = Math.max(0, rect.left - max);
        rect.right = Math.min(i10, rect.right + max);
        rect.top = Math.max(0, rect.top - max);
        rect.bottom = Math.min(i11, rect.bottom + max);
        this.detectInfo.b(rect);
        Rect rect2 = new Rect();
        float[] fArr2 = aBJniDetectResult.faceKeyPoint;
        rect2.left = (int) fArr2[16];
        rect2.right = (int) fArr2[20];
        rect2.top = (int) fArr2[19];
        rect2.bottom = (int) fArr2[23];
        int max2 = Math.max(rect2.width(), rect2.height()) / 8;
        rect2.left = Math.max(0, rect2.left - max2);
        rect2.right = Math.min(i10, rect2.right + max2);
        rect2.top = Math.max(0, rect2.top - max2);
        rect2.bottom = Math.min(i11, rect2.bottom + max2);
        this.detectInfo.c(rect2);
        this.detectInfo.a(aBJniDetectResult.brightness);
        this.detectInfo.b(aBJniDetectResult.quality);
        this.detectInfo.c(aBJniDetectResult.staticQuality);
        this.detectInfo.a(aBJniDetectResult.promptMessage().getValue());
        this.detectInfo.k();
        this.detectInfo.d(aBJniDetectResult.pitchScore);
        this.detectInfo.e(aBJniDetectResult.yawScore);
        this.detectInfo.f(aBJniDetectResult.mouthScore);
        this.detectInfo.g(aBJniDetectResult.blinkScore);
        this.detectInfo.h(aBJniDetectResult.landmarkScore);
        this.detectInfo.i(aBJniDetectResult.brightDiff);
        this.detectInfo.k(aBJniDetectResult.backHightlight);
        this.detectInfo.j(aBJniDetectResult.faceSpeed);
        this.detectInfo.d(aBJniDetectResult.f2423ec);
        this.detectInfo.e(aBJniDetectResult.ecpc);
        this.detectInfo.f(aBJniDetectResult.etcc);
        this.detectInfo.a(aBJniDetectResult.ecResult);
        this.detectInfo.a(aBJniDetectResult.faceKeyPoint);
        this.detectInfo.l(aBJniDetectResult.gestureProgress);
        this.detectInfo.b(0);
        if (this.detectInfo.x() > 0.0f && this.detectInfo.x() <= 0.5d) {
            this.detectInfo.b(1);
        } else if (this.detectInfo.x() > 0.5d && this.detectInfo.x() < 1.0f) {
            this.detectInfo.b(2);
        } else if (this.detectInfo.x() >= 1.0f) {
            this.detectInfo.b(3);
        }
        this.detectInfo.c(-1);
        if (aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_YAW && aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_YAW_STILL) {
            if (aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_PITCH && aBJniDetectResult.detectType() != ABJniDetectType.DETECT_TYPE_PITCH_STILL) {
                if (aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_MOUTH || aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_MOUTH_STILL || aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_BLINK || aBJniDetectResult.detectType() == ABJniDetectType.DETECT_TYPE_BLINK_STILL) {
                    this.detectInfo.c(m.f2784b);
                }
            } else {
                float f12 = aBJniDetectResult.pitchScore;
                if (f12 > 0.0f) {
                    this.detectInfo.c(m.f2784b);
                } else if (f12 < 0.0f) {
                    this.detectInfo.c(m.f2784b);
                } else if (f12 == 0.0f) {
                    this.detectInfo.c(m.f2788f);
                }
            }
        } else {
            float f13 = aBJniDetectResult.yawScore;
            if (f13 > 0.0f) {
                this.detectInfo.c(m.f2785c);
            } else if (f13 < 0.0f) {
                this.detectInfo.c(m.f2783a);
            } else if (f13 == 0.0f) {
                this.detectInfo.c(m.f2788f);
            }
        }
        if (aBJniDetectResult.reflectCmd == 1) {
            m mVar = this.detectInfo;
            mVar.Y = aBJniDetectResult.reflectResult;
            mVar.W = aBJniDetectResult.reflectFrames;
            mVar.X = aBJniDetectResult.reflectScore;
            mVar.Z = aBJniDetectResult.reflectBrightnessResult;
            mVar.f2790ab = aBJniDetectResult.reflectBrightnessScore;
            mVar.f2789aa = aBJniDetectResult.reflectBrightnessFrames;
            mVar.f2792ad = aBJniDetectResult.reflectEyeResult;
            mVar.f2793ae = aBJniDetectResult.reflectLeftEyeResult;
            mVar.af = aBJniDetectResult.reflectRightEyeResult;
            mVar.ag = aBJniDetectResult.reflectEyeFrames;
            mVar.ah = aBJniDetectResult.reflectEyeValidFrames;
            mVar.ai = aBJniDetectResult.brightnessHistory;
            mVar.aj = aBJniDetectResult.brightnessScores;
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int facesDetected() {
        ABJniDetectResult aBJniDetectResult = this.jniDetectResult;
        return (aBJniDetectResult == null || !aBJniDetectResult.faceExist) ? 0 : 1;
    }

    public ABJniDetectResult getDetectResult() {
        return this.jniDetectResult;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public RectF getFacePos() {
        if (getDetectInfo() == null) {
            return null;
        }
        return getDetectInfo().b();
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public float getFaceQuality() {
        return this.detectInfo.h();
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageAngle() {
        return this.imageAngle;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public byte[] getImageData() {
        return this.imageData;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageHeight() {
        return this.imageHeight;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public int getImageWidth() {
        return this.imageWidth;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public float getIso() {
        return this.iso;
    }

    public int getMsgCode() {
        return this.msgCode;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public boolean hasFace() {
        if (this.msgCode == 1002) {
            return false;
        }
        return super.hasFace();
    }

    public void setDetectResult(ABJniDetectResult aBJniDetectResult) {
        this.jniDetectResult = aBJniDetectResult;
    }

    public void setMsgCode(int i10) {
        this.msgCode = i10;
    }
}
