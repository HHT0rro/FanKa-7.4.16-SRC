package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new j();

    /* renamed from: b, reason: collision with root package name */
    public final String f23758b;

    /* renamed from: c, reason: collision with root package name */
    public final zzd f23759c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23760d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f23761e;

    public zzj(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f23758b = str;
        this.f23759c = f(iBinder);
        this.f23760d = z10;
        this.f23761e = z11;
    }

    public static zzd f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzb = zzo.zza(iBinder).zzb();
            byte[] bArr = zzb == null ? null : (byte[]) ObjectWrapper.unwrap(zzb);
            if (bArr != null) {
                return new zzg(bArr);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.o(parcel, 1, this.f23758b, false);
        zzd zzdVar = this.f23759c;
        w6.a.i(parcel, 2, zzdVar == null ? null : zzdVar.asBinder(), false);
        w6.a.c(parcel, 3, this.f23760d);
        w6.a.c(parcel, 4, this.f23761e);
        w6.a.b(parcel, a10);
    }
}
