package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.QueryRequestParam;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class QueryFaceResultRequest {
    private static final String TAG = "com.tencent.cloud.huiyansdkface.facelight.net.QueryFaceResultRequest";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class QueryResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, int i10, String str, String str2, String str3, boolean z10, WeReq.Callback<QueryResponse> callback) {
        String str4 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getQueryPath(z10) + "?app_id=" + Param.getAppId() + "&version=" + Param.getVersion(z10) + "&order_no=" + Param.getOrderNo() + "&retry=" + i10;
        QueryRequestParam queryRequestParam = new QueryRequestParam();
        queryRequestParam.faceOrLive = str;
        String json = new WeJson().toJson(queryRequestParam);
        String str5 = null;
        try {
            str5 = WbCloudNetSecurityManger.base64Encry(z10, json, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w(TAG, "encry queryRequest failed!" + e2.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z10));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry queryRequest failed!" + e2.toString(), properties);
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z10) {
            enRequestParam.encryptKey = str3;
            enRequestParam.encryptBody = str5;
        } else {
            enRequestParam.encryptedAESKey = str3;
            enRequestParam.requestBody = str5;
        }
        weOkHttp.post(str4).callTimeoutInMillis(d.z().e().ag()).bodyJson(enRequestParam).execute(callback);
    }
}
