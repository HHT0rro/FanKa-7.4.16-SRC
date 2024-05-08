package com.huawei.uikit.hwresources.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwWidgetInstantiator {
    public static final int TYPE_CAR = 4;
    public static final int TYPE_MASK = 15;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_TELEVISION = 2;
    public static final int TYPE_WATCH = 8;

    /* renamed from: a, reason: collision with root package name */
    public static final String f35230a = "HwWidgetInstantiator";

    /* renamed from: b, reason: collision with root package name */
    public static final String f35231b = "com.huawei.uikit";

    /* renamed from: c, reason: collision with root package name */
    public static final String f35232c = "com.huawei.uikit.phone";

    /* renamed from: d, reason: collision with root package name */
    public static final String f35233d = "com.huawei.uikit.tv";

    /* renamed from: e, reason: collision with root package name */
    public static final String f35234e = "com.huawei.uikit.car";

    /* renamed from: f, reason: collision with root package name */
    public static final String f35235f = "com.huawei.uikit.watch";

    /* renamed from: g, reason: collision with root package name */
    public static final Map<String, Class<?>> f35236g = new ArrayMap();

    public static int getCurrentType(@NonNull Context context, int i10, int i11) {
        int currentType = getCurrentType(context);
        return ((i10 & 15) & currentType) == 0 ? i11 : currentType;
    }

    public static int getCurrnetType(@NonNull Context context) {
        return getCurrentType(context);
    }

    public static String getDeviceClassName(@NonNull Context context, @NonNull Class<?> cls) {
        return getDeviceClassName(context, cls, getCurrnetType(context));
    }

    public static int getSystemUiModeType(@NonNull Context context) {
        Object systemService = context.getSystemService("uimode");
        if (systemService instanceof UiModeManager) {
            return ((UiModeManager) systemService).getCurrentModeType();
        }
        return 0;
    }

    @Nullable
    public static Object instantiate(Context context, String str, Class<?> cls) {
        if (context != null && !TextUtils.isEmpty(str) && cls != null) {
            try {
                Map<String, Class<?>> map = f35236g;
                Class<?> cls2 = map.get(str);
                if (cls2 == null) {
                    cls2 = context.getClassLoader().loadClass(str);
                    if (!cls.isAssignableFrom(cls2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Trying to instantiate the class that is not ");
                        sb2.append(cls.getName());
                        return null;
                    }
                    map.put(str, cls2);
                }
                return cls2.getDeclaredConstructor(Context.class).newInstance(context);
            } catch (ClassNotFoundException unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(": make sure class name exists, is public, and has an empty constructor that is public");
            } catch (IllegalAccessException unused2) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(": calling constructor caused an IllegalAccessException");
            } catch (InstantiationException unused3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(": calling constructor caused an InstantiationException");
            } catch (NoSuchMethodException unused4) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(": could not find constructor");
            } catch (InvocationTargetException unused5) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append(": calling constructor caused an InvocationTargetException");
            }
        }
        return null;
    }

    public static int getCurrentType(@NonNull Context context) {
        int i10 = context.getResources().getConfiguration().uiMode & 15;
        int i11 = i10 != 3 ? i10 != 4 ? 1 : 2 : 4;
        if (i10 == 6) {
            return 8;
        }
        return i11;
    }

    public static String getDeviceClassName(@NonNull Context context, @NonNull Class<?> cls, int i10) {
        return cls.getName().replace(f35231b, i10 != 2 ? i10 != 4 ? i10 != 8 ? f35232c : f35235f : f35234e : f35233d);
    }
}
