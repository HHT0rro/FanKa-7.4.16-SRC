package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.TuringRequestParam;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SendTuringPackage {
    private static final String TAG = "com.tencent.cloud.huiyansdkface.facelight.net.SendTuringPackage";

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
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, String str2, boolean z10, WeReq.Callback<GetFaceCompareTypeResponse> callback) {
        String str3 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getTuringPath(z10) + "?app_id=" + Param.getAppId() + "&version=" + Param.getVersion(z10) + "&order_no=" + Param.getOrderNo();
        TuringRequestParam turingRequestParam = new TuringRequestParam();
        turingRequestParam.turingPackage = Param.getTuringPackage();
        turingRequestParam.deviceModel = Param.getDeviceModel();
        String str4 = null;
        try {
            str4 = WbCloudNetSecurityManger.base64Encry(z10, new WeJson().toJson(turingRequestParam), str);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w(TAG, "encry request failed:" + e2.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z10));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry turing failed!" + e2.toString(), properties);
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z10) {
            enRequestParam.encryptKey = str2;
            enRequestParam.encryptBody = str4;
        } else {
            enRequestParam.encryptedAESKey = str2;
            enRequestParam.requestBody = str4;
        }
        weOkHttp.post(str3).bodyJson(enRequestParam).execute(callback);
    }
}
