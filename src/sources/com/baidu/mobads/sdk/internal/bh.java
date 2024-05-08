package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bh implements aa.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ bg f9888c;

    public bh(bg bgVar) {
        this.f9888c = bgVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.f9888c.f9879i.a(bg.f9872b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f9888c.j();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.f9888c.f9879i.a(bg.f9872b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f9888c.i();
    }
}
