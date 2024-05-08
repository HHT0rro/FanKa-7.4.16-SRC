package com.huawei.hms.scankit.p;

/* compiled from: QRCodeDecoderMetaData.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class i6 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f31126a;

    public i6(boolean z10) {
        this.f31126a = z10;
    }

    public void a(u6[] u6VarArr) {
        if (!this.f31126a || u6VarArr == null || u6VarArr.length < 3) {
            return;
        }
        u6 u6Var = u6VarArr[0];
        u6VarArr[0] = u6VarArr[2];
        u6VarArr[2] = u6Var;
    }
}
