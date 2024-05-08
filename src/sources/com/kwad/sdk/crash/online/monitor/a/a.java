package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public List<String> aGO = new ArrayList();
    public List<String> aGP = new ArrayList();
    public List<String> aGQ = new ArrayList();
    public List<String> aGR = new ArrayList();
    public List<b> aGS = new ArrayList();
    public Map<String, b> aGT = new HashMap();
    public int aGU;
    public int aGV;
    public int aGW;
    public double aor;

    public final boolean HU() {
        return (this.aGW & 4) != 0;
    }

    public final boolean HV() {
        return (this.aGW & 1) != 0;
    }

    public final boolean HW() {
        return (this.aGW & 2) != 0;
    }

    public final boolean HX() {
        return this.aGW == 0;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.aGS;
        if (list != null) {
            for (b bVar : list) {
                this.aGT.put(bVar.appId, bVar);
            }
            this.aGS.clear();
        }
    }

    @Nullable
    public final b fz(String str) {
        if (this.aGT == null) {
            return null;
        }
        b bVar = TextUtils.isEmpty(str) ? null : this.aGT.get(str);
        return bVar == null ? this.aGT.get("000000000") : bVar;
    }
}
