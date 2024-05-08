package com.ishumei.smantifraud.l111l11111I1l;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.flexiblelayout.n;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111I1l {
    public static Map<String, Integer> l1111l111111Il() {
        Intent registerReceiver;
        HashMap hashMap = new HashMap();
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return hashMap;
        }
        try {
            registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception unused) {
        }
        if (registerReceiver == null) {
            return hashMap;
        }
        int intExtra = registerReceiver.getIntExtra("status", 0);
        int intExtra2 = registerReceiver.getIntExtra(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, 0);
        int intExtra3 = registerReceiver.getIntExtra(n.f28264e, 100);
        int intExtra4 = registerReceiver.getIntExtra("temperature", 0);
        int intExtra5 = registerReceiver.getIntExtra("voltage", 0);
        hashMap.put("status", Integer.valueOf(intExtra));
        hashMap.put(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, Integer.valueOf(intExtra2));
        hashMap.put(n.f28264e, Integer.valueOf(intExtra3));
        hashMap.put("temp", Integer.valueOf(intExtra4));
        hashMap.put("vol", Integer.valueOf(intExtra5));
        return hashMap;
    }
}
