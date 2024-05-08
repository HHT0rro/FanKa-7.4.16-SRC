package com.huawei.quickcard.base.log;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardLogUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33371a = "QuickCard";

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<ILogAdapter> f33372b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList<IIdeLogAdapter> f33373c = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f33374d = false;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f33375e = false;

    private static <T> void a(@NonNull CopyOnWriteArrayList<T> copyOnWriteArrayList, T t2) {
        if (t2 != null) {
            copyOnWriteArrayList.add(t2);
        }
    }

    public static void addCardLogAdapter(IIdeLogAdapter iIdeLogAdapter) {
        a(f33373c, iIdeLogAdapter);
        f33375e = true;
    }

    public static void addEngineLogAdapter(@NonNull ILogAdapter iLogAdapter) {
        a(f33372b, iLogAdapter);
        f33374d = true;
    }

    private static <T> void b(@NonNull CopyOnWriteArrayList<T> copyOnWriteArrayList, @NonNull T t2) {
        copyOnWriteArrayList.remove(t2);
    }

    public static void d(String str, String str2, Throwable th) {
        printLogByLevel(3, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        printLogByLevel(6, str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        printLogByLevel(4, str, str2, th);
    }

    public static void print2Ide(int i10, @NonNull String str, String str2) {
        if (f33375e) {
            Iterator<IIdeLogAdapter> iterator2 = f33373c.iterator2();
            while (iterator2.hasNext()) {
                IIdeLogAdapter next = iterator2.next();
                if (next != null) {
                    next.print(i10, str, str2);
                }
            }
        }
    }

    public static void printLogByLevel(int i10, String str, String str2, Throwable th) {
        if (f33374d) {
            Iterator<ILogAdapter> iterator2 = f33372b.iterator2();
            while (iterator2.hasNext()) {
                ILogAdapter next = iterator2.next();
                if (next != null) {
                    next.print(i10, f33371a, "[" + str + "] " + str2, th);
                }
            }
        }
    }

    public static int queryCardLogCount() {
        return f33373c.size();
    }

    public static int queryEngineLogCount() {
        return f33372b.size();
    }

    public static void removeAllCardLogAdapter() {
        f33373c.clear();
    }

    public static void removeAllEngineLogAdapter() {
        f33372b.clear();
    }

    public static void removeCardLogAdapter(@NonNull IIdeLogAdapter iIdeLogAdapter) {
        b(f33373c, iIdeLogAdapter);
    }

    public static void removeEngineLogAdapter(ILogAdapter iLogAdapter) {
        b(f33372b, iLogAdapter);
    }

    public static void w(String str, String str2, Throwable th) {
        printLogByLevel(5, str, str2, th);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, Throwable th) {
        e(f33371a, str, th);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void w(String str, Throwable th) {
        w(f33371a, str, th);
    }

    public static void d(String str) {
        d(f33371a, str);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void i(String str) {
        i(f33371a, str);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void e(String str) {
        e(f33371a, str);
    }

    public static void w(String str) {
        w(f33371a, str);
    }
}
