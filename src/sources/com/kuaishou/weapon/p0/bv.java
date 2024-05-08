package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.nirvana.tools.logger.cache.db.DBHelpTool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class bv {
    public static String a(Context context) {
        int i10 = 0;
        try {
            if (d(context) != null) {
                i10 = (int) ((r3.getIntExtra(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, -1) / r3.getIntExtra(com.huawei.flexiblelayout.n.f28264e, -1)) * 100.0f);
            }
            return i10 + "%";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            int intExtra = d(context).getIntExtra("plugged", -1);
            return intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "" : "Wireless charger" : "USB charger" : "AC charger";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int c(Context context) {
        int i10 = -1;
        try {
            int intExtra = d(context).getIntExtra("health", -1);
            i10 = 3;
            if (intExtra != 2) {
                if (intExtra == 3) {
                    return 4;
                }
                if (intExtra == 4) {
                    return 2;
                }
                if (intExtra != 5) {
                    return intExtra != 7 ? 6 : 1;
                }
                return 5;
            }
        } catch (Throwable unused) {
        }
        return i10;
    }

    private static Intent d(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
