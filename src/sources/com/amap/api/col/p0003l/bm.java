package com.amap.api.col.p0003l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: OfflineDBCreator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bm implements hg {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bm f5145a;

    private bm() {
    }

    public static bm a() {
        if (f5145a == null) {
            synchronized (bm.class) {
                if (f5145a == null) {
                    f5145a = new bm();
                }
            }
        }
        return f5145a;
    }

    @Override // com.amap.api.col.p0003l.hg
    public final String b() {
        return "offlineDbV4.db";
    }

    @Override // com.amap.api.col.p0003l.hg
    public final int c() {
        return 2;
    }

    @Override // com.amap.api.col.p0003l.hg
    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
        } catch (Throwable th) {
            gy.b(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.hg
    public final void a(SQLiteDatabase sQLiteDatabase, int i10) {
        if (sQLiteDatabase != null && i10 == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("url"));
                    String substring = string.substring(string.lastIndexOf("/") + 1);
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }
}
