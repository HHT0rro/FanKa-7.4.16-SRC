package com.tencent.turingcam;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EQsUZ {

    /* renamed from: a, reason: collision with root package name */
    private static final String f45394a = WOMZP.b("mdNjPO1K7FJ+9CbSnlMtKMQ1GBI=");

    /* renamed from: b, reason: collision with root package name */
    private static final String f45395b = WOMZP.b("atljSFyftxO7USe0FJAEN952jDJYW1+B");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg {

        /* renamed from: a, reason: collision with root package name */
        public Object f45396a;

        public <T> T a() {
            return (T) this.f45396a;
        }
    }

    public static boolean a(Object obj, String str, spXPg spxpg) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod(f45394a, String.class).invoke(obj.getClass(), str);
            if (field != null) {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                field.setAccessible(false);
                spxpg.f45396a = obj2;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method method = (Method) Class.class.getDeclaredMethod(f45395b, String.class, Class[].class).invoke(obj.getClass(), str, clsArr);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj, objArr);
                method.setAccessible(false);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
