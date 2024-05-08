package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new g5();

    /* renamed from: b, reason: collision with root package name */
    public final String f24150b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24151c;

    /* renamed from: d, reason: collision with root package name */
    public final int f24152d;

    /* renamed from: e, reason: collision with root package name */
    public final String f24153e;

    /* renamed from: f, reason: collision with root package name */
    public final String f24154f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f24155g;

    /* renamed from: h, reason: collision with root package name */
    public final String f24156h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f24157i;

    /* renamed from: j, reason: collision with root package name */
    public final int f24158j;

    public zzr(String str, int i10, int i11, String str2, String str3, String str4, boolean z10, zzge$zzv$zzb zzge_zzv_zzb) {
        this.f24150b = (String) com.google.android.gms.common.internal.h.h(str);
        this.f24151c = i10;
        this.f24152d = i11;
        this.f24156h = str2;
        this.f24153e = str3;
        this.f24154f = str4;
        this.f24155g = !z10;
        this.f24157i = z10;
        this.f24158j = zzge_zzv_zzb.zzc();
    }

    public zzr(String str, int i10, int i11, String str2, String str3, boolean z10, String str4, boolean z11, int i12) {
        this.f24150b = str;
        this.f24151c = i10;
        this.f24152d = i11;
        this.f24153e = str2;
        this.f24154f = str3;
        this.f24155g = z10;
        this.f24156h = str4;
        this.f24157i = z11;
        this.f24158j = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzr) {
            zzr zzrVar = (zzr) obj;
            if (com.google.android.gms.common.internal.g.a(this.f24150b, zzrVar.f24150b) && this.f24151c == zzrVar.f24151c && this.f24152d == zzrVar.f24152d && com.google.android.gms.common.internal.g.a(this.f24156h, zzrVar.f24156h) && com.google.android.gms.common.internal.g.a(this.f24153e, zzrVar.f24153e) && com.google.android.gms.common.internal.g.a(this.f24154f, zzrVar.f24154f) && this.f24155g == zzrVar.f24155g && this.f24157i == zzrVar.f24157i && this.f24158j == zzrVar.f24158j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.g.b(this.f24150b, Integer.valueOf(this.f24151c), Integer.valueOf(this.f24152d), this.f24156h, this.f24153e, this.f24154f, Boolean.valueOf(this.f24155g), Boolean.valueOf(this.f24157i), Integer.valueOf(this.f24158j));
    }

    public final String toString() {
        return "PlayLoggerContext[package=" + this.f24150b + ",packageVersionCode=" + this.f24151c + ",logSource=" + this.f24152d + ",logSourceName=" + this.f24156h + ",uploadAccount=" + this.f24153e + ",loggingId=" + this.f24154f + ",logAndroidId=" + this.f24155g + ",isAnonymous=" + this.f24157i + ",qosTier=" + this.f24158j + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.o(parcel, 2, this.f24150b, false);
        w6.a.j(parcel, 3, this.f24151c);
        w6.a.j(parcel, 4, this.f24152d);
        w6.a.o(parcel, 5, this.f24153e, false);
        w6.a.o(parcel, 6, this.f24154f, false);
        w6.a.c(parcel, 7, this.f24155g);
        w6.a.o(parcel, 8, this.f24156h, false);
        w6.a.c(parcel, 9, this.f24157i);
        w6.a.j(parcel, 10, this.f24158j);
        w6.a.b(parcel, a10);
    }
}
