package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements com.tencent.cloud.huiyansdkface.a.c.d {

    /* renamed from: a, reason: collision with root package name */
    private Camera f40345a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.a f40346b;

    /* renamed from: c, reason: collision with root package name */
    private int f40347c;

    /* renamed from: d, reason: collision with root package name */
    private int f40348d;

    /* renamed from: e, reason: collision with root package name */
    private Camera.CameraInfo f40349e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.d f40350f;

    public a a(int i10) {
        this.f40347c = i10;
        return this;
    }

    public a a(Camera.CameraInfo cameraInfo) {
        this.f40349e = cameraInfo;
        return this;
    }

    public a a(Camera camera) {
        this.f40345a = camera;
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        this.f40346b = aVar;
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.d dVar) {
        this.f40350f = dVar;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.d
    public com.tencent.cloud.huiyansdkface.a.a.d b() {
        return this.f40350f;
    }

    public a b(int i10) {
        this.f40348d = i10;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Camera a() {
        return this.f40345a;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.a d() {
        return this.f40346b;
    }

    public int e() {
        return this.f40347c;
    }

    public int f() {
        return this.f40348d;
    }

    public String toString() {
        return "CameraV1{mCameraFacing=" + ((Object) this.f40346b) + ", mOrientation=" + this.f40347c + ", mCameraId=" + this.f40348d + '}';
    }
}
