package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ClientIdentity extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new i();

    /* renamed from: b, reason: collision with root package name */
    public final int f23605b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f23606c;

    public ClientIdentity(@RecentlyNonNull int i10, @Nullable String str) {
        this.f23605b = i10;
        this.f23606c = str;
    }

    @RecentlyNonNull
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f23605b == this.f23605b && g.a(clientIdentity.f23606c, this.f23606c);
    }

    @RecentlyNonNull
    public int hashCode() {
        return this.f23605b;
    }

    @RecentlyNonNull
    public String toString() {
        int i10 = this.f23605b;
        String str = this.f23606c;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12);
        sb2.append(i10);
        sb2.append(com.huawei.openalliance.ad.constant.u.bD);
        sb2.append(str);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23605b);
        w6.a.o(parcel, 2, this.f23606c, false);
        w6.a.b(parcel, a10);
    }
}
