package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.build.j;
import org.json.JSONObject;

/* compiled from: OptionApi.java */
@aw(a = "option")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bq extends aq {
    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "option";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        j.a.f3944a.f3905o = System.currentTimeMillis();
        try {
            String optString = new JSONObject(str).optString(aq.f3108d);
            if (!TextUtils.isEmpty(optString)) {
                j.a.f3944a.f3895e = optString;
            }
        } catch (Exception e2) {
            aq.a("option api get token fail", e2);
        }
        j.a.f3944a.d();
        bf bfVar = new bf();
        String str2 = VersionKey.RP_SDK_VERSION;
        if (!TextUtils.isEmpty(a.f2995a) && !TextUtils.isEmpty(str2)) {
            bfVar.a(aq.f3121q, a.f2995a);
            bfVar.a(aq.f3122r, str2);
            bfVar.a(aq.f3123s, a.f2996b);
            bfVar.a(aq.f3124t, VersionKey.FL_SDK_VERSION);
            Context context = this.al;
            if (context != null && (context instanceof RPWebViewActivity)) {
                bfVar.a(aq.f3125u, "false");
            } else {
                bfVar.a(aq.f3125u, "true");
            }
            bfVar.f3165a = 1;
            ayVar.b(bfVar);
            a(bfVar, true);
        } else {
            a(aq.a(ayVar, aq.f3106b), false);
        }
        return true;
    }
}
