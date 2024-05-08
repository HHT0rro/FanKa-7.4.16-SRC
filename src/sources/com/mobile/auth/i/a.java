package com.mobile.auth.i;

import android.text.TextUtils;
import com.mobile.auth.k.d;
import com.mobile.auth.k.g;
import com.mobile.auth.l.c;
import com.mobile.auth.n.q;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f37409a;

    /* renamed from: b, reason: collision with root package name */
    private String f37410b;

    private c a(String str, String str2, String str3, g gVar) {
        c cVar = new c(str, gVar, str3, str2);
        if (str3.equals("GET")) {
            cVar.a("Content-Type", "application/x-www-form-urlencoded");
        }
        return cVar;
    }

    public c a(c cVar, com.mobile.auth.m.b bVar, com.cmic.sso.sdk.a aVar) {
        List<String> list;
        Map<String, List<String>> b4 = bVar.b();
        if (TextUtils.isEmpty(this.f37409a) && (list = b4.get("pplocation")) != null && list.size() > 0) {
            this.f37409a = list.get(0);
        }
        q.b(aVar, String.valueOf(bVar.a()));
        List<String> list2 = b4.get("Location");
        if (list2 == null || list2.isEmpty()) {
            list2 = b4.get("Location".toLowerCase());
        }
        if (list2 != null && list2.size() > 0) {
            String str = list2.get(0);
            this.f37410b = str;
            if (!TextUtils.isEmpty(str)) {
                String b10 = aVar.b("operatortype", "0");
                q.a(aVar, "2".equals(b10) ? "getUnicomMobile" : "3".equals(b10) ? "getTelecomMobile" : "NONE");
            }
        }
        c a10 = a(this.f37410b, cVar.f(), "GET", new com.mobile.auth.k.c(cVar.k().a()));
        a10.a(cVar.h());
        return a10;
    }

    public String a() {
        return this.f37409a;
    }

    public c b(c cVar, com.mobile.auth.m.b bVar, com.cmic.sso.sdk.a aVar) {
        String b4 = aVar.b("operatortype", "0");
        q.a(aVar, "2".equals(b4) ? "getNewUnicomPhoneNumberNotify" : "3".equals(b4) ? "getNewTelecomPhoneNumberNotify" : "NONE");
        q.b(aVar, String.valueOf(bVar.a()));
        d dVar = new d(cVar.k().a(), "1.0", bVar.c());
        dVar.c(aVar.b("userCapaid"));
        dVar.b(aVar.c("logintype") != 3 ? "authz" : "pre");
        c a10 = a(this.f37409a, cVar.f(), "POST", dVar);
        a10.a(cVar.h());
        this.f37409a = null;
        return a10;
    }
}
