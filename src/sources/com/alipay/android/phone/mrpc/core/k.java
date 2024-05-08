package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import com.google.android.material.datepicker.UtcDates;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f4236a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f4237b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f4238a;

        /* renamed from: b, reason: collision with root package name */
        public int f4239b;

        /* renamed from: c, reason: collision with root package name */
        public int f4240c;

        public a(int i10, int i11, int i12) {
            this.f4238a = i10;
            this.f4239b = i11;
            this.f4240c = i12;
        }
    }

    public static long a(String str) {
        int c4;
        int d10;
        int i10;
        a aVar;
        int i11;
        int i12;
        int i13;
        Matcher matcher = f4236a.matcher(str);
        if (matcher.find()) {
            i10 = b(matcher.group(1));
            c4 = c(matcher.group(2));
            d10 = d(matcher.group(3));
            aVar = e(matcher.group(4));
        } else {
            Matcher matcher2 = f4237b.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            c4 = c(matcher2.group(1));
            int b4 = b(matcher2.group(2));
            a e2 = e(matcher2.group(3));
            d10 = d(matcher2.group(4));
            i10 = b4;
            aVar = e2;
        }
        if (d10 >= 2038) {
            i11 = 1;
            i12 = 0;
            i13 = 2038;
        } else {
            i11 = i10;
            i12 = c4;
            i13 = d10;
        }
        Time time = new Time(UtcDates.UTC);
        time.set(aVar.f4240c, aVar.f4239b, aVar.f4238a, i11, i12, i13);
        return time.toMillis(false);
    }

    private static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    private static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static int d(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        }
        if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        }
        if (str.length() == 4) {
            return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
        }
        return 1970;
    }

    private static a e(String str) {
        int i10;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i10 = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i10 = 1;
        }
        int i11 = i10 + 1 + 1 + 1 + 1;
        return new a(charAt, ((str.charAt(r2) - '0') * 10) + (str.charAt(r3) - '0'), ((str.charAt(i11) - '0') * 10) + (str.charAt(i11 + 1) - '0'));
    }
}
