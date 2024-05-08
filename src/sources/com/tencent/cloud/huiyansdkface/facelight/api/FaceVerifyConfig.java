package com.tencent.cloud.huiyansdkface.facelight.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FaceVerifyConfig {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40563a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final FaceVerifyConfig f40564a = new FaceVerifyConfig();
    }

    private FaceVerifyConfig() {
        this.f40563a = false;
    }

    public static FaceVerifyConfig getInstance() {
        return a.f40564a;
    }

    public boolean displayInfoInUI() {
        return this.f40563a;
    }

    public void enableDisplayInfoInUI() {
        this.f40563a = true;
    }
}
