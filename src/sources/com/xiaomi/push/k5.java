package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.material.datepicker.UtcDates;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class k5 {

    /* renamed from: j, reason: collision with root package name */
    public static final String f47913j = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: k, reason: collision with root package name */
    public static String f47914k = null;

    /* renamed from: l, reason: collision with root package name */
    public static final DateFormat f47915l;

    /* renamed from: m, reason: collision with root package name */
    public static String f47916m;

    /* renamed from: n, reason: collision with root package name */
    public static long f47917n;

    /* renamed from: a, reason: collision with root package name */
    public String f47918a;

    /* renamed from: b, reason: collision with root package name */
    public String f47919b;

    /* renamed from: c, reason: collision with root package name */
    public String f47920c;

    /* renamed from: d, reason: collision with root package name */
    public String f47921d;

    /* renamed from: e, reason: collision with root package name */
    public String f47922e;

    /* renamed from: f, reason: collision with root package name */
    public String f47923f;

    /* renamed from: g, reason: collision with root package name */
    public List<h5> f47924g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f47925h;

    /* renamed from: i, reason: collision with root package name */
    public n5 f47926i;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f47915l = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        f47916m = u5.a(5) + "-";
        f47917n = 0L;
    }

    public k5() {
        this.f47918a = f47914k;
        this.f47919b = null;
        this.f47920c = null;
        this.f47921d = null;
        this.f47922e = null;
        this.f47923f = null;
        this.f47924g = new CopyOnWriteArrayList();
        this.f47925h = new HashMap();
        this.f47926i = null;
    }

    public k5(Bundle bundle) {
        this.f47918a = f47914k;
        this.f47919b = null;
        this.f47920c = null;
        this.f47921d = null;
        this.f47922e = null;
        this.f47923f = null;
        this.f47924g = new CopyOnWriteArrayList();
        this.f47925h = new HashMap();
        this.f47926i = null;
        this.f47920c = bundle.getString("ext_to");
        this.f47921d = bundle.getString("ext_from");
        this.f47922e = bundle.getString("ext_chid");
        this.f47919b = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f47924g = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                h5 c4 = h5.c((Bundle) parcelable);
                if (c4 != null) {
                    this.f47924g.add(c4);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f47926i = new n5(bundle2);
        }
    }

    public static synchronized String k() {
        String sb2;
        synchronized (k5.class) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f47916m);
            long j10 = f47917n;
            f47917n = 1 + j10;
            sb3.append(Long.toString(j10));
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static String x() {
        return f47913j;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f47918a)) {
            bundle.putString("ext_ns", this.f47918a);
        }
        if (!TextUtils.isEmpty(this.f47921d)) {
            bundle.putString("ext_from", this.f47921d);
        }
        if (!TextUtils.isEmpty(this.f47920c)) {
            bundle.putString("ext_to", this.f47920c);
        }
        if (!TextUtils.isEmpty(this.f47919b)) {
            bundle.putString("ext_pkt_id", this.f47919b);
        }
        if (!TextUtils.isEmpty(this.f47922e)) {
            bundle.putString("ext_chid", this.f47922e);
        }
        n5 n5Var = this.f47926i;
        if (n5Var != null) {
            bundle.putBundle("ext_ERROR", n5Var.a());
        }
        List<h5> list = this.f47924g;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i10 = 0;
            Iterator<h5> iterator2 = this.f47924g.iterator2();
            while (iterator2.hasNext()) {
                Bundle a10 = iterator2.next().a();
                if (a10 != null) {
                    bundleArr[i10] = a10;
                    i10++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public h5 b(String str) {
        return c(str, null);
    }

    public h5 c(String str, String str2) {
        for (h5 h5Var : this.f47924g) {
            if (str2 == null || str2.equals(h5Var.j())) {
                if (str.equals(h5Var.e())) {
                    return h5Var;
                }
            }
        }
        return null;
    }

    public n5 d() {
        return this.f47926i;
    }

    public synchronized Object e(String str) {
        Map<String, Object> map = this.f47925h;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k5 k5Var = (k5) obj;
        n5 n5Var = this.f47926i;
        if (n5Var == null ? k5Var.f47926i != null : !n5Var.equals(k5Var.f47926i)) {
            return false;
        }
        String str = this.f47921d;
        if (str == null ? k5Var.f47921d != null : !str.equals(k5Var.f47921d)) {
            return false;
        }
        if (!this.f47924g.equals(k5Var.f47924g)) {
            return false;
        }
        String str2 = this.f47919b;
        if (str2 == null ? k5Var.f47919b != null : !str2.equals(k5Var.f47919b)) {
            return false;
        }
        String str3 = this.f47922e;
        if (str3 == null ? k5Var.f47922e != null : !str3.equals(k5Var.f47922e)) {
            return false;
        }
        Map<String, Object> map = this.f47925h;
        if (map == null ? k5Var.f47925h != null : !map.equals(k5Var.f47925h)) {
            return false;
        }
        String str4 = this.f47920c;
        if (str4 == null ? k5Var.f47920c != null : !str4.equals(k5Var.f47920c)) {
            return false;
        }
        String str5 = this.f47918a;
        String str6 = k5Var.f47918a;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public abstract String f();

    public synchronized Collection<h5> g() {
        if (this.f47924g == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f47924g));
    }

    public void h(h5 h5Var) {
        this.f47924g.add(h5Var);
    }

    public int hashCode() {
        String str = this.f47918a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f47919b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f47920c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f47921d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f47922e;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f47924g.hashCode()) * 31) + this.f47925h.hashCode()) * 31;
        n5 n5Var = this.f47926i;
        return hashCode5 + (n5Var != null ? n5Var.hashCode() : 0);
    }

    public void i(n5 n5Var) {
        this.f47926i = n5Var;
    }

    public synchronized Collection<String> j() {
        if (this.f47925h == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f47925h.h()));
    }

    public String l() {
        if ("ID_NOT_AVAILABLE".equals(this.f47919b)) {
            return null;
        }
        if (this.f47919b == null) {
            this.f47919b = k();
        }
        return this.f47919b;
    }

    public String m() {
        return this.f47922e;
    }

    public void n(String str) {
        this.f47919b = str;
    }

    public String o() {
        return this.f47920c;
    }

    public void p(String str) {
        this.f47922e = str;
    }

    public String q() {
        return this.f47921d;
    }

    public void r(String str) {
        this.f47920c = str;
    }

    public String s() {
        return this.f47923f;
    }

    public void t(String str) {
        this.f47921d = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x010d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String u() {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.k5.u():java.lang.String");
    }

    public void v(String str) {
        this.f47923f = str;
    }

    public String w() {
        return this.f47918a;
    }
}
