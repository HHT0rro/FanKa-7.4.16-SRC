package com.huawei.hms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    private static void a(Parcel parcel, int i10, int i11) {
        if (parcel == null) {
            return;
        }
        if (i11 >= 65535) {
            parcel.writeInt(i10 | (-65536));
            parcel.writeInt(i11);
        } else {
            parcel.writeInt(i10 | (i11 << 16));
        }
    }

    private static void b(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(dataPosition - i10);
        parcel.setDataPosition(dataPosition);
    }

    public static int beginObjectHeader(Parcel parcel) {
        return a(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i10) {
        b(parcel, i10);
    }

    public static void writeBigDecimal(Parcel parcel, int i10, BigDecimal bigDecimal, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigDecimal == null) {
            if (z10) {
                a(parcel, i10, 0);
            }
        } else {
            int a10 = a(parcel, i10);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            b(parcel, a10);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i10, BigDecimal[] bigDecimalArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigDecimalArr == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            parcel.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i11].scale());
        }
        b(parcel, a10);
    }

    public static void writeBigInteger(Parcel parcel, int i10, BigInteger bigInteger, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigInteger != null) {
            int a10 = a(parcel, i10);
            parcel.writeByteArray(bigInteger.toByteArray());
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i10, BigInteger[] bigIntegerArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bigIntegerArr == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        b(parcel, a10);
    }

    public static void writeBoolean(Parcel parcel, int i10, boolean z10) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 4);
        if (z10) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    public static void writeBooleanArray(Parcel parcel, int i10, boolean[] zArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (zArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeBooleanArray(zArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i10, List<Boolean> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(list.get(i11).booleanValue() ? 1 : 0);
        }
        b(parcel, a10);
    }

    public static void writeBooleanObject(Parcel parcel, int i10, Boolean bool, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bool != null) {
            a(parcel, i10, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i10, Bundle bundle, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bundle != null) {
            int a10 = a(parcel, i10);
            parcel.writeBundle(bundle);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i10, byte b4) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 4);
        parcel.writeInt(b4);
    }

    public static void writeByteArray(Parcel parcel, int i10, byte[] bArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeByteArray(bArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i10, byte[][] bArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (bArr == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        b(parcel, a10);
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i10, SparseArray<byte[]> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeByteArray(sparseArray.valueAt(i11));
        }
        b(parcel, a10);
    }

    public static void writeChar(Parcel parcel, int i10, char c4) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 4);
        parcel.writeInt(c4);
    }

    public static void writeCharArray(Parcel parcel, int i10, char[] cArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (cArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeCharArray(cArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i10, double d10) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 8);
        parcel.writeDouble(d10);
    }

    public static void writeDoubleArray(Parcel parcel, int i10, double[] dArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (dArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeDoubleArray(dArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i10, List<Double> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeDouble(list.get(i11).doubleValue());
        }
        b(parcel, a10);
    }

    public static void writeDoubleObject(Parcel parcel, int i10, Double d10, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (d10 != null) {
            a(parcel, i10, 8);
            parcel.writeDouble(d10.doubleValue());
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i10, SparseArray<Double> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeDouble(sparseArray.valueAt(i11).doubleValue());
        }
        b(parcel, a10);
    }

    public static void writeFloat(Parcel parcel, int i10, float f10) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void writeFloatArray(Parcel parcel, int i10, float[] fArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (fArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeFloatArray(fArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i10, List<Float> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeFloat(list.get(i11).floatValue());
        }
        b(parcel, a10);
    }

    public static void writeFloatObject(Parcel parcel, int i10, Float f10, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (f10 != null) {
            a(parcel, i10, 4);
            parcel.writeFloat(f10.floatValue());
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i10, SparseArray<Float> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeFloat(sparseArray.valueAt(i11).floatValue());
        }
        b(parcel, a10);
    }

    public static void writeIBinder(Parcel parcel, int i10, IBinder iBinder, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (iBinder != null) {
            int a10 = a(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i10, IBinder[] iBinderArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (iBinderArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeBinderArray(iBinderArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i10, List<IBinder> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int a10 = a(parcel, i10);
            parcel.writeBinderList(list);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i10, SparseArray<IBinder> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeStrongBinder(sparseArray.valueAt(i11));
        }
        b(parcel, a10);
    }

    public static void writeInt(Parcel parcel, int i10, int i11) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void writeIntArray(Parcel parcel, int i10, int[] iArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (iArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeIntArray(iArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i10, List<Integer> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(list.get(i11).intValue());
        }
        b(parcel, a10);
    }

    public static void writeIntegerObject(Parcel parcel, int i10, Integer num, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (num != null) {
            a(parcel, i10, 4);
            parcel.writeInt(num.intValue());
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeList(Parcel parcel, int i10, List list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int a10 = a(parcel, i10);
            parcel.writeList(list);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i10, long j10) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void writeLongArray(Parcel parcel, int i10, long[] jArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (jArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeLongArray(jArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i10, List<Long> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeLong(list.get(i11).longValue());
        }
        b(parcel, a10);
    }

    public static void writeLongObject(Parcel parcel, int i10, Long l10, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (l10 != null) {
            a(parcel, i10, 8);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i10, Parcel parcel2, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (parcel2 != null) {
            int a10 = a(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i10, Parcel[] parcelArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (parcelArr == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int length = parcelArr.length;
        parcel.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            if (parcelArr[i11] == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcelArr[i11].dataSize());
                parcel.appendFrom(parcelArr[i11], 0, parcelArr[i11].dataSize());
            }
        }
        b(parcel, a10);
    }

    public static void writeParcelList(Parcel parcel, int i10, List<Parcel> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcel parcel2 = list.get(i11);
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            }
        }
        b(parcel, a10);
    }

    public static void writeParcelSparseArray(Parcel parcel, int i10, SparseArray<Parcel> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            Parcel valueAt = sparseArray.valueAt(i11);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            }
        }
        b(parcel, a10);
    }

    public static void writeParcelable(Parcel parcel, int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (parcelable != null) {
            int a10 = a(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i10, short s2) {
        if (parcel == null) {
            return;
        }
        a(parcel, i10, 4);
        parcel.writeInt(s2);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i10, SparseBooleanArray sparseBooleanArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseBooleanArray != null) {
            int a10 = a(parcel, i10);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i10, SparseIntArray sparseIntArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseIntArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseIntArray.keyAt(i11));
            parcel.writeInt(sparseIntArray.valueAt(i11));
        }
        b(parcel, a10);
    }

    public static void writeSparseLongArray(Parcel parcel, int i10, SparseLongArray sparseLongArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseLongArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseLongArray.keyAt(i11));
            parcel.writeLong(sparseLongArray.valueAt(i11));
        }
        b(parcel, a10);
    }

    public static void writeString(Parcel parcel, int i10, String str, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (str != null) {
            int a10 = a(parcel, i10);
            parcel.writeString(str);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i10, String[] strArr, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (strArr != null) {
            int a10 = a(parcel, i10);
            parcel.writeStringArray(strArr);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i10, List<String> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int a10 = a(parcel, i10);
            parcel.writeStringList(list);
            b(parcel, a10);
        } else if (z10) {
            a(parcel, i10, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i10, SparseArray<String> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            parcel.writeString(sparseArray.valueAt(i11));
        }
        b(parcel, a10);
    }

    public static <P extends Parcelable> void writeTypedArray(Parcel parcel, int i10, P[] pArr, int i11, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (pArr == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        parcel.writeInt(a10);
        int length = pArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (pArr[i12] != null) {
                a(parcel, pArr[i12], i11);
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, a10);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i10, List<T> list, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t2 = list.get(i11);
            if (t2 != null) {
                a(parcel, t2, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, a10);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i10, SparseArray<T> sparseArray, boolean z10) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z10) {
                a(parcel, i10, 0);
                return;
            }
            return;
        }
        int a10 = a(parcel, i10);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(sparseArray.keyAt(i11));
            T valueAt = sparseArray.valueAt(i11);
            if (valueAt != null) {
                a(parcel, valueAt, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, a10);
    }

    private static int a(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static <P extends Parcelable> void a(Parcel parcel, P p10, int i10) {
        if (parcel == null) {
            return;
        }
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        p10.writeToParcel(parcel, i10);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
