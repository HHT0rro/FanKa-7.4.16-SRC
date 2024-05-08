package com.huawei.hianalytics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.text.TextUtils;
import com.huawei.hianalytics.core.greendao.DaoMaster;
import com.huawei.hianalytics.core.greendao.DaoSession;
import com.huawei.hianalytics.core.log.HiLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {
    public static f klm;
    public DaoSession lmn;

    public f(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                this.lmn = new DaoMaster(i.lmn(context, str, null).getWritableDatabase()).newSession();
                return;
            } catch (SQLiteDatabaseLockedException e2) {
                StringBuilder b4 = e9.a.b("SQLiteDatabaseLockedException ");
                b4.append(e2.getMessage());
                HiLog.e("DBController", b4.toString());
                return;
            } catch (Exception e10) {
                StringBuilder b10 = e9.a.b("Exception ");
                b10.append(e10.getMessage());
                HiLog.e("DBController", b10.toString());
                return;
            }
        }
        throw new IllegalArgumentException("context is null,or dbName is empty");
    }

    public static f lmn(Context context) {
        if (klm == null) {
            synchronized (f.class) {
                if (klm == null) {
                    klm = new f(context, "haformal_event.db");
                }
            }
        }
        return klm;
    }
}
