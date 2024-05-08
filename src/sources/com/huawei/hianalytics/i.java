package com.huawei.hianalytics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hianalytics.core.greendao.DaoMaster;
import com.huawei.hianalytics.core.greendao.EventDao;
import com.huawei.hianalytics.core.log.HiLog;
import org.greenrobot.greendao.database.Database;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i extends DaoMaster.OpenHelper {
    public static volatile i lmn;

    public i(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory);
    }

    public static i lmn(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        if (lmn == null) {
            synchronized (i.class) {
                if (lmn == null) {
                    lmn = new i(context, str, null);
                }
            }
        }
        return lmn;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
    }

    @Override // com.huawei.hianalytics.core.greendao.DaoMaster.OpenHelper, org.greenrobot.greendao.database.DatabaseOpenHelper
    public void onCreate(Database database) {
        super.onCreate(database);
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
    public void onUpgrade(Database database, int i10, int i11) {
        HiLog.si("MyOpenHelper", "upgrade run");
        try {
            h.lmn(database, EventDao.class);
        } catch (Exception e2) {
            StringBuilder b4 = e9.a.b("onUpgrade error msg = ");
            b4.append(e2.getMessage());
            HiLog.e("MyOpenHelper", b4.toString());
        }
        HiLog.si("MyOpenHelper", "upgrade run success");
    }
}
