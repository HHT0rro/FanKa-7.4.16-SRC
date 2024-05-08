package com.huawei.appgallery.coreservice.internal.support.parcelable.b;

import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {
    public static void a(Parcel parcel, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(dataPosition - i10);
        parcel.setDataPosition(dataPosition);
    }

    public static void b(Parcel parcel, int i10, int i11) {
        if (i11 < 65535) {
            parcel.writeInt(i10 | (i11 << 16));
        } else {
            parcel.writeInt(i10 | (-65536));
            parcel.writeInt(i11);
        }
    }

    public static int c(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }
}
