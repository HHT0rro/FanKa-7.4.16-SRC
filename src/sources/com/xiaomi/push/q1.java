package com.xiaomi.push;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q1 {

    /* renamed from: a, reason: collision with root package name */
    public int f48089a;

    /* renamed from: b, reason: collision with root package name */
    public long f48090b;

    /* renamed from: c, reason: collision with root package name */
    public long f48091c;

    /* renamed from: d, reason: collision with root package name */
    public String f48092d;

    /* renamed from: e, reason: collision with root package name */
    public long f48093e;

    public q1() {
        this(0, 0L, 0L, null);
    }

    public q1(int i10, long j10, long j11, Exception exc) {
        this.f48089a = i10;
        this.f48090b = j10;
        this.f48093e = j11;
        this.f48091c = System.currentTimeMillis();
        if (exc != null) {
            this.f48092d = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f48089a;
    }

    public q1 b(JSONObject jSONObject) {
        this.f48090b = jSONObject.getLong("cost");
        this.f48093e = jSONObject.getLong("size");
        this.f48091c = jSONObject.getLong("ts");
        this.f48089a = jSONObject.getInt("wt");
        this.f48092d = jSONObject.optString("expt");
        return this;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f48090b);
        jSONObject.put("size", this.f48093e);
        jSONObject.put("ts", this.f48091c);
        jSONObject.put("wt", this.f48089a);
        jSONObject.put("expt", this.f48092d);
        return jSONObject;
    }
}
