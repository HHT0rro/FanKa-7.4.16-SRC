package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new q9();

    /* renamed from: b, reason: collision with root package name */
    public int f25424b;

    /* renamed from: c, reason: collision with root package name */
    public int f25425c;

    /* renamed from: d, reason: collision with root package name */
    public int f25426d;

    /* renamed from: e, reason: collision with root package name */
    public long f25427e;

    /* renamed from: f, reason: collision with root package name */
    public int f25428f;

    public zzp() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 2, this.f25424b);
        w6.a.j(parcel, 3, this.f25425c);
        w6.a.j(parcel, 4, this.f25426d);
        w6.a.l(parcel, 5, this.f25427e);
        w6.a.j(parcel, 6, this.f25428f);
        w6.a.b(parcel, a10);
    }

    public zzp(int i10, int i11, int i12, long j10, int i13) {
        this.f25424b = i10;
        this.f25425c = i11;
        this.f25426d = i12;
        this.f25427e = j10;
        this.f25428f = i13;
    }
}
