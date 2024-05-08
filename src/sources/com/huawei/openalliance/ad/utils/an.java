package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class an {
    private static final String Code = "ReflectAPI";

    public static Class Code(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            gl.I("ReflectAPI", "classNoFound %s", str);
            return null;
        }
    }

    public static Class Code(Field field) {
        int i10;
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return Code(field, i10);
    }

    public static Class Code(Field field, int i10) {
        Type[] actualTypeArguments;
        StringBuilder sb2;
        Type genericType = field.getGenericType();
        if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > i10) {
            try {
                if (actualTypeArguments[i10] instanceof Class) {
                    return (Class) actualTypeArguments[i10];
                }
                String obj = actualTypeArguments[i10].toString();
                int indexOf = obj.indexOf("class ");
                if (indexOf < 0) {
                    indexOf = 0;
                }
                int indexOf2 = obj.indexOf("<");
                if (indexOf2 < 0) {
                    indexOf2 = obj.length();
                }
                return Class.forName(obj.substring(indexOf, indexOf2));
            } catch (ClassNotFoundException e2) {
                e = e2;
                sb2 = new StringBuilder();
                sb2.append("getType ");
                sb2.append(e.getClass().getSimpleName());
                gl.I("ReflectAPI", sb2.toString());
                return null;
            } catch (Exception e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("getType ");
                sb2.append(e.getClass().getSimpleName());
                gl.I("ReflectAPI", sb2.toString());
                return null;
            }
        }
        return null;
    }

    public static Object Code(Class cls, String str) {
        String str2;
        Field V = V(cls, str);
        if (V == null) {
            return null;
        }
        Code(V, true);
        try {
            return V.get(null);
        } catch (IllegalAccessException unused) {
            str2 = "getFieldValue IllegalAccessException";
            gl.I("ReflectAPI", str2);
            return null;
        } catch (Exception e2) {
            str2 = "getFieldValue " + e2.getClass().getSimpleName();
            gl.I("ReflectAPI", str2);
            return null;
        }
    }

    public static Object Code(Object obj, Class cls, String str, Class<?>[] clsArr, Object[] objArr) {
        StringBuilder sb2;
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                Method method = cls.getMethod(str, clsArr);
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            } catch (NoSuchMethodException e2) {
                e = e2;
                sb2 = new StringBuilder();
                sb2.append("invokeMethod ");
                sb2.append(e.getClass().getSimpleName());
                gl.I("ReflectAPI", sb2.toString());
                return null;
            } catch (Throwable th) {
                e = th;
                sb2 = new StringBuilder();
                sb2.append("invokeMethod ");
                sb2.append(e.getClass().getSimpleName());
                gl.I("ReflectAPI", sb2.toString());
                return null;
            }
        }
        return null;
    }

    public static Field Code(Field field, boolean z10) {
        field.setAccessible(z10);
        return field;
    }

    public static boolean Code(String str, String str2, Class<?>[] clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class.forName(str).getDeclaredMethod(str2, clsArr);
                return true;
            } catch (ClassNotFoundException unused) {
                gl.I("ReflectAPI", "class not found for %s", str);
            } catch (NoSuchMethodException unused2) {
                gl.I("ReflectAPI", "method not found for %s", str2);
            } catch (Throwable th) {
                gl.I("ReflectAPI", "isMethodAvailable %s", th.getClass().getSimpleName());
            }
        }
        return false;
    }

    public static Field[] Code(Class cls) {
        Field[] Code2 = cls.getSuperclass() != null ? Code(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (Code2 == null || Code2.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + Code2.length];
        System.arraycopy(Code2, 0, fieldArr, 0, Code2.length);
        System.arraycopy(declaredFields, 0, fieldArr, Code2.length, declaredFields.length);
        return fieldArr;
    }

    public static boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            gl.I("ReflectAPI", "class not found for %s", str);
            return false;
        }
    }

    public static Object V(String str) {
        StringBuilder sb2;
        try {
            return Class.forName(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            sb2 = new StringBuilder();
            sb2.append("createInstance ");
            sb2.append(e.getClass().getSimpleName());
            gl.I("ReflectAPI", sb2.toString());
            return null;
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("createInstance ");
            sb2.append(e.getClass().getSimpleName());
            gl.I("ReflectAPI", sb2.toString());
            return null;
        }
    }

    public static Field V(Class cls, String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && cls != null) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                str2 = "getDeclaredField NoSuchFieldException";
                gl.I("ReflectAPI", str2);
                return null;
            } catch (SecurityException unused2) {
                str2 = "getDeclaredField SecurityException";
                gl.I("ReflectAPI", str2);
                return null;
            }
        }
        return null;
    }
}
