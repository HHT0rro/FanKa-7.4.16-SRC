package com.ss.android.socialbase.downloader.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SqlDownloadCache extends ISqlDownloadCacheAidl.Stub implements ISqlDownloadCache {
    private static volatile SQLiteDatabase database;
    private volatile boolean cacheSynced;
    public ISqlCacheLoadCompleteCallbackAidl callback;
    private TableStatements chunkTableStatements;
    private TableStatements downloadTableStatements;
    private TableStatements segmentTableStatements;

    public SqlDownloadCache() {
        this(false);
    }

    private void addDownloadInfo(final DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (database == null || this.downloadTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache sqlDownloadCache = SqlDownloadCache.this;
                    sqlDownloadCache.insertDownloadInfoInner(downloadInfo, sqlDownloadCache.downloadTableStatements.getInsertStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAntiHijackDirIfNeeded(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    DownloadUtils.clearAntiHijackDir(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clearDataInSubThread() {
        try {
            safeBeginTransaction();
            database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, null, null);
            database.delete(DBDefinition.CHUNK_TABLE_NAME, null, null);
            database.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteInner(int i10, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i10);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureDataBaseInit() {
        if (database == null) {
            synchronized (SqlDownloadCache.class) {
                if (database == null) {
                    try {
                        database = DownloadDBHelper.getInstance().getWritableDatabase();
                        this.downloadTableStatements = new TableStatements(database, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.DOWNLOAD_ALL_COLUMNS, DBDefinition.DOWNLOAD_PK_COLUMNS);
                        this.chunkTableStatements = new TableStatements(database, DBDefinition.CHUNK_TABLE_NAME, DBDefinition.CHUNK_ALL_COLUMNS, DBDefinition.CHUNK_PK_COLUMNS);
                        this.segmentTableStatements = new TableStatements(database, DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.SEGMENT_ALL_COLUMNS, DBDefinition.SEGMENT_PK_COLUMNS);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertDownloadChunkInner(DownloadChunk downloadChunk, SQLiteStatement sQLiteStatement) {
        if (downloadChunk == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadChunk.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCacheFromDB(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<DownloadChunk>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || database == null) {
            return;
        }
        synchronized (database) {
            try {
                try {
                    safeBeginTransaction();
                    if (!list.isEmpty()) {
                        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_CLEAR_INVALID_TASK_ERROR)) {
                            String[] strArr = new String[list.size()];
                            for (int i10 = 0; i10 < list.size(); i10++) {
                                strArr[i10] = String.valueOf(list.get(i10));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, str, strArr);
                            database.delete(DBDefinition.CHUNK_TABLE_NAME, str, strArr);
                        } else {
                            String join = TextUtils.join(", ", list2);
                            database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id IN (?)", new String[]{join});
                            database.delete(DBDefinition.CHUNK_TABLE_NAME, "_id IN (?)", new String[]{join});
                        }
                    }
                    for (int i11 = 0; i11 < size; i11++) {
                        int keyAt = sparseArray.keyAt(i11);
                        DownloadInfo downloadInfo = sparseArray.get(keyAt);
                        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id = ?", new String[]{String.valueOf(keyAt)});
                        database.insert(DBDefinition.DOWNLOAD_TABLE_NAME, null, downloadInfo.toContentValues());
                        if (downloadInfo.getChunkCount() > 1) {
                            List<DownloadChunk> downloadChunk = getDownloadChunk(keyAt);
                            if (downloadChunk.size() > 0) {
                                database.delete(DBDefinition.CHUNK_TABLE_NAME, "_id = ?", new String[]{String.valueOf(keyAt)});
                                for (DownloadChunk downloadChunk2 : downloadChunk) {
                                    downloadChunk2.setId(downloadInfo.getId());
                                    database.insert(DBDefinition.CHUNK_TABLE_NAME, null, downloadChunk2.toContentValues());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            int id2 = sparseArray2.valueAt(i12).getId();
                            List<DownloadChunk> parseHostChunkList = DownloadUtils.parseHostChunkList(getDownloadChunk(id2));
                            if (parseHostChunkList != null && parseHostChunkList.size() > 0) {
                                sparseArray3.put(id2, parseHostChunkList);
                            }
                        }
                    }
                    database.setTransactionSuccessful();
                } finally {
                    try {
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void safeBeginTransaction() {
        database.beginTransaction();
    }

    private void safeEndTransaction() {
        try {
            if (database == null || !database.inTransaction()) {
                return;
            }
            database.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void update(final int i10, final ContentValues contentValues) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.11
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.updateInner(i10, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadChunkInner(int i10, int i11, long j10, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j10));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateDownloadInfoForCurrentThread(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!cacheExist(downloadInfo.getId())) {
                addDownloadInfo(downloadInfo);
            } else {
                TableStatements tableStatements = this.downloadTableStatements;
                if (tableStatements == null) {
                    return;
                }
                try {
                    updateDownloadInfoInner(downloadInfo, tableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void updateDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInner(int i10, ContentValues contentValues) {
        int i11 = 10;
        while (database.isDbLockedByCurrentThread() && i11 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        try {
            database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{String.valueOf(i10)});
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubDownloadChunkIndexInner(int i10, int i11, int i12, int i13, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CHUNK_INDEX, Integer.valueOf(i13));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11), Integer.toString(i12)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubDownloadChunkInner(int i10, int i11, int i12, long j10, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(j10));
                database.update(DBDefinition.CHUNK_TABLE_NAME, contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i10), Integer.toString(i11), Integer.toString(i12)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCancel(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCompleted(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        contentValues.put(DBDefinition.FIRST_SUCCESS, (Integer) 0);
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskConnected(int i10, long j10, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put(DBDefinition.TOTAL_BYTES, Long.valueOf(j10));
        contentValues.put(DBDefinition.ETAG, str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskError(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        if (j10 > 0) {
            contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        }
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskIntercept(int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPause(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPrepare(int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskProgress(int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j10));
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskRetry(int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        update(i10, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addDownloadChunk(final DownloadChunk downloadChunk) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.insertDownloadChunkInner(downloadChunk, SqlDownloadCache.this.chunkTableStatements.getInsertStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean cacheExist(int i10) {
        try {
            return getDownloadInfo(i10) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void clearData() {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.10
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.clearDataInSubThread();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getAllDownloadInfo() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadChunk> getDownloadChunk(int i10) {
        ArrayList arrayList = new ArrayList();
        ensureDataBaseInit();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.CHUNK_TABLE_NAME, "_id"), new String[]{Integer.toString(i10)});
                while (cursor.moveToNext()) {
                    arrayList.add(new DownloadChunk(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo getDownloadInfo(int i10) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "_id"), new String[]{Integer.toString(i10)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    DownloadUtils.safeClose(cursor);
                    return downloadInfo;
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                    return null;
                } catch (Throwable th3) {
                    DownloadUtils.safeClose(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfoList(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i10) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.SEGMENT_TABLE_NAME, "_id"), new String[]{Integer.toString(i10)});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex("info");
                    String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                    HashMap hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        Segment segment = new Segment(jSONArray.getJSONObject(i11));
                        hashMap.put(Long.valueOf(segment.getStartOffset()), segment);
                    }
                    DownloadUtils.safeClose(cursor);
                    return hashMap;
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    DownloadUtils.safeClose(cursor);
                    return null;
                } catch (Throwable th3) {
                    DownloadUtils.safeClose(cursor);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void init() {
        init(new SparseArray<>(), new SparseArray<>(), null);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean isDownloadCacheSyncSuccess() {
        return this.cacheSynced;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo onDownloadTaskStart(int i10) {
        return null;
    }

    public void onInitFinish(SparseArray<DownloadInfo> sparseArray, SparseArray<List<DownloadChunk>> sparseArray2) {
        try {
            HashMap sparseArrayToHashMap = DownloadUtils.sparseArrayToHashMap(sparseArray);
            HashMap sparseArrayToHashMap2 = DownloadUtils.sparseArrayToHashMap(sparseArray2);
            ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl = this.callback;
            if (iSqlCacheLoadCompleteCallbackAidl != null) {
                iSqlCacheLoadCompleteCallbackAidl.callback(sparseArrayToHashMap, sparseArrayToHashMap2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void removeAllDownloadChunk(final int i10) {
        ensureDataBaseInit();
        if (database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.deleteInner(i10, SqlDownloadCache.this.chunkTableStatements.getDeleteStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadInfo(int i10) {
        TableStatements tableStatements;
        ensureDataBaseInit();
        if (database != null && (tableStatements = this.downloadTableStatements) != null) {
            try {
                deleteInner(i10, tableStatements.getDeleteStatement());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadTaskData(final int i10) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.9
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.removeDownloadInfo(i10);
                SqlDownloadCache.this.removeAllDownloadChunk(i10);
                SqlDownloadCache.this.removeSegments(i10);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i10) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        try {
            deleteInner(i10, this.segmentTableStatements.getDeleteStatement());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        this.callback = iSqlCacheLoadCompleteCallbackAidl;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadChunks(int i10, List<DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list) {
        try {
            removeAllDownloadChunk(i10);
            if (list != null) {
                for (DownloadChunk downloadChunk : list) {
                    if (downloadChunk != null) {
                        addDownloadChunk(downloadChunk);
                        if (downloadChunk.hasChunkDivided()) {
                            Iterator<DownloadChunk> iterator2 = downloadChunk.getSubChunkList().iterator2();
                            while (iterator2.hasNext()) {
                                addDownloadChunk(iterator2.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo updateChunkCount(int i10, int i11) {
        ensureDataBaseInit();
        if (database == null) {
            return null;
        }
        int i12 = 10;
        while (database.isDbLockedByCurrentThread() && i12 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(i11));
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{Integer.toString(i10)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateDownloadChunk(final int i10, final int i11, final long j10) {
        ensureDataBaseInit();
        if (i10 == 0 || i11 < 0 || j10 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateDownloadChunkInner(i10, i11, j10, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean updateDownloadInfo(final DownloadInfo downloadInfo) {
        ensureDataBaseInit();
        if (downloadInfo == null || database == null) {
            return false;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.8
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.updateDownloadInfoForCurrentThread(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i10, Map<Long, Segment> map) {
        long currentTimeMillis = System.currentTimeMillis();
        ensureDataBaseInit();
        if (database == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> iterator2 = map.h().iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(iterator2.next().longValue())).toJson());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("json=");
        sb2.append((Object) jSONArray);
        SQLiteStatement insertOrReplaceStatement = this.segmentTableStatements.getInsertOrReplaceStatement();
        synchronized (insertOrReplaceStatement) {
            insertOrReplaceStatement.clearBindings();
            insertOrReplaceStatement.bindLong(1, i10);
            insertOrReplaceStatement.bindString(2, jSONArray.toString());
            insertOrReplaceStatement.execute();
        }
        Logger.d("SqlDownloadCache", "updateSegments cost=" + DownloadUtils.cost(currentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunk(final int i10, final int i11, final int i12, final long j10) {
        ensureDataBaseInit();
        if (i10 == 0 || i11 < 0 || i12 < 0 || j10 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkInner(i10, i11, i12, j10, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void updateSubDownloadChunkIndex(final int i10, final int i11, final int i12, final int i13) {
        ensureDataBaseInit();
        if (i10 == 0 || i12 < 0 || i13 == i11 || i13 < 0 || database == null || this.chunkTableStatements == null) {
            return;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SqlDownloadCache.this.updateSubDownloadChunkIndexInner(i10, i11, i12, i13, SqlDownloadCache.this.chunkTableStatements.getUpdateStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public SqlDownloadCache(boolean z10) {
        this.callback = null;
        if (z10) {
            this.cacheSynced = false;
            init();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i10) {
        Map<Long, Segment> segmentMap = getSegmentMap(i10);
        if (segmentMap == null || segmentMap.isEmpty()) {
            return null;
        }
        return new ArrayList<>(segmentMap.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<DownloadChunk>> sparseArray2, final SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.1
                /* JADX WARN: Code restructure failed: missing block: B:139:0x027b, code lost:
                
                    if (r0 == null) goto L88;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:144:0x0285, code lost:
                
                    if (r0 == null) goto L88;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:183:0x0340, code lost:
                
                    if (r0 == null) goto L171;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:184:0x0353, code lost:
                
                    r18.this$0.onInitFinish(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:185:0x035c, code lost:
                
                    throw r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:186:0x034b, code lost:
                
                    r0.callback();
                    r18.this$0.cacheSynced = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:191:0x0349, code lost:
                
                    if (r0 == null) goto L171;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x01a5, code lost:
                
                    if (r0 != null) goto L87;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:91:0x01b8, code lost:
                
                    r18.this$0.onInitFinish(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:92:0x0289, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:93:0x01b0, code lost:
                
                    r0.callback();
                    r18.this$0.cacheSynced = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01ae, code lost:
                
                    if (r0 == null) goto L88;
                 */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00da A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x00ca A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 887
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.AnonymousClass1.run():void");
                }
            };
            ExecutorService dBThreadExecutorService = DownloadComponentManager.getDBThreadExecutorService();
            if (dBThreadExecutorService != null) {
                dBThreadExecutorService.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
