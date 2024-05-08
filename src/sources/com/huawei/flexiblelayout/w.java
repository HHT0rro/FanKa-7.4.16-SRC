package com.huawei.flexiblelayout;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.x;
import java.util.Map;

/* compiled from: EnvFunction.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class w implements s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28661a = "EnvFunction";

    /* renamed from: b, reason: collision with root package name */
    public static final String f28662b = "env";

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Class<? extends v>> f28663c;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f28663c = arrayMap;
        arrayMap.put(x.a.f28664a, x.class);
        f28663c.put(x.a.f28665b, x.class);
        f28663c.put(x.a.f28666c, x.class);
        f28663c.put(x.a.f28667d, x.class);
    }

    @Override // com.huawei.flexiblelayout.s
    public Integer a(String str) {
        Class<? extends v> cls;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i10 = 0;
        if (str.indexOf(",") == -1) {
            cls = f28663c.get(str);
        } else {
            String[] split = str.split(",");
            if (split.length == 2) {
                String str2 = split[0];
                Class<? extends v> cls2 = f28663c.get(str2);
                try {
                    i10 = Integer.valueOf(split[1].trim());
                } catch (Exception e2) {
                    Log.e(f28661a, "execute Integer.valueOf(envArr[1]): ", e2);
                }
                str = str2;
                cls = cls2;
            } else {
                str = null;
                cls = null;
            }
        }
        if (cls == null) {
            return null;
        }
        try {
            Integer a10 = cls.newInstance().a(str);
            return a10 != null ? a10 : i10;
        } catch (Exception e10) {
            Log.e(f28661a, "execute newInstance: ", e10);
            return null;
        }
    }
}
