package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alimm.tanx.core.view.player.cache.videocache.Preconditions;
import com.alimm.tanx.core.view.player.cache.videocache.SourceInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_URL = "url";
    public static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    public static final String TABLE = "SourceInfo";
    public static final String COLUMN_LENGTH = "length";
    public static final String COLUMN_MIME = "mime";
    public static final String[] ALL_COLUMNS = {"_id", "url", COLUMN_LENGTH, COLUMN_MIME};

    public DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        Preconditions.checkNotNull(context);
    }

    private SourceInfo convert(Cursor cursor) {
        return new SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MIME)));
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) {
        Throwable th;
        Cursor cursor;
        Preconditions.checkNotNull(str);
        SourceInfo sourceInfo = null;
        try {
            cursor = getReadableDatabase().query(TABLE, ALL_COLUMNS, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        sourceInfo = convert(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return sourceInfo;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Preconditions.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(CREATE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
        Preconditions.checkAllNotNull(str, sourceInfo);
        boolean z10 = get(str) != null;
        ContentValues convert = convert(sourceInfo);
        if (z10) {
            getWritableDatabase().update(TABLE, convert, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(TABLE, null, convert);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void release() {
        close();
    }

    private ContentValues convert(SourceInfo sourceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.url);
        contentValues.put(COLUMN_LENGTH, Long.valueOf(sourceInfo.length));
        contentValues.put(COLUMN_MIME, sourceInfo.mime);
        return contentValues;
    }
}
