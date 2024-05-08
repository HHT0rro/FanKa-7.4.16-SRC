package com.mobile.auth.gatewayauth.utils;

import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.core.ExecutorManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f37391a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f37392b = true;

    public static void a(String str) {
        try {
            if (f37391a) {
                TextUtils.isEmpty(str);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(Throwable th) {
        try {
            if (!f37391a || th == null) {
                return;
            }
            ExecutorManager.getErrorInfoFromException(th);
        } catch (Throwable th2) {
            try {
                ExceptionProcessor.processException(th2);
            } catch (Throwable th3) {
                ExceptionProcessor.processException(th3);
            }
        }
    }

    public static void a(boolean z10) {
        try {
            f37391a = z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static boolean a() {
        try {
            return f37391a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static void b(String str) {
        try {
            if (f37391a) {
                TextUtils.isEmpty(str);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void b(boolean z10) {
        try {
            f37392b = z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static boolean b() {
        try {
            return f37392b;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static void c(String str) {
        try {
            TextUtils.isEmpty(str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void d(String str) {
        try {
            if (f37391a) {
                TextUtils.isEmpty(str);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
