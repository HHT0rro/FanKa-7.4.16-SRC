package com.alibaba.security.realidentity.build;

import com.alibaba.security.biometrics.skin.RPSkinManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetSkinInfoApi.java */
@aw(a = "skinInfo,rpGetSkinInfo")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bp extends aq {
    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "getSkinInfo";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        bf bfVar = new bf();
        try {
            bfVar.a(aq.f3101aa, new JSONObject(RPSkinManager.getInstance().getAllWebSkinData()));
            bfVar.f3165a = 1;
            ayVar.b(bfVar);
            a(bfVar, true);
            return true;
        } catch (JSONException unused) {
            aq.a(ayVar);
            return false;
        }
    }
}
