package t6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        long j10 = 0;
        long j11 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z11);
            if (v2 == 1) {
                z10 = SafeParcelReader.w(parcel, z11);
            } else if (v2 == 2) {
                j11 = SafeParcelReader.C(parcel, z11);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z11);
            } else {
                j10 = SafeParcelReader.C(parcel, z11);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzc(z10, j10, j11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i10) {
        return new zzc[i10];
    }
}
