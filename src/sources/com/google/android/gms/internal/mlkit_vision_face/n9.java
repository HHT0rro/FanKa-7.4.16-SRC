package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n9 implements Parcelable.Creator<zzlj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzlj createFromParcel(Parcel parcel) {
        int F = SafeParcelReader.F(parcel);
        Rect rect = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i10 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        while (parcel.dataPosition() < F) {
            int z10 = SafeParcelReader.z(parcel);
            switch (SafeParcelReader.v(z10)) {
                case 1:
                    i10 = SafeParcelReader.B(parcel, z10);
                    break;
                case 2:
                    rect = (Rect) SafeParcelReader.o(parcel, z10, Rect.CREATOR);
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
                    f16 = SafeParcelReader.y(parcel, z10);
                    break;
                case 10:
                    arrayList = SafeParcelReader.t(parcel, z10, zzlp.CREATOR);
                    break;
                case 11:
                    arrayList2 = SafeParcelReader.t(parcel, z10, zzlf.CREATOR);
                    break;
                default:
                    SafeParcelReader.E(parcel, z10);
                    break;
            }
        }
        SafeParcelReader.u(parcel, F);
        return new zzlj(i10, rect, f10, f11, f12, f13, f14, f15, f16, arrayList, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzlj[] newArray(int i10) {
        return new zzlj[i10];
    }
}
