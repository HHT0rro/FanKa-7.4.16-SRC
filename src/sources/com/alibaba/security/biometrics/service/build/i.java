package com.alibaba.security.biometrics.service.build;

import android.graphics.RectF;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;

/* compiled from: ABResultFrame.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class i extends ABFaceFrame {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2765a;

    /* renamed from: b, reason: collision with root package name */
    public int f2766b;

    /* renamed from: c, reason: collision with root package name */
    public int f2767c;

    /* renamed from: d, reason: collision with root package name */
    public int f2768d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f2769e = 1;

    /* renamed from: f, reason: collision with root package name */
    public float f2770f;

    public i(byte[] bArr, int i10, int i11, float f10) {
        this.f2765a = bArr;
        this.f2766b = i10;
        this.f2767c = i11;
        this.f2770f = f10;
        m mVar = new m();
        this.detectInfo = mVar;
        mVar.b(-1.0f);
        this.detectInfo.c(-1.0f);
        this.detectInfo.a(-1.0f);
        this.detectInfo.d();
        this.detectInfo.f();
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final int facesDetected() {
        return this.f2769e;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final RectF getFacePos() {
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final float getFaceQuality() {
        return -1.0f;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final int getImageAngle() {
        return this.f2768d;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final byte[] getImageData() {
        return this.f2765a;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final int getImageHeight() {
        return this.f2767c;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final int getImageWidth() {
        return this.f2766b;
    }

    @Override // com.alibaba.security.biometrics.service.model.detector.ABFaceFrame
    public final float getIso() {
        return this.f2770f;
    }

    public final String toString() {
        return "ResultFaceFrame{imageWidth=" + this.f2766b + ", imageHeight=" + this.f2767c + ", imageAngle=" + this.f2768d + ", faceDetected=" + this.f2769e + ", detectInfo=" + ((Object) this.detectInfo) + '}';
    }
}
