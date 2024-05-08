package com.huawei.flexiblelayout.data.changed;

import com.huawei.flexiblelayout.data.FLDataGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLRemovedDataRequest implements FLDataChangedRequest {

    /* renamed from: a, reason: collision with root package name */
    private final FLDataGroup f28103a;

    /* renamed from: b, reason: collision with root package name */
    private final int f28104b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28105c;

    public FLRemovedDataRequest(FLDataGroup fLDataGroup, int i10, int i11) {
        this.f28103a = fLDataGroup;
        this.f28104b = i10;
        this.f28105c = i11;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public int getAffectedCount() {
        return this.f28105c;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public FLDataGroup getGroup() {
        return this.f28103a;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public int getPosition() {
        return this.f28104b;
    }

    public FLRemovedDataRequest(FLDataGroup fLDataGroup, int i10) {
        this(fLDataGroup, i10, 1);
    }
}
