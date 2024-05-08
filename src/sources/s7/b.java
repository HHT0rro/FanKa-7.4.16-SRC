package s7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Parcelable.Creator<FaceParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FaceParcel createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        LandmarkParcel[] landmarkParcelArr = null;
        zza[] zzaVarArr = null;
        int i10 = 0;
        int i11 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = Float.MAX_VALUE;
        float f15 = Float.MAX_VALUE;
        float f16 = Float.MAX_VALUE;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = -1.0f;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z10)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z10);
                    break;
                case 2:
                    i11 = SafeParcelReader.B(parcel, z10);
                    break;
                case 3:
                    f10 = SafeParcelReader.y(parcel, z10);
                    break;
                case 4:
                    f11 = SafeParcelReader.y(parcel, z10);
                    break;
                case 5:
                    f12 = SafeParcelReader.y(parcel, z10);
                    break;
                case 6:
                    f13 = SafeParcelReader.y(parcel, z10);
                    break;
                case 7:
                    f14 = SafeParcelReader.y(parcel, z10);
                    break;
                case 8:
                    f15 = SafeParcelReader.y(parcel, z10);
                    break;
                case 9:
                    landmarkParcelArr = (LandmarkParcel[]) SafeParcelReader.s(parcel, z10, LandmarkParcel.CREATOR);
                    break;
                case 10:
                    f17 = SafeParcelReader.y(parcel, z10);
                    break;
                case 11:
                    f18 = SafeParcelReader.y(parcel, z10);
                    break;
                case 12:
                    f19 = SafeParcelReader.y(parcel, z10);
                    break;
                case 13:
                    zzaVarArr = (zza[]) SafeParcelReader.s(parcel, z10, zza.CREATOR);
                    break;
                case 14:
                    f16 = SafeParcelReader.y(parcel, z10);
                    break;
                case 15:
                    f20 = SafeParcelReader.y(parcel, z10);
                    break;
                default:
                    SafeParcelReader.E(parcel, z10);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new FaceParcel(i10, i11, f10, f11, f12, f13, f14, f15, f16, landmarkParcelArr, f17, f18, f19, zzaVarArr, f20);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FaceParcel[] newArray(int i10) {
        return new FaceParcel[i10];
    }
}
