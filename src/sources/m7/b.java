package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.phenotype.Configuration;
import com.google.android.gms.phenotype.zzi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Parcelable.Creator<Configuration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Configuration createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        zzi[] zziVarArr = null;
        String[] strArr = null;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 2) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 3) {
                zziVarArr = (zzi[]) SafeParcelReader.s(parcel, z10, zzi.CREATOR);
            } else if (v2 != 4) {
                SafeParcelReader.E(parcel, z10);
            } else {
                strArr = SafeParcelReader.q(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Configuration(i10, zziVarArr, strArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Configuration[] newArray(int i10) {
        return new Configuration[i10];
    }
}
