package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.inno.innosdk.pb.InnoMain;
import org.json.JSONObject;

/* compiled from: AAIDCreateRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fy extends gd {

    /* renamed from: a, reason: collision with root package name */
    public String f5990a;

    /* renamed from: b, reason: collision with root package name */
    public String f5991b;

    /* renamed from: c, reason: collision with root package name */
    public String f5992c;

    /* renamed from: d, reason: collision with root package name */
    public String f5993d;

    /* renamed from: e, reason: collision with root package name */
    public String f5994e;

    /* renamed from: f, reason: collision with root package name */
    public String f5995f;

    /* renamed from: g, reason: collision with root package name */
    public String f5996g;

    /* renamed from: h, reason: collision with root package name */
    public String f5997h;

    /* renamed from: i, reason: collision with root package name */
    public String f5998i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f5999j;

    public fy(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p0003l.id
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f5999j;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "create");
            jSONObject.put("package_name", fj.c(this.f6046k));
            jSONObject.put(bk.f9900i, Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.6");
            String a10 = fz.a();
            this.f5990a = a10;
            jSONObject.put("t1", a10);
            String b4 = fz.b();
            this.f5991b = b4;
            jSONObject.put("t2", b4);
            String c4 = fz.c();
            this.f5992c = c4;
            jSONObject.put("t3", c4);
            String d10 = fz.d();
            this.f5993d = d10;
            jSONObject.put("s1", d10);
            String e2 = fz.e();
            this.f5994e = e2;
            jSONObject.put("s2", e2);
            String f10 = fz.f();
            this.f5995f = f10;
            jSONObject.put("s3", f10);
            String g3 = fz.g();
            this.f5996g = g3;
            jSONObject.put("s4", g3);
            jSONObject.put(Constant.MAP_KEY_UUID, fz.a(this.f6046k));
            jSONObject.put("android_id", fm.g());
            jSONObject.put("hostname", fz.h());
            String t2 = fm.t(this.f6046k);
            this.f5997h = t2;
            jSONObject.put("gaid", t2);
            String e10 = fm.e(this.f6046k);
            this.f5998i = e10;
            jSONObject.put(InnoMain.INNO_KEY_OAID, e10);
            this.f5999j = fz.a(fv.d(jSONObject.toString().getBytes("utf-8")), fv.c("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f5999j;
    }
}
