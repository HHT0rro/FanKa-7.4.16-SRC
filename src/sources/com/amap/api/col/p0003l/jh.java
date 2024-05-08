package com.amap.api.col.p0003l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: AbstractBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class jh {

    /* renamed from: a, reason: collision with root package name */
    public jj f6561a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f6562b;

    public jh(int i10) {
        ByteBuffer allocate = ByteBuffer.allocate(i10);
        this.f6562b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f6561a = new jj(this.f6562b);
    }

    public final jh a() {
        this.f6561a.a(this.f6562b);
        return this;
    }
}
