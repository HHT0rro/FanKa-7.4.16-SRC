package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzam> CREATOR = new e();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f25734b;

    public zzam(@Nullable String str) {
        this.f25734b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.o(parcel, 2, this.f25734b, false);
        w6.a.b(parcel, a10);
    }

    public zzam() {
        this(null);
    }
}
