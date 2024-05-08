package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class a {
    public static void a(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) a(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field a10 = a(Fragment.class, "sClassMap");
            if (a10 != null) {
                ((SimpleArrayMap) a10.get(null)).put(cls.getName(), cls);
                return;
            }
            Class a11 = a("androidx.fragment.app.FragmentFactory");
            if (a11 == null) {
                return;
            }
            Field a12 = a(a11, "sClassMap");
            if (a12 != null) {
                ((SimpleArrayMap) a12.get(null)).put(cls.getName(), cls);
                return;
            }
            Field a13 = a(a11, "sClassCacheMap");
            if (a13 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) a13.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static Field a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
