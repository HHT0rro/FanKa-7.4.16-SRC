package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile UserManager f23785a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f23786b = !b();

    public static boolean a(Context context) {
        return b() && !c(context);
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean c(Context context) {
        boolean z10 = f23786b;
        if (!z10) {
            UserManager userManager = f23785a;
            if (userManager == null) {
                synchronized (a.class) {
                    userManager = f23785a;
                    if (userManager == null) {
                        UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                        f23785a = userManager2;
                        if (userManager2 == null) {
                            f23786b = true;
                            return true;
                        }
                        userManager = userManager2;
                    }
                }
            }
            z10 = userManager.isUserUnlocked();
            f23786b = z10;
            if (z10) {
                f23785a = null;
            }
        }
        return z10;
    }
}
