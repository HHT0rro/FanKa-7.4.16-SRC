package com.irisdt.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.irisdt.grpc.connect.ClientManager;
import com.irisdt.grpc.connect.DauManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "irisdt.db";
    private static final String LOG_TAG = "DBHelper";
    private static final long MAX_SIZE_BYTES = 10485760;
    private static final int VERSION = 2;
    private static boolean dbIsAvailable = true;
    private static volatile DBHelper instance;
    private static SQLiteDatabase sqLiteDatabase;

    private DBHelper(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
    }

    public static DBHelper getInstance() {
        return instance;
    }

    public static void open(Context context) {
        try {
            instance = new DBHelper(context, DB_NAME, null, 2);
            sqLiteDatabase = instance.getWritableDatabase();
        } catch (Throwable th) {
            th.printStackTrace();
            dbIsAvailable = false;
        }
    }

    public boolean dbIsAvailable() {
        return dbIsAvailable;
    }

    public SQLiteDatabase getDatabase() {
        return sqLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.enableWriteAheadLogging();
            sQLiteDatabase.setMaximumSize(MAX_SIZE_BYTES);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(ClientManager.CREATE_TABLE_SQL);
        sQLiteDatabase.execSQL(DauManager.CREATE_TABLE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onUpgrade, oldVersion: ");
        sb2.append(i10);
        sb2.append(", newVersion: ");
        sb2.append(i11);
        if (i10 != 1) {
            return;
        }
        sQLiteDatabase.execSQL(DauManager.CREATE_TABLE_SQL);
    }
}
