package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import o7.b;
import w6.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zab extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zab> CREATOR = new b();

    /* renamed from: b, reason: collision with root package name */
    public final int f25810b;

    /* renamed from: c, reason: collision with root package name */
    public int f25811c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Intent f25812d;

    public zab(int i10, int i11, @Nullable Intent intent) {
        this.f25810b = i10;
        this.f25811c = i11;
        this.f25812d = intent;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.f25811c == 0) {
            return Status.f23378g;
        }
        return Status.f23382k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.f25810b);
        a.j(parcel, 2, this.f25811c);
        a.n(parcel, 3, this.f25812d, i10, false);
        a.b(parcel, a10);
    }

    public zab() {
        this(0, null);
    }

    public zab(int i10, @Nullable Intent intent) {
        this(2, 0, null);
    }
}
