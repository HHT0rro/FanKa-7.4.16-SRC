package r6;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j10 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z10)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z10);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, z10);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, z10);
                    break;
                case 4:
                    str3 = SafeParcelReader.p(parcel, z10);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, z10);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.o(parcel, z10, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.p(parcel, z10);
                    break;
                case 8:
                    j10 = SafeParcelReader.C(parcel, z10);
                    break;
                case 9:
                    str6 = SafeParcelReader.p(parcel, z10);
                    break;
                case 10:
                    arrayList = SafeParcelReader.t(parcel, z10, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.p(parcel, z10);
                    break;
                case 12:
                    str8 = SafeParcelReader.p(parcel, z10);
                    break;
                default:
                    SafeParcelReader.E(parcel, z10);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new GoogleSignInAccount(i10, str, str2, str3, str4, uri, str5, j10, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i10) {
        return new GoogleSignInAccount[i10];
    }
}
