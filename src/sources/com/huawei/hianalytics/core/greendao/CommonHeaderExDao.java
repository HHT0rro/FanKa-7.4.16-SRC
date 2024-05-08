package com.huawei.hianalytics.core.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import e9.a;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CommonHeaderExDao extends AbstractDao<CommonHeaderEx, String> {
    public static final String TABLENAME = "COMMON_HEADER_EX";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Properties {
        public static final Property EvtExHashCode = new Property(0, String.class, "evtExHashCode", true, "EVT_EX_HASH_CODE");
        public static final Property CommonHeaderEx = new Property(1, String.class, "commonHeaderEx", false, CommonHeaderExDao.TABLENAME);
    }

    public CommonHeaderExDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public static void createTable(Database database, boolean z10) {
        database.execSQL("CREATE TABLE " + (z10 ? "IF NOT EXISTS " : "") + "\"COMMON_HEADER_EX\" (\"EVT_EX_HASH_CODE\" TEXT PRIMARY KEY NOT NULL ,\"COMMON_HEADER_EX\" TEXT);");
    }

    public static void dropTable(Database database, boolean z10) {
        StringBuilder b4 = a.b("DROP TABLE ");
        b4.append(z10 ? "IF EXISTS " : "");
        b4.append("\"COMMON_HEADER_EX\"");
        database.execSQL(b4.toString());
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public CommonHeaderExDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public String getKey(CommonHeaderEx commonHeaderEx) {
        if (commonHeaderEx != null) {
            return commonHeaderEx.getEvtExHashCode();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(CommonHeaderEx commonHeaderEx) {
        return commonHeaderEx.getEvtExHashCode() != null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public String readKey(Cursor cursor, int i10) {
        int i11 = i10 + 0;
        if (cursor.isNull(i11)) {
            return null;
        }
        return cursor.getString(i11);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final String updateKeyAfterInsert(CommonHeaderEx commonHeaderEx, long j10) {
        return commonHeaderEx.getEvtExHashCode();
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, CommonHeaderEx commonHeaderEx) {
        databaseStatement.clearBindings();
        String evtExHashCode = commonHeaderEx.getEvtExHashCode();
        if (evtExHashCode != null) {
            databaseStatement.bindString(1, evtExHashCode);
        }
        String commonHeaderEx2 = commonHeaderEx.getCommonHeaderEx();
        if (commonHeaderEx2 != null) {
            databaseStatement.bindString(2, commonHeaderEx2);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public CommonHeaderEx readEntity(Cursor cursor, int i10) {
        int i11 = i10 + 0;
        int i12 = i10 + 1;
        return new CommonHeaderEx(cursor.isNull(i11) ? null : cursor.getString(i11), cursor.isNull(i12) ? null : cursor.getString(i12));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, CommonHeaderEx commonHeaderEx, int i10) {
        int i11 = i10 + 0;
        commonHeaderEx.setEvtExHashCode(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i10 + 1;
        commonHeaderEx.setCommonHeaderEx(cursor.isNull(i12) ? null : cursor.getString(i12));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, CommonHeaderEx commonHeaderEx) {
        sQLiteStatement.clearBindings();
        String evtExHashCode = commonHeaderEx.getEvtExHashCode();
        if (evtExHashCode != null) {
            sQLiteStatement.bindString(1, evtExHashCode);
        }
        String commonHeaderEx2 = commonHeaderEx.getCommonHeaderEx();
        if (commonHeaderEx2 != null) {
            sQLiteStatement.bindString(2, commonHeaderEx2);
        }
    }
}
