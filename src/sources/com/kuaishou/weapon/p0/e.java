package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36106a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f36107b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f36108c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f36109d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f36110e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static int f36111f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static ThreadLocal<StringBuilder> f36112g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    private static int f36113h;

    private static void a(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            return;
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb2 = f36112g.get();
        if (sb2 == null) {
            sb2 = new StringBuilder();
            f36112g.set(sb2);
        }
        synchronized (sb2) {
            sb2.setLength(0);
            sb2.append("[");
            sb2.append(f36113h);
            sb2.append("][");
            sb2.append(fileName);
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            sb2.append(lineNumber);
            sb2.append('.');
            sb2.append(methodName);
            sb2.append("] ");
            sb2.append(str);
            f36113h++;
        }
    }

    public static void b(String str) {
        int i10 = f36111f;
        if (i10 == -1 || i10 == 0 || i10 == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i10 = f36111f;
        if (i10 == -1 || i10 == 0 || i10 == 1 || i10 == 2) {
            a(2, str);
        }
    }

    public static void d(String str) {
    }

    public static void b(String str, Throwable th) {
        int i10 = f36111f;
        if (i10 == -1 || i10 == 0 || i10 == 1) {
            a(1, str + "\n" + a(th));
        }
    }

    public static void c(String str, Throwable th) {
        int i10 = f36111f;
        if (i10 == -1 || i10 == 0 || i10 == 1 || i10 == 2) {
            a(2, str + "\n" + a(th));
        }
    }

    public static void a(String str) {
        int i10 = f36111f;
        if (i10 == -1 || i10 == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i10 = f36111f;
        if (i10 == -1 || i10 == 0) {
            a(0, str + "\n" + a(th));
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
