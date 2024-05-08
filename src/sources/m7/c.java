package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.phenotype.ExperimentTokens;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Parcelable.Creator<ExperimentTokens> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExperimentTokens createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        byte[] bArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        int[] iArr = null;
        byte[][] bArr6 = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z10)) {
                case 2:
                    str = SafeParcelReader.p(parcel, z10);
                    break;
                case 3:
                    bArr = SafeParcelReader.g(parcel, z10);
                    break;
                case 4:
                    bArr2 = SafeParcelReader.h(parcel, z10);
                    break;
                case 5:
                    bArr3 = SafeParcelReader.h(parcel, z10);
                    break;
                case 6:
                    bArr4 = SafeParcelReader.h(parcel, z10);
                    break;
                case 7:
                    bArr5 = SafeParcelReader.h(parcel, z10);
                    break;
                case 8:
                    iArr = SafeParcelReader.k(parcel, z10);
                    break;
                case 9:
                    bArr6 = SafeParcelReader.h(parcel, z10);
                    break;
                default:
                    SafeParcelReader.E(parcel, z10);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new ExperimentTokens(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExperimentTokens[] newArray(int i10) {
        return new ExperimentTokens[i10];
    }
}
