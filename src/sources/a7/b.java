package a7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        float f10 = 0.0f;
        boolean z10 = false;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z11);
                    break;
                case 2:
                    j10 = SafeParcelReader.C(parcel, z11);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, z11);
                    break;
                case 5:
                    i12 = SafeParcelReader.B(parcel, z11);
                    break;
                case 6:
                    arrayList = SafeParcelReader.r(parcel, z11);
                    break;
                case 8:
                    j11 = SafeParcelReader.C(parcel, z11);
                    break;
                case 10:
                    str3 = SafeParcelReader.p(parcel, z11);
                    break;
                case 11:
                    i11 = SafeParcelReader.B(parcel, z11);
                    break;
                case 12:
                    str2 = SafeParcelReader.p(parcel, z11);
                    break;
                case 13:
                    str4 = SafeParcelReader.p(parcel, z11);
                    break;
                case 14:
                    i13 = SafeParcelReader.B(parcel, z11);
                    break;
                case 15:
                    f10 = SafeParcelReader.y(parcel, z11);
                    break;
                case 16:
                    j12 = SafeParcelReader.C(parcel, z11);
                    break;
                case 17:
                    str5 = SafeParcelReader.p(parcel, z11);
                    break;
                case 18:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new WakeLockEvent(i10, j10, i11, str, i12, arrayList, str2, j11, i13, str3, str4, f10, j12, str5, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i10) {
        return new WakeLockEvent[i10];
    }
}
