package com.huawei.hms.common.parcel;

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
public class ParcelWrite {

    /* renamed from: b, reason: collision with root package name */
    public static final int f29749b = 65262;

    /* renamed from: a, reason: collision with root package name */
    public Parcel f29750a;

    public ParcelWrite(Parcel parcel) {
        this.f29750a = parcel;
    }

    private int a(int i10) {
        this.f29750a.writeInt(i10 | (-65536));
        this.f29750a.writeInt(0);
        return this.f29750a.dataPosition();
    }

    private void a(int i10, int i11) {
        if (i11 < 65535) {
            this.f29750a.writeInt(i10 | (i11 << 16));
        } else {
            this.f29750a.writeInt(i10 | (-65536));
            this.f29750a.writeInt(i11);
        }
    }

    private <T extends Parcelable> void a(T t2, int i10) {
        int dataPosition = this.f29750a.dataPosition();
        this.f29750a.writeInt(1);
        int dataPosition2 = this.f29750a.dataPosition();
        t2.writeToParcel(this.f29750a, i10);
        int dataPosition3 = this.f29750a.dataPosition();
        this.f29750a.setDataPosition(dataPosition);
        this.f29750a.writeInt(dataPosition3 - dataPosition2);
        this.f29750a.setDataPosition(dataPosition3);
    }

    private void b(int i10) {
        int dataPosition = this.f29750a.dataPosition();
        this.f29750a.setDataPosition(i10 - 4);
        this.f29750a.writeInt(dataPosition - i10);
        this.f29750a.setDataPosition(dataPosition);
    }

    public int beginObjectHeader() {
        return a(65262);
    }

    public void finishObjectHeader(int i10) {
        b(i10);
    }

    public void writeBigDecimal(int i10, BigDecimal bigDecimal, boolean z10) {
        if (bigDecimal == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.f29750a.writeInt(bigDecimal.scale());
            b(a10);
        }
    }

    public void writeBigDecimalArray(int i10, BigDecimal[] bigDecimalArr, boolean z10) {
        if (bigDecimalArr == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int length = bigDecimalArr.length;
        this.f29750a.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            this.f29750a.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
            this.f29750a.writeInt(bigDecimalArr[i11].scale());
        }
        b(a10);
    }

    public void writeBigInteger(int i10, BigInteger bigInteger, boolean z10) {
        if (bigInteger == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeByteArray(bigInteger.toByteArray());
            b(a10);
        }
    }

    public void writeBigIntegerArray(int i10, BigInteger[] bigIntegerArr, boolean z10) {
        if (bigIntegerArr == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        this.f29750a.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            this.f29750a.writeByteArray(bigInteger.toByteArray());
        }
        b(a10);
    }

    public void writeBoolean(int i10, boolean z10) {
        a(i10, 4);
        this.f29750a.writeInt(z10 ? 1 : 0);
    }

    public void writeBooleanArray(int i10, boolean[] zArr, boolean z10) {
        if (zArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeBooleanArray(zArr);
            b(a10);
        }
    }

    public void writeBooleanList(int i10, List<Boolean> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = list.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(list.get(i11).booleanValue() ? 1 : 0);
        }
        b(a10);
    }

    public void writeBooleanObject(int i10, Boolean bool) {
        writeBooleanObject(i10, bool, false);
    }

    public void writeBooleanObject(int i10, Boolean bool, boolean z10) {
        if (bool != null) {
            a(i10, 4);
            this.f29750a.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeBundle(int i10, Bundle bundle, boolean z10) {
        if (bundle == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeBundle(bundle);
            b(a10);
        }
    }

    public void writeByte(int i10, byte b4) {
        a(i10, 4);
        this.f29750a.writeInt(b4);
    }

    public void writeByteArray(int i10, byte[] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeByteArray(bArr);
            b(a10);
        }
    }

    public void writeByteArrayArray(int i10, byte[][] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        this.f29750a.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            this.f29750a.writeByteArray(bArr2);
        }
        b(a10);
    }

    public void writeByteArraySparseArray(int i10, SparseArray<byte[]> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseArray.keyAt(i11));
            this.f29750a.writeByteArray(sparseArray.valueAt(i11));
        }
        b(a10);
    }

    public void writeChar(int i10, char c4) {
        a(i10, 4);
        this.f29750a.writeInt(c4);
    }

    public void writeCharArray(int i10, char[] cArr, boolean z10) {
        if (cArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeCharArray(cArr);
            b(a10);
        }
    }

    public void writeDouble(int i10, double d10) {
        a(i10, 8);
        this.f29750a.writeDouble(d10);
    }

    public void writeDoubleArray(int i10, double[] dArr, boolean z10) {
        if (dArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeDoubleArray(dArr);
            b(a10);
        }
    }

    public void writeDoubleList(int i10, List<Double> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = list.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeDouble(list.get(i11).doubleValue());
        }
        b(a10);
    }

    public void writeDoubleObject(int i10, Double d10, boolean z10) {
        if (d10 != null) {
            a(i10, 8);
            this.f29750a.writeDouble(d10.doubleValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeDoubleSparseArray(int i10, SparseArray<Double> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseArray.keyAt(i11));
            this.f29750a.writeDouble(sparseArray.valueAt(i11).doubleValue());
        }
        b(a10);
    }

    public void writeFloat(int i10, float f10) {
        a(i10, 4);
        this.f29750a.writeFloat(f10);
    }

    public void writeFloatArray(int i10, float[] fArr, boolean z10) {
        if (fArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeFloatArray(fArr);
            b(a10);
        }
    }

    public void writeFloatList(int i10, List<Float> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = list.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeFloat(list.get(i11).floatValue());
        }
        b(a10);
    }

    public void writeFloatObject(int i10, Float f10, boolean z10) {
        if (f10 != null) {
            a(i10, 4);
            this.f29750a.writeFloat(f10.floatValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeFloatSparseArray(int i10, SparseArray<Float> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseArray.keyAt(i11));
            this.f29750a.writeFloat(sparseArray.valueAt(i11).floatValue());
        }
        b(a10);
    }

    public void writeIBinder(int i10, IBinder iBinder, boolean z10) {
        if (iBinder == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeStrongBinder(iBinder);
            b(a10);
        }
    }

    public void writeIBinderArray(int i10, IBinder[] iBinderArr, boolean z10) {
        if (iBinderArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeBinderArray(iBinderArr);
            b(a10);
        }
    }

    public void writeIBinderList(int i10, List<IBinder> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeBinderList(list);
            b(a10);
        }
    }

    public void writeIBinderSparseArray(int i10, SparseArray<IBinder> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseArray.keyAt(i11));
            this.f29750a.writeStrongBinder(sparseArray.valueAt(i11));
        }
        b(a10);
    }

    public void writeInt(int i10, int i11) {
        a(i10, 4);
        this.f29750a.writeInt(i11);
    }

    public void writeIntArray(int i10, int[] iArr, boolean z10) {
        if (iArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeIntArray(iArr);
            b(a10);
        }
    }

    public void writeIntegerList(int i10, List<Integer> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = list.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(list.get(i11).intValue());
        }
        b(a10);
    }

    public void writeIntegerObject(int i10, Integer num, boolean z10) {
        if (num != null) {
            a(i10, 4);
            this.f29750a.writeInt(num.intValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeList(int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeList(list);
            b(a10);
        }
    }

    public void writeLong(int i10, long j10) {
        a(i10, 8);
        this.f29750a.writeLong(j10);
    }

    public void writeLongArray(int i10, long[] jArr, boolean z10) {
        if (jArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeLongArray(jArr);
            b(a10);
        }
    }

    public void writeLongList(int i10, List<Long> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = list.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeLong(list.get(i11).longValue());
        }
        b(a10);
    }

    public void writeLongObject(int i10, Long l10, boolean z10) {
        if (l10 != null) {
            a(i10, 8);
            this.f29750a.writeLong(l10.longValue());
        } else if (z10) {
            a(i10, 0);
        }
    }

    public void writeParcel(int i10, Parcel parcel, boolean z10) {
        if (parcel == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.appendFrom(parcel, 0, parcel.dataSize());
            b(a10);
        }
    }

    public void writeParcelArray(int i10, Parcel[] parcelArr, boolean z10) {
        if (parcelArr == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        this.f29750a.writeInt(parcelArr.length);
        for (Parcel parcel : parcelArr) {
            if (parcel != null) {
                this.f29750a.writeInt(parcel.dataSize());
                this.f29750a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f29750a.writeInt(0);
            }
        }
        b(a10);
    }

    public void writeParcelList(int i10, List<Parcel> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = list.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcel parcel = list.get(i11);
            if (parcel != null) {
                this.f29750a.writeInt(parcel.dataSize());
                this.f29750a.appendFrom(parcel, 0, parcel.dataSize());
            } else {
                this.f29750a.writeInt(0);
            }
        }
        b(a10);
    }

    public void writeParcelSparseArray(int i10, SparseArray<Parcel> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseArray.keyAt(i11));
            Parcel valueAt = sparseArray.valueAt(i11);
            if (valueAt != null) {
                this.f29750a.writeInt(valueAt.dataSize());
                this.f29750a.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                this.f29750a.writeInt(0);
            }
        }
        b(a10);
    }

    public void writeParcelable(int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            parcelable.writeToParcel(this.f29750a, i11);
            b(a10);
        }
    }

    public void writeShort(int i10, short s2) {
        a(i10, 4);
        this.f29750a.writeInt(s2);
    }

    public void writeSparseBooleanArray(int i10, SparseBooleanArray sparseBooleanArray, boolean z10) {
        if (sparseBooleanArray == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeSparseBooleanArray(sparseBooleanArray);
            b(a10);
        }
    }

    public void writeSparseIntArray(int i10, SparseIntArray sparseIntArray, boolean z10) {
        if (sparseIntArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseIntArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseIntArray.keyAt(i11));
            this.f29750a.writeInt(sparseIntArray.valueAt(i11));
        }
        b(a10);
    }

    public void writeSparseLongArray(int i10, SparseLongArray sparseLongArray, boolean z10) {
        if (sparseLongArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseLongArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseLongArray.keyAt(i11));
            this.f29750a.writeLong(sparseLongArray.valueAt(i11));
        }
        b(a10);
    }

    public void writeString(int i10, String str, boolean z10) {
        if (str == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeString(str);
            b(a10);
        }
    }

    public void writeStringArray(int i10, String[] strArr, boolean z10) {
        if (strArr == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeStringArray(strArr);
            b(a10);
        }
    }

    public void writeStringList(int i10, List<String> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
            }
        } else {
            int a10 = a(i10);
            this.f29750a.writeStringList(list);
            b(a10);
        }
    }

    public void writeStringSparseArray(int i10, SparseArray<String> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseArray.keyAt(i11));
            this.f29750a.writeString(sparseArray.valueAt(i11));
        }
        b(a10);
    }

    public <T extends Parcelable> void writeTypedArray(int i10, T[] tArr, int i11, boolean z10) {
        if (tArr == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        this.f29750a.writeInt(tArr.length);
        for (T t2 : tArr) {
            if (t2 == null) {
                this.f29750a.writeInt(0);
            } else {
                a((ParcelWrite) t2, i11);
            }
        }
        b(a10);
    }

    public <T extends Parcelable> void writeTypedList(int i10, List<T> list, boolean z10) {
        if (list == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = list.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t2 = list.get(i11);
            if (t2 == null) {
                this.f29750a.writeInt(0);
            } else {
                a((ParcelWrite) t2, 0);
            }
        }
        b(a10);
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i10, SparseArray<T> sparseArray, boolean z10) {
        if (sparseArray == null) {
            if (z10) {
                a(i10, 0);
                return;
            }
            return;
        }
        int a10 = a(i10);
        int size = sparseArray.size();
        this.f29750a.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f29750a.writeInt(sparseArray.keyAt(i11));
            T valueAt = sparseArray.valueAt(i11);
            if (valueAt == null) {
                this.f29750a.writeInt(0);
            } else {
                a((ParcelWrite) valueAt, 0);
            }
        }
        b(a10);
    }
}
