package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f23755b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23756c;

    /* renamed from: d, reason: collision with root package name */
    public final FastJsonResponse.Field<?, ?> f23757d;

    public zan(int i10, String str, FastJsonResponse.Field<?, ?> field) {
        this.f23755b = i10;
        this.f23756c = str;
        this.f23757d = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23755b);
        w6.a.o(parcel, 2, this.f23756c, false);
        w6.a.n(parcel, 3, this.f23757d, i10, false);
        w6.a.b(parcel, a10);
    }

    public zan(String str, FastJsonResponse.Field<?, ?> field) {
        this.f23755b = 1;
        this.f23756c = str;
        this.f23757d = field;
    }
}
