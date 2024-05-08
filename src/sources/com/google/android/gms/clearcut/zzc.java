package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import t6.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new c();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f23342b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23343c;

    /* renamed from: d, reason: collision with root package name */
    public final long f23344d;

    public zzc(boolean z10, long j10, long j11) {
        this.f23342b = z10;
        this.f23343c = j10;
        this.f23344d = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzcVar = (zzc) obj;
            if (this.f23342b == zzcVar.f23342b && this.f23343c == zzcVar.f23343c && this.f23344d == zzcVar.f23344d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return g.b(Boolean.valueOf(this.f23342b), Long.valueOf(this.f23343c), Long.valueOf(this.f23344d));
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.f23342b + ",collectForDebugStartTimeMillis: " + this.f23343c + ",collectForDebugExpiryTimeMillis: " + this.f23344d + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.c(parcel, 1, this.f23342b);
        w6.a.l(parcel, 2, this.f23344d);
        w6.a.l(parcel, 3, this.f23343c);
        w6.a.b(parcel, a10);
    }
}
