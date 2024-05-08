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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ParcelReader {

    /* renamed from: c, reason: collision with root package name */
    public static final int f29743c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f29744d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f29745e = 65262;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Integer, Integer[]> f29746a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public Parcel f29747b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    public ParcelReader(Parcel parcel) {
        this.f29747b = parcel;
        a();
    }

    private int a(int i10) {
        if (i10 < 0) {
            return 0;
        }
        if (i10 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i10;
    }

    private void a() {
        int readInt = this.f29747b.readInt();
        int i10 = readInt & 65535;
        int readInt2 = (readInt & (-65536)) != -65536 ? (readInt >> 16) & 65535 : this.f29747b.readInt();
        if (i10 != 65262) {
            throw new ParseException("Parse header error, not 65262. Got 0x" + Integer.toHexString(i10), this.f29747b);
        }
        int dataPosition = this.f29747b.dataPosition();
        int i11 = readInt2 + dataPosition;
        if (i11 < dataPosition || i11 > this.f29747b.dataSize()) {
            throw new ParseException("invalid size, start=" + dataPosition + " end=" + i11, this.f29747b);
        }
        while (this.f29747b.dataPosition() < i11) {
            int readInt3 = this.f29747b.readInt();
            int i12 = readInt3 & 65535;
            int readInt4 = (readInt3 & (-65536)) != -65536 ? (readInt3 >> 16) & 65535 : this.f29747b.readInt();
            int dataPosition2 = this.f29747b.dataPosition();
            this.f29746a.put(Integer.valueOf(i12), new Integer[]{Integer.valueOf(dataPosition2), Integer.valueOf(readInt4)});
            this.f29747b.setDataPosition(dataPosition2 + readInt4);
        }
        if (this.f29747b.dataPosition() == i11) {
            return;
        }
        throw new ParseException("the dataPosition is not" + i11, this.f29747b);
    }

    private void a(int i10, int i11) {
        Integer[] numArr = this.f29746a.get(Integer.valueOf(i10));
        if (numArr == null) {
            throw new ParseException("Field is null:" + ((Object) numArr), this.f29747b);
        }
        int intValue = numArr[1].intValue();
        if (intValue == i11) {
            return;
        }
        throw new ParseException("the field size is not " + i11 + " got " + intValue + " (0x" + Integer.toHexString(intValue) + ")", this.f29747b);
    }

    private int b(int i10) {
        Integer[] numArr = this.f29746a.get(Integer.valueOf(i10));
        if (numArr != null) {
            this.f29747b.setDataPosition(numArr[0].intValue());
            return numArr[1].intValue();
        }
        throw new ParseException("Field is null:" + ((Object) numArr), this.f29747b);
    }

    private int b(int i10, int i11) {
        Integer[] numArr = this.f29746a.get(Integer.valueOf(i10));
        if (numArr != null) {
            this.f29747b.setDataPosition(numArr[0].intValue());
            a(i10, i11);
            return i11;
        }
        throw new ParseException("Field is null:" + ((Object) numArr), this.f29747b);
    }

    public BigDecimal createBigDecimal(int i10, BigDecimal bigDecimal) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bigDecimal;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        byte[] createByteArray = this.f29747b.createByteArray();
        int readInt = this.f29747b.readInt();
        this.f29747b.setDataPosition(dataPosition + b4);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public BigDecimal[] createBigDecimalArray(int i10, BigDecimal[] bigDecimalArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bigDecimalArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        BigDecimal[] bigDecimalArr2 = new BigDecimal[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            byte[] createByteArray = this.f29747b.createByteArray();
            bigDecimalArr2[i11] = new BigDecimal(new BigInteger(createByteArray), this.f29747b.readInt());
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return bigDecimalArr2;
    }

    public BigInteger createBigInteger(int i10, BigInteger bigInteger) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bigInteger;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        byte[] createByteArray = this.f29747b.createByteArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return new BigInteger(createByteArray);
    }

    public BigInteger[] createBigIntegerArray(int i10, BigInteger[] bigIntegerArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bigIntegerArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        BigInteger[] bigIntegerArr2 = new BigInteger[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            bigIntegerArr2[i11] = new BigInteger(this.f29747b.createByteArray());
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return bigIntegerArr2;
    }

    public boolean[] createBooleanArray(int i10, boolean[] zArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return zArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        boolean[] createBooleanArray = this.f29747b.createBooleanArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createBooleanArray;
    }

    public ArrayList<Boolean> createBooleanList(int i10, ArrayList<Boolean> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            arrayList2.add(Boolean.valueOf(this.f29747b.readInt() != 0));
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return arrayList2;
    }

    public byte[] createByteArray(int i10, byte[] bArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        byte[] createByteArray = this.f29747b.createByteArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createByteArray;
    }

    public byte[][] createByteArrayArray(int i10, byte[][] bArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        byte[][] bArr2 = new byte[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            bArr2[i11] = this.f29747b.createByteArray();
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return bArr2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i10, SparseArray<byte[]> sparseArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(a10);
        for (int i11 = 0; i11 < a10; i11++) {
            sparseArray2.append(this.f29747b.readInt(), this.f29747b.createByteArray());
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseArray2;
    }

    public char[] createCharArray(int i10, char[] cArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return cArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        char[] createCharArray = this.f29747b.createCharArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createCharArray;
    }

    public double[] createDoubleArray(int i10, double[] dArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return dArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        double[] createDoubleArray = this.f29747b.createDoubleArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createDoubleArray;
    }

    public ArrayList<Double> createDoubleList(int i10, ArrayList<Double> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            arrayList2.add(Double.valueOf(this.f29747b.readDouble()));
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return arrayList2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i10, SparseArray<Double> sparseArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            sparseArray2.append(this.f29747b.readInt(), Double.valueOf(this.f29747b.readDouble()));
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseArray2;
    }

    public float[] createFloatArray(int i10, float[] fArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return fArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        float[] createFloatArray = this.f29747b.createFloatArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createFloatArray;
    }

    public ArrayList<Float> createFloatList(int i10, ArrayList<Float> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            arrayList2.add(Float.valueOf(this.f29747b.readFloat()));
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return arrayList2;
    }

    public SparseArray<Float> createFloatSparseArray(int i10, SparseArray<Float> sparseArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            sparseArray2.append(this.f29747b.readInt(), Float.valueOf(this.f29747b.readFloat()));
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseArray2;
    }

    public IBinder[] createIBinderArray(int i10, IBinder[] iBinderArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return iBinderArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        IBinder[] createBinderArray = this.f29747b.createBinderArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createBinderArray;
    }

    public ArrayList<IBinder> createIBinderList(int i10, ArrayList<IBinder> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<IBinder> createBinderArrayList = this.f29747b.createBinderArrayList();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createBinderArrayList;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i10, SparseArray<IBinder> sparseArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(a10);
        for (int i11 = 0; i11 < a10; i11++) {
            sparseArray2.append(this.f29747b.readInt(), this.f29747b.readStrongBinder());
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseArray2;
    }

    public int[] createIntArray(int i10, int[] iArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return iArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int[] createIntArray = this.f29747b.createIntArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createIntArray;
    }

    public ArrayList<Integer> createIntegerList(int i10, ArrayList<Integer> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            arrayList2.add(Integer.valueOf(this.f29747b.readInt()));
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return arrayList2;
    }

    public long[] createLongArray(int i10, long[] jArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return jArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        long[] createLongArray = this.f29747b.createLongArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createLongArray;
    }

    public ArrayList<Long> createLongList(int i10, ArrayList<Long> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            arrayList2.add(Long.valueOf(this.f29747b.readLong()));
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return arrayList2;
    }

    public Parcel createParcel(int i10, Parcel parcel) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return parcel;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(this.f29747b, dataPosition, b4);
        this.f29747b.setDataPosition(dataPosition + b4);
        return obtain;
    }

    public Parcel[] createParcelArray(int i10, Parcel[] parcelArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return parcelArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        Parcel[] parcelArr2 = new Parcel[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            int readInt = this.f29747b.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.f29747b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f29747b, dataPosition2, readInt);
                parcelArr2[i11] = obtain;
                this.f29747b.setDataPosition(dataPosition2 + readInt);
            } else {
                parcelArr2[i11] = null;
            }
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i10, ArrayList<Parcel> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i11 = 0; i11 < a10; i11++) {
            int readInt = this.f29747b.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.f29747b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f29747b, dataPosition2, readInt);
                arrayList2.add(obtain);
                this.f29747b.setDataPosition(dataPosition2 + readInt);
            } else {
                arrayList2.add(null);
            }
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return arrayList2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i10, SparseArray<Parcel> sparseArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i11 = 0; i11 < a10; i11++) {
            int readInt = this.f29747b.readInt();
            int readInt2 = this.f29747b.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = this.f29747b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.f29747b, dataPosition2, readInt2);
                sparseArray2.append(readInt, obtain);
                this.f29747b.setDataPosition(dataPosition2 + readInt2);
            } else {
                sparseArray2.append(readInt, null);
            }
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i10, SparseBooleanArray sparseBooleanArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseBooleanArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        SparseBooleanArray readSparseBooleanArray = this.f29747b.readSparseBooleanArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return readSparseBooleanArray;
    }

    public SparseIntArray createSparseIntArray(int i10, SparseIntArray sparseIntArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseIntArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            sparseIntArray2.append(this.f29747b.readInt(), this.f29747b.readInt());
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseIntArray2;
    }

    public SparseLongArray createSparseLongArray(int i10, SparseLongArray sparseLongArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseLongArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            sparseLongArray2.append(this.f29747b.readInt(), this.f29747b.readLong());
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseLongArray2;
    }

    public String createString(int i10, String str) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return str;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        String readString = this.f29747b.readString();
        this.f29747b.setDataPosition(dataPosition + b4);
        return readString;
    }

    public String[] createStringArray(int i10, String[] strArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return strArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        String[] createStringArray = this.f29747b.createStringArray();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createStringArray;
    }

    public ArrayList<String> createStringList(int i10, ArrayList<String> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<String> createStringArrayList = this.f29747b.createStringArrayList();
        this.f29747b.setDataPosition(dataPosition + b4);
        return createStringArrayList;
    }

    public SparseArray<String> createStringSparseArray(int i10, SparseArray<String> sparseArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int a10 = a(this.f29747b.readInt());
        for (int i11 = 0; i11 < a10; i11++) {
            sparseArray2.append(this.f29747b.readInt(), this.f29747b.readString());
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseArray2;
    }

    public <T> T[] createTypedArray(int i10, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return tArr;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        T[] tArr2 = (T[]) this.f29747b.createTypedArray(creator);
        this.f29747b.setDataPosition(dataPosition + b4);
        return tArr2;
    }

    public <T> ArrayList<T> createTypedList(int i10, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return arrayList;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        ArrayList<T> createTypedArrayList = this.f29747b.createTypedArrayList(creator);
        this.f29747b.setDataPosition(dataPosition + b4);
        return createTypedArrayList;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i10, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return sparseArray;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        int a10 = a(this.f29747b.readInt());
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i11 = 0; i11 < a10; i11++) {
            sparseArray2.append(this.f29747b.readInt(), this.f29747b.readInt() != 0 ? creator.createFromParcel(this.f29747b) : null);
        }
        this.f29747b.setDataPosition(dataPosition + b4);
        return sparseArray2;
    }

    public boolean readBoolean(int i10, boolean z10) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return z10;
        }
        b(i10, 4);
        return this.f29747b.readInt() != 0;
    }

    public Boolean readBooleanObject(int i10, Boolean bool) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bool;
        }
        if (b(i10) == 0) {
            return null;
        }
        a(i10, 4);
        int readInt = this.f29747b.readInt();
        if (readInt == 0) {
            return Boolean.FALSE;
        }
        if (readInt != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Bundle readBundle(int i10, Bundle bundle) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return bundle;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        Bundle readBundle = this.f29747b.readBundle();
        this.f29747b.setDataPosition(dataPosition + b4);
        return readBundle;
    }

    public byte readByte(int i10, byte b4) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return b4;
        }
        b(i10, 4);
        return (byte) this.f29747b.readInt();
    }

    public char readChar(int i10, char c4) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return c4;
        }
        b(i10, 4);
        return (char) this.f29747b.readInt();
    }

    public double readDouble(int i10, double d10) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return d10;
        }
        b(i10, 8);
        return this.f29747b.readDouble();
    }

    public Double readDoubleObject(int i10, Double d10) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return d10;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        a(b4, 8);
        return Double.valueOf(this.f29747b.readDouble());
    }

    public float readFloat(int i10, float f10) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return f10;
        }
        b(i10, 4);
        return this.f29747b.readFloat();
    }

    public Float readFloatObject(int i10, Float f10) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return f10;
        }
        if (b(i10) == 0) {
            return null;
        }
        a(i10, 4);
        return Float.valueOf(this.f29747b.readFloat());
    }

    public IBinder readIBinder(int i10, IBinder iBinder) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return iBinder;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        IBinder readStrongBinder = this.f29747b.readStrongBinder();
        this.f29747b.setDataPosition(dataPosition + b4);
        return readStrongBinder;
    }

    public int readInt(int i10, int i11) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return i11;
        }
        b(i10, 4);
        return this.f29747b.readInt();
    }

    public Integer readIntegerObject(int i10, Integer num) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return num;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        a(b4, 4);
        return Integer.valueOf(this.f29747b.readInt());
    }

    public void readList(int i10, List list, ClassLoader classLoader) {
        if (this.f29746a.containsKey(Integer.valueOf(i10))) {
            int b4 = b(i10);
            int dataPosition = this.f29747b.dataPosition();
            if (b4 != 0) {
                this.f29747b.readList(list, classLoader);
                this.f29747b.setDataPosition(dataPosition + b4);
            }
        }
    }

    public long readLong(int i10, long j10) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return j10;
        }
        b(i10, 8);
        return this.f29747b.readLong();
    }

    public Long readLongObject(int i10, Long l10) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return l10;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        a(b4, 8);
        return Long.valueOf(this.f29747b.readLong());
    }

    public <T extends Parcelable> T readParcelable(int i10, Parcelable.Creator<T> creator, T t2) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return t2;
        }
        int b4 = b(i10);
        if (b4 == 0) {
            return null;
        }
        int dataPosition = this.f29747b.dataPosition();
        T createFromParcel = creator.createFromParcel(this.f29747b);
        this.f29747b.setDataPosition(dataPosition + b4);
        return createFromParcel;
    }

    public short readShort(int i10, short s2) {
        if (!this.f29746a.containsKey(Integer.valueOf(i10))) {
            return s2;
        }
        b(i10, 4);
        return (short) this.f29747b.readInt();
    }
}
