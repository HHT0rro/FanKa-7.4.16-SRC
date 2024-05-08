package org.joda.time.chrono;

import java.text.DateFormatSymbols;
import java.util.Comparator;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* compiled from: GJLocaleSymbols.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k {

    /* renamed from: p, reason: collision with root package name */
    public static ConcurrentMap<Locale, k> f52509p = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String[] f52510a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f52511b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f52512c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f52513d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f52514e;

    /* renamed from: f, reason: collision with root package name */
    public final String[] f52515f;

    /* renamed from: g, reason: collision with root package name */
    public final TreeMap<String, Integer> f52516g;

    /* renamed from: h, reason: collision with root package name */
    public final TreeMap<String, Integer> f52517h;

    /* renamed from: i, reason: collision with root package name */
    public final TreeMap<String, Integer> f52518i;

    /* renamed from: j, reason: collision with root package name */
    public final int f52519j;

    /* renamed from: k, reason: collision with root package name */
    public final int f52520k;

    /* renamed from: l, reason: collision with root package name */
    public final int f52521l;

    /* renamed from: m, reason: collision with root package name */
    public final int f52522m;

    /* renamed from: n, reason: collision with root package name */
    public final int f52523n;

    /* renamed from: o, reason: collision with root package name */
    public final int f52524o;

    public k(Locale locale) {
        DateFormatSymbols d10 = org.joda.time.c.d(locale);
        this.f52510a = d10.getEras();
        this.f52511b = u(d10.getWeekdays());
        this.f52512c = u(d10.getShortWeekdays());
        this.f52513d = v(d10.getMonths());
        this.f52514e = v(d10.getShortMonths());
        this.f52515f = d10.getAmPmStrings();
        Integer[] numArr = new Integer[13];
        for (int i10 = 0; i10 < 13; i10++) {
            numArr[i10] = Integer.valueOf(i10);
        }
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        TreeMap<String, Integer> treeMap = new TreeMap<>(comparator);
        this.f52516g = treeMap;
        b(treeMap, this.f52510a, numArr);
        if ("en".equals(locale.getLanguage())) {
            treeMap.put("BCE", numArr[0]);
            treeMap.put("CE", numArr[1]);
        }
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(comparator);
        this.f52517h = treeMap2;
        b(treeMap2, this.f52511b, numArr);
        b(treeMap2, this.f52512c, numArr);
        a(treeMap2, 1, 7, numArr);
        TreeMap<String, Integer> treeMap3 = new TreeMap<>(comparator);
        this.f52518i = treeMap3;
        b(treeMap3, this.f52513d, numArr);
        b(treeMap3, this.f52514e, numArr);
        a(treeMap3, 1, 12, numArr);
        this.f52519j = q(this.f52510a);
        this.f52520k = q(this.f52511b);
        this.f52521l = q(this.f52512c);
        this.f52522m = q(this.f52513d);
        this.f52523n = q(this.f52514e);
        this.f52524o = q(this.f52515f);
    }

    public static void a(TreeMap<String, Integer> treeMap, int i10, int i11, Integer[] numArr) {
        while (i10 <= i11) {
            treeMap.put(String.valueOf(i10).intern(), numArr[i10]);
            i10++;
        }
    }

    public static void b(TreeMap<String, Integer> treeMap, String[] strArr, Integer[] numArr) {
        int length = strArr.length;
        while (true) {
            length--;
            if (length < 0) {
                return;
            }
            String str = strArr[length];
            if (str != null) {
                treeMap.put(str, numArr[length]);
            }
        }
    }

    public static k h(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        k kVar = f52509p.get(locale);
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(locale);
        k putIfAbsent = f52509p.putIfAbsent(locale, kVar2);
        return putIfAbsent != null ? putIfAbsent : kVar2;
    }

    public static int q(String[] strArr) {
        int length;
        int length2 = strArr.length;
        int i10 = 0;
        while (true) {
            length2--;
            if (length2 < 0) {
                return i10;
            }
            String str = strArr[length2];
            if (str != null && (length = str.length()) > i10) {
                i10 = length;
            }
        }
    }

    public static String[] u(String[] strArr) {
        String[] strArr2 = new String[8];
        int i10 = 1;
        while (i10 < 8) {
            strArr2[i10] = strArr[i10 < 7 ? i10 + 1 : 1];
            i10++;
        }
        return strArr2;
    }

    public static String[] v(String[] strArr) {
        String[] strArr2 = new String[13];
        for (int i10 = 1; i10 < 13; i10++) {
            strArr2[i10] = strArr[i10 - 1];
        }
        return strArr2;
    }

    public int c(String str) {
        Integer num = this.f52517h.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.dayOfWeek(), str);
    }

    public String d(int i10) {
        return this.f52512c[i10];
    }

    public String e(int i10) {
        return this.f52511b[i10];
    }

    public int f(String str) {
        Integer num = this.f52516g.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.era(), str);
    }

    public String g(int i10) {
        return this.f52510a[i10];
    }

    public int i() {
        return this.f52521l;
    }

    public int j() {
        return this.f52520k;
    }

    public int k() {
        return this.f52519j;
    }

    public int l() {
        return this.f52524o;
    }

    public int m() {
        return this.f52523n;
    }

    public int n() {
        return this.f52522m;
    }

    public int o(String str) {
        String[] strArr = this.f52515f;
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                throw new IllegalFieldValueException(DateTimeFieldType.halfdayOfDay(), str);
            }
        } while (!strArr[length].equalsIgnoreCase(str));
        return length;
    }

    public String p(int i10) {
        return this.f52515f[i10];
    }

    public int r(String str) {
        Integer num = this.f52518i.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(DateTimeFieldType.monthOfYear(), str);
    }

    public String s(int i10) {
        return this.f52514e[i10];
    }

    public String t(int i10) {
        return this.f52513d[i10];
    }
}
