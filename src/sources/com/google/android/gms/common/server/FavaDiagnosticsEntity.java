package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import x6.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f23718b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23719c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23720d;

    public FavaDiagnosticsEntity(@RecentlyNonNull int i10, @RecentlyNonNull String str, @RecentlyNonNull int i11) {
        this.f23718b = i10;
        this.f23719c = str;
        this.f23720d = i11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23718b);
        w6.a.o(parcel, 2, this.f23719c, false);
        w6.a.j(parcel, 3, this.f23720d);
        w6.a.b(parcel, a10);
    }
}
