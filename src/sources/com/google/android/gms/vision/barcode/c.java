package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements Parcelable.Creator<Barcode.CalendarDateTime> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.CalendarDateTime createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        String str = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < F) {
            int z11 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z11)) {
                case 2:
                    i10 = SafeParcelReader.B(parcel, z11);
                    break;
                case 3:
                    i11 = SafeParcelReader.B(parcel, z11);
                    break;
                case 4:
                    i12 = SafeParcelReader.B(parcel, z11);
                    break;
                case 5:
                    i13 = SafeParcelReader.B(parcel, z11);
                    break;
                case 6:
                    i14 = SafeParcelReader.B(parcel, z11);
                    break;
                case 7:
                    i15 = SafeParcelReader.B(parcel, z11);
                    break;
                case 8:
                    z10 = SafeParcelReader.w(parcel, z11);
                    break;
                case 9:
                    str = SafeParcelReader.p(parcel, z11);
                    break;
                default:
                    SafeParcelReader.E(parcel, z11);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new Barcode.CalendarDateTime(i10, i11, i12, i13, i14, i15, z10, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Barcode.CalendarDateTime[] newArray(int i10) {
        return new Barcode.CalendarDateTime[i10];
    }
}
