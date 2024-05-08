package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        boolean z11 = false;
        while (parcel.dataPosition() < F) {
            int z12 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z12)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z12);
                    break;
                case 2:
                    i11 = SafeParcelReader.B(parcel, z12);
                    break;
                case 3:
                    i12 = SafeParcelReader.B(parcel, z12);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, z12);
                    break;
                case 5:
                    iBinder = SafeParcelReader.A(parcel, z12);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.s(parcel, z12, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, z12);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.o(parcel, z12, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.E(parcel, z12);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.s(parcel, z12, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.s(parcel, z12, Feature.CREATOR);
                    break;
                case 12:
                    z10 = SafeParcelReader.w(parcel, z12);
                    break;
                case 13:
                    i13 = SafeParcelReader.B(parcel, z12);
                    break;
                case 14:
                    z11 = SafeParcelReader.w(parcel, z12);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new GetServiceRequest(i10, i11, i12, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z10, i13, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i10) {
        return new GetServiceRequest[i10];
    }
}
