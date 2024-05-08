package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.LoginRequestParam;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LoginRequest {
    private static final String TAG = "com.tencent.cloud.huiyansdkface.facelight.net.LoginRequest";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class LoginResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, long j10, String str2, String str3, boolean z10, WeReq.Callback<LoginResponse> callback) {
        WLogger.d(TAG, "connectTimeout:" + j10 + ",isGm:" + z10);
        LoginRequestParam loginRequestParam = new LoginRequestParam();
        loginRequestParam.version = Param.getVersion(z10);
        String str4 = null;
        try {
            str4 = WbCloudNetSecurityManger.base64Encry(z10, new WeJson().toJson(loginRequestParam), str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w(TAG, "encry loginRequest failed!" + e2.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z10));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry loginRequest failed!" + e2.toString(), properties);
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z10) {
            enRequestParam.encryptKey = str3;
            enRequestParam.encryptBody = str4;
        } else {
            enRequestParam.encryptedAESKey = str3;
            enRequestParam.requestBody = str4;
        }
        weOkHttp.post(str + "&Tag_orderNo=" + Param.getOrderNo()).connectTimeoutInMillis(j10).bodyJson(enRequestParam).execute(callback);
    }
}
