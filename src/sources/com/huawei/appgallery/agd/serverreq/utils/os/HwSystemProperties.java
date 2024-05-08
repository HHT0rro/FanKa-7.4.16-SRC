package com.huawei.appgallery.agd.serverreq.utils.os;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HwSystemProperties {

    /* renamed from: a, reason: collision with root package name */
    public static Class<?> f27559a;

    static {
        try {
            f27559a = ReflectionHelper.loadClass("android.os.SystemProperties");
        } catch (ClassNotFoundException unused) {
            f27559a = null;
        }
    }

    public static <T> T a(String str, T t2, String str2, Class<?> cls) {
        Class<?> cls2 = f27559a;
        if (cls2 == null) {
            return t2;
        }
        try {
            return (T) ReflectionHelper.invokeMethod(ReflectionHelper.loadMethod(cls2, str2, String.class, cls), null, str, t2);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return t2;
        }
    }

    public static String get(String str, String str2) {
        return (String) a(str, str2, MonitorConstants.CONNECT_TYPE_GET, String.class);
    }
}
