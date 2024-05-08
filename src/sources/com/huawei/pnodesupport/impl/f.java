package com.huawei.pnodesupport.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import java.util.Objects;

/* compiled from: PageItem.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f33083a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final FLCell<FLCardData> f33084b;

    public f(int i10, @NonNull FLCell<FLCardData> fLCell) {
        this.f33083a = i10;
        this.f33084b = fLCell;
    }

    public void a(int i10) {
        this.f33083a = i10;
    }

    public int b() {
        return this.f33083a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f33083a == fVar.f33083a && this.f33084b.equals(fVar.f33084b);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f33083a), this.f33084b);
    }

    @NonNull
    public FLCell<FLCardData> a() {
        return this.f33084b;
    }
}
