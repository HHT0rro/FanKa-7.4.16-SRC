package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cm {

    /* renamed from: a, reason: collision with root package name */
    private String f35960a;

    /* renamed from: b, reason: collision with root package name */
    private String f35961b;

    /* renamed from: c, reason: collision with root package name */
    private String f35962c;

    /* renamed from: d, reason: collision with root package name */
    private String f35963d;

    /* renamed from: e, reason: collision with root package name */
    private String f35964e;

    /* renamed from: f, reason: collision with root package name */
    private String f35965f;

    /* renamed from: g, reason: collision with root package name */
    private String f35966g;

    /* renamed from: h, reason: collision with root package name */
    private String f35967h;

    /* renamed from: i, reason: collision with root package name */
    private String f35968i;

    /* renamed from: j, reason: collision with root package name */
    private String f35969j;

    /* renamed from: k, reason: collision with root package name */
    private String f35970k;

    /* renamed from: l, reason: collision with root package name */
    private String f35971l;

    public cm(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        this.f35968i = sb2.toString();
        this.f35962c = str;
        this.f35966g = str2;
    }

    public static String m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.f35960a);
            jSONObject.put("2", this.f35961b);
            jSONObject.put("3", this.f35962c);
            jSONObject.put("4", this.f35963d);
            jSONObject.put("5", this.f35964e);
            jSONObject.put("6", this.f35965f);
            jSONObject.put("7", this.f35966g);
            jSONObject.put("8", this.f35967h);
            jSONObject.put("9", this.f35968i);
            jSONObject.put("11", this.f35969j);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, this.f35971l);
            jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "com.kuaishou.weapon");
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.f35960a;
    }

    public String b() {
        return this.f35961b;
    }

    public String c() {
        return this.f35962c;
    }

    public String d() {
        return this.f35963d;
    }

    public String e() {
        return this.f35964e;
    }

    public String f() {
        return this.f35965f;
    }

    public String g() {
        return this.f35966g;
    }

    public String h() {
        return this.f35967h;
    }

    public String i() {
        return this.f35968i;
    }

    public String j() {
        return this.f35969j;
    }

    public String k() {
        return this.f35970k;
    }

    public String l() {
        return this.f35971l;
    }

    public void a(String str) {
        this.f35960a = str;
    }

    public void b(String str) {
        this.f35961b = str;
    }

    public void c(String str) {
        this.f35962c = str;
    }

    public void d(String str) {
        this.f35963d = str;
    }

    public void e(String str) {
        this.f35964e = str;
    }

    public void f(String str) {
        this.f35965f = str;
    }

    public void g(String str) {
        this.f35966g = str;
    }

    public void h(String str) {
        this.f35967h = str;
    }

    public void i(String str) {
        this.f35968i = str;
    }

    public void j(String str) {
        this.f35969j = str;
    }

    public void k(String str) {
        this.f35970k = str;
    }

    public void l(String str) {
        this.f35971l = str;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bi.f35852v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h a10 = h.a(context, "re_po_rt");
            boolean e2 = a10.e("a1_p_s_p_s");
            boolean e10 = a10.e("a1_p_s_p_s_c_b");
            if (e2 || e10) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bi.f35852v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bi.f35852v = 4;
        return "";
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bh.q(context));
            e(bh.r(context));
            f(bh.s(context));
            h("5.3.0");
            j(bt.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }
}
