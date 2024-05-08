package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.inno.innosdk.pb.InnoMain;
import org.json.JSONObject;

/* compiled from: AAIDCreateRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cl extends cq {

    /* renamed from: a, reason: collision with root package name */
    public String f7545a;

    /* renamed from: b, reason: collision with root package name */
    public String f7546b;

    /* renamed from: c, reason: collision with root package name */
    public String f7547c;

    /* renamed from: d, reason: collision with root package name */
    public String f7548d;

    /* renamed from: e, reason: collision with root package name */
    public String f7549e;

    /* renamed from: f, reason: collision with root package name */
    public String f7550f;

    /* renamed from: g, reason: collision with root package name */
    public String f7551g;

    /* renamed from: h, reason: collision with root package name */
    public String f7552h;

    /* renamed from: i, reason: collision with root package name */
    public String f7553i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f7554j;

    public cl(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] h() {
        byte[] bArr = this.f7554j;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put("package_name", bw.c(this.f7576k));
            jSONObject.put(com.baidu.mobads.sdk.internal.bk.f9900i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.5");
            String a10 = cm.a();
            this.f7545a = a10;
            jSONObject.put("t1", a10);
            String b4 = cm.b();
            this.f7546b = b4;
            jSONObject.put("t2", b4);
            String c4 = cm.c();
            this.f7547c = c4;
            jSONObject.put("t3", c4);
            String d10 = cm.d();
            this.f7548d = d10;
            jSONObject.put("s1", d10);
            String e2 = cm.e();
            this.f7549e = e2;
            jSONObject.put("s2", e2);
            String f10 = cm.f();
            this.f7550f = f10;
            jSONObject.put("s3", f10);
            String g3 = cm.g();
            this.f7551g = g3;
            jSONObject.put("s4", g3);
            jSONObject.put(Constant.MAP_KEY_UUID, cm.a(this.f7576k));
            jSONObject.put("android_id", ca.g());
            jSONObject.put("hostname", cm.h());
            String o10 = ca.o(this.f7576k);
            this.f7552h = o10;
            jSONObject.put("gaid", o10);
            String e10 = ca.e(this.f7576k);
            this.f7553i = e10;
            jSONObject.put(InnoMain.INNO_KEY_OAID, e10);
            this.f7554j = cm.a(ci.d(jSONObject.toString().getBytes("utf-8")), ci.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f7554j;
    }
}
