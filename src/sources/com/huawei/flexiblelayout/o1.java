package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.services.safearea.SafeAreaDelegate;
import com.huawei.flexiblelayout.services.safearea.SafeAreaService;

/* compiled from: SafeAreaServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class o1 implements SafeAreaService {

    /* renamed from: a, reason: collision with root package name */
    private SafeAreaDelegate f28277a;

    @Override // com.huawei.flexiblelayout.services.safearea.SafeAreaService
    public SafeAreaDelegate getDelegate() {
        return this.f28277a;
    }

    @Override // com.huawei.flexiblelayout.services.safearea.SafeAreaService
    public void registerDelegate(SafeAreaDelegate safeAreaDelegate) {
        this.f28277a = safeAreaDelegate;
    }
}
