package t6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Parcelable.Creator<zze> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        zzr zzrVar = null;
        byte[] bArr = null;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[][] bArr2 = null;
        ExperimentTokens[] experimentTokensArr = null;
        boolean z10 = true;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 2:
                    zzrVar = (zzr) SafeParcelReader.o(parcel, z11, zzr.CREATOR);
                    break;
                case 3:
                    bArr = SafeParcelReader.g(parcel, z11);
                    break;
                case 4:
                    iArr = SafeParcelReader.k(parcel, z11);
                    break;
                case 5:
                    strArr = SafeParcelReader.q(parcel, z11);
                    break;
                case 6:
                    iArr2 = SafeParcelReader.k(parcel, z11);
                    break;
                case 7:
                    bArr2 = SafeParcelReader.h(parcel, z11);
                    break;
                case 8:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
                case 9:
                    experimentTokensArr = (ExperimentTokens[]) SafeParcelReader.s(parcel, z11, ExperimentTokens.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zze(zzrVar, bArr, iArr, strArr, iArr2, bArr2, z10, experimentTokensArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze[] newArray(int i10) {
        return new zze[i10];
    }
}
