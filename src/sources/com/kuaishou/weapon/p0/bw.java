package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class bw {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f35883d = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private Context f35884a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35885b;

    /* renamed from: c, reason: collision with root package name */
    private int f35886c;

    public bw(Context context, int i10, boolean z10) {
        this.f35884a = context;
        this.f35885b = z10;
        this.f35886c = i10;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            h a10 = h.a(this.f35884a, "re_po_rt");
            boolean e2 = a10.e("a1_p_s_p_s");
            boolean e10 = a10.e("a1_p_s_p_s_c_b");
            jSONObject.put("11006", e2 ? 1 : 0);
            jSONObject.put("11029", e10 ? 1 : 0);
            if (a10.b(df.au, 1) == 1 && (e2 || e10)) {
                String a11 = bh.a(this.f35884a);
                if (!TextUtils.isEmpty(a11) && !a11.startsWith("RISK")) {
                    jSONObject.put("01001", f.a(a11));
                }
                String c4 = bh.c(this.f35884a);
                if (!TextUtils.isEmpty(c4) && !c4.startsWith("RISK")) {
                    jSONObject.put("01003", c4);
                }
                String b4 = bh.b(this.f35884a, 0);
                if (!TextUtils.isEmpty(b4) && !b4.startsWith("RISK")) {
                    jSONObject.put("01019", b4);
                }
                String b10 = bh.b(this.f35884a, 1);
                if (!TextUtils.isEmpty(b10) && !b10.startsWith("RISK")) {
                    jSONObject.put("01004", f.a(b10));
                }
            }
            int b11 = a10.b(df.at, 1);
            if (b11 == 1 && (e2 || e10)) {
                String f10 = bh.f(this.f35884a);
                if (!TextUtils.isEmpty(f10) && !f10.startsWith("RISK")) {
                    jSONObject.put("01013", f10);
                }
            }
            if (a10.b(df.av, 1) == 1 && (e2 || e10)) {
                String d10 = bh.d(this.f35884a);
                if (!TextUtils.isEmpty(d10) && !d10.startsWith("RISK")) {
                    jSONObject.put("01007", d10);
                }
            }
            if (a10.b(df.aw, 1) == 1 && (e2 || e10)) {
                jSONObject.put("01011", bh.e(this.f35884a));
            }
            if (e2 || e10) {
                String h10 = bh.h();
                if (!TextUtils.isEmpty(h10) && !h10.startsWith("RISK")) {
                    jSONObject.put("07005", h10);
                } else if (h10 == null) {
                    jSONObject.put("07005", "");
                } else {
                    jSONObject.put("07005", h10);
                }
                jSONObject.put("07006", bh.g());
            }
            if (a10.b(df.ay, 1) == 1 && (e2 || e10)) {
                String p10 = bh.p(this.f35884a);
                if (!TextUtils.isEmpty(p10) && !p10.startsWith("RISK")) {
                    jSONObject.put("01016", p10);
                }
            }
            if (e2 || e10) {
                try {
                    double b12 = bh.b();
                    if (b12 > ShadowDrawableWrapper.COS_45) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(b12);
                        jSONObject.put("09002", sb2.toString());
                    }
                    double c10 = bh.c();
                    if (c10 > ShadowDrawableWrapper.COS_45) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(c10);
                        jSONObject.put("09003", sb3.toString());
                    }
                } catch (Exception unused) {
                }
            }
            jSONObject.put("11013", Integer.parseInt(bx.a(this.f35884a.getApplicationContext()), 2));
            jSONObject.put("11012", bx.b(this.f35884a));
            try {
                jSONObject.put("11202", bh.b(com.kwad.sdk.f.b.Is().Ih()));
                jSONObject.put("11204", bh.b(com.kwad.sdk.f.b.Is().Io()));
                jSONObject.put("11205", bh.b(com.kwad.sdk.f.b.Is().getDeviceId()));
                jSONObject.put("11206", bh.b(com.kwad.sdk.f.b.Is().getIccId()));
                jSONObject.put("11207", bh.b(com.kwad.sdk.f.b.Is().Ig()));
                jSONObject.put("11208", bh.b(com.kwad.sdk.f.b.Is().Ij()));
                jSONObject.put("11209", bh.b(com.kwad.sdk.f.b.Is().Ik()));
                jSONObject.put("11210", bh.b(com.kwad.sdk.f.b.Is().Il()));
                jSONObject.put("11211", bh.b(com.kwad.sdk.f.b.Is().getIp()));
                jSONObject.put("11212", bh.b(com.kwad.sdk.f.b.Is().getLocation()));
                jSONObject.put("11213", bh.b(com.kwad.sdk.f.b.Is().getOaid()));
                jSONObject.put("11214", bh.b(com.kwad.sdk.f.b.Is().Ii()));
                jSONObject.put("11215", bh.b(com.kwad.sdk.f.b.Is().In()));
                jSONObject.put("11216", bh.b(com.kwad.sdk.f.b.Is().Im()));
                jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                jSONObject.put("11104", com.kwad.sdk.f.b.Is().Io());
                jSONObject.put("11105", com.kwad.sdk.f.b.Is().getDeviceId());
                jSONObject.put("11106", com.kwad.sdk.f.b.Is().getIccId());
                jSONObject.put("11107", com.kwad.sdk.f.b.Is().Ig());
                jSONObject.put("11108", com.kwad.sdk.f.b.Is().Ij());
                jSONObject.put("11109", com.kwad.sdk.f.b.Is().Ik());
                jSONObject.put("11110", com.kwad.sdk.f.b.Is().Il());
                jSONObject.put("11111", com.kwad.sdk.f.b.Is().getIp());
                jSONObject.put("11112", com.kwad.sdk.f.b.Is().getLocation());
                jSONObject.put("11113", com.kwad.sdk.f.b.Is().getOaid());
                jSONObject.put("11114", com.kwad.sdk.f.b.Is().Ii());
                jSONObject.put("11115", com.kwad.sdk.f.b.Is().In());
                jSONObject.put("11116", com.kwad.sdk.f.b.Is().Im());
            } catch (Throwable unused2) {
            }
            String w3 = bh.w(this.f35884a);
            if (!TextUtils.isEmpty(w3)) {
                jSONObject.put("01026", w3);
            }
            if (b11 == 1) {
                try {
                    JSONObject a12 = ai.a(this.f35884a);
                    if (a12 != null) {
                        jSONObject.put("11015", a12);
                    }
                    if (Engine.loadSuccess) {
                        ce ceVar = new ce(this.f35884a);
                        jSONObject.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                        jSONObject.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                        jSONObject.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                        jSONObject.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                        jSONObject.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                        jSONObject.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                        jSONObject.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                        jSONObject.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                        jSONObject.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                        jSONObject.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                    } else {
                        jSONObject.put("02001", bl.a());
                        jSONObject.put("02002", bl.b());
                        jSONObject.put("02003", bl.c());
                        jSONObject.put("02004", bl.d());
                        jSONObject.put("02005", bl.e());
                        jSONObject.put("02006", bl.f());
                        jSONObject.put("02007", bl.g());
                        jSONObject.put("02018", bl.s());
                        jSONObject.put("02013", bl.m());
                        jSONObject.put("02016", bl.q());
                    }
                    jSONObject.put("02021", bl.d(this.f35884a));
                    jSONObject.put("02022", bl.c(this.f35884a));
                    jSONObject.put("02044", bl.t());
                    jSONObject.put("11009", bs.a(this.f35884a.getApplicationContext()));
                    if (Engine.loadSuccess) {
                        bz bzVar = new bz(this.f35884a);
                        jSONObject.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : "");
                        jSONObject.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : "");
                        jSONObject.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : "");
                        jSONObject.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : "");
                    } else {
                        try {
                            bj b13 = bk.b();
                            jSONObject.put("04001", bk.a());
                            jSONObject.put("04002", b13.b());
                            jSONObject.put("04003", b13.c());
                            jSONObject.put("04004", b13.a());
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                    return null;
                }
            }
            if (this.f35885b) {
                jSONObject.put("20004", 1);
            }
            jSONObject.put("11017", jSONObject.toString().length());
            jSONObject.put("20000", this.f35886c);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused5) {
            return null;
        }
    }

    public String a(String str) {
        try {
            synchronized (f35883d) {
                JSONObject a10 = new cm(str, ck.f35942l).a(this.f35884a);
                if (a10 == null) {
                    return null;
                }
                JSONObject a11 = a();
                if (a11 == null) {
                    return null;
                }
                a10.put("module_section", a11);
                return a10.toString();
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
