package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a2 implements Comparable<a2> {

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<q1> f47105b;

    /* renamed from: c, reason: collision with root package name */
    public String f47106c;

    /* renamed from: d, reason: collision with root package name */
    public long f47107d;

    /* renamed from: e, reason: collision with root package name */
    public int f47108e;

    public a2() {
        this(null, 0);
    }

    public a2(String str) {
        this(str, 0);
    }

    public a2(String str, int i10) {
        this.f47105b = new LinkedList<>();
        this.f47107d = 0L;
        this.f47106c = str;
        this.f47108e = i10;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a2 a2Var) {
        if (a2Var == null) {
            return 1;
        }
        return a2Var.f47108e - this.f47108e;
    }

    public synchronized a2 b(JSONObject jSONObject) {
        this.f47107d = jSONObject.getLong("tt");
        this.f47108e = jSONObject.getInt("wt");
        this.f47106c = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f47105b.add(new q1().b(jSONArray.getJSONObject(i10)));
        }
        return this;
    }

    public synchronized JSONObject c() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f47107d);
        jSONObject.put("wt", this.f47108e);
        jSONObject.put("host", this.f47106c);
        JSONArray jSONArray = new JSONArray();
        Iterator<q1> it = this.f47105b.iterator2();
        while (it.hasNext()) {
            jSONArray.put(it.next().c());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized void f(q1 q1Var) {
        if (q1Var != null) {
            this.f47105b.add(q1Var);
            int a10 = q1Var.a();
            if (a10 > 0) {
                this.f47108e += q1Var.a();
            } else {
                int i10 = 0;
                for (int size = this.f47105b.size() - 1; size >= 0 && this.f47105b.get(size).a() < 0; size--) {
                    i10++;
                }
                this.f47108e += a10 * i10;
            }
            if (this.f47105b.size() > 30) {
                this.f47108e -= this.f47105b.remove().a();
            }
        }
    }

    public String toString() {
        return this.f47106c + com.huawei.openalliance.ad.constant.u.bD + this.f47108e;
    }
}
