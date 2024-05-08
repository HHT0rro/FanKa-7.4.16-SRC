package r6;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        ArrayList arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        String str3 = null;
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (parcel.dataPosition() < F) {
            int z13 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z13)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z13);
                    break;
                case 2:
                    arrayList = SafeParcelReader.t(parcel, z13, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.o(parcel, z13, Account.CREATOR);
                    break;
                case 4:
                    z10 = SafeParcelReader.w(parcel, z13);
                    break;
                case 5:
                    z11 = SafeParcelReader.w(parcel, z13);
                    break;
                case 6:
                    z12 = SafeParcelReader.w(parcel, z13);
                    break;
                case 7:
                    str = SafeParcelReader.p(parcel, z13);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, z13);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.t(parcel, z13, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    str3 = SafeParcelReader.p(parcel, z13);
                    break;
                default:
                    SafeParcelReader.E(parcel, z13);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new GoogleSignInOptions(i10, (ArrayList<Scope>) arrayList, account, z10, z11, z12, str, str2, (ArrayList<GoogleSignInOptionsExtensionParcelable>) arrayList2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
