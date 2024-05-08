package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import com.huawei.hms.scankit.p.j0;

/* compiled from: PreviewCallbackProxy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f6 implements Camera.PreviewCallback {

    /* renamed from: a, reason: collision with root package name */
    private j0.e f30980a;

    public f6(j0.e eVar) {
        this.f30980a = eVar;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.f30980a.a(bArr);
    }
}
