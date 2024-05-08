package com.vivo.push.util;

import android.os.UserHandle;
import java.lang.reflect.Method;

/* compiled from: MultiUserManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static int f46455a = -1;

    public static int a() {
        int i10 = f46455a;
        if (i10 != -1) {
            return i10;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            f46455a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            u.d("MultiUserManager", "getMyUserId = " + f46455a);
            return f46455a;
        } catch (Exception e2) {
            u.a("MultiUserManager", "getMyUserId error " + e2.getMessage());
            return 0;
        }
    }
}
