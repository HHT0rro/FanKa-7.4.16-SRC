package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Feature extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<Feature> CREATOR = new g();

    /* renamed from: b, reason: collision with root package name */
    public final String f23358b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public final int f23359c;

    /* renamed from: d, reason: collision with root package name */
    public final long f23360d;

    public Feature(@RecentlyNonNull String str, @RecentlyNonNull int i10, @RecentlyNonNull long j10) {
        this.f23358b = str;
        this.f23359c = i10;
        this.f23360d = j10;
    }

    @RecentlyNonNull
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((f() != null && f().equals(feature.f())) || (f() == null && feature.f() == null)) && g() == feature.g()) {
                return true;
            }
        }
        return false;
    }

    @RecentlyNonNull
    public String f() {
        return this.f23358b;
    }

    @RecentlyNonNull
    public long g() {
        long j10 = this.f23360d;
        return j10 == -1 ? this.f23359c : j10;
    }

    @RecentlyNonNull
    public int hashCode() {
        return com.google.android.gms.common.internal.g.b(f(), Long.valueOf(g()));
    }

    @RecentlyNonNull
    public String toString() {
        return com.google.android.gms.common.internal.g.c(this).a("name", f()).a("version", Long.valueOf(g())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.o(parcel, 1, f(), false);
        w6.a.j(parcel, 2, this.f23359c);
        w6.a.l(parcel, 3, g());
        w6.a.b(parcel, a10);
    }
}
