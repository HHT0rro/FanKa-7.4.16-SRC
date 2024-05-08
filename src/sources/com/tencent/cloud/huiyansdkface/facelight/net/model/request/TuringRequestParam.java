package com.tencent.cloud.huiyansdkface.facelight.net.model.request;

import com.tencent.cloud.huiyansdkface.facelight.c.d.d;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TuringRequestParam {
    public String deviceModel;
    public String turingPackage;
    public String webankAppId = Param.getAppId();
    public String orderNo = Param.getOrderNo();
    public String userId = Param.getUserId();
    public String h5faceId = Param.getFaceId();
    public String compareType = Param.getCompareMode();
    public String turingSdkVersion = d.b();
    public String osType = "1";
}
