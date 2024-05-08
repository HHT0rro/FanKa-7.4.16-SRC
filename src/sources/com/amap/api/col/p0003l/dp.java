package com.amap.api.col.p0003l;

import java.util.Locale;
import java.util.Random;
import java.util.zip.ZipUtils;

/* compiled from: RandomUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dp {

    /* renamed from: a, reason: collision with root package name */
    private static String f5368a = "0123456789";

    /* compiled from: RandomUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f5369a;

        /* renamed from: b, reason: collision with root package name */
        private int f5370b;

        /* renamed from: c, reason: collision with root package name */
        private int f5371c;

        public a(String str, int i10) {
            this.f5370b = 1103515245;
            this.f5371c = 12345;
            this.f5369a = a(str, i10, str.length());
        }

        private char a(int i10) {
            this.f5369a.length();
            return this.f5369a.charAt(i10);
        }

        private int b(int i10) {
            return (int) (((i10 * this.f5370b) + this.f5371c) & ZipUtils.UPPER_UNIXTIME_BOUND);
        }

        private String b(int i10, String str) {
            StringBuilder sb2 = new StringBuilder();
            int length = this.f5369a.length();
            int length2 = str.length();
            for (int i11 = 0; i11 < length2; i11++) {
                int a10 = a(str.charAt(i11));
                if (a10 < 0) {
                    break;
                }
                sb2.append(a(((a10 + i10) + i11) % length));
            }
            if (sb2.length() == length2) {
                return sb2.toString();
            }
            return null;
        }

        private int a(char c4) {
            this.f5369a.length();
            return this.f5369a.indexOf(c4);
        }

        private String a(String str, int i10, int i11) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i12 = 0; i12 < i11; i12++) {
                int b4 = b(i10);
                int i13 = b4 % length;
                i10 = b(b4);
                int i14 = i10 % length;
                char charAt = stringBuffer.charAt(i13);
                stringBuffer.setCharAt(i13, stringBuffer.charAt(i14));
                stringBuffer.setCharAt(i14, charAt);
            }
            return stringBuffer.toString();
        }

        public a() {
            this((byte) 0);
        }

        private a(byte b4) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }

        public final String a(int i10, String str) {
            return b(i10, str);
        }
    }

    public static String a() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        Locale locale = Locale.US;
        String format = String.format(locale, "%05d", Integer.valueOf(nextInt));
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        return new a(f5368a, nextInt3).a(nextInt2, format) + String.format(locale, "%01d", Integer.valueOf(nextInt2)) + String.format(locale, "%02d", Integer.valueOf(nextInt3));
    }
}
