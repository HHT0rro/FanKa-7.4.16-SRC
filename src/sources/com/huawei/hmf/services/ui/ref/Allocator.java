package com.huawei.hmf.services.ui.ref;

import com.huawei.hmf.services.ui.internal.ReferenceTypeImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Allocator {
    public static final Allocator DEFAULT = new Allocator();

    public <T> ReferenceType<T> alloc(T t2) {
        return ReferenceTypeImpl.create(t2);
    }
}
