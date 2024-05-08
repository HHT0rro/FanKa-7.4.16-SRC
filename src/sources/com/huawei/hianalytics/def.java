package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hianalytics.log.LogTag;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class def implements EvtHeaderAttributeCollector {
    public static final String klm = LogTag.get(def.class, new Class[0]);
    public JSONObject lmn;

    public def(JSONObject jSONObject) {
        this.lmn = jSONObject;
    }

    @Override // com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector
    public JSONObject doCollector(JSONObject jSONObject, int i10) {
        if (this.lmn == null) {
            return null;
        }
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.lmn.put(next, jSONObject.getString(next));
                }
            } catch (JSONException unused) {
                HiLog.e(klm, "HiAnalyticsHeaderCollector doCollector JSONException");
            }
        }
        this.lmn.put("hmac", "");
        return this.lmn;
    }
}
