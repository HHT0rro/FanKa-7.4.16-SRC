package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.j;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PushConfigSettings.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends c<com.vivo.push.model.a> {
    public e(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.c
    public final String a() {
        return "com.vivo.pushservice.other";
    }

    @Override // com.vivo.push.cache.c
    public final List<com.vivo.push.model.a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("@#")) {
            String trim = str2.trim();
            String[] split = trim.trim().split(",");
            if (split.length >= 2) {
                try {
                    arrayList.add(new com.vivo.push.model.a(split[0], trim.substring(split[0].length() + 1)));
                } catch (Exception e2) {
                    u.d("PushConfigSettings", "str2Clients E: ".concat(String.valueOf(e2)));
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.c
    public final String b(String str) throws Exception {
        return new String(j.a(j.a(e()), j.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final String c(String str) {
        synchronized (c.f46141a) {
            for (com.vivo.push.model.a aVar : this.f46142b) {
                if (!TextUtils.isEmpty(aVar.a()) && aVar.a().equals(str)) {
                    return aVar.b();
                }
            }
            return null;
        }
    }
}