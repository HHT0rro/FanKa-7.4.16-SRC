package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LoginResult implements Serializable {
    public String activeType;
    public String authProtocolVersion;
    public String authTickSwitch;
    public String authType;
    public String bizSeqNo;
    public String code;
    public String colorData;
    public String csrfToken;
    public String gradeCompareType;
    public String liveSelectData;
    public String msg;
    public String needAuth;
    public String needLogReport;
    public String optimalGradeType;
    public String popupWarnSwitch;
    public String protocolCorpName;
    public String testMsg;
    public String transactionTime;
    public String uploadWillVideo;

    public String toString() {
        return "LoginResult{code='" + this.code + "', msg='" + this.msg + "', activeType='" + this.activeType + "', needLogReport='" + this.needLogReport + "', needAuth='" + this.needAuth + "', protocolCorpName='" + this.protocolCorpName + "', authProtocolVersion='" + this.authProtocolVersion + "', optimalGradeType='" + this.optimalGradeType + "', popupWarnSwitch='" + this.popupWarnSwitch + "', authType='" + this.authType + "', authTickSwitch='" + this.authTickSwitch + "', uploadWillVideo='" + this.uploadWillVideo + "'}";
    }
}
