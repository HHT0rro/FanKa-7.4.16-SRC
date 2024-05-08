package com.huawei.flexiblelayout.data.changed;

import com.huawei.flexiblelayout.data.FLDataGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLAddedDataRequest implements FLDataChangedRequest {

    /* renamed from: a, reason: collision with root package name */
    private final FLDataGroup f28096a;

    /* renamed from: b, reason: collision with root package name */
    private final int f28097b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28098c;

    public FLAddedDataRequest(FLDataGroup fLDataGroup, int i10, int i11) {
        this.f28096a = fLDataGroup;
        this.f28097b = i10;
        this.f28098c = i11;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public int getAffectedCount() {
        return this.f28098c;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public FLDataGroup getGroup() {
        return this.f28096a;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public int getPosition() {
        return this.f28097b;
    }

    public FLAddedDataRequest(FLDataGroup fLDataGroup, int i10) {
        this(fLDataGroup, i10, 1);
    }
}
