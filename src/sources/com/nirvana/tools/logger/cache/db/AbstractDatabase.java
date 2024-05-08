package com.nirvana.tools.logger.cache.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.nirvana.tools.logger.model.ACMRecord;
import com.nirvana.tools.logger.utils.ConsoleLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbstractDatabase<T extends ACMRecord> {
    public static final int DEFAULT_LIMIT = 5242880;
    private static final String TAG = "com.nirvana.tools.logger.cache.db.AbstractDatabase";
    private SQLiteDatabase mDatabase;
    private DBHelper mDbHelper;
    public String mTableName;
    private Semaphore semaphore = new Semaphore(1);

    public AbstractDatabase(String str, DBHelper dBHelper) {
        this.mTableName = str;
        this.mDbHelper = dBHelper;
        setMaxSizeLog(5242880L);
    }

    private <G> void numberList2StringArray(List<G> list, String[] strArr) {
        if (list.size() == strArr.length) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                strArr[i10] = String.valueOf(list.get(i10));
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("NumberList size(");
        sb2.append(list.size());
        sb2.append(") not equals results length[");
        sb2.append(strArr.length);
        sb2.append("]");
    }

    private long parseIdFromCursor(Cursor cursor) {
        if (cursor == null) {
            return -1L;
        }
        return cursor.getLong(cursor.getColumnIndex("_id"));
    }

    public void close() {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.mDatabase = null;
        }
    }

    public String contactIds(long j10) {
        if (j10 <= 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder("(");
        do {
            sb2.append("?,");
            j10--;
        } while (j10 > 0);
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.append(")");
        return sb2.toString();
    }

    public synchronized boolean deleteOldest(SQLiteDatabase sQLiteDatabase, int i10) throws DbException {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor query = sQLiteDatabase.query(this.mTableName, new String[]{"_id"}, null, null, null, null, "timestamp ASC", i10 > 0 ? String.valueOf(i10) : null);
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                Long valueOf = Long.valueOf(parseIdFromCursor(query));
                if (valueOf.longValue() != -1) {
                    arrayList.add(valueOf);
                }
            }
            query.close();
            ConsoleLogUtils.logcatV(TAG, "delete oldest: escape=" + (System.currentTimeMillis() - currentTimeMillis));
            if (!arrayList.isEmpty()) {
                return deleteRecordsById(sQLiteDatabase, arrayList);
            }
        } catch (Exception e2) {
            new DbException("Delete oldest exception!", e2);
        }
        return false;
    }

    public synchronized boolean deleteRecords(List<T> list) throws DbException {
        if (list != null) {
            try {
                try {
                    if (!list.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> iterator2 = list.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(Long.valueOf(iterator2.next().getId()));
                        }
                        return deleteRecordsById(getWriteDatabase(), arrayList);
                    }
                } catch (DbException e2) {
                    throw e2;
                }
            } finally {
                close();
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized boolean deleteRecordsById(SQLiteDatabase sQLiteDatabase, List<Long> list) throws DbException {
        if (list != 0) {
            try {
                if (!list.isEmpty()) {
                    String str = TAG;
                    ConsoleLogUtils.logcatV(str, "delete: size=" + list.size());
                    StringBuilder sb2 = new StringBuilder("_id in ");
                    sb2.append(contactIds((long) list.size()));
                    ConsoleLogUtils.logcatV(str, "delete: selection=" + ((Object) sb2));
                    String[] strArr = new String[list.size()];
                    numberList2StringArray(list, strArr);
                    int delete = sQLiteDatabase.delete(this.mTableName, sb2.toString(), strArr);
                    ConsoleLogUtils.logcatV(str, "delete: count=" + delete);
                    return delete == list.size();
                }
            } catch (Exception e2) {
                throw new DbException("Delete records failed!", e2);
            }
        }
        return true;
    }

    public abstract ContentValues getContentValuesByRecord(T t2);

    public int getCount(SQLiteDatabase sQLiteDatabase) {
        return (int) DatabaseUtils.longForQuery(sQLiteDatabase, String.format("SELECT COUNT(%s) FROM %s", "_id", this.mTableName), null);
    }

    public synchronized long getCurrentSize() {
        long pageSize;
        try {
            pageSize = getReadDatabase().getPageSize() * DatabaseUtils.longForQuery(this.mDatabase, "PRAGMA page_count;", null);
            close();
        } catch (Throwable unused) {
            close();
            return -1L;
        }
        return pageSize;
    }

    public synchronized long getMaxSizeLog() {
        long maximumSize;
        try {
            maximumSize = getReadDatabase().getMaximumSize();
            close();
        } catch (Throwable unused) {
            close();
            return -1L;
        }
        return maximumSize;
    }

    public SQLiteDatabase getReadDatabase() {
        if (this.mDatabase == null) {
            this.mDatabase = this.mDbHelper.getReadableDatabase();
        }
        return this.mDatabase;
    }

    public synchronized SQLiteDatabase getWriteDatabase() {
        if (this.mDatabase == null) {
            this.mDatabase = this.mDbHelper.getWritableDatabase();
        }
        return this.mDatabase;
    }

    public synchronized boolean insert(T t2) throws DbException {
        long j10 = -1;
        if (t2 == null) {
            close();
            return false;
        }
        try {
            try {
                if (getCurrentSize() >= 5242880) {
                    ConsoleLogUtils.logcatV(TAG, "Table size is limited, clear half of data!");
                    deleteOldest(getWriteDatabase(), getCount(getWriteDatabase()) / 2);
                }
                ContentValues contentValuesByRecord = getContentValuesByRecord(t2);
                j10 = getWriteDatabase().insert(this.mTableName, null, contentValuesByRecord);
                if (j10 < 0 && getCount(getWriteDatabase()) > 0) {
                    deleteOldest(getWriteDatabase(), getCount(getWriteDatabase()) / 2);
                    j10 = getWriteDatabase().insert(this.mTableName, null, contentValuesByRecord);
                }
                ConsoleLogUtils.logcatV(TAG, "insert: id=" + j10);
                close();
                return j10 >= 0;
            } catch (Exception e2) {
                throw new DbException("Insert record failed!", e2);
            }
        } catch (Throwable unused) {
            close();
            return j10 >= 0;
        }
    }

    public synchronized boolean insertList(List<T> list) throws DbException {
        boolean z10 = true;
        if (list != null) {
            long j10 = -1;
            try {
                try {
                    if (list.size() != 0) {
                        if (getCurrentSize() >= 5242880) {
                            ConsoleLogUtils.logcatV(TAG, "Table size is limited, clear half of data!");
                            deleteOldest(getWriteDatabase(), getCount(getWriteDatabase()) / 2);
                        }
                        this.semaphore.acquire();
                        String str = TAG;
                        ConsoleLogUtils.logcatV(str, "beginTransaction");
                        getWriteDatabase().beginTransaction();
                        StringBuilder sb2 = new StringBuilder("writedatabase success  ");
                        sb2.append(this.mDatabase == null);
                        ConsoleLogUtils.logcatV(str, sb2.toString());
                        Iterator<T> iterator2 = list.iterator2();
                        while (iterator2.hasNext()) {
                            ContentValues contentValuesByRecord = getContentValuesByRecord(iterator2.next());
                            String str2 = TAG;
                            ConsoleLogUtils.logcatV(str2, "ContentValues");
                            j10 = getWriteDatabase().insert(this.mTableName, null, contentValuesByRecord);
                            ConsoleLogUtils.logcatV(str2, "insert");
                            if (j10 < 0 && getCount(getWriteDatabase()) > 0) {
                                deleteOldest(getWriteDatabase(), getCount(getWriteDatabase()) / 2);
                                j10 = getWriteDatabase().insert(this.mTableName, null, contentValuesByRecord);
                            }
                            ConsoleLogUtils.logcatV(str2, "insert: id=" + j10);
                        }
                        getWriteDatabase().setTransactionSuccessful();
                        String str3 = TAG;
                        StringBuilder sb3 = new StringBuilder("final ");
                        sb3.append(getWriteDatabase() == null);
                        ConsoleLogUtils.logcatV(str3, sb3.toString());
                        this.mDatabase.endTransaction();
                        this.semaphore.release();
                        close();
                        return j10 >= 0;
                    }
                } catch (Exception e2) {
                    throw new DbException("Insert record failed!", e2);
                }
            } catch (Throwable unused) {
                String str4 = TAG;
                StringBuilder sb4 = new StringBuilder("final ");
                sb4.append(getWriteDatabase() == null);
                ConsoleLogUtils.logcatV(str4, sb4.toString());
                this.mDatabase.endTransaction();
                this.semaphore.release();
                close();
                return j10 >= 0;
            }
        }
        String str5 = TAG;
        StringBuilder sb5 = new StringBuilder("final ");
        if (getWriteDatabase() != null) {
            z10 = false;
        }
        sb5.append(z10);
        ConsoleLogUtils.logcatV(str5, sb5.toString());
        this.mDatabase.endTransaction();
        this.semaphore.release();
        close();
        return false;
    }

    public abstract T parseDataFromCursor(Cursor cursor);

    public synchronized List<T> query(int i10, int i11, String str) {
        String str2;
        String[] strArr;
        ArrayList arrayList;
        if (i11 >= 0) {
            try {
                str2 = "upload_flag = ?";
                strArr = new String[]{String.valueOf(i11)};
            } catch (Throwable unused) {
                close();
                return null;
            }
        } else {
            str2 = null;
            strArr = null;
        }
        ConsoleLogUtils.logcatV(TAG, "query: selection=" + str2);
        String valueOf = i10 > 0 ? String.valueOf(i10) : "";
        arrayList = new ArrayList();
        Cursor query = getReadDatabase().query(this.mTableName, null, str2, strArr, null, null, str, valueOf);
        while (query.moveToNext()) {
            T parseDataFromCursor = parseDataFromCursor(query);
            if (parseDataFromCursor != null) {
                arrayList.add(parseDataFromCursor);
            }
        }
        query.close();
        ConsoleLogUtils.logcatV(TAG, "query: result=" + ((Object) arrayList) + ", size=" + arrayList.size());
        close();
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: all -> 0x00d5, TryCatch #0 {all -> 0x00d5, blocks: (B:4:0x0002, B:10:0x0026, B:11:0x003b, B:12:0x0063, B:14:0x0078, B:15:0x007c, B:16:0x009e, B:18:0x00a4, B:21:0x00aa, B:26:0x00ae, B:33:0x0041, B:36:0x0054), top: B:3:0x0002, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a4 A[Catch: all -> 0x00d5, TryCatch #0 {all -> 0x00d5, blocks: (B:4:0x0002, B:10:0x0026, B:11:0x003b, B:12:0x0063, B:14:0x0078, B:15:0x007c, B:16:0x009e, B:18:0x00a4, B:21:0x00aa, B:26:0x00ae, B:33:0x0041, B:36:0x0054), top: B:3:0x0002, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<T> queryFailed(long r14, long r16, int r18) {
        /*
            r13 = this;
            r1 = r13
            monitor-enter(r13)
            java.lang.String r0 = ""
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r2.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ld5
            r3.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "1"
            r3.add(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "upload_flag = ?"
            r2.append(r4)     // Catch: java.lang.Throwable -> Ld5
            r4 = 0
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r6 < 0) goto L3f
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 < 0) goto L3f
            int r7 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r7 < 0) goto L3f
            java.lang.String r4 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> Ld5
            r3.add(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = java.lang.String.valueOf(r16)     // Catch: java.lang.Throwable -> Ld5
            r3.add(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = " and _id"
            r2.append(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = " between ? and ?"
        L3b:
            r2.append(r4)     // Catch: java.lang.Throwable -> Ld5
            goto L63
        L3f:
            if (r6 < 0) goto L50
            java.lang.String r4 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> Ld5
            r3.add(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = " and _id"
            r2.append(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = " >= ?"
            goto L3b
        L50:
            int r6 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r6 < 0) goto L63
            java.lang.String r4 = java.lang.String.valueOf(r16)     // Catch: java.lang.Throwable -> Ld5
            r3.add(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = " and _id"
            r2.append(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = " <= ?"
            goto L3b
        L63:
            java.lang.String r4 = com.nirvana.tools.logger.cache.db.AbstractDatabase.TAG     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = "query: selection="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Ld5
            r5.append(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Ld5
            com.nirvana.tools.logger.utils.ConsoleLogUtils.logcatV(r4, r5)     // Catch: java.lang.Throwable -> Ld5
            if (r18 <= 0) goto L7c
            java.lang.String r0 = java.lang.String.valueOf(r18)     // Catch: java.lang.Throwable -> Ld5
        L7c:
            r12 = r0
            int r0 = r3.size()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Ld5
            r3.toArray(r8)     // Catch: java.lang.Throwable -> Ld5
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ld5
            r0.<init>()     // Catch: java.lang.Throwable -> Ld5
            android.database.sqlite.SQLiteDatabase r4 = r13.getReadDatabase()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r5 = r1.mTableName     // Catch: java.lang.Throwable -> Ld5
            r6 = 0
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> Ld5
            r9 = 0
            r10 = 0
            java.lang.String r11 = "_id ASC"
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Ld5
        L9e:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> Ld5
            if (r3 == 0) goto Lae
            com.nirvana.tools.logger.model.ACMRecord r3 = r13.parseDataFromCursor(r2)     // Catch: java.lang.Throwable -> Ld5
            if (r3 == 0) goto L9e
            r0.add(r3)     // Catch: java.lang.Throwable -> Ld5
            goto L9e
        Lae:
            r2.close()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r2 = com.nirvana.tools.logger.cache.db.AbstractDatabase.TAG     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "query: result="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Ld5
            r3.append(r0)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = ", size="
            r3.append(r4)     // Catch: java.lang.Throwable -> Ld5
            int r4 = r0.size()     // Catch: java.lang.Throwable -> Ld5
            r3.append(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Ld5
            com.nirvana.tools.logger.utils.ConsoleLogUtils.logcatV(r2, r3)     // Catch: java.lang.Throwable -> Ld5
            r13.close()     // Catch: java.lang.Throwable -> Ldb
            monitor-exit(r13)
            return r0
        Ld5:
            r13.close()     // Catch: java.lang.Throwable -> Ldb
            r0 = 0
            monitor-exit(r13)
            return r0
        Ldb:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nirvana.tools.logger.cache.db.AbstractDatabase.queryFailed(long, long, int):java.util.List");
    }

    public synchronized long queryFailedMaxId() {
        long j10;
        try {
            Cursor query = getReadDatabase().query(true, this.mTableName, new String[]{"_id"}, "upload_flag=?", new String[]{"1"}, null, null, "_id desc", null);
            query.moveToFirst();
            j10 = query.getLong(0);
            query.close();
            close();
        } catch (Throwable unused) {
            close();
            return -1L;
        }
        return j10;
    }

    public synchronized void setMaxSizeLog(long j10) {
        try {
            try {
                getWriteDatabase().setMaximumSize(j10);
            } finally {
                close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void updateUploadCount(List<T> list, long j10, int i10) throws DbException {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        arrayList.add(Long.valueOf(iterator2.next().getId()));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(String.valueOf(j10));
                    arrayList2.add(String.valueOf(i10));
                    arrayList2.add("1");
                    Iterator<E> iterator22 = arrayList.iterator2();
                    while (iterator22.hasNext()) {
                        arrayList2.add(String.valueOf((Long) iterator22.next()));
                    }
                    String[] strArr = new String[arrayList2.size()];
                    String format = String.format("Update %s SET %s=?, %s=?, %s= %s+? where %s in %s", this.mTableName, "timestamp", DBHelpTool.RecordEntry.COLUMN_UPLOAD_FLAG, DBHelpTool.RecordEntry.COLUMN_UPLOAD_COUNT, DBHelpTool.RecordEntry.COLUMN_UPLOAD_COUNT, "_id", contactIds(arrayList.size()));
                    arrayList2.toArray(strArr);
                    getWriteDatabase().execSQL(format, strArr);
                }
            } finally {
            }
        }
    }
}
