package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.GetActRequestParam;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseCallback;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GetFaceActiveCompareType {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class GetFaceCompareTypeResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, String str2, boolean z10, String str3, SelectData selectData, BaseCallback<GetFaceCompareTypeResponse> baseCallback) {
        String str4 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getResPath(z10) + "?version=" + Param.getVersion(z10) + "&app_id=" + Param.getAppId() + "&csrfToken=" + Param.getCsrfToken() + "&Tag_orderNo=" + Param.getOrderNo();
        GetActRequestParam getActRequestParam = new GetActRequestParam();
        getActRequestParam.version = Param.getVersion(z10);
        getActRequestParam.compareMode = str3;
        getActRequestParam.liveSelectData = selectData;
        String json = new WeJson().toJson(getActRequestParam);
        WLogger.d("GetFaceActiveCompareType", "paramStr=" + json);
        String str5 = null;
        try {
            str5 = WbCloudNetSecurityManger.base64Encry(z10, json, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("GetFaceActiveCompareType", "encry request failed:" + e2.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z10));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry GetActType failed!" + e2.toString(), properties);
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z10) {
            enRequestParam.encryptKey = str2;
            enRequestParam.encryptBody = str5;
        } else {
            enRequestParam.encryptedAESKey = str2;
            enRequestParam.requestBody = str5;
        }
        weOkHttp.post(str4).bodyJson(enRequestParam).execute(baseCallback);
    }
}
