package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.aw;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class au extends aw.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9829a = "local";

    /* renamed from: b, reason: collision with root package name */
    private static final int f9830b = 4000;

    /* renamed from: c, reason: collision with root package name */
    private static final int f9831c = 23;

    /* renamed from: d, reason: collision with root package name */
    private static final int f9832d = 5;

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f9833e = Pattern.compile("(\\$\\d+)+$");

    /* renamed from: f, reason: collision with root package name */
    private static final char f9834f = 9556;

    /* renamed from: g, reason: collision with root package name */
    private static final char f9835g = 9562;

    /* renamed from: h, reason: collision with root package name */
    private static final char f9836h = 9567;

    /* renamed from: i, reason: collision with root package name */
    private static final char f9837i = 9553;

    /* renamed from: j, reason: collision with root package name */
    private static final String f9838j = "════════════════════════════════════════════";

    /* renamed from: k, reason: collision with root package name */
    private static final String f9839k = "------------------------------------------";

    /* renamed from: l, reason: collision with root package name */
    private static final String f9840l = "╔════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: m, reason: collision with root package name */
    private static final String f9841m = "╚════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: n, reason: collision with root package name */
    private static final String f9842n = "╟------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.aw.a
    @NonNull
    public String a() {
        return "local";
    }

    public String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = f9833e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    @Override // com.baidu.mobads.sdk.internal.aw.a
    public final String b() {
        String b4 = super.b();
        if (b4 != null) {
            return b4;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : a(stackTrace[5]);
    }

    public String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z10 = false;
        int i10 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f9833e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (!className.equals(aw.class.getName()) && !className.equals(bs.class.getName())) {
                if (z10) {
                    break;
                }
            } else {
                z10 = true;
            }
            i10++;
        }
        return "   (" + stackTrace[i10].getFileName() + com.huawei.openalliance.ad.constant.u.bD + stackTrace[i10].getLineNumber() + ")# " + stackTrace[i10].getMethodName();
    }

    @Override // com.baidu.mobads.sdk.internal.aw.a
    public void a(int i10, String str, String str2, Throwable th) {
        int min;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("当前线程：");
            sb2.append(Thread.currentThread().getName());
            sb2.append(";  ");
            sb2.append("调用位置：");
            sb2.append(c());
            sb2.append(";  ");
            sb2.append("打印消息：");
            if (str2.length() > 4000) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i11 = 0;
                while (i11 < length) {
                    int indexOf = str2.indexOf(10, i11);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i11 + 4000);
                        arrayList.add(str2.substring(i11, min));
                        if (min >= indexOf) {
                            break;
                        } else {
                            i11 = min;
                        }
                    }
                    i11 = min + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    a(i10, str, sb2.toString() + str3);
                }
                return;
            }
            sb2.append(str2);
            a(i10, str, sb2.toString());
        } catch (Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    private static void a(int i10, String str, String str2) {
        if (i10 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i10, str, str2);
        }
    }
}
