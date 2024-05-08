package com.huawei.flexiblelayout;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.flexiblelayout.log.Log;
import java.util.Map;

/* compiled from: CSSFunctionExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28629a = "CSSFunctionExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Class<? extends s>> f28630b;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f28630b = arrayMap;
        arrayMap.put(w.f28662b, w.class);
        f28630b.put(u.f28633a, u.class);
        f28630b.put(c0.f27745b, c0.class);
    }

    public static Integer a(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("(")) <= 0) {
            return null;
        }
        Class<? extends s> cls = f28630b.get(str.substring(0, indexOf));
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance().a(str.substring(indexOf + 1, str.length() - 1));
        } catch (Exception e2) {
            Log.e(f28629a, "execute newInstance: ", e2);
            return null;
        }
    }
}
