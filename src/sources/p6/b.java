package p6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: CacheFileMetadataIndex.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f52862c = {"name", DatabaseSourceInfoStorage.COLUMN_LENGTH, "last_touch_timestamp"};

    /* renamed from: a, reason: collision with root package name */
    public final y4.a f52863a;

    /* renamed from: b, reason: collision with root package name */
    public String f52864b;

    public b(y4.a aVar) {
        this.f52863a = aVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str) {
        String valueOf = String.valueOf(str);
        sQLiteDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new String("DROP TABLE IF EXISTS "));
    }

    public static String d(String str) {
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "ExoPlayerCacheFileMetadata".concat(valueOf) : new String("ExoPlayerCacheFileMetadata");
    }

    @WorkerThread
    public Map<String, a> b() throws DatabaseIOException {
        try {
            Cursor c4 = c();
            try {
                HashMap hashMap = new HashMap(c4.getCount());
                while (c4.moveToNext()) {
                    hashMap.put((String) com.google.android.exoplayer2.util.a.e(c4.getString(0)), new a(c4.getLong(1), c4.getLong(2)));
                }
                c4.close();
                return hashMap;
            } finally {
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public final Cursor c() {
        com.google.android.exoplayer2.util.a.e(this.f52864b);
        return this.f52863a.getReadableDatabase().query(this.f52864b, f52862c, null, null, null, null, null);
    }

    @WorkerThread
    public void e(long j10) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j10);
            this.f52864b = d(hexString);
            if (y4.c.b(this.f52863a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f52863a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    y4.c.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f52864b);
                    String str = this.f52864b;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 108);
                    sb2.append("CREATE TABLE ");
                    sb2.append(str);
                    sb2.append(" ");
                    sb2.append("(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.execSQL(sb2.toString());
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public void f(String str) throws DatabaseIOException {
        com.google.android.exoplayer2.util.a.e(this.f52864b);
        try {
            this.f52863a.getWritableDatabase().delete(this.f52864b, "name = ?", new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public void g(Set<String> set) throws DatabaseIOException {
        com.google.android.exoplayer2.util.a.e(this.f52864b);
        try {
            SQLiteDatabase writableDatabase = this.f52863a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> iterator2 = set.iterator2();
                while (iterator2.hasNext()) {
                    writableDatabase.delete(this.f52864b, "name = ?", new String[]{iterator2.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @WorkerThread
    public void h(String str, long j10, long j11) throws DatabaseIOException {
        com.google.android.exoplayer2.util.a.e(this.f52864b);
        try {
            SQLiteDatabase writableDatabase = this.f52863a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put(DatabaseSourceInfoStorage.COLUMN_LENGTH, Long.valueOf(j10));
            contentValues.put("last_touch_timestamp", Long.valueOf(j11));
            writableDatabase.replaceOrThrow(this.f52864b, null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
