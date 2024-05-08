package com.yxcorp.kuaishou.addfp.android.b;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Process;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            Class<Integer> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("getUserId", cls2);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()))).intValue();
            Method declaredMethod2 = Class.forName("android.provider.Settings$" + str).getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, cls2);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(null, context.getContentResolver(), str2, Integer.valueOf(intValue));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
