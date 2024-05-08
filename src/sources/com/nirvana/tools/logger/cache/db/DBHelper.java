package com.nirvana.tools.logger.cache.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DBHelper extends SQLiteOpenHelper {
    private String mCreateSql;
    private String mDeleteSql;
    private String mIndexSql;

    public DBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10, String str2, String str3, String str4) {
        super(context, str, cursorFactory, i10);
        this.mCreateSql = str2;
        this.mDeleteSql = str3;
        this.mIndexSql = str4;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(this.mCreateSql);
            sQLiteDatabase.execSQL(this.mIndexSql);
            sQLiteDatabase.execSQL("PRAGMA auto_vacuum = FULL");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            sQLiteDatabase.execSQL(this.mDeleteSql);
            onCreate(sQLiteDatabase);
        } catch (Exception unused) {
        }
    }
}
