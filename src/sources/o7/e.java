package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.internal.zam;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements Parcelable.Creator<zam> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        ConnectionResult connectionResult = null;
        zas zasVar = null;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.o(parcel, z10, ConnectionResult.CREATOR);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z10);
            } else {
                zasVar = (zas) SafeParcelReader.o(parcel, z10, zas.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zam(i10, connectionResult, zasVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam[] newArray(int i10) {
        return new zam[i10];
    }
}
