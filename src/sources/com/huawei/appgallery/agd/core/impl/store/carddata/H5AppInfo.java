package com.huawei.appgallery.agd.core.impl.store.carddata;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import n9.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class H5AppInfo extends JsonBean {
    private static final String TAG = "H5AppInfo";
    private String appName;
    private String downloadParams;
    private String iconUrl;

    @NonNull
    public static H5AppInfo parse(@NonNull JSONObject jSONObject) {
        H5AppInfo h5AppInfo = new H5AppInfo();
        if (jSONObject.has(CardConstants.KEY_REFS_APP)) {
            try {
                h5AppInfo.appName = jSONObject.getJSONObject(CardConstants.KEY_REFS_APP).getString("name");
                h5AppInfo.iconUrl = jSONObject.getJSONObject(CardConstants.KEY_REFS_APP).getString("icon");
            } catch (JSONException unused) {
                a.f52175d.e(TAG, "H5AppInfo parse with JSONException");
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("downloadParams");
        if (optJSONObject != null) {
            h5AppInfo.downloadParams = optJSONObject.toString();
        }
        return h5AppInfo;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getDownloadParams() {
        return this.downloadParams;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setDownloadParams(String str) {
        this.downloadParams = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }
}
