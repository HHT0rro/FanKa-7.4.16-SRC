package com.huawei.hms.common.util;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Logger {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f29763a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final String f29764b = "Logger";

    /* renamed from: c, reason: collision with root package name */
    public static final String f29765c = "|";

    /* renamed from: d, reason: collision with root package name */
    public static final int f29766d = 8;

    /* renamed from: e, reason: collision with root package name */
    public static final int f29767e = 20;

    /* renamed from: f, reason: collision with root package name */
    public static final String f29768f = "dynamic-api_";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends Throwable {

        /* renamed from: d, reason: collision with root package name */
        public static final long f29769d = 7129050843360571879L;

        /* renamed from: a, reason: collision with root package name */
        public String f29770a;

        /* renamed from: b, reason: collision with root package name */
        public Throwable f29771b;

        /* renamed from: c, reason: collision with root package name */
        public Throwable f29772c;

        public b(Throwable th) {
            this.f29772c = th;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Throwable th) {
            this.f29771b = th;
        }

        public void a(String str) {
            this.f29770a = str;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.f29771b;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f29770a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f29772c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f29770a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f29770a.startsWith(str)) {
                return this.f29770a;
            }
            return str + this.f29770a;
        }
    }

    public static int a(int i10, String str, String str2) {
        return Log.println(i10, a(str), a(str2, 7));
    }

    public static String a(int i10) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i10) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return Process.myPid() + "-" + Process.myTid() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    public static String a(String str) {
        return f29768f + str;
    }

    public static String a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return a(i10);
        }
        return a(i10) + "|" + str;
    }

    public static Throwable a(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        if (th == null) {
            return null;
        }
        int i10 = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
        b bVar = new b(th);
        StackTraceElement[] stackTrace = bVar.getStackTrace();
        if (stackTrace.length > i10) {
            bVar.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i10));
        } else {
            bVar.setStackTrace(stackTrace);
        }
        bVar.a(anonymizeMessage(th.getMessage()));
        Throwable cause = th.getCause();
        b bVar2 = bVar;
        while (cause != null) {
            b bVar3 = new b(cause);
            bVar3.a(anonymizeMessage(cause.getMessage()));
            bVar2.a(bVar3);
            cause = cause.getCause();
            bVar2 = bVar3;
        }
        return bVar;
    }

    public static String anonymizeMessage(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 == 1) {
                charArray[i10] = '*';
            }
        }
        return new String(charArray);
    }

    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    public static void e(String str, String str2, Throwable th) {
        a(str);
        a(str2, 5);
        a(th);
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isLoggable(int i10) {
        return Log.isLoggable(f29768f, i10);
    }

    public static void println(int i10, String str, Object obj) {
        if (i10 >= 3 && isLoggable(i10)) {
            a(i10, str, obj == null ? "null" : obj.toString());
        }
    }

    public static void println(int i10, String str, String str2, Object... objArr) {
        if (i10 >= 3 && str2 != null) {
            try {
                if (isLoggable(i10)) {
                    a(i10, str, format(str2, objArr));
                }
            } catch (IllegalFormatException e2) {
                w(f29764b, "log format error" + str2, e2);
            }
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    public static void w(String str, String str2, Throwable th) {
        a(str);
        a(str2, 5);
        a(th);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }
}
