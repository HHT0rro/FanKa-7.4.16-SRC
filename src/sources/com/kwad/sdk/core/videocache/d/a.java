package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.kwad.sdk.core.videocache.n;
import com.kwad.sdk.utils.ap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class a extends SQLiteOpenHelper implements c {
    private static final String[] aCD = {"_id", "url", DatabaseSourceInfoStorage.COLUMN_LENGTH, DatabaseSourceInfoStorage.COLUMN_MIME};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        ap.checkNotNull(context);
    }

    private static n i(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseSourceInfoStorage.COLUMN_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow(DatabaseSourceInfoStorage.COLUMN_MIME)));
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        ap.f(str, nVar);
        boolean z10 = eJ(str) != null;
        ContentValues a10 = a(nVar);
        if (z10) {
            getWritableDatabase().update(DatabaseSourceInfoStorage.TABLE, a10, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(DatabaseSourceInfoStorage.TABLE, null, a10);
        }
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eJ(String str) {
        Throwable th;
        Cursor cursor;
        ap.gH(str);
        n nVar = null;
        try {
            cursor = getReadableDatabase().query(DatabaseSourceInfoStorage.TABLE, aCD, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        nVar = i(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return nVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ap.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(DatabaseSourceInfoStorage.CREATE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    private static ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.url);
        contentValues.put(DatabaseSourceInfoStorage.COLUMN_LENGTH, Long.valueOf(nVar.aCx));
        contentValues.put(DatabaseSourceInfoStorage.COLUMN_MIME, nVar.aCy);
        return contentValues;
    }
}
