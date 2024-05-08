package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a0 implements g {

    /* renamed from: a, reason: collision with root package name */
    private Context f30056a = q0.i();

    /* renamed from: b, reason: collision with root package name */
    private String f30057b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f30058c;

    /* renamed from: d, reason: collision with root package name */
    private String f30059d;

    /* renamed from: e, reason: collision with root package name */
    private String f30060e;

    /* renamed from: f, reason: collision with root package name */
    private String f30061f;

    /* renamed from: g, reason: collision with root package name */
    private String f30062g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f30063h;

    public a0(String str, JSONObject jSONObject, String str2, String str3, long j10) {
        this.f30057b = str;
        this.f30058c = jSONObject;
        this.f30059d = str2;
        this.f30060e = str3;
        this.f30061f = String.valueOf(j10);
        if (z.i(str2, FrameworkConstant.DataType.STRING_OPER)) {
            p0 a10 = y.a().a(str2, j10);
            this.f30062g = a10.a();
            this.f30063h = Boolean.valueOf(a10.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        v.c("hmsSdk", "Begin to run EventRecordTask...");
        int h10 = q0.h();
        int k10 = a1.k(this.f30059d, this.f30060e);
        if (c0.a(this.f30056a, "stat_v2_1", h10 * 1048576)) {
            v.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            e.a().a("", "alltype");
            return;
        }
        b1 b1Var = new b1();
        b1Var.b(this.f30057b);
        b1Var.a(this.f30058c.toString());
        b1Var.d(this.f30060e);
        b1Var.c(this.f30061f);
        b1Var.f(this.f30062g);
        Boolean bool = this.f30063h;
        b1Var.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d10 = b1Var.d();
            String a10 = n1.a(this.f30059d, this.f30060e);
            String a11 = d.a(this.f30056a, "stat_v2_1", a10, "");
            try {
                jSONArray = !TextUtils.isEmpty(a11) ? new JSONArray(a11) : new JSONArray();
            } catch (JSONException unused) {
                v.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(d10);
            d.b(this.f30056a, "stat_v2_1", a10, jSONArray.toString());
            if (jSONArray.toString().length() > k10 * 1024) {
                e.a().a(this.f30059d, this.f30060e);
            }
        } catch (JSONException unused2) {
            v.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
