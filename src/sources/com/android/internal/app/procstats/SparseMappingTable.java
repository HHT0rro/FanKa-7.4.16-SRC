package com.android.internal.app.procstats;

import android.os.Build;
import android.os.Parcel;
import android.util.EventLog;
import android.util.Slog;
import com.alipay.sdk.util.i;
import com.android.internal.util.GrowingArrayUtils;
import java.util.ArrayList;
import java.util.zip.ZipUtils;
import libcore.util.EmptyArray;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SparseMappingTable {
    private static final int ARRAY_MASK = 255;
    private static final int ARRAY_SHIFT = 8;
    public static final int ARRAY_SIZE = 4096;
    private static final int ID_MASK = 255;
    private static final int ID_SHIFT = 0;
    private static final int INDEX_MASK = 65535;
    private static final int INDEX_SHIFT = 16;
    public static final int INVALID_KEY = -1;
    private static final String TAG = "SparseMappingTable";
    private final ArrayList<long[]> mLongs;
    private int mNextIndex;
    private int mSequence;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Table {
        private SparseMappingTable mParent;
        private int mSequence;
        private int mSize;
        private int[] mTable;

        public Table(SparseMappingTable parent) {
            this.mSequence = 1;
            this.mParent = parent;
            this.mSequence = parent.mSequence;
        }

        public void copyFrom(Table copyFrom, int valueCount) {
            this.mTable = null;
            this.mSize = 0;
            int N = copyFrom.getKeyCount();
            for (int i10 = 0; i10 < N; i10++) {
                int theirKey = copyFrom.getKeyAt(i10);
                long[] theirLongs = (long[]) copyFrom.mParent.mLongs.get(SparseMappingTable.getArrayFromKey(theirKey));
                byte id2 = SparseMappingTable.getIdFromKey(theirKey);
                int myKey = getOrAddKey(id2, valueCount);
                long[] myLongs = (long[]) this.mParent.mLongs.get(SparseMappingTable.getArrayFromKey(myKey));
                System.arraycopy((Object) theirLongs, SparseMappingTable.getIndexFromKey(theirKey), (Object) myLongs, SparseMappingTable.getIndexFromKey(myKey), valueCount);
            }
        }

        public int getOrAddKey(byte id2, int count) {
            assertConsistency();
            int idx = binarySearch(id2);
            if (idx >= 0) {
                return this.mTable[idx];
            }
            ArrayList<long[]> list = this.mParent.mLongs;
            int whichArray = list.size() - 1;
            long[] array = list.get(whichArray);
            if (this.mParent.mNextIndex + count > array.length) {
                long[] array2 = new long[4096];
                list.add(array2);
                whichArray++;
                this.mParent.mNextIndex = 0;
            }
            int key = (whichArray << 8) | (this.mParent.mNextIndex << 16) | (id2 << 0);
            this.mParent.mNextIndex += count;
            int[] iArr = this.mTable;
            if (iArr == null) {
                iArr = EmptyArray.INT;
            }
            this.mTable = GrowingArrayUtils.insert(iArr, this.mSize, ~idx, key);
            this.mSize++;
            return key;
        }

        public int getKey(byte id2) {
            assertConsistency();
            int idx = binarySearch(id2);
            if (idx >= 0) {
                return this.mTable[idx];
            }
            return -1;
        }

        public long getValue(int key) {
            return getValue(key, 0);
        }

        public long getValue(int key, int index) {
            assertConsistency();
            try {
                long[] array = (long[]) this.mParent.mLongs.get(SparseMappingTable.getArrayFromKey(key));
                return array[SparseMappingTable.getIndexFromKey(key) + index];
            } catch (IndexOutOfBoundsException ex) {
                SparseMappingTable.logOrThrow("key=0x" + Integer.toHexString(key) + " index=" + index + " -- " + dumpInternalState(), ex);
                return 0L;
            }
        }

        public long getValueForId(byte id2) {
            return getValueForId(id2, 0);
        }

        public long getValueForId(byte id2, int index) {
            assertConsistency();
            int idx = binarySearch(id2);
            if (idx < 0) {
                return 0L;
            }
            int key = this.mTable[idx];
            try {
                long[] array = (long[]) this.mParent.mLongs.get(SparseMappingTable.getArrayFromKey(key));
                return array[SparseMappingTable.getIndexFromKey(key) + index];
            } catch (IndexOutOfBoundsException ex) {
                SparseMappingTable.logOrThrow("id=0x" + Integer.toHexString(id2) + " idx=" + idx + " key=0x" + Integer.toHexString(key) + " index=" + index + " -- " + dumpInternalState(), ex);
                return 0L;
            }
        }

        public long[] getArrayForKey(int key) {
            assertConsistency();
            int arrayIndex = SparseMappingTable.getArrayFromKey(key);
            int N = this.mParent.mLongs.size();
            if (arrayIndex >= N) {
                Slog.w(SparseMappingTable.TAG, "Invalid key at index " + arrayIndex + " -- " + dumpInternalState());
                return (long[]) this.mParent.mLongs.get(N - 1);
            }
            return (long[]) this.mParent.mLongs.get(SparseMappingTable.getArrayFromKey(key));
        }

        public void setValue(int key, long value) {
            setValue(key, 0, value);
        }

        public void setValue(int key, int index, long value) {
            assertConsistency();
            if (value < 0) {
                SparseMappingTable.logOrThrow("can't store negative values key=0x" + Integer.toHexString(key) + " index=" + index + " value=" + value + " -- " + dumpInternalState());
                return;
            }
            try {
                long[] array = (long[]) this.mParent.mLongs.get(SparseMappingTable.getArrayFromKey(key));
                array[SparseMappingTable.getIndexFromKey(key) + index] = value;
            } catch (IndexOutOfBoundsException ex) {
                SparseMappingTable.logOrThrow("key=0x" + Integer.toHexString(key) + " index=" + index + " value=" + value + " -- " + dumpInternalState(), ex);
            }
        }

        public void resetTable() {
            this.mTable = null;
            this.mSize = 0;
            this.mSequence = this.mParent.mSequence;
        }

        public void writeToParcel(Parcel out) {
            out.writeInt(this.mSequence);
            out.writeInt(this.mSize);
            for (int i10 = 0; i10 < this.mSize; i10++) {
                out.writeInt(this.mTable[i10]);
            }
        }

        public boolean readFromParcel(Parcel in) {
            this.mSequence = in.readInt();
            int readInt = in.readInt();
            this.mSize = readInt;
            if (readInt != 0) {
                this.mTable = new int[readInt];
                for (int i10 = 0; i10 < this.mSize; i10++) {
                    this.mTable[i10] = in.readInt();
                }
            } else {
                this.mTable = null;
            }
            if (validateKeys(true)) {
                return true;
            }
            this.mSize = 0;
            this.mTable = null;
            return false;
        }

        public int getKeyCount() {
            return this.mSize;
        }

        public int getKeyAt(int i10) {
            return this.mTable[i10];
        }

        private void assertConsistency() {
        }

        private int binarySearch(byte id2) {
            int lo = 0;
            int hi = this.mSize - 1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                byte midId = (byte) ((this.mTable[mid] >> 0) & 255);
                if (midId < id2) {
                    lo = mid + 1;
                } else if (midId > id2) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            }
            return ~lo;
        }

        private boolean validateKeys(boolean log) {
            ArrayList<long[]> longs = this.mParent.mLongs;
            int longsSize = longs.size();
            int N = this.mSize;
            for (int i10 = 0; i10 < N; i10++) {
                int key = this.mTable[i10];
                int arrayIndex = SparseMappingTable.getArrayFromKey(key);
                int index = SparseMappingTable.getIndexFromKey(key);
                if (arrayIndex >= longsSize || index >= longs.get(arrayIndex).length) {
                    if (log) {
                        Slog.w(SparseMappingTable.TAG, "Invalid stats at index " + i10 + " -- " + dumpInternalState());
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }

        public String dumpInternalState() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SparseMappingTable.Table{mSequence=");
            sb2.append(this.mSequence);
            sb2.append(" mParent.mSequence=");
            sb2.append(this.mParent.mSequence);
            sb2.append(" mParent.mLongs.size()=");
            sb2.append(this.mParent.mLongs.size());
            sb2.append(" mSize=");
            sb2.append(this.mSize);
            sb2.append(" mTable=");
            int[] iArr = this.mTable;
            if (iArr == null) {
                sb2.append("null");
            } else {
                int N = iArr.length;
                sb2.append('[');
                for (int i10 = 0; i10 < N; i10++) {
                    int key = this.mTable[i10];
                    sb2.append("0x");
                    sb2.append(Integer.toHexString((key >> 0) & 255));
                    sb2.append("/0x");
                    sb2.append(Integer.toHexString((key >> 8) & 255));
                    sb2.append("/0x");
                    sb2.append(Integer.toHexString((key >> 16) & 65535));
                    if (i10 != N - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append(']');
            }
            sb2.append(" clazz=");
            sb2.append(getClass().getName());
            sb2.append('}');
            return sb2.toString();
        }
    }

    public SparseMappingTable() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        this.mLongs = arrayList;
        arrayList.add(new long[4096]);
    }

    public void reset() {
        this.mLongs.clear();
        this.mLongs.add(new long[4096]);
        this.mNextIndex = 0;
        this.mSequence++;
    }

    public void writeToParcel(Parcel out) {
        out.writeInt(this.mSequence);
        out.writeInt(this.mNextIndex);
        int N = this.mLongs.size();
        out.writeInt(N);
        for (int i10 = 0; i10 < N - 1; i10++) {
            long[] array = this.mLongs.get(i10);
            out.writeInt(array.length);
            writeCompactedLongArray(out, array, array.length);
        }
        long[] lastLongs = this.mLongs.get(N - 1);
        out.writeInt(this.mNextIndex);
        writeCompactedLongArray(out, lastLongs, this.mNextIndex);
    }

    public void readFromParcel(Parcel in) {
        this.mSequence = in.readInt();
        this.mNextIndex = in.readInt();
        this.mLongs.clear();
        int N = in.readInt();
        for (int i10 = 0; i10 < N; i10++) {
            int size = in.readInt();
            long[] array = new long[size];
            readCompactedLongArray(in, array, size);
            this.mLongs.add(array);
        }
        if (N > 0 && this.mLongs.get(N - 1).length != this.mNextIndex) {
            EventLog.writeEvent(1397638484, "73252178", -1, "");
            throw new IllegalStateException("Expected array of length " + this.mNextIndex + " but was " + this.mLongs.get(N - 1).length);
        }
    }

    public String dumpInternalState(boolean includeData) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SparseMappingTable{");
        sb2.append("mSequence=");
        sb2.append(this.mSequence);
        sb2.append(" mNextIndex=");
        sb2.append(this.mNextIndex);
        sb2.append(" mLongs.size=");
        int N = this.mLongs.size();
        sb2.append(N);
        sb2.append("\n");
        if (includeData) {
            for (int i10 = 0; i10 < N; i10++) {
                long[] array = this.mLongs.get(i10);
                for (int j10 = 0; j10 < array.length && (i10 != N - 1 || j10 != this.mNextIndex); j10++) {
                    sb2.append(String.format(" %4d %d 0x%016x %-19d\n", Integer.valueOf(i10), Integer.valueOf(j10), Long.valueOf(array[j10]), Long.valueOf(array[j10])));
                }
            }
        }
        sb2.append(i.f4738d);
        return sb2.toString();
    }

    private static void writeCompactedLongArray(Parcel out, long[] array, int num) {
        for (int i10 = 0; i10 < num; i10++) {
            long val = array[i10];
            if (val < 0) {
                Slog.w(TAG, "Time val negative: " + val);
                val = 0;
            }
            if (val > ZipUtils.UPPER_UNIXTIME_BOUND) {
                int top = ~((int) (ZipUtils.UPPER_UNIXTIME_BOUND & (val >> 32)));
                int bottom = (int) (4294967295L & val);
                out.writeInt(top);
                out.writeInt(bottom);
            } else {
                out.writeInt((int) val);
            }
        }
    }

    private static void readCompactedLongArray(Parcel in, long[] array, int num) {
        int alen = array.length;
        if (num > alen) {
            logOrThrow("bad array lengths: got " + num + " array is " + alen);
            return;
        }
        int i10 = 0;
        while (i10 < num) {
            int val = in.readInt();
            if (val >= 0) {
                array[i10] = val;
            } else {
                int bottom = in.readInt();
                array[i10] = ((~val) << 32) | bottom;
            }
            i10++;
        }
        while (i10 < alen) {
            array[i10] = 0;
            i10++;
        }
    }

    public static byte getIdFromKey(int key) {
        return (byte) ((key >> 0) & 255);
    }

    public static int getArrayFromKey(int key) {
        return (key >> 8) & 255;
    }

    public static int getIndexFromKey(int key) {
        return (key >> 16) & 65535;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logOrThrow(String message) {
        logOrThrow(message, new RuntimeException("Stack trace"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logOrThrow(String message, Throwable th) {
        Slog.e(TAG, message, th);
        boolean z10 = Build.IS_ENG;
    }
}
