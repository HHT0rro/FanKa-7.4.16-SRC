package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new y6.a();

    /* renamed from: b, reason: collision with root package name */
    public final int f23728b;

    /* renamed from: c, reason: collision with root package name */
    public final StringToIntConverter f23729c;

    public zaa(int i10, StringToIntConverter stringToIntConverter) {
        this.f23728b = i10;
        this.f23729c = stringToIntConverter;
    }

    public static zaa f(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a<?, ?> g() {
        StringToIntConverter stringToIntConverter = this.f23729c;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23728b);
        w6.a.n(parcel, 2, this.f23729c, i10, false);
        w6.a.b(parcel, a10);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f23728b = 1;
        this.f23729c = stringToIntConverter;
    }
}
