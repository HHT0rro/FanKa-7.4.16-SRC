package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AuthUploadRequest {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AuthUploadResponse implements Serializable {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class RequestParam {
        public String userId = Param.getUserId();
        public String orderNo = Param.getOrderNo();
        public String h5faceId = Param.getFaceId();
    }

    public static void requestExec(WeOkHttp weOkHttp, WeReq.Callback<AuthUploadResponse> callback) {
        RequestParam requestParam = new RequestParam();
        weOkHttp.post(WeOkHttpProvider.getPathEnv() + "/auth/upload?version=1.0.0&Tag_orderNo=" + requestParam.orderNo + "&app_id=" + Param.getAppId()).bodyJson(requestParam).execute(callback);
    }
}
