package com.alipay.sdk.app;

import com.alipay.sdk.util.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PayTask f4410a;

    public h(PayTask payTask) {
        this.f4410a = payTask;
    }

    @Override // com.alipay.sdk.util.e.a
    public void a() {
    }

    @Override // com.alipay.sdk.util.e.a
    public void b() {
        this.f4410a.dismissLoading();
    }
}
