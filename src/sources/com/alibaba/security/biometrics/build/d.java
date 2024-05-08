package com.alibaba.security.biometrics.build;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener;

/* compiled from: ICameraAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface d {

    /* compiled from: ICameraAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();

        void a(int i10, String str);

        void a(byte[] bArr, int i10, int i11, int i12);
    }

    void a(SurfaceTexture surfaceTexture);

    void a(a aVar);

    void a(OnCameraVideoReorderListener onCameraVideoReorderListener, boolean z10);

    void d();

    String f();

    Point g();

    byte[] h();

    int i();

    boolean j();

    void k();

    String l();

    String m();
}
