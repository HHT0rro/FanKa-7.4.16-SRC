package com.wangmai.okhttp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.cookie.SerializableCookie;
import com.wangmai.okhttp.model.Progress;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_CACHE_NAME = "wmhttp.db";
    public static final int DB_CACHE_VERSION = 1;
    public static final String TABLE_CACHE = "cache";
    public static final String TABLE_COOKIE = "cookie";
    public static final String TABLE_DOWNLOAD = "download";
    public static final String TABLE_UPLOAD = "upload";
    public static final Lock lock = new ReentrantLock();
    public TableEntity cacheTableEntity;
    public TableEntity cookieTableEntity;
    public TableEntity downloadTableEntity;
    public TableEntity uploadTableEntity;

    public DBHelper() {
        this(OkHttp.getInstance().getContext().getApplicationContext());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.cacheTableEntity.buildTableString());
        sQLiteDatabase.execSQL(this.cookieTableEntity.buildTableString());
        sQLiteDatabase.execSQL(this.downloadTableEntity.buildTableString());
        sQLiteDatabase.execSQL(this.uploadTableEntity.buildTableString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        onUpgrade(sQLiteDatabase, i10, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.cacheTableEntity)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cache");
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.cookieTableEntity)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cookie");
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.downloadTableEntity)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download");
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.uploadTableEntity)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS upload");
        }
        onCreate(sQLiteDatabase);
    }

    public DBHelper(Context context) {
        super(context, DB_CACHE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.cacheTableEntity = new TableEntity(TABLE_CACHE);
        this.cookieTableEntity = new TableEntity("cookie");
        this.downloadTableEntity = new TableEntity("download");
        this.uploadTableEntity = new TableEntity(TABLE_UPLOAD);
        this.cacheTableEntity.addColumn(new ColumnEntity("key", "VARCHAR", true, true)).addColumn(new ColumnEntity(CacheEntity.LOCAL_EXPIRE, "INTEGER")).addColumn(new ColumnEntity("head", "BLOB")).addColumn(new ColumnEntity("data", "BLOB"));
        this.cookieTableEntity.addColumn(new ColumnEntity("host", "VARCHAR")).addColumn(new ColumnEntity("name", "VARCHAR")).addColumn(new ColumnEntity(SerializableCookie.DOMAIN, "VARCHAR")).addColumn(new ColumnEntity("cookie", "BLOB")).addColumn(new ColumnEntity("host", "name", SerializableCookie.DOMAIN));
        this.downloadTableEntity.addColumn(new ColumnEntity("tag", "VARCHAR", true, true)).addColumn(new ColumnEntity("url", "VARCHAR")).addColumn(new ColumnEntity(Progress.FOLDER, "VARCHAR")).addColumn(new ColumnEntity("filePath", "VARCHAR")).addColumn(new ColumnEntity("fileName", "VARCHAR")).addColumn(new ColumnEntity(Progress.FRACTION, "VARCHAR")).addColumn(new ColumnEntity(Progress.TOTAL_SIZE, "INTEGER")).addColumn(new ColumnEntity(Progress.CURRENT_SIZE, "INTEGER")).addColumn(new ColumnEntity("status", "INTEGER")).addColumn(new ColumnEntity("priority", "INTEGER")).addColumn(new ColumnEntity("date", "INTEGER")).addColumn(new ColumnEntity("request", "BLOB")).addColumn(new ColumnEntity(Progress.EXTRA1, "BLOB")).addColumn(new ColumnEntity(Progress.EXTRA2, "BLOB")).addColumn(new ColumnEntity(Progress.EXTRA3, "BLOB"));
        this.uploadTableEntity.addColumn(new ColumnEntity("tag", "VARCHAR", true, true)).addColumn(new ColumnEntity("url", "VARCHAR")).addColumn(new ColumnEntity(Progress.FOLDER, "VARCHAR")).addColumn(new ColumnEntity("filePath", "VARCHAR")).addColumn(new ColumnEntity("fileName", "VARCHAR")).addColumn(new ColumnEntity(Progress.FRACTION, "VARCHAR")).addColumn(new ColumnEntity(Progress.TOTAL_SIZE, "INTEGER")).addColumn(new ColumnEntity(Progress.CURRENT_SIZE, "INTEGER")).addColumn(new ColumnEntity("status", "INTEGER")).addColumn(new ColumnEntity("priority", "INTEGER")).addColumn(new ColumnEntity("date", "INTEGER")).addColumn(new ColumnEntity("request", "BLOB")).addColumn(new ColumnEntity(Progress.EXTRA1, "BLOB")).addColumn(new ColumnEntity(Progress.EXTRA2, "BLOB")).addColumn(new ColumnEntity(Progress.EXTRA3, "BLOB"));
    }
}
