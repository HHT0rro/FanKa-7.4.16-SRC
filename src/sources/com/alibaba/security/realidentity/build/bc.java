package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.build.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TraceLinkApi.java */
@aw(a = "rpTraceLink")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bc extends aq {
    private static final String ao = "TraceLinkApi";

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "rpTraceLink";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        try {
            RPLogging.d(ao, str);
            TrackLog trackLog = new TrackLog();
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("token");
            String optString2 = jSONObject.optString("service");
            String optString3 = jSONObject.optString("method");
            int optInt = jSONObject.optInt("code");
            String optString4 = jSONObject.optString("msg");
            String optString5 = jSONObject.optString("params");
            String optString6 = jSONObject.optString("result");
            JSONArray optJSONArray = jSONObject.optJSONArray(com.baidu.mobads.sdk.internal.bk.f9903l);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList(10);
                for (int i10 = 0; i10 < 10; i10++) {
                    arrayList.add(optJSONArray.optString(i10));
                }
                trackLog.setTags(arrayList);
            }
            trackLog.setLayer(TrackConstants.Layer.H5);
            trackLog.setService(optString2);
            trackLog.setMethod(optString3);
            trackLog.setCode(optInt);
            trackLog.setMsg(optString4);
            trackLog.setParams(optString5);
            trackLog.setResult(optString6);
            j.a.f3944a.f3895e = optString;
            j.a.f3944a.collectLog(trackLog);
            bf bfVar = new bf();
            bfVar.f3165a = 1;
            ayVar.b(bfVar);
        } catch (Exception e2) {
            RPLogging.e(ao, e2);
        }
        return true;
    }
}
