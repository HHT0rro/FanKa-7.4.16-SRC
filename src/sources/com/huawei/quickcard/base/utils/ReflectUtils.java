package com.huawei.quickcard.base.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.invoke.IInvoker;
import com.huawei.quickcard.base.invoke.MethodInvoker;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ReflectUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33427a = "ReflectUtils";

    private static boolean a(@NonNull Method method) {
        return !Modifier.isPublic(method.getModifiers());
    }

    @Nullable
    public static Object adaptArgs(Type type, Object obj) {
        if (type == Integer.TYPE) {
            return Integer.valueOf(a(obj, Integer.MIN_VALUE));
        }
        if (type == Long.TYPE) {
            return Long.valueOf(a(obj, Long.MIN_VALUE));
        }
        if (type == Float.TYPE) {
            return Float.valueOf(a(obj, Float.NaN));
        }
        if (type == Double.TYPE) {
            return Double.valueOf(a(obj, Double.NaN));
        }
        if (type == String.class) {
            return a(obj, (String) null);
        }
        return a(obj, (Object) null);
    }

    @NonNull
    public static Object[] compatArgs(@NonNull Type[] typeArr, Object[] objArr, boolean z10) {
        int length = typeArr.length;
        int length2 = objArr != null ? objArr.length : 0;
        Object[] objArr2 = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 < length2) {
                objArr2[i10] = z10 ? adaptArgs(typeArr[i10], objArr[i10]) : objArr[i10];
            } else {
                objArr2[i10] = z10 ? adaptArgs(typeArr[i10], null) : null;
            }
        }
        return objArr2;
    }

    @NonNull
    public static Map<String, IInvoker> extractPublicMethods(@NonNull Class<?> cls) {
        return extractPublicMethods(cls, null);
    }

    @Nullable
    public static Object invokeMethod(@NonNull Map<String, IInvoker> map, @NonNull String str, @NonNull Object obj, Object... objArr) {
        return invokeMethod(map, str, obj, true, objArr);
    }

    public static Object reflectPublicMethod(String str, String str2) throws Exception {
        return Class.forName(str).getMethod(str2, new Class[0]).invoke(str, new Object[0]);
    }

    @Nullable
    public static Object reflectPublicMethodSimply(String str, String str2) {
        CardLogUtils.d(f33427a, "invoke reflectPublicMethodSimply, class::" + str + ", method::" + str2);
        try {
            return reflectPublicMethod(str, str2);
        } catch (ClassNotFoundException e2) {
            CardLogUtils.w(f33427a, str + " class not found::" + e2.getMessage());
            return null;
        } catch (NoSuchMethodException e10) {
            CardLogUtils.w(f33427a, str2 + " method not found::" + e10.getMessage());
            return null;
        } catch (Exception e11) {
            CardLogUtils.w(f33427a, "reflect other error::" + e11.getMessage());
            return null;
        }
    }

    private static int a(Object obj, int i10) {
        if (obj == null) {
            return i10;
        }
        try {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            return Double.valueOf(Double.parseDouble(obj.toString())).intValue();
        } catch (Exception unused) {
            CardLogUtils.e("Argument error! need number, value is " + obj);
            return i10;
        }
    }

    @NonNull
    public static Map<String, IInvoker> extractPublicMethods(@NonNull Class<?> cls, Class<? extends Annotation> cls2) {
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            HashMap hashMap = new HashMap(declaredMethods.length);
            for (Method method : declaredMethods) {
                if (!a(method)) {
                    if (cls2 != null) {
                        if (method.isAnnotationPresent(cls2)) {
                            hashMap.put(method.getName(), new MethodInvoker(method));
                        }
                    } else {
                        hashMap.put(method.getName(), new MethodInvoker(method));
                    }
                }
            }
            return hashMap;
        } catch (Exception e2) {
            CardLogUtils.w(f33427a, "reflect methods failed::" + e2.getMessage());
            return new HashMap();
        }
    }

    @Nullable
    public static Object invokeMethod(@NonNull Map<String, IInvoker> map, @NonNull String str, @NonNull Object obj, boolean z10, Object... objArr) {
        try {
            IInvoker iInvoker = map.get(str);
            if (iInvoker == null) {
                CardLogUtils.i(f33427a, "invoke method failed::method is not exist");
                return null;
            }
            Type[] parameterTypes = iInvoker.getParameterTypes();
            if (parameterTypes.length == 0) {
                return iInvoker.invoke(obj, new Object[0]);
            }
            return iInvoker.invoke(obj, compatArgs(parameterTypes, objArr, z10));
        } catch (Exception e2) {
            CardLogUtils.w(f33427a, "invoke method failed::" + e2.getMessage());
            return null;
        }
    }

    private static long a(Object obj, long j10) {
        if (obj == null) {
            return j10;
        }
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            return Double.valueOf(Double.parseDouble(obj.toString())).longValue();
        } catch (Exception unused) {
            CardLogUtils.e("Argument error! need number, value is " + obj);
            return j10;
        }
    }

    private static float a(Object obj, float f10) {
        if (obj == null) {
            return f10;
        }
        try {
            return Double.valueOf(Double.parseDouble(obj.toString())).floatValue();
        } catch (Exception unused) {
            CardLogUtils.e("Argument error! need number, value is " + obj);
            return f10;
        }
    }

    private static double a(Object obj, double d10) {
        if (obj == null) {
            return d10;
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception unused) {
            CardLogUtils.e("Argument error! need number, value is " + obj);
            return d10;
        }
    }

    private static String a(Object obj, String str) {
        if (obj instanceof CardDataObject) {
            return ((CardDataObject) obj).toJSON().toString();
        }
        return obj == null ? str : obj.toString();
    }

    private static Object a(Object obj, Object obj2) {
        Object wrap = WrapDataUtils.wrap(obj);
        return wrap instanceof CardDataObject ? wrap : obj2;
    }
}
