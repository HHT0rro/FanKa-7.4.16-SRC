package com.google.gson.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class JavaVersion {

    /* renamed from: a, reason: collision with root package name */
    public static final int f26880a = a();

    private JavaVersion() {
    }

    public static int a() {
        return c(System.getProperty("java.version"));
    }

    public static int b(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb2.append(charAt);
            }
            return Integer.parseInt(sb2.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c(String str) {
        int e2 = e(str);
        if (e2 == -1) {
            e2 = b(str);
        }
        if (e2 == -1) {
            return 6;
        }
        return e2;
    }

    public static boolean d() {
        return f26880a >= 9;
    }

    public static int e(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
