package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s1 {

    /* renamed from: a, reason: collision with root package name */
    public String f48148a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<r1> f48149b = new ArrayList<>();

    public s1() {
    }

    public s1(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f48148a = str;
    }

    public synchronized r1 a() {
        for (int size = this.f48149b.size() - 1; size >= 0; size--) {
            r1 r1Var = this.f48149b.get(size);
            if (r1Var.p()) {
                v1.c().l(r1Var.b());
                return r1Var;
            }
        }
        return null;
    }

    public synchronized s1 b(JSONObject jSONObject) {
        this.f48148a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f48149b.add(new r1(this.f48148a).a(jSONArray.getJSONObject(i10)));
        }
        return this;
    }

    public String c() {
        return this.f48148a;
    }

    public ArrayList<r1> d() {
        return this.f48149b;
    }

    public synchronized JSONObject e() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f48148a);
        JSONArray jSONArray = new JSONArray();
        Iterator<r1> iterator2 = this.f48149b.iterator2();
        while (iterator2.hasNext()) {
            jSONArray.put(iterator2.next().f());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void f(r1 r1Var) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.f48149b.size()) {
                break;
            }
            if (this.f48149b.get(i10).q(r1Var)) {
                this.f48149b.set(i10, r1Var);
                break;
            }
            i10++;
        }
        if (i10 >= this.f48149b.size()) {
            this.f48149b.add(r1Var);
        }
    }

    public synchronized void g(boolean z10) {
        ArrayList<r1> arrayList;
        for (int size = this.f48149b.size() - 1; size >= 0; size--) {
            r1 r1Var = this.f48149b.get(size);
            if (z10) {
                if (r1Var.w()) {
                    arrayList = this.f48149b;
                    arrayList.remove(size);
                }
            } else if (!r1Var.u()) {
                arrayList = this.f48149b;
                arrayList.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f48148a);
        sb2.append("\n");
        Iterator<r1> iterator2 = this.f48149b.iterator2();
        while (iterator2.hasNext()) {
            sb2.append((Object) iterator2.next());
        }
        return sb2.toString();
    }
}
