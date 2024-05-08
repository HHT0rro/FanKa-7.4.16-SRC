package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d implements b {
    public List<e> aIS;
    public long intervalTime;

    public final long IV() {
        long j10 = this.intervalTime;
        if (j10 > 0) {
            return j10;
        }
        return 5000L;
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.aIS = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("configList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                e eVar = new e();
                eVar.parseJson(optJSONArray.optJSONObject(i10));
                this.aIS.add(eVar);
            }
        }
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
