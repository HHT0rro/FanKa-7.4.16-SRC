package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Parcelable.Creator<zag> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zag createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                arrayList = SafeParcelReader.r(parcel, z10);
            } else if (v2 != 2) {
                SafeParcelReader.E(parcel, z10);
            } else {
                str = SafeParcelReader.p(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zag(arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zag[] newArray(int i10) {
        return new zag[i10];
    }
}
