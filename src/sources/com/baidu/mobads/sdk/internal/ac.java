package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.by;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ac implements by.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aa f9753a;

    public ac(aa aaVar) {
        this.f9753a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.by.c
    public void a(boolean z10) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z10) {
            try {
                by byVar = g.f10244a;
                if (byVar != null) {
                    this.f9753a.f9741b = byVar.i();
                    iXAdContainerFactory = this.f9753a.f9741b;
                    if (iXAdContainerFactory != null) {
                        this.f9753a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f9753a.a("加载dex异常");
                return;
            }
        }
        g.f10244a = null;
        this.f9753a.a("加载dex失败");
    }
}
