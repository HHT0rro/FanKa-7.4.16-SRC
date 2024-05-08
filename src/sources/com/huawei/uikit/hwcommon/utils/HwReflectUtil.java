package com.huawei.uikit.hwcommon.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e9.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwReflectUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f34960a = "HwReflectUtil";

    @Nullable
    public static Object callMethod(@Nullable Object obj, @NonNull String str, @Nullable Class[] clsArr, @Nullable Object[] objArr, @NonNull Class<?> cls) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IllegalAccessException in reflect call ");
            sb2.append(str);
            return null;
        } catch (IllegalArgumentException unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("IllegalArgumentException in reflect call ");
            sb3.append(str);
            return null;
        } catch (NoSuchMethodException unused3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("there is no ");
            sb4.append(str);
            sb4.append(" method");
            return null;
        } catch (InvocationTargetException unused4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("InvocationTargetException in reflect call ");
            sb5.append(str);
            return null;
        }
    }

    public static int getInternalId(@NonNull String str, @NonNull String str2) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("com.android.internal.R$");
            sb2.append(str);
            Field field = Class.forName(sb2.toString()).getField(str2);
            field.setAccessible(true);
            return field.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getInternalId: com.android.internal.R.");
            sb3.append(str);
            sb3.append(" not found");
            return 0;
        } catch (IllegalAccessException unused2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("getInternalId: IllegalAccessException of com.android.internal.R.");
            sb4.append(str);
            sb4.append(".");
            sb4.append(str2);
            return 0;
        } catch (NoSuchFieldException unused3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getInternalId: com.android.internal.R.");
            sb5.append(str);
            sb5.append(".");
            sb5.append(str2);
            sb5.append(" not found");
            return 0;
        }
    }

    @Nullable
    public static Method getMethod(@NonNull String str, @Nullable Class[] clsArr, @NonNull String str2) {
        try {
            return getMethod(str, clsArr, Class.forName(str2));
        } catch (ClassNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ClassNotFoundException in reflect call ");
            sb2.append(str);
            return null;
        }
    }

    @Nullable
    public static Object getObject(@Nullable Object obj, @NonNull String str, @NonNull Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("In get object, IllegalAccessException in reflect ");
            sb2.append(str);
            return null;
        } catch (NoSuchFieldException unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("In get object, No field in reflect ");
            sb3.append(str);
            return null;
        }
    }

    @Nullable
    public static Object invokeMethod(@Nullable Object obj, @NonNull Method method, @Nullable Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            a.b("IllegalAccessException in reflect call ").append(method.getName());
            return null;
        } catch (InvocationTargetException unused2) {
            a.b("InvocationTargetException in reflect call ").append(method.getName());
            return null;
        }
    }

    public static void setObject(@NonNull String str, @Nullable Object obj, @NonNull Object obj2, @NonNull Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("In set object, IllegalAccessException in reflect ");
            sb2.append(str);
        } catch (IllegalArgumentException unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("In set object, IllegalArgumentException in reflect ");
            sb3.append(str);
        } catch (NoSuchFieldException unused3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("In set object, No field in reflect ");
            sb4.append(str);
        } catch (SecurityException unused4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("In set object, SecurityException in reflect ");
            sb5.append(str);
        }
    }

    @Nullable
    public static Method getMethod(@NonNull String str, @Nullable Class[] clsArr, @NonNull Class<?> cls) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("there is no ");
            sb2.append(str);
            sb2.append(" method");
            return null;
        }
    }

    @Nullable
    public static Object invokeMethod(@Nullable Object obj, @NonNull Method method) {
        return invokeMethod(obj, method, null);
    }

    @Nullable
    public static Object invokeMethod(@NonNull Method method) {
        return invokeMethod(null, method, null);
    }
}
