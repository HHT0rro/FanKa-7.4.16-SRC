package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RiskInfo implements Serializable {
    public String deviceInfoLevel;
    public String deviceInfoTag;
    public String riskInfoLevel;
    public String riskInfoTag;

    public String toString() {
        return "RiskInfo{deviceInfoLevel='" + this.deviceInfoLevel + "', deviceInfoTag='" + this.deviceInfoTag + "', riskInfoLevel='" + this.riskInfoLevel + "', riskInfoTag='" + this.riskInfoTag + "'}";
    }
}
