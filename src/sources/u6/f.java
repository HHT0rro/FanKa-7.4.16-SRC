package u6;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            int v2 = SafeParcelReader.v(z10);
            if (v2 == 1) {
                i11 = SafeParcelReader.B(parcel, z10);
            } else if (v2 == 2) {
                str = SafeParcelReader.p(parcel, z10);
            } else if (v2 == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.o(parcel, z10, PendingIntent.CREATOR);
            } else if (v2 == 4) {
                connectionResult = (ConnectionResult) SafeParcelReader.o(parcel, z10, ConnectionResult.CREATOR);
            } else if (v2 != 1000) {
                SafeParcelReader.E(parcel, z10);
            } else {
                i10 = SafeParcelReader.B(parcel, z10);
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Status(i10, i11, str, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i10) {
        return new Status[i10];
    }
}
