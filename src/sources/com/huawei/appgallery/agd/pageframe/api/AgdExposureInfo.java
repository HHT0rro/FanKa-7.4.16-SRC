package com.huawei.appgallery.agd.pageframe.api;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdExposureInfo {

    /* renamed from: a, reason: collision with root package name */
    public String f27501a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f27502b;

    /* renamed from: c, reason: collision with root package name */
    public String f27503c;

    /* renamed from: d, reason: collision with root package name */
    public String f27504d;

    public void addDetailId(@NonNull String str) {
        if (this.f27502b == null) {
            this.f27502b = new ArrayList<>();
        }
        this.f27502b.add(str);
    }

    public ArrayList<String> getDetailIdList() {
        return this.f27502b;
    }

    public String getLayoutId() {
        return this.f27501a;
    }

    public String getReferrer() {
        return this.f27503c;
    }

    public String getSlotId() {
        return this.f27504d;
    }

    public void setLayoutId(String str) {
        this.f27501a = str;
    }

    public void setReferrer(String str) {
        this.f27503c = str;
    }

    public void setSlotId(String str) {
        this.f27504d = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CardConstants.KEY_LAYOUT_ID, this.f27501a);
            JSONArray jSONArray = new JSONArray();
            ArrayList<String> arrayList = this.f27502b;
            if (arrayList != null) {
                Iterator<String> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    jSONArray.put(new JSONObject().put("detailId", iterator2.next()));
                }
            }
            jSONObject.put("detailIdList", jSONArray);
            jSONObject.put("referrer", this.f27503c);
        } catch (JSONException unused) {
            PageFrameLog.LOG.e("AgdExposureInfo", "convert to json fail");
        }
        return jSONObject.toString();
    }
}
