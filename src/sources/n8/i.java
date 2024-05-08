package n8;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class i implements Parcelable.Creator<VisionImageMetadataParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ VisionImageMetadataParcel createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        long j10 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i10 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                i11 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 3) {
                i12 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 4) {
                j10 = SafeParcelReader.C(parcel, z10);
            } else if (v2 != 5) {
                SafeParcelReader.E(parcel, z10);
            } else {
                i13 = SafeParcelReader.B(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new VisionImageMetadataParcel(i10, i11, i12, j10, i13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ VisionImageMetadataParcel[] newArray(int i10) {
        return new VisionImageMetadataParcel[i10];
    }
}
