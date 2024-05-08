package com.huawei.appgallery.coreservice.internal.support.parcelable.b;

import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b extends RuntimeException {
        public b(String str) {
            super(str);
        }
    }

    public static int a(int i10) {
        return i10 & 65535;
    }

    public static int b(Parcel parcel) {
        int readInt = parcel.readInt();
        int c4 = c(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if (a(readInt) != 20293) {
            throw new a("Expected object header. Got 0x" + Integer.toHexString(readInt), parcel);
        }
        int i10 = c4 + dataPosition;
        if (i10 >= dataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        throw new a("Size read is invalid start=" + dataPosition + " end=" + i10, parcel);
    }

    public static int c(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (i10 >> 16) & 65535 : parcel.readInt();
    }

    public static void d(Parcel parcel, int i10, int i11) {
        int c4 = c(parcel, i10);
        if (c4 == i11) {
            return;
        }
        throw new a("Expected size " + i11 + " got " + c4 + " (0x" + Integer.toHexString(c4) + ")", parcel);
    }

    public static void e(Parcel parcel, int i10) {
        if ((i10 & (-65536)) == -65536) {
            parcel.setDataPosition(parcel.dataPosition() - 4);
        }
    }

    public static void f(Parcel parcel, int i10) {
        int c4 = c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        int i11 = dataPosition + c4;
        if (i11 >= dataPosition && i11 <= parcel.dataSize()) {
            parcel.setDataPosition(i11);
            return;
        }
        throw new b("error length:" + dataPosition + "-" + c4);
    }
}
