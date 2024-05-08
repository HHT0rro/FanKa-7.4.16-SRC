package com.ishumei.smantifraud.l1111l111111Il;

import android.text.TextUtils;
import com.ishumei.smantifraud.SmAntiFraud;
import com.ishumei.smantifraud.dfp.SMSDK;
import com.ishumei.smantifraud.l1111l111111Il.l11l1111Il;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l11l111l11Il {
    private final int l1111l111111Il;
    private final InputStream l111l11111I1l;
    private final byte[] l111l11111Il;
    private final int l111l11111lIl;

    public l11l111l11Il() {
    }

    public l11l111l11Il(int i10, byte[] bArr) {
        this.l1111l111111Il = i10;
        this.l111l11111lIl = bArr.length;
        this.l111l11111Il = bArr;
        this.l111l11111I1l = null;
    }

    public static String l1111l111111Il(Set<JSONObject> set, JSONObject jSONObject, boolean z10) {
        String str;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("organization", SmAntiFraud.option.l11l1111I1l());
            com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il();
            String l111l11111lIl = com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l111l11111lIl();
            if (TextUtils.isEmpty(l111l11111lIl)) {
                l111l11111lIl = "";
                str = l111l11111lIl;
            } else if (l111l11111lIl.startsWith("B")) {
                str = "";
            } else {
                str = l111l11111lIl;
                l111l11111lIl = "";
            }
            if (TextUtils.isEmpty(l111l11111lIl)) {
                l111l11111lIl = com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l1111lIl();
                if (TextUtils.isEmpty(l111l11111lIl)) {
                    l111l11111lIl = com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l111l1111llIl();
                }
            }
            if (!TextUtils.isEmpty(l111l11111lIl)) {
                jSONObject2.put("smid", l111l11111lIl);
            } else if (z10) {
                jSONObject2.put("smid", str);
            } else {
                jSONObject2.put("smid", "");
            }
            JSONArray jSONArray = new JSONArray((Collection) set);
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
            jSONObject2.put("appId", SmAntiFraud.option.l11l11IlIIll());
            jSONObject2.put("appname", com.ishumei.smantifraud.l111l11111I1l.l111l11111lIl.l111l11111I1l());
            jSONObject2.put("sessionId", com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l11111lIl);
            jSONObject2.put("wevent", jSONArray);
            return SMSDK.v3(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il, jSONObject2.toString(), SmAntiFraud.option.l111l11111Il(), SmAntiFraud.option.l11l1111I1l(), SmAntiFraud.option.l11l11IlIIll());
        } catch (Throwable th) {
            return l11l1111Il.l1111l111111Il.l1111l111111Il.l1111l111111Il(th);
        }
    }

    public int l1111l111111Il() {
        return this.l1111l111111Il;
    }

    public byte[] l111l11111I1l() {
        return this.l111l11111Il;
    }

    public InputStream l111l11111Il() {
        if (this.l111l11111Il != null) {
            return new ByteArrayInputStream(this.l111l11111Il);
        }
        return null;
    }

    public int l111l11111lIl() {
        return this.l111l11111lIl;
    }
}
