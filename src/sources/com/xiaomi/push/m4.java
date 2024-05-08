package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.service.aq;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m4 {
    public static void a(aq.b bVar, String str, u4 u4Var) {
        String b4;
        j3 j3Var = new j3();
        if (!TextUtils.isEmpty(bVar.f48224c)) {
            j3Var.k(bVar.f48224c);
        }
        if (!TextUtils.isEmpty(bVar.f48227f)) {
            j3Var.t(bVar.f48227f);
        }
        if (!TextUtils.isEmpty(bVar.f48228g)) {
            j3Var.w(bVar.f48228g);
        }
        j3Var.n(bVar.f48226e ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f48225d)) {
            j3Var.q("XIAOMI-SASL");
        } else {
            j3Var.q(bVar.f48225d);
        }
        n4 n4Var = new n4();
        n4Var.u(bVar.f48223b);
        n4Var.g(Integer.parseInt(bVar.f48229h));
        n4Var.r(bVar.f48222a);
        n4Var.j("BIND", null);
        n4Var.i(n4Var.w());
        fc.c.i("[Slim]: bind id=" + n4Var.w());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f48224c);
        hashMap.put("chid", bVar.f48229h);
        hashMap.put(RemoteMessageConst.FROM, bVar.f48223b);
        hashMap.put("id", n4Var.w());
        hashMap.put(RemoteMessageConst.TO, "xiaomi.com");
        if (bVar.f48226e) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f48227f)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.f48227f);
        }
        if (TextUtils.isEmpty(bVar.f48228g)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f48228g);
        }
        if (bVar.f48225d.equals("XIAOMI-PASS") || bVar.f48225d.equals("XMPUSH-PASS")) {
            b4 = n0.b(bVar.f48225d, null, hashMap, bVar.f48230i);
        } else {
            bVar.f48225d.equals("XIAOMI-SASL");
            b4 = null;
        }
        j3Var.z(b4);
        n4Var.l(j3Var.h(), null);
        u4Var.u(n4Var);
    }

    public static void b(String str, String str2, u4 u4Var) {
        n4 n4Var = new n4();
        n4Var.u(str2);
        n4Var.g(Integer.parseInt(str));
        n4Var.j("UBND", null);
        u4Var.u(n4Var);
    }
}
