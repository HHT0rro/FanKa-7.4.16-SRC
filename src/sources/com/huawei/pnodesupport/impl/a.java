package com.huawei.pnodesupport.impl;

import androidx.annotation.Nullable;
import com.huawei.pnodesupport.api.FLPNodeDelegate;
import com.huawei.pnodesupport.api.FLPNodeService;

/* compiled from: FLPNodeServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements FLPNodeService {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private FLPNodeDelegate f33075a;

    @Override // com.huawei.pnodesupport.api.FLPNodeService
    @Nullable
    public FLPNodeDelegate getDelegate() {
        return this.f33075a;
    }

    @Override // com.huawei.pnodesupport.api.FLPNodeService
    public void setDelegate(@Nullable FLPNodeDelegate fLPNodeDelegate) {
        this.f33075a = fLPNodeDelegate;
    }
}
