package com.tencent.liteav.videobase.videobase;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f43558a;

    /* renamed from: b, reason: collision with root package name */
    public final int f43559b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final Rotation f43560c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f43561d;

    public a() {
        this(0, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.f43558a == this.f43558a && aVar.f43559b == this.f43559b && aVar.f43560c == this.f43560c && aVar.f43561d == this.f43561d;
    }

    public final int hashCode() {
        return (((this.f43558a * 32713) + this.f43559b) << 4) + (this.f43560c.ordinal() << 1) + (this.f43561d ? 1 : 0);
    }

    public a(int i10, int i11) {
        this(i10, i11, Rotation.NORMAL);
    }

    public a(int i10, int i11, Rotation rotation) {
        this.f43558a = i10;
        this.f43559b = i11;
        this.f43560c = rotation == null ? Rotation.NORMAL : rotation;
        this.f43561d = false;
    }
}
