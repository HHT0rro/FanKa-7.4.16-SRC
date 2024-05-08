package com.amap.api.col.p0003l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hk extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6253b = true;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f6254c;

    /* renamed from: a, reason: collision with root package name */
    private hg f6255a;

    public hk(Context context, String str, int i10, hg hgVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f6255a = hgVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f6255a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.f6255a.a(sQLiteDatabase, i10);
    }
}
