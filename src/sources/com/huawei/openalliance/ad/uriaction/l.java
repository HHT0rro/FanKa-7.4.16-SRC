package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.dz;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.au;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l extends q {
    private static String C = "arContentVertify";
    private static String S = "1";
    private static final String V = "OpenArAction";
    public Map<String, String> Code;

    public l(Context context, AdContentData adContentData, Map<String, String> map) {
        super(context, adContentData);
        this.Code = map;
    }

    private boolean Code(AdContentData adContentData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", adContentData.S());
            jSONObject.put("templateId", adContentData.az());
            jSONObject.put("slotid", adContentData.C());
            jSONObject.put("apiVer", adContentData.aA());
            String str = (String) com.huawei.openalliance.ad.ipc.b.Code(this.I).Code(C, jSONObject.toString(), String.class).getData();
            gl.V(V, "result:" + str);
            if (!au.Code(str) && S.equalsIgnoreCase(str)) {
                return true;
            }
            eo.Code(this.I, adContentData.S(), adContentData, str);
            return false;
        } catch (JSONException unused) {
            gl.I(V, "isArContentPrepared JSONException");
            return false;
        }
    }

    private boolean V(AdContentData adContentData) {
        if (!dz.Code(this.I, adContentData, this.Code)) {
            return false;
        }
        Code(t.L);
        return true;
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        AdContentData adContentData = this.Z;
        if (adContentData == null) {
            gl.I(V, "contentRecord is null");
            eo.Code(this.I, "", (AdContentData) null, com.huawei.openalliance.ad.constant.n.Code);
            return V();
        }
        if (Code(adContentData)) {
            return V(this.Z);
        }
        gl.V(V, "ar content is not prepared");
        return V();
    }
}
