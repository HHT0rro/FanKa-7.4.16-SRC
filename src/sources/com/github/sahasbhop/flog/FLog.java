package com.github.sahasbhop.flog;

import android.os.Process;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FLog {

    /* renamed from: a, reason: collision with root package name */
    public static String f19299a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f19300b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f19301c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f19302d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f19303e;

    /* renamed from: f, reason: collision with root package name */
    public static final DateFormat f19304f = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.SSS", Locale.ENGLISH);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum LogType {
        ERROR,
        WARNING,
        DEBUG,
        INFO,
        VERBOSE
    }

    public static synchronized void a(String str, Object... objArr) {
        synchronized (FLog.class) {
            String format = String.format(str, objArr);
            String str2 = null;
            StackTraceElement e2 = e();
            if (e2 != null) {
                str2 = f(e2);
                format = d(e2, format);
            }
            boolean z10 = f19301c;
            if (f19302d) {
                System.out.println(format);
            }
            if (f19303e) {
                i(LogType.DEBUG, str2, format);
            }
        }
    }

    public static synchronized void b(String str, Object... objArr) {
        synchronized (FLog.class) {
            String format = String.format(str, objArr);
            String str2 = null;
            StackTraceElement e2 = e();
            if (e2 != null) {
                str2 = f(e2);
                format = d(e2, format);
            }
            boolean z10 = f19301c;
            if (f19302d) {
                System.out.println(format);
            }
            if (f19303e) {
                i(LogType.ERROR, str2, format);
            }
        }
    }

    public static String c(LogType logType, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str2), 256);
            Date date = new Date();
            date.setTime(System.currentTimeMillis());
            String format = f19304f.format(date);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(String.format("%s: ", format));
                sb2.append(String.format("%s/%s(%d): ", logType, str, Integer.valueOf(Process.myPid())));
                sb2.append(readLine);
                sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        } catch (IOException unused) {
        }
        return sb2.toString();
    }

    public static String d(StackTraceElement stackTraceElement, String str) {
        return stackTraceElement == null ? str : String.format("%s # %s", stackTraceElement.getMethodName(), str);
    }

    public static StackTraceElement e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length < 5) {
            return null;
        }
        return stackTrace[4];
    }

    public static String f(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return null;
        }
        String className = stackTraceElement.getClassName();
        if (className == null) {
            return className;
        }
        String[] split = className.split("\\.");
        return split.length > 0 ? split[split.length - 1] : className;
    }

    public static synchronized void g(String str, Object... objArr) {
        synchronized (FLog.class) {
            String format = String.format(str, objArr);
            String str2 = null;
            StackTraceElement e2 = e();
            if (e2 != null) {
                str2 = f(e2);
                format = d(e2, format);
            }
            boolean z10 = f19301c;
            if (f19302d) {
                System.out.println(format);
            }
            if (f19303e) {
                i(LogType.VERBOSE, str2, format);
            }
        }
    }

    public static synchronized void h(String str, Object... objArr) {
        synchronized (FLog.class) {
            String format = String.format(str, objArr);
            String str2 = null;
            StackTraceElement e2 = e();
            if (e2 != null) {
                str2 = f(e2);
                format = d(e2, format);
            }
            boolean z10 = f19301c;
            if (f19302d) {
                System.out.println(format);
            }
            if (f19303e) {
                i(LogType.WARNING, str2, format);
            }
        }
    }

    public static synchronized void i(LogType logType, String str, String str2) {
        String str3;
        synchronized (FLog.class) {
            String str4 = f19299a;
            if (str4 != null && !str4.equals("") && (str3 = f19300b) != null && !str3.equals("")) {
                File file = new File(f19299a);
                if (!file.exists()) {
                    try {
                        file.mkdirs();
                    } catch (SecurityException unused) {
                    }
                }
                if (file.canWrite()) {
                    String c4 = c(logType, str, str2);
                    File file2 = new File(f19299a + f19300b);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new StringReader(c4), 256);
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2, true), 256);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            bufferedWriter.append((CharSequence) readLine);
                            bufferedWriter.append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        }
    }
}
