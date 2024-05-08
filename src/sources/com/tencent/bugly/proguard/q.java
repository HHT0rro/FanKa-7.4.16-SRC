package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class q extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static String f40185a = "bugly_db";

    /* renamed from: b, reason: collision with root package name */
    private static int f40186b = 15;

    /* renamed from: c, reason: collision with root package name */
    private Context f40187c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.bugly.a> f40188d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context, List<com.tencent.bugly.a> list) {
        super(context, f40185a + "_", (SQLiteDatabase.CursorFactory) null, f40186b);
        com.tencent.bugly.crashreport.common.info.a.a(context).getClass();
        this.f40187c = context;
        this.f40188d = list;
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i10 = 0; i10 < 3; i10++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + strArr[i10], new String[0]);
            }
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i10 = 0;
        while (sQLiteDatabase == null && i10 < 5) {
            i10++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                x.d("[Database] Try to get db(count: %d).", Integer.valueOf(i10));
                if (i10 == 5) {
                    x.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i10 = 0;
        while (sQLiteDatabase == null && i10 < 5) {
            i10++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                x.d("[Database] Try to get db(count: %d).", Integer.valueOf(i10));
                if (i10 == 5) {
                    x.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            x.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS t_ui");
            sb2.append(" ( _id");
            sb2.append(" INTEGER PRIMARY KEY");
            sb2.append(" , _tm");
            sb2.append(" int");
            sb2.append(" , _ut");
            sb2.append(" int");
            sb2.append(" , _tp");
            sb2.append(" int");
            sb2.append(" , _dt");
            sb2.append(" blob");
            sb2.append(" , _pc");
            sb2.append(" text");
            sb2.append(" ) ");
            x.c(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS t_lr");
            sb2.append(" ( _id");
            sb2.append(" INTEGER PRIMARY KEY");
            sb2.append(" , _tp");
            sb2.append(" int");
            sb2.append(" , _tm");
            sb2.append(" int");
            sb2.append(" , _pc");
            sb2.append(" text");
            sb2.append(" , _th");
            sb2.append(" text");
            sb2.append(" , _dt");
            sb2.append(" blob");
            sb2.append(" ) ");
            x.c(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS t_pf");
            sb2.append(" ( _id");
            sb2.append(" integer");
            sb2.append(" , _tp");
            sb2.append(" text");
            sb2.append(" , _tm");
            sb2.append(" int");
            sb2.append(" , _dt");
            sb2.append(" blob");
            sb2.append(",primary key(_id");
            sb2.append(",_tp");
            sb2.append(" )) ");
            x.c(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS t_cr");
            sb2.append(" ( _id");
            sb2.append(" INTEGER PRIMARY KEY");
            sb2.append(" , _tm");
            sb2.append(" int");
            sb2.append(" , _s1");
            sb2.append(" text");
            sb2.append(" , _up");
            sb2.append(" int");
            sb2.append(" , _me");
            sb2.append(" int");
            sb2.append(" , _uc");
            sb2.append(" int");
            sb2.append(" , _dt");
            sb2.append(" blob");
            sb2.append(" ) ");
            x.c(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS dl_1002");
            sb2.append(" (_id");
            sb2.append(" integer primary key autoincrement, _dUrl");
            sb2.append(" varchar(100), _sFile");
            sb2.append(" varchar(100), _sLen");
            sb2.append(" INTEGER, _tLen");
            sb2.append(" INTEGER, _MD5");
            sb2.append(" varchar(100), _DLTIME");
            sb2.append(" INTEGER)");
            x.c(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append("CREATE TABLE IF NOT EXISTS ge_1002");
            sb2.append(" (_id");
            sb2.append(" integer primary key autoincrement, _time");
            sb2.append(" INTEGER, _datas");
            sb2.append(" blob)");
            x.c(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS st_1002");
            sb2.append(" ( _id");
            sb2.append(" integer");
            sb2.append(" , _tp");
            sb2.append(" text");
            sb2.append(" , _tm");
            sb2.append(" int");
            sb2.append(" , _dt");
            sb2.append(" blob");
            sb2.append(",primary key(_id");
            sb2.append(",_tp");
            sb2.append(" )) ");
            x.c(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
        }
        List<com.tencent.bugly.a> list = this.f40188d;
        if (list == null) {
            return;
        }
        Iterator<com.tencent.bugly.a> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th2) {
                if (!x.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (com.tencent.bugly.crashreport.common.info.b.c() >= 11) {
            x.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i10), Integer.valueOf(i11));
            List<com.tencent.bugly.a> list = this.f40188d;
            if (list != null) {
                Iterator<com.tencent.bugly.a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    try {
                        iterator2.next().onDbDowngrade(sQLiteDatabase, i10, i11);
                    } catch (Throwable th) {
                        if (!x.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            x.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f40187c.getDatabasePath(f40185a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        x.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i10), Integer.valueOf(i11));
        List<com.tencent.bugly.a> list = this.f40188d;
        if (list != null) {
            Iterator<com.tencent.bugly.a> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                try {
                    iterator2.next().onDbUpgrade(sQLiteDatabase, i10, i11);
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        x.d("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.f40187c.getDatabasePath(f40185a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }
}
