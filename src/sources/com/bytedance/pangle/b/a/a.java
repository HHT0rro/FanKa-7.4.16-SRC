package com.bytedance.pangle.b.a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Field> f10628a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Method> f10629b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Constructor> f10630c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, Class> f10631d = new HashMap();

    static {
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e2);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String b4 = b(cls, str, clsArr);
        synchronized (f10629b) {
            method = f10629b.get(b4);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method a10 = b.a(cls, str, clsArr);
            if (a10 != null) {
                synchronized (f10629b) {
                    f10629b.put(b4, a10);
                }
            }
            return a10;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String b(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.getName());
        sb2.append("#");
        sb2.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb2.append(cls2.getName());
                sb2.append("#");
            }
        } else {
            sb2.append(Void.class.getName());
        }
        return sb2.toString();
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String b4 = b(cls, "clinit", clsArr);
        synchronized (f10630c) {
            constructor = f10630c.get(b4);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor a10 = b.a(cls, clsArr);
            if (a10 != null) {
                synchronized (f10630c) {
                    f10630c.put(b4, a10);
                }
            }
            return a10;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static Field a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + "#" + str;
        synchronized (f10628a) {
            field = f10628a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field a10 = b.a(cls, str);
            if (a10 != null) {
                synchronized (f10628a) {
                    f10628a.put(str2, a10);
                }
            }
            return a10;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }
}
