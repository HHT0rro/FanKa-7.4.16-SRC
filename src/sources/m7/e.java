package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.phenotype.zzi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        long j10 = 0;
        double d10 = 0.0d;
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 2:
                    str = SafeParcelReader.p(parcel, z11);
                    break;
                case 3:
                    j10 = SafeParcelReader.C(parcel, z11);
                    break;
                case 4:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
                case 5:
                    d10 = SafeParcelReader.x(parcel, z11);
                    break;
                case 6:
                    str2 = SafeParcelReader.p(parcel, z11);
                    break;
                case 7:
                    bArr = SafeParcelReader.g(parcel, z11);
                    break;
                case 8:
                    i10 = SafeParcelReader.B(parcel, z11);
                    break;
                case 9:
                    i11 = SafeParcelReader.B(parcel, z11);
                    break;
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzi(str, j10, z10, d10, str2, bArr, i10, i11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i10) {
        return new zzi[i10];
    }
}
