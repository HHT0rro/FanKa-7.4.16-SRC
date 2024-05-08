package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ParseException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ParseException(@androidx.annotation.RecentlyNonNull java.lang.String r4, @androidx.annotation.RecentlyNonNull android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    @RecentlyNonNull
    public static IBinder A(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + D);
        return readStrongBinder;
    }

    @RecentlyNonNull
    public static int B(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        G(parcel, i10, 4);
        return parcel.readInt();
    }

    @RecentlyNonNull
    public static long C(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        G(parcel, i10, 8);
        return parcel.readLong();
    }

    @RecentlyNonNull
    public static int D(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        return (i10 & (-65536)) != -65536 ? (i10 >> 16) & 65535 : parcel.readInt();
    }

    public static void E(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        parcel.setDataPosition(parcel.dataPosition() + D(parcel, i10));
    }

    @RecentlyNonNull
    public static int F(@RecentlyNonNull Parcel parcel) {
        int z10 = z(parcel);
        int D = D(parcel, z10);
        int dataPosition = parcel.dataPosition();
        if (v(z10) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(z10));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i10 = D + dataPosition;
        if (i10 >= dataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Size read is invalid start=");
        sb2.append(dataPosition);
        sb2.append(" end=");
        sb2.append(i10);
        throw new ParseException(sb2.toString(), parcel);
    }

    public static void G(Parcel parcel, int i10, int i11) {
        int D = D(parcel, i10);
        if (D == i11) {
            return;
        }
        String hexString = Integer.toHexString(D);
        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb2.append("Expected size ");
        sb2.append(i11);
        sb2.append(" got ");
        sb2.append(D);
        sb2.append(" (0x");
        sb2.append(hexString);
        sb2.append(")");
        throw new ParseException(sb2.toString(), parcel);
    }

    @RecentlyNonNull
    public static BigDecimal a(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + D);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    @RecentlyNonNull
    public static BigDecimal[] b(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i11] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + D);
        return bigDecimalArr;
    }

    @RecentlyNonNull
    public static BigInteger c(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + D);
        return new BigInteger(createByteArray);
    }

    @RecentlyNonNull
    public static BigInteger[] d(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            bigIntegerArr[i11] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + D);
        return bigIntegerArr;
    }

    @RecentlyNonNull
    public static boolean[] e(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + D);
        return createBooleanArray;
    }

    @RecentlyNonNull
    public static Bundle f(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + D);
        return readBundle;
    }

    @RecentlyNonNull
    public static byte[] g(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + D);
        return createByteArray;
    }

    @RecentlyNonNull
    public static byte[][] h(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            bArr[i11] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + D);
        return bArr;
    }

    @RecentlyNonNull
    public static double[] i(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + D);
        return createDoubleArray;
    }

    @RecentlyNonNull
    public static float[] j(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + D);
        return createFloatArray;
    }

    @RecentlyNonNull
    public static int[] k(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + D);
        return createIntArray;
    }

    @RecentlyNonNull
    public static long[] l(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + D);
        return createLongArray;
    }

    @RecentlyNonNull
    public static Parcel m(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, D);
        parcel.setDataPosition(dataPosition + D);
        return obtain;
    }

    @RecentlyNonNull
    public static Parcel[] n(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i11] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i11] = null;
            }
        }
        parcel.setDataPosition(dataPosition + D);
        return parcelArr;
    }

    @RecentlyNonNull
    public static <T extends Parcelable> T o(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + D);
        return createFromParcel;
    }

    @RecentlyNonNull
    public static String p(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + D);
        return readString;
    }

    @RecentlyNonNull
    public static String[] q(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + D);
        return createStringArray;
    }

    @RecentlyNonNull
    public static ArrayList<String> r(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + D);
        return createStringArrayList;
    }

    @RecentlyNonNull
    public static <T> T[] s(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + D);
        return tArr;
    }

    @RecentlyNonNull
    public static <T> ArrayList<T> t(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int D = D(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (D == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + D);
        return createTypedArrayList;
    }

    public static void u(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        if (parcel.dataPosition() == i10) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Overread allowed size end=");
        sb2.append(i10);
        throw new ParseException(sb2.toString(), parcel);
    }

    @RecentlyNonNull
    public static int v(@RecentlyNonNull int i10) {
        return i10 & 65535;
    }

    @RecentlyNonNull
    public static boolean w(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        G(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    @RecentlyNonNull
    public static double x(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        G(parcel, i10, 8);
        return parcel.readDouble();
    }

    @RecentlyNonNull
    public static float y(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        G(parcel, i10, 4);
        return parcel.readFloat();
    }

    @RecentlyNonNull
    public static int z(@RecentlyNonNull Parcel parcel) {
        return parcel.readInt();
    }
}
