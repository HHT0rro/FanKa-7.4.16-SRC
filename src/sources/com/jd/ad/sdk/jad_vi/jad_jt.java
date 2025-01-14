package com.jd.ad.sdk.jad_vi;

import android.text.TextUtils;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: EventRequestBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_jt {
    public static com.jd.ad.sdk.jad_xk.jad_fs jad_an() {
        com.jd.ad.sdk.jad_xk.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_xk.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_ob.jad_fs.jad_cp());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        return jad_fsVar;
    }

    public static byte[] jad_an(ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<jad_dq> iterator2 = concurrentLinkedQueue.iterator2();
        while (iterator2.hasNext()) {
            JSONObject jad_an = iterator2.next().jad_an();
            jad_an.put("rts", String.valueOf(System.currentTimeMillis()));
            jSONArray.put(jad_an);
        }
        jSONObject.put("param", jSONArray);
        Logger.d("XlogReport  data: " + jSONObject.toString());
        String ja2 = ANEProxy.ja(jSONObject.toString().replace("\\n", " ").replace("\\t", " ").replace("\\r", " "));
        if (TextUtils.isEmpty(ja2)) {
            return null;
        }
        return ja2.getBytes(Charset.forName("UTF-8"));
    }
}
