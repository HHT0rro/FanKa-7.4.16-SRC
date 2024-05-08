package com.huawei.appgallery.agd.core.impl.store.carddata;

import com.huawei.appgallery.agd.core.api.RequestConfig;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PersonalizeInfo extends JsonBean {

    @NetworkTransmission
    private Integer hwPersonalize;

    @NetworkTransmission
    private Integer personalize;

    @NetworkTransmission
    private Integer thirdPersonalize;

    @NetworkTransmission
    private String thirdPersonalizeStr;

    private PersonalizeInfo() {
    }

    public static PersonalizeInfo parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PersonalizeInfo personalizeInfo = new PersonalizeInfo();
        if (jSONObject.has(RequestConfig.PersonalizeConstant.KEY_PERSONALIZE)) {
            personalizeInfo.setPersonalize(Integer.valueOf(jSONObject.optInt(RequestConfig.PersonalizeConstant.KEY_PERSONALIZE)));
        }
        if (jSONObject.has(RequestConfig.PersonalizeConstant.KEY_HW_PERSONALIZE)) {
            personalizeInfo.setHwPersonalize(Integer.valueOf(jSONObject.optInt(RequestConfig.PersonalizeConstant.KEY_HW_PERSONALIZE)));
        }
        if (jSONObject.has(RequestConfig.PersonalizeConstant.KEY_THIRD_PERSONALIZE)) {
            personalizeInfo.setThirdPersonalize(Integer.valueOf(jSONObject.optInt(RequestConfig.PersonalizeConstant.KEY_THIRD_PERSONALIZE)));
        }
        if (jSONObject.has(RequestConfig.PersonalizeConstant.KEY_THIRD_PERSONALIZE_STR)) {
            personalizeInfo.setThirdPersonalizeStr(jSONObject.optString(RequestConfig.PersonalizeConstant.KEY_THIRD_PERSONALIZE_STR));
        }
        return personalizeInfo;
    }

    public void setHwPersonalize(Integer num) {
        this.hwPersonalize = num;
    }

    public void setPersonalize(Integer num) {
        this.personalize = num;
    }

    public void setThirdPersonalize(Integer num) {
        this.thirdPersonalize = num;
    }

    public void setThirdPersonalizeStr(String str) {
        this.thirdPersonalizeStr = str;
    }
}
