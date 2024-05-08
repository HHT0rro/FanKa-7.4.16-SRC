package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzlf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlf> CREATOR = new l9();

    /* renamed from: b, reason: collision with root package name */
    public final int f25399b;

    /* renamed from: c, reason: collision with root package name */
    public final List<PointF> f25400c;

    public zzlf(int i10, List<PointF> list) {
        this.f25399b = i10;
        this.f25400c = list;
    }

    public final List<PointF> f() {
        return this.f25400c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f25399b);
        w6.a.s(parcel, 2, this.f25400c, false);
        w6.a.b(parcel, a10);
    }

    public final int zza() {
        return this.f25399b;
    }
}
