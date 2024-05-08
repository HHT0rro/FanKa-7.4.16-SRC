package com.alipay.sdk.app;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4406a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4407b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ H5PayCallback f4408c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PayTask f4409d;

    public g(PayTask payTask, String str, boolean z10, H5PayCallback h5PayCallback) {
        this.f4409d = payTask;
        this.f4406a = str;
        this.f4407b = z10;
        this.f4408c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4408c.onPayResult(this.f4409d.h5Pay(this.f4406a, this.f4407b));
    }
}
