package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u6.e;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new e();

    /* renamed from: b, reason: collision with root package name */
    public final int f23376b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23377c;

    public Scope(int i10, String str) {
        h.f(str, "scopeUri must not be null or empty");
        this.f23376b = i10;
        this.f23377c = str;
    }

    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f23377c.equals(((Scope) obj).f23377c);
        }
        return false;
    }

    @RecentlyNonNull
    public final String f() {
        return this.f23377c;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.f23377c.hashCode();
    }

    @RecentlyNonNull
    public final String toString() {
        return this.f23377c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23376b);
        w6.a.o(parcel, 2, f(), false);
        w6.a.b(parcel, a10);
    }

    public Scope(@RecentlyNonNull String str) {
        this(1, str);
    }
}
