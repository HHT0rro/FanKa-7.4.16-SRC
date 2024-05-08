package com.huawei.appgallery.agd.common.gcd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class DispatchMainQueue {

    /* renamed from: a, reason: collision with root package name */
    public DispatchMainItem f27342a;

    public void async(DispatchBlock dispatchBlock) {
        if (this.f27342a == null) {
            this.f27342a = new DispatchMainItem();
        }
        this.f27342a.excute(dispatchBlock);
    }
}
