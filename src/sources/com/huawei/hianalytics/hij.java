package com.huawei.hianalytics;

import com.huawei.hianalytics.core.crypto.AesCipher;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class hij implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        HiLog.i("ABTest/ReadCacheDataTask", "read cache task running");
        try {
            JSONArray jSONArray = new JSONObject(AesCipher.decryptCbc(j0.lmn("abtest", "exp_data", ""), q.lmn().klm())).getJSONArray("parameters");
            ijk[] ijkVarArr = new ijk[jSONArray.length()];
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String string = jSONObject.getString("groupId");
                String string2 = jSONObject.getString("key");
                ijkVarArr[i10] = new ijk(jSONObject.getString("value"), string);
                concurrentHashMap.put(string2, ijkVarArr[i10]);
            }
        } catch (JSONException unused) {
            HiLog.w("ABTest/ReadCacheDataTask", "experiment data error");
        }
        ikl iklVar = ikl.hij;
        synchronized (iklVar) {
            iklVar.ikl = true;
        }
        ikl iklVar2 = ikl.hij;
        synchronized (iklVar2) {
            iklVar2.klm = false;
        }
    }
}
