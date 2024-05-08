package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            Logger.w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    private static Class<?> getClass(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Field getField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                final Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        Field.this.setAccessible(true);
                        return null;
                    }
                });
                return declaredField;
            } catch (IllegalArgumentException e2) {
                Logger.e(TAG, "Exception in getField :: IllegalArgumentException:", e2);
            } catch (NoSuchFieldException e10) {
                Logger.e(TAG, "Exception in getField :: NoSuchFieldException:", e10);
            } catch (SecurityException e11) {
                Logger.e(TAG, "not security int method getField,SecurityException:", e11);
            }
        }
        return null;
    }

    public static Object getFieldObj(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Field declaredField = obj.getClass().getDeclaredField(str);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    Field.this.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(obj);
        } catch (IllegalAccessException e2) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e2);
            return null;
        } catch (IllegalArgumentException e10) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e10);
            return null;
        } catch (NoSuchFieldException e11) {
            Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e11);
            return null;
        } catch (SecurityException e12) {
            Logger.e(TAG, "not security int method getFieldObj,SecurityException:", e12);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && str != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e2) {
                Logger.e(TAG, "NoSuchMethodException:", e2);
                return null;
            } catch (SecurityException e10) {
                Logger.e(TAG, "SecurityException:", e10);
                return null;
            }
        }
        Logger.w(TAG, "targetClass is  null pr name is null:");
        return null;
    }

    public static Object getStaticFieldObj(String str, String str2) {
        Class<?> cls;
        if (str == null || (cls = getClass(str)) == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            final Field declaredField = cls.getDeclaredField(str2);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    Field.this.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(cls);
        } catch (IllegalAccessException e2) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e2);
            return null;
        } catch (IllegalArgumentException e10) {
            Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e10);
            return null;
        } catch (NoSuchFieldException e11) {
            Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e11);
            return null;
        } catch (SecurityException e12) {
            Logger.e(TAG, "not security int method getStaticFieldObj,SecurityException:", e12);
            return null;
        }
    }

    private static Object invoke(Object obj, Method method, Object... objArr) throws UnsupportedOperationException {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e2) {
            Logger.e(TAG, "RuntimeException in invoke:", e2);
            return null;
        } catch (Exception e10) {
            Logger.e(TAG, "Exception in invoke:", e10);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i10 = 0; i10 < length; i10++) {
                setClassType(clsArr, objArr[i10], i10);
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }

    private static void setClassType(Class<?>[] clsArr, Object obj, int i10) {
        if (obj instanceof Integer) {
            clsArr[i10] = Integer.TYPE;
            return;
        }
        if (obj instanceof Long) {
            clsArr[i10] = Long.TYPE;
            return;
        }
        if (obj instanceof Double) {
            clsArr[i10] = Double.TYPE;
            return;
        }
        if (obj instanceof Float) {
            clsArr[i10] = Float.TYPE;
            return;
        }
        if (obj instanceof Boolean) {
            clsArr[i10] = Boolean.TYPE;
            return;
        }
        if (obj instanceof Character) {
            clsArr[i10] = Character.TYPE;
            return;
        }
        if (obj instanceof Byte) {
            clsArr[i10] = Byte.TYPE;
            return;
        }
        if (obj instanceof Void) {
            clsArr[i10] = Void.TYPE;
        } else if (obj instanceof Short) {
            clsArr[i10] = Short.TYPE;
        } else {
            clsArr[i10] = obj.getClass();
        }
    }

    private static void tryLoadClass(String str) throws ClassNotFoundException {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader != null) {
            classLoader.loadClass(str);
            return;
        }
        throw new ClassNotFoundException("not found classloader");
    }

    public static boolean checkCompatible(String str, String str2, Class<?>... clsArr) {
        try {
            if (str != null && str2 != null) {
                Class.forName(str).getDeclaredMethod(str2, clsArr);
                Logger.v(TAG, "has method : " + str2);
                return true;
            }
            Logger.w(TAG, "targetClass is  null or name is null:");
            return false;
        } catch (RuntimeException unused) {
            Logger.w(TAG, str + " RuntimeException");
            return false;
        } catch (Exception unused2) {
            Logger.w(TAG, str2 + " NoSuchMethodException");
            return false;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }
}
