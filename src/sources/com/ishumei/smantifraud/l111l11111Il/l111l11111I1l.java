package com.ishumei.smantifraud.l111l11111Il;

import android.text.TextUtils;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l11111I1l extends l111l1111llIl<l111l11111Il> {
    public l111l11111I1l(String str, String str2, l11l1111lIIl.l111l11111lIl<l111l11111Il> l111l11111lil, l11l1111lIIl.l1111l111111Il l1111l111111il) {
        super(1, str, str2, null, l111l11111lil, l1111l111111il);
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111llIl, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public final l11l1111lIIl<l111l11111Il> l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111llIl l111l1111llil) {
        try {
            JSONObject jSONObject = new JSONObject(new String(l111l1111llil.l1111l111111Il));
            int optInt = jSONObject.optInt("code", -1);
            l111l11111Il l111l11111il = new l111l11111Il(optInt, jSONObject.optString("requestId"), jSONObject.optString("deviceId"), jSONObject.optJSONObject("detail"));
            if (!TextUtils.isEmpty(l111l11111il.l111l11111lIl())) {
                return l11l1111lIIl.l1111l111111Il(l111l11111il);
            }
            if (optInt == 1902) {
                this.l1111l111111Il = null;
            }
            return l11l1111lIIl.l1111l111111Il(new l11l1111I1ll(optInt));
        } catch (Exception unused) {
            return l11l1111lIIl.l1111l111111Il(new l11l1111I1ll(-3));
        }
    }
}
