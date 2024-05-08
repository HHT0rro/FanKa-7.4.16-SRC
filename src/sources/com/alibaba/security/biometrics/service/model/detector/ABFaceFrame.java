package com.alibaba.security.biometrics.service.model.detector;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import com.alibaba.security.biometrics.service.build.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ABFaceFrame {
    public m detectInfo;
    public Bundle exts;

    public static PointF get2DPoint(float f10, float f11, float f12, float f13, float f14, float f15) {
        PointF pointF = new PointF();
        pointF.x = ((f15 < 0.0f ? f15 / f12 : (-f15) / f13) * 0.5f) + 0.5f;
        pointF.y = ((f14 < 0.0f ? (-f14) / f10 : f14 / f11) * 0.5f) + 0.5f;
        return pointF;
    }

    public static boolean isValid2DPoint(PointF pointF) {
        float f10 = pointF.x;
        if (f10 < 0.0f || f10 > 1.0f) {
            return false;
        }
        float f11 = pointF.y;
        return f11 >= 0.0f && f11 <= 1.0f;
    }

    public abstract int facesDetected();

    public m getDetectInfo() {
        return this.detectInfo;
    }

    public Bundle getExts() {
        return this.exts;
    }

    public abstract RectF getFacePos();

    public abstract float getFaceQuality();

    public Rect getFaceSize() {
        return getDetectInfo().a();
    }

    public abstract int getImageAngle();

    public abstract byte[] getImageData();

    public abstract int getImageHeight();

    public abstract int getImageWidth();

    public abstract float getIso();

    public boolean hasFace() {
        return facesDetected() > 0 && getDetectInfo() != null;
    }

    public void setDetectInfo(m mVar) {
        this.detectInfo = mVar;
    }

    public void setExts(Bundle bundle) {
        this.exts = bundle;
    }

    public PointF get2DPoint(float f10, float f11, float f12, float f13) {
        if (facesDetected() <= 0) {
            return null;
        }
        return get2DPoint(f10, f11, f12, f13, this.detectInfo.m(), this.detectInfo.l());
    }

    public PointF get2DPoint() {
        return get2DPoint(-0.17f, 0.17f, -0.22f, 0.22f);
    }
}
