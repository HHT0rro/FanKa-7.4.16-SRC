package com.qq.e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Boolean> f38327a = new HashMap();

    private static boolean a(Class cls, String str, Class... clsArr) {
        String sb2;
        if (cls == null) {
            sb2 = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls.getName());
            sb3.append("#");
            sb3.append(str);
            for (Class cls2 : clsArr) {
                sb3.append("_");
                sb3.append(cls2.getName());
            }
            sb2 = sb3.toString();
        }
        Map<String, Boolean> map = f38327a;
        Boolean bool = map.get(sb2);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(sb2, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            f38327a.put(sb2, Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
