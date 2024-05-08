package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import java.util.ArrayList;

/* compiled from: ABDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class j {

    /* renamed from: t, reason: collision with root package name */
    public static final int f2771t = 1;

    /* renamed from: u, reason: collision with root package name */
    public static final int f2772u = 2;

    /* renamed from: v, reason: collision with root package name */
    public static final int f2773v = 3;

    /* renamed from: w, reason: collision with root package name */
    public s f2774w;

    public abstract String a();

    public abstract void a(int i10);

    public final void a(s sVar) {
        this.f2774w = sVar;
    }

    public abstract void a(ABDetectType aBDetectType, boolean z10);

    public abstract void a(boolean z10);

    public abstract boolean a(Context context, ALBiometricsParams aLBiometricsParams);

    public abstract boolean a(byte[] bArr, int i10, int i11, int i12);

    public abstract Bundle b(byte[] bArr, int i10, int i11, int i12);

    public abstract void b();

    public abstract boolean c();

    public abstract ABDetectType d();

    public abstract ArrayList<ABFaceFrame> e();

    public abstract Rect f();

    public abstract byte[] g();

    public abstract float[] h();

    public abstract byte[] i();

    public abstract byte[] j();

    public abstract byte[] k();

    public abstract float[] l();

    public abstract String m();
}
