package com.huawei.flexiblelayout.data.changed;

import com.huawei.flexiblelayout.data.FLDataGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLModifyDataRequest implements FLDataChangedRequest {

    /* renamed from: a, reason: collision with root package name */
    private final FLDataGroup f28099a;

    /* renamed from: b, reason: collision with root package name */
    private final int f28100b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28101c;

    /* renamed from: d, reason: collision with root package name */
    private Object f28102d;

    public FLModifyDataRequest(FLDataGroup fLDataGroup, int i10, int i11) {
        this.f28099a = fLDataGroup;
        this.f28100b = i10;
        this.f28101c = i11;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public int getAffectedCount() {
        return this.f28101c;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public FLDataGroup getGroup() {
        return this.f28099a;
    }

    public Object getPayload() {
        return this.f28102d;
    }

    @Override // com.huawei.flexiblelayout.data.changed.FLDataChangedRequest
    public int getPosition() {
        return this.f28100b;
    }

    public void setPayload(Object obj) {
        this.f28102d = obj;
    }

    public FLModifyDataRequest(FLDataGroup fLDataGroup, int i10) {
        this(fLDataGroup, i10, 1);
    }
}
