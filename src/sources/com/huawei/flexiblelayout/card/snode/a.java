package com.huawei.flexiblelayout.card.snode;

/* compiled from: FLSNodeServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements FLSNodeService {

    /* renamed from: a, reason: collision with root package name */
    private FLSNodeDelegate f27902a;

    @Override // com.huawei.flexiblelayout.card.snode.FLSNodeService
    public FLSNodeDelegate getDelegate() {
        return this.f27902a;
    }

    @Override // com.huawei.flexiblelayout.card.snode.FLSNodeService
    public void registerViewDelegate(FLSNodeDelegate fLSNodeDelegate) {
        this.f27902a = fLSNodeDelegate;
    }
}
