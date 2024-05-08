package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzld extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzld> CREATOR = new k9();

    /* renamed from: b, reason: collision with root package name */
    public final int f25394b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25395c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25396d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25397e;

    /* renamed from: f, reason: collision with root package name */
    public final long f25398f;

    public zzld(int i10, int i11, int i12, int i13, long j10) {
        this.f25394b = i10;
        this.f25395c = i11;
        this.f25396d = i12;
        this.f25397e = i13;
        this.f25398f = j10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25394b);
        w6.a.j(parcel, 2, this.f25395c);
        w6.a.j(parcel, 3, this.f25396d);
        w6.a.j(parcel, 4, this.f25397e);
        w6.a.l(parcel, 5, this.f25398f);
        w6.a.b(parcel, a10);
    }
}
