package com.xiaomi.push;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r1 {

    /* renamed from: a, reason: collision with root package name */
    public String f48113a;

    /* renamed from: b, reason: collision with root package name */
    public long f48114b;

    /* renamed from: d, reason: collision with root package name */
    public String f48116d;

    /* renamed from: e, reason: collision with root package name */
    public String f48117e;

    /* renamed from: f, reason: collision with root package name */
    public String f48118f;

    /* renamed from: g, reason: collision with root package name */
    public String f48119g;

    /* renamed from: h, reason: collision with root package name */
    public String f48120h;

    /* renamed from: i, reason: collision with root package name */
    public String f48121i;

    /* renamed from: j, reason: collision with root package name */
    public String f48122j;

    /* renamed from: k, reason: collision with root package name */
    public String f48123k;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<a2> f48115c = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    public double f48124l = 0.1d;

    /* renamed from: m, reason: collision with root package name */
    public String f48125m = "s.mi1.cc";

    /* renamed from: n, reason: collision with root package name */
    public long f48126n = 86400000;

    public r1(String str) {
        this.f48113a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f48114b = System.currentTimeMillis();
        this.f48115c.add(new a2(str, -1));
        this.f48113a = v1.d();
        this.f48116d = str;
    }

    public synchronized r1 a(JSONObject jSONObject) {
        this.f48113a = jSONObject.optString("net");
        this.f48126n = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f48124l = jSONObject.getDouble("pct");
        this.f48114b = jSONObject.getLong("ts");
        this.f48118f = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
        this.f48117e = jSONObject.optString("prv");
        this.f48121i = jSONObject.optString("cty");
        this.f48119g = jSONObject.optString("isp");
        this.f48120h = jSONObject.optString("ip");
        this.f48116d = jSONObject.optString("host");
        this.f48122j = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            i(new a2().b(jSONArray.getJSONObject(i10)));
        }
        return this;
    }

    public synchronized String b() {
        if (!TextUtils.isEmpty(this.f48123k)) {
            return this.f48123k;
        }
        if (TextUtils.isEmpty(this.f48119g)) {
            return "hardcode_isp";
        }
        String g3 = p0.g(new String[]{this.f48119g, this.f48117e, this.f48118f, this.f48121i, this.f48120h}, "_");
        this.f48123k = g3;
        return g3;
    }

    public synchronized ArrayList<String> c() {
        return e(false);
    }

    public ArrayList<String> d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (!TextUtils.equals(url.getHost(), this.f48116d)) {
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> iterator2 = e(true).iterator2();
        while (iterator2.hasNext()) {
            t1 b4 = t1.b(iterator2.next(), url.getPort());
            arrayList.add(new URL(url.getProtocol(), b4.c(), b4.a(), url.getFile()).toString());
        }
        return arrayList;
    }

    public synchronized ArrayList<String> e(boolean z10) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f48115c.size();
        a2[] a2VarArr = new a2[size];
        this.f48115c.toArray(a2VarArr);
        Arrays.sort(a2VarArr);
        arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < size; i10++) {
            a2 a2Var = a2VarArr[i10];
            if (z10) {
                substring = a2Var.f47106c;
            } else {
                int indexOf = a2Var.f47106c.indexOf(com.huawei.openalliance.ad.constant.u.bD);
                substring = indexOf != -1 ? a2Var.f47106c.substring(0, indexOf) : a2Var.f47106c;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    public synchronized JSONObject f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f48113a);
        jSONObject.put(RemoteMessageConst.TTL, this.f48126n);
        jSONObject.put("pct", this.f48124l);
        jSONObject.put("ts", this.f48114b);
        jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.f48118f);
        jSONObject.put("prv", this.f48117e);
        jSONObject.put("cty", this.f48121i);
        jSONObject.put("isp", this.f48119g);
        jSONObject.put("ip", this.f48120h);
        jSONObject.put("host", this.f48116d);
        jSONObject.put("xf", this.f48122j);
        JSONArray jSONArray = new JSONArray();
        Iterator<a2> iterator2 = this.f48115c.iterator2();
        while (iterator2.hasNext()) {
            jSONArray.put(iterator2.next().c());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void g(double d10) {
        this.f48124l = d10;
    }

    public void h(long j10) {
        if (j10 > 0) {
            this.f48126n = j10;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j10);
    }

    public synchronized void i(a2 a2Var) {
        v(a2Var.f47106c);
        this.f48115c.add(a2Var);
    }

    public synchronized void j(String str) {
        i(new a2(str));
    }

    public void k(String str, int i10, long j10, long j11, Exception exc) {
        n(str, new q1(i10, j10, j11, exc));
    }

    public void l(String str, long j10, long j11) {
        try {
            s(new URL(str).getHost(), j10, j11);
        } catch (MalformedURLException unused) {
        }
    }

    public void m(String str, long j10, long j11, Exception exc) {
        try {
            t(new URL(str).getHost(), j10, j11, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r1.f(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void n(java.lang.String r4, com.xiaomi.push.q1 r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.a2> r0 = r3.f48115c     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator2()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.a2 r1 = (com.xiaomi.push.a2) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.f47106c     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.f(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.r1.n(java.lang.String, com.xiaomi.push.q1):void");
    }

    public synchronized void o(String[] strArr) {
        int i10;
        int size = this.f48115c.size() - 1;
        while (true) {
            i10 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i10 < length) {
                    if (TextUtils.equals(this.f48115c.get(size).f47106c, strArr[i10])) {
                        this.f48115c.remove(size);
                        break;
                    }
                    i10++;
                }
            }
            size--;
        }
        Iterator<a2> iterator2 = this.f48115c.iterator2();
        int i11 = 0;
        while (iterator2.hasNext()) {
            int i12 = iterator2.next().f47108e;
            if (i12 > i11) {
                i11 = i12;
            }
        }
        while (i10 < strArr.length) {
            i(new a2(strArr[i10], (strArr.length + i11) - i10));
            i10++;
        }
    }

    public boolean p() {
        return TextUtils.equals(this.f48113a, v1.d());
    }

    public boolean q(r1 r1Var) {
        return TextUtils.equals(this.f48113a, r1Var.f48113a);
    }

    public void r(String str) {
        this.f48125m = str;
    }

    public void s(String str, long j10, long j11) {
        k(str, 0, j10, j11, null);
    }

    public void t(String str, long j10, long j11, Exception exc) {
        k(str, -1, j10, j11, exc);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f48113a);
        sb2.append("\n");
        sb2.append(b());
        Iterator<a2> iterator2 = this.f48115c.iterator2();
        while (iterator2.hasNext()) {
            a2 next = iterator2.next();
            sb2.append("\n");
            sb2.append(next.toString());
        }
        sb2.append("\n");
        return sb2.toString();
    }

    public boolean u() {
        return System.currentTimeMillis() - this.f48114b < this.f48126n;
    }

    public final synchronized void v(String str) {
        Iterator<a2> iterator2 = this.f48115c.iterator2();
        while (iterator2.hasNext()) {
            if (TextUtils.equals(iterator2.next().f47106c, str)) {
                iterator2.remove();
            }
        }
    }

    public boolean w() {
        long j10 = this.f48126n;
        if (864000000 >= j10) {
            j10 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f48114b;
        return currentTimeMillis - j11 > j10 || (currentTimeMillis - j11 > this.f48126n && this.f48113a.startsWith("WIFI-"));
    }
}
