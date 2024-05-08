package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbCusMetaData implements Serializable {
    public String activeType;
    public String appId;
    public String authProtocolVersion;
    public String authTickSwitch;
    public String authType;
    public String bizSeqNo;
    public String cdnFile;
    public String code;
    public String colorData;
    public String csrfToken;
    public String faceId;
    public String gradeCompareType;
    public String liveSelectData;
    public String msg;
    public String needAuth;
    public String needLogReport;
    public String optimalGradeType;
    public String orderNo;
    public String popupWarnSwitch;
    public String protocolCorpName;
    public String testMsg;
    public String transactionTime;
    public String verifyType;

    public String toString() {
        return "WbCusMetaData{code='" + this.code + "', msg='" + this.msg + "', appId='" + this.appId + "', orderNo='" + this.orderNo + "', faceId='" + this.faceId + "', bizSeqNo='" + this.bizSeqNo + "', csrfToken='" + this.csrfToken + "', transactionTime='" + this.transactionTime + "', activeType='" + this.activeType + "', needLogReport='" + this.needLogReport + "', needAuth='" + this.needAuth + "', authType='" + this.authType + "', authTickSwitch='" + this.authTickSwitch + "', protocolCorpName='" + this.protocolCorpName + "', authProtocolVersion='" + this.authProtocolVersion + "', testMsg='" + this.testMsg + "', gradeCompareType='" + this.gradeCompareType + "', optimalGradeType='" + this.optimalGradeType + "', colorData='" + this.colorData + "', liveSelectData='" + this.liveSelectData + "', popupWarnSwitch='" + this.popupWarnSwitch + "', cdnFile='" + this.cdnFile + "', verifyType='" + this.verifyType + "'}";
    }
}
