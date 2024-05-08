package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder BUILDER = new DataHolderBuilderCreator(new String[0], null);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String[] f29674a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f29675b;

        /* renamed from: c, reason: collision with root package name */
        private final String f29676c;

        /* renamed from: d, reason: collision with root package name */
        private final HashMap<Object, Integer> f29677d;

        public DataHolder build(int i10) {
            return new DataHolder(this, i10, (Bundle) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.huawei.hms.common.data.DataHolder.Builder setDataForContentValuesHashMap(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
                r4 = this;
                java.lang.String r0 = "contentValuesHashMap cannot be null"
                com.huawei.hms.common.internal.Preconditions.checkNotNull(r5, r0)
                java.lang.String r0 = r4.f29676c
                r1 = 0
                if (r0 == 0) goto L31
                java.lang.Object r0 = r5.get(r0)
                if (r0 == 0) goto L31
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.f29677d
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L22
                int r1 = r2.intValue()
                r0 = 1
                r0 = r1
                r1 = 1
                goto L32
            L22:
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.f29677d
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r3 = r4.f29675b
                int r3 = r3.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.put(r0, r3)
            L31:
                r0 = 0
            L32:
                if (r1 == 0) goto L3f
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.f29675b
                r1.remove(r0)
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.f29675b
                r1.add(r0, r5)
                goto L44
            L3f:
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.f29675b
                r0.add(r5)
            L44:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolder.Builder.setDataForContentValuesHashMap(java.util.HashMap):com.huawei.hms.common.data.DataHolder$Builder");
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.f29674a = strArr;
            this.f29675b = new ArrayList<>();
            this.f29676c = str;
            this.f29677d = new HashMap<>();
        }

        public DataHolder build(int i10, Bundle bundle) {
            return new DataHolder(this, i10, bundle, -1);
        }

        public Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    private void checkAvailable(String str, int i10) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle != null && bundle.containsKey(str)) {
            if (isClosed()) {
                str2 = "buffer has been closed";
            } else if (i10 < 0 || i10 >= this.dataCount) {
                str2 = "row is out of index:" + i10;
            } else {
                str2 = "";
            }
        } else {
            str2 = "cannot find column: " + str;
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public static DataHolder empty(int i10) {
        return new DataHolder(BUILDER, i10, (Bundle) null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int i10;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i10 = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
                arrayList.add(window);
                i10 = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i10, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            try {
                HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());
                return new CursorWindow[0];
            } finally {
                hMSCursorWrapper.close();
            }
        }
    }

    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder, int i10, List list) {
        CursorWindow cursorWindow;
        boolean z10;
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow2 = new CursorWindow((String) null);
        cursorWindow2.setNumColumns(builder.f29674a.length);
        arrayList.add(cursorWindow2);
        for (int i11 = 0; i11 < i10; i11++) {
            try {
                if (!cursorWindow2.allocRow()) {
                    HMSLog.d(TAG, "Failed to allocate a row");
                    cursorWindow = new CursorWindow((String) null);
                    try {
                        cursorWindow.setStartPosition(i11);
                        cursorWindow.setNumColumns(builder.f29674a.length);
                        if (!cursorWindow.allocRow()) {
                            HMSLog.e(TAG, "Failed to retry to allocate a row");
                            return arrayList;
                        }
                        arrayList.add(cursorWindow);
                        cursorWindow2 = cursorWindow;
                    } catch (RuntimeException unused) {
                        Iterator<CursorWindow> iterator2 = arrayList.iterator2();
                        while (iterator2.hasNext()) {
                            iterator2.next().close();
                        }
                        HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
                        cursorWindow2 = cursorWindow;
                    }
                }
                HashMap hashMap = (HashMap) list.get(i11);
                z10 = true;
                for (int i12 = 0; i12 < builder.f29674a.length && (z10 = putValue(cursorWindow2, hashMap.get(builder.f29674a[i12]), i11, i12)); i12++) {
                }
            } catch (RuntimeException unused2) {
                cursorWindow = cursorWindow2;
            }
            if (!z10) {
                HMSLog.d(TAG, "fail to put data for row " + i11);
                cursorWindow2.freeLastRow();
                CursorWindow cursorWindow3 = new CursorWindow((String) null);
                cursorWindow3.setStartPosition(i11);
                cursorWindow3.setNumColumns(builder.f29674a.length);
                arrayList.add(cursorWindow3);
                break;
            }
            continue;
        }
        return arrayList;
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i10, int i11) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i10 < i11 && hMSCursorWrapper.moveToPosition(i10)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i10);
                hMSCursorWrapper.fillWindow(i10, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i10 = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i10, int i11) throws IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i10, i11);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i10, i11);
        }
        if (obj instanceof Integer) {
            return cursorWindow.putLong(((Integer) obj).intValue(), i10, i11);
        }
        if (obj instanceof Long) {
            return cursorWindow.putLong(((Long) obj).longValue(), i10, i11);
        }
        if (obj instanceof Float) {
            return cursorWindow.putDouble(((Float) obj).floatValue(), i10, i11);
        }
        if (obj instanceof Double) {
            return cursorWindow.putDouble(((Double) obj).doubleValue(), i10, i11);
        }
        if (obj instanceof String) {
            return cursorWindow.putString((String) obj, i10, i11);
        }
        if (obj instanceof byte[]) {
            return cursorWindow.putBlob((byte[]) obj, i10, i11);
        }
        throw new IllegalArgumentException("unsupported type for column: " + obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!this.mClosed) {
            for (CursorWindow cursorWindow : this.cursorWindows) {
                cursorWindow.close();
            }
            this.mClosed = true;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        String[] strArr = this.columns;
        int i10 = 0;
        if (strArr != null && strArr.length != 0) {
            int i11 = 0;
            while (true) {
                String[] strArr2 = this.columns;
                if (i11 >= strArr2.length) {
                    break;
                }
                this.columnsBundle.putInt(strArr2[i11], i11);
                i11++;
            }
            CursorWindow[] cursorWindowArr = this.cursorWindows;
            if (cursorWindowArr != null && cursorWindowArr.length != 0) {
                this.perCursorCounts = new int[cursorWindowArr.length];
                int i12 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr2 = this.cursorWindows;
                    if (i10 < cursorWindowArr2.length) {
                        this.perCursorCounts[i10] = i12;
                        i12 = cursorWindowArr2[i10].getStartPosition() + this.cursorWindows[i10].getNumRows();
                        i10++;
                    } else {
                        this.dataCount = i12;
                        return;
                    }
                }
            } else {
                this.dataCount = 0;
            }
        } else {
            this.dataCount = 0;
        }
    }

    public final void copyToBuffer(String str, int i10, int i11, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i10);
        this.cursorWindows[i11].copyStringToBuffer(i10, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    public final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Object getValue(String str, int i10, int i11, String str2) {
        str2.hashCode();
        char c4 = 65535;
        switch (str2.hashCode()) {
            case -1092271849:
                if (str2.equals(TYPE_FLOAT)) {
                    c4 = 0;
                    break;
                }
                break;
            case -870070237:
                if (str2.equals(TYPE_BOOLEAN)) {
                    c4 = 1;
                    break;
                }
                break;
            case -675993238:
                if (str2.equals(TYPE_INT)) {
                    c4 = 2;
                    break;
                }
                break;
            case 445002870:
                if (str2.equals(TYPE_DOUBLE)) {
                    c4 = 3;
                    break;
                }
                break;
            case 519136353:
                if (str2.equals(TYPE_LONG)) {
                    c4 = 4;
                    break;
                }
                break;
            case 878975158:
                if (str2.equals(TYPE_STRING)) {
                    c4 = 5;
                    break;
                }
                break;
            case 1300508295:
                if (str2.equals(TYPE_BYTE_ARRAY)) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                checkAvailable(str, i10);
                return Float.valueOf(this.cursorWindows[i11].getFloat(i10, this.columnsBundle.getInt(str)));
            case 1:
                checkAvailable(str, i10);
                return Boolean.valueOf(this.cursorWindows[i11].getLong(i10, this.columnsBundle.getInt(str)) == 1);
            case 2:
                checkAvailable(str, i10);
                return Integer.valueOf(this.cursorWindows[i11].getInt(i10, this.columnsBundle.getInt(str)));
            case 3:
                checkAvailable(str, i10);
                return Double.valueOf(this.cursorWindows[i11].getDouble(i10, this.columnsBundle.getInt(str)));
            case 4:
                checkAvailable(str, i10);
                return Long.valueOf(this.cursorWindows[i11].getLong(i10, this.columnsBundle.getInt(str)));
            case 5:
                checkAvailable(str, i10);
                return this.cursorWindows[i11].getString(i10, this.columnsBundle.getInt(str));
            case 6:
                checkAvailable(str, i10);
                return this.cursorWindows[i11].getBlob(i10, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i10) {
        int[] iArr;
        int i11 = 0;
        Preconditions.checkArgument(i10 >= 0 || i10 < this.dataCount, "rowIndex is out of index:" + i10);
        while (true) {
            iArr = this.perCursorCounts;
            if (i11 >= iArr.length) {
                break;
            }
            if (i10 < iArr[i11]) {
                i11--;
                break;
            }
            i11++;
        }
        return i11 == iArr.length ? i11 - 1 : i11;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i10, int i11) {
        checkAvailable(str, i10);
        return this.cursorWindows[i11].getType(i10, this.columnsBundle.getInt(str)) == 0;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i10 & 1) != 0) {
            close();
        }
    }

    public DataHolder(int i10, String[] strArr, CursorWindow[] cursorWindowArr, int i11, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i10;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i11;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i10, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i10;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private static CursorWindow[] getCursorWindows(Builder builder, int i10) {
        if (builder.f29674a.length == 0) {
            return new CursorWindow[0];
        }
        if (i10 < 0 || i10 >= builder.f29675b.size()) {
            i10 = builder.f29675b.size();
        }
        ArrayList<CursorWindow> iterCursorWindow = iterCursorWindow(builder, i10, builder.f29675b.subList(0, i10));
        return (CursorWindow[]) iterCursorWindow.toArray(new CursorWindow[iterCursorWindow.size()]);
    }

    private DataHolder(HMSCursorWrapper hMSCursorWrapper, int i10, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i10, bundle);
    }

    public DataHolder(Cursor cursor, int i10, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i10, bundle);
    }

    private DataHolder(Builder builder, int i10, Bundle bundle) {
        this(builder.f29674a, getCursorWindows(builder, -1), i10, (Bundle) null);
    }

    private DataHolder(Builder builder, int i10, Bundle bundle, int i11) {
        this(builder.f29674a, getCursorWindows(builder, -1), i10, bundle);
    }
}
