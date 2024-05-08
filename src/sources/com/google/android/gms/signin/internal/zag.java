package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import o7.c;
import w6.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new c();

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f25813b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f25814c;

    public zag(List<String> list, @Nullable String str) {
        this.f25813b = list;
        this.f25814c = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.f25814c != null) {
            return Status.f23378g;
        }
        return Status.f23382k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.q(parcel, 1, this.f25813b, false);
        a.o(parcel, 2, this.f25814c, false);
        a.b(parcel, a10);
    }
}
