package id;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: AdMonitorDbHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "tanx_ad_expose_sdk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public synchronized void a(long j10) {
        if (j10 < 0) {
            return;
        }
        try {
            long delete = getWritableDatabase().delete("retry_monitor_info", "id = ?", new String[]{String.valueOf(j10)});
            if (rc.b.f53376a) {
                rc.b.a("RetryMonitorDbHelper", "delete: id = " + j10 + ", deleteRows = " + delete);
            }
        } catch (Throwable th) {
            rc.b.b("RetryMonitorDbHelper", "delete by id exception.", th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (rc.b.f53376a) {
            rc.b.a("RetryMonitorDbHelper", "onCreate: createRetryTableSql = CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (rc.b.f53376a) {
            rc.b.a("RetryMonitorDbHelper", "onUpgrade: oldVer = " + i10 + ", newVer = " + i11);
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS retry_monitor_info");
        onCreate(sQLiteDatabase);
    }
}
