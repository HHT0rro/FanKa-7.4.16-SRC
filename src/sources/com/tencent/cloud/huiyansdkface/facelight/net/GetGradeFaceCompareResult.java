package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.CompareRequestParam;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.wehttp2.BodyReq;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GetGradeFaceCompareResult {
    private static final String TAG = "com.tencent.cloud.huiyansdkface.facelight.net.GetGradeFaceCompareResult";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
        public String csrfToken = Param.getCsrfToken();
        public String orderNo = Param.getOrderNo();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class GetResultReflectModeResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, String str2, boolean z10, byte[] bArr, byte[] bArr2, String str3, String str4, String str5, FlashReq flashReq, int i10, WeReq.Callback<GetResultReflectModeResponse> callback) {
        int i11;
        String str6;
        String str7;
        String str8;
        String str9 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getComparePath(z10) + "?Tag_orderNo=" + Param.getOrderNo() + "&app_id=" + Param.getAppId() + "&version=" + Param.getVersion(z10) + "&retry=" + i10;
        Param.appendRequestRetryInfo(i10);
        BodyReq formData = weOkHttp.post(str9).callTimeoutInMillis(d.z().e().af()).formData();
        CompareRequestParam compareRequestParam = new CompareRequestParam();
        compareRequestParam.activeType = str4;
        compareRequestParam.luxJudge = str5;
        compareRequestParam.flashReqDTO = flashReq;
        compareRequestParam.videoMd5 = str3;
        if (bArr == null || bArr.length == 0) {
            WLogger.d(TAG, "null ytVideo");
            i11 = 0;
        } else {
            WLogger.d(TAG, "has ytVideo");
            i11 = bArr.length;
            formData.addPart("videoFile", "videoFile", bArr, (MediaType) null);
        }
        if (bArr2 == null || bArr2.length == 0) {
            str6 = TAG;
            str7 = "null wbVideo";
        } else {
            compareRequestParam.rotate = Param.getRolateInfo();
            i11 += bArr2.length;
            formData.addPart("wbVideo", "wbVideo", bArr2, (MediaType) null);
            str6 = TAG;
            str7 = "has wbVideo:" + compareRequestParam.rotate;
        }
        WLogger.d(str6, str7);
        WLogger.d(TAG, "param=" + compareRequestParam.toString());
        try {
            str8 = WbCloudNetSecurityManger.base64Encry(z10, new WeJson().toJson(compareRequestParam), str);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w(TAG, "encry request failed:" + e2.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z10));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry GetFaceResult failed!" + e2.toString(), properties);
            str8 = null;
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z10) {
            enRequestParam.encryptKey = str2;
            enRequestParam.encryptBody = str8;
        } else {
            enRequestParam.encryptedAESKey = str2;
            enRequestParam.requestBody = str8;
        }
        int length = i11 + enRequestParam.toString().length();
        KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_compare_size", "" + length, null);
        formData.body(enRequestParam).execute(callback);
    }
}
