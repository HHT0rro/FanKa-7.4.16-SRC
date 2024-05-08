package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zal;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Parcelable.Creator<SafeParcelResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        Parcel parcel2 = null;
        zal zalVar = null;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                parcel2 = SafeParcelReader.m(parcel, z10);
            } else if (v2 != 3) {
                SafeParcelReader.E(parcel, z10);
            } else {
                zalVar = (zal) SafeParcelReader.o(parcel, z10, zal.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new SafeParcelResponse(i10, parcel2, zalVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse[] newArray(int i10) {
        return new SafeParcelResponse[i10];
    }
}
