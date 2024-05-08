package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: OSSSQLiteHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cf extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3309a = "part_info";

    /* renamed from: b, reason: collision with root package name */
    private static final String f3310b = "create table if not exists part_info(id INTEGER primary key,upload_id VARCHAR(255),num INTEGER,crc64 INTEGER,size INTEGER,etag VARCHAR(255))";

    private cf(Context context) {
        this(context, "oss_android_sdk.db");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f3310b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    private cf(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }
}
