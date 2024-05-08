package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MaliciousAppsListResp extends BaseResp {
    public ArrayList<MaliciousAppsData> maliciousAppsList = new ArrayList<>();

    public MaliciousAppsListResp(String str) throws JSONException {
        JSONArray optJSONArray = new JSONObject(str).optJSONArray("harmfulAppsList");
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            this.maliciousAppsList.add(new MaliciousAppsData(optJSONArray.getString(i10)));
        }
    }

    public ArrayList<MaliciousAppsData> getMaliciousAppsList() {
        return this.maliciousAppsList;
    }

    public void setMaliciousAppsList(ArrayList<MaliciousAppsData> arrayList) {
        this.maliciousAppsList = arrayList;
    }
}
