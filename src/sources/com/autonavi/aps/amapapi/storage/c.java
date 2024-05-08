package com.autonavi.aps.amapapi.storage;

import android.database.sqlite.SQLiteDatabase;
import com.amap.api.col.p0003l.hg;

/* compiled from: SdCardDbCreator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c implements hg {
    @Override // com.amap.api.col.p0003l.hg
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "SdCardDbCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.p0003l.hg
    public final void a(SQLiteDatabase sQLiteDatabase, int i10) {
    }

    @Override // com.amap.api.col.p0003l.hg
    public final String b() {
        return "alsn20170807.db";
    }

    @Override // com.amap.api.col.p0003l.hg
    public final int c() {
        return 1;
    }
}
