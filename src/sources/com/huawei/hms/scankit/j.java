package com.huawei.hms.scankit;

import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.o4;

/* compiled from: PreviewCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j implements j0.e {

    /* renamed from: a, reason: collision with root package name */
    private d f30673a;

    public j(d dVar) {
        this.f30673a = dVar;
    }

    @Override // com.huawei.hms.scankit.p.j0.e
    public void a(byte[] bArr) {
        o4.a("scan-time", "request frame time:" + System.currentTimeMillis());
        this.f30673a.a().obtainMessage(R.id.scankit_decode, bArr).sendToTarget();
    }
}
