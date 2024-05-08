package com.huawei.hianalytics.core.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 2;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onUpgrade(Database database, int i10, int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Upgrading schema from version ");
            sb2.append(i10);
            sb2.append(" to ");
            sb2.append(i11);
            sb2.append(" by dropping all tables");
            DaoMaster.dropAllTables(database, true);
            onCreate(database);
        }

        public DevOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String str) {
            super(context, str, 2);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onCreate(Database database) {
            DaoMaster.createAllTables(database, false);
        }

        public OpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 2);
        }
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this(new StandardDatabase(sQLiteDatabase));
    }

    public static void createAllTables(Database database, boolean z10) {
        CommonHeaderExDao.createTable(database, z10);
        EventDao.createTable(database, z10);
    }

    public static void dropAllTables(Database database, boolean z10) {
        CommonHeaderExDao.dropTable(database, z10);
        EventDao.dropTable(database, z10);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoMaster(Database database) {
        super(database, 2);
        registerDaoClass(CommonHeaderExDao.class);
        registerDaoClass(EventDao.class);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    public DaoSession newSession() {
        return new DaoSession(this.f52439db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.f52439db, identityScopeType, this.daoConfigMap);
    }
}
