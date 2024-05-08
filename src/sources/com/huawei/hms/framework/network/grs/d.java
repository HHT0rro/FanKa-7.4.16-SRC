package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, c> f29949a = new ConcurrentHashMap(16);

    /* renamed from: b, reason: collision with root package name */
    private static final Object f29950b = new Object();

    public static c a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (f29950b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, c> map = f29949a;
            c cVar = map.get(context.getPackageName() + uniqueCode);
            if (cVar == null) {
                Logger.i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                c cVar2 = new c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, cVar2);
                return cVar2;
            }
            if (cVar.a((Object) new c(grsBaseInfo))) {
                return cVar;
            }
            Logger.i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
            c cVar3 = new c(context, grsBaseInfo);
            map.put(context.getPackageName() + uniqueCode, cVar3);
            return cVar3;
        }
    }
}
