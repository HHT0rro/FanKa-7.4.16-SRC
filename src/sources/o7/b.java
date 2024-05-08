package o7;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.signin.internal.zab;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Parcelable.Creator<zab> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zab createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        int i10 = 0;
        Intent intent = null;
        int i11 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                i11 = SafeParcelReader.B(parcel, z10);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z10);
            } else {
                intent = (Intent) SafeParcelReader.o(parcel, z10, Intent.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zab(i10, i11, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zab[] newArray(int i10) {
        return new zab[i10];
    }
}
