package com.ishumei.smantifraud.l111l11111Il;

import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l1111l111111Il extends l111l1111llIl<l111l11111lIl> {
    public l1111l111111Il(String str, String str2, l11l1111lIIl.l111l11111lIl<l111l11111lIl> l111l11111lil, l11l1111lIIl.l1111l111111Il l1111l111111il) {
        super(1, str, str2, null, l111l11111lil, l1111l111111il);
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111llIl, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public final l11l1111lIIl<l111l11111lIl> l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111llIl l111l1111llil) {
        try {
            JSONObject jSONObject = new JSONObject(new String(l111l1111llil.l1111l111111Il));
            JSONObject optJSONObject = jSONObject.optJSONObject("detail");
            if (optJSONObject != null && optJSONObject.has("data")) {
                return l11l1111lIIl.l1111l111111Il(new l111l11111lIl(jSONObject.optInt("code", -1), jSONObject.optString("requestId", ""), optJSONObject));
            }
        } catch (JSONException unused) {
        }
        return l11l1111lIIl.l1111l111111Il(new l11l1111I1ll("no conf data", -4));
    }
}
