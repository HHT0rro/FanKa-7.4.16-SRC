package com.huawei.pnodesupport.impl;

import java.util.Objects;

/* compiled from: PNodeConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f33076a;

    public int a() {
        return this.f33076a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f33076a == ((b) obj).f33076a;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f33076a));
    }

    public void a(int i10) {
        this.f33076a = i10;
    }
}
