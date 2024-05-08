package com.tencent.cloud.huiyansdkface.facelight.net.model.request;

import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CusRequestBody {
    public String activeType;
    public FlashReq flashReqDTO;
    public String luxJudge;
    public String userVideoStr;
    public String videoMd5;
    public String wbVideoStr;
    public String appId = Param.getAppId();
    public String orderNo = Param.getOrderNo();
    public String deviceInfo = Param.getDeviceInfo();
    public String modeType = Param.getGradeCompareType();
    public String faceId = Param.getFaceId();
    public String turingPackage = Param.getTuringPackage();
    public String turingVideoData = Param.getTuringVideoData();
    public String showAuth = "0";
    public String verifyType = Param.getVerifyType();
    public String rotate = "0";
    public String transSwitch = "0";
}
