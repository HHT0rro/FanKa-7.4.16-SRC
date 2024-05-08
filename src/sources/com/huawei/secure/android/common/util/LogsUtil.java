package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LogsUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f34768a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends Throwable {

        /* renamed from: d, reason: collision with root package name */
        private static final long f34769d = 7129050843360571879L;

        /* renamed from: a, reason: collision with root package name */
        private String f34770a;

        /* renamed from: b, reason: collision with root package name */
        private Throwable f34771b;

        /* renamed from: c, reason: collision with root package name */
        private Throwable f34772c;

        public a(Throwable th) {
            this.f34772c = th;
        }

        public void a(Throwable th) {
            this.f34771b = th;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th;
            th = this.f34771b;
            if (th == this) {
                th = null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f34770a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f34772c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f34770a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f34770a.startsWith(str)) {
                return this.f34770a;
            }
            return str + this.f34770a;
        }

        public void a(String str) {
            this.f34770a = str;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i10 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (f34768a.matcher(String.valueOf(charAt)).matches()) {
                if (i10 % 2 == 0) {
                    charAt = '*';
                }
                i10++;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(a(str2));
        }
        return sb2.toString();
    }

    public static String c(String str, boolean z10) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                sb2.append(a(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }

    public static void e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        b(str2, str3);
    }

    public static void f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, false);
    }
}
